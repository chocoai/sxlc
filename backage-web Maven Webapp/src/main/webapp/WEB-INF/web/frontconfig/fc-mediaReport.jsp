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
	<title>前台界面配置-媒体报道</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<!-- <div class="search">
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
							<form id="" class="" action="">
								<span class="con-item">
									<span>添加时间</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item">
									<span>图片标题</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item">
									<span>状态</span><input type="text" class="" placeholder="" />
								</span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div> -->
			
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-hotNews-add" onclick="addOrUpdate(1)" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-hotNews-mod" onclick="addOrUpdate(2)" type="button">修改</button>
								<input type="hidden" id="hostPath" value="${hostPath}"/>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="mediaTb" class="display">
								<tbody>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
				<div class="w-content pic-add">
				  <form action="" id="dataForm" method="post">
					<table>
						<tr>
							<td class="tt">标题</td>
							<td class="con"><input type="text" name="title"  id="title" class="" /></td>
						</tr>
						<tr>
							<td class="tt">来源</td>
							<td class="con"><input type="text" name="source" id="source"  class="" /></td>
						</tr>
						<tr>
							<td class="tt">图标</td>
							<td class="con">
								<!--dom结构部分-->
								<div id="uploader">
								    <!--用来存放item-->
								    <div class="" id="fileList"></div>
								    <div id="filePicker">选择图片</div>
								    <span class="rec-dimensions">建议尺寸：100*100</span>
								    <img id="showImg" src="">
								    <input type="hidden" name="logo" id="pictureUrl" />
								    <input type="hidden" name="reportId" id="reportId" />
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt">内容</td>
							<td class="con">
								<input type="hidden" name="content" id="content" />
								<script id="editor" type="text/plain" style="height:300px;width:98%;"></script>
							</td>
						</tr>
					</table>
					</form>
				</div>
				
				<div class="w-content report-det">
					详情
				</div>
				<div class="w-content pic-view">
								<div class="w-content hideHtml">暂无头像</div>
								<img id="picView" src="">
				</div>
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="js/frontconfig/fc-mediaReport.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>
	
</body>

</html>