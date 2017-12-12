# -*- coding:utf-8 -*-
import re
import csv
import datetime
import os
import sys
reload(sys)                      # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'

bourse = 'sz'
t = 'month'

def getConnect():
    f = open("connect/connect_"+bourse+".txt")
    codes = []
    p = re.compile('\n')

    for i in f:
        i = re.sub(p, '', i)
        codes.append(i)
        # print i

    return codes

def findNoCode():

    codes = getConnect()

    path = "data_" + bourse + "_" + t
    files = os.listdir(path)
    # codes_n = []
    for file in files:

        code_n = file.split('_')[1].split('.')[0]
        # codes_n.append(code_n)
        if code_n not in codes:
            os.remove(path + "/" + file)
            print "over data " + file


    # for code in codes:
    #     if code not in codes_n:
    #         print "no data" + code



if __name__ == "__main__":
    findNoCode()
