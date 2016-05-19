<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long memberId =IntegerAndString.StringToLong(request.getParameter("content"), 0);
	String index3 = request.getParameter("_index_m3");
	String index2 = request.getParameter("_index_m2");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" />  -->
	<base href="<%=basePath%>">
	<title>借款项目查询</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
</head>


<body class="nav-md">
	<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-member.jsp">
				<jsp:param value="<%=index2 %>" name="_index_m2"/>
				<jsp:param value="<%=index3 %>" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
	<!-- 地址导航 -->
	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<div class="container body addContainer">
		<div class="main_container">
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
									<span class="con-item textRight"><span>会员编号</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span class="phoneNum">手机号</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span class="registerTime">注册时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
								</div>
								<div>
									<span class="con-item textRight"><span>会员名称</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span>会员用户名</span><input type="text" class="notspecial" ></span>
									<span class="con-item textRight"><span>开通第三方时间</span><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" ></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search inquiryBtn">查询</button>
								</div>
								
							</form>
					  	</div>
					 </div>
				</div> 
				<div class="data_display">
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>

								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>
	
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/memberInvite.js"></script>
	<script type="text/javascript">
		var memberId = <%=memberId %>;
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		memberId = encrypt.encrypt(memberId+"");
		showMemberInviteList(memberId);//邀請
	</script>
</div>


