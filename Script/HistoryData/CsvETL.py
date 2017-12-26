# -*- coding:utf-8 -*-
import os
import csv
import mysql.connector
import sys
import datetime
reload(sys)                      # reload 才能调用 setdefaultencoding 方法
sys.setdefaultencoding('utf-8')  # 设置 'utf-8'


t = 'month'
path = "data_" + t
config = {'host': '10.60.42.201', 'user': 'root', 'password': '123456', 'port': 13142, 'database': 'javaEE',
                      'charset': 'utf8'}
# files = os.listdir(path)
# write = open("sh_code.txt",'w')

# code = ""
# sqlStatement = "INSERT INTO HISTORICAL_QUOTES VALUES('"
# AllSqlStatememt = []
# count = 0
# temp = 0

def run():
    # bourse = 'sh'
    # t = 'day'
    # path = "data_" + bourse + "_" + t
    files = os.listdir(path)

    for file in files:

        code = file.split('.')[0]
        sql = "INSERT INTO warehouse_data_" + t + "s VALUES (NULL,%s,%s,%s,%s,%s,%s,%s,%s)"
        # sql = "INSERT INTO warehouse_data_" + t + "VALUES (SEQ_W_DATA_DAYS.NEXTVAL,?,?,?,?,?,?,?)"
        try:
            csvfile = open(path + "/" + file, 'rb')
            reader = csv.reader(csvfile)
            next(reader, None)
        except Exception, e:
            print "read csv error! " + code
            print e
        result = []

        for lines in reader:
            try:
                # print lines[0]
                # new_date = dateFormat(lines[0])
                # print new_date
                result.append((code, lines[0], lines[1], lines[3], lines[2], lines[4], lines[5], lines[7]))

            except Exception, e:
                print "read data error! " + code
                print e
                continue

        try:
            conn = mysql.connector.connect(**config)
            cursor = conn.cursor()

            cursor.executemany(sql, result)
            cursor.execute("Commit;")
            cursor.close()
            conn.close()
            print "write data succeed! " + code
            print datetime.datetime.now()
        except Exception, e:
            print "write data error! " + code
            print e
            cursor.close()
            conn.close()
# def dateFormat(d):
#     print d
#     new = d[6:10] + "-" + d[3:5] + "-" + d[0:2]
#     return new

if __name__ == '__main__':
    run()

# for file in files:
#
#     code = file.split('_')[1].split('.')[0]
#     try:
#         csvfile = open(path + "/" + file, 'rb')
#     except IOError:
#         print "wrong filename"
#         continue
#     reader = csv.reader(csvfile)
#     print file
#     next(reader, None)
#     for line in reader:
#         sqlStatement += code + "', "
#         sqlStatement += "TO_DATE('" + line[0] + "','YYYY-MM-DD')"
#         line = line[1:]
#         for item in line:
#             sqlStatement += ', ' + item
#         sqlStatement += ');\n'
#         # print sqlStatement
#         AllSqlStatememt.append(sqlStatement)
#         count += 1
#         sqlStatement = "INSERT INTO HISTORICAL_QUOTES VALUES('"
#     csvfile.close()
#     if count > 20000:
#         write = open("sql_sh/sh_code_" + str(temp) + ".txt", 'w')
#         write.writelines(AllSqlStatememt)
#         write.write('Commit;')
#         AllSqlStatememt = []
#         temp += 1
#         count = 0
# write = open("sql_sh/sh_code_" + str(temp) + ".txt", 'w')
# write.write('Commit;')
# write.writelines(AllSqlStatememt)