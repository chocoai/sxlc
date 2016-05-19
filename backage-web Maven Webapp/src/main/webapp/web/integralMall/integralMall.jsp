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
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
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
				<input type="hidden" value="" id="imgHost">
				<table class="tree-table">
					<tr>
						<td class="ztree v-top w4">
							<div class="zTree-box">
								<ul id="dleft_tab1" class="ztree"></ul>
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
											</ul>
										</div>
									</div>
									<div class="panel-body">
										<form>
											<span class="con-item">
												<span>商品类型名称</span>
												<input type="text" id="mngName" class="notspecial" />
											</span>
											<span class="con-item">
											<span>状态</span>
												<select id="getStatu">
													<option value="-1">全部</option>
													<option value="1">有效</option>
													<option value="0">无效</option>
												</select>
											</span>
											<input type="button" class="obtn obtn-query glyphicon glyphicon-search" value="查询">
										</form>
									</div>
								</div>
							</div>
			
							<div class="data_display">
								<div class="panel panel-success">
									<div class="panel-heading">
										<div class="action_item">
											<button id="addProPage" class="obtn glyphicon glyphicon-plus obtn-export">添加</button>
											<button id="updateProPage" class="obtn glyphicon glyphicon-wrench obtn-export">修改</button>
										</div>
									</div>
									<div class="panel-body">
										<table id="table_id" class="display">
										</table>
									</div>
			
									<div class="w-content dept-add">
										<form id="saveDept" action="javascript:addDept()" method="post" >
											<table>
												<tr>
													<td class="tt"><label class="ineed">商品名称：</label></td>
													<td class="con">
														<input type="text" id="sdeptName" name="deptName"/>
													</td>
												</tr>
												<tr>
													<td class="tt"><label>上级：</label></td>
													<td class="con">
														<input type="text" id="sprincipalName" name="principalName"  class="" placeholder="" />
													</td>
												</tr>
												
											</table>
										</form>
									</div>
									
									<div class="w-content dept-mod">
										<form id="updateDept" action="javascript:updateDept()" method="post" >
											<table>
												<tr>
													<td class="tt"><label class="ineed">商品名称：</label></td>
													<td class="con">
														<input id="dId" type="hidden" name="deptId" class="" placeholder="" />
														<input id="dName" type="text" name="deptName"  class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>上级：</label></td>
													<td class="con">
														<input id="dpName" type="text" name="principalName"  class="" placeholder="" />
													</td>
												</tr>
												
											</table>
										</form>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>										
			
			
				<div class="w-content ishow pic-add" style="display:none">
					<input type="hidden" id="updateUid" value="">
					<table id="card_id" class="add-content">
						<tr>
							<td class="tt">上级</td>
							<td class="con"><span id="addtypeName">实物</span></td>
						</tr>
						<tr>
							<td class="tt">商品类型名称</td>
							<td class="con" ><input id="proName" type="text" /></td>
						</tr>
						<tr>
							<td class="tt">图片选择</td>
							<td class="con">
							<!--dom结构部分-->
								<div id="uploader">
							    <!--用来存放item-->
							    	<div id="filePicker">选择图片</div>
							    	<span class="rec-dimensions">建议尺寸：580*280</span>
							    	<input type="hidden" name="portraitUrl" id="portraitUrl" />
								</div>
							</td>
						</tr>
						<tr>
							<td class="tt" valign="top">图片预览</td>
							<td class="con" id="fileList"></td>
						</tr>
						<tr>
							<td class="tt">商品类型描述</td>
							<td class="con" id="">
								<textarea  type="text" id="productDescribe" style="width:347px;height:50px;" ></textarea>
							</td>
						</tr>
					</table>
				</div>
									
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/integralMall/integralMall.js"></script>
	<script type="text/javascript" src="plugs/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/exp-upload.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		var goodType = "0";
		function zTreeOnClick(event, treeId, treeNode) {
	   		 if (treeNode.id == "1"){
	   		 	goodType = "0";
	   		 	$('#table_id').DataTable().ajax.reload();
	   		 }else if(treeNode.id == "2"){
	   		 	goodType = "1";
	   		 	$('#table_id').DataTable().ajax.reload();
	   		 }
		};
		var setting = {
			view: {
				showIcon: showIconForTree
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback:{
				onClick:zTreeOnClick
			}
		};

		var zNodes =[
			{ id:1, pId:0, name:"实物", open:true , },
			{ id:2, pId:0, name:"电子礼券", }
			
		];

		function showIconForTree(treeId, treeNode) {
			return !treeNode.isParent;
		};
		$(document).ready(function(){
			$.fn.zTree.init($("#dleft_tab1"), setting, zNodes);
			var treeObj = $.fn.zTree.getZTreeObj("dleft_tab1");
			var nodes = treeObj.getNodes();
			if (nodes.length>0) {
				treeObj.selectNode(nodes[0]);
			}
		});
		
		
	</script>
</body>
</html>