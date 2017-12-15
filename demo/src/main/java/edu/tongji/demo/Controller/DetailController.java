package edu.tongji.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class DetailController {

    @GetMapping("/detailspage")
    public Object index(){
        return "detail.html";
    }
}
