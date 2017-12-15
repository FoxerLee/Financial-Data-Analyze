package edu.tongji.demo.Model;

import java.util.Date;

public class Research {
    private Integer id;

    private String code;

    private String title;

    private String url;

    private String date;

    private String inst;

    private String researcher;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst == null ? null : inst.trim();
    }

    public String getResearcher() {
        return researcher;
    }

    public void setResearcher(String researcher) {
        this.researcher = researcher == null ? null : researcher.trim();
    }
}