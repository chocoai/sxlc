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
<!-- 配置中心-------------------财务设置 -->
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
				
			 	<ul class="nav nav-tabs">
			 		<li role="presentation" class="active"><a href="<%=basePath%>config/toOverdueLimit.do">逾期严重程度配置</a>
			 		</li>
					<li role="presentation" class=""><a href="<%=basePath%>config/toOverdueList.do">逾期费用设置</a>
					</li>
				</ul>
			 	<!-- 逾期配置 -->
			 	<div class="nav-tabs-con active">
				 	<div class="config">
				 		<fieldset>
				 			<legend>逾期严重程度配置</legend>
				 			<form class="form-horizontal" role="form" name="" action="javascript:addOverdueLimit()" id="dataForm">
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">逾期期限：</label>
				 					<div class="i-fl">
				 						<input type="text" class="form-control" dataType="days" name="overdueLimit" id="lastname" value="${overDays}" placeholder="逾期期限">
				 					</div>
				 					<div class="i-fl">
										<span class="sign i-fl">天<i>*</i></span>
									</div>
				 				</div>
				 				<div class="form-group">
				 					<div class="offset-col3">
				 						<button type="submit" id="submitBtn" class="btn btn-default" >保存</button>
				 					</div>
				 				</div>
				 			</form>		
				 		</fieldset>
				 	</div>
				 </div>
			 </div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
			validform5("#submitBtn","dataForm",false,3);
		});
		//增加或修改逾期程度
		function addOverdueLimit(){
			$.ajax( {  
				url:appPath+"/config/addOverdueLimit.do",
				data:$("#dataForm").serialize(),
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					if(data>0){
						layer.alert("操作成功",{icon:1});
					}else if(data==0){
						layer.alert("操作失败",{icon:2});  
					}
				},  
				error : function() {  
					layer.alert("服务器异常",{icon:2});  
				}  
			});
		}
	</script>
</body>

</html>