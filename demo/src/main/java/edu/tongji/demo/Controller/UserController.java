package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

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
                             HttpServletRequest request, HttpServletResponse response){
        try{
            if (!userService.verify(name, password))
                return "400";
            else {
                userService.addSession(name, password, request, response);
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
    @CrossOrigin
    public void Delete(HttpServletRequest request, HttpServletResponse response){
        userService.logout(request, response);
    }

    /**
     * 用户注册账户
     * @param name
     * @param password
     * @return
     */
    @GetMapping("/signup")
    public String SignUp(@Param(value = "name") String name, @Param(value = "password")String password){
        try{
            if(userService.signUp(name, password))
                return "200";
            else
                return "400";
        } catch (Exception e){
            return "404";
        }
    }
}