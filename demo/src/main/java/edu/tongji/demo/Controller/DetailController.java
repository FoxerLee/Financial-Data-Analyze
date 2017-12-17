package edu.tongji.demo.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
public class DetailController {

    @GetMapping("/detailspage")
    public Object index(@Param(value = "code")String code, HttpServletResponse response){
        return new ModelAndView("detail.html");
    }
}
