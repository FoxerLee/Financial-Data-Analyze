import sys
import pymysql

default_encodeing = 'gbk'
if sys.getdefaultencoding != default_encodeing:
    reload(sys)
    sys.setdefaultencoding(default_encodeing)

f = open("connect_sh.txt")
g = open("connect_sz.txt")

for i in f:
    str = "INSERT INTO data_weeks VALUES (NULL," + i + ",now(),0,0,0,0,0);"
    print str
for i in g:
    str = "INSERT INTO data_weeks VALUES (NULL," + i + ",now(),0,0,0,0,0);"
    print str
