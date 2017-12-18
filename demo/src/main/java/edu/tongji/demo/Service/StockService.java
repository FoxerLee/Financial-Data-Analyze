package edu.tongji.demo.Service;

import edu.tongji.demo.Mapper.ConnectMapper;
import edu.tongji.demo.Mapper.SelfStockingMapper;
import edu.tongji.demo.Model.Connect;
import edu.tongji.demo.Model.SelfStocking;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class StockService {

    @Autowired
    private SelfStockingMapper selfStockingMapper;

    @Autowired
    private ConnectMapper connectMapper;

    public ArrayList<Connect> getStocksByCodes(Integer id){
        try{
            ArrayList<SelfStocking> codes = selfStockingMapper.getStockByID(id);
            ArrayList<Connect> Stocks = new ArrayList<>();
            for (int i = 0; i < codes.size(); i++){
                Stocks.add(connectMapper.getDataByCode(codes.get(i).getCode()).get(0));
            }
            return Stocks;
        } catch (Exception e){
            return null;
        }
    }
}
