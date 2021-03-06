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
	<title>配置中心--积分规则设置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置  积分规则设置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="613" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 积分规则设置 -->
			 	<div class="config">
			 		<fieldset>
			 			<legend>积分规则设置</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">积分换算方式：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="积分换算方式">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">*N%(N是期限，年)<i>*</i></span>
								</div>
								<div class="input-alert">
									<span>错误提示</span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">积分有效期：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="积分有效期">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">年<i>*</i></span>
								</div>
								<div class="input-alert">
									<span>错误提示</span>
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
</body>

</html>