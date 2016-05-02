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
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
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
				<jsp:param value="201" name="_index_m2"/>
				<jsp:param value="20109" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
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
										<span class="con-item"><span>状态</span><select><option>待审核</option><option>通过</option><option>驳回</option></select></span>
										<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</form>
							  	</div>
							 </div>
						</div> 
						<div class="contentTable">
							<div class="action_item">
								<table class="filterTable">
									<tr>
										<td id="0" class="obtn glyphicon filterTd_click" onclick="">实名认证</td>
										<td id="1" class="obtn glyphicon" onclick="dataAuten();">手机认证</td>
										<td id="2" class="obtn glyphicon" onclick="dataAuten();">征信认证</td>
										<td id="3" class="obtn glyphicon" onclick="dataAuten();">住址认证</td>
										<td id="4" class="obtn glyphicon" onclick="dataAuten();">婚姻认证</td>
										<td id="5" class="obtn glyphicon" onclick="dataAuten();">工作认证</td>
										<td id="6" class="obtn glyphicon" onclick="dataAuten();">学历认证</td>
										<td id="7" class="obtn glyphicon" onclick="dataAuten();">股权认证</td>
										<td id="8" class="obtn glyphicon" onclick="dataAuten();">职称认证</td>
										<td id="9" class="obtn glyphicon" onclick="dataAuten();">社保认证</td>
										<td id="10" class="obtn glyphicon" onclick="dataAuten();">房产认证</td>
										<td id="11" class="obtn glyphicon" onclick="dataAuten();">车产认证</td>
										<td id="12" class="obtn glyphicon" onclick="dataAuten();">银行流水认证</td>
										<td class="obtn glyphicon" onclick="dataAuten();">其它</td>
									</tr>
								</table>
								
								
								<!-- <div class="buttonCombination" style="display:inline-block">
									<button class="">认证</button>
									<button class="">查看</button>
								</div> -->
								
							</div>
							<div id="panel-body" class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>会员登录名</th>
											<th>姓名</th>
											<th>性别</th>
											<th>身份证号</th>
											<th>籍贯</th>
											<th>手机号</th>
											<th>申请时间</th>
											<th>有效期</th>
											<th>所属服务器</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>会员登录名</td>
											<td>姓名</td>
											<td>性别</td>
											<td>身份证号</td>
											<td>籍贯</td>
											<td>手机号</td>
											<td>申请时间</td>
											<td>有效期</td>
											<td>所属服务器</td>
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
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
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
					"aTargets" : [0,1,2,3,4,5,6,7,8,9]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</body>