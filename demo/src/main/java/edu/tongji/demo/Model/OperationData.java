package edu.tongji.demo.Model;

public class OperationData {
    private Integer id;

    private String code;

    private String name;

    private Double arturnover;

    private Double arturndays;

    private Double inventoryTurnover;

    private Double inventoryDays;

    private Double currentassetTurnover;

    private Double currentassetDays;

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

    public Double getInventoryTurnover() {
        return inventoryTurnover;
    }

    public void setInventoryTurnover(Double inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
    }

    public Double getInventoryDays() {
        return inventoryDays;
    }

    public void setInventoryDays(Double inventoryDays) {
        this.inventoryDays = inventoryDays;
    }

    public Double getCurrentassetTurnover() {
        return currentassetTurnover;
    }

    public void setCurrentassetTurnover(Double currentassetTurnover) {
        this.currentassetTurnover = currentassetTurnover;
    }

    public Double getCurrentassetDays() {
        return currentassetDays;
    }

    public void setCurrentassetDays(Double currentassetDays) {
        this.currentassetDays = currentassetDays;
    }
}