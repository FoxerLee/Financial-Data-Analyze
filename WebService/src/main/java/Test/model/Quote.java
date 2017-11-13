package Test.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Historical_Quotes")
public class Quote implements Serializable{
    @EmbeddedId
    private QuotePK quotePK;
    @Column(precision = 30, scale = 10)
    private BigDecimal open_value;
    @Column(precision = 30, scale = 10)
    private BigDecimal high_value;
    @Column(precision = 30, scale = 10)
    private BigDecimal close_value;
    @Column(precision = 30, scale = 10)
    private BigDecimal low_value;
    @Column(precision = 30, scale = 10)
    private BigDecimal volume_value;
    @Column(precision = 30, scale = 10)
    private BigDecimal price_change;
    @Column(precision = 30, scale = 10)
    private BigDecimal p_change;
    @Column(precision = 30, scale = 10)
    private BigDecimal ma5;
    @Column(precision = 30, scale = 10)
    private BigDecimal ma10;
    @Column(precision = 30, scale = 10)
    private BigDecimal ma20;
    @Column(precision = 30, scale = 10)
    private BigDecimal v_ma5;
    @Column(precision = 30, scale = 10)
    private BigDecimal v_ma10;
    @Column(precision = 30, scale = 10)
    private BigDecimal v_ma20;
    @Column(precision = 30, scale = 10)
    private BigDecimal turnover;

    public Quote(){}

    public QuotePK getQuotePK() {
        return quotePK;
    }

    public void setQuotePK(QuotePK quotePK) {
        this.quotePK = quotePK;
    }

    public BigDecimal getOpen_value() {
        return open_value;
    }

    public void setOpen_value(BigDecimal open_value) {
        this.open_value = open_value;
    }

    public BigDecimal getHigh_value() {
        return high_value;
    }

    public void setHigh_value(BigDecimal high_value) {
        this.high_value = high_value;
    }

    public BigDecimal getClose_value() {
        return close_value;
    }

    public void setClose_value(BigDecimal close_value) {
        this.close_value = close_value;
    }

    public BigDecimal getLow_value() {
        return low_value;
    }

    public void setLow_value(BigDecimal low_value) {
        this.low_value = low_value;
    }

    public BigDecimal getVolume_value() {
        return volume_value;
    }

    public void setVolume_value(BigDecimal volume_value) {
        this.volume_value = volume_value;
    }

    public BigDecimal getPrice_change() {
        return price_change;
    }

    public void setPrice_change(BigDecimal price_change) {
        this.price_change = price_change;
    }

    public BigDecimal getP_change() {
        return p_change;
    }

    public void setP_change(BigDecimal p_change) {
        this.p_change = p_change;
    }

    public BigDecimal getMa5() {
        return ma5;
    }

    public void setMa5(BigDecimal ma5) {
        this.ma5 = ma5;
    }

    public BigDecimal getMa10() {
        return ma10;
    }

    public void setMa10(BigDecimal ma10) {
        this.ma10 = ma10;
    }

    public BigDecimal getMa20() {
        return ma20;
    }

    public void setMa20(BigDecimal ma20) {
        this.ma20 = ma20;
    }

    public BigDecimal getV_ma5() {
        return v_ma5;
    }

    public void setV_ma5(BigDecimal v_ma5) {
        this.v_ma5 = v_ma5;
    }

    public BigDecimal getV_ma10() {
        return v_ma10;
    }

    public void setV_ma10(BigDecimal v_ma10) {
        this.v_ma10 = v_ma10;
    }

    public BigDecimal getV_ma20() {
        return v_ma20;
    }

    public void setV_ma20(BigDecimal v_ma20) {
        this.v_ma20 = v_ma20;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

}
