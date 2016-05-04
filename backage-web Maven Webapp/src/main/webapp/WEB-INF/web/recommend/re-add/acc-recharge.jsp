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
	<title></title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="css/recommend/account-center.css"/>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="w-content ishow" id="webauthen-add">
				<!-- 主要内容 -->
				<div class="" role="main">
					<div class="data_display">
						<div class="recharge col-lg-12">
							<form id="rechargeform" class="accrechargeform" action="">
								<span class="con-item">
									<span class="con-item-word">充值方式：</span>
									<select class="rechargeway">
										<option>企业网银</option>
										<option>个人网银</option>
										<option>汇款充值</option>
										<option>快捷支付</option>
									</select>
								</span>
								<span class="con-item">
									<span class="con-item-word">充值金额：</span>
									<input type="text" class="rechargeinput" placeholder="" datatype="amcountM"/>
									<label class="unit">元</label>
								</span>
								<span class="con-item">
									<span class="con-item-word">备注：</span><textarea class="rechargeta ta-noresize" rows="2" cols=""></textarea>
								</span>
								<span class="rechargecost">
									<span>支付充值费用：</span><label class="cost moneyFormat">20</label>元
								</span>
								<span class="acturallymoney">
									<span>实际到账金额：</span><label class="creditedactually moneyFormat">1000</label>元
								</span>
							</form>
							<div class="cmbtncontainer accrechargecon">
								<a class="commonbtn0">添加</a>
								<a class="commonbtn1">取消</a>
							</div>
						</div>						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
	$(function(){
		validform5(".commonbtn0","rechargeform",false,"3");
	});
	$(".commonbtn1").click(function(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	});
	</script>
</body>
</html>
