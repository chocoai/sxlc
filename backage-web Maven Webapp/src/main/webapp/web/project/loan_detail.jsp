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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/project/myLayer.css" rel="stylesheet" />
</head>
<body>
	<div class="container add_type_contianer">
	  	<ul class="list-group">
	  	<!-- 一下信息不完整 -->
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">会员编号：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">会员用户名：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">会员名称：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">会员联系号码：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款金额：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款期限：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">还款方式：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款用途：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">还款来源：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款描述：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">期限类型：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">提交意向时间：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">有无分配理财顾问：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">提交借款申请时间：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款项目名称：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">还款保障：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">设置最大投资比例：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">年化利率：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">起投金额：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">加价幅度：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">投资上限：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">项目描述：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">所有勾选的配置项：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">所有需要的借款认证项：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  	</ul>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>