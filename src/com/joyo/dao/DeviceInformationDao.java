package com.joyo.dao;

import static com.joyo.util.common.HrmConstants.DEVICEINFORMATIONTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.joyo.dao.provider.DeviceInformationSqlProvider;
import com.joyo.pojo.DeviceInformation;

public interface DeviceInformationDao {
	 @Select("select * from "+DEVICEINFORMATIONTABLE+" where deviceId = #{deviceid}")
	    DeviceInformation selectById(Integer deviceid);
		
	    
		@Select("select * from "+DEVICEINFORMATIONTABLE+" ")
		List<DeviceInformation> selectAllDeviceInformation();

		// 动态查询
		
		@SelectProvider(type=DeviceInformationSqlProvider.class,method="selectWhitParam")
		List<DeviceInformation> selectByPage(Map<String, Object> params);
		
		@SelectProvider(type=DeviceInformationSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
		
		// 根据id删除部门
		@Delete(" delete from "+DEVICEINFORMATIONTABLE+" where deviceId = #{deviceid} ")
		void deleteById(Integer deviceid);
		
		// 动态插入部门
		@SelectProvider(type=DeviceInformationSqlProvider.class,method="insertDevin")
		void insertDevin(DeviceInformation deviceInformation);
		
		// 动态修改用户
		@SelectProvider(type=DeviceInformationSqlProvider.class,method="updateDevin")
		void updateDevin(DeviceInformation deviceInformation);
	}

