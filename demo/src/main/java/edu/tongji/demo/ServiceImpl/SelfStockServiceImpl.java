package edu.tongji.demo.ServiceImpl;

import edu.tongji.demo.DAO.SelfStockingMapper;
import edu.tongji.demo.Service.SelfStockService;
import edu.tongji.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SelfStockServiceImpl implements SelfStockService {

    @Autowired
    private UserService userService;

    @Autowired
    private SelfStockingMapper selfStockingMapper;

    @Override
    public boolean addStockByCode(String code, HttpServletRequest request){
        try{
            Integer id = userService.getIDByName(userService.getNameByCookie(request));
            selfStockingMapper.addStockCode(id, code);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteStockByCode(String code, HttpServletRequest request){
        try{
            Integer id = userService.getIDByName(userService.getNameByCookie(request));
            System.out.println(id);
            selfStockingMapper.deleteStockCode(id, code);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
