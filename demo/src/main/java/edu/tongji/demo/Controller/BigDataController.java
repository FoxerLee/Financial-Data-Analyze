package edu.tongji.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class BigDataController {

    @GetMapping("/bigdatagraph1")
    public Object index1(){
        return "index_data2.html";
    }
}
