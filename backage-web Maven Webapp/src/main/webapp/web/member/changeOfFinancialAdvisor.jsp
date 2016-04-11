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
	<title>理财顾问变更</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" type="text/css" href="css/membershipManagement.css">
	
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp"></jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- <ul class="nav nav-tabs">
					<li role="presentation" class="allMembers"><a href="javascript:;">全部会员</a></li>
					<li role="presentation" class="active "><a href="javascript:;">VIP会员</a></li>
					<li role="presentation" class="registeredMemberCu"><a href="javascript:;">注册会员</a></li>
					<li role="presentation" class="authenticationInformation"><a href="javascript:;">认证会员</a></li>
					<li role="presentation" class="loanMemberCu"><a href="javascript:;">借款会员</a></li>
					<li role="presentation" class="investmentMemberCu"><a href="javascript:;">投资会员</a></li>
					<li role="presentation" class="compositeMemberCu"><a href="javascript:;">复合会员</a></li>
					<li role="presentation" class=""><a href="javascript:;">会员黑名单</a></li>
					<li role="presentation" class=""><a href="javascript:;">资料认证</a></li>
					<li role="presentation" class=""><a href="javascript:;">会员分配理财顾问</a></li>
					<li role="presentation" class=""><a href="javascript:;">理财顾问变更</a></li>
				</ul> -->
				<div class="search">
					<div class="panel panel-success boxRadius">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<span class="glyphicon glyphicon-search"></span>
										<span>查询</span>
									</li>
									<a class="state">
										<span class="glyphicon glyphicon-chevron-down"></span>
									</a>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form class="" action="">
								<span class="con-item"><span>用户名</span><input type="text" class="" placeholder="用户名" /></span>
								<span class="con-item"><span>姓名</span><input type="text" class="" placeholder="姓名" /></span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
					  	</div>
					</div>
				</div> 
				<div class="data_display i-mt">
					<div class="panel panel-success boxRadius">
					  <div class="panel-heading">
					  	<div class="action_item">
							<button class="obtn glyphicon glyphicon-plus">添加</button>
							<button class="obtn glyphicon glyphicon-pencil">修改</button>
							<button class="obtn glyphicon glyphicon-trash">删除</button>
						 	<button class="obtn glyphicon queryHistoryAdvisorCunt">查询历史理财顾问变更记录</button>
						 	<button class="obtn glyphicon changeFinancialAdvisorCunt">变更理财顾问</button>
						</div>
				</div>
					<div class=" panel-body tScroll">
						<table id="memberSelect" class="display table-hover memberselect_b">
						  <thead>
							<tr>
								<th> </th>
								<th rowspan="1" colspan="1">会员编号</th>
								<th class="sorting_asc" >会员用户名</th>
								<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width: 133px;">会员姓名</th>
								<th>注册时间</th>
								<th>是否开通第三方</th>
								<th>理财顾问姓名</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-checkbox sorting_disabled" rowspan="1" colspan="1">
									<input class="group_checkable" type = "checkbox" onclick="selectAll(this)">
								</td>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>13000000000</td>
								<td>四川省成都市郫县</td>
								<td>123456789123456789</td>
							</tr>
							<tr>
								<td class="table-checkbox sorting_disabled" rowspan="1" colspan="1">
									<input class="group_checkable" type = "checkbox" onclick="selectAll(this)">
								</td>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>13000000000</td>
								<td>四川省成都市郫县</td>
								<td>123456789123456789</td>
 							</tr>
						</tbody>
	                    </table>
					</div>
					</div>
				</div>
			
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>

	
	<!-- 查询历史理财顾问变更记录 -->
	<div class="queryHistoryAdvisor">
		<div class="panel-body">
			<form class="" action="">
				<span class="con-item"><span>变更时间</span><input type="text" class="" placeholder="变更时间" /></span>
				<span class="con-item"><span>理财顾问姓名</span><input type="text" class="" placeholder="理财顾问姓名" /></span>
				<span class="con-item"><span>变更操作管理员</span><input type="text" class="" placeholder="变更操作管理员" /></span>
				<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
			</form>
		</div>
	</div>
	
	
	<!-- 变更理财顾问 -->
	<div class="changeFinancialAdvisor_a">
		<div class="panel-body">
			<form class="" action="">
				<span class="con-item"><span>用户名</span><input type="text" class="" placeholder="用户名" /></span>
				<span class="con-item"><span>姓名</span><input type="text" class="" placeholder="姓名" /></span>
				<button class="obtn obtn-query glyphicon glyphicon-search">保存</button>
			</form>
		</div>
	</div>

	

	

	

	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/membershipManagement.js"></script>
</body>

</html>