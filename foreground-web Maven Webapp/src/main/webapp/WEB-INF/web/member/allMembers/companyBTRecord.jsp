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
				<div class="data_display">
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>项目名称</th>
										<th>转让金额(元)</th>
										<th>转让系数(%)</th>
										<th>转让价格(元)</th>
										<th>最晚转让时间</th>
										<th>投资进度(%)</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>项目名称</td>
										<td class="moneyFormat">1000</td>
										<td>8</td>
										<td class="moneyFormat">10</td>
										<td>2016-06-01</td>
										<td>投资进度</td>
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
	<script type="text/javascript">
		$(function(){
			$('#table_id').DataTable({
				"scrollX":true,
				//"scrollY":true,
				"aaSorting" : [  ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3,4,5,6]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</div>

