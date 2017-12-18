package edu.tongji.demo.ServiceInterface;

import edu.tongji.demo.Model.Connect;

import java.util.ArrayList;

public interface StockServiceInterface {

    ArrayList<Connect> getStocksByCodes(Integer id);

    Object getStockByNameOrCode(String content);

    Object getStocksOfIndustry(String name);

    Object getStocksHistory(String code);

}
