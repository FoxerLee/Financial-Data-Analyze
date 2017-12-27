package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.IndustryService;
import edu.tongji.demo.Service.StockService;
import edu.tongji.demo.Service.UserService;
import edu.tongji.demo.Security.Verification;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stock")
public class StockController {
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
     * ͨ��code����name���connect����Ϣ
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
     * ������ҵ���Ʒ��ظ���ҵ��Ʊ�Լ����ǵ�����Ϣ
     * @param name
     * @return
     */
    @GetMapping("/industry")
    public Object GetStocksOfIndustry(@RequestParam(value = "name", defaultValue = "������ҵ")  String name){
        if (!Verification.verify())
            return "400";
        else {
            return stockService.getStocksOfIndustry(name);
        }
    }

    /**
     * ��ȡĳֻ��Ʊ��������Ϣ������code
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
     * ��ù�Ʊ����ʷ����������Kͼ
     * @param code
     * @return
     */
    @GetMapping(value = "/history/days")
    public Object getHistoryDays(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        try{
            return stockService.getStocksHistory(code, 1);
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping(value = "/history/weeks")
    public Object getHistoryWeeks(@Param(value = "code")String code){
        if(!Verification.verify())
            return "400";
        try{
            return stockService.getStocksHistory(code, 2);
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping(value = "/history/months")
    public Object getHistoryMonths(@Param(value = "code")String code){
        if(!Verification.verify())
            return "400";
        try{
            return stockService.getStocksHistory(code, 3);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * ����code��ȡ��Ʊ����
     * @param code
     * @return
     */
    @GetMapping(value = "/name")
    public Object getStockName(@Param(value = "code") String code){
        if (!Verification.verify())
            return "400";
        return stockService.getStockNameByCode(code);
    }

    @GetMapping(value = "/predict")
    public Object getPredicton(@RequestParam(value = "code", defaultValue = "000001")String code){
        if (!Verification.verify())
            return "400";
        return stockService.getPredict(code);
    }

}