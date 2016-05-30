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
	<title>平台推广管理-推荐达人申请审核</title>
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
				<jsp:param value="10" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-promoted.jsp">
				<jsp:param value="1003" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
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
									<span class="con-item"><span>会员编号</span><input id="memberNo" type="text" class="notspecial" /></span>
									<span class="con-item"><span>会员用户名</span><input id="logname" type="text" class="notspecial" /></span>
									<span class="con-item"><span>注册时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>姓名</span><input id="personalName" type="text" class="notspecial" /></span>
									<span class="con-item">
										<span>状态</span>
										<select id="checkStatu">
											<option value="1">通过</option>
											<option value="-1">打回</option>
											<option value="0">审核中</option>
										</select>
									</span>
									<span class="con-item"><span>所在地</span><input id="houseAddress" type="text" class="notspecial" /></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button id="" class="obtn glyphicon glyphicon-plus obtn-exam">审核</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
								</table>
							</div>
						</div>
					</div>
				
				</div>
			</div>
			<!-- 审核弹出层2016-05-11伍成然 -->
			<div class="layerExam" style="display:none">
				<table>
					<tr class="col-md-12">
						<td class="tt"><label>会员编号：</label></td>
						<td class="con">
							<span id="memberNo1"></span>
						</td>
					</tr>
					<tr class="col-md-12">	
						<td class="tt"><label>会员用户名：</label></td>
						<td class="con">
							<span id="logname1"></span>
						</td>
					</tr>	
					<tr class="col-md-12">
						<td class="tt"><label>姓名：</label></td>
						<td class="con">
							<span id="personalName1"></span>
						</td>
					</tr>	
					<tr class="col-md-12">	
						<td class="tt"><label>手机号：</label></td>
						<td class="con">
							<span id="personalPhone1"></span>
						</td>
					</tr>	
					<tr class="col-md-12">	
						<td class="tt"><label>审核结果：</label></td>
						<td class="con">
							<select class="w3" id="checkStatu">
								<option value="">请选择</option>
								<option value="1">通过</option>
								<option value="-1">拒绝</option>
								<!-- <option value="-1">踢出</option> -->
							</select>
						</td>
					</tr>
					<tr class="col-md-12">	
						<td class="tt"><label>审核意见：</label></td>
						<td class="con">
							<textarea id="remark" rows="2" cols="" class="ta-noresize"></textarea>
						</td>
					</tr>	
				</table>
			</div>
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/pro-applicationAudit.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>