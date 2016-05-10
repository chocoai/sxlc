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

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<%-- <jsp:include page="../common/cm-addr.jsp"></jsp:include> --%>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							</div>
						<div class="panel-body">
						<table id="table_id" class="display">
						</table>
					</div>
				</div>
			</div>
		</div>
		
			<!-- 尾部 -->
			
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getRepayPlanData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var applyId = encrypt.encrypt( parent.$("#applyID").val());
						d.applyId = applyId;
					}  
				},
				columns: [  
				          { title:"还款期数","data": "indexs"},  
				          { title:"合约还款日","data": "retrieveDateTime"},  
				          { title:"应还本金","data": "sLoanAmount"},  
				          { title:"应还利息","data": "sLoanInterest"},  
				          { title:"是否逾期","data": "isYuQi", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data==0){
				        		  		return "未逾期";
				        		  	}else if(data ==1){
				        		  		return "已逾期";
				        		  	}else{
				        		  		return "无数据";
				        		  	}
				        	  }
				          },  
				          { title:"应还逾期利息","data": "sOverdueInterest"},  
				          { title:"应还总额","data": "sdReplayTotals"},  
				          { title:"状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data==0){
				        		  		return "未还";
				        		  	}else if(data ==1){
				        		  		return "部分还款";
				        		  	}else if(data ==2){
				        		  		return "还清";
				        		  	}else{
				        		  		return "无数据";
				        		  	}
				        	  }
				          }
				         
				          ],
//  			  aaSorting : [[ 0, "desc"],[ 3, "desc"],[ 4, "desc"],[ 5, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0, 1, 2, 3, 4, 5, 6, 7, 8]
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
			</script>
		</div>
	</div>
</body>

</html>