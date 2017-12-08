package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Model.Connect;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    private ConnectMapper connectMapper;

    @PostMapping("/Stocks")
    public Object SearchStock(@RequestBody String content){

        //将post过来的数据转换为json格式
        JSONObject jsonObject;
        try{
            jsonObject = JSONObject.fromObject(content);
        } catch (Exception e){
            return "invalid json format";
        }

        //添加字段
        //jsonObject.accumulate("hello", "test");

        //获取key值对应的数据
        //String name = jsonObject.getString("hello");

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
