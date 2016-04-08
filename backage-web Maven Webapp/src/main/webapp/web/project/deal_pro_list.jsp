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
<!-- 贷后管理---------成交项目列表 -->
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
					<li role="presentation" class="active"><a href="web/project/deal_pro_list.jsp">成交项目列表</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>项目编号</span><input type="text" class="" value="项目编号" /></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="" value="借款人用户名" /></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="" value="借款人姓名" /></span>
									<span class="con-item"><span>借款期限</span><input type="date" class="" value="借款期限(天、月)" /></span>
									<span class="con-item"><span>实际借款金额</span><input type="text" class="" value="实际借款金额" /></span>
									<span class="con-item"><span>还款方式</span><input type="text" class="" value="还款方式" /></span>
									<span class="con-item"><span>合同约定下一还款日</span><input type="date" class="" value="合同约定下一还款日" /></span>
									<span class="con-item"><span>还款状态</span><input type="text" class="" value="还款状态" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="deal_list_pro_detail" class="obtn glyphicon glyphicon-plus">查看项目详情</button>
						  			<button id="deal_list_pay_detail" class="obtn glyphicon glyphicon-plus">查看还款详情</button>
						  			<button id="deal_list_supervice_list" class="obtn glyphicon glyphicon-plus">项目监管</button>
								</div>
							</div>
						<div class="panel-body">
						<table id="table_deal_list" class="display">
							<thead>
								<tr>
									<th></th>
									<th>项目编号</th>
									<th>项目名称</th>
									<th>借款人用户名</th>
									<th>借款人姓名</th>
									<th>电话号码</th>
									<th>产品类型</th>
									<th>借款期限</th>
									<th>申请借款金额</th>
									<th>实际借款金额</th>
									<th>年化利率</th>
									<th>还款方式</th>
									<th>合同约定下一个还款日</th>
									<th>还款状态</th>
									<th>未还本金</th>
									<th>未还利息</th>
									<th>逾期费</th>
									<th>逾期天数</th>
									<th>首次申请时间</th>
									<th>项目审批完成时间</th>
									<th>发布时间</th>
									<th>融资结束时间</th>
									<th>放款时间</th>
									<th>项目结清时间</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
									<td>还款中</td>
									<td>10万</td>
									<td>1万</td>
									<td>38293</td>
									<td>29</td>
									<td>02-04</td>
									<td>03-01</td>
									<td>04-12</td>
									<td>04-15</td>
									<td>04-15</td>
									<td>04-15</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
									<td>还款中</td>
									<td>10万</td>
									<td>1万</td>
									<td>38293</td>
									<td>29</td>
									<td>02-04</td>
									<td>03-01</td>
									<td>04-12</td>
									<td>04-15</td>
									<td>04-15</td>
									<td>04-15</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
									<td>还款中</td>
									<td>10万</td>
									<td>1万</td>
									<td>38293</td>
									<td>29</td>
									<td>02-04</td>
									<td>03-01</td>
									<td>04-12</td>
									<td>04-15</td>
									<td>04-15</td>
									<td>04-15</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
									<td>还款中</td>
									<td>10万</td>
									<td>1万</td>
									<td>38293</td>
									<td>29</td>
									<td>02-04</td>
									<td>03-01</td>
									<td>04-12</td>
									<td>04-15</td>
									<td>04-15</td>
									<td>04-15</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
									<td>还款中</td>
									<td>10万</td>
									<td>1万</td>
									<td>38293</td>
									<td>29</td>
									<td>02-04</td>
									<td>03-01</td>
									<td>04-12</td>
									<td>04-15</td>
									<td>04-15</td>
									<td>04-15</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
									<td>还款中</td>
									<td>10万</td>
									<td>1万</td>
									<td>38293</td>
									<td>29</td>
									<td>02-04</td>
									<td>03-01</td>
									<td>04-12</td>
									<td>04-15</td>
									<td>04-15</td>
									<td>04-15</td>
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
	<script src="js/project/deal_pro_list.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_deal_list').DataTable({
						"autoWidth" : false,
						"scrollY": 500,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[ 12, "desc"],[ 18, "desc"],[ 19, "desc"],[ 20, "desc"],[ 21, "desc"],[ 22, "desc"],[ 23, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17]
						} // 制定列不参与排序
						],
						colReorder : false,
						"scrollX": true,
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