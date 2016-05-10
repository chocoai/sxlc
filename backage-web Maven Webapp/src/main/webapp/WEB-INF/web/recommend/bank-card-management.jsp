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
	<title>保荐机构管理-担保机构管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp">
				<jsp:param value="907" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel-heading">
							<div class="action_item">
								<button id class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="bankManagementAdd('添加银行卡','web/recommend/re-add/bank-card-management-add.jsp','1')">添加</button>
								<button id class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="bankManagementMod()">修改</button>
								<button id class="obtn glyphicon glyphicon-trash obtn-dept-del">删除</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
					<div class="w-content pic-mod">
					<form id="bankAdd" action="javascript:modBank()" type="post">
						<table id="card_id">
							<tr>
								<td class="tt">银行卡类型</td>
								<td class="con" id="cardType">
									<select class="cardTypeOption">
										<option value="0">借记卡</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">开户银行</td>
								<td class="con" id="depositBank"><!-- <input type="text" datatype="enterAddress" /> -->
									<select id="bank" class="accountbankse">
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">开户行城市</td>
								<td class="con" id="depositCity">
									<select id="province" class="cityoption">
									</select>
									<span class="line"></span>
									<select id="city" class="cityoption">
										<option>请选择省</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">开户行支行</td>
								<td class="con" id=""><input id="branch" type="text" datatype="enterAddress" /></td>
							</tr>
							<tr>
								<td class="tt">银行卡卡号</td> 
								<td class="con" id=""><input id="cardNo" type="text" datatype="bankNum" /></td>
							</tr>
							<tr>
								<td class="tt">确认银行卡卡号</td>
								<td class="con" id=""><input id="cardNo2" type="text" datatype="bankNum" /></td>
							</tr>
							<tr>
								<td class="tt">开户手机号</td>
								<td class="con" id=""><input id="phone" type="text" datatype="zphone" /></td>
							</tr>
						</table>
					</form>
					<div class="cmbtncontainer containerbtndiv">
						<a class="commonbtn0">添加</a>
						<a class="commonbtn1">取消</a>
					</div>
				</div>
				</div>
			</div>
			<!-- 尾部 -->
			<div class="all"></div>
		</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/bank-card-management.js"></script>
	<script type="text/javascript" src="js/recommend/bankMod.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>
