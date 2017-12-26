package edu.tongji.demo.Service;

import edu.tongji.demo.Model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    Integer getIDByName(String name);

    String getNameByCookie(HttpServletRequest request);

    void addSession(String name, String password, HttpServletRequest request, HttpServletResponse responses);

    boolean verify(String name, String password);

    void logout(HttpServletRequest request, HttpServletResponse response);

    boolean signUp(String name, String password, String email, String nickname);

    UserInfo getUserInformation(HttpServletRequest request);
}
