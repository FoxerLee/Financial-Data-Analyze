package Test.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Embeddable
public class QuotePK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private Date trading_day;

    public QuotePK(){}

    public QuotePK(String code, Date trading_day){
        this.code = code;
        this.trading_day = trading_day;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTrading_day() {
        return trading_day;
    }

    public void setTrading_day(Date trading_day) {
        this.trading_day = trading_day;
    }

    public String formatDate(){
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
        df.applyPattern("yyyy-MM-dd");
        String date = df.format(trading_day);
        return date;
    }
}
