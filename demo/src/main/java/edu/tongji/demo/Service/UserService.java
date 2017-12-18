package edu.tongji.demo.Service;

import edu.tongji.demo.Mapper.UserInfoMapper;
import edu.tongji.demo.Mapper.WinnerListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private WinnerListMapper winnerListMapper;

    public Object getUserByName(String name){
//        try{
//
//        } catch (Exception e){
//            return -2;
//        }
//        if (name.equals(""))
//            return -1;
//
//        userInfoMapper.getID(name);
//        return userInfoMapper.getID(name);
        return winnerListMapper.getAll();
    }

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
