package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.IndustryService;
import edu.tongji.demo.Service.StockService;
import edu.tongji.demo.Service.UserService;
import edu.tongji.demo.Security.Verification;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/stock")
@CrossOrigin
public class StockController {

    @Autowired
    private UserService userService;

    @Autowired
    private StockService stockService;

    @Autowired
    private IndustryService industryService;

    @GetMapping("/all")
    public Object GetAllStockInfo(){
        if (!Verification.verify())
            return "400";
        try{
            Boolean judge = Verification.verify();
            if (!judge)
                return "400";
            else
                return industryService.getAllIndustry();
        }catch (Exception e){
            return "404";
        }
    }
        /**
     * 通过code或者name获得connect的信息
     * @param content
     * @return
     */
    @PostMapping("/one")
    public Object GetSpecificInfo(@RequestBody String content){
        if (!Verification.verify())
            return "400";
        else{
            return stockService.getStockByNameOrCode(content);
        }
    }

    /**
     * 根据行业名称返回该行业股票以及它们的周信息
     * @param name
     * @return
     */
    @GetMapping("/industry")
    public Object GetStocksOfIndustry(@RequestParam(value = "name", defaultValue = "化工行业")  String name){
        if (!Verification.verify())
            return "400";
        else {
            return stockService.getStocksOfIndustry(name);
        }
    }

    /**
     * 获取某只股票的最新信息，根据code
     * @param code
     * @return
     */
    @GetMapping(value = "/brief")
    public Object getBrief(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        try{
            return stockService.getStockBriefInformation(code);
        }catch (Exception e){
            return "400";
        }
    }

    /**
     * 获得股票的历史数据来画日K图
     * @param code
     * @return
     */
    @GetMapping(value = "/history")
    public Object getHistory(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        try{
            return stockService.getStocksHistory(code);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 根据code获取股票名称
     * @param code
     * @return
     */
    @GetMapping(value = "/name")
    public Object getStockName(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        return stockService.getStockNameByCode(code);
    }

    /**
     * 返回用户持有股票的信息
     */
    @GetMapping("/user")
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
}