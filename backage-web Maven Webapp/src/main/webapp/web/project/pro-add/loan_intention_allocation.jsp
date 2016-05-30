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
	<title>项目管理——借款申请管理</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" >
	<link rel="stylesheet" href="css/upload.css" >
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/loan_intention.css" type="text/css">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-project.jsp">
				<jsp:param value="302" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="selectMember">
							<input id="memberID" type="hidden" value="${memberId}">
							<span><samp>选择会员：</samp>${logname}</span>
							<span><samp>姓名：</samp>${personalName}</span>
						</div>
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="" class="" action="">
										<span class="con-item"><span>姓名</span><input id="realName" type="text" class="notspecial" /></span>
										<span class="con-item"><span>编号</span><input id="serviceNo" type="text" class="notspecial" /></span>
										<span class="con-item"><span>手机号</span><input id="servicePhone" type="text" class="notspecial" /></span>
										<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</form>
							  	</div>
						 	</div>
						 </div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
							
					</div>
				</div>
				<div class="buttonSet2">
					<button class="obtn obtn-query" onclick="distributeAdviser()">确定</button>
					<button class="obtn obtn-query" onclick="window.location.href='project/toLoanApplyList'">取消</button>
				</div>
			</div>
		</div>
	
		
		<!-- 公用js -->
		<jsp:include page="../../common/cm-js.jsp"></jsp:include>
		
		<!-- 私用js -->
		<script type="text/javascript">
			$(function(){
				
				//表格初始化
				$('#table_id').DataTable(
						{	
							ajax: {  
								"url": appPath+"/project/getAdviserData",   
								"dataSrc": "results", 
								"type": "POST",
								"data": function ( d ) {
									//加密
									var realName = encrypt.encrypt($("#realName").val());
									var serviceNo = encrypt.encrypt($("#serviceNo").val());
									var servicePhone = encrypt.encrypt($("#servicePhone").val());
									d.realName = realName;
									d.serviceNo = serviceNo;
									d.servicePhone = servicePhone;
								}  
							},
							columns: [  
							          {title:'',sWidth:"3%", 
							        	  "mRender": function (data, type, full) {
							        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
							        		  return sReturn;
							        	  }
							          },
							          { title:"姓名","data": "realName"},  
							          { title:"编号","data": "serviceNo"},  
							          { title:"手机号","data": "servicePhone"},  
							          { title:"会员登录名","data": "logName"},  
							          { title:"成为理财顾问时间","data": "sRecordDate"}
							          ],
				          aoColumnDefs : [
				                          {
				                        	  "orderable" : false,
				                        	  "aTargets" : [ 0, 1, 2, 3,4,5 ]
				                          } // 制定列不参与排序
				                          ],
				          pagingType: "simple_numbers",//设置分页控件的模式  
				          processing: true, //打开数据加载时的等待效果  
				          serverSide: true,//打开后台分页 
				          searching: false,
				//          info:false,
				          rowCallback:function(row,data){//添加单击事件，改变行的样式      
				          }
				});//表格初始化完毕
				 
				//表格单选效果(有复选框)
				 $('#table_id tbody').on( 'click', 'tr', function () {
					    var $this = $(this);
					    var $checkBox = $this.find("input:checkbox");
				        if ( $this.hasClass('selected') ) {
				        	 $checkBox.prop("checked",false);
				        	$this.removeClass('selected');
				        } else {
				        	$(".tr-checkbox").prop("checked",false);
				        	$checkBox.prop("checked",true);
				        	$('#table_id tr.selected').removeClass('selected');
				        	$this.addClass('selected');
				        }
				  });
				
				 /**
				  * 查询按钮
				  */
				 $(".glyphicon-search").on("click",function(){
					$('#table_id').DataTable().ajax.reload();
				 });
				
			});
			
			/**
			 * 确定按钮
			 */
			function distributeAdviser(){
				var rData = $("#table_id").DataTable().rows('.selected').data();
				if(rData.length<1){
					layer.alert("请选择要分配的理财顾问！",{icon:0});
					return;
				}
				var data={};
				var advisorId = encrypt.encrypt(rData[0].fAID+"");
				var memberID = encrypt.encrypt($("#memberID").val());
				data.advisorId=advisorId;
				data.memberID=memberID;
				
				NetUtil.ajax(
					appPath+"/project/distributeAdviser",
					data,
					function(data) { 
						if(data == 1){
							layer.alert("操作成功",{icon:1});
							window.location.href="project/toLoanApplyList";
						}else if(data== -1){
							layer.alert("已存在理财顾问!",{icon:2});  
						}else if(data == 0){
							layer.alert("操作失败!",{icon:2});  
						}
					} 
				);
						  
			}
			
			
		</script>
	</div>
</body>
</html>

