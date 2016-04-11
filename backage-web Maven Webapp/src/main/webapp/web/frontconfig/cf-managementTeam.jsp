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
	<title>前台界面配置-管理团队</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<script type="text/javascript" src="<%=basePath%>/plugs/My97DatePicker/WdatePicker.js"></script>
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
							<form id="" class="" action="">
								<span class="con-item">
									<span>添加时间</span>
									<input type="text" id="addDate" class="" onfocus="WdatePicker({isShowWeek:true})" placeholder="" />
								</span>
								<span class="con-item">
									<span>姓名</span><input type="text" id="name" class="" placeholder="" />
								</span>
								<button class="obtn obtn-query glyphicon glyphicon-search" type="button">查询</button>
								<input type="hidden" id="hostPath" value="${hostPath}"/>
							</form>
						</div>
						
						<div class="w-content pic-add">
							<form action="javascript:addOrModify()" id="dataForm" method="post">
								<table>
									<tr>
										<td class="tt">姓名</td>
										<td class="con"><input type="text" name="mngName" id="mngName" class="" datatype="z2_8" /></td>
									</tr>
									<tr>
										<td class="tt">职务</td>
										<td class="con"><input type="text" name="mngPost" id="mngPost" class="" /></td>
									</tr>
									<tr>
										<td class="tt">头像</td>
										<td class="con portrait-box">
											<!--dom结构部分-->
											<div id="uploader">
											    <!--用来存放item-->
											    <div class="" id="fileList"></div>
											    <div id="filePicker">选择头像</div>
											    <span class="rec-dimensions">建议尺寸：100*100</span>
											     <img id="portrait" src="">
											     <input type="hidden" name="portraitUrl" id="portraitUrl" />
											     <input type="hidden" name="teamId" id="teamId" />
											</div>
										</td>
									</tr>
									<tr>
										<td class="tt" valign="top">简介</td>
										<td class="con">
											<textarea rows="6" cols="" name="profile" id="profile" class="ta-noresize w500"></textarea>
										</td>
									</tr>
								</table>
								</form>
							</div>
							<div class="w-content pic-view">
								<div class="w-content hideHtml">暂无头像</div>
								<img id="picView" src="">
							</div>
					</div>
				</div>
			
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="addOrUpdate(1)" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="addOrUpdate(2)" type="button">修改</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="teamTb" class="display">
							</table>
						</div>
						
					</div>
				</div>
				
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
	<!-- <script type="text/javascript" src="js/exp-upload.js"></script> -->
	<!-- 私用js -->
	<script type="text/javascript" src="js/frontconfig/cf-manage.js"></script>
</body>

</html>