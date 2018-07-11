package com.joyo.pojo;

import java.io.Serializable;
import java.util.List;

public class Area implements Serializable{

    private Integer areaid;

    private String addressnumber;

  
    private String areaname;

    private String arealevel;


    private String higherareanumber;


    private String higherareaname;

    private String validtags;
    
    private List <HistoricalRecords> historicalrecordss;

     
    public Area() {
    	super();
    }
    public Integer getAreaid() {
        return areaid;
    }


    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAddressnumber() {
        return addressnumber;
    }

    public void setAddressnumber(String addressnumber) {
        this.addressnumber = addressnumber;
    }


    public String getAreaname() {
        return areaname;
    }


    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }


    public String getArealevel() {
        return arealevel;
    }

    public void setArealevel(String arealevel) {
        this.arealevel = arealevel;
    }

    public String getHigherareanumber() {
        return higherareanumber;
    }

 
    public void setHigherareanumber(String higherareanumber) {
        this.higherareanumber = higherareanumber;
    }

   
    public String getHigherareaname() {
        return higherareaname;
    }


    public void setHigherareaname(String higherareaname) {
        this.higherareaname = higherareaname;
    }

 
    public String getValidtags() {
        return validtags;
    }

    public void setValidtags(String validtags) {
        this.validtags = validtags;
    }
	public List <HistoricalRecords> getHistoricalrecordss() {
		return historicalrecordss;
	}
	public void setHistoricalrecordss(List <HistoricalRecords> historicalrecordss) {
		this.historicalrecordss = historicalrecordss;
	}

	@Override
	public String toString() {
		return "Area [areaid=" + areaid + ", addressnumber=" + addressnumber + 
				", areaname=" + areaname + ", arealevel=" + arealevel 
				+ ",higherareanumber= " + higherareanumber + ",validtags=" + validtags + "]";
	}



}