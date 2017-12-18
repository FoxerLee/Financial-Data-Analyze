package edu.tongji.demo.Service;

import edu.tongji.demo.DAO.UserInfoMapper;
import edu.tongji.demo.DAO.WinnerListMapper;
import edu.tongji.demo.ServiceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Integer getUserByName(String name){
        try{
            if (name.equals(""))
                return -1;
            return userInfoMapper.getID(name);
        } catch (Exception e){
            return -2;
        }
    }

    @Override
    public String getNameByCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String name = "";
        for(int i = 0; i < cookies.length; i++){
            if(cookies[i].getName().equals("fnan")){
                name = cookies[i].getValue();
                break;
            }
        }
        return name;
    }
}
