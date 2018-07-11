package com.joyo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.joyo.dao.AreaDao;
import com.joyo.dao.DeviceInformationDao;
import com.joyo.dao.HistoricalRecordsDao;
import com.joyo.dao.UserDao;
import com.joyo.dao.NoticeDao;
import com.joyo.pojo.Area;
import com.joyo.pojo.DeviceInformation;
import com.joyo.pojo.HistoricalRecords;
import com.joyo.pojo.User;
import com.joyo.service.HrmService;
import com.joyo.util.tag.PageModel;

import com.joyo.pojo.Notice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Description: 数据管理系统服务层接口实现类
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HistoricalRecordsDao historicalrecordsDao;
	
	@Autowired
	private DeviceInformationDao deviceinformationDao;
	
	@Autowired
	private AreaDao areaDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	
	
	
	/*****************用户服务接口实现*************************************/
	/**
	 * HrmServiceImpl接口login方法实现
	 *  @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
//		System.out.println("HrmServiceImpl login -- >>");
		return userDao.selectByLoginnameAndPassword(loginname, password);
	}

	/**
	 * HrmServiceImpl接口findUser方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<User> findUser(User user,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("user", user);
		int recordCount = userDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<User> users = userDao.selectByPage(params);
		 
		return users;
	}
	
	/**
	 * HrmServiceImpl接口findUserById方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public User findUserById(Integer id) {
		return userDao.selectById(id);
	}
	
	/**
	 * HrmServiceImpl接口removeUserById方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void removeUserById(Integer id) {
		userDao.deleteById(id);
		
	}
	
	/**
	 * HrmServiceImpl接口addUser方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void modifyUser(User user) {
		userDao.update(user);
		
	}
	
	/**
	 * HrmServiceImpl接口modifyUser方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void addUser(User user) {
		userDao.save(user);
		
	}

	
	/**********数据管理服务接口实现********************/
	/**
	 * HrmService接口findHistoricalRecords方法实现
	 * @see { HrmService }
	 * */
	
	@Transactional(readOnly=true)
	@Override
	public List<HistoricalRecords> findHistoricalRecords(HistoricalRecords historicalrecords, PageModel pageModel) {
		// TODO Auto-generated method stub
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("historicalrecords", historicalrecords);
		
		int recordCount = historicalrecordsDao.count(params);
	    pageModel.setRecordCount(recordCount);
	    
	    if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
	    List<HistoricalRecords> historicalrecordss = historicalrecordsDao.selectByPage(params);
	    return historicalrecordss;
	}
	
	
	//@Transactional(readOnly=true)
	@Override
	public void removeHistoricalRecordsById(Integer recordid) {
		// TODO Auto-generated method stub
		historicalrecordsDao.deleteById(recordid);
	}

	@Transactional(readOnly=true)
	@Override
	public HistoricalRecords findHistoricalRecordsById(Integer recordid) {
		// TODO Auto-generated method stub
		return historicalrecordsDao.selectById(recordid);
	}

	@Transactional(readOnly=true)
	@Override
	public List<HistoricalRecords> findAllHistoricalRecords() {
		
		return historicalrecordsDao.selectAllHistoricalRecords();
	}
	
	
	/**********设备服务接口实现*********/
	/**
	 * HrmService接口findAllDeviceInformation方法实现
	 * @see { HrmService }
	 * */
	
	@Transactional(readOnly=true)
	@Override
	public List<DeviceInformation> findAllDeviceInformation() {
		
		return deviceinformationDao.selectAllDeviceInformation();
	}

	/**
	 * HrmService接口find方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<DeviceInformation> findDeviceInformation(DeviceInformation deviceInformation, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("deviceInformation", deviceInformation);
		int recordCount = deviceinformationDao.count(params);
		System.out.println("recordCount -->>" + recordCount);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<DeviceInformation> deviceInformations = deviceinformationDao.selectByPage(params);
		 
		return deviceInformations;
	}
	
	/**
	 * HrmService接口removeDevicexxxById方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void removeDeviceInformationById(Integer deviceid) {
		deviceinformationDao.deleteById(deviceid);
		
	}
	
	/**
	 * HrmService接口add方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void addDeviceInformation(DeviceInformation deviceInformation) {
		deviceinformationDao.insertDevin(deviceInformation);
		
	}
	
	/**
	 * HrmService接口findById方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public DeviceInformation findDeviceInformationById(Integer deviceid) {
		
		return deviceinformationDao.selectById(deviceid);
	}
	
	/**
	 * HrmService接口modify方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void modifyDeviceInformation(DeviceInformation deviceInformation) {
		deviceinformationDao.updateDevin(deviceInformation);
		
	}
	

	
	/**********************************************/
	
	/*
	@Override
	public List<EquipmentInformation> findEquipmentInformation(EquipmentInformation equipmentInformation,
			PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentInformation> findAllEquipmentInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEquipmentInformationById(Integer equipmentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEquipmentInformation(EquipmentInformation equipmentInformation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EquipmentInformation findEquipmentInformationById(Integer equipmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyEquipmentInformation(EquipmentInformation equipmentInformation) {
		// TODO Auto-generated method stub
		
	}

	
	*/
	
	/*****************地区服务接口实现*************************************/
	@Transactional(readOnly=true)
	@Override
	public List<Area> findAllArea() {
		
		return areaDao.selectAllArea();
	}
	
	/**
	 * HrmServiceImpl接口findDept方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<Area> findArea(Area area,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("area", area);
		int recordCount = areaDao.count(params);
		System.out.println("recordCount -->>" + recordCount);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Area> areas = areaDao.selectByPage(params);
		 
		return areas;
	}
	
	/**
	 * HrmServiceImpl接口removeXXXById方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void removeAreaById(Integer areaid) {
		areaDao.deleteById(areaid);
		
	}

	/**
	 * HrmServiceImpl接口add方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void addArea(Area area) {
		areaDao.insertArea(area);
		
	}
	
	/**
	 * HrmServiceImpl接口findAreaById方法实现
	 * @see { HrmService }
	 * */
	@Transactional (readOnly=true)
	@Override
	/**06/30/2018
	public Area findAreaById(Integer areaid) {
		
	
		return areaDao.selectById(areaid);
	}
	
	**/
public Area findAreaById(String areaname) {
		
		//return areaDao.selectById(areaid);
		return areaDao.selectById(areaname);
	}
	
	/**
	 * HrmServiceImpl接口modify方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void modifyArea(Area area) {
		areaDao.updateArea(area);
		
	}
	
	/*****************公告接口实现*************************************/
	@Transactional(readOnly=true)
	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("notice", notice);
		int recordCount = noticeDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Notice> notices = noticeDao.selectByPage(params);
		 
		return notices;
	}

	/**
	 * HrmService接口findNoticeById方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public Notice findNoticeById(Integer id) {
		
		return noticeDao.selectById(id);
	}

	/**
	 * HrmService接口removeNoticeById方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void removeNoticeById(Integer id) {
		noticeDao.deleteById(id);
		
	}
	
	/**
	 * HrmService接口addNotice方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
		
	}
	
	/**
	 * HrmService接口modifyNotice方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
		
	}


}
