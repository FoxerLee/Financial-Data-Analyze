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
        try{
            return researchMapper.getBriefResearchData(code);
        }catch (Exception e){
            return "400";
        }
    }

}
