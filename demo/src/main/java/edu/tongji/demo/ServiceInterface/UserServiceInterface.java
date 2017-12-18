package edu.tongji.demo.ServiceInterface;

import javax.servlet.http.HttpServletRequest;

public interface UserServiceInterface {

    Integer getUserByName(String name);

    String getNameByCookie(HttpServletRequest request);
}
