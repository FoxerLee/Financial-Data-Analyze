package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.UserInfo;
import edu.tongji.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆验证
     * @param data
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Object test(UserInfo data, HttpServletRequest request, HttpServletResponse response){
        try{
            if (!userService.verify(data.getName(), data.getPassword()))
                return "400";
            else {
                userService.addSession(data.getName(), data.getPassword(), request, response);
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
     * @param data
     * @return
     */
    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody String SignUp(UserInfo data){
        try{
            if(userService.signUp(data.getName(), data.getPassword(), data.getEmail(), data.getNickname()))
                return "200";
            else
                return "400";
        } catch (Exception e){
            return "404";
        }
    }
}