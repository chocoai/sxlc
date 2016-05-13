<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="<%=basePath%>">
	<title>首页全屏弹出公告——修改图片</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>
<body class="nav-md">
	<div class="container body addContainer">
		<div class="main_container">
			<div class="w-content ishow pic-add">
				<table>	
					<tr>
						<td class="tt"><label style="width:107px;">公告链接：</label></td>
						<td class="con" id="fullAdLink1">
							<input type="text" class="" datatype="strRegex" value="" />
						</td>
					</tr>
					<tr>
						<td class="tt"><label>开始截止日期：</label></td>
						<td class="con">
							<input type="text" class="" value="" />
						</td>
					</tr>
					<tr>
						<td class="tt"><label>弹出总次数：</label></td>
						<td class="con" id="fullAdLink2">
							<input type="text" class="" datatype="days" value="" />
						</td>
					</tr>
					<tr>
						<td class="tt"><label>日弹最大次数：</label></td>
						<td class="con" id="fullAdLink3">
							<input type="text" class="" datatype="days" value="" />
						</td>
					</tr>			
					<tr>
						<td class="tt"><label>上传图片：</label></td>
						<td class="con">
							<div id="logo">
							    <!--用来存放item-->
							    <div id="filePicker">选择图片</div>
							    <span class="rec-dimensions">建议尺寸：580*280</span>
							</div>
						</td>
					</tr>
					<tr>
						<td class="tt" valign="top">图片预览：</td>
						<td class="con" id="fileList"></td>
					</tr>																
				</table>
			</div>	
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/fc-fullAd.js"></script>	
</body>
</html>