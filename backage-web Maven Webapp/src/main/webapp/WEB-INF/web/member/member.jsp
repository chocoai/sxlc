<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" />  -->
	<base href="<%=basePath%>">
	<title>会员管理全部会员</title>
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
				<jsp:param value="20101" name="_index_m3"/>
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
									<span class="con-item"><span>会员姓名</span><input type="text" name="member_Name" id="member_Name" class="notspecial" /></span>
									<span class="con-item"><span>用户名</span><input type="text" name="user_Name" id="user_Name" class="notspecial" /></span>
									<span class="con-item"><span>手机号</span><input type="text" name="phone_Num" id="phone_Num" class="notspecial" /></span>
									<span class="con-item"><span>开启自动投标</span><select name="auto_tou" id="auto_tou"><option value="1">是</option><option value="0">否</option></select></span>
									<span class="con-item"><span>开启自动还款</span><select name="auto_return" id="auto_return"><option value="1">是</option><option value="0">否</option></select></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon examine" onclick="detailView();">查看会员详情</button>
									<button class="obtn glyphicon" onclick="loanView();">借款项目查询</button>
									<button class="obtn glyphicon" onclick="investView();">投资项目查询</button>
									<button class="obtn glyphicon" onclick="transactionRecord();">交易记录</button>
									<button class="obtn glyphicon" onclick="cardView()">银行卡查询</button>
									<button class="obtn glyphicon" onclick="inviteView();">查看邀请会员列表</button>
									<button class="obtn glyphicon defriend">拉黑</button>
									<button class="obtn glyphicon" onclick="resetPWDRecord();">会员密码重置记录</button>
									<button class="obtn glyphicon" onclick="resetPWD('重置密码','web/member/allMembers/resetPWDC.jsp','2')">会员密码重置</button>
									<button class="obtn glyphicon" onclick="inviteVip();">修改邀请会员</button>
									<button class="obtn glyphicon" onclick="messageSendPer('发送信息','web/member/allMembers/per-messageSend.jsp','2');">发送消息</button>
								</div>
							</div>
							
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
		</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript" src="js/member/memberPwd.js"></script>
	<script type="text/javascript" src="js/member/allmember.js"></script>

</body>