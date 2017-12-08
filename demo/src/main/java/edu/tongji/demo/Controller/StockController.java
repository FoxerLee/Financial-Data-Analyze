package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.IndustryMapper;
import edu.tongji.demo.Model.Industry;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/Stock")
public class StockController {

    @Autowired
    private IndustryMapper industryMapper;

    @GetMapping("/GetAll")
    public ArrayList<Industry> GetAllStockInfo(){
        return industryMapper.getAllIndustryInfor();
    }
}
