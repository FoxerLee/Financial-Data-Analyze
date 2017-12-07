package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.NewsMapper;
import edu.tongji.demo.Model.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/news")
@CrossOrigin()
public class NewsController {

    @Autowired
    private NewsMapper newsMapper;

    @GetMapping("/user")
    public Object getNews(@Param(value = "code") String code){
        ArrayList<News> news = newsMapper.getNews(code);
        return news;
    }
}
