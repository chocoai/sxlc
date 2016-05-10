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
	<title>商品添加</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
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
							<td class="tt">上级</td>
							<td class="con" id=""><span>实物</span></td>
						</tr>
						<tr>
							<td class="tt">商品类型名称</td>
							<td class="con" id=""><input type="text"  /></td>
						</tr>
						<tr>
							<td class="tt">图片选择</td>
							<td class="con">
							<!--dom结构部分-->
								<div id="uploader">
							    <!--用来存放item-->
							    	<div id="filePicker">选择图片</div>
							    	<span class="rec-dimensions">建议尺寸：580*280</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top">图片预览</td>
							<td class="con" id="fileList"></td>
						</tr>
						<tr>
							<td class="tt">商品类型描述</td>
							<td class="con" id=""><textarea  type="text" style="width:347px;height:50px;" ></textarea></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
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
