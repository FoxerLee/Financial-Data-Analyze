package edu.tongji.demo.Model;

public class CashFlowData {
    private Integer id;

    private String code;

    private String name;

    private Double cfSales;

    private Double rateofreturn;

    private Double cfNm;

    private Double cfLiabilities;

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

    public Double getCfSales() {
        return cfSales;
    }

    public void setCfSales(Double cfSales) {
        this.cfSales = cfSales;
    }

    public Double getRateofreturn() {
        return rateofreturn;
    }

    public void setRateofreturn(Double rateofreturn) {
        this.rateofreturn = rateofreturn;
    }

    public Double getCfNm() {
        return cfNm;
    }

    public void setCfNm(Double cfNm) {
        this.cfNm = cfNm;
    }

    public Double getCfLiabilities() {
        return cfLiabilities;
    }

    public void setCfLiabilities(Double cfLiabilities) {
        this.cfLiabilities = cfLiabilities;
    }

    public Double getCashflowratio() {
        return cashflowratio;
    }

    public void setCashflowratio(Double cashflowratio) {
        this.cashflowratio = cashflowratio;
    }
}