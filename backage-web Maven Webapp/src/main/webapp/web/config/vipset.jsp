<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="cn.springmvc.model.Operation"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/* 登录人操作权限 */
	List<Operation> operations = null;
	if(session.getAttribute("operationList") != null){
		operations = (List<Operation>)session.getAttribute("operationList");

	}
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>配置中心--VIP配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------VIP设置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="609" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- VIP设置 -->
			 	<div class="config">
			 	<form class="form-horizontal config-form vipseetingform" role="form" name="" action="" id="vipForm">
			 		<fieldset class="vipsetting">
			 			<legend>VIP获取</legend>
			 			
			 				<div class="form-group">

			 					<label for="firstname" class="i-fl control-label col3 formsettinglabel">VIP购买年金额：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="vip_Attest" name="vip_Attest" maxlength="8"  datatype="amcountM" placeholder="">
								</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">元<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">

			 					<label for="lastname" class="i-fl control-label col3 formsettinglabel">上个VIP截止日起累计有效投资：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="invest_total" name="invest_total" maxlength="8" datatype="amcountM" placeholder="">
								</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">元<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						
				 	
			 					</div>
			 				</div>
			 		</fieldset>
			 		<fieldset class="vipsetting">
			 			<legend>VIP享有优惠</legend>
			 				<div class="form-group">

			 					<label for="firstname" class="i-fl control-label col3 formsettinglabel">投资收取投资管理费：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" name="invest_Fee" id="invest_Fee" placeholder="">

			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">%<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">

			 					<label for="lastname" class="i-fl control-label col3 formsettinglabel">借款收取借款管理费：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" name="borrow_Fee"  id="borrow_Fee" placeholder="">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">%<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 							<%
							if(operations.size()>0){
								for(int i = 0;i < operations.size(); i++){
									if(operations.get(i).getOptID() == 60901){
						%>				
									<button type="submit" class="btn btn-default" onclick="submitVipCofig()">保存</button>
						<%      
					      			}
						  		 }
							 }
					     %>	
			 					</div>
			 				</div>
			 		</fieldset>
			 			</form>		
			 	</div>	
			 </div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->

	<script type="text/javascript" src="js/configCenter/vipConfig.js"></script>

	<script>
		$(function(){
			validform5("layui-layer-btn0","vip_Attest",false,"3");
			validform5("layui-layer-btn0","invest_total",false,"3");
			validform5("layui-layer-btn0","borrow_Fee",false,"3");
			validform5("layui-layer-btn0","invest_Fee",false,"3");
		});
	</script>

</body>

</html>