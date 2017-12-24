package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.ResearchService;
import edu.tongji.demo.Security.Verification;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/research")
public class ResearchController {

    @Autowired
    private ResearchService researchService;

    @GetMapping("/code")
    public Object getResByCode(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        return researchService.getBriefResearchByCode(code);
    }

    @GetMapping("/personal")
    public Object getResByPerson(HttpServletRequest request){
        if (!Verification.verify())
            return "400";
        return researchService.getPersonalResearch(request);
    }
}
