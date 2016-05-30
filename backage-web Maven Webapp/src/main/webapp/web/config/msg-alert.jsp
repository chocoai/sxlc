<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>配置中心--短信设置-消息提醒设置</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<!-- 私用css -->
<link href="css/config.css" rel="stylesheet" />
<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
<link rel="stylesheet" href="css/upload.css" />
</head>
<!-- 配置中心-------------------消息设置  消息提醒设置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1" />
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="603" name="_index_m2" />
				<jsp:param value="60302" name="_index_m3" />
			</jsp:include>
			<!-- 头部导航 -->
			
			<!-- 主要内容 -->
			<div class="right_col role-content">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp">
					<jsp:param value="config-1" name="config-index" />
				</jsp:include>
				<ul class="nav nav-tabs msgalerttab">
					<li role="presentation"   changeType="1" class="changePg active"><a>手机短信</a>
					</li>
					<li role="presentation"  changeType="2" class="changePg"><a>站内消息</a>
					</li>
					<li role="presentation"   changeType="3" class="changePg"><a>邮件</a>
					</li>
				</ul>
				<!-- 数据显示 -->
				<div class="">
					<div class="config">
						<!-- 手机短信 -->
						<fieldset>
				 			<legend id="title" submitType="1">手机短信</legend>
				 			
				 			<c:forEach var="msg" items="${msgs}" varStatus="status">
				 				<div class="form-group col-md-4 col-sm-6 col-xs-12">
				 					<label for="lastname" class="i-fl control-label col3" >${msg.typeName}：</label>
					 				<div class="i-fl optionDiv" iSSmsSend="${msg.iSSmsSend }" iSLetterSend="${msg.iSLetterSend }" iSEmailSend="${msg.iSEmailSend }" typeID="${msg.typeID }">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios${status.index}"  value="1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios${status.index}"  value="0"> 否
					 					</label>
					 				</div>
					 			</div>
							</c:forEach>
							
				 			<div class="msgcontentbtn col-md-12 col-sm-12 col-xs-12"><button type="button" onclick="saveData()" class="btn btn-default">提交</button></div>			
				 		</fieldset>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/config/msgAlert.js"></script>
</body>

</html>