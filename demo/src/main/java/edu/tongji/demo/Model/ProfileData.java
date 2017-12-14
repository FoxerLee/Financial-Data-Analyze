package edu.tongji.demo.Model;

public class ProfileData {
    private Integer id;

    private String code;

    private String name;

    private Double roe;

    private Double net_profitRatio;

    private Double gross_profitRatio;

    private Double net_profits;

    private Double eps;

    private Double business_income;

    private Double bips;

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

    public Double getRoe() {
        return roe;
    }

    public void setRoe(Double roe) {
        this.roe = roe;
    }

    public Double getNet_profitRatio() {
        return net_profitRatio;
    }

    public void setNet_profitRatio(Double net_profitRatio) {
        this.net_profitRatio = net_profitRatio;
    }

    public Double getGross_profitRatio() {
        return gross_profitRatio;
    }

    public void setGross_profitRatio(Double gross_profitRatio) {
        this.gross_profitRatio = gross_profitRatio;
    }

    public Double getNet_profits() {
        return net_profits;
    }

    public void setNet_profits(Double net_profits) {
        this.net_profits = net_profits;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getBusiness_income() {
        return business_income;
    }

    public void setBusiness_income(Double business_income) {
        this.business_income = business_income;
    }

    public Double getBips() {
        return bips;
    }

    public void setBips(Double bips) {
        this.bips = bips;
    }
}