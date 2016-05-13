<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<!-- 贷后管理---------成交项目列表-------贷后监管-------列表展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="306" name="_index_m2"/>
				<jsp:param value="30601" name="_index_m3"/>
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
										<li>
											<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<input type="hidden" id="projectID" value="${projectID}">
									<span class="con-item"><span>添加时间范围</span><input type="text" id="startDate" class="notspecial Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-addmsg">添加贷后信息</button>
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-searchmsg">贷后信息查询</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_id" class="display">
								</table>
							</div>
						</div>
						<!-- 添加贷后信息 -->
						<div class="w-content addmsg">
						   <form id="dataForm">
							<table>
								<tr>
									<td class="tt"><label>摘要：</label></td>
									<td class="con">
										<textarea id="abstractMain" cols="20" rows="5"></textarea>
									</td>
								</tr>
								<tr>
									<td class="tt"><label>详细描述：</label></td>
									<td class="con">
										<textarea id="details" cols="20" rows="5"></textarea>
									</td>
								</tr>
								<tr>
									<td class="tt"><label >附件名称：</label></td>
									<td class="col"><input class="notspecial" id="fileName" datatype="enterNameR"></td>
								</tr>
								<tr>
									<td class="tt"><label >上传附件信息：</label></td>
									<input type="hidden" id="affix">
									<td class="con">
										<!--dom结构部分-->
										<div id="uploader">
										    <!--用来存放item-->
										    <div  class="filePicker" id="filePicker1">上传附件</div>
										</div>
									</td>
								</tr>
								<tr>
									<td class="tt" valign="top"></td>
									<td class="con fileList" id="fileList1"></td>
								</tr>
							</table>
							</form>
						</div>
						<!-- 贷后信息查询 -->
						<div class="w-content searchmsg">
							<table>
								<tr>
									<input type="hidden" id="hostPath" value="${hostPath}">
									<td class="tt"><label>摘要：</label></td>
									<td class="con">
										<span class="abstracts"></span>
									</td>
								</tr>
								<tr>
									<td class="tt"><label>详细描述：</label></td>
									<td class="con">
										<span class="detail"></span>
									</td>
								</tr>
								<tr>
									<td class="tt"><label>产生时间：</label></td>
									<td class="con">
										<span class="recordDate"></span>
									</td>
								</tr>
								<tr>
									<td class="tt"><label class="ineed">附件：</label></td>
								</tr>
								<tr>
									<td class="tt" valign="top"></td>
									<td class="con showFileList" ></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!-- 公用js -->
				<jsp:include page="../common/cm-js.jsp"></jsp:include>
				<!-- 私用js -->
				<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
				<script src="js/project/deal_list_supervice_list.js"></script>
			</div>	
		</div>
	</div>
</body>

</html>
