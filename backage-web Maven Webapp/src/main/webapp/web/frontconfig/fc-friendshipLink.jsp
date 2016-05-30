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
	<title>前台界面配置-友情链接配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="css/frontconfig/fc-friendshipLink.css"/>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp">
				<jsp:param value="514" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus" onclick="addLink()" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="modLink()" type="button">修改</button>
								<button class="obtn glyphicon glyphicon-trash delLink" onclick="delLink()" type="button">删除</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="fltable" class="display">
							</table>
						</div>
						<!-- 添加部分开始 -->
						<div class="w-content" id="friendlink-add">
							<form role="form" class="addlinkform">
								<div class="form-group" id="addlinkname"> 
									<label>链接名称</label><input id="stitle" type="text" value="" datatype="notSpecial"/>
								</div>
								<div class="form-group" id="addlinkaddress"> 
									<label>链接地址</label><input id="surl" type="text" value="" datatype="strRegex"/>
								</div>
							</form>
						</div>
						<!-- 添加部分结束 -->
						<!-- 修改部分开始 -->
						<div class="w-content" id="friendlink-mod">
							<form role="form" class="addlinkform">
								<div class="form-group" id="modlinkname"> 
									<label>链接名称</label><input id="mtitle" type="text" value="" datatype="notSpecial"/>
								</div>
								<div class="form-group" id="modlinkaddress"> 
									<label>链接地址</label><input id="murl" type="text" value="" datatype="strRegex"/>
								</div>
							</form>
						</div>
						<!-- 修改部分结束 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/frontconfig/fc-friendshgipLink.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="js/rsa/RSA.js"></script> 
	<script type="text/javascript" src="js/rsa/Barrett.js"></script>
	<script type="text/javascript" src="js/rsa/BigInt.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
	<script type="text/javascript">
		$(function(){
			validform5("layui-layer-btn0","addlinkname",false,"5");
		});
		$(function(){
			validform5("layui-layer-btn0","addlinkaddress",false,"5");
		});
		$(function(){
			validform5("layui-layer-btn0","modlinkname",false,"5");
		});
		$(function(){
			validform5("layui-layer-btn0","modlinkaddress",false,"5");
		});
	</script>
	
</body>

</html>