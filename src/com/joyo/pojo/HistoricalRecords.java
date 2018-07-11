package com.joyo.pojo;

import java.io.Serializable;

public class HistoricalRecords  implements Serializable{

	
	private Integer recordid; //记录序号
	
	  //设备拥有多条历史记录
   private DeviceInformation deviceInformation;
	  
    private Integer signalstrength; //信号强度

    
    private Float voltage; //电池电压

  
    private Double flowtotal; //累计流量

    private Double flowrate; //瞬时流速
    
    private Double flowforwardtotal; //正向累计流量
  
    private Double flowbackwardtotal; //反向累计流量
    
    private Float tempin; //进水温度


    private Integer status; //状态

    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String uploadtime; //上传时间
    
    public Integer getRecordid() {
    	return recordid;
    }
    
    public void setRecordid(Integer recordid) {
    	this.recordid = recordid;
    }
    
    
	public DeviceInformation getDeviceInformation() {
		return deviceInformation;
	}


	public void setDeviceInformation(DeviceInformation deviceInformation) {
		this.deviceInformation = deviceInformation;
	}


	public Integer getSignalstrength() {
		return signalstrength;
	}


	public void setSignalstrength(Integer signalstrength) {
		this.signalstrength = signalstrength;
	}


	public Float getVoltage() {
		return voltage;
	}


	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}


	public Double getFlowtotal() {
		return flowtotal;
	}


	public void setFlowtotal(Double flowtotal) {
		this.flowtotal = flowtotal;
	}


	public Double getFlowrate() {
		return flowrate;
	}


	public void setFlowrate(Double flowrate) {
		this.flowrate = flowrate;
	}


	public Double getFlowforwardtotal() {
		return flowforwardtotal;
	}


	public void setFlowforwardtotal(Double flowforwardtotal) {
		this.flowforwardtotal = flowforwardtotal;
	}


	public Double getFlowbackwardtotal() {
		return flowbackwardtotal;
	}


	public void setFlowbackwardtotal(Double flowbackwardtotal) {
		this.flowbackwardtotal = flowbackwardtotal;
	}


	public Float getTempin() {
		return tempin;
	}


	public void setTempin(Float tempin) {
		this.tempin = tempin;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getUploadtime() {
		return uploadtime;
	}
	
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	
	@Override
	public String toString() {
		return "HistoricalRecords [recordid=" + recordid + ", deviceInformation=" + deviceInformation
				+ ", signalstrength=" + signalstrength + ", voltage=" + voltage + ", flowtotal="
				+ flowtotal + ", flowrate=" + flowrate + ", flowforwardtotal=" + flowforwardtotal
				+ ", flowbackwardtotal=" + flowbackwardtotal + ", tempin=" + tempin
				+ ", status=" + status
				+ ", uploadtime=" + uploadtime + "]";
	}

	

}