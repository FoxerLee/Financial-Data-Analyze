package edu.tongji.demo.Model;

import java.util.Date;

public class DataDays {
    private Integer id;

    private String code;

    private Date trading_day;

    private Double open_value;

    private Double close_value;

    private Double high_value;

    private Double low_value;

    private Double volume_value;

    private String name;

    private String c_name;

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

    public Date getTrading_day() {
        return trading_day;
    }

    public void setTrading_day(Date trading_day) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}