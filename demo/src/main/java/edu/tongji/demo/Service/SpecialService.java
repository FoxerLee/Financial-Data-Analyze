package edu.tongji.demo.Service;

import edu.tongji.demo.Model.*;

import java.util.ArrayList;

public interface SpecialService {

    ArrayList<CashFlowData> getCashFloweData();

    ArrayList<DebtPayingData> getDebtPayingData();

    ArrayList<GrowthData> getGrowthData();

    ArrayList<OperationData> getOperationData();

    ArrayList<ProfileData> getProfileData();
}
