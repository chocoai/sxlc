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
<title>配置中心--平台设置</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<!-- 私用css -->
<link href="css/config.css" rel="stylesheet" />
<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
<link rel="stylesheet" href="css/upload.css" />
</head>
<!-- 配置中心-------------------平台设置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index" />
				<jsp:param value="配置中心" name="loc1" />
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp">
					<jsp:param value="config-1" name="config-index" />
				</jsp:include>

				<!-- 数据显示 -->
				<div class="config">
					<fieldset>
			 			<legend>平台设置</legend>
			 			<form class="form-horizontal" role="form" name="" action="" id="">
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">平台名称设置：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">平台后台log设置：</label>
			 					<div class="i-fl">
			 						<div id="bglogo">
									    <!--用来存放item-->
									    <div id="filePicker">选择图片</div>
									    <span class="rec-dimensions">建议尺寸：580*280</span>
									</div>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">平台前台log设置：</label>
			 					<div class="i-fl">
			 						<div id="fglogo">
									    <!-- 用来存放item -->
									    <div id="filePicker">选择图片</div>
									    <span class="rec-dimensions">建议尺寸：580*280</span>
									</div>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">平台客服热线设置：</label>
			 					<div class="i-fl">
			 						<input type="tel" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">法定工作时间设置：</label>
			 					<div class="i-fl">
			 						<input type="date" class="form-control" id="lastname" placeholder="">
			 					</div>
			 				</div>
			 				<!-- 新浪微博 -->
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">新浪微博：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">新浪微博二维码：</label>
			 					<div class="i-fl">
			 						<div id="sina">
			 							<!--  用来存放item -->
									    <div id="filePicker">选择图片</div>
									    <span class="rec-dimensions">建议尺寸：580*280</span>
									</div>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">投资QQ群：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder=""/>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">QQ群二维码：</label>
			 					<div class="i-fl">
			 						<div id="qqgroup">
			 							<!--  用来存放item -->
									    <div id="filePicker">选择图片</div>
									    <span class="rec-dimensions">建议尺寸：580*280</span>
									</div>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">微信公众号：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="lastname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">微信公众号二维码：</label>
			 					<div class="i-fl">
			 						<div id="weixin">
									    <!-- 用来存放item -->
									    <div id="filePicker">选择图片</div>
									    <span class="rec-dimensions">建议尺寸：580*280</span>
									</div>
			 					</div>
			 				</div>
			 				<!-- 开启或关闭平台 -->
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">开启或关闭平台：</label>
				 				<div class="i-fl">
				 					<label class="checkbox-inline">
				 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 开启
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="optionsRadios" id="optionsRadios2" value="option1"> 关闭
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">风险备付金金额设置：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">平台预期年化设置：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign">%<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">即将到期还款限制：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign">天内<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">借款项目风险保证金比例上限：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign">%<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">红包使用比例配置：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign">%<i>*</i></span>
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">签到送积分：</label>
			 					<div class="i-fl">
			 						<input type="num" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">积分别名：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">平台扣除保证金方式：</label>
				 				<div class="i-fl">
				 					<label class="checkbox-inline">
				 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 一次逾期全部扣除
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="optionsRadios" id="optionsRadios2" value="option1"> 按照逾期总金额占本金百分比扣除
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="optionsRadios" id="optionsRadios2" value="option1"> 按照逾期期数百分比扣除
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
			 					<label for="firstname" class="col3 i-fl control-label">网站top欢迎语设置：</label>
			 					<div class="i-fl">
			 						<input type="text" class="form-control" id="firstname" placeholder="">
			 					</div>
			 				</div>
			 				<div class="form-group">
			 					<div class="offset-col3">
			 						<button type="submit" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
				</div>

			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/config/upload.js"></script>
	<!-- 私用js -->
</body>

</html>