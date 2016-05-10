<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<!-- 借款申请管理——查看项目详情 -->
<head>
	<base href="<%=basePath%>">
	<title>项目详情</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
</head>
<body>
<div class="w-content ishow">
	<table>
		<tr class="col-md-6">
			<td class="tt"><label>借款项目编号：</label></td>
			<td class="con">
				<span>100001</span>
			</td>
		</tr>
		<tr class="col-md-6">	
			<td class="tt"><label>账单编号：</label></td>
			<td class="con">
				<span>200002</span>
			</td>
		</tr>	
		<tr class="col-md-6">
			<td class="tt"><label>借款项目名称：</label></td>
			<td class="con">
				<span>项目名称</span>
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>借款人：</label></td>
			<td class="con">
				<span>借款人</span>
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>账单金额：</label></td>
			<td class="con">
				<span class="moneyFormat">10000</span>元
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>账单期数：</label></td>
			<td class="con">
				<span>3</span>
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>实际还款时间：</label></td>
			<td class="con">
				<span>2016-05-10</span>
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>逾期时长：</label></td>
			<td class="con">
				<span>5</span>天
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>逾期费用：</label></td>
			<td class="con">
				<span class="moneyFormat">100</span>元
			</td>
		</tr>	
		<tr class="col-md-6">	
			<td class="tt"><label>账单展示：</label></td>
			<td class="con">
				<span>这里是一段话这里是一段话这里是一段话这里是一段话这里是一段话</span>
			</td>
		</tr>
	</table>
</div>
<!-- 公用js -->
<jsp:include page="../common/cm-js.jsp"></jsp:include>
</body>
</html>