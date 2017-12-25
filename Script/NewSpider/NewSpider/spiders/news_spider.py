# -*- coding:utf-8 -*-
from scrapy import Request
from scrapy.spiders import Spider
from NewSpider.items import NewspiderItem
from NewSpider.randomHeaders import RandomHeaders
import time
import re
import mysql.connector
import sys

reload(sys)
sys.setdefaultencoding('utf-8')

# config = {'host':'10.60.42.201','user':'root', 'password':'123456', 'port':13142 , 'database':'javaEE', 'charset':'utf8'}
# conn = mysql.connector.connect(**config)
# cursor = conn.cursor()

class newSpider(Spider):
    config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
              'charset': 'utf8'}
    conn = mysql.connector.connect(**config)
    cursor = conn.cursor()
    name = 'news'

    # sql = 'delete from news'
    # cursor.execute(sql)
    # cursor.execute("Commit;")
    # 从mysql中获取待爬股票id
    # sql = 'select * from self_stocking'
    # cursor.execute(sql)
    #
    # origin_codes = []
    # for user_id, code in cursor:
    #     origin_codes.append(code)
    # # 去除重复
    # codes = list(set(origin_codes))
    # f = open("connect_sh.txt")
    # g = open("connect_sz.txt")
    # p = re.compile('\n')
    # codes = []
    # for i in f:
    #     i = re.sub(p, '', i)
    #     codes.append(i)
    # for i in g:
    #     g = re.sub(p, '', i)
    #     codes.append(i)

    cursor.execute("SELECT code FROM javaEE.connect;")
    codes = []
    for code in cursor:
        code = str(code[0])
        codes.append(code)


    cursor.execute("SELECT code FROM news GROUP BY code;")

    codes_al = []
    for code in cursor:
        code = str(code[0])
        codes_al.append(code)

    codes = list(set(codes).difference(set(codes_al)))

    start_urls = []
    for code in codes:
        if code[0] == '0':
            start_url = 'http://finance.sina.com.cn/realstock/company/sz' + code + '/nc.shtml'
        if code[0] == '6':
            start_url = 'http://finance.sina.com.cn/realstock/company/sh' + code + '/nc.shtml'
        start_urls.append(start_url)
    # start_urls = ['http://finance.sina.com.cn/realstock/company/sz000998/nc.shtml']

    # headers = {
    #     'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36',
    # }
    # headers = RandomHeaders.LoadHeader()
    cursor.close()
    conn.close()


    def start_requests(self):
        # url = 'https://book.douban.com/tag/小说'
        for start_url in self.start_urls:
            yield Request(start_url, headers=RandomHeaders.LoadHeader())

    def parse(self, response):
        time.sleep(2)
        config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
                  'charset': 'utf8'}
        conn = mysql.connector.connect(**config)
        cursor = conn.cursor()
        item = NewspiderItem()
        s = str(response)
        index = s.rindex('/')
        code = s[index - 6:index]

        news = response.xpath('/html/body/div[8]/div[3]/div[7]/div/div[1]/div[2]/ul[1]/li')

        params = []
        for new in news:
            # print new
            item['name'] = new.xpath('.//a/text()').extract()
            item['click'] = new.xpath('.//span[1]/text()').extract()
            item['url'] = new.xpath('.//a/@href').extract()
            # print type(item['name'][0])
            # a = str(item['name'][0])
            # print a
            # print type(a)
            params.append((code, str(item['name'][0]), str(item['url'][0]), str(item['click'][0])))
            yield item

        news = response.xpath('/html/body/div[8]/div[3]/div[7]/div/div[1]/div[2]/ul[2]/li')
        for new in news:
            # print new
            item['name'] = new.xpath('.//a/text()').extract()
            item['click'] = new.xpath('.//span[1]/text()').extract()
            item['url'] = new.xpath('.//a/@href').extract()
            params.append((code, str(item['name'][0]), str(item['url'][0]), str(item['click'][0])))
            yield item

        sql = "INSERT INTO news VALUES(NULL,%s,%s,%s,%s)"
        cursor.executemany(sql, params)
        cursor.execute("Commit;")
        cursor.close()
        conn.close()



# cursor.execute("Commit;")
# conn.close()
# cursor.close()
