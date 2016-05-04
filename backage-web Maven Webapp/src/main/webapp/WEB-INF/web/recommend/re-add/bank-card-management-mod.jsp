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
	<link rel="stylesheet" href="css/recommend/bank-card-management-add.css"/>
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
							<td class="con" id="depositBank"><!-- <input type="text" datatype="enterAddress" /> -->
								<select class="accountbankse">
									<option>中国银行</option>
									<option>建设银行</option>
									<option>工商银行</option>
									<option>农商银行</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="tt">开户行城市</td>
							<td class="con" id="depositCity">
								<select class="cityoption">
									<option>请选择省</option>
									<option>四川</option>
									<option>山东</option>
									<option>云南</option>
								</select>
								<span class="line"></span>
								<select class="cityoption">
									<option>请选择市</option>
									<option>成都</option>
									<option>济南</option>
									<option>大理</option>
								</select>
								<span class="line"></span>
								<select class="cityoption">
									<option>请选择区/县</option>
									<option>高新西区</option>
									<option>历下区</option>
									<option>盘龙区</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="tt">开户行支行</td>
							<td class="con" id=""><input type="text" datatype="enterAddress" /></td>
						</tr>
						<tr>
							<td class="tt">银行卡卡号</td>
							<td class="con" id=""><input type="text" datatype="bankNum" /></td>
						</tr>
						<tr>
							<td class="tt">确认银行卡卡号</td>
							<td class="con" id=""><input type="text" datatype="bankNum" /></td>
						</tr>
						<tr>
							<td class="tt">开户手机号</td>
							<td class="con" id=""><input type="text" datatype="zphone" /></td>
						</tr>
					</table>
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
	<script>
		$(".commonbtn1").click(function(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	});
	</script>
</body>

</html>
