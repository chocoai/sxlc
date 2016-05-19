<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String btn = request.getParameter("draw");
int content = IntegerAndString.StringToInt(request.getParameter("content"),0);
int typeId = IntegerAndString.StringToInt(request.getParameter("start"),1);
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>房产认证查看</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/companyMembers.css" type="text/css" >
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp">
				<jsp:param value="202" name="_index_m2"/>
				<jsp:param value="20209" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<!-- tab切换 -->
						<jsp:include page="../common/mc-companyTable.jsp"></jsp:include> 
						<div class="w-content ishow detailAuthen realnameAuthen">
							<fieldset>
								<legend class="titleLen"></legend>
								<div class="introduce">
								<input type="hidden" id="hostPath" value="${ImgProfix}"/>
									<span><samp>企业名称：</samp><label id="company"></label></span>
									<span><samp>会员登录名：</samp><label id="logname"></label></span>
									<span><samp>房产位置：</samp><label id="houseAdress"></label></span>
								</div>
								<div class="introduce">
									<span><samp>房产面积：</samp><label id="area"></label></span>
									<span><samp>价值：</samp><label class="moneyFormat" id="value"></label>元</span>
									<span><samp>有效期：</samp><input readonly="readonly" id="sEndDate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></span>
								</div>
								<div><samp class="appendix">认证附件：</samp>
										<table >
												<tbody id="addImg" >
												
												</tbody>
										</table>
								</div>
								<div><samp>审核意见：</samp><select class="verifySelect" id="statu"><option value="2">同意</option><option value="3">打回</option></select></div>
								<div>
									<div id="submit"  class="back" style="display: none">
										<input type="hidden" id="applyId">
										<input type="hidden" id="memberId">
										<button class="submitAuthen" onclick="submitIdentyList()">提交</button>
									</div>
									<div id="back"  class="back"  style="display: none">
										<button class="backAuthen" onclick="back('web/member/companyFreeholdAuthen.jsp?content=<%=typeId%>')">返回</button>
									</div>
									<div  class="back"  style="display: none">
										<button class="backAuthen" onclick="window.history.back()">返回</button>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/companyMembers.js"></script>
	<script type="text/javascript" src="js/member/companyIdentySorts/houseHolderIdenty.js"></script>
		<script type="text/javascript">
		var memberId = "<%=content%>";
		var typeId =<%=typeId%>;
		var btn = "<%=btn%>"; 
		$("#"+typeId).addClass("active").siblings().removeClass("active");
		IdentyDetails(memberId,typeId);//会员认证详情
	</script>	
</body>