# -*- coding:utf-8 -*-
import tushare
import re
print(tushare.__version__)
import csv
import datetime
import sys
reload(sys)                      # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'

bourse = 'sh'
t = 'month'

f = open("stock/stockCode_"+bourse+".csv")
line = f.readline()

for i in range(1773):
    line = f.readline()
    patt = re.compile(r"\((.*?)\)", re.I | re.X)
    code = patt.findall(line)

    nPos = line.index('(')
    name = line[0:nPos]
    try:
        if code[0][0] == '0' or code[0][0] == '6':
            df = tushare.get_hist_data(code[0], ktype='W')
            df.to_csv('data_'+bourse+'_'+t+'/' + name + '_' + code[0] + '.csv')
            print name + " " + str(code)
            print datetime.datetime.now()

        # if code[0][0] == '6':
        #     df = tushare.get_hist_data(code[0], ktype='D')
        #     df.to_csv('data_'+bourse+'_day/' + name + '_' + code[0] + '.csv')
        else:
            continue

    except Exception, e:
        print e
        continue
