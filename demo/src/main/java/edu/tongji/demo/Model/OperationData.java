package edu.tongji.demo.Model;

public class OperationData {
    private Integer id;

    private String code;

    private String name;

    private Double arturnover;

    private Double arturndays;

    private Double inventory_turnover;

    private Double inventory_days;

    private Double currentasset_turnover;

    private Double currentasset_days;

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

    public Double getArturnover() {
        return arturnover;
    }

    public void setArturnover(Double arturnover) {
        this.arturnover = arturnover;
    }

    public Double getArturndays() {
        return arturndays;
    }

    public void setArturndays(Double arturndays) {
        this.arturndays = arturndays;
    }

    public Double getInventory_turnover() {
        return inventory_turnover;
    }

    public void setInventory_turnover(Double inventory_turnover) {
        this.inventory_turnover = inventory_turnover;
    }

    public Double getInventory_days() {
        return inventory_days;
    }

    public void setInventory_days(Double inventory_days) {
        this.inventory_days = inventory_days;
    }

    public Double getCurrentasset_turnover() {
        return currentasset_turnover;
    }

    public void setCurrentasset_turnover(Double currentasset_turnover) {
        this.currentasset_turnover = currentasset_turnover;
    }

    public Double getCurrentasset_days() {
        return currentasset_days;
    }

    public void setCurrentasset_days(Double currentasset_days) {
        this.currentasset_days = currentasset_days;
    }
}