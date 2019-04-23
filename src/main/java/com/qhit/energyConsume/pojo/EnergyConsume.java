package com.qhit.energyConsume.pojo;


/** 
* Created by GeneratorCode on 2019/04/10
*/ 

public class EnergyConsume { 
    private Integer consumeid;    //主键能耗id 
    private Integer devid;    //设备名称 
    private Double electric;    //电耗(kw.h) 
    private Double water;    //水耗(吨) 
    private Double oil;    //油耗(L) 
    private Integer reportid;    //报岗id
    private String devname;
    private String fc;
    private String flowname;
    private String typename;

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getFlowname() {
        return flowname;
    }

    public void setFlowname(String flowname) {
        this.flowname = flowname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getConsumeid() {
        return consumeid;
    }

    public void setConsumeid(Integer consumeid) { 
        this.consumeid = consumeid;
    } 

    public Integer getDevid() { 
        return devid;
    }

    public void setDevid(Integer devid) { 
        this.devid = devid;
    } 

    public Double getElectric() { 
        return electric;
    }

    public void setElectric(Double electric) { 
        this.electric = electric;
    } 

    public Double getWater() { 
        return water;
    }

    public void setWater(Double water) { 
        this.water = water;
    } 

    public Double getOil() { 
        return oil;
    }

    public void setOil(Double oil) { 
        this.oil = oil;
    } 

    public Integer getReportid() { 
        return reportid;
    }

    public void setReportid(Integer reportid) { 
        this.reportid = reportid;
    } 


 }