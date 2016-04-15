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
	<title>配置中心--VIP配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------VIP设置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- VIP设置 -->
			 	<div class="config">
			 		<fieldset>
			 			<legend>VIP获取</legend>
			 			<form class="form-horizontal config-form" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="firstname" class="i-fl control-label col3">VIP购买年金额：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="" datatype="" placeholder="VIP购买年金额">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">元<i>*</i></span>
			 					</div>
			 					<!-- <div class="input-alert">
			 						<span>错误提示</span>
			 					</div> -->
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">上个VIP截止日起累计有效投资：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="" datatype="*" placeholder="N">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">元<i>*</i></span>
			 					</div>
			 					<!-- <div class="input-alert">
			 						<span>错误提示</span>
			 					</div> -->
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="submit" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset>
			 			<legend>VIP享有优惠</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="firstname" class="i-fl control-label col3">投资收取管理投资管理费：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="投资收取管理投资管理费">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">%<i>*</i></span>
			 					</div>
			 					<!-- <div class="input-alert">
			 						<span>错误提示</span>
			 					</div> -->
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">借款收取借款管理费：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="借款收取借款管理费">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">%<i>*</i></span>
			 					</div>
			 					<!-- <div class="input-alert">
			 						<span>错误提示</span>
			 					</div> -->
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
</body>

</html>