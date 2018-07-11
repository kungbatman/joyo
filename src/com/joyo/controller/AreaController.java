package com.joyo.controller;

import java.util.List;

import com.joyo.pojo.Area;
import com.joyo.service.HrmService;
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
public class AreaController {
	/**
	 * 自动注入UserService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	@RequestMapping(value="/area/selectArea")
	 public String selectArea(Model model,Integer pageIndex,
			 @ModelAttribute Area area){
		System.out.println("selectArea -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("area = " + area);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		
		List<Area> areas = hrmService.findArea(area, pageModel);
		model.addAttribute("areas", areas);
		model.addAttribute("pageModel", pageModel);
		return "area/area";
		
	}
	
	/**
	 * 处理删除地区请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/area/removeArea")
	 public ModelAndView removeAera(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除地区
			hrmService.removeAreaById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/area/selectArea");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * */
	@RequestMapping(value="/area/addArea")
	 public ModelAndView addArea(
			 String flag,
			 @ModelAttribute Area area,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("area/showAddArea");
		}else{
			// 执行添加操作
			hrmService.addArea(area);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/area/selectArea");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理修改地区请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操
	 * */
	@RequestMapping(value="/area/updateArea")
	 public ModelAndView updateArea(
			 String flag,
			 @ModelAttribute Area area,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询地区
			
			//06/30/2018
			Area target = hrmService.findAreaById(area.getAreaname());
			//Area target = hrmService.findAreaById(area.getAreaid());
			// 设置Model数据
			mv.addObject("area", target);
			// 设置跳转到修改页面
			mv.setViewName("area/showUpdateArea");
		}else{
			// 执行修改操作
			hrmService.modifyArea(area);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/area/selectArea");
		}
		// 返回
		return mv;
	}
}
