package Test.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
@RequestMapping("/hello/*")
public class index {

    @GetMapping(value = "index")
    public ModelAndView index(ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("/templates/index.html");
        return modelAndView;
    }

    @GetMapping(value = "requestData")
    @ResponseBody
    public HashMap<String , String> index(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "1552635");
        return hashMap;
    }
}
