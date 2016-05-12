<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<!-- 主要内容 -->
	<div class="" role="main">
		<!-- 地址导航 -->
		<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<!-- 添加审批点配置 -->
			<div class="w-content ishow proexam-point-add">
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li><a class="state">展开&nbsp;<span
											class="glyphicon glyphicon-chevron-down"></span> </a>
									</li>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form id="" class="" action="">
								<span class="con-item">
									<span>活动点名称</span><input type="text" class="" placeholder=""/>
								</span>
								<span class="">
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</span>
							</form>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<table id="addproexamexam" class="display">
						<thead>
							<tr>
								<th></th>
								<th>活动点名称</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < 6; i++) {
							%>
							<tr>
								<td><input type="checkbox"></td>
								<td>活动点名称1</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<div class="layui-layer-btn addproprocessbtn">
						<a class="layui-layer-btn0">添加</a>
						<a class="layui-layer-btn1" href="web/config/proexam-process.jsp">取消</a>
					</div>
				</div>
			</div>							
		</div>
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/config/proexam-process.js"></script>
	<script>
		$('#addproexamexam').DataTable({
			//scrollY : 400,
			"scrollX":true,
			"aaSorting" : [  ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1]
			} // 制定列不参与排序
			],
		});
	</script>
