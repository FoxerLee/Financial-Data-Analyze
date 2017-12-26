package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.*;
import edu.tongji.demo.Security.Verification;
import edu.tongji.demo.Service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/special")
public class SpecialDataController {

    @Autowired
    private SpecialService specialService;

    @GetMapping("/cashflow")
    public Object getCashFlowData(){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<CashFlowData> cashFlowData = specialService.getCashFloweData();
            int size = cashFlowData.size();
            Object[] rep = new Object[size];
            if (size == 0)
                return null;
            for(int i = 0; i < size; i++){
                Object[] temp = new Object[7];
                temp[0] = cashFlowData.get(i).getCode();
                temp[1] = cashFlowData.get(i).getName();
                temp[2] = cashFlowData.get(i).getCf_sales();
                temp[3] = cashFlowData.get(i).getRateofreturn();
                temp[4] = cashFlowData.get(i).getCf_nm();
                temp[5] = cashFlowData.get(i).getCf_liabilities();
                temp[6] = cashFlowData.get(i).getCashflowratio();
                rep[i] = temp;
            }
            return rep;
        }catch (Exception e){
            return "404";
        }

    }

    @GetMapping("/debt")
    public Object getDebtPayingData(){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<DebtPayingData> debtPayingData = specialService.getDebtPayingData();
            int size = debtPayingData.size();
            Object[] rep = new Object[size];
            if (size == 0)
                return null;
            for(int i = 0; i < size; i++){
                Object[] temp = new Object[8];
                temp[0] = debtPayingData.get(i).getCode();
                temp[1] = debtPayingData.get(i).getName();
                temp[2] = debtPayingData.get(i).getCurrentratio();
                temp[3] = debtPayingData.get(i).getQuickratio();
                temp[4] = debtPayingData.get(i).getCashratio();
                temp[5] = debtPayingData.get(i).getIcratio();
                temp[6] = debtPayingData.get(i).getSheqratio();
                temp[7] = debtPayingData.get(i).getAdratio();
                rep[i] = temp;
            }
            return rep;
        }catch (Exception e){
            return "404";
        }
    }

    @GetMapping("/growth")
    public Object getGrowthData(){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<GrowthData> growthData = specialService.getGrowthData();
            int size = growthData.size();
            Object[] rep = new Object[size];
            if (size == 0)
                return null;
            for(int i = 0; i < size; i++){
                Object[] temp = new Object[8];
                temp[0] = growthData.get(i).getCode();
                temp[1] = growthData.get(i).getName();
                temp[2] = growthData.get(i).getMbrg();
                temp[3] = growthData.get(i).getNprg();
                temp[4] = growthData.get(i).getNav();
                temp[5] = growthData.get(i).getTarg();
                temp[6] = growthData.get(i).getEpsg();
                temp[7] = growthData.get(i).getSeg();
                rep[i] = temp;
            }
            return rep;
        }catch (Exception e){
            return "404";
        }
    }

    @GetMapping("/profit")
    public Object getProfileData(){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<ProfileData> profitData = specialService.getProfileData();
            int size = profitData.size();
            Object[] rep = new Object[size];
            if (size == 0)
                return null;
            for(int i = 0; i < size; i++){
                Object[] temp = new Object[9];
                temp[0] = profitData.get(i).getCode();
                temp[1] = profitData.get(i).getName();
                temp[2] = profitData.get(i).getRoe();
                temp[3] = profitData.get(i).getNet_profit_ratio();
                temp[4] = profitData.get(i).getGross_profit_ratio();
                temp[5] = profitData.get(i).getNet_profits();
                temp[6] = profitData.get(i).getEps();
                temp[7] = profitData.get(i).getBusiness_income();
                temp[8] = profitData.get(i).getBips();
                rep[i] = temp;
            }
            return rep;
        }catch (Exception e){
            return "404";
        }
    }

    @GetMapping("/operation")
    public Object getOperationData(){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<OperationData> operationData = specialService.getOperationData();
            int size = operationData.size();
            Object[] rep = new Object[size];
            if (size == 0)
                return null;
            for(int i = 0; i < size; i++){
                Object[] temp = new Object[8];
                temp[0] = operationData.get(i).getCode();
                temp[1] = operationData.get(i).getName();
                temp[2] = operationData.get(i).getArturnover();
                temp[3] = operationData.get(i).getArturndays();
                temp[4] = operationData.get(i).getInventory_turnover();
                temp[5] = operationData.get(i).getInventory_days();
                temp[6] = operationData.get(i).getCurrentasset_turnover();
                temp[7] = operationData.get(i).getCurrentasset_days();
                rep[i] = temp;
            }
            return rep;
        }catch (Exception e){
            return "404";
        }
    }
}
