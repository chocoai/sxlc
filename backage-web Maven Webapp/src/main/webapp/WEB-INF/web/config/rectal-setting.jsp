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
	<title>配置中心--财务配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置  推荐达人提奖设置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			 	<!-- 推荐达人提奖设置 -->
			 	<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-pic-add" onclick="handleBtn(1)" type="button">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-pic-mod" onclick="handleBtn(2)" type="button">修改</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
				</div>
				<!-- 添加部分开始 -->
				<div class="w-content" id="addrectal">
				   <form action="" id="dataForm" method="post">
					<table>
						<tr>
							<input type="hidden" id="rewardId">
							<td class="tt"><label class="ineed">等级名称</label></td>
							<td class="con"><input type="text" class="gradeName" placeholder="" datatype="rolename"></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">等级投资总金额</label></td>
							<td class="con" ><input type="text" class="totalInvest" placeholder="" datatype="amcountM"></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">等级描述</label></td>
							<td class="con" ><textarea datatype="describeC" class="recaltextarea"></textarea></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">推荐VIP提奖金额</label></td>
							<td class="con" ><input type="text" class="vIPReward" placeholder="" datatype="amcountM"></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">推荐借款提奖百分比</label></td>
							<td class="con" ><input type="text" class="borrowReward" placeholder="" datatype="hundredNum"></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">推荐借款还本提奖百分比：</label></td>
							<td class="con"><input type="text" class="repayReward" placeholder="" datatype="hundredNum"></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">推荐投资收益提奖百分比：</label></td>
							<td class="con"><input type="text" class="investReward" placeholder="" datatype="hundredNum"></td>
						</tr>
						<tr>
							<td class="tt"><label class="ineed">推荐投资提奖百分比：</label></td>
							<td class="con"><input type="text" class="" placeholder="" datatype="hundredNum"></td>
						</tr>
					</table>
					</form>
				</div>
			 </div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/config/rectal-setting.js"></script>
</body>

</html>