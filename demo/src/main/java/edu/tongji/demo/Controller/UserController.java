package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.UserInfoMapper;
import edu.tongji.demo.Model.UserInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

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
            session.setMaxInactiveInterval(60*60);

            Cookie cookie = new Cookie("fnan", content.getString("name"));
            cookie.setPath("/");
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            return "200";
        }
    }

    /**
     * 注销用户，删除session里的cookie
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

    @PostMapping("/signup")
    @ResponseBody
    public String SignUp(@RequestBody String information, HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    @GetMapping("/test")
    public Object test(HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "unregistered!";
        }
        else{
            Cookie[] cookies = request.getCookies();
            if(cookies == null)
                return "no cookies?";
            else{
                for (int i = 0; i < cookies.length; i++){
                    if(cookies[i].getName().equals("fnan") && cookies[i].getValue().equals(session.getAttribute("name")))
                        return "verifying successfully!";
                }
                return "verifying failed!";
            }
        }
    }
}
