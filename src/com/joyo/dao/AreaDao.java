package com.joyo.dao;

import com.joyo.dao.provider.AreaSqlProvider;
import com.joyo.pojo.Area;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import static com.joyo.util.common.HrmConstants.AREATABLE;

import java.util.List;
import java.util.Map;

public interface AreaDao {

	// 动态查询
	@SelectProvider(type=AreaSqlProvider.class,method="selectWhitParam")
	List<Area> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=AreaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Select("select * from "+AREATABLE+" ")
	List<Area> selectAllArea();
	
	
	//06/30/2018
	@Select("select * from "+AREATABLE+" where  areaName LIKE CONCAT ('%',#{area.areaname},'%')")
	Area selectById(String areaname);
	
	//@Select("select * from "+AREATABLE+" where areaId= #{areaid}")
//	Area selectById(int areaid);

	// 根据id删除部门
	@Delete(" delete from "+AREATABLE+" where areaId = #{areaid} ")
	void deleteById(Integer areaid);
	
	// 动态插入部门
	@SelectProvider(type=AreaSqlProvider.class,method="insertArea")
	void insertArea(Area area);
	
	// 动态修改用户
	//
	@SelectProvider(type=AreaSqlProvider.class,method="updateArea")
	void updateArea(Area area);
}