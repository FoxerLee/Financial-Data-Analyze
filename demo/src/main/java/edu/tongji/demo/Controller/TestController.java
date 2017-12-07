package edu.tongji.demo.Controller;

import edu.tongji.demo.Mapping.CompanyInfoMapper;
import edu.tongji.demo.Mapping.ConnectMapper;
import edu.tongji.demo.Model.CompanyInfo;
import edu.tongji.demo.Model.Connect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    private ConnectMapper connectMapper;

    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    @GetMapping(value = "/test")
    public Object Test(){
        ArrayList<Connect> connectArrayList = connectMapper.getData("000001");
        return connectArrayList;
    }

    @GetMapping(value = "/temp")
    public Object Temp(){
        ArrayList<CompanyInfo> companyInfos = companyInfoMapper.getData("000001");
        return companyInfos;
    }
}
