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
	<title>配置中心</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</head>
<!-- 配置中心--------会员信用等级配置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
				<jsp:param value="配置中心" name="loc6" />
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
					  		<div class="action_item">
					  			<button class="obtn glyphicon glyphicon-plus obtn-memcredit-grade-add">添加</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
					<!-- 添加会员等级配置 -->
					<div class="w-content memcredit-grade-add">
						<table>
							<tr>
								<td class="tt"><label class="ineed">会员信用等级：</label></td>
								<td class="con">
									<input type="text" id="levelMark" placeholder="会员信用等级" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">对应开始分数：</label></td>
								<td class="con">
									<input type="text" id="creditScoreMin"  class="" placeholder="对应开始分数" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>对应结束分数：</label></td>
								<td class="con">
									<input type="text" id="creditScoreMax" placeholder="对应结束分数" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>等级描述：</label></td>
								<td class="con">
									<textarea col="30" id="levelDetail" row="5" placeholder="等级描述"></textarea>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<script type="text/javascript" src="js/config/member-credit-grade.js"></script>
		<!-- 私用js -->
		</div>
	</div>
</body>

</html>