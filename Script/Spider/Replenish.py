# -*- coding: utf-8 -*-
import sys
import mysql.connector
import datetime
import time
from lxml import html
import requests
import csv
import re
import random

reload(sys)
sys.setdefaultencoding('utf-8')


def delete_format(s):
    p = re.compile('\r\n')
    s = re.sub(p, ' ', s)
    s = s.lstrip()
    s = s.rstrip()

    return s

config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
              'charset': 'utf8'}
def getCode():

    conn = mysql.connector.connect(**config)
    cursor = conn.cursor()

    sql = "SELECT code FROM connect;"
    cursor.execute(sql)
    ids = []
    for id in cursor:
        ids.append(id[0])

    # cursor.execute("SELECT code FROM research GROUP BY code;")
    # o_ids = []
    # for code in cursor:
    #     code = str(code[0])
    #     o_ids.append(code)
    #
    # codes = list(set(ids).difference(set(o_ids)))
    cursor.execute("SELECT code, count(code) FROM research GROUP BY code;")
    o_ids = []
    for code in cursor:
        if code[1] > 7:
            o_ids.append(str(code[0]))

    codes = list(set(ids).difference(set(o_ids)))
    cursor.close()
    conn.close()
    return codes


def run():
    codes = getCode()

    re = []
    for page in range(7):
        try:
            res = requests.get('http://vip.stock.finance.sina.com.cn/q/go.php/vReport_List/kind/lastest/index.phtml?p='+str(page))
        except Exception, e:
            print e
            print "Can`t get page " + str(page) + "!"

        res.encoding = 'gb2312'
        tree = html.fromstring(res.text)
        # pages = tree.xpath('')

        trs = tree.xpath('/html/body/div/div[3]/table/tr')
        try:
            title = trs[2].xpath('./td[2]/a/text()')[0].encode('utf8')
        except Exception, e:
            print e
            print 'no researches found '
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
                re.append((title, url, date, inst, researcher))
            except Exception, e:
                print e
                print 'get data error '
                continue

        print "Get page " + str(page) + " Succeed!"
    print len(re)

    sql = "INSERT INTO research VALUES (NULL, %s, %s, %s, %s, %s, %s);"
    for code in codes:
        news_index = random.sample(range(280), 9)

        news = []
        for i in range(9):

            news.append((code, re[news_index[i]][0], re[news_index[i]][1], re[news_index[i]][2], re[news_index[i]][3], re[news_index[i]][4]))

        conn = mysql.connector.connect(**config)
        cursor = conn.cursor()

        cursor.executemany(sql, news)
        cursor.execute("Commit;")
        print "replenish " + code + " succeed!"
        cursor.close()
        conn.close()




if __name__ == '__main__':
    run()
