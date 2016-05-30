<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>配置中心-短信设置-消息发送历史</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------短信设置  消息发送历史-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="603" name="_index_m2" />
				<jsp:param value="60303" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	
			 	<!-- 消息发送历史-->
			 	<div class="award-rule-set">
			 		<!-- 数据显示 -->
			 		<ul class="nav nav-tabs msgalerttab">
						<li role="presentation" class="active"><a>查看站内信历史记录</a></li>
						<li role="presentation" class=""><a>查看短信发送历史记录</a></li>
						<li role="presentation" class=""><a>查看邮件发送历史记录</a></li>
					</ul>
					<!-- 站内信开始 -->
					<div class="nav-tabs-con active">
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span
													class="glyphicon glyphicon-chevron-down"></span> </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="website" class="" action="">
										<span class="con-item">
											<span>会员编号</span><input type="text" class="MemberNo" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员手机号</span><input type="text" class="personalPhone" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员登录名</span><input type="text" class="logname" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员名称</span><input type="text" class="personalName" placeholder="" />
										</span>
										<span class="">
											<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</form>
								</div>
							</div>
						</div>
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-body">
									<table id="stationlettertable" class="display">
									</table>
								</div>
								
							</div>
						</div>
					</div>
					<!-- 短信开始  -->
					<div class="nav-tabs-con">
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span
													class="glyphicon glyphicon-chevron-down"></span> </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="sms" class="" action="">
										<span class="con-item">
											<span>会员编号</span><input type="text" class="MemberNo" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员手机号</span><input type="text" class="personalPhone" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员登录名</span><input type="text" class="logname" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员名称</span><input type="text" class="personalName" placeholder="" />
										</span>
										<span class="">
											<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</form>
								</div>
							</div>
						</div>
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-body">
									<table id="msgtable" class="display">
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- 短信结束  -->
					<!-- 邮件开始 -->
					<div class="nav-tabs-con">
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span
													class="glyphicon glyphicon-chevron-down"></span> </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="mail" class="" action="">
										<span class="con-item">
											<span>会员编号</span><input type="text" class="MemberNo" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员手机号</span><input type="text" class="personalPhone" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员登录名</span><input type="text" class="logname" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员名称</span><input type="text" class="personalName" placeholder="" />
										</span>
										<span class="">
											<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</form>
								</div>
							</div>
						</div>
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-body">
									<table id="emailtable" class="display">
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- 邮件结束 -->
				</div>
			</div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js//config/config.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
$(function(){
	/* 站内信 */
	$('#stationlettertable').DataTable(
			{	
				ajax: {  
					"url": appPath+"/config/getMsgSendHistoryData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var MemberNo = $("#website .MemberNo").val();
						var personalPhone = $("#website .personalPhone").val();
						var personalName = $("#website .personalName").val();
						var logname = $("#website .logname").val();
						d.MemberNo = encrypt.encrypt(MemberNo);
						d.personalPhone = encrypt.encrypt(personalPhone);
						d.personalName = encrypt.encrypt(personalName);
						d.logname = encrypt.encrypt(logname);
						d.pgType = encrypt.encrypt("1");//标签页类型 1:站内信
						
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"站内信内容","data": "msgDetail"},  
				          { title:"接收人","data": "personalName"},  
				          { title:"接收人用户名","data": "logName"},  
				          { title:"发送时间","data": "recordDate"},  
				          { title:"发送类型","data": "recordType"},  
				          { title:"发送操作管理员","data": "adminName"}
				          ],
// 			  aaSorting : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,1,2,3,4,5,6]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页
	          searching: false,
	          scrollCollapse: true,
// 	          scrollX : "100%",
// 			  scrollXInner : "100%",
			  scrollY:500,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          },
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#stationlettertable tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#stationlettertable tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $("#website .glyphicon-search").on("click",function(){
		$('#stationlettertable').DataTable().ajax.reload();
		
	 });
		 
	/* 短信 */
	$('#msgtable').DataTable(
			{	
				ajax: {  
					"url": appPath+"/config/getMsgSendHistoryData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var MemberNo = $("#sms .MemberNo").val();
						var personalPhone = $("#sms .personalPhone").val();
						var personalName = $("#sms .personalName").val();
						var logname = $("#sms .logname").val();
						d.MemberNo = encrypt.encrypt(MemberNo);
						d.personalPhone = encrypt.encrypt(personalPhone);
						d.personalName = encrypt.encrypt(personalName);
						d.logname = encrypt.encrypt(logname);
						d.pgType = encrypt.encrypt("2");//标签页类型 2:短信
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"短信内容","data": "msgDetail"},  
				          { title:"接收人","data": "personalName"},  
				          { title:"接收人手机号","data": "personalPhone"},  
				          { title:"发送时间","data": "recordDate"},  
				          { title:"发送类型","data": "recordType"},  
				          { title:"发送操作管理员","data": "adminName"}
				          ],
// 			  aaSorting : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,1,2,3,4,5,6]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页
	          searching: false,
	          scrollCollapse: true,
// 	          scrollX : "100%",
// 			  scrollXInner : "100%",
// 			  scrollY:500,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          },
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#msgtable tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#msgtable tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $("#sms .glyphicon-search").on("click",function(){
		$('#msgtable').DataTable().ajax.reload();
		
	 });
	
	/* 邮件 */
	$('#emailtable').DataTable(
			{	
				ajax: {  
					"url": appPath+"/config/getMsgSendHistoryData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var MemberNo = $("#mail .MemberNo").val();
						var personalPhone = $("#mail .personalPhone").val();
						var personalName = $("#mail .personalName").val();
						var logname = $("#mail .logname").val();
						d.MemberNo = encrypt.encrypt(MemberNo);
						d.personalPhone = encrypt.encrypt(personalPhone);
						d.personalName = encrypt.encrypt(personalName);
						d.logname = encrypt.encrypt(logname);
						d.pgType = encrypt.encrypt("3");//标签页类型 3:邮箱
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"邮件内容","data": "msgDetail"},  
				          { title:"接收人","data": "personalName"},  
				          { title:"接收人邮箱","data": "personalEmail"},  
				          { title:"发送时间","data": "recordDate"},  
				          { title:"发送类型","data": "recordType"},  
				          { title:"发送操作管理员","data": "adminName"}
				          ],
// 			  aaSorting : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,1,2,3,4,5,6]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          searching: false,
	          scrollCollapse: true,
// 	          scrollX : "100%",
// 			  scrollXInner : "100%",
// 			  scrollY:500,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          },
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#emailtable tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#emailtable tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $("#mail .glyphicon-search").on("click",function(){
		$('#emailtable').DataTable().ajax.reload();
		
	 });
		
});
	</script>
</body>

</html>