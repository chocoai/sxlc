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
	<title>前台界面配置-专家顾问</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
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
				
			
			
				<div class="data_display">
					<div class="panel panel-success">
					
					<div class="w-content pic-add">
							<form action="javascript:addMngTeam()" id="dataForm" method="post">
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
											</div>
										</td>
									</tr>
									<tr>
										<td class="tt" valign="top">简介</td>
										<td class="con">
											<textarea rows="6" cols="" name="profile" id="profile" class="ta-noresize w500">测试</textarea>
										</td>
									</tr>
								</table>
								</form>
							</div>
							<div class="w-content pic-view">
								<img id="picView" src="">
							</div>
					
					
					<div class="w-content pic-mod">
							<form action="javascript:updateExpertTeamByID()" id="dataFor" method="post">
								<table>
									<tr>
										<td class="tt">专家姓名</td>
										<td class="con"><input type="text" name="mngName" id="mngNam" class="" datatype="z2_8" /></td>
									</tr>
									<tr>
										<td class="tt">职务</td>
										<td class="con"><input type="text" name="mngPost" id="mngPos" class="" /></td>
									</tr>
									<tr>
										<td class="tt">头像</td>
										<td class="con portrait-box">
											<!--dom结构部分-->
											<div id="uploader">
											    <!--用来存放item-->
											    <div class="" id="fileList"></div>
											    <div id="filePickers">选择头像</div>
											    <span class="rec-dimensions">建议尺寸：100*100</span>
											    <img id="portrait" src="">
											     <input type="hidden" name="portraitUrl" id="portraitUr" />
											</div>
										</td>
									</tr>
									<tr>
										<td class="tt" valign="top">简介</td>
										<td class="con">
											<textarea rows="6" cols="" name="profile" id="profil" class="ta-noresize w500">测试</textarea>
										</td>
									</tr>
								</table>
								</form>
							</div>
							<div class="w-content pic-view">
								<img id="picView" src="">
							</div>
					
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-experts-add" onclick="expAdd()">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-experts-mod" onclick="expMod()">修改</button>
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
	<!-- 私用js -->
	<script type="text/javascript" src="js/frontconfig/cf-experts.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/exper/exper.js"></script>

</body>

</html>