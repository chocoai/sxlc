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
	<title>保荐机构管理-账户中心</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/account-center.css" type="text/css"></link>
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp">
				<jsp:param value="902" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus" onclick="accRecharge('充值','web/recommend/re-add/acc-recharge.jsp','2')">充值</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="accWithdraw()">提现</button>
								<!-- <button class="obtn" onclick="accCheckRecords()">查看担保费收取记录</button> -->
								<button class="obtn" onclick="loanAmount()">担保借款金额范围</button>
								<button class="obtn" onclick="productType()">担保产品类型</button>
								<button class="obtn" onclick="termRange()">允许担保借款期限起止范围</button>
								<button class="obtn" onclick="documentManagement()">担保证件管理</button>
								<button class="obtn" onclick="accOnOff()">开启/关闭自动代偿</button>
							</div>
						</div>
					</div>
					<div class="content2">
		   				<div class="info clearfix">
			   				<fieldset class="accountfd">
			   					<legend>账户中心</legend>
			   					<div>
					   				<div class="item">
					   					<div class="label">第三方账户号：</div>
					   					<div class="con">第三方账户号</div>
					   				</div>
					   				<div class="item">
					   					<div class="label">当前余额：</div>
					   					<div class="con"><label class="moneyFormat">1000</label>元</div>
					   				</div>
					   				<div class="item">
					   					<div class="label">代偿总金额：</div>			   				
								   		<div class="con"><label class="moneyFormat">1000</label>元</div>
										
					   				</div>
					   				<div class="item">
					   					<div class="label">代偿回款总金额：</div>
					   					<div class="con"><label class="moneyFormat">1000</label>元</div>
					   				</div>
					   				<div class="item">
					   					<div class="label">代偿未回款总金额：</div>
					   					<div class="con"><label class="moneyFormat">1000</label>元</div>
					   				</div>
					   				<div class="item">
					   					<div class="label">担保费收取总金额：</div>
					   					<div class="con"><label class="moneyFormat">1000</label>元</div>
					   				</div>
				   				</div>
			   				</fieldset>
			   			</div>
		   			</div>
				</div>
				<!-- 担保借款金额范围部分开始 -->
				<div class="w-content" id="loanamount">
					<form role="form" class="" id="loanamountform">
						<div class="form-group"> 
							<label>最大借款金额：</label><input type="text" value="" datatype="amcountM"/><samp>元</samp>
						</div>
						<div class="form-group"> 
							<label>最小借款金额：</label><input type="text" value="" datatype="amcountM"/><samp>元</samp>
						</div>
						<div class="cmbtncontainer loanamountcon">
							<a class="commonbtn0">添加</a>
							<a class="commonbtn1">取消</a>
						</div>
					</form>
				</div>
				<!-- 担保借款金额范围部分结束 -->
				<!-- 担保产品类型部分开始 -->
				<div class="w-content" id="producttype">
					<form>
						<table>
							<tr>
								<td>担保产品类型</td>
								<td>
									<span class="producttypechk">
										<input type="checkbox" name="optionsRadios" id="" value=""> 
						 				<label class="checkbox-inline">信用贷</label>
									</span>
									<span class="producttypechk">
										<input type="checkbox" name="optionsRadios" id="" value=""> 
						 				<label class="checkbox-inline">担保贷</label>
									</span>
									<span class="producttypechk">
										<input type="checkbox" name="optionsRadios" id="" value=""> 
						 				<label class="checkbox-inline">抵押贷</label>
									</span>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<!-- 担保产品类型部分结束 -->
				<!-- 允许担保借款期限起止范围部分开始 -->
				<div class="w-content" id="termrange">
					<form role="form" class="" id="termRangeform">
						<div class="form-group"> 
							<label>天标：</label><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" >
						</div>
						<div class="form-group"> 
							<label>月标：</label><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" >
						</div>
						<div class="form-group"> 
							<label>年标：</label><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" >
						</div>
						<div class="cmbtncontainer loanamountcon">
							<a class="commonbtn0">添加</a>
							<a class="commonbtn1">取消</a>
						</div>
					</form>
				</div>
				<!-- 允许担保借款期限起止范围部分结束 -->
			</div>
		</div>
			<!-- 尾部 -->
	</div>
			
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/account-center.js"></script>
	<script>
		$(".commonbtn1").click(function(){
			layer.closeAll(); //再执行关闭  
		});
		$(function(){
			validform5(".commonbtn0","loanamountform",false,"3");
		});
		$(function() {
			$('#table_id').DataTable({
				"autoWidth" : false,
				//scrollY : 500,
				//paging : false,//分页
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8 ]
				} // 制定列不参与排序
				],
				colReorder : false,
				"sScrollX" : "100%",
				"sScrollXInner" : "100%",
				"bScrollCollapse" : true
			});
		});
	</script>
</body>

</html>