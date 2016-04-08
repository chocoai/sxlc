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
	<title>配置中心--财务配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置  提奖规则配置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	
			 	<!-- 提奖规则设置 -->
			 	<div class="award-rule-set">
			 		<!-- 注：推荐达人提奖规则配置中的          基本配置        取消 -->
			 		<!-- 数据显示 -->
			 		<ul class="nav nav-tabs">
						<li role="presentation" class="active"><a href="javascript:;">推荐达人提奖规则配置</a>
						</li>
						<li role="presentation" class=""><a href="javascript:;">理财顾问提奖规则配置</a>
						</li>
					</ul>
					<!-- 推荐达人提奖规则设置 -->
					<div class="nav-tabs-con active">
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="action_item">
										<button class="obtn glyphicon glyphicon-plus obtn-master-add">添加</button>
										<button class="obtn glyphicon glyphicon-trash obtn-master-del">删除</button>
									</div>
								</div>
								<div class="panel-body">
									<table id="table-master" class="display">
										<thead>
											<tr>
												<th class="table-checkbox"></th>
												<th>推荐达人成功邀请累计投资总额范围</th>
												<th>等级</th>
												<th>等级描述</th>
												<th>投资返现百分比加点</th>
												<th>借款返现百分比加点</th>
												<th>推荐购买VIP提奖加百分点</th>
												<th>推荐还本提奖百分比加点</th>
												<th>邀请人投资管理费百分点折扣</th>
												<th>邀请人借款管理费百分点折扣</th>
											</tr>
										</thead>
										<tbody>
											<%
												for (int i = 0; i < 15; i++) {
											%>
											<tr>
												<td><input type="checkbox" /></td>
												<td>R001</td>
												<td>管理员</td>
												<td>2016年3月10日</td>
												<td>管理地区事务</td>
												<td>R001</td>
												<td>管理员</td>
												<td>2016年3月10日</td>
												<td>管理地区事务</td>
												<td>管理地区事务</td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
								
								<!-- 添加提奖达人规则的特殊配置--推荐达人提奖 -->
								<div class="w-content master-add">
									<table>
										<tr>
											<td class="tt"><label class="ineed">推荐达人成功邀请有效投资最小总额：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>推荐达人成功邀请有效投资最大总额：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>投资返现百分比加点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>借款返现百分比加点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>推荐购买VIP提奖加百分点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>推荐还本提奖百分比加点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>邀请人投资管理费百分点折扣：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>邀请人借款管理费百分点折扣：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>等级：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>等级描述：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- 理财顾问提奖规则配置 -->
					<div class="nav-tabs-con">
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="action_item">
										<button class="obtn glyphicon glyphicon-plus obtn-adviser-add">添加</button>
										<button class="obtn glyphicon glyphicon-trash obtn-adviser-del">删除</button>
									</div>
								</div>
								<div class="panel-body">
									<table id="table-adviser" class="display">
										<thead>
											<tr>
												<th class="table-checkbox"></th>
												<th>理财顾问成功邀请有效投资总额范围</th>
												<th>投资返现百分比加点</th>
												<th>借款返现百分比加点</th>
												<th>推荐购买VIP提奖加百分点</th>
												<th>推荐还本提奖百分比加点</th>
												<th>邀请人投资管理费百分点折扣</th>
												<th>邀请人借款管理费百分点折扣</th>
											</tr>
										</thead>
										<tbody>
											<%
												for (int i = 0; i < 15; i++) {
											%>
											<tr>
												<td><input type="checkbox" /></td>
												<td>R001</td>
												<td>管理员</td>
												<td>2016年3月10日</td>
												<td>管理地区事务</td>
												<td>R001</td>
												<td>管理员</td>
												<td>2016年3月10日</td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
								
								<!-- 添加提奖达人规则的特殊配置  --理财顾问体检-->
								<div class="w-content adviser-add">
									<table>
										<tr>
											<td class="tt"><label class="ineed">理财顾问成功邀请有效投资最小总额：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>理财顾问成功邀请有效投资最大总额：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>投资返现百分比加点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>借款返现百分比加点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>推荐购买VIP提奖加百分点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>推荐还本提奖百分比加点：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>邀请人投资管理费百分点折扣：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
										<tr>
											<td class="tt"><label>邀请人借款管理费百分点折扣：</label></td>
											<td class="con">
												<input type="text" class="" placeholder="" />
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js//config/config.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		 /* 推荐达人提奖规则设置----表格 */
		$(function() {
			$('#table-master').DataTable({
				"autoWidth" : false,
				//scrollY : 500,
				//paging : false,//分页
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0,1,2,3,4,5,6,7,8,9]
				} // 制定列不参与排序
				],
				colReorder : false,
				"scrollX": true,
				"sScrollX" : "100%",
				"sScrollXInner" : "100%",
				"bScrollCollapse" : true
			});
		}); 
		/* 理财顾问提奖规则设置----表格 */
		$(function(){
			$('#table-adviser').DataTable({
				"autoWidth" : false,
				//scrollY : 500,
				//paging : false,//分页
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0,1,2,3,4,5,6,7]
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
</body>

</html>