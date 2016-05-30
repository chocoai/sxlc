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
	<title>配置中心-推荐达人积分规则设置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>

			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="613" name="_index_m2"/>
				<jsp:param value="61302" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:;">投资积分设置</a>
					</li>
					<li role="presentation" class=""><a href="javascript:;">债券转让投资积分设置</a>
					</li>
					<li role="presentation" class=""><a href="javascript:;">充值积分设置</a>
					</li>
					<li role="presentation" class=""><a href="javascript:;">借款积分设置</a>
					</li>
				</ul>
			 	<div class="panel-body basicSet">
			 		<form id="" class="" action="">
						<span class="col-md-3"><span>邀请注册积分</span><input type="text"></span>
						<span class="col-md-3"><button type="button" class="obtn obtn-query">确定</button></span>
					</form>
			 	</div>
			 	<!-- 投资积分列表及设置 -->
			 	<div class="nav-tabs-con active">
				 	<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button class="obtn glyphicon glyphicon-plus btn-inv-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil btn-inv-mod">修改</button>
									<button class="obtn glyphicon glyphicon-trash btn-inv-del">删除</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_inv_integral" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>投资金额(元)</th>
											<th>赠送积分</th>
											<th>状态</th>
											<th>操作</th>																
										</tr>
									</thead>
									<tbody>
									<%for (int i=0;i<5;i++){ %>
										<tr>
											<td><input type="checkbox"></td>
											<td class="moneyFormat">10000</td>
											<td>100</td>
											<td>状态</td>
											<td>
												<a href="javascript:;" class="btn-enable">启用</a>
												<a href="javascript:;" class="btn-disable">停用</a>
											</td>	
										</tr>
										<%}%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- 债券转让投资积分列表及设置 -->
				<div class="nav-tabs-con">
				 	<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button class="obtn glyphicon glyphicon-plus btn-credit-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil btn-credit-mod">修改</button>
									<button class="obtn glyphicon glyphicon-trash btn-credit-del">删除</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_credit_integral" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>投资金额(元)</th>
											<th>赠送积分</th>
											<th>状态</th>
											<th>操作</th>																
										</tr>
									</thead>
									<tbody>
									<%for (int i=0;i<5;i++){ %>
										<tr>
											<td><input type="checkbox"></td>
											<td class="moneyFormat">10000</td>
											<td>100</td>
											<td>状态</td>
											<td>
												<a href="javascript:;" class="btn-enable">启用</a>
												<a href="javascript:;" class="btn-disable">停用</a>
											</td>	
										</tr>
										<%}%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- 充值积分列表及设置 -->
				<div class="nav-tabs-con">
				 	<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button class="obtn glyphicon glyphicon-plus btn-recharge-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil btn-recharge-mod">修改</button>
									<button class="obtn glyphicon glyphicon-trash btn-recharge-del">删除</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_recharge_integral" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>充值金额(元)</th>
											<th>赠送积分</th>
											<th>状态</th>
											<th>操作</th>																
										</tr>
									</thead>
									<tbody>
									<%for (int i=0;i<5;i++){ %>
										<tr>
											<td><input type="checkbox"></td>
											<td class="moneyFormat">10000</td>
											<td>100</td>
											<td>状态</td>
											<td>
												<a href="javascript:;" class="btn-enable">启用</a>
												<a href="javascript:;" class="btn-disable">停用</a>
											</td>	
										</tr>
										<%}%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- 借款积分列表及设置 -->
				<div class="nav-tabs-con">
				 	<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button class="obtn glyphicon glyphicon-plus btn-loan-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil btn-loan-mod">修改</button>
									<button class="obtn glyphicon glyphicon-trash btn-loan-del">删除</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_loan_integral" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>借款金额(元)</th>
											<th>赠送积分</th>
											<th>状态</th>
											<th>操作</th>																
										</tr>
									</thead>
									<tbody>
									<%for (int i=0;i<5;i++){ %>
										<tr>
											<td><input type="checkbox"></td>
											<td class="moneyFormat">10000</td>
											<td>100</td>
											<td>状态</td>
											<td>
												<a href="javascript:;" class="btn-enable">启用</a>
												<a href="javascript:;" class="btn-disable">停用</a>
											</td>	
										</tr>
										<%}%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			 </div>
		</div>
	</div>
	<!-- 投资积分弹出层 -->
	<div class="inv-integral-layer">
		<div class="w-content ishow">
			<table>
				<tr class="col-md-12">
					<td class="tt"><label>投资金额：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
				<tr class="col-md-12">	
					<td class="tt"><label>赠送积分：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
			</table>
		</div>	
	</div>
	<!-- 债权转让投资积分弹出层 -->
	<div class="credit-integral-layer">
		<div class="w-content ishow">
			<table>
				<tr class="col-md-12">
					<td class="tt"><label>投资金额：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
				<tr class="col-md-12">	
					<td class="tt"><label>赠送积分：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
			</table>
		</div>	
	</div>
	<!-- 充值积分弹出层 -->
	<div class="recharge-integral-layer">
		<div class="w-content ishow">
			<table>
				<tr class="col-md-12">
					<td class="tt"><label>充值金额：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
				<tr class="col-md-12">	
					<td class="tt"><label>赠送积分：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
			</table>
		</div>	
	</div>
	<!-- 借款积分弹出层 -->
	<div class="loan-integral-layer">
		<div class="w-content ishow">
			<table>
				<tr class="col-md-12">
					<td class="tt"><label>借款金额：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
				<tr class="col-md-12">	
					<td class="tt"><label>赠送积分：</label></td>
					<td class="con">
						<input type="text">
					</td>
				</tr>
			</table>
		</div>	
	</div>
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/config/integral-rule.js"></script>
</body>

</html>