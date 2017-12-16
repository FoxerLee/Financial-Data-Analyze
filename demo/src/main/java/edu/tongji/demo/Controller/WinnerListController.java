package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapper.WinnerListMapper;
import edu.tongji.demo.Model.WinnerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/winner")
public class WinnerListController {

    @Autowired
    private WinnerListMapper winnerListMapper;

//    @GetMapping(value = "/all")
//    public Object getAll(){
//        ArrayList<WinnerList> data = winnerListMapper.getAll();
//        ArrayList<String> reasons = new ArrayList<String>();
//        for(int)
//    }
}