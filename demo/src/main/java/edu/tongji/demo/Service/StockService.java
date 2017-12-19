package edu.tongji.demo.Service;

import edu.tongji.demo.Model.Connect;

import java.util.ArrayList;

public interface StockService {

    ArrayList<Connect> getStocksByUserID(Integer id);

    Object getStockByNameOrCode(String content);

    Object getStocksOfIndustry(String name);

    Object getStocksHistory(String code);

    Object getStockBriefInformation(String code);

    String getStockNameByCode(String code);

}
