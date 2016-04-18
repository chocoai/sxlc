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
	<title>保荐机构管理-资产管理方管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
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
				<!-- tab切换 -->
				<div class="nav-tabs-con active">
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
									<span class="con-item col-md-3 col-sm-4 col-xs-6">
										<span>编号</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item col-md-3 col-sm-4 col-xs-6">
										<span>资产管理方名称</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item col-md-3 col-sm-4 col-xs-6">
										<span>营业执照号</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item col-md-3 col-sm-4 col-xs-6">
										<span>联系人姓名</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item col-md-3 col-sm-4 col-xs-6">
										<span>联系人手机号</span><input type="text" class="" placeholder="" />
									</span>
									<span class="con-item col-md-3 col-sm-4 col-xs-6">
										<span>状态</span>
										<select>
											<option>请选择</option>
											<option>有效</option>
											<option>无效 </option>
										</select>
									</span>
									<span class="col-md-6 col-sm-12 col-xs-12">
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
									<button class="obtn glyphicon glyphicon-plus" onclick="assetAdd()">添加</button>
									<button class="obtn glyphicon glyphicon-pencil" onclick="assetMod()">修改</button>
									<button class="obtn" onclick="assetDetail()">查看详情</button>
									<button class="obtn" onclick="assetAdmainManager()">管理员管理</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="assettable" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>添加时间</th>
											<th>编号</th>
											<th>资产管理方名称</th>
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
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%for (int i = 0; i < 15; i++) {%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>添加时间</td>
											<td>编号</td>
											<td>资产管理方名称</td>
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
					<!-- 添加资产管理方信息部分开始 -->
					<div class="w-content" id="assetadd">
						<form action="">
							<table>
								<tr>
									<td><label>资产管理方名称</label></td>
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
									<td><label>资产管理方证件类型</label></td>
									<td><input type="text" class="" placeholder="" /></td>
								</tr>
							</table>
						</form>
					</div>
					<!-- 添加资产管理方信息部分部分结束 -->
					<!-- 修改资产管理方信息部分开始 -->
					<div class="w-content" id="assetmod">
						<form action="">
							<table>
								<tr>
									<td><label>资产管理方名称</label></td>
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
									<td><label>资产管理方证件类型</label></td>
									<td><input type="text" class="" placeholder="" /></td>
								</tr>
							</table>
						</form>
					</div>
					<!-- 修改资产管理方信息部分部分结束 -->
					<!-- 查看资产管理方信息详情部分开始 -->
					<div class="w-content" id="assetmod">
						<form action="">
							<table>
								<tr>
									<td><label>资产管理方名称</label></td>
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
									<td><label>上传的资产管理方证件</label></td>
									<td><input type="text" class="" placeholder="" /></td>
								</tr>
							</table>
						</form>
					</div>
					<!-- 查看资产管理方信息详情部分部分结束 -->
				</div>
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/asset-management.js"></script>
	<script type="text/javascript">
		$('#assettable').DataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,2,3,4,5,6,7,8,9,10,11,12,13,14]
			} // 制定列不参与排序
			],
		});
	</script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
</body>

</html>