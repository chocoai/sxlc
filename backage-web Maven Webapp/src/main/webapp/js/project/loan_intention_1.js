$(function(){
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getLoanPurposeData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var memberNo = encrypt.encrypt($("#memberNo").val());
						var logname = encrypt.encrypt($("#logname").val());
						d.memberNo = memberNo;
						d.logname = logname;
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"会员编号","data": "MemberNo"},  
				          { title:"会员用户名","data": "Logname", 
				        	  "mRender": function (data, type, full) {
				        		  return full.minAmounts+"~"+full.maxAmounts;
				        	  }
				          },  
				          { title:"会员名称","data": "PersonalName"},  
				          { title:"会员联系号码","data": "PersonalPhone"},  
				          { title:"借款金额","data": "amountStr"},  
				          { title:"借款期限","data": "deadline"},  
				          { title:"还款方式","data": "repayWay", 
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
				          { title:"借款用途","data": "uses"},  
				          { title:"还款来源","data": "repaySource"},  
				          { title:"借款描述","data": "projectDescript"},  
				          { title:"期限类型","data": "deadlineType", 
				        	  "mRender": function (data, type, full) {
				        		  if(data==0){
				        			  return "天标";
				        		  }else if(data==1){
				        			  return full.deadline+"月标";
				        		  }else if(data==2){
				        			  return full.deadline+"年标";
				        		  }else{
				        			  return "无数据";
				        		  }
				        	  }
				          },  
				          { title:"提交意向时间","data": "recordDate"},  
				          { title:"有无分配理财顾问","data": "financial", 
				        	  "mRender": function (data, type, full) {
				        		  if(data>0){
				        			  return "有";
				        		  }else{
				        			  return "无";
				        		  }
				        	  }
				          },  
				          { title:"提交借款申请时间","data": "sendrecordDate"}  
				          ],
			  aaSorting : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
	          aoColumnDefs : [
	                          {"bVisible": false, "aTargets": [1]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13 ]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
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
	 
	 
	//默认禁用搜索和排序
	/* $.extend( $.fn.dataTable.defaults, {
	    searching: true,
	    ordering:  false
	} ); */
	
	
	/*验证*/
	validform5("layui-layer-btn0","saveNotice",true,"3");
	//查看审批记录
	$('#loan_exam_record').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '查看审批记录',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        content: 'web/project/pro-add/loan_exam_record.jsp'
	    });
	});
	//拒绝借款
	$('#refuse_payment').on('click', function(){
		layer.confirm('确定拒绝借款？', {
			btn: ['确定','取消'] //按钮
			}, function(){
			  layer.msg('已拒绝', {icon: 1});
			});
	});
	//借款会员拉黑
	$("#loan_member_black").on("click",function(){
        layer.prompt({title: '填写拉黑原因', formType: 2}, function(text){
          layer.msg('拉黑原因：'+text);
        });	      
	});
});
/******补充资料*******/
function addInfo(){
	$(".right_col").load("web/project/pro-add/add_information.jsp");
}
/******查看借款项目详情*******/
function view_detail(){
	$(".right_col").load("web/project/pro-add/loan_pro_detail.jsp");
}
/******分配理财顾问*******/
function allocation(){
		var data = $('#table_id').DataTable().rows('.selected').data(); 
		if(data.length<1){
				layer.alert("请选择要分配理财顾问的会员！",{icon:0});
				return;
		}
		var Logname = data[0].Logname;
		$(".right_col").load("project/toProTypeDetail",{"Logname": encrypt.encrypt(Logname),"PersonalName":encrypt.encrypt(PersonalName)});
	
	$(".right_col").load("web/project/pro-add/loan_intention_allocation.jsp");
}


