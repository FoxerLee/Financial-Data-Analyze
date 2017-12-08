package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Mapping.IndustryMapper;
import edu.tongji.demo.Model.Connect;
import edu.tongji.demo.Model.Industry;
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

    @GetMapping("/GetAll")
    public ArrayList<Industry> GetAllStockInfo(){
        return industryMapper.getAllIndustryInfor();
    }

    @PostMapping("/GetOne")
    public Object GetSpecificInfo(@RequestBody String content){
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
