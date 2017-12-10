package edu.tongji.demo.Controller;


import com.sun.deploy.net.HttpResponse;
import edu.tongji.demo.Mapping.UserInfoMapper;
import edu.tongji.demo.Model.UserInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Identification")
public class LoginController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @PostMapping("/login")
    @ResponseBody
    public String Vefification(@RequestBody String verification, HttpServletRequest request,  HttpServletResponse response){
        JSONObject content = JSONObject.fromObject(verification);
        UserInfo info = userInfoMapper.Vefify(content.getString("name"), content.getString("password"));
        if (info == null){
            return "404";
        }
        else {
            //添加session
            HttpSession session = request.getSession();
            session.setAttribute("name", content.getString("name"));
            session.setAttribute("password", content.getString("password"));

            //添加cookie
            Cookie name = new Cookie("name", content.getString("name"));
            name.setMaxAge(60*60*1);
            response.addCookie(name);
            return "200";
        }
    }
}
