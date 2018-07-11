package com.joyo.dao.provider;

import com.joyo.pojo.Area;

import static com.joyo.util.common.HrmConstants.AREATABLE;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class AreaSqlProvider {

	
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(AREATABLE);
				if(params.get("area") != null){
					Area area = (Area) params.get("area");
					if(area.getAreaname() != null && !area.getAreaname().equals("")){
						WHERE(" areaName LIKE CONCAT ('%',#{area.aeraname},'%') ");
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
				FROM(AREATABLE);
				if(params.get("area") != null){
					Area area = (Area) params.get("area");
					if(area.getAreaname() != null && !area.getAreaname().equals("")){
						WHERE("  areaName LIKE CONCAT ('%',#{area.areaname},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	
	// 动态插入
		public String insertArea(Area area){
			
			return new SQL(){
				{
					INSERT_INTO(AREATABLE);
					
					if(area.getAreaid() != null && !area.getAreaid().equals("")) {
						VALUES(" areaId " , " #{areaid} ");
					}
					if(area.getAddressnumber() != null && !area.getAddressnumber().equals("")) {
						VALUES(" addressNumber " , " #{addressnumber} ");
					}
					if(area.getAreaname() != null && !area.getAreaname().equals("")){
						VALUES(" areaName" , " #{areaname} ");
					}
					
					if(area.getArealevel() != null && !area.getArealevel().equals("")){
						VALUES(" areaLevel ", " #{arealevel} ");
					}
					if(area.getHigherareanumber() != null && !area.getHigherareanumber().equals("")){
						VALUES(" higherAreaNumber ", "#{higherareanumber} ");
					}
					
					if(area.getHigherareaname() != null &&! area.getHigherareaname().equals("")){
						VALUES(" higherAreaName ", " #{higherareaname} ");
					}
					if(area.getValidtags() != null && !area.getValidtags().equals("")){
						VALUES(" validTags "," #{validtags} ");
					}
				}
			}.toString();
		}
	
	// 动态更新
		public String updateArea(Area area){
			
			return new SQL(){
				{
					UPDATE(AREATABLE);
					if(area.getAddressnumber() != null){
						SET(" addressNumber = #{addressnumber} ");
					}
					if(area.getAreaname() != null){
						SET(" areaName = #{areaname} ");
					}
					
					if(area.getArealevel() != null){
						SET(" areaLevel = #{arealevel} ");
					}
					if(area.getHigherareanumber() != null){
						SET(" higherAreaNumber = #{higherareanumber} ");
					}
					
					if(area.getHigherareaname() != null){
						SET(" higherAreaName = #{higherareaname} ");
					}
					if(area.getValidtags() != null){
						SET(" validTags = #{validtags} ");
					}
					
					WHERE(" areaId = #{areaid} ");
				}
			}.toString();
		}

   
}