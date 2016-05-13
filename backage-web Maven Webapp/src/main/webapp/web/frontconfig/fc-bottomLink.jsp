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
	<title>前台界面配置-底部导航管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="css/frontconfig/fc-bottomLink.css"/>
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
								<button class="obtn glyphicon glyphicon-plus" onclick="addNavigation()" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="modNavigation()" type="button">修改</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="bottomnavtable" class="display">
							</table>
						</div>
						<!-- 添加部分开始 -->
						<div class="w-content" id="bottomnav-add">
							<form id="saveBoot" role="form" class="addnavform" action="javascript:addBoot()" type="post">
								<table>
									<tr>
										<td><label>导航标题</label></td>
										<td id="addnavtitle"><input id="stitle" type="text" value="" datatype="z2_8"/></td>
									</tr>
									<tr>
										<td><label>导航标题链接</label></td>
										<td id="addnavlink"><input id="surl" type="text" value="" datatype="strRegex"/></td>
									</tr>
									<tr>
										<td><label>导航所属种类</label></td>
										<td id="bootType">
											
										</td>
									</tr>
								</table>
							</form>
						</div>
						<!-- 添加部分结束 -->
						<!-- 修改部分开始 -->
						<div class="w-content" id="bottomnav-mod">
							<form id="updateBoot" role="form" action="javascript:modBoot()" type="post" class="addnavform">
								<table>
									<tr>
										<td><label>导航标题</label></td>
										<td id="modnavtitle"><input id="mtitle" type="text" value="" datatype="z2_8"/></td>
									</tr>
									<tr>
										<td><label>导航标题链接</label></td>
										<td id="modnavlink"><input id="murl" type="text" value="" datatype="strRegex"/></td>
									</tr>
									<tr>
										<td><label>导航所属种类</label></td>
										<td id="mtype">
										</td>
									</tr>
								</table>
							</form>
						</div>
						<!-- 修改部分结束 -->
					</div>
				</div>
			</div>
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/frontconfig/fc-bottomLink.js"></script>
	<script type="text/javascript">
		 $(function(){
			validform5("layui-layer-btn0","addnavtitle",false,"3");
		});
		$(function(){
			validform5("layui-layer-btn0","addnavlink",false,"3");
		});
		 $(function(){
			validform5("layui-layer-btn0","modnavtitle",false,"3");
		});
		$(function(){
			validform5("layui-layer-btn0","modnavlink",false,"3");
		});
		
	</script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
	
</body>

</html>