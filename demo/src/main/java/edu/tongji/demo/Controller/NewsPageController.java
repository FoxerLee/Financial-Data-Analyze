package edu.tongji.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsPageController {

    @GetMapping("/newspage")
    public Object index(){
        return "news.html";
    }
}
