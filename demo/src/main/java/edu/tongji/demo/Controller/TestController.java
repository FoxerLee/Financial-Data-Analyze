package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.CompanyInfoMapper;
import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Model.CompanyInfo;
import edu.tongji.demo.Model.Connect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class TestController {

    @Autowired
    private ConnectMapper connectMapper;

    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    @GetMapping(value = "/test")
    public Object Test(HttpServletRequest httpServletRequest){
        try{
            Cookie[] cookies = httpServletRequest.getCookies();
            String[] names = new String[cookies.length];
            for(int i = 0; i < cookies.length; i++){
                names[i] = cookies[i].getName();
            }
            return names;
        } catch (Exception e){
            return "emmm";
        }

    }

    @GetMapping(value = "/temp")
    public Object Temp(){
        ArrayList<CompanyInfo> companyInfos = companyInfoMapper.getData("000001");
        return companyInfos;
    }
}
