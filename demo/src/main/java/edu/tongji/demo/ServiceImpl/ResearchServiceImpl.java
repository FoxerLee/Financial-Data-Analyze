package edu.tongji.demo.ServiceImpl;
import edu.tongji.demo.DAO.ResearchMapper;
import edu.tongji.demo.Service.ResearchService;
import edu.tongji.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class ResearchServiceImpl implements ResearchService{

    @Autowired
    private ResearchMapper researchMapper;

    @Autowired
    private UserService userService;

    public Object getBriefResearchByCode(String code){
        try{
            return researchMapper.getBriefResearchData(code);
        }catch (Exception e){
            return "404";
        }
    }

    @Override
    public Object getPersonalResearch(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        try{
            for (int i = 0; i < cookies.length; i++){
                return researchMapper.getPersonalStock(userService.getIDByName(userService.getNameByCookie(request)));
            }
            return "400";
        }catch (Exception e){
            return "404";
        }
    }
}
