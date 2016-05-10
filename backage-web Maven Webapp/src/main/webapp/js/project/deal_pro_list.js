$(function() {	
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getProjectLoanData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var Project_No = encrypt.encrypt($(".Project_No").val());
						var Personal_Name = encrypt.encrypt($(".Personal_Name").val());
						var Logname = encrypt.encrypt($(".Logname").val());
						var Deadline = encrypt.encrypt($(".Deadline").val());
						var Deadline_Type = encrypt.encrypt($(".Deadline_Type").val());
						var Real_Amount_Min = encrypt.encrypt($(".Real_Amount_Min").val());
						var Real_Amount_Max = encrypt.encrypt($(".Real_Amount_Max").val());
						var Repay_Way = encrypt.encrypt($(".Repay_Way").val());
						//合同约定下一个还款日  条件还未加
						
						d.Project_No = Project_No;
						d.Personal_Name = Personal_Name;
						d.Logname = Logname;
						d.Deadline = Deadline;
						d.Deadline_Type = Deadline_Type;
						d.Real_Amount_Min = Real_Amount_Min;
						d.Real_Amount_Max = Real_Amount_Max;
						d.Repay_Way = Repay_Way;
						
						
						//设置后台排序参数
						d.ordercolumn = encrypt.encrypt("RELEASE_DATE");//排序字段 HOLD_DATE REPAY_MAXTIME RELEASE_DATE REAL_END_DATE SETTLE_DATE
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
				          { title:"项目名称","data": "projectBaseInfoentity.projectTitle"},  
				          { title:"借款人用户名","data": "logname"},  
				          { title:"借款人姓名","data": "memberName"},  
				          { title:"电话号码","data": "personalPhone"},  
				          { title:"产品类型","data": "projectName"},  
				          { title:"借款期限","data": "projectBaseInfoentity", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data.deadlineTypes == 0){
				        	    		return data.deadline+"天";
				        	    	}else if(data.deadlineTypes == 1){
				        	    		return data.deadline+"月";
				        	    	}else if(data.deadlineTypes == 2){
				        	    		return data.deadline+"年";
				        	    	}else{
				        	    		return "无数据";
				        	    	}  
				        	  }
				          },  
				          { title:"申请借款金额","data": "projectBaseInfoentity.amounts"},  
				          { title:"实际借款金额","data": "projectBaseInfoentity.realAmounts"},  
				          { title:"年化利率(%)","data": "projectBaseInfoentity.yearRates"},  
				          { title:"还款方式","data": "projectBaseInfoentity.repayWay", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data == 0){
				        	    		return "等额本息";
				        	    	}else if(data == 1){
				        	    		return '每月还息，到期还本';
				        	    	}else if(data == 2){
				        	    		return "到期还息本";
				        	    	}else if(data == 3){
				        	    		return "等额本金";
				        	    	}else{
				        	    		return "无数据";
				        	    	}  
				        	  }
				          },  
				          { title:"合同约定下一个还款日","data": "repayMaxTime"},  
				          { title:"还款状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data == 0){
				        	    		return "未还款";
				        	    	}else if(data == 1){
				        	    		return '还款中';
				        	    	}else if(data == 2){
				        	    		return "已还清";
				        	    	}else{
				        	    		return "无数据";
				        	    	}  
				        	  }
				          },  
				          { title:"未还本金","data": "principalAmounts"},  
				          { title:"未还利息","data": "interestAmounts"},  
				          { title:"是否逾期","data": "overdue", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data == 0){
				        	    		return "否";
				        	    	}else if(data == 1){
				        	    		return '是';
				        	    	}else{
				        	    		return "无数据";
				        	    	}  
				        	  }
				          },  
				          { title:"首次申请时间","data": "recordDate"},  
				          { title:"项目审批完成时间","data": "releaseDate"},  
				          { title:"发布时间","data": "releaseDate"},  
				          { title:"融资结束时间","data": "realEndDate"},  
				          { title:"放款时间","data": "holdDate"},  
				          { title:"项目结清时间","data": "settleDate"}
				          ],
 			  aaSorting : [[ 12, "desc"],[ 18, "desc"],[ 19, "desc"],[ 20, "desc"],[ 21, "desc"],[ 22, "desc"],[ 22, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17 ]
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




$(document).ready(function() {
    /*** *************项目详情״̬********* ***/
    $('#deal_list_pro_detail').on('click', function(){
    	$(".right_col").load('web/project/pro-add/loan_pro_detail.jsp');
//    	$(".right_col").load("project/toBorrowDetail",{"id":encrypt.encrypt(id+""),"applyid":encrypt.encrypt(applyid+"")});//id为Purpose_ID
    });
    
    
    /******************还款详情**********************/
    $('#deal_list_pay_detail').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '还款详情',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/deal_list_pay_detail.jsp'
    	});
    });
    
    /** *************贷后监管************** **/
    $('#deal_list_suppervision').on('click', function(){
    	$(".right_col").load('web/project/deal_list_supervice_list.jsp');
    });
});