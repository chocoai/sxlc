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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
</head>
<!-- 贷后管理--即将还款统计 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="306" name="_index_m2"/>
				<jsp:param value="30602" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>项目名称</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>前距离还款日天数</span><input type="text" class="notspecial Wdate" onFocus="WdatePicker()"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-sendmsg">发送消息</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_soon_pay_count" class="display">
									<thead>
										<tr>
											<th></th>
											<th>项目编号</th>
											<th>项目名称</th>
											<th>借款金额</th>
											<th>借款人用户名</th>
											<th>借款人姓名</th>
											<th>担保机构</th>
											<th>应还日期</th>
											<th>期次</th>
											<th>当期应还总额</th>
											<th>当期应还本金</th>
											<th>当期应还利息</th>
										</tr>
									</thead>
									<tbody>
										<%
											for(int i=0;i<15;i++){
										 %>
										<tr>
											<td><input type="checkbox"></td>
											<td>0000001</td>
											<td>交电费</td>
											<td>jiuyang</td>
											<td>王书记</td>
											<td>1234455415</td>
											<td>200000</td>
											<td>12-01</td>
											<td>方式</td>
											<td>用途</td>
											<td>来源</td>
											<td>描述</td>
										</tr>
										<%
											}
										 %>
									</tbody>
								</table>
							</div>
						</div>
						<!-- 发送消息-->
						<div class="w-content sendmsg">
							<table>
								<tr>
									<td class="tt"><label>发送消息：</label></td>
									<td class="con">
										<select>
											<option>请选择</option>
											<option>站内信</option>
											<option>短信</option>
											<option>邮箱</option>
										</select>
									</td>
								</tr>
								<tr>
									<td class="tt"><label>消息内容：</label></td>
									<td class="con">
										<script id="msgcontent" type="text/plain" style="height:260px;width:98%;"></script>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!-- 尾部 -->
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		//默认禁用搜索和排序
		/* $.extend( $.fn.dataTable.defaults, {
		    searching: true,
		    ordering:  false
		} ); */
		// 这样初始化，排序将会打开
		$(function() {
			$('#table_soon_pay_count').DataTable({
				"autoWidth" : true,
				//"scrollY": 500,
				//paging : false,//分页
				
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [[ 7, "desc"],[ 9, "desc"],[ 10, "desc"],[ 11, "desc"]],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 8]
				} // 制定列不参与排序
				],
				colReorder : false,
				"scrollX": true,
				"sScrollX" : "100%",
				"sScrollXInner" : "100%",
				"bScrollCollapse" : true
			});
		});
		/* 自行编辑消息内容 */
		var mc = UE.getEditor('msgcontent');
		/* 发送消息 */
		$(".obtn-sendmsg").on('click',function(){
			layer.open({
			    type: 1,
			    area: ['800px', '580px'], //高宽
			    title: "发送消息",
			    content: $(".sendmsg"),//DOM或内容
			    btn:['确定', '取消']
				  ,yes: function(index, layero){ //或者使用btn1
				    //确定的回调
				  	
				  },cancel: function(index){//或者使用btn2（concel）
				  	//取消的回调
				  }
			});
		});
	</script>
</body>

</html>