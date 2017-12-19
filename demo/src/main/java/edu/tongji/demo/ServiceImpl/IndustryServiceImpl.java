package edu.tongji.demo.ServiceImpl;

import edu.tongji.demo.DAO.IndustryMapper;
import edu.tongji.demo.Model.Industry;
import edu.tongji.demo.Service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    @Override
    public ArrayList<Industry> getAllIndustry(){
        return industryMapper.getAllIndustryInfor();
    }
}
