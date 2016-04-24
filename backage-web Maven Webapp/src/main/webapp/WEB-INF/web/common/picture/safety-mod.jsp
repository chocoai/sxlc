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
	<title>添加图片</title>
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
						<td class="tt"><label>保障标题：</label></td>
						<td class="con">
							<input type="text" class="" placeholder="保障标题" value="" />
						</td>
					</tr>
					<tr>
						<td class="tt"><label>链接地址：</label></td>
						<td class="con">
							<input type="text" class="" placeholder="请输入保障链接地址" value="" />
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
					<tr>
						<td class="tt"><label>保障内容：</label></td>
						<td class="con">
							<script id="applyguide" type="text/plain" style="height:160px;width:98%;"></script>
						</td>
					</tr>																		
				</table>
			</div>
		</div>		
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>	
	<script type="text/javascript" src="js/frontconfig/fc-safety.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>	
	<script type="text/javascript" src="js/upload.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">		
		var ag = UE.getEditor('applyguide');
	</script>
</body>
</html>