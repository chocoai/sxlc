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
	<title>配置中心-财务设置-逾期配置</title>
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
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="601" name="_index_m2"/>
				<jsp:param value="60105" name="_index_m3"/>
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
						<li role="presentation" class="active"><a href="<%=basePath%>config/tolateFeePg.do">逾期费用设置</a>
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
											<input type="text" readonly="readonly" name = "overdueMin" dataType="days" id="overdueMin" placeholder=""  />
										</td>
									</tr>
									<tr>
										<td class="tt"><label>逾期截止天数：</label></td>
										<td class="con">
											<input type="text" name = "overdueMax"  dataType="days" id="overdueMax" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label>逾期罚息日利息(%)：</label></td>
										<td class="con">
											<input type="text" name = "price"  dataType="hundredNum" id="price" placeholder="" />
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
	</div>	
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js//config/config.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
			validform5(".layui-layer-btn0","dataForm",false,5);//合法性检验
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
							{title:'',sWidth:"3%", 
								  "mRender": function (data, type, full) {
									  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
									  return sReturn;
								  }
							},
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
			                  {
			                	  "orderable" : false,
			                	  "aTargets" : [ 0,1,2,3,4]
			                  } // 制定列不参与排序
			                  ],
			  pagingType: "simple_numbers",//设置分页控件的模式  
			  processing: true, //打开数据加载时的等待效果  
			  serverSide: true,//打开后台分页  
			  searching: false,
	          scrollCollapse: true,
	          scrollX : "100%",
	          scrollXInner : "100%",scrollY:500,
			  rowCallback:function(row,data){//添加单击事件，改变行的样式      
			  }
			});
			
			//表格单选效果(有复选框)
			 $('#table-id tbody').on( 'click', 'tr', function () {
				    var $this = $(this);
				    var $checkBox = $this.find("input:checkbox");
			        if ( $this.hasClass('selected') ) {
			        	 $checkBox.prop("checked",false);
			        	$this.removeClass('selected');
			        } else {
			        	$(".tr-checkbox").prop("checked",false);
			        	$checkBox.prop("checked",true);
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
						data:{"overdueMin":encrypt.encrypt(param+"")},
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
			document.getElementById("dataForm").reset();
			$.ajax({
				type : 'post',
				url : appPath + "/config/findMax.do",
				success : function (msg) {
					if (msg > 0) {
						$("#overdueMin").val(msg);
					}else {
						$("#overdueMin").val(1);
					}
				}
			});
			layer.open({
			    type: 1,
			    area: ['500px', '300px'], //高宽
			    title: "增加",
			    maxmin: true,
			    content: $(".invest-fee-modify"),//DOM或内容
			    btn:['确定', '取消']
				  ,yes: function(index, layero){ //或者使用btn1
					  $(".layui-layer-btn1").attr("disabled","disabled");
					  $("#dataForm").submit();
				  },cancel: function(index){//或者使用btn2（concel）
				  }
			});
		});
		function addOrUpdate(){
			//加密参数
			var data = {};
			var overdueMin = encrypt.encrypt($("#overdueMin").val());
			var overdueMax = encrypt.encrypt($("#overdueMax").val());
			var price = encrypt.encrypt($("#price").val());
			data.overdueMin=overdueMin;
			data.overdueMax=overdueMax;
			data.price=price;
			$.ajax( {  
				url:appPath+"/config/addOverdue.do",
				data:data,
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