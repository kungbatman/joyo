package com.joyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.joyo.pojo.DeviceInformation;
import com.joyo.service.HrmService;
import com.joyo.util.tag.PageModel;

@Controller
public class DeviceInformationController {

	
	/**
	 * 自动注入DeviceInformationService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	@RequestMapping(value="/device/selectDevice")
	 public String selectDeviceInformation(Model model,Integer pageIndex,
			 @ModelAttribute DeviceInformation deviceInformation){
		System.out.println("selectDevice -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("deviceInformation = " + deviceInformation);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		
		List<DeviceInformation> deviceInformations = hrmService.findDeviceInformation(deviceInformation, pageModel);
		model.addAttribute("deviceInformations", deviceInformations);
		model.addAttribute("pageModel", pageModel);
		return "device/device";
		
	}
	
	/**
	 * 处理删除地区请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/device/removeDevice")
	 public ModelAndView removeDevice(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除
			hrmService.removeDeviceInformationById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/device/selectDevice");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * */
	@RequestMapping(value="/device/addDevice")
	 public ModelAndView addDevice(
			 String flag,
			 @ModelAttribute DeviceInformation deviceInformation,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("device/showAddDevice");
		}else{
			// 执行添加操作
			hrmService.addDeviceInformation(deviceInformation);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/device/selectDevice");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理修改设备请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操
	 * */
	@RequestMapping(value="/device/updateDevice")
	 public ModelAndView updateDevice(
			 String flag,
			 @ModelAttribute DeviceInformation deviceInformation,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询
			
			//06/30/2018
			DeviceInformation target = hrmService.findDeviceInformationById(deviceInformation.getDeviceid());
			
			// 设置Model数据
			mv.addObject("deviceInformation", target);
			// 设置跳转到修改页面
			mv.setViewName("device/showUpdateDevice");
		}else{
			// 执行修改操作
			hrmService.modifyDeviceInformation(deviceInformation);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/device/selectDevice");
		}
		// 返回
		return mv;
	}
	
	
	
	
}
