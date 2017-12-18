package edu.tongji.demo.Service;

import edu.tongji.demo.DAO.IndustryMapper;
import edu.tongji.demo.Model.Industry;
import edu.tongji.demo.ServiceInterface.IndustryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IndustryService implements IndustryServiceInterface{

    @Autowired
    private IndustryMapper industryMapper;

    @Override
    public ArrayList<Industry> getAllIndustry(){
        return industryMapper.getAllIndustryInfor();
    }
}
