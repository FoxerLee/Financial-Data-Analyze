package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.WinnerListMapper;
import edu.tongji.demo.Model.WinnerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/winner")
public class WinnerListController {

    @Autowired
    private WinnerListMapper winnerListMapper;

    @GetMapping(value = "/all")
    public Object getAll(){
        try{
            ArrayList<WinnerList> data = winnerListMapper.getAll();
            ArrayList<String> reasons = new ArrayList<String>();
            for(int i = 0; i < data.size(); i++){
                if(reasons.indexOf(data.get(i).getReason()) == -1)
                    reasons.add(data.get(i).getReason());
            }
            Object[] result = new Object[reasons.size()];
            int tag = 0;
            for (int i = 0; i < reasons.size(); i++){
                ArrayList<WinnerList> list = new ArrayList<>();
                while(data.get(tag).getReason().equals(reasons.get(i))){
                    list.add(data.get(tag));
                    tag++;
                    if(tag == data.size())
                        break;
                }
                HashMap<String, Object> content = new HashMap<>();
                content.put("reason", reasons.get(i));
                content.put("data", list);
                result[i] = content;
            }
            return result;
        } catch (Exception e){
            return null;
        }

    }
}