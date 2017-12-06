package edu.tongji.demo.Model;

import java.util.Date;

public class WarehouseDataRealTime {
    private Integer id;

    private String code;

    private Date tradingDay;

    private Double openValue;

    private Double closeValue;

    private Double highValue;

    private Double lowValue;

    private Double volumeValue;

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

    public Date getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        this.tradingDay = tradingDay;
    }

    public Double getOpenValue() {
        return openValue;
    }

    public void setOpenValue(Double openValue) {
        this.openValue = openValue;
    }

    public Double getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(Double closeValue) {
        this.closeValue = closeValue;
    }

    public Double getHighValue() {
        return highValue;
    }

    public void setHighValue(Double highValue) {
        this.highValue = highValue;
    }

    public Double getLowValue() {
        return lowValue;
    }

    public void setLowValue(Double lowValue) {
        this.lowValue = lowValue;
    }

    public Double getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(Double volumeValue) {
        this.volumeValue = volumeValue;
    }
}