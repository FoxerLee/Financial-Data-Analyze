package edu.tongji.demo.ServiceImpl;

import edu.tongji.demo.DAO.*;
import edu.tongji.demo.Model.Connect;
import edu.tongji.demo.Model.DataRealTime;
import edu.tongji.demo.Model.SelfStocking;
import edu.tongji.demo.Model.WarehouseData;
import edu.tongji.demo.Service.StockService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private SelfStockingMapper selfStockingMapper;

    @Autowired
    private ConnectMapper connectMapper;

    @Autowired
    private DataDaysMapper dataDaysMapper;

    @Autowired
    private WarehouseDataDaysMapper warehouseDataDaysMapper;

    @Autowired
    private WarehouseDataWeeksMapper warehouseDataWeeksMapper;

    @Autowired
    private WarehouseDataMonthsMapper warehouseDataMonthsMapper;

    @Autowired
    private DataRealTimeMapper dataRealTimeMapper;

    @Override
    public ArrayList<Connect> getStocksByUserID(Integer id){
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

    @Override
    public Object getStockByNameOrCode(String content){
        JSONObject jsonObject;
        try{
            jsonObject = JSONObject.fromObject(content);
        } catch (Exception e){
            return "invalid json format";
        }
        try{
            String code = jsonObject.getString("code");
            ArrayList<Connect> data;
            if (code.matches("^[0-9]*")) {
                data = connectMapper.getDataByCode(code);
            } else{
                data = connectMapper.getDataByName(code);
            }
            if(data == null)
                return "cannot find it";
            JSONObject result = new JSONObject();
            result.accumulate("code", data.get(0).getCode());
            result.accumulate("name", data.get(0).getName());
            return result;
        }catch (Exception e){
            return "Fail!";
        }
    }


    @Override
    public Object getStocksOfIndustry(String name){
        /**
         * 内部类定义传输数据的格式
         */
        class Data{
            private String code;
            private String name;
            private Double p_change;
            public Data(String name, Double p_change, String code){
                this.name = name;
                this.p_change = p_change;
                this.code = code;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Double getP_change() {
                return p_change;
            }

            public void setP_change(Double p_change) {
                this.p_change = p_change;
            }
        }
        try{
            ArrayList<Connect> connectArrayList = connectMapper.getDataByCName(name);
            ArrayList<Data> dataDays = new ArrayList<>();
            if(connectArrayList == null)
                return null;
            for (int i = 0; i < connectArrayList.size(); i++){
                if (i == 50)
                    break;
                Double p_change = 0.0;
                String code = "";
                try{
                    p_change = dataDaysMapper.getPChangeByCode(connectArrayList.get(i).getCode()).getP_change();
                    code = connectArrayList.get(i).getCode();
                } catch (Exception e){
                    continue;
                }
                dataDays.add(new Data(connectArrayList.get(i).getName(), p_change, code));
            }
            return dataDays;
        } catch (Exception e){
            //未知错误
            return "404";
        }
    }

    @Override
    public Object getStocksHistory(String code, int type){
        ArrayList<WarehouseData> data = null;
        if (type == 1)
            data = warehouseDataDaysMapper.getWareHouseData(code);
        else if(type == 2)
            data = warehouseDataWeeksMapper.getWareHouseData(code);
        else
            data = warehouseDataMonthsMapper.getWareHouseData(code);
        Object[] result = new Object[data.size()];
        for(int i = 0; i < data.size(); i++){
            Object[] temp  = new Object[6];
            temp[0] = new String(data.get(i).getTrading_day().split(" ")[0]);
            temp[1] = new Double(data.get(i).getOpen_value());
            temp[2] = new Double(data.get(i).getClose_value());
            temp[3] = new Double(data.get(i).getHigh_value());
            temp[4] = new Double(data.get(i).getLow_value());
            temp[5] = new Double(data.get(i).getVolume_value());
            result[i] = temp;
        }
        return result;
    }

    @Override
    public Object getStockBriefInformation(String code){
        DataRealTime dataRealTimes = dataRealTimeMapper.getPresentData(code);
        if (dataRealTimes == null)
            return "404";
        else
            return dataRealTimes;
    }

    @Override
    public String getStockNameByCode(String code){
        String temp = "{\"name\":\"";
        try{
            return temp + connectMapper.getName(code) + "\"}";
        }catch (Exception e){
            return "404";
        }
    }

    @Override
    public Integer getPredict(String code){
        return connectMapper.getPredict(code);
    }
}
