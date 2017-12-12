package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.ConnectMapper;
import edu.tongji.demo.Mapper.DataDaysMapper;
import edu.tongji.demo.Mapper.IndustryMapper;
import edu.tongji.demo.Models.Connect;
import edu.tongji.demo.Models.BriefDataDays;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Stock")
public class StockController {

    @Autowired
    private IndustryMapper industryMapper;

    @Autowired
    private ConnectMapper connectMapper;

    @Autowired
    private DataDaysMapper dataDaysMapper;

    @GetMapping("/GetAll")
    public Object GetAllStockInfo(){
        return industryMapper.getAllIndustryInfor();
    }

    @PostMapping("/GetOne")
    public Object GetSpecificInfo(@RequestBody String content){
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

    /**
     * 根据行业名称返回该行业股票以及它们的周信息
     * @param name
     * @return
     */
    @GetMapping("/Industry")
    public Object GetStocksOfIndustry(@Param(value = "name") String name){
        try{
            ArrayList<BriefDataDays> dataDays =dataDaysMapper.getStocksByIndustry(name);
            if (dataDays == null)
                return "404";
            else{
//                for(int i = 0; i < dataDays.size(); i++)
//                    System.out.print(dataDays.get(0).getTradingDay());
                return dataDays;
            }
        } catch (Exception e){
            //未知错误
            return "400";
        }


    }
}