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
	<title>会员管理</title>
	<!-- 公用meta -->
<%-- 	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include> --%>
	<!-- 私用css -->
	<link rel="stylesheet" type="text/css" href="css/allMembers/allMembers.css">
</head>
<body>

	<!-- 查看会员详情 -->
	<div class="membershipDetails">
		<table class="membershipDetails_a">
			<thead>
				<tr role="row">
					<th rowspan="1" colspan="1">会员编码</th>
					<th>会员编号</th>
					<th>会员用户名</th>
					<th>真实姓名</th>
					<th>身份证号</th>
					<th>籍贯</th>
					<th>民族</th>
					<th>户籍地址</th>
					<th>居住地址</th>
					<th>手机号码</th>
					<th>电子邮箱</th>
					<th>qq</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>年龄</th>
					<th>最高学历</th>
					<th>婚姻状况</th>
					<th>月均收入</th>
					<th>地区</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>张三</td>
					<td>张山</td>
					<td>123456789123456780</td>
					<td>四川</td>
					<td>汉族</td>
					<td>四川省成都市郫县</td>
					<td>四川省成都市郫县</td>
					<td>13512345678</td>
					<td>789456123@qq.com</td>
					<td>男</td>
					<td>1990.01.01</td>
					<td>26</td>
					<td>本科生</td>
					<td>未婚</td>
					<td>5000.00</td>
					<td>双流区</td>
				</tr>
				<tr>
					<td>1</td>
					<td>李四</td>
					<td>李视</td>
					<td>123456789123456780</td>
					<td>四川</td>
					<td>汉族</td>
					<td>四川省成都市郫县</td>
					<td>四川省成都市郫县</td>
					<td>13512345678</td>
					<td>789456123@qq.com</td>
					<td>男</td>
					<td>1990.01.01</td>
					<td>26</td>
					<td>本科生</td>
					<td>未婚</td>
					<td>5000.00</td>
					<td>双流区</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>