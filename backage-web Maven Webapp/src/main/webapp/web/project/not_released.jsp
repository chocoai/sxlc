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
	<link rel="stylesheet" href="css/project/apply_faild.css" type="text/css"></link>
</head>
<!-- 借款管理---------未发布 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="305" name="_index_m2"/>
				<jsp:param value="30503" name="_index_m3"/>
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
									<span class="con-item conItem"><span>项目编号</span><input type="text" class="notspecial Project_No"/></span>
									<span class="con-item conItem1"><span>借款金额范围</span><input type="text" class="notspecial dateInput Amount_Min" />-&nbsp;&nbsp;<input type="text" class="notspecial dateInput Amount_Max"/></span>
									<span class="con-item conItem"><span>借款人姓名</span><input type="text" class="notspecial Personal_Name" /></span>
									<span class="con-item conItem1"><span>提交申请时间范围</span><input type="text" id="startDate" class="notspecial Wdate dateInput Record_Date_Min" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput Record_Date_Max" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item conItem"><span>借款人用户名</span><input type="text" class="notspecial Logname"/></span>
									<button type ="button" class="obtn obtn-query glyphicon glyphicon-search loanInquiry">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-export">导出</button>
								</div>
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
	$(function() {	
		//表格初始化
		$('#table_id').DataTable(
				{	
					ajax: {  
						"url": appPath+"/project/getLoanManageData",   
						"dataSrc": "results", 
						"type": "POST",
						"data": function ( d ) {
							//加密
							var Project_No = encrypt.encrypt($(".Project_No").val());
							var Amount_Min = encrypt.encrypt($(".Amount_Min").val());
							var Amount_Max = encrypt.encrypt($(".Amount_Max").val());
							var Personal_Name = encrypt.encrypt($(".Personal_Name").val());
							var Record_Date_Min = encrypt.encrypt($(".Record_Date_Min").val());
							var Record_Date_Max = encrypt.encrypt($(".Record_Date_Max").val());
							var Logname = encrypt.encrypt($(".Logname").val());
							
							d.Project_No = Project_No;
							d.Amount_Min = Amount_Min;
							d.Amount_Max = Amount_Max;
							d.Personal_Name = Personal_Name;
							d.Record_Date_Min = Record_Date_Min;
							d.Record_Date_Max = Record_Date_Max;
							d.Logname = Logname;
							//设置后台排序参数
							d.ordercolumn = encrypt.encrypt("RECORD_DATE");//排序字段 AMOUNT  RECORD_DATE  
							d.orderDsec = encrypt.encrypt(0+"");//1:ASC 0:DESC
							//设置查询页面类型
							d.pgType = encrypt.encrypt("3");
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
					          { title:"项目名称","data": "projectBaseInfoentity.projectTitle"},  
					          { title:"借款人用户名","data": "logname"},  
					          { title:"借款人姓名","data": "memberName"},  
					          { title:"产品类型","data": "projectName"},  
					          { title:"借款期限","data": "projectBaseInfoentity", 
					        	  "mRender": function (data, type, full) {
					        		  	if(data.deadlineType == 0){
					        	    		return data.deadline+"天";
					        	    	}else if(data.deadlineType == 1){
					        	    		return data.deadline+"月";
					        	    	}else if(data.deadlineType == 2){
					        	    		return data.deadline+"年";
					        	    	}else{
					        	    		return "无数据";
					        	    	}  
					        	  }
					          },  
					          { title:"借款金额(元)","data": "projectBaseInfoentity.amounts"},  
					          { title:"年化利率(%)","data": "projectBaseInfoentity.yearRates"},  
					          { title:"项目申请时间","data": "recordDate"},  
					          { title:"审核成功时间","data": "checkDate"}  
					          ],
	 			  aaSorting : [[ 7, "desc"]],//默认第几个排序
		          aoColumnDefs : [
		                          {
		                        	  "orderable" : false,
		                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 8, 9, 10]
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
			</script>
		</div>
	</div>
</body>

</html>