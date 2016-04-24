<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
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
	<title></title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="css/frontconfig/fc-webAuthentication.css"/>
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="w-content ishow" id="webauthen-add">
				<form id="addauthenform" role="form" class="addauthenform">
					<table>
						<tr>
							<td><label>网站认证资料标题</label></td>
							<td id="addauthentitle"><input type="text" value="" datatype="z2_8"/></td>
						</tr>
						<tr>
							<td><label>网站认证资料链接</label></td>
							<td id="addauthenlink"><input type="text" value="" datatype="strRegex"/></td>
						</tr>
						<tr>
							<td class="tt"><label>网站认证资料图</label></td>
							<td class="con">
							   <!--  dom结构部分 -->
								<div id="uploader">
								    <!-- 用来存放item -->
								    <div id="filePicker">选择图片</div>
								    <span class="rec-dimensions">建议尺寸：98*37</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top"><label>图片预览：</label></td>
							<td class="con">
								<div id="fileList">
								</div>
							</td>
						</tr>
					</table>
				</form> 
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
	<script type="text/javascript" src="js/upload.js"></script>
	<script>
		$(function(){
			validform5("layui-layer-btn0","addauthentitle",false,"3");
		});
		$(function(){
			validform5("layui-layer-btn0","addauthenlink",false,"3");
		});
		 $(function(){
			validform5("layui-layer-btn0","modauthentitle",false,"3");
		});
		$(function(){
			validform5("layui-layer-btn0","modauthenlink",false,"3");
		});
	</script>
</body>
</html>