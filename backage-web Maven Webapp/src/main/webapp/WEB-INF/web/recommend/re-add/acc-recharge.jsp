<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<!-- 主要内容 -->
	<div class="" role="main">
		<!-- 地址导航 -->
		<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
		<div class="data_display">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="action_item">
						<button class="obtn glyphicon glyphicon-plus" onclick="acc-recharge()">充值</button>
					</div>
				</div>
			</div>
			<div class="recharge col-lg-12">
				<form id="" class="accrechargeform" action="">
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
						<input type="text" class="rechargeinput" placeholder="" />
						<label class="unit">元</label>
					</span>
					<span class="con-item">
						<span class="con-item-word">备注：</span><input type="text" class="rechargeinput" placeholder="请输入备注内容" />
					</span>
					<span class="rechargecost">
						<span>支付充值费用：</span><label class="cost">20.00</label>元
					</span>
					<span class="acturallymoney">
						<span>实际到账金额：</span><label class="creditedactually">1000.00</label>元
					</span>
					<span class="con-item">
						<button class="obtn obtn-query glyphicon rechargebtn">充值</button>
					</span>
				</form>
			</div>						
		</div>
	</div>
