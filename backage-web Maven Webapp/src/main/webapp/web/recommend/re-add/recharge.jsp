<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
	<title>充值</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/recharge.css" type="text/css"/>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="container body">
			<div class="main_container">
				<div class="w-content ishow pic-add">
					<table id="card_id">
						<tr>
							<td class="tt">充值类型</td>
							<td class="con">
								<select class="assettype">
									<option>请选择</option>
									<option>人民银行</option>
									<option>工商银行</option>
									<option>邮政储蓄银行</option>
									<option>建设银行</option>
									<option>农业银行</option>
									<option>其它</option>
								</select>	
							</td>
						</tr>
						<tr>
							<td class="tt">输入金额</td>
							<td class="con" id="inputMoney"><input type="text" datatype="acountM"/></td>
						</tr>
						<tr>
							<td class="tt">充值备注</td>
							<td class="con" id="inputRemarks"><input type="text" datatype="remarks"/></td>
						</tr>																
					</table>
				</div>
			</div>			
		</div>
	</div>
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 公用js -->
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/recharge-record.js"></script>
	<script type="text/javascript">
	</script>
</body>
</html>