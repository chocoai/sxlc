<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int typeId = IntegerAndString.StringToInt(request.getParameter("start"),1);
String btn = request.getParameter("draw");
int content = IntegerAndString.StringToInt(request.getParameter("content"),0);
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>实名认证或查看</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
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
				<jsp:param value="201" name="_index_m2"/>
				<jsp:param value="20109" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<!-- tab切换 -->
						<jsp:include page="../common/mc-table.jsp"></jsp:include> 
						<div class="w-content ishow detailAuthen realnameAuthen">
							<fieldset>
								<legend>实名认证</legend>
								<div class="introduce">
								<input type="hidden" id="hostPath" value="${ImgProfix}"/>
									<span><samp>真实姓名：</samp><label id="realName"></label></span>
									<span><samp>民族：</samp><label id="nation"></label></span>
									<span><samp>性别：</samp><label id="sex"></label></span>
								</div>
								<div class="introduce">
									<span><samp>籍贯：</samp><label  id="native"></label></span>
									<span><samp>身份证号：</samp><label id="idcard"></label></span>
								</div>
								<div class="introduce">
									<samp>有效期：</samp><input readonly="readonly" id="sEndDate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
								</div>
								<div><samp class="appendix">认证附件：</samp><img id="right_idcard" alt="身份证正面" width="220" height="110"><img id="left_idcard" alt="身份证反面"  width="220" height="110"></div>
								<div><samp>审核意见：</samp><select class="verifySelect" id="statu"><option value="2">同意</option><option value="3">打回</option></select></div>
								<div>
									<div id="submit"  class="back" style="display: none">
										<input type="hidden" id="applyId">
										<input type="hidden" id="memberId">
										<button class="submitAuthen" onclick="submitIdentyList()">提交</button>
									</div>
									<div id="back"  class="back"  style="display: none">
										<button class="backAuthen" onclick="back('web/member/realNameAuthen.jsp?content=<%=typeId%>')">返回</button>
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
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript" src="js/member/personAuthen.js"></script>
	<script type="text/javascript" src="js/member/personalIdentySorts/realNameIdenty.js"></script>
	<script type="text/javascript">
		var typeId = <%=typeId%>;
		var memberId = "<%=content%>";/*  认证id */
		var btn = "<%=btn%>";  //查看和认证判断
		$("#"+memberId).addClass("active").siblings().removeClass("active");
		reanlNameIdentyList(memberId);//会员认证详情
	</script>
</body>