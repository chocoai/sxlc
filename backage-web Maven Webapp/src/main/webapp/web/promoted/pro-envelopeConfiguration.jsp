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
	<title>平台推广管理-红包赠送配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
	<link rel="stylesheet" href="css/promoted/pro-envelopeConfiguration.css" type="text/css">
	
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="10" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-promoted.jsp">
				<jsp:param value="1007" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<form id="conForm" action="javascript:firstOption()" type="post">
								<div class="conInput">
									<span class="conInputList"><label>注册开户：</label><input id="openAcount" datatype="logname" type="text"></span>
									<span class="conInputList"><label>首次充值：</label><input id="firstRecharge" datatype="acountM" type="text"></span>
									<div class="btnSubmit">
										<button type="button" id="first" class="okBtn">确定</button>
										<a class="cancelBtn">取消</a>
									</div>
								</div>
							</form>
							
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addEnv();">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="alertEnv();">修改</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="applicationAudit" class="display">
								</table>
							</div>
							
						</div>
					</div>
					
					<!-- 添加部分  -->
					<div class="" id="addEnv">
						<form id="addRedEForm" action="javascript:addRed()" type="post">
							<div>
								<span class="tt">投资金额：</span>
								<span class="col"><input id="invsit" datatype="acountM">元</span>
							</div>
							<div>
								<span class="tt">红包比例：</span>
								<span class="col"><input id="scale" datatype="hundredNum">%</span>
							</div>
							<div class="btnAdd">
								<button type="button" id="add" class="addButton">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
					
					
					<!-- 修改部分 -->
					<div class="" id="alertEnv">
						<form id="alertRedEForm" action="javascript:modRed()" type="post">
							<div>
								<span class="tt">投资金额：</span>
								<span class="col"><input id="minvsit" datatype="acountM">元</span>
							</div>
							<div>
								<span class="tt">红包比例：</span>
								<span class="col"><input id="mscale" datatype="hundredNum"></span>
							</div>
							<div class="btnAdd">
								<button type="button" id="mod" class="alertBtn">修改</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/pro-envelopeConfiguration.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>