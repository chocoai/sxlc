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
	<title>配置中心-前台借款信息填写配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------前台借款信息填写配置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="607" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 前台借款信息填写配置 -->
			 	<div class="config">
			 		<fieldset>
			 			<legend>前台借款信息填写配置</legend>
			 			<form class="form-inline" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3 frontloanlabel">前台借款信息填写配置项：</label>
				 				<div class="i-fl morecheck">
				 					<div class="frontinfodiv">
					 						<input type="checkbox" name="optionsRadios" id="borrow_Use" value="0"> 
					 						<label class="checkbox-inline">借款用途</label>
					 					</div>	
				 					<div class="frontinfodiv">
				 						<input type="checkbox" name="optionsRadios" id="return_keep" value="1"> 
				 						<label class="checkbox-inline">还款保障</label>
				 					</div>	
				 					<div class="frontinfodiv">
				 						<input type="checkbox" name="optionsRadios" id="borrow_Money" value="2"> 
				 						<label class="checkbox-inline">借款金额</label>
				 					</div>	
					 					<div class="frontinfodiv">
					 						<input type="checkbox" name="optionsRadios" id="borrow_detail" value="3"> 
					 						<label class="checkbox-inline">借款描述</label>
					 					</div>	
				 					<div class="frontinfodiv">
				 						<input type="checkbox" name="optionsRadios" id="borrow_deadline" value="4"> 
				 						<label class="checkbox-inline">借款期限</label>
				 					</div>	
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
				 					<div class="i-fl morecheck">
				 						<!-- <div class="frontinfodiv">
					 						<input type="checkbox" name="optionsRadios" id="di_ya" value=""> 
					 						<label class="checkbox-inline">抵押物描述</label>
					 					</div>	 -->
					 				<div class="frontinfodiv">
					 						<input type="checkbox" name="optionsRadios" id="return_way" value="5"> 
					 						<label class="checkbox-inline">还款方式</label>
					 				</div>
					 				<div class="frontinfodiv">
				 						<input type="checkbox" name="optionsRadios" id="deadline_type" value="6"> 
				 						<label class="checkbox-inline">预计年化收益率</label>
				 					</div>
					 				<div class="frontinfodiv">
				 						<input type="checkbox" name="optionsRadios" id="borrow_type" value="7"> 
				 						<label class="checkbox-inline">借款项目类型</label>
				 					</div>
					 				<div class="frontinfodiv">
				 						<input type="checkbox" name="optionsRadios" id="return_resourse" value="8"> 
				 						<label class="checkbox-inline">还款来源</label>
				 					</div>	
				 					
				 				</div>
			 				</div>
		 				</div>
		 				</form>	
	 					<div class="frontinfobtn">
	 						<button type="submit" class="btn btn-default layui-layer-btn0" onclick="submitPlatCofig()">保存</button>
	 					</div>	
			 		</fieldset>
			 	</div>	
			 </div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/configCenter/front-loan.js"></script>	
</body>

</html>