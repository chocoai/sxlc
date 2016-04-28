<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
	<title>提现</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/present.css" type="text/css"/>
</head>
<body class="nav-md">
	<div class="container body addContainer">
		<div class="main_container">
			<div class="w-content ishow pic-add">
				<table>
					<tr>
						<td class="tt"><label style="width:107px;">银行卡：</label></td>
						<td class="con">		
							<select class="assettype">
								<option>请选择</option>
								<option>人民银行</option>
								<option>工商银行</option>
								<option>邮政储蓄银行</option>
								<option>建设银行</option>
								<option>农业银行</option>
								<option>其它</option>
							</select>	
						</td>
					</tr>
					<tr>
						<td class="tt"><label>提现金额：</label></td>
						<td class="con" id="inputMoney"><input type="text" class="" datatype="amcountM" /></td>
					</tr>
					<tr>
						<td class="tt"><label>提现备注：</label></td>
						<td class="con" id="inputRemarks"><input type="text" class="" datatype="remarks" /></td>
					</tr>
					<tr>
						<td class="tt"><label>手机验证：</label></td>
						<td class="con" id="inputZ6"><input type="text" class="telCheck" datatype="z6" /><button class="getCode">获取验证码</button></td>
					</tr>																
				</table>
			</div>
		</div>			
	</div>
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 公用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>	
	<script type="text/javascript" src="js/frontconfig/fc-safety.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>	
	<script type="text/javascript" src="js/upload.js"></script>	
	<script type="text/javascript" src="js/recommend/recharge-record.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
	$(function(){
		validform5("layui-layer-btn0","inputMoney",false,"3");
	});
	$(function(){
		validform5("layui-layer-btn0","inputRemarks",false,"3");
	});
	$(function(){
		validform5("layui-layer-btn0","inputZ6",false,"3");
	});
	</script>
</body>
</html>