$(function() {
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getRepaySettledData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var Project_No = $(".Project_No").val();
						var Project_Title = $(".Project_Title").val();
						var Personal_Name = $(".Personal_Name").val();
						var Merbill_No = $(".Merbill_No").val();
						
						d.Project_No = encrypt.encrypt(Project_No);
						d.Project_Title = encrypt.encrypt(Project_Title);
						d.Personal_Name = encrypt.encrypt(Personal_Name);
						d.Merbill_No = encrypt.encrypt(Merbill_No);
						
						//设置后台排序参数
						d.ordercolumn = encrypt.encrypt("REPAY_MAXTIME");//排序字段 Repay_Time REPAY_MAXTIME  
						d.orderDsec = encrypt.encrypt("0");//1:ASC 0:DESC
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"借款项目编号","data": "projectNo"},  
				          { title:"借款项目名称","data": "projectTitle"},  
				          { title:"借款人","data": "memberName"},  
				          { title:"账单编号","data": "merbillNo"},  
				          { title:"账单金额","data": "amounts"},  
				          { title:"账单期数","data": "indexs"},  
				          { title:"还款时间","data": "repayMaxTime"},
				          { title:"实际还款时间","data": "repayTime"}
				          ],
 			  aaSorting :[[ 5, "desc"],[ 7, "desc"],[ 8, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 6]
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
//借款项目详情
	$('.obtn-loan-prodetail').click(function(){
		var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
				layer.alert("请选择项目！",{icon:0});
				return;
		}
		var applyId = data[0].applyId;//Project_App_Record 表Apply_Id
		window.location.href=appPath+"/project/toProjectdetailPg?content="+applyId;
	});
//	账单详情
	$('.obtn-bill-detail').click(function(){
		var rdata = $('#table_id').DataTable().rows('.selected').data();
		 if(rdata.length<1){
				layer.alert("请选择项目！",{icon:0});
				return;
		 }
		var repayID =  encrypt.encrypt(rdata[0].repayID+"");
		$.ajax( {  
			  url:appPath+"/project/getBillDetailData",
			  data: {"repayID":repayID},  
			  type:'post',  
			  cache:false,  
			  dataType:'json',  
			  success:function(data) { 
				  $("#projectNo").val(data.projectNo);
				  $("#merbillNo").val(data.merbillNo);
				  $("#projectTitle").val(data.projectTitle);
				  $("#memberName").val(data.memberName);
				  $("#amounts").val(data.amounts);
				  $("#indexs").val(data.indexs);
				  $("#repayTime").val(data.repayTime);
				  $("#overDay").val(data.overDay);
				  $("#overdueAmounts").val(data.overdueAmounts);
				  
				  layer.open({
			            type: 1,
			            title: '账单详情',
			            maxmin: true,
			            shadeClose: true, //点击遮罩关闭层
			            area : ['500px' , '300px'],
			            content: $(".bill_detail")
			        });
				  
		      },  
		      error : function() {  
		           layer.alert("服务器异常!",{icon:2});  
		      }  
		 });
	});
});