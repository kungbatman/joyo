<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>数据管理系统 ——数据管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />

	<script type="text/javascript">
	       $(function(){
	    	   /** 获取上一次选中的数据 */
	    	   var boxs  = $("input[type='checkbox'][id^='box_']");
	    	   
	    	   /** 给全选按钮绑定点击事件  */
		    	$("#checkAll").click(function(){
		    		// this是checkAll  this.checked是true
		    		// 所有数据行的选中状态与全选的状态一致
		    		boxs.attr("checked",this.checked);
		    	})
		    	
	    	   /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
		    	$("tr[id^='data_']").hover(function(){
		    		$(this).css("backgroundColor","#eeccff");
		    	},function(){
		    		$(this).css("backgroundColor","#ffffff");
		    	})
		    	
		    	
	    	   /** 删除数据绑定点击事件 */
	    	   $("#delete").click(function(){
	    		   /** 获取到用户选中的复选框  */
	    		   var checkedBoxs = boxs.filter(":checked");
	    		   if(checkedBoxs.length < 1){
	    			   $.ligerDialog.error("请选择一个需要删除的数据！");
	    		   }else{
	    			   /** 得到用户选中的所有的需要删除的ids */
	    			   var ids = checkedBoxs.map(function(){
	    				   return this.value;
	    			   })
	    			   
	    			   $.ligerDialog.confirm("确认要删除吗?","删除数据",function(r){
	    				   if(r){
	    					   // alert("删除："+ids.get());
	    					   // 发送请求
	    					   window.location = "${ctx }/historicalrecords/removeHistoricalRecords?ids=" + ids.get();
	    				   }
	    			   });
	    		   }
	    	   })
	       })
	</script>
	
	<script type="text/javascript">
	function changeState(){
		var status = document.getElementById("indexState").value;
		document.getElementById("status").value=status;
	}
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：数据管理 &gt; 历史查询</td>
		<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	  <!-- 查询区  -->
	  <tr valign="top">
	    <td height="30">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr>
			  <td class="fftd">
			  	<form name="historicalform" method="post" id="historicalform" action="${ctx}/historicalrecords/selectHistoricalRecords">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="font3">
					    	设备号：
							    <select name="deviceInformation_deviceId" style="width:143px;">
					    			<option value="0">---请选择设备---</option>
					    			<c:forEach items="${requestScope.deviceinformations }" var="device">
					    				<option value="${device.deviceid }">${device.deviceimei}</option>
					    			</c:forEach>
					    		</select>
					    	
					    <!-- 	记录起始时间：<input type="date" name="time1" /> 
					    	记录结束时间：<input type="date">
					    	 -->
					    	记录时间：<input type="text" name="uploadtime"/>
					    	
					    </td>
					  </tr>
					  
					  
					  <tr>
					    <td class="font3">
					    	状&nbsp;态：
					    		<select id="indexState" onchange="changeState()">
					    			<option value="0">--请选择状态--</option>
					    			<option value="4608">有效</option>
					    			<option value="2">无效</option> 
					    		</select>
					    	<input type="hidden" name="status" id="status" value="0">
					    	
					    	<!-- 
					    	所属设备：<select  name="Equipmentinformation_equipmentId" style="width:100px;">
								   <option value="0">--设备选择--</option>
								   <c:forEach items="${requestScope.equipmentinformations }" var="equipmentinformation">
					    				<option value="${equipmentinformation.equipmentid }">${equipmentinformation.equipmentid }</option>
					    			</c:forEach>
							</select>&nbsp; -->
					    	<input type="submit" value="搜索"/>
					   	<input id="delete" type="button" value="删除" >
					  
					    </td>
					  </tr>
					</table>
				</form>
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
	  
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr class="main_trbg_tit" align="center">
			  <td><input type="checkbox" name="checkAll" id="checkAll"></td>
		
			  <td>设备IMEI</td>
			   <td>信号强度</td>				 	
			  <td>电池电压</td>
			  <td>累计流量</td>
			  <td>瞬时流速</td>
			  <td>正向累计流量</td>
			  <td>反向累计流量</td>
			  <td>进水温度</td>
			  <td>状态</td>	
			  <td>上传时间</td>  
		</tr>
			
			
			<!-- 更新日期：06/28/2018 -->
			<c:forEach items="${requestScope.historicalrecordss}" var="historicalrecords" varStatus="state">
				<tr id="data_${state.index}" class="main_trbg" align="center">
					<td><input type="checkbox" id="box_${state.index}" value="${historicalrecords.recordid }"></td>
				
				<td>${historicalrecords.deviceInformation.deviceimei}</td>	
					  <td>${historicalrecords.signalstrength}</td>
					  
					   <td>${historicalrecords.voltage}</td>
					  <td>${historicalrecords.flowtotal}</td>
					  <td>${historicalrecords.flowrate}</td>
					  <td>${historicalrecords.flowforwardtotal}</td>
					  
					  <td>${historicalrecords.flowbackwardtotal}</td>
					  <td>${historicalrecords.tempin}</td>
					  
					  
					  <td>
					  <c:if test="${historicalrecords.status==4608}">
					  <font color="blue">有效</font>
					  
					  </c:if>
					  
					    <c:if test="${historicalrecords.status==2}">
					  <font color="red">无效</font>
					  
					  </c:if>				 					  
					  </td>  			  								
						<td>${historicalrecords.uploadtime}
					 </td>
					  <!--  
					  <td align="center" width="40px;"><a href="${ctx}/employee/updateEmployee?flag=1&id=${employee.id}">
							<img title="修改" src="${ctx}/images/update.gif"/></a>
					  </td>
					  
					  -->
				</tr>
			</c:forEach>
			
			
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        style="digg"
	  	        submitUrl="${ctx}/historicalrecords/selectHistoricalRecords?pageIndex={0}"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>