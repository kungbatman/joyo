package com.joyo.controller;


import com.joyo.pojo.DeviceInformation;

import com.joyo.pojo.HistoricalRecords;
import com.joyo.service.HrmService;

import java.util.List;


import com.joyo.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理用户请求控制器
 * */
@Controller
public class HistoricalRecordsController {
	/**
	 * 自动注入hrmService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param historicalrecords 模糊查询参数
	 * @param Model model
	 * */
	
	@RequestMapping(value="/historicalrecords/selectHistoricalRecords")
	public String selectHistoricalRecords(Integer pageIndex,Integer deviceInformation_deviceId,	
			@ModelAttribute HistoricalRecords historicalrecords,
			Model model) {
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		
		
		//06/29/2018测试，关联
		/**/
		  this.genericAssociation(deviceInformation_deviceId, historicalrecords);
		 
		
		
				// 创建分页对象
				PageModel pageModel = new PageModel();
				// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
				if(pageIndex != null){
					pageModel.setPageIndex(pageIndex);
				}
				// 查询设备信息，用于模糊查询
				List<DeviceInformation> deviceinformations = hrmService.findAllDeviceInformation();
				// 查询数据信息    
				List<HistoricalRecords> historicalrecordss = hrmService.findHistoricalRecords(historicalrecords,pageModel);
				// 设置Model数据 
				model.addAttribute("historicalrecordss", historicalrecordss);
				model.addAttribute("deviceinformations", deviceinformations);
				
				model.addAttribute("pageModel", pageModel);
				// 返回数据页面
		
	
		return "historicalrecords/historicalrecords";
		}
	
	/**
	 * 处理删除记录请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/historicalrecords/removeHistoricalRecords")
	 public ModelAndView removeHistoricalRecords(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除
			hrmService.removeHistoricalRecordsById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求	
		mv.setViewName("redirect:/historicalrecords/selectHistoricalrecords");
		// 返回ModelAndView
		return mv;
	}
	
	
	/**设备表与地区表在历史数据表中是对象关联映射
	 * 不能直接接收参数,需要创建DevXXX对象
	 * @param historicalrecords
	 * 
	 */
	
	/**测试关联 06/29/2018 ***/
	
	
	private void genericAssociation(Integer deviceInformation_deviceId, 
			HistoricalRecords historicalrecords) {
		if(deviceInformation_deviceId != null){
			DeviceInformation dein = new DeviceInformation();
			dein.setDeviceid(deviceInformation_deviceId);
			historicalrecords.setDeviceInformation(dein);
		}
	
		
	}
	
	
}
