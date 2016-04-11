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
	    		<label for="type_name" class="col-sm-2 control-label">类型名称:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="type_name" id="type_name" placeholder="类型名称">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="pro_fiance_range" class="col-sm-2 control-label">项目融资额度范围:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="pro_fiance_range" id="pro_fiance_range" placeholder="范围0~99999999">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="annual_rate_range" class="col-sm-2 control-label">年化利率范围:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" id="annual_rate_range" name="annual_rate_range" placeholder="0~9999的整数">
	    		</div>
	  		</div>
	  		<div class="form-group">
	  			<label class="col-sm-2 control-label">是否需要抵押物:</label>
	  			<div class="col-sm-8">
			  		<label class="radio-inline">
			  			<input type="radio" name="sure" id="collateral" value="option1">是
			  		</label>
			  		<label class="radio-inline">
			  			<input type="radio" name="sure" id="not_ollateral" value="option2">否
			  		</label>
			  	</div>
		  	</div>
		  	<div class="form-group">
		  		<label class="col-sm-2 control-label">项目类型简介:</label>
		  		<div class="col-sm-8">
		  			<textarea class="form-control" rows="10" name="brief_msg"></textarea>
		  		</div>
		  	</div>
		  	<div class="form-group">
	  			<label class="col-sm-2 control-label">选择产品所需认证项:</label>
	  			<div class="col-sm-8">
			  		<label class="radio-inline">
			  			<input type="radio" name="business_member" id="business_member" value="企业会员">企业会员
			  		</label>
			  		<label class="radio-inline">
			  			<input type="radio" name="personel_member" id="personel_member" value="个人会员">个人会员
			  		</label>
			  	</div>
		  	</div>
		  	<div class="form-group">
		  		<label class="col-sm-2 control-label">原有产品小图标:</label>
		  		<div class="col-sm-8">
		  			<img src="resources/img/indentifyicode.jpg">
		  		</div>
		  	</div>
		  	<div class="form-group">
		  		<label class="col-sm-2 control-label">产品展示小图标:</label>
		  		<div class="col-sm-8">
		  			<input type="file" id="product_logo">
		  			<!-- <p class="help-block">上传产品展示小图标25*25</p> -->
		  		</div>
		  	</div>
	    	<div class="form-group">
	    		<div class="col-sm-offset-2 col-sm-10">
	    			<button type="submit" class="btn btn-success">修改</button>
	    		</div>
	    	</div>
	    </form>
	    <div class="guide row">
	    	<p class="col-sm-10 col-sm-offset-2">
	    		<a href="#" class="text-danger">1.申请指南</a>
	    		<a href="#" class="text-danger">2.还款指南</a>
	    	</p>
	    </div>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>