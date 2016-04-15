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
	<title>配置中心--账单催收</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------账单催收-->
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
				
			 	
			 	<div class="config">
			 	<!-- 账单即将到期天数配置 -->
			 		<fieldset>
			 			<legend>账单即将到期天数配置</legend>
			 			<form class="form-horizontal" role="form" name="" type="post" action="javascript:updateAuto()" id="auto">
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">即将到期天数：</label>
			 					<div class="i-fl">
			 						<input type="text" name="autoBackRate" class="form-control" id="firstname" placeholder="即将到期天数">
				 				</div>
				 				<div class="i-fl">
				 					<span class="sign">天<i>*</i></span><!-- 放款时返还自动投资总金额的N% -->
				 				</div>
				 			</div>
				 			<div class="form-group">
				 				<div class="offset-col3">
				 					<button type="submit" class="btn btn-default">保存</button>
				 				</div>
				 			</div>
				 		</form>
				 	</fieldset>
				 	<!-- 催收账单配置 -->
				 	<fieldset>
			 			<legend>催收账单配置</legend>
			 			<div class="collectbill">
			 				<script id="collectbill" type="text/plain" style="height:260px;width:98%;margin-left:2%;"></script>
			 			</div>
			 			<div class="form-group">
			 				<div class="offset-col3">
			 					<button type="submit" class="btn btn-default">保存</button>
			 				</div>
			 			</div>
				 	</fieldset>
				 </div>
			</div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		var cb = UE.getEditor('collectbill');
	</script>
</body>

</html>