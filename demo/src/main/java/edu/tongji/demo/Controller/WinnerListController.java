package edu.tongji.demo.Controller;

import edu.tongji.demo.ServiceImpl.WinnerServiceImpl;
import edu.tongji.demo.Security.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winner")
public class WinnerListController {

    @Autowired
    private WinnerServiceImpl winnerServiceImpl;

    @GetMapping(value = "/all")
    public Object getAll(){
        if (!Verification.verify())
            return "400";
        try{
            return winnerServiceImpl.getWinnerListByCookie();
        } catch (Exception e){
            return null;
        }
    }
}