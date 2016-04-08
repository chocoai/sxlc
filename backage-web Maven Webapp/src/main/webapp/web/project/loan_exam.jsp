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
</head>
<!-- 借款审核--------列表详情展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:;">列表展示详情</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>类型名称</span><input type="text" class="" value="类型名称" /></span>
									<span class="con-item"><span>借款人申请时间</span><input type="text" class="" value="借款人申请时间" /></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="" value="借款人用户名" /></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="" value="借款人姓名" /></span>
									<span class="con-item"><span>项目状态</span><input type="text" class="" value="项目状态" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
									<!-- <form class="form-inline" name="search">
										<div class="form-group">
										    <label for="pro_name">类型名称:</label>
										    <input type="text" class="form-control" id="pro_name" name="pro_name" placeholder="项目名称">
										</div>
										<div class="form-group">
									    	<label for="apply_time">借款人申请时间:</label>
									    	<input type="text" class="form-control" id="apply_time" name="apply_time" placeholder="借款人申请时间">
										</div>
										<div class="form-group">
										    <label for="borrower_name">借款人用户名:</label>
										    <input type="text" class="form-control" id="borrower_name" name="borrower_name" placeholder="借款人用户名">
										</div>
										<div class="form-group">
									    	<label for="borrower_user">借款人姓名:</label>
									    	<input type="text" class="form-control" id="borrower_user" name="borrower_user" placeholder="借款人姓名">
										</div>
										<div class="form-group">
									    	<label for="pro_state">项目状态:</label>
									    	<input type="text" class="form-control" id="pro_state" name="pro_state" placeholder="项目状态">
										</div>
										<button type="button" class="btn btn-default search_btn">查询</button>
									</form> -->
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
					  				<button id="loan_pro_exam" class="obtn glyphicon glyphicon-plus">项目审核</button>
									<button id="loan_pro_detail" class="obtn glyphicon glyphicon-pencil">项目详情</button>
									<button id="history_exam_record" class="obtn glyphicon glyphicon-ok-circle">历史审批记录</button>
								</div> 
					  		<!-- <div class="i-fr action_item">
					  			<ul class="list_item list-inline">
									<li id="loan_exam-1">
										<span>项目审核</span>
									</li>
									<li id="loan_pro_detail">
										<span>项目详情</span>
									</li>
									<li  id="history_exam_record">
										<span>历史审批记录</span>
									</li>
								</ul>
							</div>  -->
						</div>
						<div class="panel-body">
							<table id="table_loan_detail_list" class="display">
								<thead>
									<tr>
										<th></th>
						                <th>借款人申请日期</th>
						                <th>借款申请项目编号</th>
						                <th>借款人用户名</th>
						                <th>借款人姓名</th>
						                <th>借款项目名称</th>
						                <th>借款产品类型</th>
						                <th>借款期限</th>
						                <th>借款金额</th>
						                <th>年化利率</th>
						                <th>还款方式</th>
						                <th>状态</th>
						            </tr>
						        </thead>
						        <tbody>
						        	<tr>
						        		<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						            <tr>
						            	<td><input type="checkbox"></td>
						                <td>信用贷</td>
						                <td>20万~40万</td>
						                <td>20万</td>
						                <td>4%</td>
						                <td>20天</td>
						                <td class="current_state">已启用</td>
						                <td>简介:</td>
						                <td>无</td>
						                <td>img</td>
						                <td>无</td>
						                <td>img</td>
						            </tr>
						       	</tbody>
						    </table>
						</div>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/project/loan_exam.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_loan_detail_list').DataTable({
						"autoWidth" : false,
						scrollY : 500,
						//paging : false,//分页
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [], //默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 ]
						} // 制定列不参与排序
						],
						colReorder : false,
						"sScrollX" : "100%",
						"sScrollXInner" : "100%",
						"bScrollCollapse" : true
					});
				});
			</script>
		</div>
	</div>
</body>

</html>