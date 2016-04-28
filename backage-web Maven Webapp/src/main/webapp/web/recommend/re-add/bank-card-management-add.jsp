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
	<title>银行卡管理</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
</head>

<body class="nav-md">
	<div class="container body">
		<div class="container body">
			<div class="main_container">
			
				<div class="w-content ishow pic-add">
					<table id="card_id">
						<tr>
							<td class="tt">银行卡类型</td>
							<td class="con" id="cardType">
								<select class="cardTypeOption">
									<option>借记卡</option>
									<option>信用卡</option>
									<option>储蓄卡</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="tt">开户银行</td>
							<td class="con" id="depositBank"><input type="text" datatype="enterAddress" /></td>
						</tr>
						<tr>
							<td class="tt">开户行城市</td>
							<td class="con" id="depositCity"><input type="text" datatype="enterAddress" /></td>
						</tr>
						<tr>
							<td class="tt">开户行支行</td>
							<td class="con" id="subbranch"><input type="text" datatype="enterAddress" /></td>
						</tr>
						<tr>
							<td class="tt">银行卡卡号</td>
							<td class="con" id="bankNum"><input type="text" datatype="bankNum" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/bank-card-management.js"></script>
</body>

</html>
