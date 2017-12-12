package edu.tongji.demo.Models;

import java.util.Date;

public class BriefDataDays {
    private String code;
    private Date trading_day;
    private Double volume_value;
    private String name;
    private String c_name;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Date getTradingDay() {
        return trading_day;
    }
    public void setTradingDay(Date tradingDay) {
        this.trading_day = tradingDay;
    }
    public Double getVolume() {
        return volume_value;
    }
    public void setVolume(double volume) {
        this.volume_value = volume;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getcName() {
        return c_name;
    }
    public void setcName(String cName) {
        this.c_name = cName;
    }
}
