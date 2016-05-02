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
	<title>配置中心</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="603" name="_index_m2" />
				<jsp:param value="60304" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="javascript:;">短信接口地址</a></li>
					<li><a href="javascript:;">邮件接口地址</a></li>
				</ul>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-msgp-add" onclick="addOrUpdate(1)" type="button">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-msgp-modify" onclick="addOrUpdate(2)"  type="button">修改</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
								</table>
							</div>
						</div>
					</div>
					<!-- 短信接口地址添加 -->
					<div class="w-content msgp-add">
					 <form action="" id="dataForm" method="post">
						<table>
							<tr>
								<td class="tt"><label class="ineed">接口类型：</label></td>
								<td class="con" id="addmsginterface" >
									<select class="msginterfaceselect">
										<option value="">请选择</option>
										<option value="0">发送短信</option>
										<option value="1">接收短信</option>
										<option value="2">查询余额</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">短信接口地址：</label></td>
								<td class="con" id="">
									<input type="text" class="smsInterface" placeholder="" datatype=""/>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>序列号：</label></td>
								<td class="con" id="addserialnumber">
									<input type="text" class="smsSerialNumber" placeholder="" datatype=""/>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>密码：</label></td>
								<td class="con" id="addpassword">
									<input type="password" class="smsPassword" placeholder="" datatype="logPass"/>
								</td>
							</tr>
						</table>
						</form>
					</div>
					</div>
				<!-- 邮件接口地址 -->
				<div class="nav-tabs-con">
					<div class="config">
				 		<fieldset>
				 			<legend>邮件接口地址配置</legend>
				 			<form class="form-horizontal"  action="javascript:saveData()" id="dataForm">
				 				<div class="form-group">
				 					<label for="firstname" class="i-fl control-label col3">SMTP服务器：</label>
				 					<div class="i-fl" >
				 						<input type="text" class="form-control" id="firstname" placeholder="" value="${mailSet.smtpservice}" datatype="server">
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">端口号：</label>
				 					<div class="i-fl" >
				 						<input type="text" class="form-control" id="lastname" placeholder="" value="${mailSet.portNumber}" datatype="port">
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="firstname" class="i-fl control-label col3">邮箱地址：</label>
				 					<div class="i-fl" ><input type="text" class="form-control" value="${mailSet.emailAddress}" id="firstname" placeholder="" datatype="mail"></div>
				 				</div>
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">邮箱密码：</label>
				 					<div class="i-fl">
				 						<input type="password" class="form-control" id="lastname" placeholder="" value="${mailSet.emailPassword}" datatype="logPass">
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<div class="offset-col3">
				 						<button type="button" class="btn btn-default">保存</button>
				 					</div>
				 				</div>
				 			</form>		
				 		</fieldset>
				 	</div>	
				</div>
		</div>
	</div>
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/valid.js"></script>
	<script type="text/javascript" src="js/config/msg-interface.js"></script>
	<!-- 私用js -->
</body>

</html>