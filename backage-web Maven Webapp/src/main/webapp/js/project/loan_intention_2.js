$(function() {
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
						d.personalPhone = "";
						d.repayWay = "";
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"会员编号","data": "memberNo"},  
				          { title:"会员用户名","data": "logname"},  
				          { title:"会员名称","data": "personalName", 
				        	  "mRender": function (data, type, full) {
				        		  if(data !=null && data !=''){
				        	    		return data;
				        	    	}else{
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"会员联系号码","data": "personalPhone", 
				        	  "mRender": function (data, type, full) {
				        		  if(data !=null && data !=''){
				        	    		return data;
				        	    	}else{
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"借款金额(元)","data": "amountStr"},  
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
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"借款用途","data": "uses"},  
				          { title:"还款来源","data": "repaySource"},  
				          { title:"借款描述","data": "projectDescript", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data==null){
				        		  		return "";
				        	  		}else if(data.length>8){//当内容长度大于8时隐藏详细信息
				        	    		return ' <a href="javascript:;" onclick="showText(this)" title="借款描述">'+data.substring(0,7)+'...</a>';
				        	    	}else {
				        	    		return data;
				        	    	} 
				        	  }
				          },  
				          { title:"期限类型","data": "deadlineType", 
				        	  "mRender": function (data, type, full) {
				        		  if(data==0){
				        			  return "天标";
				        		  }else if(data==1){
				        			  return full.deadline+"月标";
				        		  }else if(data==2){
				        			  return full.deadline+"年标";
				        		  }else{
				        			  return "";
				        		  }
				        	  }
				          },  
				          { title:"添加意向借款申请时间","data": "recordDate"}  
				          ],
	          aoColumnDefs : [
//	                          {"bVisible": false, "aTargets": [1]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          scrollCollapse: true,
	          scrollX : "100%",
			  scrollXInner : "100%",
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
	
	 
	//查询借款人列表初始化
		$('#table_borrow').DataTable(
				{	
					ajax: {  
						"url": appPath+"/project/getAllMembers",   
						"dataSrc": "results", 
						"type": "POST",
						"data": function ( d ) {
							//加密
							var memberName = encrypt.encrypt($("#memberName").val());
							var memberNo = encrypt.encrypt($("#memberNo").val());
							var personalPhone = encrypt.encrypt($("#personalPhone").val());
							d.memberNo = memberNo;
							d.memberName = memberName;
							d.personalPhone = personalPhone;
						}  
					},
					columns: [  
					          {title:'',sWidth:"3%", 
					        	  "mRender": function (data, type, full) {
					        		  sReturn = '<input type="checkbox" class="tr-checkbox1" value="1" />';
					        		  return sReturn;
					        	  }
					          },
					          { title:"会员用户名","data": "memberName"},  
					          { title:"会员姓名","data": "personalName"},  
					          { title:"会员编号","data": "memberNo"},  
					          { title:"手机号","data": "personalPhone"} 
					          ],
		          aoColumnDefs : [
		                          {
		                        	  "orderable" : false,
		                        	  "aTargets" : [ 0, 1, 2, 3]
		                          } // 制定列不参与排序
		                          ],
		          pagingType: "simple_numbers",//设置分页控件的模式  
		          processing: true, //打开数据加载时的等待效果  
		          serverSide: true,//打开后台分页  
		          rowCallback:function(row,data){//添加单击事件，改变行的样式      
		          }
		
		});//表格初始化完毕
		 
		//表格单选效果(有复选框)
		 $('#table_borrow tbody').on( 'click', 'tr', function () {
			    var $this = $(this);
			    var $checkBox = $this.find("input:checkbox");
		        if ( $this.hasClass('selected') ) {
		        	 $checkBox.prop("checked",false);
		        	$this.removeClass('selected');
		        } else {
		        	$(".tr-checkbox1").prop("checked",false);
		        	$checkBox.prop("checked",true);
		        	$('#table_borrow tr.selected').removeClass('selected');
		        	$this.addClass('selected');
		        }
		  });
		
		 /**
		  * 查询按钮
		  */
		 $("#memberQuery").on("click",function(){
			$('#table_borrow').DataTable().ajax.reload();
			
		 });
		 
		 
		 validform5(".layui-layer-btn0","dataForm",false,"3");
		//天标改变事件
		$("#deadlineType").on("change",function(){
			var type = $(this).val();
			if(type==0){
				$("#repayWay").val(2);
				$("#repayWay").attr("disabled",true);
			}else{
				$("#repayWay").attr("disabled",false);
			}
		});
		 
});

/* 借款人查询弹窗与弹窗中表格样式控制
 * 2016-5-4
 * 伍成然 */ 
function findBorrower(){
	layer.open({
	    type: 1,
	    area: ['60%', '90%'], //高宽
	    title: '选择借款人',
	    maxmin: true,
	    content: $('.borrower'),//DOM或内容
	    btn:['确定','取消']
		,yes: function(index, layero){ //或者使用btn1
			var data = $('#table_borrow').DataTable().rows('.selected').data();
			if(data.length<1){
					layer.alert("请选择会员！",{icon:0});
					return;
			}
			$("#memberID").val(data[0].memberId);
			$("#memberType").val(data[0].memberType);
			$("#memberName").val(data[0].memberName);
			layer.close(index);
	  },cancel: function(index){//或者使用btn2（concel）
		//取消的回调
		$this.parent().find(".postId").prop("postId","");
		$this.parent().find(".postId").prop("deptId","");
		$this.parent().find(".postId").val("");
	}
	});
};


/**
 * 添加意向借款按钮
 * @returns
 */
function addBorrow(){
	layer.open({
	    type: 1,
	    area: ['60%', '90%'], //高宽
	    title: '添加意向借款',
	    maxmin: true,
	    content: $('.borrowingCull'),//DOM或内容
	    btn:['确定', '取消'], 
			yes: function(index, layero){ //或者使用btn1
				$("#dataForm").submit();
	  },cancel: function(index){//或者使用btn2（concel）
		  
	  }
	});
}

function addData(){
	//加密参数
	var data={};
	var projectID = encrypt.encrypt($("#projectID").val());
	data.projectID=projectID;
	var memberID = encrypt.encrypt($("#memberID").val());
	data.memberID=memberID;
	var memberType = encrypt.encrypt($("#memberType").val());
	data.memberType=memberType;
	var amount = encrypt.encrypt($("#amount").val());
	data.amount=amount;
	var deadline = encrypt.encrypt($("#deadline").val());
	data.deadline=deadline;
	var deadlineType = encrypt.encrypt($("#deadlineType").val());
	data.deadlineType=deadlineType;
	var yearRate = encrypt.encrypt($("#yearRate").val());
	data.yearRate=yearRate;
	var repayWay = encrypt.encrypt($("#repayWay").val());
	data.repayWay=repayWay;
	var uses = encrypt.encrypt($("#uses").val());
	data.uses=uses;
	var repaySource = encrypt.encrypt($("#repaySource").val());
	data.repaySource=repaySource;
	var projectDescript = encrypt.encrypt($("#projectDescript").val());
	data.projectDescript=projectDescript;
	
	$.ajax( {  
		url:appPath+"/project/addLoanPurpose.do",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				$(".layui-layer-btn1").click();
				 var table = $('#table_id').DataTable();
				 table.ajax.reload();
			}else if(data==0){
				layer.alert("操作失败",{icon:2});  
			}else if(data==-1){
				layer.alert("该会员未开户",{icon:2});  
			}else if(data==-2){
				layer.alert("该会员未授权二次分配授权",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
	
}

/**
 * 简介弹出框显示
 */
function showText(btn){
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	layer.open({
	    type: 1,
	    area: ['400px', '300px'], //高宽
	    title: "借款描述",
	    content: data.projectDescript,//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});
};