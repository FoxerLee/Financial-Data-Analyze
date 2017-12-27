package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.*;
import edu.tongji.demo.Security.Verification;
import edu.tongji.demo.Service.SpecialService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/special")
public class SpecialDataController {

    private static int RECORD_PER_PAGE = 20;

    @Autowired
    private SpecialService specialService;

    @GetMapping("/cashflow")
    public Object getCashFlowData(@RequestParam(value = "page", defaultValue = "1") String page){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<CashFlowData> cashFlowData = specialService.getCashFloweData();
            int size = cashFlowData.size();
            Object[] rep = new Object[RECORD_PER_PAGE];
            int p = Integer.parseInt(page);
            if (p <= 0)
                return null;
            int j = 0;
            for(int i = (p - 1) * RECORD_PER_PAGE; i < p * RECORD_PER_PAGE && i < size; i++, j++){
                Object[] temp = new Object[7];
                temp[0] = cashFlowData.get(i).getCode();
                temp[1] = cashFlowData.get(i).getName();
                temp[2] = cashFlowData.get(i).getCf_sales();
                temp[3] = cashFlowData.get(i).getRateofreturn();
                temp[4] = cashFlowData.get(i).getCf_nm();
                temp[5] = cashFlowData.get(i).getCf_liabilities();
                temp[6] = cashFlowData.get(i).getCashflowratio();
                rep[j] = temp;
            }
            HashMap<String, Object> result = new HashMap<>();
            int t = size%RECORD_PER_PAGE;
            if(t > 0)
                t = size/RECORD_PER_PAGE + 1;
            else
                t = size/RECORD_PER_PAGE;
            result.put("page", p);
            result.put("data",rep);
            result.put("total", t);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/debt")
    public Object getDebtPayingData(@RequestParam(value = "page", defaultValue = "1")String page){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<DebtPayingData> debtPayingData = specialService.getDebtPayingData();
            int size = debtPayingData.size();
            Object[] rep = new Object[RECORD_PER_PAGE];
            int p = Integer.parseInt(page);
            if(p <= 0)
                return null;
            int j = 0;
            for(int i = (p - 1)*RECORD_PER_PAGE; i < p * RECORD_PER_PAGE && i < size; i++, j++){
                Object[] temp = new Object[8];
                temp[0] = debtPayingData.get(i).getCode();
                temp[1] = debtPayingData.get(i).getName();
                temp[2] = debtPayingData.get(i).getCurrentratio();
                temp[3] = debtPayingData.get(i).getQuickratio();
                temp[4] = debtPayingData.get(i).getCashratio();
                temp[5] = debtPayingData.get(i).getIcratio();
                temp[6] = debtPayingData.get(i).getSheqratio();
                temp[7] = debtPayingData.get(i).getAdratio();
                rep[j] = temp;
            }
            HashMap<String, Object> result = new HashMap<>();
            int t = size%RECORD_PER_PAGE;
            if(t > 0)
                t = size/RECORD_PER_PAGE + 1;
            else
                t = size/RECORD_PER_PAGE;
            result.put("page",p);
            result.put("data",rep);
            result.put("total", t);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/growth")
    public Object getGrowthData(@RequestParam(value = "page", defaultValue = "1")String page){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<GrowthData> growthData = specialService.getGrowthData();
            int size = growthData.size();
            Object[] rep = new Object[RECORD_PER_PAGE];
            int p = Integer.parseInt(page);
            if(p <= 0)
                return null;
            int j = 0;
            for(int i = (p - 1)*RECORD_PER_PAGE; i < p * RECORD_PER_PAGE && i < size; i++, j++){
                Object[] temp = new Object[8];
                temp[0] = growthData.get(i).getCode();
                temp[1] = growthData.get(i).getName();
                temp[2] = growthData.get(i).getMbrg();
                temp[3] = growthData.get(i).getNprg();
                temp[4] = growthData.get(i).getNav();
                temp[5] = growthData.get(i).getTarg();
                temp[6] = growthData.get(i).getEpsg();
                temp[7] = growthData.get(i).getSeg();
                rep[j] = temp;
            }
            HashMap<String, Object> result = new HashMap<>();
            int t = size%RECORD_PER_PAGE;
            if(t > 0)
                t = size/RECORD_PER_PAGE + 1;
            else
                t = size/RECORD_PER_PAGE;
            result.put("page", p);
            result.put("data",rep);
            result.put("total", t);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/profit")
    public Object getProfileData(@RequestParam(value = "page", defaultValue = "1")String page){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<ProfileData> profitData = specialService.getProfileData();
            int size = profitData.size();
            Object[] rep = new Object[RECORD_PER_PAGE];
            int p = Integer.parseInt(page);
            if(p <= 0)
                return null;
            int j = 0;
            for(int i = (p - 1)*RECORD_PER_PAGE; i < p * RECORD_PER_PAGE && i < size; i++, j++){
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
                rep[j] = temp;
            }
            HashMap<String, Object> result = new HashMap<>();
            int t = size%RECORD_PER_PAGE;
            if(t > 0)
                t = size/RECORD_PER_PAGE + 1;
            else
                t = size/RECORD_PER_PAGE;
            result.put("page", p);
            result.put("data",rep);
            result.put("total", t);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/operation")
    public Object getOperationData(@RequestParam(value = "page", defaultValue = "1")String page){
        if(!Verification.verify())
            return "400";
        try{
            ArrayList<OperationData> operationData = specialService.getOperationData();
            int size = operationData.size();
            Object[] rep = new Object[RECORD_PER_PAGE];
            int p = Integer.parseInt(page);
            if(p <= 0)
                return null;
            int j = 0;
            for(int i = (p - 1)*RECORD_PER_PAGE; i < p * RECORD_PER_PAGE && i < size; i++, j++){
                Object[] temp = new Object[8];
                temp[0] = operationData.get(i).getCode();
                temp[1] = operationData.get(i).getName();
                temp[2] = operationData.get(i).getArturnover();
                temp[3] = operationData.get(i).getArturndays();
                temp[4] = operationData.get(i).getInventory_turnover();
                temp[5] = operationData.get(i).getInventory_days();
                temp[6] = operationData.get(i).getCurrentasset_turnover();
                temp[7] = operationData.get(i).getCurrentasset_days();
                rep[j] = temp;
            }
            HashMap<String, Object> result = new HashMap<>();
            int t = size%RECORD_PER_PAGE;
            if(t > 0)
                t = size/RECORD_PER_PAGE + 1;
            else
                t = size/RECORD_PER_PAGE;
            result.put("page", p);
            result.put("data",rep);
            result.put("total", t);
            return result;
        }catch (Exception e){
            return null;
        }
    }
}
