<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 管理员管理部分开始 -->
			<div id="manageAdmain">
				<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="manageAdmainAdd()">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="manageAdmainMod()">修改</button>
								</div>
							</div>
						</div>
				</div>
				<table id="admaintable" class="display">
					<thead>
						<tr>
							<th class="table-checkbox"></th>
							<th>管理员名称</th>
							<th>添加时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<%for(int j=0;j<5;j++){ %>
						<tr>
							<td><input type="checkbox" /></td>
							<td>管理员名称</td>
							<td>管理员名称</td>
							<td>已启用</td>
							<td><a class="obtn" href="javascript:;" onclick="enable()">停用/启用</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<!-- 管理员管理部分结束 --> 
			<!-- 管理员管理-添加管理员部分开始 -->
			<div class="w-content" id="manageAdmainAdd">
				<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus" onclick="">添加</button>
								</div>
							</div>
						</div>
				</div>
				<table id="admaintableadd" class="display">
					<thead>
						<tr>
							<th class="table-checkbox"></th>
							<th>管理员名称</th>
						</tr>
					</thead>
					<tbody>
						<%for(int j=0;j<5;j++){ %>
						<tr>
							<td><input type="checkbox" /></td>
							<td>管理员名称</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<!-- 管理员管理-添加管理员部分结束 -->
			<!-- 管理员管理-修改管理员部分开始 -->
			<div class="w-content" id="manageAdmainMod">
				<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus" onclick="">添加</button>
								</div>
							</div>
						</div>
				</div>
				<table id="admaintablemod" class="display">
					<thead>
						<tr>
							<th class="table-checkbox"></th>
							<th>管理员名称</th>
						</tr>
					</thead>
					<tbody>
						<%for(int j=0;j<5;j++){ %>
						<tr>
							<td><input type="checkbox" /></td>
							<td>管理员名称</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<!-- 管理员管理-修改管理员部分结束 -->		
	
	<!-- 私用js -->
	<script type="text/javascript" src="../js/recommend/guarantee-manage.js"></script>
	<script type="text/javascript">
		$('#admaintable').DataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,2,3]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript">
		$('#admaintableadd').DataTable({
			/* "aaSorting" :false,//默认第几个排序 */
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript">
		$('#admaintablemod').DataTable({
			/* "aaSorting" :false,//默认第几个排序 */
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0]
			} // 制定列不参与排序
			],
		});
	</script>

			