<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int content = Integer.parseInt(request.getParameter("content"));
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>营业执照认证</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/companyMembers.css" type="text/css" >
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp">
				<jsp:param value="202" name="_index_m2"/>
				<jsp:param value="20209" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<!-- tab切换 -->
						<jsp:include page="../common/mc-companyTable.jsp"></jsp:include>
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="" class="" action="">
										<span class="con-item"><span>会员登录名</span><input type="text" class="notspecial" ></span>
										<span class="con-item"><span>姓名</span><input type="text" class="notspecial" ></span>
										<span class="con-item"><span>身份证号</span><input type="text" class="notspecial" ></span>
										<span class="con-item"><span>状态</span><select class="auditState"><option>待审核</option><option>通过</option><option>驳回</option></select></span>
										<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</form>
							  	</div>
							 </div>
						</div> 		
						<div class="buttonCombination" style="display:inline-block">
							<button class="cerfiedBtn" onclick="jump(<%=content %>,1,'web/member/businessLicenseCResualt.jsp')">认证</button>
							<button class="checkBtn" onclick="jump(<%=content %>,2,'web/member/businessLicenseCResualt.jsp')">查看</button>
						</div>
						<div id="panel-body" class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>会员登录名</th>
										<th>企业名称</th>
										<th>住所</th>
										<th>法人代表姓名</th>
										<th>公司类型</th>
										<th>注册资金(元)</th>
										<th>实收资本(元)</th>
										<th>经营范围</th>
										<th>成立日期</th>
										<th>申请时间</th>
										<th>有效期</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>会员登录名</td>
										<td>企业名称</td>
										<td>住所</td>
										<td>法人代表姓名</td>
										<td>公司类型</td>
										<td class="moneyFormat">10000</td>
										<td class="moneyFormat">10000</td>
										<td>经营范围</td>
										<td>成立日期</td>
										<td>申请时间</td>
										<td>有效期</td>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/companyMembers.js"></script>
	<script type="text/javascript" src="js/member/personAuthen.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#table_id').DataTable({
				"scrollX":true,
				//"scrollY":true,
				"aaSorting" : [  ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3,4,5,6,7,8,9,10,11]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</body>