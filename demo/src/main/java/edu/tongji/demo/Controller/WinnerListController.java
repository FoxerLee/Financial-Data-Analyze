package edu.tongji.demo.Controller;

import edu.tongji.demo.DAO.WinnerListMapper;
import edu.tongji.demo.Model.WinnerList;
import edu.tongji.demo.Service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/winner")
public class WinnerListController {

    @Autowired
    private WinnerService winnerService;

    @GetMapping(value = "/all")
    public Object getAll(){
        try{
            return winnerService.getWinnerListByCookie();
        } catch (Exception e){
            return null;
        }
    }
}