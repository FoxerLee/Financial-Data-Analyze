package edu.tongji.demo.Controller;

import edu.tongji.demo.DAO.UserInfoMapper;
import edu.tongji.demo.Model.UserInfo;
import edu.tongji.demo.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 用户输入用户名和密码进行登陆
     * @param name
     * @param password
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/login")
    public String Verification(@Param(value = "name")String name, @Param(value = "password") String password,
                             HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            UserInfo info = userInfoMapper.Vefify(name, password);
            if (info == null){
                return "400";
            }
            else {
                //添加session
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("password", password);
                session.setMaxInactiveInterval(60*60);

                Cookie cookie = new Cookie("fnan", name);
                cookie.setPath("/");
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
                return "200";
            }
        }catch (Exception e){
            return "404";
        }
    }

    /**
     * 注销用户，删除注册的cookie
     * @param request
     * @param response
     */
    @GetMapping("/logout")
    //@AvoidDuplicatSubmission
    @CrossOrigin
    public void Delete(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
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
     * @param name
     * @param password
     * @param response
     * @return
     */
    @GetMapping("/signup")
    public String SignUp(@Param(value = "name") String name, @Param(value = "password")String password,
                         HttpServletResponse response) throws IOException{
        try{
            Integer count = userInfoMapper.Check(name);
            System.out.print(count);
            if(count.equals(1)){
                return "400";
            }
            else{
                userInfoMapper.AddUser(password, name);
                return "200";
            }
        } catch (Exception e){
            return "404";
        }
    }
}