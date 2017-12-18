package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.*;
import edu.tongji.demo.Model.Connect;
import edu.tongji.demo.Model.DataRealTime;
import edu.tongji.demo.Model.WarehouseDataDays;
import edu.tongji.demo.Service.StockService;
import edu.tongji.demo.security.Verification;
import edu.tongji.demo.Service.UserService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/stock")
@CrossOrigin
public class StockController {

    @Autowired
    private IndustryMapper industryMapper;

    @Autowired
    private ConnectMapper connectMapper;

    @Autowired
    private DataDaysMapper dataDaysMapper;

    @Autowired
    private DataRealTimeMapper dataRealTimeMapper;

    @Autowired
    private WarehouseDataDaysMapper warehouseDataDaysMapper;

    @GetMapping("/all")
    public Object GetAllStockInfo(){
        try{
            Boolean judge = Verification.verify();
            if (!judge){
                return "400";
            }
            else
                return industryMapper.getAllIndustryInfor();
        }catch (Exception e){
            return "404";
        }
    }
        /**
     * 通过code或者name获得connect的信息
     * @param content
     * @return
     */
    @PostMapping("/one")
    public Object GetSpecificInfo(@RequestBody String content){
        Boolean judge = Verification.verify();
        if (judge == false) {
            return "unregistered";
        }
        else{
            int i = 0;
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
    }

    /**
     * 根据行业名称返回该行业股票以及它们的周信息
     * @param name
     * @return
     */
    @GetMapping("/industry")
    public Object GetStocksOfIndustry(@RequestParam(value = "name", defaultValue = "化工行业")  String name, HttpServletResponse response) throws IOException{
        if (!Verification.verify()){
            return "400";
        }
        else {/**
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
    }

    /**
     * 获取某只股票的最新信息，根据code
     * @param code
     * @return
     */
    @GetMapping(value = "/brief")
    public Object getBrief(@Param(value = "code") String code){
        try{
            DataRealTime dataRealTimes = dataRealTimeMapper.getPresentData(code);
            if (dataRealTimes == null)
                return "404";
            else
                return dataRealTimes;
        }catch (Exception e){
            return "400";
        }
    }

    @GetMapping(value = "/history")
    public Object getHistory(@Param(value = "code") String code){
        try{
            ArrayList<WarehouseDataDays> data = warehouseDataDaysMapper.getWareHouseData(code);
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
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 根据code获取股票名称
     * @param code
     * @return
     */
    @GetMapping(value = "/name")
    public Object getStockName(@Param(value = "code") String code){
        String temp = "{\"name\":\"";
        try{
            return temp + connectMapper.getName(code) + "\"}";
        }catch (Exception e){
            return temp + "Unknown" + "\"}";
        }
    }

    /**
     * 返回用户持有股票的信息
     */
//    @GetMapping("/user")
//    public Object getPersonalStocks(HttpServletRequest request){
//        if (!Verification.verify())
//            return "400";
//        else{
//            UserService userService = new UserService();
//            String name = userService.getNameByCookie(request);
//            if (name.equals(""))
//                return null;
//            int id = userService.getUserByName(name);
//            System.out.println(id);
//            if (id < 0)
//                return null;
//            else{
//                try{
//                    return new StockService().getStocksByCodes(id);
//                }catch (Exception e){
//                    return null;
//                }
//            }
//        }
//    }
}