<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>选择担保机构</title>
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
<!-- 借款申请管理--------借款意向列表查询 -->
<body class="nav-md">

<div class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
			<!-- 地址导航 -->
			<div class="nav-tabs-con active">
				<div class="data_display">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>编号</span><input id="" type="text" class="notspecial guaranteeNo" /></span>
									<span class="con-item"><span>机构名称</span><input type="text" class="notspecial guaranteeName" /></span>
									<span class="con-item"><span>营业执照号</span><input type="text" class="notspecial companyeBLN" /></span>
									<span class="con-item"><span>联系人姓名</span><input type="text" class="notspecial contactName"  /></span>
									<span class="con-item"><span>手机号</span><input type="text" class="notspecial contactPhone" /></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
					 	</div>
					 </div>
					 <div class="panel-body">
						<table id="tableId" class="display">
						</table>
					</div>
				</div>
			</div>
			<div class="buttonSet2">
				<button class="obtn obtn-query" onclick="submitData();">确定</button>
				<button class="obtn obtn-query" onclick="cancel();">取消</button>
			</div>
		</div>
	</div>

	
	<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
			$(".panel-body").show();
			//表格初始化
			$('#tableId').DataTable(
					{	
						ajax: {  
							"url": appPath + "/guarant/list.do",   
							"dataSrc": "results", 
							"type": "POST",
							"data": function ( d ) {
								//加密
								var guaranteeNo = $(".guaranteeNo").val();
								var guaranteeName = $(".guaranteeName").val();
								var companyeBLN = $(".companyeBLN").val();
								var contactName = $(".contactName").val();
								var contactPhone = $(".contactPhone").val();
								
								d.guaranteeNo = encrypt.encrypt(guaranteeNo);
								d.guaranteeName = encrypt.encrypt(guaranteeName);
								d.companyeBLN = encrypt.encrypt(companyeBLN);
								d.contactName = encrypt.encrypt(contactName);
								d.contactPhone = encrypt.encrypt(contactPhone);
								
							}  
						},
						columns: [  
				                   {title:'',sWidth:"3%", 
						        	  "mRender": function (data, type, full) {
						        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
						        		  return sReturn;
						        	  }
						          },
				                  { title:"编号","data": "guaranteeNo" },
				                  { title:"机构名称","data": "guaranteeName" },
				                  { title:"营业执照号","data": "companyeBLN" },
				                  { title:"联系人姓名","data": "contactName" },  
				                  { title:"手机号","data": "contactPhone" }
				        ],
			          aoColumnDefs : [
			                          {
			                        	  "orderable" : false,
			                        	  "aTargets" : [0,1,2,3,4,5]
			                          } // 制定列不参与排序
			                          ],
			          pagingType: "simple_numbers",//设置分页控件的模式  
			          processing: true, //打开数据加载时的等待效果  
			          serverSide: true,//打开后台分页  
			//          info:false,
			          rowCallback:function(row,data){//添加单击事件，改变行的样式      
			          },
			});//表格初始化完毕
			 
			//表格单选效果(有复选框)
			 $('#tableId tbody').on( 'click', 'tr', function () {
				    var $this = $(this);
				    var $checkBox = $this.find("input:checkbox");
			        if ( $this.hasClass('selected') ) {
			        	 $checkBox.prop("checked",false);
			        	$this.removeClass('selected');
			        } else {
			        	$(".tr-checkbox").prop("checked",false);
			        	$checkBox.prop("checked",true);
			        	$('#tableId tr.selected').removeClass('selected');
			        	$this.addClass('selected');
			        }
			 });
			
			 /**
			  * 查询按钮
			  */
			 $(".glyphicon-search").on("click",function(){
				$('#tableId').DataTable().ajax.reload();
			 });
			
		});
		
		//确定按钮，点击将选中值保存到父页面中
		function submitData(){
			 var index = parent.layer.getFrameIndex(window.name);
			 var data = $('#tableId').DataTable().rows('.selected').data();
			 if(data.length<1){
					layer.alert("请选择担保机构！",{icon:0});
					return;
			 }
			 var guaranteeID = data[0].guaranteeID;
			 var guaranteeName = data[0].guaranteeName;
	         parent.$(".guaranteeID").val(guaranteeID);
	         parent.$(".guaranteeName").val(guaranteeName);
		     parent.layer.close(index);
		}
		
		//取消按钮，点击关闭父页面弹出层
		function cancel(){
			 var index = parent.layer.getFrameIndex(window.name);
		     parent.layer.close(index);
		}
	</script>
</div>
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/project/loan_intention_1.js"></script>
</body>
</html>