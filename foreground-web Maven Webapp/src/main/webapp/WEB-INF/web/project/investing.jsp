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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<link rel="stylesheet" href="css/common.css" type="text/css">
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/apply_faild.css" type="text/css">
	<link rel="stylesheet" href="css/project/investing.css" type="text/css">
</head>
<!-- 借款管理----------投资中 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="305" name="_index_m2"/>
				<jsp:param value="30504" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial Project_No"/></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial Logname" /></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="notspecial Personal_Name" /></span>
									<span class="con-item"><span>项目发布日期</span><input type="text" id="startDate" class="notspecial Wdate dateInput Record_Date_Min" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput Record_Date_Max" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>借款期限</span><input type="text" class="notspecial w1 Deadline"/><select class="w2 Deadline_Type"><option value="">请选择</option><option value="0">天</option><option value="1">月</option><option value="2">年</option></select></span>
									<span class="con-item"><span>借款金额</span><input type="text" class="notspecial dateInput Amount_Min" />-&nbsp;&nbsp;<input type="text" class="notspecial dateInput Amount_Max"/></span>
									<button  type ="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
							  		<button id="" class="obtn glyphicon glyphicon-plus obtn-export">导出</button>
						  			<button id="investing_modify" class="obtn glyphicon glyphicon-plus" onclick="alertAudit()">修改附件</button>
						  			<button id="" class="obtn glyphicon glyphicon-plus investing_invest_record">查看投资记录</button>
						  			<input id="applyID" type="hidden">
								</div>
							</div>
						<div class="panel-body">
						<table id="table_id" class="display">
						</table>
					</div>
				</div>
				<!-- 修改附件弹出层 -->
				<div class="uploadEnclosure" id="alertAudit">
					<form id="formInput">
						<table>
							<tr>
								<input type="hidden" id="hostPath" value="${hostPath}">
								<input type="hidden" id="deleteaffix">
								<input type="hidden" id="affix">
								<td class="tt">前台展示附件：</td>
								<td class="con fileList">									
								</td>
							</tr>
							<tr>
								<td class="tt">附件名称：</td>
								<td class="col"><input class="notspecial" id="fileName" datatype="enterNameR"></td>
							</tr>
							<tr>
								<td class="tt"></td>
								<td class="con">
									<!--dom结构部分-->
									<div id="uploader">
									    <!--用来存放item-->
									    <div id="filePicker" disabled="disabled">上传附件</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="tt" valign="top"></td>
								<td class="con" id="fileList"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		
			<!-- 尾部 -->
			
	</div>
	<!-- 公用js -->
	
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/project/investing.js"></script>
		</div>
	</div>
</body>

</html>