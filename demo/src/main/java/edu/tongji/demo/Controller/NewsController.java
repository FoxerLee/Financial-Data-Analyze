package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.NewsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsMapper newsMapper;

    @GetMapping("/user")
    public Object getNews(@Param(value = "code") String code){
        return newsMapper.getNews(code);
    }
}
