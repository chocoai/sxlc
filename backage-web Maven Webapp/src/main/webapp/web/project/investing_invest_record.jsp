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
	<link rel="stylesheet" href="css/project/investing.css" type="text/css">
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
								<form id="" class="" actio n="">
									<input id="applyID" type="text" value="${applyID}">
									<span class="con-item"><span>投资完成时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput Hold_Date_Min" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput Hold_Date_Max" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>会员用户名</span><input type="text" class="notspecial Logname" /></span>
									<span class="con-item"><span>会员姓名</span><input type="text" class="notspecial Personal_Name" /></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
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
					"url": appPath+"/project/getInvestmentRecordData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var applyID = encrypt.encrypt( parent.$("#applyID").val());
						var Personal_Name = encrypt.encrypt($(".Personal_Name").val());
						var Logname = encrypt.encrypt($(".Logname").val());
						var Hold_Date_Min = encrypt.encrypt($(".Hold_Date_Min").val());
						var Hold_Date_Max = encrypt.encrypt($(".Hold_Date_Max").val());
						
						d.applyID = applyID;
						d.Personal_Name = Personal_Name;
						d.Logname = Logname;
						d.Hold_Date_Min = Hold_Date_Min;
						d.Hold_Date_Max = Hold_Date_Max;
						
						//设置后台排序参数
						d.orderDsec = encrypt.encrypt(0+"");//1:ASC 0:DESC
					}  
				},
				columns: [  
				          { title:"投资完成时间","data": "holdDate"},  
				          { title:"会员用户名","data": "logname"},  
				          { title:"会员姓名","data": "membername"},  
				          { title:"投资金额","data": "investAmount"},  
				          { title:"使用红包抵扣金额","data": "investGiftAmount"},  
				          { title:"使用代金券抵扣金额","data": "investVouchersAmount"},  
				          { title:"是否使用返现券","data": "isBack", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data==0){
				        		  		return "否";
				        		  	}else if(data ==1){
				        		  		return "是";
				        		  	}else{
				        		  		return "";
				        		  	}
				        	  }
				          }
				         
				          ],
 			  aaSorting : [[ 0, "desc"],[ 3, "desc"],[ 4, "desc"],[ 5, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 1, 2, 6]
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