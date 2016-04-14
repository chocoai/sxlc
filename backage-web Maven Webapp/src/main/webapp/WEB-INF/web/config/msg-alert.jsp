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
<title>配置中心--消息管理</title>
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
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a>站内消息</a>
					</li>
					<li role="presentation" class=""><a>手机短信</a>
					</li>
					<li role="presentation" class=""><a>邮件</a>
					</li>
				</ul>
				<!-- 数据显示 -->
				<div class="nav-tabs-con active">
					<div class="config">
						<!-- 站内消息 -->
						<fieldset>
				 			<legend>站内消息</legend>
				 			<form class="form-horizontal" role="form" name="" action="" id="">
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">注册成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">开户成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">充值成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">提现成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">投资成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">投资失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款申请审核失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">还款提醒：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">当期还款成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">项目回款：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">修改登录密码通知：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="是"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="否"> 否
					 					</label>
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
		 		<!-- 手机短信 -->
		 		<div class="nav-tabs-con">
		 			<div class="config">
						<fieldset>
				 			<legend>手机短信</legend>
				 			<form class="form-horizontal" role="form" name="" action="" id="">
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">注册成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">开户成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">充值成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">提现成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">投资成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">投资失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款申请审核失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">还款提醒：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">当期还款成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">项目回款：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">修改登录密码通知：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
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
		 		<!-- 邮件 -->
		 		<div class="nav-tabs-con">
		 			<div class="config">
						<fieldset>
				 			<legend>邮件</legend>
				 			<form class="form-horizontal" role="form" name="" action="" id="">
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">注册成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">开户成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">充值成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">提现成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">投资成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">投资失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款申请审核失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款失败：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">借款成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">还款提醒：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">当期还款成功：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">项目回款：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
					 				</div>
					 			</div>
					 			<div class="form-group">
					 				<label for="lastname" class="i-fl control-label col3">修改登录密码通知：</label>
					 				<div class="i-fl">
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 是
					 					</label>
					 					<label class="checkbox-inline">
					 						<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> 否
					 					</label>
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
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>