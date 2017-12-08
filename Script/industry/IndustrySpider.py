# -*- coding: utf-8 -*-
from selenium import webdriver
import re
import sys
import mysql.connector
import datetime
import time

reload(sys)
sys.setdefaultencoding('utf-8')

def run():
    config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
              'charset': 'utf8'}
    conn = mysql.connector.connect(**config)
    cursor = conn.cursor()
    start_time = datetime.datetime.now()
    try:
        driver = webdriver.PhantomJS(executable_path='/Users/phantomjs')
        driver.get('http://finance.sina.com.cn/stock/sl/#sinaindustry_1')

        # 模拟点击动作，转换到手动刷新，方便抓
        handle_e = driver.find_element_by_xpath('//*[@id="manualBtn"]')

        handle_e.click()

        # trs = driver.find_element_by_xpath('//*[@id="datatbl"]/tbody')

        # trs_resource = trs.get_attribute('innerHTML')
        # print type(trs)
        # print trs_resource
        # names = re.findall(nameReg, trs_resource)
        # print names[0]
        # for tr in trs:
        #     name = tr.xpath('/td[1]/a/text()').extract()
        #     print name
        # sql = "INSERT INTO industry VALUES(NULL,%s,%s,%s,%s,%s)"
        # sql = "UPDATE industry SET "

        names_xpath = driver.find_elements_by_xpath('//*[@id="datatbl"]/tbody/tr/td[1]/a')
        names = [name.text for name in names_xpath]

        prices_xpath = driver.find_elements_by_xpath('//*[@id="datatbl"]/tbody/tr/td[4]')
        prices = [price.text for price in prices_xpath]

        prices_r_xpath = driver.find_elements_by_xpath('//*[@id="datatbl"]/tbody/tr/td[5]')
        prices_r = [price_r.text for price_r in prices_r_xpath]

        turnover_xpath = driver.find_elements_by_xpath('//*[@id="datatbl"]/tbody/tr/td[6]')
        turnovers = [turnover.text for turnover in turnover_xpath]

        turnover_p_xpath = driver.find_elements_by_xpath('//*[@id="datatbl"]/tbody/tr/td[7]')
        turnovers_p = [turnover_p.text for turnover_p in turnover_p_xpath]

        res = []

        for i in range(len(names)):
            # res.append((names[i], prices[i], prices_r[i], turnovers[i], turnovers_p[i]))
            sql = "UPDATE industry SET price = " + prices[i] + ",price_range = \'" + prices_r[i] + "\',turnover = " + turnovers[i] + ",turnover_p = " + turnovers_p[i] + "WHERE name = \'" + names[i] + "\';"
            cursor.execute(sql)
        # cursor.executemany(sql, res)
        cursor.execute('Commit;')
        print 'Succeed!'
        print datetime.datetime.now() - start_time
        cursor.close()
        conn.close()
        driver.close()
    except:
        cursor.close()
        conn.close()
        driver.close()
        print 'Error!'
        print datetime.datetime.now() - start_time


if __name__ == '__main__':
    while True:
        run()
        time.sleep(60)
