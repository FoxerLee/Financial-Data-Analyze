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

conn1 = None
conn2 = None
conn3 = None
cursor1 = None
cursor2 = None
cursor3 = None


def Timer():
    flag = 0
    while True:
        if flag == 0:
            Process(target=DealData, args=(flag,)).start()
            flag = 1
        else:
            Process(target=DealData, args=(flag,)).start()
            flag = 0
        time.sleep(60)


def DealData(flag):

    global conn1, cursor1, conn2, cursor2, conn3, cursor3

    start_time = datetime.datetime.now()

    # try:
    #     cursor1 = conn1.cursor()
    #     cursor2 = conn2.cursor()
    #     cursor3 = conn3.cursor()
    # except Exception,e:
    #     connect(1)
    #     connect(2)
    #     connect(3)
    #     print e

    p1 = Process(target=getData, args=(1,flag,1,10, False))
    p2 = Process(target=getData, args=(2,flag,10,20, False))
    p3 = Process(target=getData, args=(3,flag,20,30, True))
    p4 = Process(target=getData, args=(4, flag,30, 44, False))
    # p5 = Process(target=getData, args=(5, flag, 34, 60, False))
    # p4 = Process(target=getData, args=(3, flag, 30, 60, True))
    # p4 = Process(target=store, args=(params[2800:len(params)],))
    p1.start()
    p2.start()
    p3.start()
    p4.start()
    # p5.start()

    # p4.start()
    p1.join()
    p2.join()
    p3.join()
    p4.join()
    # p5.join()
    # store(params)
    # if (datetime.datetime.now() - start_time).seconds <= 60:
    #     try:
    #         cursor1.execute("COMMIT;")
    #         cursor2.execute("COMMIT;")
    #         cursor3.execute("COMMIT;")
    #     except Exception,e:
    #         print e
    # else:
    #     try:
    #         cursor1.execute("ROLLBACK;")
    #         cursor2.execute("ROLLBACK;")
    #         cursor3.execute("ROLLBACK;")
    #     except Exception,e:
    #         print e
    #     print "舍弃......"

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
        for index, row in data.iterrows():
            if row['code'][0] == '6' or row['code'][0] == '0':
                params.append((str(row['code']), inTime, row['open'], row['trade'],
                           row['high'], row['low'], row['volume']))
    except:
        print "data null"
    # print params
    store(select,params)




def store(select,params):
    global conn1, cursor1, conn2, cursor2, conn3, cursor3
    # sql = "INSERT INTO DATA_yearS VALUES(SEQ_DATA_DAYS.NEXTVAL,?,TO_DATE(?),?,?,?,?,?);"
    # conn = pyodbc.connect(
    #     'DRIVER=/Users/luozhongjin/TimesTen/tt1122/lib/libttclient.so;TTC_SERVER=10.60.42.201;TCP_Port=53393;TTC_SERVER_DSN=my_1122;UID=sjh;PWD=sjh')
    # cursor = conn.cursor()
    config={'host':'10.60.42.201','user':'root', 'password':'123456', 'port':13142 , 'database':'javaEE', 'charset':'utf8'}
    conn = mysql.connector.connect(**config)
    cursor=conn.cursor()
    sql = "INSERT INTO data_real_time VALUES(NULL,%s,%s,%s,%s,%s,%s,%s)"
    cursor.executemany(sql, params)
    # cursor.commit()
    cursor.execute("Commit;")
    print "success"

def GetTime():

    time = datetime.datetime.now()
    s_time = str(time)

    nPos = s_time.index('.')
    s_time = s_time[:nPos]
    return s_time


# def connect(select):
#     global conn1, cursor1, conn2, cursor2, conn3, cursor3
#     if select == 1:
#         conn1 = pyodbc.connect(
#             'DRIVER=/Users/luozhongjin/TimesTen/tt1122/lib/libttclient.so;TTC_SERVER=10.60.42.201;TCP_Port=53393;TTC_SERVER_DSN=my_1122;UID=sjh;PWD=sjh')
#         cursor1 = conn1.cursor()
#     elif select == 2:
#         conn2 = pyodbc.connect(
#             'DRIVER=/Users/luozhongjin/TimesTen/tt1122/lib/libttclient.so;TTC_SERVER=10.60.42.201;TCP_Port=53393;TTC_SERVER_DSN=my_1122;UID=sjh;PWD=sjh')
#         cursor2 = conn2.cursor()
#     else:
#         conn3 = pyodbc.connect(
#             'DRIVER=/Users/luozhongjin/TimesTen/tt1122/lib/libttclient.so;TTC_SERVER=10.60.42.201;TCP_Port=53393;TTC_SERVER_DSN=my_1122;UID=sjh;PWD=sjh')
#         cursor3 = conn3.cursor()
def close():
    global conn1, cursor1, conn2, cursor2, conn3, cursor3
    try:
        conn1.close()
        cursor1.close()
        conn2.close()
        cursor2.close()
        conn3.close()
        cursor3.close()
    except Exception,e:
        print e
        pass

if __name__ == '__main__':

    # connect(1)
    # connect(2)
    # connect(3)

    try:
        Timer()
    except Exception,e:
        close()
        print e

    # print GetTime()

