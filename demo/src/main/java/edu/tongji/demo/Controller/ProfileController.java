package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.SelfStockService;
import edu.tongji.demo.Service.StockService;
import edu.tongji.demo.Service.UserService;
import edu.tongji.demo.Security.Verification;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private StockService stockService;

    @Autowired
    private SelfStockService selfStockService;

    /**
     * 返回用户持有股票的信息
     */
    @GetMapping("/stock/check")
    public Object getPersonalStocks(HttpServletRequest request){
        if (!Verification.verify())
            return "400";
        else{
            String name = userService.getNameByCookie(request);
            if (name.equals(""))
                return null;
            int id = userService.getIDByName(name);
            if (id < 0)
                return null;
            else{
                try{
                    return stockService.getStocksByUserID(id);
                }catch (Exception e){
                    return null;
                }
            }
        }
    }

    @GetMapping("/stock/add")
    public Object addSelfStock(@Param(value = "code") String code, HttpServletRequest request){
        if(!Verification.verify())
            return "400";
        return selfStockService.addStockByCode(code, request);
    }

    @DeleteMapping("/stock/delete")
    public Object deleteSelfStock(@Param(value = "code") String code, HttpServletRequest request){
        if(!Verification.verify())
            return "400";
        return selfStockService.deleteStockByCode(code, request);
    }

    @GetMapping("/check")
    public Object checkUserInformation(HttpServletRequest request){
        if (!Verification.verify())
            return "400";
        return userService.getUserInformation(request);
    }
}
