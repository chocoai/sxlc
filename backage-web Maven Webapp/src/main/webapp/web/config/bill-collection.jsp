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
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="611" name="_index_m2" />
				<jsp:param value="" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	
			 	<div class="config billconfig">
			 	<form class="form-horizontal" role="form" type="post" action="javascript:submitBillCofig()" id="dataForm">
			 	<!-- 账单即将到期天数配置 -->
			 		<fieldset class="billfiel">
			 			<legend>账单即将到期天数配置</legend>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">即将到期天数：</label>
			 					<div class="i-fl">
			 						<input type="text" name="overdue_day" id="overdue_day" class="form-control" id="firstname" placeholder="" datatype="days">
				 				</div>
				 				<!-- <div class="offset-col3">
				 					<button type="submit" class="btn btn-default">保存</button>
				 				</div> -->
				 			</div>
				 	</fieldset>
				 	<!-- 催收账单配置 -->
				 	<fieldset class="billfiel">
			 			<legend>催收账单配置</legend>
			 			<div class="collectbill">
			 				<!-- <script id="collectbill" type="text/plain" style="height:260px;width:98%;margin-left:2%;"></script> -->
			 				<textarea rows="8" cols="" placeholder="" name="content" id="content" class="billtextarea"></textarea>
			 			</div>
			 			<div class="form-group">
			 				<div class="offset-col3 billbtn">
			 		<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								if(operations.get(i).getOptID() == 61101){
					%>				
								<button type="submit" class="btn btn-default" >保存</button>
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
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/configCenter/bill-collection.js"></script>
</body>

</html>