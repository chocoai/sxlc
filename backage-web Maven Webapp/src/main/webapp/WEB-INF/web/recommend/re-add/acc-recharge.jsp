<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<!-- 主要内容 -->
	<div class="" role="main">
		<!-- 地址导航 -->
		<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
		<div class="data_display">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="action_item">
						<button class="obtn glyphicon glyphicon-plus" onclick="acc-recharge()">充值</button>
					</div>
				</div>
			</div>
										
		</div>
	</div>
