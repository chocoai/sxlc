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
							<form id="rechargeform" class="accrechargeform" action="account/recharge.do">
								<span class="con-item">
									<span class="con-item-word">充值金额：</span>
									<input id="amounts" type="text" class="rechargeinput" placeholder="" datatype="acountM"/>
									<label class="unit">元</label>
									<input id="amount" type="hidden" name="amount" />
								</span>
								<span class="con-item">
									<span class="con-item-word">充值方式：</span>
									<select id="rechargeTypes" class="rechargeway">
										<option value="4">企业网银</option>
										<option value="">个人网银</option>
										<option value="3">汇款充值</option>
										<option value="2">快捷支付</option>
									</select>
									<input id="rechargeType" name="rechargeType" type="hidden" value="" />
									<input id="memberTypes" type="hidden" value="<%=content %>" />
									<input id="memberType" name="memberType" type="hidden" value="" />
								</span>
								<span class="con-item">
									<span class="con-item-word">备注：</span><textarea id="remarks" class="rechargeta ta-noresize" rows="2" cols=""></textarea>
									<input id="remark" type="hidden" name="remark" />
								</span>
								<span class="rechargecost">
									<span>支付充值费用：</span><label id="rechargeC" class="cost moneyFormat">0</label>元
								</span>
								<span class="acturallymoney">
									<span>实际到账金额：</span><label id="realMoney" class="creditedactually moneyFormat">0</label>元
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
	<script type="text/javascript" src="js/recommend/acc-recharge.js"></script>
	<script type="text/javascript">
	$(function(){
		validform5(".commonbtn0","rechargeform",false,"5");
	});
	$(".commonbtn1").click(function(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	});
	</script>
</body>
</html>
