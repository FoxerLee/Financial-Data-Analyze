package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.ConnectMapper;
import edu.tongji.demo.Mapper.DataDaysMapper;
import edu.tongji.demo.Mapper.IndustryMapper;
import edu.tongji.demo.Model.Connect;
import edu.tongji.demo.Verification;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IndustryMapper industryMapper;

    @Autowired
    private ConnectMapper connectMapper;

    @Autowired
    private DataDaysMapper dataDaysMapper;

    @GetMapping("/all")
    public Object GetAllStockInfo(){
        Boolean judge = Verification.verify();
        if (!judge)
            return "unregistered";
        else
            return industryMapper.getAllIndustryInfor();
    }

    /**
     * 通过code或者name获得connect的信息
     * @param content
     * @return
     */
    @PostMapping("/one")
    public Object GetSpecificInfo(@RequestBody String content){
        Boolean judge = Verification.verify();
        if (judge == false)
            return "unregistered";
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
    public Object GetStocksOfIndustry(@Param(value = "name") String name){
        if (!Verification.verify())
            return "unregistered";
        else {/**
         * 内部类定义传输数据的格式
         */
            class Data{
                private String name;
                private Double p_change;
                public Data(String name, Double p_change){
                    this.name = name;
                    this.p_change = p_change;
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
                if(connectArrayList == null)
                    return "no information";
                ArrayList<Data> dataDays = new ArrayList<>();
                for (int i = 0; i < connectArrayList.size(); i++){
                    if (i == 50)
                        break;
                    Double p_change = 0.0;
                    try{
                        p_change = dataDaysMapper.getPChangeByCode(connectArrayList.get(i).getCode()).getP_change();
                    } catch (Exception e){
                        System.out.println(connectArrayList.get(i).getCode());
                    }
                    dataDays.add(new Data(connectArrayList.get(i).getName(), p_change));
                }
                return dataDays;
            } catch (Exception e){
                //未知错误
                return "400";
            }
        }
    }
}