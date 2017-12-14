package edu.tongji.demo.Model;

public class CashFlowData {
    private Integer id;

    private String code;

    private String name;

    private Double cf_sales;

    private Double rateofreturn;

    private Double cf_nm;

    private Double cf_liabilities;

    private Double cashflowratio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getRateofreturn() {
        return rateofreturn;
    }

    public void setRateofreturn(Double rateofreturn) {
        this.rateofreturn = rateofreturn;
    }

    public Double getCashflowratio() {
        return cashflowratio;
    }

    public void setCashflowratio(Double cashflowratio) {
        this.cashflowratio = cashflowratio;
    }

    public Double getCf_sales() {
        return cf_sales;
    }

    public void setCf_sales(Double cf_sales) {
        this.cf_sales = cf_sales;
    }

    public Double getCf_nm() {
        return cf_nm;
    }

    public void setCf_nm(Double cf_nm) {
        this.cf_nm = cf_nm;
    }

    public Double getCf_liabilities() {
        return cf_liabilities;
    }

    public void setCf_liabilities(Double cf_liabilities) {
        this.cf_liabilities = cf_liabilities;
    }
}