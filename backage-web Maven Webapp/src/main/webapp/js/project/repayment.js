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
						var Deadline = encrypt.encrypt($(".Deadline").val());
						var Deadline_Type = encrypt.encrypt($(".Deadline_Type").val());
						var Invest_Amount_Valid_Min = encrypt.encrypt($(".Invest_Amount_Valid_Min").val());
						var Invest_Amount_Valid_MAX = encrypt.encrypt($(".Invest_Amount_Valid_MAX").val());
						var Repay_Time_Min = encrypt.encrypt($(".Repay_Time_Min").val());
						var Repay_Time_Max = encrypt.encrypt($(".Repay_Time_Max").val());
						
						d.Project_No = Project_No;
						d.Amount_Min = Amount_Min;
						d.Amount_Max = Amount_Max;
						d.Personal_Name = Personal_Name;
						d.Record_Date_Min = Record_Date_Min;
						d.Record_Date_Max = Record_Date_Max;
						d.Logname = Logname;
						d.Deadline = Deadline;
						d.Deadline_Type = Deadline_Type;
						d.Invest_Amount_Valid_Min = Invest_Amount_Valid_Min;
						d.Invest_Amount_Valid_MAX = Invest_Amount_Valid_MAX;
						d.Repay_Time_Min = Repay_Time_Min;
						d.Repay_Time_Max = Repay_Time_Max;
						
						//设置后台排序参数
						d.ordercolumn = encrypt.encrypt("RECORD_DATE");//排序字段 AMOUNT  INVEST_RATE  RECORD_DATE  REPAY_TIME
						d.orderDsec = encrypt.encrypt(0+"");//1:ASC 0:DESC
						//设置查询页面类型
						d.pgType = encrypt.encrypt("7");
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
				          { title:"借款人用户名","data": "logname"},  
				          { title:"借款人姓名","data": "memberName"},  
				          { title:"项目名称","data": "projectBaseInfoentity.projectTitle"},  
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
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"借款金额","data": "projectBaseInfoentity.amount"},  
				          { title:"实际借款金额","data": "endamount"},  
				          { title:"年化利率(%)","data": "projectBaseInfoentity.yearRate"},  
				          { title:"项目发布日期","data": "releaseDate"},  
				          { title:"投标开始结束日期","data": "checkDate", 
				        	  "mRender": function (data, type, full) {
				        		  	return full.startDate+"~"+full.endDate; 
				        	  }
				          },
				          { title:"借款进度(%)","data": "investRates"},  
				          { title:"放款时间","data": "holdDate"},  
				          { title:"最近一期还款时间","data": "repayTime"},  
				          { title:"是否有逾期","data": "overdue", 
				        	  "mRender": function (data, type, full) {
				        		  if(data == 0){
				        			return "否";  
				        		  }else if(data == 1){
				        			return "是";  
				        		  }else{
				        			  return "";
				        		  }
				        	  }
				          }  
				          ],
 			  aaSorting : [[ 7, "desc"],[ 12, "desc"],[ 14, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 13, 15]
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


$(function(){
	//还款计划
	$('#repayment_plan').click(function(){
		 var data = $('#table_id').DataTable().rows('.selected').data();
		 if(data.length<1){
				layer.alert("请选择项目！",{icon:0});
				return;
		 }
		 $("#applyID").val(data[0].applyId);
		layer.open({
            type: 2,
            title: '还款计划',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: appPath+'/project/toRepaymentPlanPg'
        });
	});
//	查看投资记录
	$('#repayment_invest_record').click(function(){
		 var data = $('#table_id').DataTable().rows('.selected').data();
		 if(data.length<1){
				layer.alert("请选择项目！",{icon:0});
				return;
		 }
		 $("#applyID").val(data[0].applyId);
    	layer.open({
            type: 2,
            title: '投资记录',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: appPath+'/project/toInvestRecordPg'
        });
	});
});