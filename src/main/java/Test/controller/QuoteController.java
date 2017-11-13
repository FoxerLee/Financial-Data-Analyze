package Test.controller;

import Test.Repositories.QuoteRepository;
import Test.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test/*")
public class QuoteController {
    class DataSet{
        private Date trading_day;
        private BigDecimal volume_value;
        private BigDecimal v_ma5;
        private BigDecimal v_ma10;
        private BigDecimal v_ma20;

        public DataSet(Date trading_day, BigDecimal volume_value, BigDecimal v_ma5, BigDecimal v_ma10, BigDecimal v_ma20) {
            this.trading_day = trading_day;
            this.volume_value = volume_value;
            this.v_ma5 = v_ma5;
            this.v_ma10 = v_ma10;
            this.v_ma20 = v_ma20;
        }

        public Date getTrading_day() {
            return trading_day;
        }

        public void setTrading_day(Date trading_day) {
            this.trading_day = trading_day;
        }

        public BigDecimal getVolume_value() {
            return volume_value;
        }

        public void setVolume_value(BigDecimal volume_value) {
            this.volume_value = volume_value;
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
    }

    @Autowired
    QuoteRepository quoteRepository;

    @GetMapping("index")
    public ModelAndView createTable(){
        return new ModelAndView("/templates/echart.html");
    }

    @GetMapping("getData")
    public List getData(){
        List<Quote> q = quoteRepository.findQuotesByCode("900906");
        List rowData = new ArrayList<>();
        for(Quote m : q){
            List temp = new ArrayList();
            temp.add(m.getQuotePK().formatDate());
            temp.add(m.getVolume_value());
            temp.add(m.getV_ma5());
            temp.add(m.getV_ma10());
            temp.add(m.getV_ma20());
            rowData.add(temp);
        }
        return rowData;
    }
}
