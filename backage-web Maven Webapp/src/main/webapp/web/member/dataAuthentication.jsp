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
	<title>资料认证</title>
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
						 	<button class="obtn glyphicon memberCertificationDetailsCunt">会员认证详情</button>
							<!--<button class="obtn glyphicon loanItemQueryCunt">借款项目查询</button>
							<button class="obtn glyphicon nvestmentProjectInquiryCunt">投资项目查询</button>
							<button class="obtn glyphicon transactionRecordCunt">交易记录</button> -->
						</div>
				</div>
					<div class=" panel-body tScroll">
						<table id="memberSelect" class="display table-hover memberselect_b">
						  <thead>
							<tr>
								<th> </th>
								<th rowspan="1" colspan="1">营业执照认证</th>
								<th class="sorting_asc" >工商执照认证</th>
								<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width: 133px;">组织机构代码认证</th>
								<th>开户许可证认证</th>
								<th>企业银行流水认证</th>
								<th>实地考察认证</th>
								<th>税务登记认证</th>
								<th>批文认证</th>
								<th>财务资料认证</th>
								<th>监管单位认证</th>
								<th>房产认证</th>
								<th>车产认证</th>
								<th>担保考察认证</th>
								<th>VIP认证</th>
								<th>其他</th>
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
								<td>100.00</td>
								<td>50.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
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
								<td>100.00</td>
								<td>50.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
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

	
	<!-- 会员认证详情 -->
	<div class="memberCertificationDetails"></div>

	

	

	

	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/membershipManagement.js"></script>
</body>

</html>