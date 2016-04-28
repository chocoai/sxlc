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


<div class="nav-md">
	<div class="container body addContainer">
		<div class="main_container">
			<!-- 地址导航 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div class="w-content ishow">
				<div class="message">
					<div class="linkMan"><label>手机号：</label><span>18855848784</span></div>
					<div class="linkMan"><label>邮箱：</label><span>44845147@qq.com</span></div>
					<div class="mode"><label>发送方式：</label>
						<input name="transmitMode" type="radio" checked ><label for="transmitMode">手机</label>
						<input name="transmitMode" type="radio" ><label for="transmitMode">邮箱</label>
						<input name="transmitMode" type="radio" ><label for="transmitMode">站内信</label>
					</div>
					<div><label>消息内容：</label><textarea class="sentContent"></textarea></div>
				</div>
				<div class="buttonSet">
					<button class="obtn obtn-query">发送</button>
					<button class="obtn obtn-query">取消</button>
				</div>
				
			</div>
			
		</div>
	</div>
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
</div>


