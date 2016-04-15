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
	<title>保荐机构管理-担保机构管理</title>
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
								<span class="con-item col-md-4 col-sm-6 col-xs-12">
									<span>编号</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item col-md-4 col-sm-6 col-xs-12">
									<span>担保机构名称</span><input type="text" class="departmentname" placeholder="" />
								</span>
								<span class="con-item col-md-4 col-sm-6 col-xs-12">
									<span>营业执照号</span><input type="text" class="licencenum" placeholder="" />
								</span>
								<span class="con-item col-md-4 col-sm-6 col-xs-12">
									<span>联系人姓名</span><input type="text" class="contactname" placeholder="" />
								</span>
								<span class="con-item col-md-4 col-sm-6 col-xs-12">
									<span>联系人手机号</span><input type="text" class="contactphone" placeholder="" />
								</span>
								<span class="con-item col-md-2 col-sm-4 col-xs-4">
									<span>状态</span>
									<select>
										<option>请选择</option>
										<option>启用</option>
										<option>停用</option>
									</select>
								</span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div>
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="manageAdd()">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="manageMod()">修改</button>
								<button class="obtn" onclick="checkDetail()">查看详情</button>
								<button class="obtn" onclick="manageAdmain()">管理员管理</button>
								<button class="obtn" onclick="checkProject()">担保项目查看</button>
								<button class="obtn" onclick="checkRecord()">代偿记录查询</button>
								<button class="obtn" onclick="checkPayment()">代偿回款查询</button>
								<button class="obtn" onclick="ableDisable()">停用/启用</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="table_id" class="display i-b2">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>添加时间</th>
										<th>编号</th>
										<th>担保机构名称</th>
										<th>营业执照号</th>
										<th>组织机构代码</th>
										<th>税务登记号</th>
										<th>注册资本</th>
										<th>注册地址</th>
										<th>法人姓名</th>
										<th>法人身份证号</th>
										<th>法人手机号</th>
										<th>联系人姓名</th>
										<th>联系人手机号</th>
										<th>第三方支付账号</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>添加时间</td>
										<td>编号</td>
										<td>担保机构名称</td>
										<td>营业执照号</td>
										<td>组织机构代码</td>
										<td>税务登记号</td>
										<td>注册资本</td>
										<td>注册地址</td>
										<td>法人姓名</td>
										<td>法人身份证号</td>
										<td>法人手机号</td>
										<td>联系人姓名</td>
										<td>联系人手机号</td>
										<td>第三方支付账号</td>
										<td>有效</td>
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
			
			<!-- 添加担保机构信息部分开始 -->
			<div class="w-content" id="manage-add">
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
							<td><label>担保证件类型</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
					</table>
				</form>
			</div>
			
			<!-- 添加担保机构信息部分结束 -->
			<!-- 修改担保机构信息部分开始 -->
			<div class="w-content" id="manageMod">
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
							<td><label>担保证件类型</label></td>
							<td><input type="text" class="" placeholder="" /></td>
						</tr>
					</table>
				</form>
			</div>
			<!-- 修改担保机构信息部分结束 -->
			<!-- 查看担保机构信息部分开始 -->
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
			<!-- 查看担保机构信息部分结束 -->
			<!-- 担保机构管理员管理部分开始 -->
			<div class="w-content" id="manageAdmain">
				<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="">修改</button>
									<button class="obtn" onclick="">停用/启用</button>
								</div>
							</div>
						</div>
				</div>
				<table id="admaintable">
					<thead>
						<tr>
							<th>管理员名称</th>
							<th>添加时间</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<%for(int j=0;j<5;j++){ %>
						<tr>
							<td>管理员名称</td>
							<td>管理员名称</td>
							<td>已启用</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<!-- 担保机构管理员管理部分结束 -->
			<!-- 担保项目查询部分开始 -->
			<div class="w-content" id="checkProject">
				<div class="panel-body">
					<form id="" class="" action="">
						<span class="con-item col-md-4">
							<span>项目编号</span><input type="text" class="" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>项目名称</span><input type="text" class="departmentname" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>担保机构名称</span><input type="text" class="licencenum" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>担保登记时间</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item col-md-4 col-sm-6 col-xs-12 col-md-4">
							<span>最近代偿时间</span><input type="text" class="contactphone" placeholder="" />
						</span>
						<span class="con-item col-md-2">
							<span>是否代偿</span>
							<select>
								<option>请选择</option>
								<option>是</option>
								<option>否</option>
							</select>
						</span>
						<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
					</form>
				</div>
				<table id="checkProjectTable">
						<thead>
							<tr>
								<th>项目编号</th>
								<th>项目名称</th>
								<th>借款金额</th>
								<th>项目保证金</th>
								<th>担保机构名称</th>
								<th>担保登记时间</th>
								<th>是否代偿</th>
								<th>代偿金额</th>
								<th>最近代偿时间</th>
							</tr>
						</thead>
						<tbody>
							<%for(int k=0;k<5;k++){ %>
							<tr>
								<td>项目编号</td>
								<td>项目名称</td>
								<td>借款金额</td>
								<td>项目保证金</td>
								<td>担保机构名称</td>
								<td>担保登记时间</td>
								<td>是否代偿</td>
								<td>代偿金额</td>
								<td>最近代偿时间</td>
							</tr>
							<%} %>
						</tbody>
				</table>
			</div>
			<!-- 担保项目查询部分结束 -->
			<!-- 代偿记录查询部分开始 -->
			<div class="w-content" id="checkRecord">
				<div class="panel-body">
					<form id="" class="" action="">
						<span class="con-item">
							<span>项目编号</span><input type="text" class="" placeholder="" />
						</span>
						<span class="con-item">
							<span>项目名称</span><input type="text" class="departmentname" placeholder="" />
						</span>
						<span class="con-item">
							<span>借款人姓名</span><input type="text" class="licencenum" placeholder="" />
						</span>
						<span class="con-item">
							<span>借款人用户名</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item">
							<span>借款人手机号</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item">
							<span>担保机构名称</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item">
							<span>当期合约还款时间</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item">
							<span>代偿时间</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item">
							<span>是否回款</span>
							<select>
								<option>请选择</option>
								<option>是</option>
								<option>否</option>
							</select>
						</span>
						<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
					</form>
				</div>
				<table id="checkrecordtable">
					<thead>
						<tr>
							<th>项目编号</th>
							<th>产品类型</th>
							<th>项目名称</th>
							<th>代偿期数</th>
							<th>借款人姓名</th>
							<th>借款人用户名</th>
							<th>借款人手机号</th>
							<th>担保机构名称</th>
							<th>实际借款金额</th>
							<th>当期合约还款时间</th>
							<th>代偿时间</th>
							<th>代偿本金</th>
							<th>代偿利息</th>
							<th>代偿逾期利息</th>
							<th>代偿逾期罚金</th>
							<th>代偿总金额</th>
							<th>是否回款</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>项目编号</td>
							<td>产品类型</td>
							<td>项目名称</td>
							<td>代偿期数</td>
							<td>借款人姓名</td>
							<td>借款人用户名</td>
							<td>借款人手机号</td>
							<td>担保机构名称</td>
							<td>实际借款金额</td>
							<td>当期合约还款时间</td>
							<td>代偿时间</td>
							<td>代偿本金</td>
							<td>代偿利息</td>
							<td>代偿逾期利息</td>
							<td>代偿逾期罚金</td>
							<td>代偿总金额</td>
							<td>是</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 代偿记录查询部分结束 -->
			<!-- 代偿回款查询部分开始 -->
			<div class="w-content" id="checkPayment">
				<div class="panel-body">
					<form id="" class="" action="">
						<span class="con-item col-md-4">
							<span>项目编号</span><input type="text" class="" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>项目名称</span><input type="text" class="departmentname" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>借款人用户名</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>借款人姓名</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>回款时间</span><input type="text" class="contactname" placeholder="" />
						</span>
						<span class="con-item col-md-4">
							<span>担保机构名称</span><input type="text" class="contactname" placeholder="" />
						</span>
						<button class="obtn obtn-query glyphicon glyphicon-search col-md-offset-11">查询</button>
					</form>
				</div>
				<table id="checkpaymenttable">
					<thead>
						<tr>
							<th>项目编号</th>
							<th>项目名称</th>
							<th>回款项目期数</th>
							<th>借款人用户名</th>
							<th>借款人姓名</th>
							<th>担保机构名称</th>
							<th>回款金额</th>
							<th>回款时间</th>
						</tr>
					</thead>
					<tbody>
						<%for(int m=0;m<5;m++){ %>
						<tr>
							<td>项目编号</td>
							<td>项目名称</td>
							<td>回款项目期数</td>
							<td>借款人用户名</td>
							<td>借款人姓名</td>
							<td>担保机构名称</td>
							<td>回款金额</td>
							<td>回款时间</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<!-- 代偿回款查询部分结束 -->
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
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript">
		$('#admaintable').DataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,2]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript">
		$('#checkProjectTable').DataTable({
			"aaSorting" : [ [ 3,5,8, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,4,6,7]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript">
		$('#checkrecordtable').DataTable({
			"aaSorting" : [ [ 8,9,10,11,12,13,14,15, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6,7,16]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript">
		$('#checkpaymenttable').DataTable({
			"aaSorting" : [ [ 6,7, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5]
			} // 制定列不参与排序
			],
		});
	</script>
</body>

</html>