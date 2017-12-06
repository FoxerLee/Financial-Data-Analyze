package edu.tongji.demo.Model;

public class GrowthData {
    private Integer id;

    private String code;

    private String name;

    private Double mbrg;

    private Double nprg;

    private Double nav;

    private Double targ;

    private Double epsg;

    private Double seg;

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

    public Double getMbrg() {
        return mbrg;
    }

    public void setMbrg(Double mbrg) {
        this.mbrg = mbrg;
    }

    public Double getNprg() {
        return nprg;
    }

    public void setNprg(Double nprg) {
        this.nprg = nprg;
    }

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public Double getTarg() {
        return targ;
    }

    public void setTarg(Double targ) {
        this.targ = targ;
    }

    public Double getEpsg() {
        return epsg;
    }

    public void setEpsg(Double epsg) {
        this.epsg = epsg;
    }

    public Double getSeg() {
        return seg;
    }

    public void setSeg(Double seg) {
        this.seg = seg;
    }
}