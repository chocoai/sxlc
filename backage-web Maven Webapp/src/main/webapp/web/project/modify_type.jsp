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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/project/myLayer.css" rel="stylesheet" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>
<body>
	<div class="container add_type_contianer">
		<div class="w-content memcredit-grade-add">
			<table>
				<tr>
					<td class="tt"><label class="ineed">类型名称：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="类型名称" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label class="ineed">项目融资额度范围：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="项目融资额度范围" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label>年化利率范围：</label></td>
					<td class="con">
						<input type="text" class="" placeholder="年化利率范围" value="" />
					</td>
				</tr>
				<tr>
					<td class="tt"><label>是否需要抵押物：</label></td>
					<td class="con">
						<input type="radio" name="apply" class="" value="是"/> 是
						<input type="radio" name="apply" class="" value="否"/> 否
					</td>
				</tr>
				<tr>
					<td class="tt"><label>项目类型简介：</label></td>
					<td class="con">
						<textarea cols="20" rows="3" name="" placeholder="项目类型简介"></textarea>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>产品所需认证项：</label></td>
					<td class="con">
						<input type="radio" name="identity" class="" value="1"/> 企业会员
						<input type="radio" name="identity" class="" value="2"/> 个人会员
					</td>
				</tr>
				<tr>
					<td class="tt"><label>原产品小图标：</label></td>
					<td class="con">
						<div class="primarylogo">
				  			<img src="resources/img/indentifyicode.jpg">
				  		</div>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>产品展示小图标：</label></td>
					<td class="con">
						<div id="logo">
						    <!--用来存放item-->
						    <div id="filePicker">选择图片</div>
						    <span class="rec-dimensions">建议尺寸：25*25</span>
						</div>
					</td>
				</tr>
				<tr>
					<td class="tt" valign="top">图片预览：</td>
					<td class="con" id="fileList"></td>
				</tr>
				<tr>
					<td class="tt"><label>申请指南：</label></td>
					<td class="con">
						<script id="applyguide" type="text/plain" style="height:260px;width:98%;"></script>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款指南：</label></td>
					<td class="con">
						<script id="payguide" type="text/plain" style="height:260px;width:98%;"></script>
					</td>
				</tr>
				<tr>
					<td class="tt"><label></label></td>
					<td class="con">
						<button type="submit" class="btn btn-success">添加</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/project/protype-upload.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		var ag = UE.getEditor('applyguide');
		var pg = UE.getEditor('payguide');
	</script>
</body>

</html>