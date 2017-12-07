package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Model.Connect;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    private ConnectMapper connectMapper;

    @PostMapping("/Stocks")
    public Object SearchStock(@RequestBody Map<String, String> reMap){
        try{
            String code = reMap.get("code");
            if (code.matches("[^0-9]")){
                return "good";
            }else{
                ArrayList<Connect> data = connectMapper.getDataByCode(code);
                HashMap<String, String> result = new HashMap<>();
                result.put("code", data.get(0).getCode());
                result.put("name", data.get(0).getName());
                return result;

            }

        }catch (Exception e){
            return "Fail!";
        }

    }
}
