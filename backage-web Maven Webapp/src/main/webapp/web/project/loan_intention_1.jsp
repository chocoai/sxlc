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
	<title>项目管理——借款申请管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" >
	<link rel="stylesheet" href="css/upload.css" >
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/loan_intention.css" type="text/css">
</head>
<!-- 借款申请管理--------借款意向列表查询 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="302" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:;">借款意向列表查询</a>
					</li>
					<li role="presentation" class=""><a href="project/toLoanApplyPg">直接意向借款</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item col-md-3 col-sm-5 col-xs-5"><span>会员编号</span><input id="memberNo" type="text" class="notspecial"  /></span>
									<span class="con-item col-md-3 col-sm-5 col-xs-5"><span>会员用户名</span><input id="logname" type="text" class="notspecial" /></span>
									<span class="con-item col-md-3 col-sm-5 col-xs-5"><span>会员联系号码</span><input id="personalPhone" type="text" class="notspecial"  /></span>
									<span class="con-item col-md-3 col-sm-5 col-xs-5"><span>还款方式</span><input id="repayWay" type="text" class="notspecial" /></span>
									<span class="col-md-12"><button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button></span>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<div class="action_item">
					  			<button id="pro_allocation" class="obtn glyphicon glyphicon-plus" onclick="allocation()">项目分配理财顾问</button>
								<button id="add_information" class="obtn glyphicon glyphicon-pencil" onclick="addInfo()">补充资料</button>
								<button id="loan_exam_record" class="obtn glyphicon glyphicon-ok-circle">查看审批记录</button>
								<button id="refuse_payment" class="obtn glyphicon glyphicon-trash">拒绝借款</button>
								<button id="loan_member_black" class="obtn glyphicon glyphicon-trash">借款会员拉黑</button>
								<button id="loan_detail" class="obtn glyphicon glyphicon-pencil" onclick="view_detail()">查看项目借款详情</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
				</div>
			</div>	
			</div>
			<!-- 分配理财顾问弹出层2016-4-26伍成然 -->
			<div class="allocation">
			  	<div class="form-group">
					<label>请选择理财顾问：</label>
					<select>
						<option>顾问1</option>
						<option>顾问2</option>
						<option>顾问3</option>
						<option>顾问4</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="js/project/loan_intention_1.js"></script>
</body>
</html>