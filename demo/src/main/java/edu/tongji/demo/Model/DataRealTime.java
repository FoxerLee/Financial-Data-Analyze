package edu.tongji.demo.Model;

import java.util.Date;

public class DataRealTime {
    private Integer id;

    private String code;

    private String trading_day;

    private Double open_value;

    private Double close_value;

    private Double high_value;

    private Double low_value;

    private Double volume_value;

    private Double p_change;

    private Double turnoverratio;

    private Double amount;

    private Double per;

    private Double pb;

    private Double mktcap;

    private Double nmc;

    private Double settlement;

    public Double getSettlement() {
        return settlement;
    }

    public void setSettlement(Double settlement) {
        this.settlement = settlement;
    }

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

    public String getTrading_day() {
        return trading_day;
    }

    public void setTrading_day(String trading_day) {
        this.trading_day = trading_day;
    }

    public Double getOpen_value() {
        return open_value;
    }

    public void setOpen_value(Double open_value) {
        this.open_value = open_value;
    }

    public Double getClose_value() {
        return close_value;
    }

    public void setClose_value(Double close_value) {
        this.close_value = close_value;
    }

    public Double getHigh_value() {
        return high_value;
    }

    public void setHigh_value(Double high_value) {
        this.high_value = high_value;
    }

    public Double getLow_value() {
        return low_value;
    }

    public void setLow_value(Double low_value) {
        this.low_value = low_value;
    }

    public Double getVolume_value() {
        return volume_value;
    }

    public void setVolume_value(Double volume_value) {
        this.volume_value = volume_value;
    }

    public Double getP_change() {
        return p_change;
    }

    public void setP_change(Double p_change) {
        this.p_change = p_change;
    }

    public Double getTurnoverratio() {
        return turnoverratio;
    }

    public void setTurnoverratio(Double turnoverratio) {
        this.turnoverratio = turnoverratio;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPer() {
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    public Double getPb() {
        return pb;
    }

    public void setPb(Double pb) {
        this.pb = pb;
    }

    public Double getMktcap() {
        return mktcap;
    }

    public void setMktcap(Double mktcap) {
        this.mktcap = mktcap;
    }

    public Double getNmc() {
        return nmc;
    }

    public void setNmc(Double nmc) {
        this.nmc = nmc;
    }
}