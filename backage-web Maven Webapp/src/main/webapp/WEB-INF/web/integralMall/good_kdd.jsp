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
	<title>修改商品</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="container body">
			<div class="main_container">
			
				<div class="w-content ishow pic-add">
					<table id="card_id">
						<tr>
							<td class="tt">入库数量</td>
							<td class="con" id=""><input type="text" value=""/></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
	<script type="text/javascript" src="js/upload.js"></script>
	<script>
		$(".commonbtn1").click(function(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	});
	</script>
</body>

</html>
