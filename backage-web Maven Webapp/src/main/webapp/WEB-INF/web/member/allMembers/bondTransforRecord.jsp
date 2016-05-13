<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
		long memberId =IntegerAndString.StringToLong(request.getParameter("content"), 0);			
%>
<!DOCTYPE html>


<div class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
				<!-- 地址导航 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div class="nav-tabs-con active">
				<div class="data_display">
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>

	
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/memberTrans.js"></script>
	<script type="text/javascript">
		var memberId = <%=memberId %>;
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		memberId = encrypt.encrypt(memberId+"");
		showMemberTransList(memberId); //借款
	</script>
</div>

