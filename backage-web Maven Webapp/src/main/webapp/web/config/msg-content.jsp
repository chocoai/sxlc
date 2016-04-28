<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus" onclick="addOrUpdate(1)">添加</button>
									<button class="obtn glyphicon glyphicon-pencil" onclick="addOrUpdate(2)">修改</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
								</table>
							</div>
						</div>
					</div>
					<!-- 短信接口地址添加 -->
					<div class="w-content" id="msgadd">
					 <form action="" id="dataForm" method="post">
						<table>
							<tr>
								<td class="tt"><label class="ineed">短信类型：</label></td>
								<td class="con" id="addmsginterface">
									<select  class="msginterfaceselect" >
										<c:forEach var="msg" items="${msgs}">
											<option value="${msg.typeID}">${msg.typeName}</option>
										</c:forEach>
				                    </select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">短信内容：</label></td>
								<td class="con" id="">
									<textarea rows="3" cols="40" class="msgtextarea"></textarea>
								</td>
							</tr>
						</table>
						</form>
						<div class="masgtip"><span>提示：【】内内容不能修改</span></div>
					</div>
					<!-- 短信接口地址修改 -->
					<div class="w-content" id="modadd">
						<table>
							<tr>
								<td class="tt"><label class="ineed">短信类型：</label></td>
								<td class="con" id="addmsginterface">
									<select class="msginterfaceselect">
										<option>请选择</option>
										<option>注册成功</option>
										<option>开户成功</option>
										<option>充值成功</option>
										<option>提现成功</option>
										<option>投资成功</option>
										<option>投资失败</option>
										<option>借款申请审核失败</option>
										<option>借款失败</option>
										<option>借款成功</option>
										<option>还款提醒</option>
										<option>当期还款成功</option>
										<option>项目回款</option>
										<option>修改登录密码通知</option>
										<option>注册手机验证码通知</option>
										<option>修改手机验证码通知</option>
										<option>提现手机验证码通知</option>
										<option>登录手机验证码通知</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">短信内容：</label></td>
								<td class="con" id="">
									<textarea rows="3" cols="40"></textarea>
								</td>
							</tr>
						</table>
						<div class="masgtip"><span>提示：【】内内容不能修改</span></div>
					</div>
				</div>
				<!-- 邮件接口地址 -->
				<div class="nav-tabs-con">
					<div class="config">
				 		<fieldset>
				 			<legend>邮件接口地址配置</legend>
				 			<form class="form-horizontal" role="form" name="" action="" id="">
				 				<div class="form-group">
				 					<label for="firstname" class="i-fl control-label col3">SMTP服务器：</label>
				 					<div class="i-fl" id="server">
				 						<input type="text" class="form-control" id="firstname" placeholder="" datatype="server">
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">端口号：</label>
				 					<div class="i-fl" id="port">
				 						<input type="text" class="form-control" id="lastname" placeholder="" datatype="port">
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="firstname" class="i-fl control-label col3">邮箱地址：</label>
				 					<div class="i-fl" id="emailinterface"><input type="text" class="form-control" id="firstname" placeholder="" datatype="mail"></div>
				 				</div>
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">邮箱密码：</label>
				 					<div class="i-fl" id="emailpassword">
				 						<input type="password" class="form-control" id="lastname" placeholder="" datatype="logPass">
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<div class="offset-col3">
				 						<button type="submit" class="btn btn-default">保存</button>
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
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/config/msg-content.js"></script>
</body>

</html>