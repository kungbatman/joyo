package com.joyo.pojo;

import java.io.Serializable;

public class DeviceInformation implements Serializable{


	private Integer deviceid;//设备序号
	
	private String deviceimei;//设备IMEI号
	
	private String deviceuniqueid;//电信平台端设备唯一识别号
	
	private Integer devicetype;
	
	private Integer cal;
	
	private Integer equipmentstate;
	
	private String remark;
	
	private Integer areaid;
	

	public Integer getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}

	public String getDeviceimei() {
		return deviceimei;
	}

	public void setDeviceimei(String deviceimei) {
		this.deviceimei = deviceimei;
	}

	public String getDeviceuniqueid() {
		return deviceuniqueid;
	}

	public void setDeviceuniqueid(String deviceuniqueid) {
		this.deviceuniqueid = deviceuniqueid;
	}

	public Integer getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Integer devicetype) {
		this.devicetype = devicetype;
	}

	public Integer getCal() {
		return cal;
	}

	public void setCal(Integer cal) {
		this.cal = cal;
	}

	public Integer getEquipmentstate() {
		return equipmentstate;
	}

	public void setEquipmentstate(Integer equipmentstate) {
		this.equipmentstate = equipmentstate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
	
	@Override
	public String toString() {
		return "DeviceInformation [deviceid=" + deviceid + ", deviceimei=" + deviceimei
				+ ", deviceuniqueid=" + deviceuniqueid + ", devicetype=" + devicetype
				+ ", cal="+ cal + ", equipmentstate=" + equipmentstate + ", remark=" + remark
				+ ", areaid=" + areaid + "]";
	}


	  
}
