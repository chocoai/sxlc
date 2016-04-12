<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<base href="<%=basePath%>">
<title>配置中心--平台管理</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<!-- 私用css -->
<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------消息设置  消息内容设置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index" />
				<jsp:param value="配置中心" name="loc1" />
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp">
					<jsp:param value="config-1" name="config-index" />
				</jsp:include>

				<!-- 数据显示 -->
				<div class="config">
					<fieldset>
			 			<legend>消息内容设置</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">注册成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="注册成功">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">开户成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="开户成功">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">充值成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="充值成功">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">提现成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="提现成功">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">投资成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="投资成功">
			 					</div>
			 				</div>
			 				<!-- 新浪微博 -->
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">投资失败：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="投资失败">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">借款申请审核失败：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="借款申请审核失败"/>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">借款失败：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="借款失败"/>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">借款成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="借款成功">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">还款提醒：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="还款提醒">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">当期还款成功：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="当期还款成功">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">项目回款：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="项目回款">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">修改登录密码通知：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="修改登录密码通知">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">注册手机验证码通知：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="注册手机验证码通知">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">修改手机验证码通知：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="修改手机验证码通知">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">提现手机验证码通知：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="提现手机验证码通知">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">登录手机验证码通知：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="登录手机验证码通知">
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
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>