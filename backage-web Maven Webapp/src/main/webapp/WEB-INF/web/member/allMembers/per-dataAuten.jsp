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
					<th>会员登录名</th>
					<th>姓名</th>
					<th>性别</th>
					<th>身份证号</th>
					<th>籍贯</th>
					<th>手机号</th>
					<th>申请时间</th>
					<th>有效期</th>
					<th>所属服务器</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < 15; i++) {
				%>
				<tr>
					<td><input type="checkbox" /></td>
					<td>会员登录名</td>
					<td>姓名</td>
					<td>性别</td>
						<td>身份证号</td>
						<td>籍贯</td>
						<td>手机号</td>
						<td>申请时间</td>
						<td>有效期</td>
						<td>所属服务器</td>
					</tr>
					<%
						}
					%>
				</tbody>
		</table>
						</div>
						
					</div>
				</div>
				<div class="buttonSet2">
					<button class="obtn obtn-query">变更</button>
					<button class="obtn obtn-query">取消</button>
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
					"aTargets" : [0,1,2,3,4,5,6]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</div>

