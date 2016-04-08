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
		<ul class="list-group">
	  	<!-- 一下信息不完整 -->
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款金额：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">还款保障：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款项目类型：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款期限：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">还款来源：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">借款用途：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  		<li class="list-group-item">
	  			<div class="row">
	  				<div class="col-md-2 col-md-offset-1">抵押物描述：</div>
	  				<div class="col-md-8">000001</div>
	  			</div>
	  		</li>
	  	</ul>
	  	<form class="form-horizontal">
	  		<div class="form-group">
	    		<label for="loan_proType" class="col-sm-2 control-label">借款项目类型:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" id="loan_proType" name="loan_proType">
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
	      			<input type="text" class="form-control" id="payway" name="payway">
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
	      			<input type="text" class="form-control" id="loan_purpose" name="loan_purpose">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="pay_source" class="col-sm-2 control-label">还款来源:</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="pay_source" id="pay_source">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="loan_term" class="col-sm-2 control-label">借款期限：</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="loan_term" id="loan_term">
	    		</div>
	 		</div>
	 		<div class="form-group">
	    		<label for="set_max_invest_scale" class="col-sm-2 control-label">设置最大投资比例：</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="set_max_invest_scale" id="set_max_invest_scale">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="annual_rate" class="col-sm-2 control-label">年化利率：</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="annual_rate" id="annual_rate">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="start_invest_money" class="col-sm-2 control-label">起投金额：</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="start_invest_money" id="start_invest_money">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="fare_range" class="col-sm-2 control-label">加价幅度：</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="fare_range" id="fare_range">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="invest_uperlimit" class="col-sm-2 control-label">投资上限：</label>
	    		<div class="col-sm-8">
	      			<input type="text" class="form-control" name="invest_uperlimit" id="invest_uperlimit">
	    		</div>
	  		</div>
	  		<div class="form-group">
		  		<label class="col-sm-2 control-label">项目描述：</label>
		  		<div class="col-sm-8">
		  			<textarea class="form-control" rows="10"></textarea>
		  		</div>
		  	</div>
		  	<!-- 信息不完整 -->
		  	<!-- 展示出该会员对于该借款产品类型需要的所有的认证资料信息,若产品类型为抵押贷则出现：编辑器编辑抵押物信息 -->
		  	<div class="form-group">
	    		<label for="upload_apply_doc" class="col-sm-2 control-label">上传项目申请附件：</label>
	    		<div class="col-sm-8">
	      			<input type="file" class="form-control" name="upload_apply_doc" id="upload_apply_doc">
	    		</div>
	  		</div>
	  		<!-- 自动投标设置：投标开始后N分钟开始执行自动投标，自动投标总金额占比x% -->
	  		<div class="form-group">
		  		<label class="col-sm-2 control-label">是否为加息标：</label>
		  		<div class="col-sm-8">
		  			<input type="text" class="form-control" name="upload_apply_doc" id="upload_apply_doc">
		  		</div>
		  	</div>
		  	<div class="form-group">
		  		<label class="col-sm-2 control-label">是否为定向标：</label>
		  		<div class="col-sm-8">
		  			<input type="text" class="form-control" name="upload_apply_doc" id="upload_apply_doc">
		  		</div>
		  	</div>
		  	<div class="form-group">
		  		<label class="col-sm-2 control-label">是否为奖励标：</label>
		  		<div class="col-sm-8">
		  			<input type="text" class="form-control" name="upload_apply_doc" id="upload_apply_doc">
		  		</div>
		  	</div>
			<!-- 信息不完整 -->
	    	<div class="form-group">
	    		<div class="col-sm-offset-2 col-sm-10">
	    			<button type="submit" class="btn btn-success">提交</button>
	    			<button type="submit" class="btn btn-default">保存</button>
	    		</div>
	    	</div>
	    </form>
	</div>
    <!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>