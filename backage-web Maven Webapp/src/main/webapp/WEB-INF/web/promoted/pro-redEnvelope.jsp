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
	<title>平台推广-关系年限</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
	<link rel="stylesheet" href="css/promoted/pro-redEnvelope.css" type="text/css">
	
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
				<jsp:param value="1006" name="_index_m2"/>
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
									<span class="con-item"><span>添加时间</span><input type="text" id="startDate1" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate1" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>开始时间</span><input type="text" id="startDate2" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate2" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>结束时间</span><input type="text" id="startDate3" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate3" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>状态</span>
										<select id="statu">
											<option value="2">已结束</option>
											<option value="1">领取中</option>
											<option value="0">未发布</option>
										</select>
									</span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addRedE();">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="alertRedE();">修改</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export">发布</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="getDetail()">领取明细</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
								</table>
							</div>
							
						</div>
					</div>
					
					<!-- 添加部分  -->
					<div class="" id="addRedE">
						<form id="addRedEForm" action="javascript:addRecord()" type="post">
							<div>
								<span class="tt">活动起止时间：</span>
								<span class="col"><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
							</div>
							<div>
								<span class="tt">活动名称：</span>
								<span class="col"><input id="affairName" class="notspecial" datatype="describeC"></span>
							</div>
							<div id="redMany">
								<div class="redEContent isActive"  id = "RM0">
									<span class="tt">红包金额：</span>
									<span class="col">
										<input datatype="acountM" class="moneyInput money">元
										<input datatype="nNum1" class="moneyInput num">个
										<a class="redEAdd">增加</a>
									</span>
								</div>
								<%for(int i = 1 ;i<20 ; i++){ %>
								<div class='redEContent notActive' id = "RM<%=i %>">
									<span class='tt'></span>
									<span class='col'>
										<input datatype='acountM' class='moneyInput money' >元
										<input datatype='nNum1' class='moneyInput num' >个
										<a class='redDelete'>删除</a>
									</span>
								</div>
								<%} %>
							</div>
							<div>
								<span class="tt">活动有效期：</span>
								<span class="col"><input id="userendDate" type="text" class="notspecial Wdate" onFocus="WdatePicker()"/></span>
							</div>
							<div class="btnAdd">
								<button id="addRecord" class="addBtn">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
					
					
					<!-- 修改部分 -->
					<div class="" id="alertRedE">
						<form id="alertRedEForm" action="javascript:modRed()">
							<div>
								<span class="tt">活动起止时间时间：</span>
								<span class="col"><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
							</div>
							<div>
								<span class="tt">活动名称：</span>
								<span class="col"><input class="notspecial" datatype="describeC"></span>
							</div>
							<div id = "redChange">
								<div class="redEContent isActive2"  id = "RMC0">
									<span class="tt">红包金额：</span>
									<span class="col">
										<input datatype="acountM" class="moneyInput money">元
										<input datatype="nNum1" class="moneyInput num">个
										<a class="redEAdd">增加</a>
									</span>
								</div>
								<%for(int i = 1 ;i<20 ; i++){ %>
								<div class='redEContent notActive2' id = "RMC<%=i %>">
									<span class='tt'></span>
									<span class='col'>
										<input datatype='acountM' class='moneyInput money' >元
										<input datatype='nNum1' class='moneyInput num' >个
										<a class='redDelete'>删除</a>
									</span>
								</div>
								<%} %>
							</div>
							<div>
								<span class="tt">活动有效期：</span>
								<span class="col"><input type="text" class="notspecial Wdate" onFocus="WdatePicker()"/></span>
							</div>
							<div class="btnAdd">
								<button id="modRed" class="addBtn">确认修改</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/pro-redEnvelope.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
		function getDetail() {
			var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
			window.location.href='<%=path %>/web/promoted/pro-receiveDetail.jsp?content=' + rowdata[0].affairID;
		}
	</script>
</body>

</html>