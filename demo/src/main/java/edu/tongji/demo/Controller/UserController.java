package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.UserInfoMapper;
import edu.tongji.demo.Model.UserInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 用户输入名字和password身份验证通过
     * @param verification
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String Vefification(@RequestBody String verification, HttpServletRequest request,  HttpServletResponse response){
        JSONObject content = JSONObject.fromObject(verification);
        UserInfo info = userInfoMapper.Vefify(content.getString("name"), content.getString("password"));
        if (info == null){
            System.out.println("error");
//            response.sendRedirect("http://localhost:8080/loginpage");
            return "404";
        }
        else {
            //添加session
            HttpSession session = request.getSession();
            session.setAttribute("name", content.getString("name"));
            session.setAttribute("password", content.getString("password"));
            session.setMaxInactiveInterval(60*60);

            Cookie cookie = new Cookie("fnan", content.getString("name"));
            cookie.setPath("/");
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            System.out.println("yes!!");
//            response.sendRedirect("http://localhost:8080/bigdatagraph1");
            return "200";
        }
    }

    /**
     * 注销用户，删除注册的cookie
     * @param request
     * @param response
     */
    @GetMapping("/withdraw")
    public void Delete(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        System.out.print(cookies.length);
        for (int i = 0; i < cookies.length; i++){
            if(cookies[i].getName().equals("fnan")){
                Cookie cookie = new Cookie("fnan", "ww");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    /**
     * 用户注册账户
     * @param information
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/signup")
    @ResponseBody
    public String SignUp(@RequestBody String information, HttpServletRequest request, HttpServletResponse response){
        return null;
    }
}