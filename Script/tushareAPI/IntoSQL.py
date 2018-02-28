# -*- coding:utf-8 -*-
import sys
reload(sys)  # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'

f = open("connect_sh.txt")
g = open("connect_sz.txt")

h = open("sql.txt", "w")
for i in f:
    str = "INSERT INTO javaEE.data_months VALUES (NULL,'" + i + "',now(),0,0,0,0,0,0);\n"
    h.write(str)
for i in g:
    str = "INSERT INTO javaEE.data_months VALUES (NULL,'" + i + "',now(),0,0,0,0,0,0);\n"
    h.write(str)

h.close()
