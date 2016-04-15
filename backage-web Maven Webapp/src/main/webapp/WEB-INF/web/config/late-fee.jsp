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
<!-- 配置中心-------------------财务设置  逾期配置-->
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
						<li role="presentation" class=""><a href="<%=basePath%>config/toOverdueLimit.do">逾期严重程度配置</a>
				 		</li>
						<li role="presentation" class="active"><a href="<%=basePath%>config/toOverdueList.do">逾期费用设置</a>
						</li>
					</ul>
					<!-- 推荐达人提奖规则设置 -->
					<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-invest-fee-modify">增加</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table-id" class="display">
								</table>
							</div>
							
							<!-- 修改   -->
							<div class="w-content invest-fee-modify">
							  <form action="javascript:addOrUpdate()" id="dataForm" method="post">
								<table>
									<tr>
										<td class="tt"><label class="ineed">逾期起算天数：</label></td>
										<td class="con">
											<input type="text" name = "overdueMin" dayatype="" id="overdueMin" placeholder="" value="1" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label>逾期截止天数：</label></td>
										<td class="con">
											<input type="text" name = "overdueMax"  dayatype="" id="overdueMax" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label>逾期罚息日利息(%)：</label></td>
										<td class="con">
											<input type="text" name = "price"  dayatype="" id="price" placeholder="" />
										</td>
									</tr>
								</table>
								</form>
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
		$(function(){
			validform5("#submitBtn","dataForm",false,3);//合法性检验
			//表格初始化
			$('#table-id').DataTable({
				ajax: {  
					"url": appPath+"/config/getAllOverdue.do",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {  
					}  
				},
				columns: [  
				          { title:"id","data": "id"},  
				          { title:"逾期起算天数","data": "overdueMin"},  
				          { title:"逾期截止天数","data": "overdueMax"},  
				          { title:"逾期罚息日利息(%)","data": "price"},  
				          { title:"操作","data": "", 
				        	  "mRender": function (data, type, full) {
				        		return '<a href="javascript:void(0);" onclick="deleteData('+full.overdueMin+')" class="invest-fee-del">删除</a>';
				        	  }
				          }
				          ],
			  aoColumnDefs : [
			                  {"bVisible": false, "aTargets": [0]}, //控制列的隐藏显示
			                  {
			                	  "orderable" : false,
			                	  "aTargets" : [ 0,1,2,3,4]
			                  } // 制定列不参与排序
			                  ],
			  pagingType: "simple_numbers",//设置分页控件的模式  
			  processing: true, //打开数据加载时的等待效果  
			  serverSide: true,//打开后台分页  
//			  info:false,
			  rowCallback:function(row,data){//添加单击事件，改变行的样式      
			  }
			});
			
			//表格单选效果
			 $('#table-id tbody').on( 'click', 'tr', function () {
				    var $this = $(this);
			        if ( $this.hasClass('selected') ) {
			        	$this.removeClass('selected');
			        }
			        else {
			        	$('#table-id tr.selected').removeClass('selected');
			        	$this.addClass('selected');
			        }
			  });
			
		   });
		
		/**
		 * 删除
		 */
		function deleteData(param){
			layer.confirm('确定删除该条信息？', {
				  btn: ['确定', '取消']
				}, function(index, layero){
					$.ajax( {  
						url:appPath+"/config/deleteOverdue.do",
						data:{"overdueMin":param},
						type:'post',  
						cache:false,  
						dataType:'json',  
						success:function(data) { 
							if(data>0){
								layer.alert("操作成功",{icon:1});
								var table = $('#table-id').DataTable();
								table.ajax.reload();
							}else if(data==0){
								layer.alert("操作失败",{icon:2});  
							}
						},  
						error : function() {  
							layer.alert("服务器异常",{icon:2});  
						}  
					});					
				  	layer.close(index);
				}, function(index){
				});
		}
		

		/**
		 * 增加按钮
		 */
		$(".obtn-invest-fee-modify").on("click touchstart",function(){
			layer.open({
			    type: 1,
			    area: ['500px', '300px'], //高宽
			    title: "添加",
			    maxmin: true,
			    content: $(".invest-fee-modify"),//DOM或内容
			    btn:['确定', '取消']
				  ,yes: function(index, layero){ //或者使用btn1
					  $("#dataForm").submit();
				  },cancel: function(index){//或者使用btn2（concel）
				  }
			});
		});
		function addOrUpdate(){
			$.ajax( {  
				url:appPath+"/config/addOverdue.do",
				data:$("#dataForm").serialize(),
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					if(data>0){
						layer.alert("操作成功",{icon:1});
						$(".layui-layer-btn1").click();
						var table = $('#table-id').DataTable();
						table.ajax.reload();
					}else if(data==0){
						layer.alert("操作失败",{icon:2});  
					}
				},  
				error : function() {  
					layer.alert("服务器异常",{icon:2});  
				}  
			});
		}
		
	</script>
</body>

</html>