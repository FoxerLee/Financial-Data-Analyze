package edu.tongji.demo.Model;

public class ProfileData {
    private Integer id;

    private String code;

    private String name;

    private Double roe;

    private Double netProfitRatio;

    private Double grossProfitRatio;

    private Double netProfits;

    private Double eps;

    private Double businessIncome;

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

    public Double getNetProfitRatio() {
        return netProfitRatio;
    }

    public void setNetProfitRatio(Double netProfitRatio) {
        this.netProfitRatio = netProfitRatio;
    }

    public Double getGrossProfitRatio() {
        return grossProfitRatio;
    }

    public void setGrossProfitRatio(Double grossProfitRatio) {
        this.grossProfitRatio = grossProfitRatio;
    }

    public Double getNetProfits() {
        return netProfits;
    }

    public void setNetProfits(Double netProfits) {
        this.netProfits = netProfits;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(Double businessIncome) {
        this.businessIncome = businessIncome;
    }

    public Double getBips() {
        return bips;
    }

    public void setBips(Double bips) {
        this.bips = bips;
    }
}