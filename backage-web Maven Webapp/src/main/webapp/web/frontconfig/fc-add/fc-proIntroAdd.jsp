<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>添加图片</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	
	
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css"/>
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body addContainer">
		<div class="main_container">
		
			<div class="w-content ishow">
					<table>
						<tr>
							<td class="tt"><label>产品名称</label></td>
							<td class="con" id="productName"><input type="text" datatype="notSpecial"/></td>
						</tr>
						<tr>
							<td class="tt">借款金额范围</td>
							<td class="con" id="loanScope"><input type="text" datatype="amcountM"/><span class="line"></span><input type="text" datatype="amcountM"/></td>
						</tr>
						<tr>
							<td class="tt"><label>年化利率范围</label></td>
							<td class="con" id="rateScope"><input type="text" datatype="hundredNum"/><span class="line"></span><input type="text" datatype="hundredNum"/></td>
						</tr>
						<tr>
							<td class="tt"><label>借款时间范围</label></td>
							<td class="con"><input type="text"/><span class="line"></span><input type="text"/></td>
						</tr>
						<tr>
							<td class="tt"><label>产品展示图片</label></td>
							<td class="con" colspan="3">
								<div id="filePicker" >上传图片</div>
								<span class="rec-dimensions">建议尺寸：580*280</span>
							</td>
						</tr>
						<tr>
						<td class="tt"><label>图片预览</label></td>
						<td class="con" id="fileList">
							
						</td>
					</tr>
						<tr>
							<td class="tt"><label>产品介绍</label></td>
							<td class="con" colspan="3">
								<script id="introduceDetail" type="text/plain" style="height:300px;width:98%;"></script>
							</td>
						</tr>
					</table>
				</div>
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/fc-proIntro.js"></script>
	<script type="text/javascript" src="js/upload.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
		//编辑器实例化
			var ue1 = UE.getEditor('introduceDetail');
		});
	</script>
</body>

</html>
