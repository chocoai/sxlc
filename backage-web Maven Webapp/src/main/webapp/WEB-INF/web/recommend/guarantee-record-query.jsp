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
	<title>保荐机构管理-担保记录查询</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
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
				</div>
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus" onclick="manageAdd()">账户信息查看</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="manageMod()">充值</button>
								<button class="obtn" onclick="checkDetail()">提现</button>
								<button class="obtn" onclick="manageAdmain()">担保项目设置</button>
								<button class="obtn" onclick="checkProject()">自动代偿设置</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>项目编号</th>
										<th>项目名称</th>
										<th>借款金额</th>
										<th>项目保证金</th>
										<th>担保登记时间</th>
										<th>是否代偿</th>
										<th>代偿金额</th>
										<th>最近代偿时间</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>项目编号</td>
										<td>项目名称</td>
										<td>借款金额</td>
										<td>项目保证金</td>
										<td>担保登记时间</td>
										<td>
											<span>
												<select>
													<option>请选择</option>
													<option>是</option>
													<option>否</option>
												</select>
											</span>
										</td>
										<td>代偿金额</td>
										<td>最近代偿时间</td>
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
			
			
			<!-- <!-- 查看担保机构信息部分开始
			<div class="w-content" id="checkDetail">
				<form action="">
					<table>
						<tr>
							<td><label>担保机构名称</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>营业执照号码</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>组织机构代码</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>税务登记号</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>经营场所</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>注册资金</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>法人姓名</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>法人手机号</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>法人身份照号</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>注册地址</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>注册资本来源</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>经营范围</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>公司简介</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>联系人姓名</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>联系人手机号</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>联系人邮箱</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>绑定后台管理员</label></td>
							<td><input type="text" class="" placeholder="" /></td>
							<td><label>设置的担保配置信息</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
						<tr>
							<td><label>上传的担保证件</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
					</table>
				</form>
			</div>
			查看担保机构信息部分结束 --> -->
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
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
</body>

</html>