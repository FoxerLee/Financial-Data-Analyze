# -*- coding:utf-8 -*-
import tushare
import re
print(tushare.__version__)
import csv
import datetime
import sys
import mysql.connector
reload(sys)                      # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'

t = 'month'


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

codes = getCode()

for code in codes:
    try:
        if code[0] == '0' or code[0] == '6':
            df = tushare.get_hist_data(code, ktype='W')
            df.to_csv('data_'+t+'/' + code + '.csv')
            print code + " " + str(code)
            print datetime.datetime.now()

        # if code[0][0] == '6':
        #     df = tushare.get_hist_data(code[0], ktype='D')
        #     df.to_csv('data_'+bourse+'_day/' + name + '_' + code[0] + '.csv')
        else:
            continue

    except Exception, e:
        print e
        continue
