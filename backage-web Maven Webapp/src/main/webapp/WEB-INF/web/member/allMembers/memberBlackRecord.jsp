<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>



<div class="nav-md">
	<div class="container body">
		<div class="main_container">
				<!-- 地址导航 -->
				<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							
							<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>拉黑时间</th>
											<th>拉黑操作管理员</th>
											<th>取消拉黑时间</th>
											<th>取消拉黑操作管理员</th>
											<th>取消拉黑原因</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>拉黑时间</td>
											<td>拉黑操作管理员</td>
											<td>取消拉黑时间</td>
											<td>取消拉黑操作管理员</td>
											<td>取消拉黑原因</td>
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
				"aaSorting" : [  ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3,4,5]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</div>