package edu.tongji.demo.Models;

public class Connect {
    private String code;

    private String name;

    private String c_name;

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

    public String getcName() {
        return c_name;
    }

    public void setcName(String cName) {
        this.c_name = cName == null ? null : cName.trim();
    }
}