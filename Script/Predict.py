import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from pandas import datetime
import math, time
import itertools
from sklearn import preprocessing
import datetime
from operator import itemgetter
from sklearn.metrics import mean_squared_error
from math import sqrt
import mysql.connector

from keras.models import Sequential
from keras.layers.core import Dense, Dropout, Activation
from keras.layers.recurrent import LSTM

import tushare as ts

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

    cursor.close()
    conn.close()
    return ids


def dealData(id):
    df = ts.get_hist_data(id)
    df.to_csv('test.csv')
    df = pd.read_csv('test.csv')
    df['high'] = df['high'] / 1000
    df['open'] = df['open'] / 1000
    df['close'] = df['close'] / 1000
    df.drop(['date'], axis=1, inplace=True)
    df.drop(['low'], axis=1, inplace=True)
    df.drop(['volume'], axis=1, inplace=True)
    df.drop(['price_change'], axis=1, inplace=True)
    df.drop(['ma5'], axis=1, inplace=True)
    df.drop(['ma10'], axis=1, inplace=True)
    df.drop(['ma20'], axis=1, inplace=True)
    df.drop(['v_ma10'], axis=1, inplace=True)
    df.drop(['v_ma5'], axis=1, inplace=True)
    df.drop(['v_ma20'], axis=1, inplace=True)
    df.drop(['p_change'], axis=1, inplace=True)
    df.drop(['turnover'], axis=1, inplace=True)

    return df


def load_data(stock, seq_len):
    amount_of_features = len(stock.columns)
    data = stock.as_matrix()  # pd.DataFrame(stock)
    sequence_length = seq_len + 1
    result = []
    for index in range(len(data) - sequence_length):
        result.append(data[index: index + sequence_length])

    result = np.array(result)
    row = round(0.9 * result.shape[0])
    train = result[:int(row), :]
    x_train = train[:, :-1]
    y_train = train[:, -1][:, -1]
    x_test = result[int(row):, :-1]
    y_test = result[int(row):, -1][:, -1]

    x_train = np.reshape(x_train, (x_train.shape[0], x_train.shape[1], amount_of_features))
    x_test = np.reshape(x_test, (x_test.shape[0], x_test.shape[1], amount_of_features))

    return [x_train, y_train, x_test, y_test]


def build_model(layers):
    model = Sequential()

    model.add(LSTM(
        input_dim=layers[0],
        output_dim=layers[1],
        return_sequences=True))
    model.add(Dropout(0.2))

    model.add(LSTM(
        layers[2],
        return_sequences=False))
    model.add(Dropout(0.2))

    model.add(Dense(
        output_dim=layers[2]))
    model.add(Activation("linear"))

    start = time.time()
    model.compile(loss="mse", optimizer="rmsprop", metrics=['accuracy'])
    print("Compilation Time : ", time.time() - start)
    return model


def build_model2(layers):
    d = 0.2
    model = Sequential()
    model.add(LSTM(128, input_shape=(layers[1], layers[0]), return_sequences=True))
    model.add(Dropout(d))
    model.add(LSTM(64, input_shape=(layers[1], layers[0]), return_sequences=False))
    model.add(Dropout(d))
    model.add(Dense(16, init='uniform', activation='relu'))
    model.add(Dense(1, init='uniform', activation='relu'))
    model.compile(loss='mse', optimizer='adam', metrics=['accuracy'])
    return model


def run():
    ids = getCode()
    for id in ids:
        start = datetime.datetime.now()
        print start
        df = dealData(id)
        window = 5
        X_train, y_train, X_test, y_test = load_data(df[::-1], window)
        print("X_train", X_train.shape)
        print("y_train", y_train.shape)
        print("X_test", X_test.shape)
        print("y_test", y_test.shape)

        # you can choose one model
        # model = build_model([3,lag,1])
        model = build_model2([3, window, 1])

        model.fit(
            X_train,
            y_train,
            batch_size=512,
            nb_epoch=500,
            validation_split=0.1,
            verbose=0)

        trainScore = model.evaluate(X_train, y_train, verbose=0)
        print('Train Score: %.6f MSE (%.6f RMSE)' % (trainScore[0], math.sqrt(trainScore[0])))

        testScore = model.evaluate(X_test, y_test, verbose=0)
        print('Test Score: %.6f MSE (%.6f RMSE)' % (testScore[0], math.sqrt(testScore[0])))

        p = model.predict(X_test)

        conn = mysql.connector.connect(**config)
        cursor = conn.cursor()
        if p[-1] < p[-2]:
            res = -1
            cursor.execute("UPDATE javaEE.connect SET res=" + str(res) + " WHERE code = \'" + id + "\';")
            cursor.execute("Commit;")
        else:
            res = 1
            cursor.execute("UPDATE javaEE.connect SET res=" + str(res) + " WHERE code = \'" + id + "\';")
            cursor.execute("Commit;")
        cursor.close()
        conn.close()

        print "Succeed! " + id
        print datetime.datetime.now() - start


if __name__ == "__main__":
    run()