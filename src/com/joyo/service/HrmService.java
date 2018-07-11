package com.joyo.service;

import java.util.List;

import com.joyo.pojo.Notice;

import com.joyo.pojo.Area;
import com.joyo.pojo.DeviceInformation;
import com.joyo.pojo.HistoricalRecords;
import com.joyo.pojo.User;
import com.joyo.util.tag.PageModel;

/**   
 * @Description: 数据管理服务层接口 
 */
public interface HrmService {


	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	User login(String loginname,String password);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 用户对象
	 * */
	User findUserById(Integer id);
	
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<User> findUser(User user,PageModel pageModel);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * */
	void removeUserById(Integer id);
	
	/**
	 * 修改用户
	 * @param User 用户对象
	 * */
	void modifyUser(User user);
	
	/**
	 * 添加用户
	 * @param User 用户对象
	 * */
	void addUser(User user);
	
	/**
	 * 获得所有数据
	 * @param employee 查询条件
	 * @param pageModel 分页对象
	 * @return 对象的List集合
	 * */
	
	/***********历史数据服务接口***********/
	List<HistoricalRecords> findHistoricalRecords(HistoricalRecords historicalrecords,PageModel pageModel);
	
	List<HistoricalRecords> findAllHistoricalRecords();
	/**
	 * 根据id删除
	 * @param id
	 * 
	 * */
	void removeHistoricalRecordsById(Integer recordid);
	
	/**
	 * 根据id查询
	 * 
	 * */
	HistoricalRecords findHistoricalRecordsById(Integer recordid);
	
	
	/**
	 * 获得所有设备，分页查询
	 * @return DeviceInformation对象的List集合
	 * */
	List<DeviceInformation> findDeviceInformation(DeviceInformation deviceInformation,PageModel pageModel);
	
	/**
	 * 获得所有设备
	 * @return DeviceInformation对象的List集合
	 * */
	List<DeviceInformation> findAllDeviceInformation();
	
	/**
	 * 根据id删除设备
	 * @param deviceId
	 * */
	public void removeDeviceInformationById(Integer deviceid);
	
	/**
	 * 添加设备
	 * @param DeviceInformation 
	 * */
	void addDeviceInformation(DeviceInformation deviceInformation);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return 设备对象
	 * */
	DeviceInformation findDeviceInformationById(Integer deviceid);
	
	/**
	 * 修改
	 * @param DeviceInformation 对象
	 * */
	void modifyDeviceInformation(DeviceInformation deviceInformation);

	
	/**
	 * 获得所有地区
	 * @return Area对象的List集合
	 * */
	List<Area> findAllArea();
	
	List<Area> findArea(Area Area,PageModel pageModel);
	
	/**
	 * 根据id删除地区
	 * @param id
	 * */
	public void removeAreaById(Integer areaid);
	
	/**
	 * 添加地区
	 * @param 地区对象
	 * */
	void addArea(Area area);
	
	/**
	 * 根据id查询地区
	 * @param id
	 * @return 地区对象
	 * */
	
	//06/30/2018
	//Area findAreaById(Integer areaid);
	Area findAreaById(String name);
	
	/**
	 * 修改地区
	 * @param Area对象
	 * */
	void modifyArea(Area area);
	

	/**
	 * 获得所有公告
	 * @return Notice对象的List集合
	 * */
	List<Notice> findNotice(Notice notice,PageModel pageModel);
	
	/**
	 * 根据id查询公告
	 * @param id
	 * @return 公告对象
	 * */
	Notice findNoticeById(Integer id);
	
	/**
	 * 根据id删除公告
	 * @param id
	 * */
	public void removeNoticeById(Integer id);
	
	/**
	 * 添加公告
	 * @param Notice 公告对象
	 * */
	void addNotice(Notice notice);
	
	/**
	 * 修改公告
	 * @param Notice 公告对象
	 * */
	void modifyNotice(Notice notice);
}
