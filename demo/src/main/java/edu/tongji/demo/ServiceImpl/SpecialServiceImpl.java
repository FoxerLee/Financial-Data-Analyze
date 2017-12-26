package edu.tongji.demo.ServiceImpl;

import edu.tongji.demo.DAO.SpecialDataMapper;
import edu.tongji.demo.Model.*;
import edu.tongji.demo.Service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SpecialServiceImpl implements SpecialService{

    @Autowired
    private SpecialDataMapper specialDataMapper;

    @Override
    public ArrayList<CashFlowData> getCashFloweData(){
        return specialDataMapper.getCashFlowData();
    }

    @Override
    public ArrayList<DebtPayingData> getDebtPayingData(){
        return specialDataMapper.getDebtPayingData();
    }

    @Override
    public ArrayList<GrowthData> getGrowthData(){
        return specialDataMapper.getGrowthData();
    }

    public ArrayList<OperationData> getOperationData(){
        return specialDataMapper.getOperationData();
    }

    @Override
    public ArrayList<ProfileData> getProfileData(){
        return specialDataMapper.getProfileData();
    }


}
