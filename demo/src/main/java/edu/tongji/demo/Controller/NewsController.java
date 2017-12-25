package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.NewsService;
import edu.tongji.demo.Security.Verification;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/user")
    public Object getNews(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        else
            return newsService.getNewsByCode(code);
    }

    @GetMapping("/code")
    public Object getBriefNews(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        return newsService.getBriefNewsByCode(code);
    }
}