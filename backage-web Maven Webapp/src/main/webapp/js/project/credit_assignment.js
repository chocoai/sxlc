$(function() {
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getDebtTransferData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var projectNo = $(".projectNo").val();
						var billNo = $(".billNo").val();
						var name = $(".name").val();
						var TransPrincipal = $(".TransPrincipal").val();
						
						d.projectNo = encrypt.encrypt(projectNo);
						d.billNo = encrypt.encrypt(billNo);
						d.name = encrypt.encrypt(name);
						d.TransPrincipal = encrypt.encrypt(TransPrincipal);
						
						//设置后台排序参数
						d.order = encrypt.encrypt("1");//1转让申请时间降序,-1转让申请时间升序-,2转让金额降序,-2转让金额升序,3转让价格降序,-3转让价格升序
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"债权转让申请时间","data": "applyTime"},  
				          { title:"债权转让项目编号","data": "projectNo"},  
				          { title:"项目名称","data": "projectTitle"},  
				          { title:"借款会员","data": "loanMemberName"},  
				          { title:"转让会员","data": "tranMemberName"},  
				          { title:"转让金额","data": "transPrincipals"},  
				          { title:"转让价格","data": "transferPrices"},
				          { title:"转让折扣(%","data": "transDiscounts"},
				          { title:"投标结束时间","data": "transMaxTime"},
				          { title:"转让状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data == -1){
				        		  		return "待流标处理";
				        		  	}else if(data == 0){
				        		  		return "投标中";
				        		  	}else if(data == 1){
				        		  		return "流标";
				        		  	}else if(data == 2){
				        		  		return "投标完成";
				        		  	}else if(data == 3){
				        		  		return "还款中";
				        		  	}else if(data == 4){
				        		  		return "结清";
				        		  	}else{
				        		  		return "无数据";
				        		  	}
				        	  }
				          }
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
	//	审核
	$('#credit_assignment_exam').click(function(){
		var rdata = $('#table_id').DataTable().rows('.selected').data();
		if(rdata.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
		}
		layer.open({
		    type: 1,
		    area: ['400px', '230px'], //高宽
		    title: "审核",
		    content: $(".assignment_exam"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				  var data={};
				  var ctaId = rdata[0].ctaId;//债权转让申请ID
				  var checkstatu = $("input[name='checkstatu']:checked").val();//-1:审核打回 1:审核通过
				  var transMaxTime = $("#transMaxTime").val();//最迟转让时间
				  var checkRemark = "";//审核意见
				  if(checkstatu==-1){
					  checkRemark="拒绝";
				  }else if(checkstatu==1){
					  checkRemark="同意";
				  }
				  data.checkstatu = encrypt.encrypt(checkstatu);
				  data.transMaxTime = encrypt.encrypt(transMaxTime);
				  data.checkRemark = encrypt.encrypt(checkRemark);
				  data.ctaId = encrypt.encrypt(ctaId);

				  $.ajax( {  
					  url:appPath+"/project/creditorTransAppCheck",
					  data: data,  
					  type:'post',  
					  cache:false,  
					  dataType:'json',  
					  success:function(data) { 
						  if(data==1){
							  layer.alert("操作成功!",{icon:1});  
						  }else if(data == -1){
							  layer.alert("该债权已审核!",{icon:2});  
						  }
					  },  
					  error : function() {  
						  layer.alert("服务器异常!",{icon:2});  
					  }  
				  });
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
//	投标结束时间延长
	$('#credit_assignment_late').click(function(){
		var rdata = $('#table_id').DataTable().rows('.selected').data();
		if(rdata.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
		}
		layer.open({
		    type: 1,
		    area: ['400px', '230px'], //高宽
		    title: "投标结束时间延长",
		    content: $(".assignment_late"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				  var data={};
				  var ctaId = rdata[0].ctaId;//债权转让申请ID
				  var transMaxTime = $("#transMaxTime").val();//最迟转让时间
				  data.transMaxTime = encrypt.encrypt(transMaxTime);
				  data.ctaId =  encrypt.encrypt(ctaId);

				  $.ajax( {  
					  url:appPath+"/project/updateTransMaxTime",
					  data: data,  
					  type:'post',  
					  cache:false,  
					  dataType:'json',  
					  success:function(data) { 
						  if(data > 0){
							  layer.alert("操作成功!",{icon:1});  
						  }else if(data == 0){
							  layer.alert("未找到要延迟的项目!",{icon:2});  
						  }
					  },  
					  error : function() {  
						  layer.alert("服务器异常!",{icon:2});  
					  }  
				  });
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
		
	});
	
});
