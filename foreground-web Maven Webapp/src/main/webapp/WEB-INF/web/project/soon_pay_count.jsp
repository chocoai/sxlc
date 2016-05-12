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
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial Project_No" /></span>
									<span class="con-item"><span>项目名称</span><input type="text" class="notspecial Project_Title"/></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial Logname" /></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="notspecial Personal_Name"/></span>
									<span class="con-item"><span>前距离还款日天数</span><input type="text" class="notspecial Wdate day" onFocus="WdatePicker()"/></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
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
								<table id="table_id" class="display">
								</table>
							</div>
						</div>
						<!-- 发送消息-->
						<div class="w-content sendmsg">
							<table>
								<tr>
									<td class="tt"><label>发送消息：</label></td>
									<td class="con">
										<select id="urgedType">
											<option value="">请选择</option>
											<option value="0">站内信</option>
											<option value="1">短信</option>
											<option value="2">邮箱</option>
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
	$(function() {	
		//表格初始化
		$('#table_id').DataTable(
				{	
					ajax: {  
						"url": appPath+"/project/getSoonPayData",   
						"dataSrc": "results", 
						"type": "POST",
						"data": function ( d ) {
							//加密
							var Project_No = $(".Project_No").val();
							var Project_Title = $(".Project_Title").val();
							var Logname = $(".Logname").val();
							var Personal_Name = $(".Personal_Name").val();
							var day = $(".day").val();
							//合同约定下一个还款日  条件还未加
							
							d.Project_No = encrypt.encrypt(Project_No);
							d.Project_Title = encrypt.encrypt(Project_Title);
							d.Personal_Name = encrypt.encrypt(Personal_Name);
							d.Logname = encrypt.encrypt(Logname);
							d.day = encrypt.encrypt(day);
							
							//设置后台排序参数
							d.ordercolumn = encrypt.encrypt("REPAY_MAXTIME");//排序字段 REPAY_MAXTIME AMOUNT SDREPAY_PRINCIPAL SDREPAY_INTEREST Repay_MaxTime
							d.orderDsec = encrypt.encrypt(0+"");//1:ASC 0:DESC
						}  
					},
					columns: [  
					          {title:'',sWidth:"3%", 
					        	  "mRender": function (data, type, full) {
					        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
					        		  return sReturn;
					        	  }
					          },
					          { title:"项目编号","data": "projectNo"},  
					          { title:"项目名称","data": "projectTitle"},  
					          { title:"借款金额","data": "investAmountValids"},  
					          { title:"借款人用户名","data": "logname"},  
					          { title:"借款人姓名","data": "personalName"},  
					          { title:"担保机构","data": "guaranteeName"},  
					          { title:"应还日期","data": "repayMaxTime"},  
					          { title:"期次","data": "indexs"},  
					          { title:"当期应还总额","data": "amounts"},  
					          { title:"当期应还本金","data": "sdRepayPrincipals"},  
					          { title:"当期应还利息","data": "sdRepayInterests"}
					          ],
	 			  aaSorting :[[ 7, "desc"],[ 9, "desc"],[ 10, "desc"],[ 11, "desc"]],//默认第几个排序
		          aoColumnDefs : [
		                          {
		                        	  "orderable" : false,
		                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 8]
		                          } // 制定列不参与排序
		                          ],
		          pagingType: "simple_numbers",//设置分页控件的模式  
		          processing: true, //打开数据加载时的等待效果  
		          serverSide: true,//打开后台分页  
		          scrollCollapse: true,
		          scrollX : "100%",
				  scrollXInner : "100%",
		          rowCallback:function(row,data){//添加单击事件，改变行的样式      
		          },
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
		/* 自行编辑消息内容 */
		var mc = UE.getEditor('msgcontent');
		/* 发送消息 */
		$(".obtn-sendmsg").on('click',function(){
			 var rdata = $('#table_id').DataTable().rows('.selected').data();
// 			 if(rdata.length<1){
// 					layer.alert("请选择项目！",{icon:0});
// 					return;
// 			 }
			layer.open({
			    type: 1,
			    area: ['800px', '580px'], //高宽
			    title: "发送消息",
			    content: $(".sendmsg"),//DOM或内容
			    btn:['确定', '取消']
				  ,yes: function(index, layero){ //或者使用btn1
				    //确定的回调
				    var data={};
				    var urgedType = $("#urgedType").val();
				    var urgedDetail = mc.getContent();
				    data.urgedType = encrypt.encrypt(urgedType); 
				    data.urgedDetail = encrypt.encrypt(urgedDetail); 
// 				    data.applyID = rdata[0].applyID;
// 				    data.repayId = rdata[0].repayId;
				    $.ajax( {  
						url:appPath+"/project/sendMessage",
						data:data,
						type:'post',  
						cache:false,  
						dataType:'json',  
						success:function(data) { 
							if(data==1){
								layer.alert("操作成功",{icon:1});
								$(".layui-layer-btn1").click();
							}else if(data==0){
								layer.alert("操作失败",{icon:2});  
							}
						},  
						error : function() {  
							layer.alert("服务器异常",{icon:2});  
						}  
					});
				  	
				  },cancel: function(index){//或者使用btn2（concel）
				  	//取消的回调
				  }
			});
		});
	</script>
</body>

</html>