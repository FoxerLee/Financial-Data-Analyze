package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.ResearchMapper;
import edu.tongji.demo.Model.Research;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/research")
public class ResearchController {

    @Autowired
    private ResearchMapper researchMapper;

    @GetMapping("/code")
    public Object getResByCode(@Param(value = "code") String code){
//        JSONObject jsonObject;
//        try{
//            jsonObject = JSONObject.fromObject(request);
//            System.out.print(request);
//            return researchMapper.getBriefResearchData(jsonObject.getString("code"));
//        }catch (Exception e){
//            return "400";
//        }
        return null;
    }

}
