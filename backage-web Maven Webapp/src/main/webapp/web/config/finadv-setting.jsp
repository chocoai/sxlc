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
	<title>配置中心-财务设置-理财顾问提奖设置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置  理财顾问提奖设置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="601" name="_index_m2"/>
				<jsp:param value="60107" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="config">
			 		<fieldset>
			 			<legend>理财顾问提奖设置</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:addOrModify()" id="dataForm">
			 				<div class="form-group">
			 					<input type="hidden" id="setId" value="${rewards.id}"  >
			 					<label for="firstname" class="col3 i-fl control-label">推荐VIP提奖金额：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="vIPReward" placeholder="" value = "${rewards.vIPReward}" datatype="acountM">
			 					</div>
			 					<!-- <div class="i-fl">
									<span class="sign i-fl">*N%(N是期限，年)<i>*</i></span>
								</div>
								<div class="input-alert">
									<span>错误提示</span>
								</div> -->
								<div class="i-fl">
									<span class="sign i-fl">元</span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">推荐借款提奖百分比：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="borrowReward" placeholder="" value = "${rewards.borrowReward}" datatype="hundredNum">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">%</span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">推荐借款还本提奖百分比：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="repayReward" placeholder="" value = "${rewards.repayReward}" datatype="hundredNum">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">%</span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">推荐投资收益提奖百分比：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="investReward" placeholder="" value = "${rewards.investReward}" datatype="hundredNum">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">%</span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">推荐投资提奖百分比：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="" value = "" datatype="hundredNum">
			 					</div>
			 					<div class="i-fl">
									<span class="sign i-fl">%</span>
								</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="button" class="btn btn-default" id="submit">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 	</div>
			</div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/config/config.js"></script>
	<!-- 私用js -->
	<script>
	$(function(){
			validform5(".btn-default","dataForm",false,"5");
			//保存按钮
			$("#submit").on("click",function(){
					if($("#dataForm").find(".Validform_error").length>0){
							return;					
					}
					var id =  $("#setId").val();
					var handType = "";//操作类型 0：增加  1：修改
					if(id==""){
						handType="0";
					}else{
						handType="1";
					}
					var vIPReward =  encrypt.encrypt($("#vIPReward").val());
					var borrowReward = encrypt.encrypt($("#borrowReward").val());
					var repayReward =  encrypt.encrypt($("#repayReward").val());
					var investReward =  encrypt.encrypt($("#investReward").val());
					
					NetUtil.ajax(
							  appPath+"/config/updateRewarSet.do",
							  {"id":encrypt.encrypt(id),"handType":encrypt.encrypt(handType),"vIPReward":vIPReward,"borrowReward":borrowReward,"repayReward":repayReward,"investReward":investReward,"type":encrypt.encrypt("1")},
							  function(data) { 
									if(data==1){
										layer.alert("保存成功",{icon:1});
									}else if(data==0){
										layer.alert("保存失败",{icon:2});  
									}
								}
					 );
			
			});
			
		});
	</script>
</body>

</html>