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
					<div class="selectMember">
						<span><samp>选择会员：</samp>某某某</span>
						<span><samp>姓名：</samp>某某某</span>
						<div class="buttonSet2">
							<button class="obtn obtn-query">确定</button>
							<button class="obtn obtn-query">取消</button>
						</div>
					</div>
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
									<span class="con-item"><span>姓名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>编号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>手机号</span><input type="text" class="notspecial" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
					 	</div>
					 </div>
					<div class="panel-body">
						<table id="table_id" class="display">
							<thead>
								<tr>
									<th class="table-checkbox"></th>
									<th>姓名</th>
									<th>编号</th>
									<th>手机号</th>
									<th>会员登录名</th>
									<th>成为理财顾问时间</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (int i = 0; i < 15; i++) {
								%>
								<tr>
									<td><input type="checkbox" /></td>
									<td>姓名</td>
									<td>编号</td>
									<td>手机号</td>
									<td>会员登录名</td>
									<td>成为理财顾问时间</td>
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

