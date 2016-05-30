<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
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
	<link rel="stylesheet" href="css/recommend/bank-card-management-add.css"/>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="container body">
			<div class="main_container">
			
				<div class="w-content ishow pic-add">
					<form id="bankAdd" action="javascript:modBank()" type="post">
					<input id="bankCardId" type="hidden" value="<%=content %>" />
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
								<td class="con" id=""><input id="cardNo" type="text" datatype="bankNum" name="bankNum" name="bankNum" /></td>
							</tr>
							<tr>
								<td class="tt">确认银行卡卡号</td>
								<td class="con" id=""><input id="cardNo2" type="text" datatype="*" recheck="bankNum" recheck="bankNum" /></td>
							</tr>
							<tr>
								<td class="tt">开户手机号</td>
								<td class="con" id=""><input id="phone" type="text" datatype="zPhone" /></td>
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
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/bank-card-management.js"></script>
	<script type="text/javascript" src="js/recommend/bankMod.js"></script>
	<script>
		$(".commonbtn1").click(function(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	});
	</script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>
