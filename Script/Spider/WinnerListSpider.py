# -*- coding: utf-8 -*-
import sys
import mysql.connector
import datetime
import tushare as ts
import csv
import re

reload(sys)
sys.setdefaultencoding('utf-8')

def run():
    start = datetime.datetime.now()
    config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
              'charset': 'utf8'}
    conn = mysql.connector.connect(**config)
    cursor = conn.cursor()

    today = datetime.date.today()
    today = str(today)
    td = ts.top_list('2017-12-01')

    params = []
    for index, row in td.iterrows():
        params.append((row['code'], row['name'], row['pchange'], row['amount'], row['buy'], row['bratio'], row['sell'], row['sratio'], row['reason']))

    sql = "INSERT INTO winnerlist VALUES (NULL, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
    cursor.executemany(sql, params)
    cursor.execute("Commit;")

    cursor.close()
    conn.close()

    print datetime.datetime.now() - start

if __name__ == '__main__':
    run()

