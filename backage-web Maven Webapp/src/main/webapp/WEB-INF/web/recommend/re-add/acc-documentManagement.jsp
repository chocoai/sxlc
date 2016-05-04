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
			<fieldset class="accdocmanagefd">
				<legend>担保证件管理</legend>
				<table class="accdocmanagetb">
					<tr>
						<td class="tt">上传担保证件</td>
						<td class="con">
							<!--dom结构部分-->
							<div id="uploader">
							    <!--用来存放item-->
							    <div id="filePicker">选择图片</div>
							    <span class="rec-dimensions">建议尺寸：580*280</span>
							</div>
						</td>
					</tr>
					<tr>
						<td class="tt" valign="top">图片预览</td>
						<td class="con" id="fileList"></td>
					</tr>
				</table>
				<div class="cmbtncontainer">
					<a class="commonbtn0">添加</a>
					<a href="web/recommend/account-center.jsp">取消</a>
				</div>							
			</fieldset>
		</div>
	</div>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/recommend/re-guamanage.js"></script>