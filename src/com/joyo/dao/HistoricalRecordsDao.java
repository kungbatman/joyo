package com.joyo.dao;

import com.joyo.dao.provider.HistoricalRecordsSqlProvider;
import com.joyo.pojo.HistoricalRecords;
//import com.joyo.util.common.HrmConstants;

import  static com.joyo.util.common.HrmConstants.HISTORICALRECORDSTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;



/**   
 * @Description: HistoricalRecordsMapper接口
 */
public interface HistoricalRecordsDao {

    @Delete({
       "delete from "+HISTORICALRECORDSTABLE+"where recordId = #{recordid}"       
    })
   void deleteById(Integer recordid);


	// 根据参数查询历史数据总数
	@SelectProvider(type=HistoricalRecordsSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	
	/**
	// 根据参数动态查询
	@SelectProvider(type=HistoricalRecordsSqlProvider.class,method="selectWhitParam")
	@Results({
		 @Result(column="recordId", property="recordid", jdbcType=JdbcType.INTEGER, id=true),
	     @Result(column="Equipmentinformation_equipmentId", property="equipmentInformation",
	        jdbcType=JdbcType.INTEGER, id=true,
	    	 one=@One(select="com.joyo.EquipmentInformationDao.selectById",
	    	 fetchType=FetchType.EAGER)
	     ),			
	   
	    @Result(column="meterNumber", property="meternumber", jdbcType=JdbcType.INTEGER),
	    @Result(column="Area_areaId", property="area" ,
        jdbcType=JdbcType.INTEGER, id=true,
		one=@One(select="com.joyo.AreaDao.selectById",
	    fetchType=FetchType.EAGER)
    ),
	    @Result(column="areaNumber", property="areanumber", jdbcType=JdbcType.INTEGER),
	    @Result(column="instantaneousFlow", property="instantaneousflow", jdbcType=JdbcType.VARCHAR),
	    @Result(column="cumulativeFlow", property="cumulativeflow", jdbcType=JdbcType.VARCHAR),
	    @Result(column="positiveCumulativeFlow", property="positivecumulativeflow", jdbcType=JdbcType.VARCHAR),
	    @Result(column="waterSupplyTemperature", property="watersupplytemperature", jdbcType=JdbcType.VARCHAR),
	    @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
	    @Result(column="time", property="time", jdbcType=JdbcType.DATE)
		
	})
	List<HistoricalRecords> selectByPage(Map<String, Object> params);
    
    
    //根据id查询
	@Select("select * from "+HISTORICALRECORDSTABLE+" where RECORDID = #{recordid}")
    @Results({
        @Result(column="recordId", property="recordid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Equipmentinformation_equipmentId", property="equipmentInformation" , 
        jdbcType=JdbcType.INTEGER,  
         id =true,
     one=@One(select="com.joyo.EquipmentInformationDao.selectById",
        fetchType=FetchType.EAGER)
        ),
       
        @Result(column="meterNumber", property="meternumber", jdbcType=JdbcType.INTEGER),
        
        @Result(column="Area_areaId", property="area", 
        jdbcType=JdbcType.INTEGER, id=true,
        one=@One(select="com.joyo.AreaDao.selectById",
        fetchType=FetchType.EAGER)
        ),
        
        @Result(column="areaNumber", property="areanumber", jdbcType=JdbcType.INTEGER),
        @Result(column="instantaneousFlow", property="instantaneousflow", jdbcType=JdbcType.VARCHAR),
        @Result(column="cumulativeFlow", property="cumulativeflow", jdbcType=JdbcType.VARCHAR),
        @Result(column="positiveCumulativeFlow", property="positivecumulativeflow", jdbcType=JdbcType.VARCHAR),
        @Result(column="waterSupplyTemperature", property="watersupplytemperature", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.DATE)
    })
    HistoricalRecords selectById(Integer recordid);
	
	*/
	
	
	
	
	
	/***测试***   07/01/2018********/
	
	// 根据参数动态查询
		@SelectProvider(type=HistoricalRecordsSqlProvider.class,method="selectWhitParam")
		@Results({
			 @Result(column="recordId", property="recordid", jdbcType=JdbcType.INTEGER, id=true),
		     @Result(column="deviceInformation_deviceId", property="deviceInformation",id=true,
		    		 one=@One(select="com.joyo.dao.DeviceInformationDao.selectById",
		    			fetchType=FetchType.EAGER)),		
		   
		    @Result(column="signalStrength", property="signalstrength", jdbcType=JdbcType.INTEGER),	   
		    @Result(column="voltage", property="voltage", jdbcType=JdbcType.FLOAT),
		    @Result(column="flowTotal", property="flowtotal", jdbcType=JdbcType.DOUBLE),
		    @Result(column="flowRate", property="flowrate", jdbcType=JdbcType.DOUBLE),
		    @Result(column="flowForwardTotal", property="flowforwardtotal", jdbcType=JdbcType.DOUBLE),
		    @Result(column="flowBackwardTotal", property="flowbackwardtotal", jdbcType=JdbcType.DOUBLE),
		    @Result(column="tempIn", property="tempin", jdbcType=JdbcType.FLOAT),
		    @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
		    @Result(column="upLoadTime", property="uploadtime", jdbcType=JdbcType.VARCHAR)
			
		})
		List<HistoricalRecords> selectByPage(Map<String, Object> params);
	    
	    
	    //根据id查询
		@Select("select * from "+HISTORICALRECORDSTABLE+" where RECORDID = #{recordid}")
		@Results({
			 @Result(column="recordId", property="recordid", jdbcType=JdbcType.INTEGER, id=true),
		     @Result(column="deviceInformation_deviceId", property="deviceInformation", id=true,
		    		 one=@One(select="com.joyo.dao.DeviceInformationDao.selectById",
		    			fetchType=FetchType.EAGER)),
		    		   
		    @Result(column="signalStrength", property="signalstrength", jdbcType=JdbcType.INTEGER),	   
	       
	   
		    @Result(column="voltage", property="voltage", jdbcType=JdbcType.FLOAT),
		    @Result(column="flowTotal", property="flowtotal", jdbcType=JdbcType.DOUBLE),
		    @Result(column="flowRate", property="flowrate", jdbcType=JdbcType.DOUBLE),
		    @Result(column="flowForwardTotal", property="flowforwardtotal", jdbcType=JdbcType.DOUBLE),
		    @Result(column="flowBackwardTotal", property="flowbackwardtotal", jdbcType=JdbcType.DOUBLE),
		    @Result(column="tempIn", property="tempin", jdbcType=JdbcType.FLOAT),
		    @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
		    @Result(column="upLoadTime", property="uploadtime", jdbcType=JdbcType.VARCHAR)
			
		})
	    HistoricalRecords selectById(Integer recordid);
	
	
	@Select("select * from " + HISTORICALRECORDSTABLE + " ")
	List <HistoricalRecords> selectAllHistoricalRecords();
	

}