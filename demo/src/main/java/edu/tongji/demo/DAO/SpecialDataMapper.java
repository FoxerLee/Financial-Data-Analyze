package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


@Mapper
public interface SpecialDataMapper {

    @Select("select * from cashflow_data")
    ArrayList<CashFlowData> getCashFlowData();

    @Select("select * from debtpaying_data")
    ArrayList<DebtPayingData> getDebtPayingData();

    @Select("select * from growth_data")
    ArrayList<GrowthData> getGrowthData();

    @Select("select * from operation_data")
    ArrayList<OperationData> getOperationData();

    @Select("select * from profile_data")
    ArrayList<ProfileData> getProfileData();
}
