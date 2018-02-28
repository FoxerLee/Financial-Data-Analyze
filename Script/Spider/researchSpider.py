# -*- coding: utf-8 -*-
import sys
import mysql.connector
import datetime
import time
from lxml import html
import requests
import csv
import re

reload(sys)
sys.setdefaultencoding('utf-8')

def getCode():
    config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
              'charset': 'utf8'}
    conn = mysql.connector.connect(**config)
    cursor = conn.cursor()

    sql = "SELECT code FROM connect;"
    cursor.execute(sql)
    ids = []
    for id in cursor:
        ids.append(id[0])

    cursor.close()
    conn.close()
    return ids

def delete_format(s):
    p = re.compile('\r\n')
    s = re.sub(p, ' ', s)
    s = s.lstrip()
    s = s.rstrip()

    return s

def run():

    ids = getCode()
    re = []
    for id in ids:
        time.sleep(2)
        try:
            if id[0] == '0':
                res = requests.get('http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?symbol=sz'+id+'&t1=all')
            else:
                res = requests.get('http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/search/index.phtml?symbol=sh'+id+'&t1=all')
        except Exception, e:
            print e
            print 'requests error ' + id
            continue
        res.encoding = 'gb2312'

        tree = html.fromstring(res.text)
        # pages = tree.xpath('')

        trs = tree.xpath('/html/body/div/div[3]/table/tr')
        try:
            title = trs[2].xpath('./td[2]/a/text()')[0].encode('utf8')
        except Exception, e:
            print e
            print 'no researches found ' + id
            continue
        # f = open('test.txt', 'w')

        for i in range(2, len(trs)):
            try:
                title = trs[i].xpath('./td[2]/a/text()')[0].encode('utf8')
                title = str(delete_format(title))

                url = str(trs[i].xpath('./td[2]/a/@href')[0])


                date = str(trs[i].xpath('./td[4]/text()')[0])
                inst = str(trs[i].xpath('./td[5]/a/div/span/text()')[0].encode('utf8'))
                researcher = str(trs[i].xpath('./td[6]/div/span/text()')[0])
                # print title
                # print url
                # print date
                # print inst
                # print researcher
                re.append((id, title, url, date, inst, researcher))
            except Exception, e:
                print e
                print 'get data error ' + id
                continue

        sql = "INSERT INTO research VALUES (NULL, %s, %s, %s, %s, %s, %s);"

        try:
            config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
          'charset': 'utf8'}
            conn = mysql.connector.connect(**config)
            cursor = conn.cursor()

            cursor.executemany(sql, re)
            cursor.execute('Commit;')
            cursor.close()
            conn.close()
            re = []
        except Exception, e:
            print e
            print 'write data error ' + id
            cursor.close()
            conn.close()
            re = []

        print 'succeed ' + id



        # f.write(title + '\n')



    # f.close()





if __name__ == '__main__':

    run()