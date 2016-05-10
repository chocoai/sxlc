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
	<title>积分商城</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
	<link rel="stylesheet" href="plugs/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
	<script type="text/javascript" src="<%=path %>/js/zTree/jquery.ztree.core-3.2.js"></script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="7" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-integralMall.jsp">
				<jsp:param value="701" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- 主体部分 -->
				<table class="tree-table">
					<tr>
						<td class="ztree v-top w4">
							<div class="zTree-box">
								<ul id="dleft_tab1" class="ztree">
									<li>实物</li>
									<li>电子礼券</li>
								</ul>
							</div>
						</td>
						<td class="v-top">
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
											<span class="con-item"><span>商品类型名称</span><input type="text" class="notspecial" /></span>
											<span class="con-item"><span>状态</span><select><option>有效</option><option>无效</option></select></span>
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</form>
									</div>
								</div>
							</div>
			
							<div class="data_display">
								<div class="panel panel-success">
									<div class="panel-heading">
										<div class="action_item">
											<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="bankManagementAdd('添加商品','web/recommend/re-add/integralMall_add.jsp','1')">添加</button>
											<button id="" class="obtn glyphicon glyphicon-wrench obtn-export" onclick="bankManagementAdd('修改商品','web/recommend/re-add/integralMall_qu.jsp','1')">修改</button>
										</div>
									</div>
									<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>添加时间</th>
											<th>商品类型名称</th>
											<th>商品类型描述</th>
											<th>状态</th>
											<th>操作</th>
											<th>最近一次操作管理员</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2016.5.9 14：50</td>
											<td>菲利普斯同款泳衣</td>
											<td>流线型设计，穿上它，你就可以像菲尔普斯一样在水中穿梭，买不了吃亏买不了上当！</td>
											<td>已启用</td>
											<td><button id="" class="obtn  btn-qiyong">启用</button>
												<button id="" class="obtn  btn-ting">停用</button></td>
											<td>泰迪熊2</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
			
									<div class="w-content dept-add">
										<form id="saveDept" action="javascript:addDept()" method="post" >
											<table>
												<tr>
													<td class="tt"><label class="ineed">部门名称：</label></td>
													<td class="con">
														<input type="text" id="sdeptName" name="deptName" datatype="entername" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门负责人：</label></td>
													<td class="con">
														<input type="text" id="sprincipalName" name="principalName" datatype="enterperson" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>负责人电话：</label></td>
													<td class="con">
														<input type="text" id="sprincipalPhone" name="principalPhone" datatype="zPhone" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>上级部门ID：</label></td>
													<td class="con">
														<input type="text" id="spreDeptId" name="preDeptId" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门描述：</label></td>
													<td class="con">
														<input type="text" id="sdeptRemark" name="deptRemark" datatype="reMarks" class="" placeholder="" />
													</td>
												</tr>
											</table>
										</form>
									</div>
									
									<div class="w-content dept-mod">
										<form id="updateDept" action="javascript:updateDept()" method="post" >
											<table>
												<tr>
													<td class="tt"><label class="ineed">部门名称：</label></td>
													<td class="con">
														<input id="dId" type="hidden" name="deptId" class="" placeholder="" />
														<input id="dName" type="text" name="deptName" datatype="entername" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门负责人：</label></td>
													<td class="con">
														<input id="dpName" type="text" name="principalName" datatype="enterperson" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>负责人电话：</label></td>
													<td class="con">
														<input id="dpPhone" type="text" name="principalPhone" datatype="zPhone" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门描述：</label></td>
													<td class="con">
														<input id="dRemark" type="text" name="deptRemark" datatype="reMarks" class="" placeholder="" />
													</td>
												</tr>
											</table>
										</form>
									</div>							
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
				
				
		
			<!-- 尾部 -->
			
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/recommendedAge.js"></script>
	<script type="text/javascript" src="js/integralMall/integralMall.js"></script>
	<script type="text/javascript" src="js/role/role-dept.js"></script>
		<script type="text/javascript" src="js/myZtree.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(document).ready(function(){
			$(document).ajaxStart(onStart).ajaxSuccess(onStop);
			loadMenu("dleft_tab1");
		});
	

		function loadMenu(treeObj){
				var depId = 1;
				$.ajax({
					type:"POST",
					url : appPath + "/role/treeList.do",
					dataType : "json",
					success:function(data){
					alert(data[0].resourceName);
						// 如果返回数据不为空，加载"业务模块"目录
						if(data != null){
							// 将返回的数据赋给zTree
							$.fn.zTree.init($("#"+treeObj), setting, data);
							zTree = $.fn.zTree.getZTreeObj(treeObj);
							//点击事件
							
							var node = zTree.getNodeByParam('parentID',0);//获取id为1的点   设置默认点击第几级
				         	zTree.selectNode(node);//选择点  
				        	zTree.setting.callback.onClick(null,zTree.setting.treeId,node);//调用事件  
			                if( zTree ){
								// 默认展开所有节点
								zTree.expandAll(true);
							}
						}
					}
				});
			}
		
		//点击事件
		function TheSelectedNode(id){
		alert(id);
			 var node = zTree.getNodeByParam('parentID',id);//获取id为1的点   设置默认点击第几级
	         zTree.selectNode(node);//选择点  
	         zTree.setting.callback.onClick(null,zTree.setting.treeId,node);//调用事件  
		}	
		
		//刷新
		function updateTable(prevId,moduleId){
		}
		$(function() {
					$('#applicationAudit').DataTable({
						"autoWidth" : true,
						"scrollX": true,
						//"scrollY": true,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[1, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 2, 3, 4, 5,6 ]
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
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
		
</body>

</html>