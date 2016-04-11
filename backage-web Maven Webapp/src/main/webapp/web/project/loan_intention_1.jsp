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
<!-- 借款申请管理--------借款意向列表查询 -->
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
					<li role="presentation" class="active"><a href="javascript:;">借款意向列表查询</a>
					</li>
					<li role="presentation" class=""><a href="web/project/loan_intention_2.jsp">直接意向借款</a>
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
									<span class="con-item"><span>会员编号</span><input type="text" class="" value="会员编号" /></span>
									<span class="con-item"><span>会员用户名</span><input type="text" class="" value="会员用户名" /></span>
									<span class="con-item"><span>会员联系号码</span><input type="text" class="" value="会员联系号码" /></span>
									<span class="con-item"><span>还款方式</span><input type="text" class="" value="还款方式" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<div class="action_item">
					  			<button id="pro_allocation" class="obtn glyphicon glyphicon-plus">项目分配理财顾问</button>
								<button id="add_information" class="obtn glyphicon glyphicon-pencil">补充资料</button>
								<button id="add_loan_apply" class="obtn glyphicon glyphicon-trash">添加到借款申请</button>
								<button id="loan_member_black" class="obtn glyphicon glyphicon-plus">借款会员拉黑</button>
								<button id="loan_exam_record" class="obtn glyphicon glyphicon-pencil">查看审批记录</button>
								<button id="loan_detail" class="obtn glyphicon glyphicon-trash">查看借款项目详情</button>
								<button id="refuse_payment" class="obtn glyphicon glyphicon-trash">拒绝借款</button>
							</div>
					  		<!-- <div class="i-fr action_item">
					  			<ul class="list_item list-inline">
									<li id="pro_allocation">
										<span>项目分配理财顾问</span>
									</li>
									<li id="add_information">
										<span>补充资料</span>
									</li>
									<li  id="add_loan_apply">
										<span>添加到借款申请</span>
									</li>
									<li  id="loan_member_black">
										<span>借款会员拉黑</span>
									</li>
									<li  id="loan_exam_record">
										<span>查看审批记录</span>
									</li>
									<li  id="loan_detail">
										<span>查看借款项目详情</span>
									</li>
									<li  id="refuse_payment">
										<span>拒绝借款</span>
									</li>
								</ul>
							</div>  -->
						</div>
						<div class="panel-body">
							<table id="table_loan_intention_1" class="display">
								<thead>
									<tr>
										<th></th>
										<th>会员编号</th>
										<th>会员用户名</th>
										<th>会员名称</th>
										<th>会员联系号码</th>
										<th>借款金额</th>
										<th>借款期限</th>
										<th>还款方式</th>
										<th>借款用途</th>
										<th>还款来源</th>
										<th>借款描述</th>
										<th>期限类型</th>
										<th>提交意向时间</th>
										<th>有无分配理财顾问</th>
										<th>提交借款申请时间</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>0000001</td>
										<td>jiuyang</td>
										<td>九阳股份</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>方式</td>
										<td>用途</td>
										<td>来源</td>
										<td>描述</td>
										<td>类型</td>
										<td>时间</td>
										<td>分配</td>
										<td>提交时间</td>
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
	<script src="js/project/loan_intention_1.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_loan_intention_1').DataTable({
						"autoWidth" : false,
						scrollY : 500,
						//paging : false,//分页
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13 ]
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