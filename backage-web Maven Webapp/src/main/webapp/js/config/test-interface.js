/**
 * 版块：配置中心-----托管平台配置
 * 内容介绍：
 */
$(function(){
	$(".testinterfaceselect").css("color","#aaa");
	$(".testinterfaceselect").change(function(){
		if($(this).val()!="请选择"){
			$(this).css("color","#000");
		}else{
			$(this).css("color","#aaa");
		}
	});
	validform5(".layui-layer-btn0","dataForm",true,3);
	validform5(".layui-layer-btn0","dataForms",true,3);
	//单选
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
	showInterfaceList();
	showInterface();
	/*添加接口配置*/
	$(".obtn-test-inter-add").on("click touchstart",function(){
		layer.open({
			type: 1,
			area: ['565px', '260px'], //高宽
			title: "添加接口配置",
			content: $(".test-inter-add"),//DOM或内容
			btn:['确定', '取消']
		,yes: function(index, layero){ //或者使用btn1
			//确定的回调
			$("#dataForm").submit();
			//addThird();
		},cancel: function(index){//或者使用btn2（concel）
			//取消的回调
		}
		});
	});
	/*修改接口配置*/
	$(".obtn-test-inter-modify").on("click touchstart",function(){
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要处理的事务！",{icon:0});
			return;
		}
		if(rowdata[0].statu ==0){
			layer.alert("平台无效，不能修改！",{icon:2});
			return;
		}
		$("#typeInterface").append("<option value="+rowdata[0].escrowID+" selected>"+rowdata[0].escrowName+"</option>");
		
		$("#typeSure").append("<option value="+rowdata[0].interfaceID+" selected>"+rowdata[0].interfaceName+"</option>");
		$("#requestUrl").val(rowdata[0].interfaceUrl);
		layer.open({
		    type: 1,
		    area: ['565px', '260px'], //高宽
		    title: "修改接口配置",
		    content: $(".test-inter-modify"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				 $("#dataForms").submit();
				 // updateThird();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
});
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
	var escrowID = data.escrowID;
	var interfaceID =data.interfaceID;
	var interfaceUrl = data.interfaceUrl;
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var statu = encrypt.encrypt(statu+"");
	var escrowID = encrypt.encrypt(escrowID+"");
	var interfaceID = encrypt.encrypt(interfaceID+"");
	var interfaceUrl = encrypt.encrypt(interfaceUrl);
	layer.confirm(ms, {
		  btn: ['确定', '取消']
	}, function(index, layero){
		  //按钮【按钮一】的回调
		$.ajax({
			url : appPath+"/channel/ofChanner.do",
				data:{
					escrowID:escrowID,
					interfaceID:interfaceID,
					interfaceUrl:interfaceUrl,
					statu:statu
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
				  	setTimeout('location.reload()',500);
				}else {
					if(stutus==1){
						layer.alert("停用失败。",{icon:2});
					}else{
						layer.alert("启用失败。",{icon:2});
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
 *显示接口类型列表
 */
function showInterfaceList(){
	var html = "<option value='-1'>请选择</option>";
	$.ajax({
		url : appPath+"/common/AccountEscrow.do",
			data:{
			},
			type : "post",
			dataType:"json",
		error : function() {
			alert('操作失败！');
			return;
		},
		success : function(data) {
			if(data.length>0){
				$.each(data,function(index,obj){
					html+= "<option value="+obj.interfaceID+">"+obj.interfaceName+"</option>";
				});
				$("#typeO").append(html);
				$("#interfaceID").append(html);
			}
		}
	});
	
}
/**
 * 添加第三方
 */
function addThird(){ 
	var  escrowID  = $("#escrowID").val();   //接口类型
	if(escrowID<0){
		layer.alert("请选择接口类型！",{icon:0});
		return;
	}
	var  interfaceID = $("#interfaceID").val();//操作类型
	if(interfaceID<0){
		layer.alert("请选择操作类型！",{icon:0});
		return;
	}
	var  interfaceUrl = $("#interfaceUrl").val();//路径
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var escrowID = encrypt.encrypt(escrowID);
	var interfaceID = encrypt.encrypt(interfaceID+"");
	var interfaceUrl = encrypt.encrypt(interfaceUrl+"");
	
	$.ajax({
		url : appPath+"/channel/saveChanner.do",
			data:{
				escrowID:escrowID,
				interfaceID:interfaceID,
				interfaceUrl:interfaceUrl,
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
				setTimeout('location.reload()',500);
			}else{
				layer.alert("添加失败。",{icon:2});  
			}
		}
	});
}


/**
 * 修改第三方
 */
function updateThird(){ 
	var  escrowID  = $("#typeInterface").val();   //接口类型
	var  interfaceID = $("#typeSure").val();//操作类型
	var  interfaceUrl = $("#requestUrl").val();//路径
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var escrowID = encrypt.encrypt(escrowID);
	var interfaceID = encrypt.encrypt(interfaceID+"");
	var interfaceUrl = encrypt.encrypt(interfaceUrl+"");
	
	$.ajax({
		url : appPath+"/channel/updateChanner.do",
			data:{
				escrowID:escrowID,
				interfaceID:interfaceID,
				interfaceUrl:interfaceUrl,
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
				setTimeout('location.reload()',500);
			}else{
				layer.alert("修改失败。",{icon:2});  
			}
		}
	});
}
/**
 * 显示列表
 */
function showInterface(){
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
		            "url": appPath+"/channel/getchannelList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) { 
		            	var typeO = $("#typeO").val();
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	typeO = encrypt.encrypt(typeO+"");
		            	d.interfaceType = typeO;
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"接口类型","data": "escrowName"},  
				          { title:"操作类型","data": "interfaceName"},  
				          { title:"请求路径","data": "interfaceUrl"},  
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








