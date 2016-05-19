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
	<title>积分商城</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="7" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-integralMall.jsp">
				<jsp:param value="703" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- 主体部分 -->
				<div class="nav-tabs-con active">
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
									<div>
									<span class="con-item"><span>兑换时间</span><input type="text" id="startDate" class="dateInput Wdate data1 stime1" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate data1 stime2"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item"><span>发货时间</span><input type="text" id="startDate" class="dateInput Wdate data1 etime1" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate data1 etime2"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item"><span>会员用户名</span><input id="userId" type="text" class="notspecial" /></span>
									</div>
									<div>
									<span class="con-item"><span>会员姓名</span><input id="userName" type="text" class="notspecial" /></span>
									<span class="con-item"><span>联系电话</span><input id="userPhone" type="text" class="notspecial" /></span>
									<span class="con-item"><span>商品编号</span><input id="proId" type="text" class="notspecial" /></span>
									</div>
									<div>
									<span class="con-item"><span>商品名称</span><input id="proName" type="text" class="notspecial" /></span>
									<span class="con-item"><span>状态</span>
									<select id="proSelect">
									<option value="-1">所有</option>
									<option value="0">已下单</option>
									<option value="2">已发货</option>
									<option value="1">订货失败</option>
									</select>
									</span>
									<input type="button" id="ding_search" class="obtn obtn-query glyphicon glyphicon-search" value="查询"></div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										
								</table>
							</div>
							<div class="w-content ishow pic-add" id="into_dd"  style="display:none">
								
								<table id="card_id">
									<tr>
										<td class="tt">物流公司</td>
										<td class="con"><input id="into_dd1" type="text" style="width:250px;"/></td>
									</tr>
									<tr>
										<td class="tt">物流单号</td>
										<td class="con"><input id="into_dd2" type="text"  style="width:250px;"/></td>
									</tr>
									<tr>
										<td class="tt">通知信息内容</td>
										<td class="con"><textarea id="into_dd3" type="text" style="height:60px;width:250px;"></textarea></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>						
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/integralMall/integralMall_ding.js"></script>

</body>

</html>