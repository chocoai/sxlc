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
	<title>配置中心--财务配置</title>
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
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 前台借款信息填写配置 -->
			 	<div class="config">
			 		<fieldset>
			 			<legend>前台借款信息填写配置</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">前台借款信息填写配置项：</label>
				 				<div class="i-fl morecheck">	
				 					<label class="checkbox-inline">
				 						<input type="checkbox" name="optionsRadios" id="optionsRadios1" value=""> 借款金额
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="checkbox" name="optionsRadios" id="optionsRadios2" value=""> 还款保障
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="checkbox" name="optionsRadios" id="optionsRadios1" value=""> 借款项目类型
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="checkbox" name="optionsRadios" id="optionsRadios2" value=""> 借款期限
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="checkbox" name="optionsRadios" id="optionsRadios1" value=""> 还款来源
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
				 					<div class="i-fl morecheck">
				 						<label class="checkbox-inline">
					 						<input type="checkbox" name="optionsRadios" id="optionsRadios2" value=""> 借款用途
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="checkbox" name="optionsRadios" id="optionsRadios1" value=""> 抵押物描述
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="checkbox" name="optionsRadios" id="optionsRadios2" value=""> 还款方式
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="checkbox" name="optionsRadios" id="optionsRadios1" value=""> 借款描述
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="checkbox" name="optionsRadios" id="optionsRadios2" value=""> 期限类型
					 					</label>
					 				</div>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="submit" class="btn btn-default">保存</button>
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
	<!-- 私用js -->
</body>

</html>