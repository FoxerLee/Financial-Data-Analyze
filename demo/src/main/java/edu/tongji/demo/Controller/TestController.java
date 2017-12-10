package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.CompanyInfoMapper;
import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Model.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Logger;

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
    public Object Temp(HttpServletRequest request, HttpServletResponse response){

        //获取session
        HttpSession session = request.getSession();

        //session添加元素
        session.setAttribute("id", "");

//        //获取value
//        String context = (String)session.getAttribute("test");
//
//        //删除特定属性
//        session.removeAttribute("test");
//
//        //使session无效
//        session.invalidate();
        ArrayList<CompanyInfo> companyInfos = companyInfoMapper.getData("000001");

//        Cookie cookie = new Cookie("name", "lalala");
//        cookie.setMaxAge(60 * 60);
//        response.addCookie(cookie);

        if(session.isNew()){
            return "session创建成功！";
        }
        else{
            return "服务器已经创建了session！";
        }
//        return companyInfos;
    }
}
