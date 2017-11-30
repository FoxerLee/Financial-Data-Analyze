# -*- coding: utf-8 -*-

import json
import urllib2
from multiprocessing import Process, Queue, Lock
from threading import Thread
import time

import pyodbc

import re

import datetime
import pandas as pd
import requests
import sys

from tushare.stock import cons as ct
reload(sys)  # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'

pagesQ = Queue()

queue = Queue()


class Producer2(Process):
    def __init__(self, name,l1):
        Process.__init__(self)
        self.name = name
        self.l1 = l1


    def run(self):
        while 1:
            # res = requests.get("http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?num=80&sort=code&asc=0&node=hs_a&symbol=&_s_r_a=page&page=1")
            # queue.append(res.text)

            print "start"
            for i in range(1,44):
                pagesQ.put(i)

            time.sleep(60)



class Producer(Process):
    def __init__(self, name,l1,l2):
        Process.__init__(self)
        self.name = name
        self.l1 = l1
        self.l2 = l2

    def run(self):
        while 1:
            i = 0
            self.l1.acquire()
            try:
                if not pagesQ.empty():
                    i = pagesQ.get()
                else:
                    continue
            except:
                continue
            finally:
                self.l1.release()
            try:
                myurl = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?num=80&sort=code&asc=0&node=hs_a&symbol=&_s_r_a=page&page="+str(i)
                text = 'null'
                if (i % 2) == 0:
                    proxy_info = {'host': '10.60.42.201',
                                  'port': 13143
                                  }

                    # proxy_info = {'host': '120.78.142.72',
                    #               'port': 8888
                    #               }

                    # We create a handler for the proxy
                    proxy_support = urllib2.ProxyHandler({"http": "http://%(host)s:%(port)d" % proxy_info})

                    # We create an opener which uses this handler:
                    opener = urllib2.build_opener(proxy_support)

                    # Then we install this opener as the default opener for urllib2:
                    # urllib2.install_opener(opener)
                    text = opener.open(myurl,timeout=5).read()
                elif (i % 3) == 0:
                    proxy_info = {'host': '10.60.42.201',
                                  'port': 13143
                                  }

                    # proxy_info = {'host': '120.78.142.72',
                    #               'port': 8888
                    #               }

                    # We create a handler for the proxy
                    proxy_support = urllib2.ProxyHandler({"http": "http://%(host)s:%(port)d" % proxy_info})

                    # We create an opener which uses this handler:
                    opener = urllib2.build_opener(proxy_support)

                    # Then we install this opener as the default opener for urllib2:
                    # urllib2.install_opener(opener)
                    text = opener.open(myurl,timeout=5).read()
                else:
                    text = urllib2.urlopen(myurl,timeout=5).read()

                if text == 'null':
                    return None
                reg = re.compile(r'\,(.*?)\:')
                text = reg.sub(r',"\1":', text.decode('gbk') if ct.PY3 else text)
                text = text.replace('"{symbol', '{"symbol')
                text = text.replace('{symbol', '{"symbol"')
                if ct.PY3:
                    jstr = json.dumps(text)
                else:
                    jstr = json.dumps(text, encoding='GBK')
                js = json.loads(jstr)
                df = pd.DataFrame(pd.read_json(js, dtype={'code': object}),
                                  columns=ct.DAY_TRADING_COLUMNS)

                self.l2.acquire()
                queue.put(df)
                self.l2.release()

                # print i,

                time.sleep(1)

            except Exception,e:
                print e # timed out
                continue


class Consumer(Process):
    def __init__(self, name,l3):
        Process.__init__(self)
        self.name = name
        self.l3 = l3

    def run(self):
        try:
            conn = pyodbc.connect(
                'DRIVER=/Users/luozhongjin/TimesTen/tt1122/lib/libttclient.so;TTC_SERVER=10.60.42.201;TCP_Port=53393;TTC_SERVER_DSN=my_1122;UID=sjh;PWD=sjh')
            cursor = conn.cursor()

            while 1:
                try:
                    self.l3.acquire()
                    if not queue.empty():
                        data = queue.get()
                        self.l3.release()
                    else:
                        self.l3.release()
                        continue
                    params = []
                    inTime = GetTime()
                    sql = "{CALL DATA_REAL_TIME_UPDATE(SEQ_DATA_DAYS.NEXTVAL,?,?,?,?,?,?,?)}"
                    for index, row in data.iterrows():
                        params.append((str(row['code']), inTime, row['open'], row['settlement'],
                                       row['high'], row['settlement'], row['volume']))
                    cursor.executemany(sql, params)
                    # print(df)
                    cursor.commit()

                    print "#",
                    # sys.stdtout.write("#")
                    # sys.stdout.flush()
                    print datetime.datetime.now()
                    time.sleep(0.2)
                except Exception,e:
                    print e
                    time.sleep(0.2)
        except Exception:
            pass


def GetTime():

    time = datetime.datetime.now()
    s_time = str(time)

    nPos = s_time.index('.')
    s_time = s_time[:nPos]
    return s_time

def test():

    l1 = Lock()
    l2 = Lock()
    l3 = Lock()

    p0 = Producer2("Producer-0",l1)


    p1 = Producer("Producer-1",l1,l2)
    p2 = Producer("Producer-2",l1,l2)
    p3 = Producer("Producer-3",l1,l2)


    p0.start()

    p1.start()
    p2.start()
    # p3.start()

    c = []
    for i in range(10):
        c.append(Consumer("consumer-"+str(i),l3))
    for x in c:
        x.start()



if __name__ == "__main__":
    test()


