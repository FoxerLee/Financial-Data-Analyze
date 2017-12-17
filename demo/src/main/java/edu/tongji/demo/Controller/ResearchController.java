package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.ResearchMapper;
import edu.tongji.demo.Mapper.UserInfoMapper;
import edu.tongji.demo.Model.Research;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("/research")
public class ResearchController {

    @Autowired
    private ResearchMapper researchMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @GetMapping("/code")
    public Object getResByCode(@Param(value = "code") String code){
        try{
            return researchMapper.getBriefResearchData(code);
        }catch (Exception e){
            return "400";
        }
    }

    @GetMapping("/personal")
    public Object getResByPerson(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        HttpSession session = request.getSession(false);
//        if(session == null){
//            response.sendRedirect("http://localhost:8080/loginpage");
//            return false;
//        }
//        else{
//
//        }
//        try{
//
//        }catch (Exception e){
//            System.out.println("error!!");
//            return null;
//        }
        Cookie[] cookies = request.getCookies();
        String name = "";
        if(cookies == null){
            response.sendRedirect("http://localhost:8080/loginpage");
            return null;
        }
        else{
            for (int i = 0; i < cookies.length; i++){
                if(cookies[i].getName().equals("fnan")){
                    name = cookies[i].getValue();
                    Integer id = userInfoMapper.getID(name);
                    return researchMapper.getPersonalStock(id);
                }
            }
            response.sendRedirect("http://localhost:8080/loginpage");
            return false;
        }

    }
}
