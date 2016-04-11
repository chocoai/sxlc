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
	<!-- 信息不完整 -->
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