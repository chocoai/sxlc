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
	<title>平台推广</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<!-- 测试css -->
	<link rel="stylesheet" type="text/css" href="css/memberselect.css">
	
</head>

<body class="nav-md" >
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="11" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/promoted1aa.jsp"></jsp:include>
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div id="right_col" class="right_col i-b2" role="main">
				<div  class="memberselect_a">测试</div>
				<div class="tScroll">
					<table class="memberselect_b">
						<thead>
							<tr role="row">
								<th rowspan="1" colspan="1">会员编码</th>
								<th>姓名</th>
								<th>用户名</th>
								<th>手机号码</th>
								<th>所属地区</th>
								<th>会员等级</th>
								<th>信用等级</th>
								<th>第三方账户</th>
								<th>可用账户余额</th>
								<th>冻结金额</th>
								<th>充值总额</th>
								<th>投资总额</th>
								<th>借款总额</th>
								<th>提现总额</th>
								<th>收益总额</th>
								<th>可用积分</th>
								<th>赠送红包总额</th>
								<th>使用红包总额</th>
								<th>已过期红包总额</th>
								<th>剩余可用红包总额</th>
								<th>是否开启自动投标</th>
								<th>是否开启自动还款</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>13000000000</td>
								<td>四川省成都市郫县</td>
								<td>3星用户</td>
								<td>2级</td>
								<td>123456789123456789</td>
								<td>123456789123456789</td>
								<td>100.00</td>
								<td>50.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
								<td>300.00</td>
								<td>20.00</td>
								<td>10.00</td>
								<td>1.00</td>
								<td>5.00</td>
								<td>true</td>
								<td>false</td>
								<td>已添加</td>
							</tr>
							<tr>
								<td>1</td>
								<td>张三</td>
								<td>KFSDLY00000001</td>
								<td>13000000000</td>
								<td>四川省成都市郫县</td>
								<td>3星用户</td>
								<td>2级</td>
								<td>123456789123456789</td>
								<td>123456789123456789</td>
								<td>100.00</td>
								<td>50.00</td>
								<td>1000.00</td>
								<td>200.00</td>
								<td>100.00</td>
								<td>1000.00</td>
								<td>300.00</td>
								<td>20.00</td>
								<td>10.00</td>
								<td>1.00</td>
								<td>5.00</td>
								<td>true</td>
								<td>false</td>
								<td>已添加</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/select.js"></script>
</body>

</html>