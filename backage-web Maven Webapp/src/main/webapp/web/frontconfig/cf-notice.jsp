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
	<title>前台界面配置-网站公告</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<!-- <div class="search">
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
									<span>添加时间</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item">
									<span>图片标题</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item">
									<span>状态</span><input type="text" class="" placeholder="" />
								</span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div> -->
					
				<div class="w-content pic-add">
					<form id="saveNotice" action="javascript:addNotice()" method="post" >
					<table>
						<tr>
							<td class="tt">标题</td>
							<td class="con"><input id="title" datatype="entername" type="text" class="" /></td>
						</tr>
						<tr>
							<td class="tt">内容</td>
							<td class="con">
								<script id="editor"  type="text/plain" style="height:300px;width:98%;"></script>
							</td>
						</tr>
					</table>
					</form>
				</div>
				<div class="w-content pic-mod">
					<form id="modNotice" action="javascript:updateNotice()" method="post" >
					<table>
						<tr>
							<td class="tt">标题</td>
							<td class="con"><input id="mtitle" datatype="entername" type="text" class="" /></td>
						</tr>
						<tr>
							<td class="tt">内容</td>
							<td class="con">
								<script id="meditor"  type="text/plain" style="height:300px;width:98%;"></script>
							</td>
						</tr>
					</table>
					</form>
				</div>
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-notice-add">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-notice-mod">修改</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="table_id" class="display">
								
							</table>
						</div>
						
					</div>
				</div>
				
				
				<div class="w-content note-add">
					
				</div>
				
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/announce/announce.js"></script>
	<!-- 私用js -->
	
	
	<script type="text/javascript">
		
		/* $(function(){
			$('#table_id').DataTable({
				"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,2,3,4,5,6]
				} // 制定列不参与排序
				],
			});
		}); */
	</script>
	<script type="text/javascript">
		
	</script>
</body>

</html>