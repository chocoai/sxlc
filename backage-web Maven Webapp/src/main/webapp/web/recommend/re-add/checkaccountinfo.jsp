<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

				<div class="search">
						<div class="panel-body">
							<form id="" class="" action="">
								<span class="con-item col-md-3 col-sm-6 col-xs-6">
									<span>项目编号</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item col-md-3 col-sm-6 col-xs-6">
									<span>项目名称</span><input type="text" class="departmentname" placeholder="" />
								</span>
								<span class="con-item col-md-3 col-sm-6 col-xs-6">
									<span>担保登记时间</span><input type="text" class="licencenum" placeholder="" />
								</span>
								<span class="con-item col-md-3 col-sm-6 col-xs-6">
									<span>是否代偿</span><input type="text" class="contactname" placeholder="" />
								</span>
								<span class="con-item col-md-3 col-sm-6 col-xs-6">
									<span>最近代偿时间</span><input type="text" class="contactphone" placeholder="" />
								</span>
								<span class="col-md-9 col-sm-12 col-xs-12">
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</span>
							</form>
						</div>
					</div>
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>第三方账户号</th>
										<th>当前余额</th>
										<th>代偿总金额</th>
										<th>代偿回款总金额</th>
										<th>代偿未回款总金额</th>
										<th>担保费收取总金额</th>
										<th>自动代偿是否开启</th>
										<th>担保配置</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>第三方账户号</td>
										<td>当前余额</td>
										<td>代偿总金额</td>
										<td>代偿回款总金额</td>
										<td>代偿未回款总金额</td>
										<td>担保费收取总金额</td>
										<td>自动代偿是否开启</td>
										<td>担保配置</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			<!-- 尾部 -->
	<!-- 公用js -->
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/guarantee-manage.js"></script>
	<script type="text/javascript">
		$('#table_id').DataTable({
			autoWidth : false,
			"aaSorting" : [ [ 4,5,8, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,6,7]
			} // 制定列不参与排序
			],
		});
	</script>

