package com.joyo.dao.provider;

import com.joyo.pojo.HistoricalRecords;

import static com.joyo.util.common.HrmConstants.HISTORICALRECORDSTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;


public class HistoricalRecordsSqlProvider {
 // 分页动态查询
 	public String selectWhitParam(Map<String, Object> params){
 		String sql =  new SQL(){
 			{
 				SELECT("*");
 				FROM(HISTORICALRECORDSTABLE);
 				if(params.get("historicalrecords") != null){
 					HistoricalRecords historicalrecords = (HistoricalRecords)params.get("historicalrecords");
 					if(historicalrecords.getDeviceInformation() != null
 							&& historicalrecords.getDeviceInformation().getDeviceid()!= null 
 							&& historicalrecords.getDeviceInformation().getDeviceid() != 0){
						WHERE(" deviceInformation_deviceId = #{historicalrecords.deviceInformation.deviceid} ");
					}
 				//	System.out.println("ok");
 					/**
 					if(historicalrecords.getMeternumber() != null && !historicalrecords.getMeternumber().equals("")){
 						WHERE("  meterNumber LIKE CONCAT ('%',#{historicalrecords.meternumber},'%') ");
 					}
 					**/
 					
 					else if(historicalrecords.getStatus()!= null && !historicalrecords.getStatus().equals("")){
 						WHERE("status = #{historicalrecords.status}");
 					}
 					
 					else if(historicalrecords.getUploadtime()!= null && !historicalrecords.getUploadtime().equals("")){
 						WHERE("upLoadTime = #{historicalrecords.uploadtime}");
 					}
 					
 						
 				}
 			}
 			
 		}.toString();
 		System.out.println("ok");
 		
 		if(params.get("pageModel") != null){
 			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
 		}
 		
 		return sql;
 	}	
 	// 动态查询总数量
 	public String count(Map<String, Object> params){
 		return new SQL(){
 			{
 				SELECT("count(*)");
 				FROM(HISTORICALRECORDSTABLE);
 				if(params.get("historicalrecords") != null){
 					HistoricalRecords historicalrecords = (HistoricalRecords)params.get("historicalrecords");
 					if(historicalrecords.getDeviceInformation() != null 
 							&& historicalrecords.getDeviceInformation().getDeviceid() != null 
 							&& historicalrecords.getDeviceInformation().getDeviceid() != 0){
						WHERE(" deviceInformation_deviceId = #{historicalrecords.deviceInformation.deviceid} ");
					}
 					/**
 					if(historicalrecords.getMeternumber() != null && !historicalrecords.getMeternumber().equals("")){
 						WHERE("  meterNumber LIKE CONCAT ('%',#{historicalrecords.metername},'%') ");
 					}
 					**/
 					else if(historicalrecords.getStatus()!= null && !historicalrecords.getStatus().equals("")){
 						WHERE("status = #{historicalrecords.status}");
 					}
 					
 					else if(historicalrecords.getUploadtime()!= null && !historicalrecords.getUploadtime().equals("")){
 						WHERE("upLoadTime = #{historicalrecords.uploadtime}");
 					}
 					
 				}
 			}
 		}.toString();
 	}	
 	
}