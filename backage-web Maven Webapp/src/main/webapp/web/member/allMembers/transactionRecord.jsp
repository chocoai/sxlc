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


<div class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
				<!-- 地址导航 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
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
								<span class="con-item"><span>交易类型</span><input type="text" class="notspecial" ></span>
								<span class="con-item"><span>交易时间范围</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
					  	</div>
					 </div>
				</div> 
				<div class="data_display">
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>序号ID</th>
										<th>交易类型</th>
										<th>交易金额</th>
										<th>总金额</th>
										<th>冻结金额</th>
										<th>待收本金</th>
										<th>待收利息</th>
										<th>可用金额</th>
										<th>待还本金</th>
										<th>待还利息</th>
										<th>待还逾期利息</th>
										<th>待还逾期罚金</th>
										<th>交易对方</th>
										<th>交易时间</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>1</td>
										<td>交易类型</td>
										<td class="moneyFormat">100</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td class="moneyFormat">1200</td>
										<td>交易对方</td>
										<td>交易时间</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>
	
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript">
		$(function(){
	$('#table_id').DataTable({
		"scrollX":true,
		//"scrollY":true,
		"aaSorting" : [ [ 3,4,5,6,7,9,10,11, "desc" ] ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,8,12,13,14]
		} // 制定列不参与排序
		],
	});
});
	</script>
</div>

