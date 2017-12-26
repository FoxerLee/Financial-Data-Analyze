package edu.tongji.demo.Controller;

import edu.tongji.demo.Security.Verification;
import edu.tongji.demo.Service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/special")
public class SpecialDataController {

    @Autowired
    private SpecialService specialService;

    @GetMapping("/cashflow")
    public Object getCashFlowData(){
        if(!Verification.verify())
            return "400";
        return specialService.getCashFloweData();
    }

    @GetMapping("/debt")
    public Object getDebtPayingData(){
        if(!Verification.verify())
            return "400";
        return specialService.getDebtPayingData();
    }

    @GetMapping("/growth")
    public Object getGrowthData(){
        if(!Verification.verify())
            return "400";
        return specialService.getGrowthData();
    }

    @GetMapping("/profit")
    public Object getProfileData(){
        if(!Verification.verify())
            return "400";
        return specialService.getProfileData();
    }

    @GetMapping("/operation")
    public Object getOperationData(){
        if(!Verification.verify())
            return "400";
        return specialService.getOperationData();
    }

}
