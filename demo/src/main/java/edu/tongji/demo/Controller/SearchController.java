package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Model.Connect;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.*;

@RestController
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    private ConnectMapper connectMapper;

    @RequestMapping(value = "/Stocks", method = RequestMethod.POST)
    public Object SearchStock(@RequestBody String content){
        return content;
//        try{
//            String code = reMap.get("code");
//            if (code.matches("[^0-9]")){
//                return "good";
//            }else{
//                ArrayList<Connect> data = connectMapper.getDataByCode(code);
//                HashMap<String, String> result = new HashMap<>();
//                result.put("code", data.get(0).getCode());
//                result.put("name", data.get(0).getName());
//                return result;
//
//            }
//
//        }catch (Exception e){
//            return "Fail!";
//        }

    }
}
