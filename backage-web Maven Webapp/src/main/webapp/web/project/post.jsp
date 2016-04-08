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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/project/myLayer.css" rel="stylesheet" />
</head>
<body>
	<div class="container add_type_contianer">
	  	<form class="form-horizontal">
	  		<div class="form-group">
	    		<label for="loan_proName" class="col-sm-2 control-label">借款项目名称:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" id="loan_proName" name="loan_proName">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_money" class="col-sm-2 control-label">借款金额:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="loan_money" id="loan_money">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="payway" class="col-sm-2 control-label">还款方式:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="payway" id="payway">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="pay_ensure" class="col-sm-2 control-label">还款保障:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="pay_ensure" id="pay_ensure">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_purpose" class="col-sm-2 control-label">借款用途:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="loan_purpose" id="loan_purpose">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="pay_source" class="col-sm-2 control-label">还款来源:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="pay_source" id="pay_source">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="loan_time" class="col-sm-2 control-label">借款期限:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="loan_time" id="loan_time">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_proType" class="col-sm-2 control-label">设置最大投资比例:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" id="loan_proType" name="loan_proType">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_term" class="col-sm-2 control-label">年化利率:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="loan_term" id="loan_term">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="loan_source" class="col-sm-2 control-label">起投金额:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="loan_source" id="loan_source">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_purpose" class="col-sm-2 control-label">加价幅度:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" id="loan_purpose" name="loan_purpose">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_purpose" class="col-sm-2 control-label">投资上限:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" id="loan_purpose" name="loan_purpose">
	    		</div>
	  		</div>
	  		<div class="form-group">
		  		<label class="col-sm-2 control-label">项目描述:</label>
		  		<div class="col-sm-8">
		  			<textarea class="form-control" rows="10"></textarea>
		  		</div>
		  	</div>
		  	<div class="form-group">
	    		<label for="loan_purpose" class="col-sm-2 control-label">借款人信息:</label>
	    		<div class="col-sm-10">
	    			<ul id="myTab" class="nav nav-tabs">
		      			<li class="active">
		      				<a href="#personel_msg" id="personel" data-toggle="tab">个人</a>
		      			</li>
		      			<li class="dropdown">
		      				<a href="#company_msg" id="company" data-toggle="tab">企业</a>
		      			</li>
	      			</ul>
	      			<div id="myTabContent" class="tab-content">
		      			<div class="tab-pane fade in active" id="personel_msg">
	      					<div class="form-group">
					    		<label for="member_num" class="col-sm-2 control-label">会员编号:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="member_num" name="member_num">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="member_name" class="col-sm-2 control-label">会员用户名:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="member_name" name="member_name">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="real_name" class="col-sm-2 control-label">真实姓名:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="real_name" name="real_name">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="IDcard" class="col-sm-2 control-label">身份证号:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="IDcard" name="IDcard">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="tel" class="col-sm-2 control-label">手机号码:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="tel" name="tel">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="high_education" class="col-sm-2 control-label">最高学历:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="high_education" name="high_education">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="marriage_state" class="col-sm-2 control-label">婚姻状况:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="marriage_state" name="marriage_state">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="month_shour" class="col-sm-2 control-label">月均收入:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="month_shour" name="month_shour">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="address" class="col-sm-2 control-label">地区:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="address" name="address">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="register_time" class="col-sm-2 control-label">注册时间:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="register_time" name="register_time">
					    		</div>
					  		</div>
	      				</div>
	      				<div class="tab-pane fade" id="company_msg">
	      					<div class="form-group">
					    		<label for="member_num" class="col-sm-2 control-label">会员编号:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="member_num" name="member_num">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="member_name" class="col-sm-2 control-label">会员用户名:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="member_name" name="member_name">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="company_name" class="col-sm-2 control-label">企业名称:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="company_name" name="company_name">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="license_num" class="col-sm-2 control-label">营业执照号:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="license_num" name="license_num">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="contacts" class="col-sm-2 control-label">联系人:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="contacts" name="contacts">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="contacts_tel" class="col-sm-2 control-label">联系人手机号:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="contacts_tel" name="contacts_tel">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="address" class="col-sm-2 control-label">地区:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="address" name="address">
					    		</div>
					  		</div>
					  		<div class="form-group">
					    		<label for="register_time" class="col-sm-2 control-label">注册时间:</label>
					    		<div class="col-sm-8">
					      			<input type="text" class="form-control" id="register_time" name="register_time">
					    		</div>
					  		</div>
	      				</div>
	      			</div>
	    		</div>
	  		</div>
	  		<!-- 信息不完整 -->
	    	<div class="form-group">
	    		<div class="col-sm-offset-2 col-sm-10">
	    			<button type="submit" class="btn btn-success">确认提交</button>
	    		</div>
	    	</div>
	    </form>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>