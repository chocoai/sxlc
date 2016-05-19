/**
 * 版块：配置中心-----项目审批流程配置----审批点配置
 * 内容介绍：
 */
$(function(){
	//单选
	validform5(".layui-layer-btn0","dataForm",true,3);
	validform5(".layui-layer-btn0","dataForms",true,3);
	$('#table_id tbody').on( 'click', 'tr', function () {
		var $this = $(this);
		var $checkBox = $this.find("input:checkbox");
		 if ( $(this).hasClass('selected') ) {
			 $checkBox.prop("checked",false);
				$(this).removeClass('selected');
			}
			else {
				$('tr.selected').removeClass('selected');
				$this.siblings().find("input:checkbox").prop("checked",false);
				$checkBox.prop("checked",true);
				$(this).addClass('selected');
			}
		
	} );
	showActivity();
	/*添加审批点*/
	$(".obtn-proexam-point-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['460px', '260px'], //高宽
		    title: "添加审批点",
		    content: $(".proexam-point-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				$("#dataForm").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	/*修改审批点*/
	$(".obtn-proexam-point-mod").on("click touchstart",function(){
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要处理的事务！",{icon:0});
			return;
		}
		 var sReturn ="";
   	     if(rowdata[0].roleType==0){
   	    	 sReturn = "平台审批";
   	     }else if(rowdata[0].roleType==1){
   	    	 sReturn = "担保机构审批";
   	     }else{
   	    	 sReturn = "资产管理方审批";
   	     }
   	    $("#activityId").val(rowdata[0].id);
		$("#apName").val(rowdata[0].apName);
		$("#apType").append("<option value="+rowdata[0].roleType+">"+sReturn+"</option>");
		layer.open({
		    type: 1,
		    area: ['460px', '260px'], //高宽
		    title: "修改审批点",
		    content: $(".proexam-point-mod"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	$("#dataForms").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
	//启用停用
	$(".btn-enable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定启用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
	
	$(".btn-disable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定停用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
	/* 下拉框内字体颜色 */
	$(".msginterfaceselect").css("color","#aaa");
	$(".msginterfaceselect").change(function(){
		if($(this).val()!="请选择"){
			$(this).css("color","#000");
		}else{
			$(this).css("color","#aaa");
		}
	});
});



/**
 * 添加审判活动点
 */
function addActivity(){ 
	var  apName  = $("#aName").val();   //活动点名称
	var  roleType = $("#aType").val();//类型
	if(roleType<0){
		layer.alert("请选择审批类型！",{icon:0});
		return;
	}
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var apName = encrypt.encrypt(apName);
	var roleType = encrypt.encrypt(roleType+"");
	
	$.ajax({
		url : appPath+"/activity/saveActivity.do",
			data:{
				apName:apName,
				roleType:roleType,
			},
			type : "post",
			dataType:"text",
		error : function() {
			alert('操作失败！');
			return;
		},
		success : function(data) {
			if(data >0){
				layer.alert("添加成功。",{icon:1}); 
				$(".layui-layer-btn1").click();
				var table = $('#table_id').DataTable();
				table.ajax.reload();
			}else{
				layer.alert("添加失败。",{icon:2});  
			}
		}
	});
}

/**
 * 修改审判活动点
 */
function updateActivity(){ 
	var  id = $("#activityId").val();
	var  apName  = $("#apName").val();   //活动点名称
	var  roleType = $("#apType").val();//类型
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var id = encrypt.encrypt(id+"");
	var apName = encrypt.encrypt(apName);
	var roleType = encrypt.encrypt(roleType+"");
	
	$.ajax({
		url : appPath+"/activity/updateActivity.do",
			data:{
				id:id,
				apName:apName,
				roleType:roleType,
			},
			type : "post",
			dataType:"text",
		error : function() {
			alert('操作失败！');
			return;
		},
		success : function(data) {
			if(data >0){
				layer.alert("修改成功。",{icon:1}); 
				$(".layui-layer-btn1").click();
				var table = $('#table_id').DataTable();
				table.ajax.reload();
			}else{
				layer.alert("修改失败。",{icon:2});  
			}
		}
	});
}

/**
 * 
 * @param id   协议id
 * @param statu 协议状态
 */
function stopOrStart(btn){
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	var ms ="";
	var statu = 0;
	if(data.statu==0){
		ms="确定启用？";
		statu=1;
	}else{
		ms="确定停用？";
		statu = 0;
	}
	var stutus =statu;
	var id=data.id;
	//result 为加密后参数
	var statu = encrypt.encrypt(statu+"");
	var id = encrypt.encrypt(id+"");
	layer.confirm(ms, {
		  btn: ['确定', '取消']
	}, function(index, layero){
		  //按钮【按钮一】的回调
		$.ajax({
			url : appPath+"/activity/ofActivity.do",
				data:{
					statu:statu,
					id:id
				},
				type : "post",
				dataType:"text",
			error : function() {
				alert('操作失败！');
				return;
			},
			success : function(data) {
				if(data >0){
					//执行完关闭
					if(stutus==0){
						layer.alert("停用成功。",{icon:1});  
					}else{
						layer.alert("启用成功。",{icon:1});
					}
				  	layer.close(index);
				  	var table = $('#table_id').DataTable();
					table.ajax.reload();
				}else {
					if(stutus==0){
						layer.alert("无法停用!",{icon:2});
					}else{
						layer.alert("启用失败!",{icon:2});
					}
				}
			}
			});
			//执行完关闭
		  	layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
}
/**
 * 显示列表
 */
function showActivity(){
	$('#table_id').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				serverSide:true,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
				searching : true,
	/*			processing:true,
				displayStart:0,*/
				info : true,// 左下角信息
//				ordering: false,//排序
				lengthMenu:[10,25,50,100],
//				aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath+"/activity/getactivityList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) { 
		            	d.content = -1;//所有的 包括有效和无效
		            	d.autu= "";//活动点名称
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"活动点名称","data": "apName"},  
				          { title:"审批类型","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.roleType==0){
		                		  sReturn = "<font >平台审批</font>";
		                	  }else if(full.roleType==1){
		                		  sReturn = "<font >担保机构审批</font>";
		                	  }else{
		                		  sReturn = "<font >资产管理方审批</font>";
		                	  }
		                  		return sReturn;
		                  	}
		                  }, 
		                  { title:"状态","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.statu==1){
		                		  sReturn = "<font >有效</font>";
		                	  }else{
		                		  sReturn = "<font color='red'>无效</font>";
		                	  }
		                  		return sReturn;
		                  	}
		                  }, 
		                  { title:"操作","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(on_off==true){
		                		  if(full.statu==1){
			                		  return '<a href="javascript:void(0);" class="btn-det" onclick="stopOrStart(this)">停用</a>';
		                		  }else{
			                		  return '<a href="javascript:void(0);" class="btn-det" onclick="stopOrStart(this)">启用</a>';
		                		  }
		                	  }else{
		                		  sReturn = "<a href='javascript:void(0);' class='btn-disable'></a>";
		                	  }
		                	  return sReturn;
		                  	}
		                }, 
		                  
		        ],
		        aoColumnDefs : [
		        				{"bVisible": false, "aTargets": []}, //控制列的隐藏显示
		        				{
		        					orderable : false,
		        					/*aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ]*/
		        				} // 制定列不参与排序
		        				],
		        rowCallback:function(row,data){//添加单击事件，改变行的样式      
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});
}








