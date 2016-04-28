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
	<title>会员重置密码</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
    <jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="plugs/layer-v2.2/layer/skin/layer.css" type="text/css"></link>
</head>

<body class="nav-md" style="min-width:350px;">
	<form id="password">
	<div class="container body addContainer">
		<div class="main_container">
		
			<div class="w-content ishow">
					<table>
						<tr class="resetPwd">
							<td class="tt">新密码：</td>
							<td class="con"><input name="password" type="password" datatype="regpass" maxlength="16" ></td>
						</tr>
						<tr class="resetPwd">
							<td class="tt">确认密码：</td>
							<td class="con"><input type="password" recheck="password" datatype="repass" maxlength="16" ></td>
						</tr>
					</table>
			</div>
			
		</div>
	</div>
	<div class="layui-layer-btn">
		<a class="layui-layer-btn0">确定</a>
		<a class="layui-layer-btn1">取消</a>
	</div>
	</form>

	<!--  公用的js   -->
	<script type="text/javascript" src="plugs/Validform/5.3.2/Validform.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="plugs/layer-v2.2/layer/layer.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/memberPwd.js"></script>
	<script type="text/javascript">
		validform5(".layui-layer-btn0","password",false,"3");
		$(".layui-layer-btn1").click(function(){
    		alert(1);
    		var index = parent.layer.getFrameIndex(window.name);
	    	parent.layer.close(index);
    	});
	</script>
</body>

