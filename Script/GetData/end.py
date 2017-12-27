# -*- coding:utf-8 -*-
import pyodbc
import datetime
import threading
import time
from multiprocessing import Process

import tushare as ts
import sys
import csv
import mysql.connector

reload(sys)  # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'

# conn1 = None
# conn2 = None
# conn3 = None
# cursor1 = None
# cursor2 = None
# cursor3 = None


def Timer():
    flag = 0
    while True:
        if flag == 0:
            Process(target=DealData, args=(flag,)).start()
            flag = 1
        # elif flag == 1:
        #     Process(target=DealData, args=(flag,)).start()
        #     flag = 2
        else:
            Process(target=DealData, args=(flag,)).start()
            flag = 0
        time.sleep(60)


def DealData(flag):

    # global conn1, cursor1, conn2, cursor2, conn3, cursor3
    print flag
    start_time = datetime.datetime.now()



    p1 = Process(target=getData, args=(1,flag,1,10, False))
    p2 = Process(target=getData, args=(2,flag,10,20, False))
    p3 = Process(target=getData, args=(3,flag,20,30, True))
    p4 = Process(target=getData, args=(4, flag,30,44, False))

    p1.start()
    p2.start()
    p3.start()
    p4.start()

    p1.join()
    p2.join()
    p3.join()
    p4.join()

    print (datetime.datetime.now() - start_time).seconds

def getData(select,flag, start,end,st):

    try:
        # print 'start'
        data = ts.get_today_all(flag,start,end,st)

    except Exception,e:
        print e

    inTime = GetTime()
    params=[]
    try:
        # config={'host':'10.60.42.201','user':'root', 'password':'123456', 'port':13142 , 'database':'javaEE', 'charset':'utf8'}
        # conn = mysql.connector.connect(**config)
        # cursor=conn.cursor()
        for index, row in data.iterrows():
            if row['code'][0] == '6' or row['code'][0] == '0':
                

                # sql = "SELECT volume_value FROM data_days WHERE code = " + str(row['code'])
                # cursor.execute(sql)
                # add_volume = 0.0
                # try:
                #     for volume_value in cursor:
                #         add_volume = row['volume'] - volume_value
                # except:
                #     add_volume = row['volume']
                # add_volume = row['volume']
                params.append((str(row['code']), inTime, row['open'], row['trade'],
                           row['high'], row['low'], row['volume'], row['changepercent'], row['turnoverratio'],
                           row['amount'], row['per'], row['pb'], row['mktcap'], row['nmc'], row['settlement']))
                # conn.close()
                # cursor.close()
    except Exception, e:
        print e
        print "data null"
        conn.close()
        cursor.close()
    # print params
    store(select,params)




def store(select,params):
    # global conn1, cursor1, conn2, cursor2, conn3, cursor3
    try:
        config={'host':'10.60.42.201','user':'root', 'password':'123456', 'port':13142 , 'database':'javaEE', 'charset':'utf8'}
        conn = mysql.connector.connect(**config)
        cursor=conn.cursor()
        sql = "INSERT INTO data_real_time VALUES(NULL,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
        cursor.executemany(sql, params)
        # cursor.commit()
        cursor.execute("Commit;")
        conn.close()
        cursor.close()
        print "success"
    except Exception, e:
        print e
        print "write data error!"
        conn.close()
        cursor.close()

def GetTime():

    time = datetime.datetime.now()
    s_time = str(time)

    nPos = s_time.index('.')
    s_time = s_time[:nPos]
    return s_time

# def close():
#     global conn1, cursor1, conn2, cursor2, conn3, cursor3
#     try:
#         conn1.close()
#         cursor1.close()
#         conn2.close()
#         cursor2.close()
#         conn3.close()
#         cursor3.close()
#     except Exception,e:
#         print e
#         pass

if __name__ == '__main__':


    try:
        Timer()
    except Exception,e:
        # close()
        print e

    # print GetTime()

