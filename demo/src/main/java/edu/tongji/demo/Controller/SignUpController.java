package edu.tongji.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class SignUpController {

    @GetMapping("/signuppage")
    public Object index(){
        return "sign-up2.html";
    }
}
