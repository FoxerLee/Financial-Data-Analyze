package edu.tongji.demo.Model;

public class Industry {
    private Integer id;

    private String name;

    private Double price;

    private String price_range;

    private Double turnover;

    private Double turnover_p;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceRange() {
        return price_range;
    }

    public void setPriceRange(String priceRange) {
        this.price_range = priceRange == null ? null : priceRange.trim();
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getTurnoverP() {
        return turnover_p;
    }

    public void setTurnoverP(Double turnoverP) {
        this.turnover_p = turnoverP;
    }
}