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
	<title>前台界面配置-合作伙伴</title>
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
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
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
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-partner-add" onclick="addOrUpdate(1)" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-partner-mod" onclick="addOrUpdate(2)" type="button">修改</button>
								<button class="obtn" onclick="ableDisable()">停用/启用</button>
								<input type="hidden" id="hostPath" value="${hostPath}"/>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="partnerTb" class="display">
							</table>
						</div>
						
					<div class="w-content pic-add">
						<form id="savePartner" action="javascript:addPartner()" method="post" >
							<table>
								<tr>
									<td class="tt">图片标题</td>
									<td class="con"><input id="title" type="text" class="" /></td>
								</tr>
								<tr>
									<td class="tt">图片链接</td>
									<td class="con"><input id="link" type="text" class="w500" /></td>
								</tr>
								<tr>
									<td class="tt">图片选择</td>
									<td class="con">
										<!--dom结构部分-->
										<div id="uploader">
										    <!--用来存放item-->
										    <div class="" id="fileList"></div>
										    <div id="filePicker">选择图片</div>
										    <span class="rec-dimensions">建议尺寸：580*280</span>
										    <img id="showImg" src="">
										    <input type="hidden" name="logo" id="pictureUrl" />
								    		<input type="hidden" name="coopId" id="coopId" />
										</div>
									</td>
								</tr>
								<tr>
									<td class="tt" valign="top">图片预览</td>
									<td class="con">
										<input type="hidden" name="content" id="content" />
										<script id="editor" type="text/plain" style="height:300px;width:98%;"></script>
									</td>
								</tr>
							</table>
						</form>
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
	<script type="text/javascript">
	</script>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="js/frontconfig/fc-partner.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>
	
</body>

</html>