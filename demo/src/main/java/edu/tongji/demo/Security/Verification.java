package edu.tongji.demo.Security;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Verification {
    public static Boolean verify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        HttpSession session = request.getSession(false);
        if(session == null){
            return false;
        }
        else{
            Cookie[] cookies = request.getCookies();
            if(cookies == null)
                return false;
            else{
                for (int i = 0; i < cookies.length; i++){
                    if(cookies[i].getName().equals("fnan") && cookies[i].getValue().equals(session.getAttribute("name")))
                        return true;
                }
                return false;
            }
        }
    }
}
