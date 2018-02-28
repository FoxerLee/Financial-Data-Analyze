# -*- coding: utf-8 -*-
from locust import HttpLocust, TaskSet, task
import sys
from selenium import webdriver
import time

reload(sys)
sys.setdefaultencoding('utf-8')


class WebsiteTasks(TaskSet):

    cookiejar = {}

    def on_start(self):
        driver = webdriver.PhantomJS(executable_path='/Users/phantomjs')

        driver.get("http://localhost:8080/index")
        u = driver.find_element_by_id("name")
        u.clear()
        u.send_keys("cc")

        p = driver.find_element_by_id("_password")
        p.clear()
        p.send_keys("1234")

        driver.find_element_by_xpath("//*[@id=\"subbtn\"]").click()

        for cookie in driver.get_cookies():
            self.cookiejar[cookie['name']] = cookie['value']

    @task
    def test_task1(self):
        self.client.request('get', "/ranking.html", cookies=self.cookiejar)

    @task
    def test_task2(self):
        self.client.request('get', "/detail.html?code=000001", cookies=self.cookiejar)
    @task
    def test_task3(self):
        self.client.request('get', "/fundamentals.html", cookies=self.cookiejar)

class WebsiteUser(HttpLocust):
    task_set = WebsiteTasks
    host = "http://localhost:8080"
    min_wait = 1000
    max_wait = 5000



