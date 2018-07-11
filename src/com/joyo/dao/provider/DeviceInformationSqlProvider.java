package com.joyo.dao.provider;

import com.joyo.pojo.DeviceInformation;

import static com.joyo.util.common.HrmConstants.DEVICEINFORMATIONTABLE;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DeviceInformationSqlProvider {
	//分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(DEVICEINFORMATIONTABLE);
				if(params.get("deviceInformation") != null){
					DeviceInformation deviceInformation = (DeviceInformation) params.get("deviceInformation");
					if(deviceInformation.getDeviceid()!= null && !deviceInformation.getDeviceid().equals("")){
						WHERE("  deviceId = #{deviceid} ");
					}
				}
			}
		}.toString();
		
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
				FROM(DEVICEINFORMATIONTABLE);
				if(params.get("deviceInformation") != null){
					DeviceInformation deviceInformation = (DeviceInformation) params.get("deviceInformation");
					if(deviceInformation.getDeviceid() != null && !deviceInformation.getDeviceid().equals("")){
						WHERE (" deviceId = #{deviceid}") ;
					}
				}
			}
		}.toString();
	}	

	// 动态插入
		public String insertDevin(DeviceInformation deviceInformation ){
			
			return new SQL(){
				{
					INSERT_INTO(DEVICEINFORMATIONTABLE);
					
					if(deviceInformation.getDeviceid() != null && !deviceInformation.getDeviceid().equals("")){
						VALUES("deviceId", "#{deviceid}");
					}
					if(deviceInformation.getDeviceimei() != null && !deviceInformation.getDeviceimei().equals("")){
						VALUES("deviceIMEI", "#{deviceimei}");
				
					}
					
					if(deviceInformation.getDeviceuniqueid() != null && !deviceInformation.getDeviceuniqueid().equals("")){
						VALUES("deviceUniqueID", "#{deviceUniqueid}");
					}
					
					if(deviceInformation.getDevicetype()!= null && !deviceInformation.getDevicetype().equals("")){
						VALUES("deviceType", "#{devicetype}");
					}
					
					if(deviceInformation.getCal() != null && !deviceInformation.getCal().equals("")){
						VALUES("CAL", "#{cal}");
					}
					if(deviceInformation.getEquipmentstate() != null && !deviceInformation.getEquipmentstate().equals("")){
						VALUES("equipmentState", "#{equipmentstate}");
					}
					if(deviceInformation.getRemark() != null && !deviceInformation.getRemark().equals("")){
						VALUES("remark", "#{remark}");
					}
					if(deviceInformation.getAreaid() != null && !deviceInformation.getAreaid().equals("")){
						VALUES("area_areaId", "#{areaid}");
					}
					
				}
			}.toString();
		}

		// 动态更新
		public String updateDevin(DeviceInformation deviceInformation){
			
			return new SQL(){
				{
					UPDATE(DEVICEINFORMATIONTABLE);
					
					if(deviceInformation.getDeviceimei()!= null ){
						SET("deviceIMEI = #{deviceimei}");
				
					}
					
					if(deviceInformation.getDeviceuniqueid()!= null ){
						SET("deviceUniqueID = #{deviceuniqueid}");
				
					}
					
					
					if(deviceInformation.getDevicetype() != null){
						SET("deviceType=#{devicetype}");
					}
					if(deviceInformation.getCal() != null ){
						SET("CAL=#{cal}");
					}
					if(deviceInformation.getEquipmentstate() != null ){
						SET("equipmentState=#{equipmentstate}");
					}
					if(deviceInformation.getRemark() != null){
						SET("remark=#{remark}");
					}
					if(deviceInformation.getAreaid() != null){
						SET("area_areaId=#{areaid}");
					}
					
					
					/**06/30/2018 areaAreaId不应出现在页面上,后期若有需要,删除即可
					if(equipmentInformation.getAreaAreaid() != null){
						SET("Area_areaId=#{areaAreaid}");
					}
						WHERE(" Area_areaId = #{equipmentInformation.area.areaAreaid} ");
						
						//if(equipmentInformation.getEquipmentid() != null){
						//	SET("equipmentId = #{equipmentid} ");
						//}
						 * 
						 * *
						 */
				}
			}.toString();
			
			}
		
   }


