/*角色管理*/
/**pengran
 * 版块：角色管理
 * 内容介绍：角色管理
 */
$(function(){
	showRoleList();//显示角色列表
	//模块全选 添加
	$("[name='moduleCls']").change(function() {
		if ($(this).prop("checked")) {
			var obj = $(this).parent().parent().parent().parent().parent().nextAll().find("[name='checkAutoCls']");
			for ( var i = 0; i < obj.length; i++) {
				if (!obj[i].checked) {
					obj[i].checked = true;
				} 
			}
		} else {
			$(this).parent().parent().parent().parent().parent().nextAll().find("[name='checkAutoCls']").attr("checked", false);
		}
		
	});
	//操作选择 添加
	$(" [name='checkAutoCls']").change(function() {
		if ($(this).prop("checked")) {//$(this).is(":checked") == true
			var t = $(this).parent().parent().parent().parent().parent();
			t.prev("div").find("[name='moduleCls']").prop("checked","checked");
		}else{
			var t = $(this).parent().parent().parent().parent().parent();
			var a = t.find("[name='checkAutoCls']:checked");
			if(a.length == 0){
				t.prev("div").find("[name='moduleCls']").attr("checked",false);//prev("div").
			}
		}
	});
	//模块全选  修改
	$("[name='moduleCls1']").change(function() {
		if ($(this).prop("checked")) {
			var obj = $(this).parent().parent().parent().parent().parent().nextAll().find("[name='checkAutoCls1']");
			for ( var i = 0; i < obj.length; i++) {
				if (!obj[i].checked) {
					obj[i].checked = true;
				} 
			}
		} else {
			$(this).parent().parent().parent().parent().parent().nextAll().find("[name='checkAutoCls1']").attr("checked", false);
		}
		
	});
	//操作选择  修改
	$(" [name='checkAutoCls1']").change(function() {
		if ($(this).prop("checked")) {//$(this).is(":checked") == true
			var t = $(this).parent().parent().parent().parent().parent();
			t.prev("div").find("[name='moduleCls1']").prop("checked","checked");
		}else{
			var t = $(this).parent().parent().parent().parent().parent();
			var a = t.find("[name='checkAutoCls1']:checked");
			if(a.length == 0){
				t.prev("div").find("[name='moduleCls1']").attr("checked",false);//prev("div").
			}
		}
	});

	$('#table_id tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	} );

	
	$(".obtn-role-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['980px', '600px'], //高宽
		    title: "添加角色",
		    content: $(".role-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				  var roleName = $("#roleName").val(); //角色名称
				  var rolediscribe =  $("#rolediscribe").val();	//角色描述
					var auth = "";
					auth = checkboxStr("moduleCls","checkAutoCls");
					$.ajax({
		 				url : appPath+"/saveRole.do",
		 				data:{
		 					roleName:roleName,
		 					rolediscribe:rolediscribe,
		 					auth:auth
		 				},
		 				type : "post",
		 				dataType:"text",
						error : function() {
							alert('操作失败！');
							return;
						},
						success : function(data) {
							//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
							if(data == 0){
								//执行完关闭
								alert("添加成功。");
							  	layer.close(index);
							  	setTimeout('location.reload()',2000);
							}else if(data == -1){
								alert('部门名称已存在！');
							}
						}
		 			});
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
	/**
	 * 修改角色前显示角色信息
	 */
	$(".obtn-role-mod").on("click touchstart",function(){
		//获得选取的对象
		
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var roleId =0;
		if(!isEmptyObject(rowdata[0])){ //判断是否选择
			roleId=rowdata[0].id;
		}else{
			alert("请选择要处理的事务！");
			return;
		}
		$.ajax({
				url : appPath+"/getRoleMess.do",
				data:{
					roleId:roleId
				},
				type : "post",
				dataType:"json",
			error : function() {
				alert('操作失败！');
				return;
			},
			success : function(data) {
				//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
				if(data!=null && data!=""){
					var roleInfo = data.roleInfo;
				    $("input[name=modify_roledis]").val(roleInfo[0].roleRemark);
				    $("input[name=modify_roleName]").val(roleInfo[0].roleName);
				    
				    //模块操作权限
				    var str = data.roleAuth;
				    
				    var moduleCls = $(".role-mod input[name='moduleCls1']");
					moduleCls.each(function(index){
						var moduVal = $(this).val();
						$.each(str, function(k, list) {
							if(moduVal == list.moduleId){
								$("#moduleCls"+moduVal+"").attr("checked",true);
							//	console.log("模块："+moduVal);
								return true;
							}
						});
							
					});
					
					var checkAutoCls = $(".role-mod input[name='checkAutoCls1']");
					checkAutoCls.each(function(index){
						var moduVal = $(this).val();
						$.each(str, function(k, list) {
							if(moduVal == list.optId){
								$("#checkAutoCls"+moduVal+"").attr("checked",true);
							//	console.log("操作："+moduVal);
								return true;
							}
						});
						
					});
				
				}
			}
			});
		
		//之后
		layer.open({
		    type: 1,
		    area: ['980px', '600px'], //高宽
		    title: "修改角色",
		    content: $(".role-mod"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				//确定的回调
				  var roleName = $("input[name=modify_roleName]").val(); //角色名称
				  var rolediscribe =  $("input[name=modify_roledis]").val();	//角色描述
					var auth = "";
					auth = checkboxStr("moduleCls1","checkAutoCls1");
					$.ajax({
						url : appPath+"/editRole.do",
		 				data:{
		 					roleId:roleId,
		 					roleName:roleName,
		 					rolediscribe:rolediscribe,
		 					auth:auth
		 				},
		 				type : "post",
		 				dataType:"text",
						error : function() {
							alert('操作失败！');
							return;
						},
						success : function(data) {
							//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
							if(data == 0){
								//执行完关闭
								alert("修改成功。");
							  	layer.close(index);
							  	setTimeout('location.reload()',2000);
							}else if(data == -1){
								alert('部门名称已存在！');
							}
						}
		 			});
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});

	
	$(".obtn-role-del").on("click touchstart",function(){
		//获得选取的对象
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var roleId =0;
		if(!isEmptyObject(rowdata[0])){ //判断是否选择
			roleId=rowdata[0].id;
		}else{
			alert("请选择要处理的事务！");
			return;
		}
		layer.confirm('确定删除该条信息？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/removeRole.do",
 				data:{
 					roleId:roleId
 				},
 				type : "post",
 				dataType:"text",
				error : function() {
					alert('操作失败！');
					return;
				},
				success : function(data) {
					//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
					if(data == 0){
						//执行完关闭
						alert("删除成功。");
					  	layer.close(index);
						setTimeout('location.reload()',2000);
					}else if(data == -1){
						alert('删除失败！改角色已被管理员使用！');
					}
				}
 			});
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
	
	
});

//function
//获取权限
function checkboxStr(moduName,checkName){
	var auth = "";
	var checkArray = document.getElementsByName(""+ moduName +"");
	var checkArray1 = document.getElementsByName(""+ checkName +"");
	var single;
	var singleStr;
	var len = checkArray.length;
	var numlen = checkArray1.length;
	for(var i=0;i<len;i++){
		single = checkArray[i];
		if(single.checked){
			var value = single.value;
			for(var j=0;j<numlen;j++){
				singleStr = checkArray1[j];
				if(singleStr.checked){
					var moduleStr = singleStr.value;
					var length = moduleStr.length;
					var moduValue = 0;
					if(length == 5){
						moduValue = moduleStr.substring(0,3);							
					}else if(length == 6){
						moduValue = moduleStr.substring(0,4);		
					}else if(length == 7){
						moduValue = moduleStr.substring(0,5);
					}
					if(moduValue == value){
						var strModu = value + "," + moduleStr;
						auth = auth + strModu + ";";
					}
				}
			}
		}
		if(single.checked && numlen.length == 0){
			var strModu = single.value+',0';
			auth = auth + strModu + ";";
		}
	}
	return auth;
}

/**
 * 显示角色列表
 */
function showRoleList(){
	$('#table_id').DataTable(
			{	autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
//				searching : false,
				info : false,// 左下角信息
//				ordering: false,//排序
				lengthMenu:[[5,10,25,50],[5,10,25,50]],
//				aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath+"/getRoleList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		                var level1 = $('#level1').val();  
		                //添加额外的参数传给服务器  
		                d.extra_search = level1;  
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"角色编码","data": "roleNo"},   
		                  { title:"角色名称","data": "roleName" },  
		                  { title:"生成日期","data": "sAddDate" },  
		                  { title:"描述","data": "roleRemark" },  
		                  { title:"角色权限","mRender":function(data, type, full){
		                  		sReturn = "<a href='javascript:showMess("+full.id+");' class='btn-enable'>查看</a>";
		                		  return sReturn;
		                	  }
		                  }, 
		                  { title:"操作","mRender": function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.roleStatu==0){
		                		  sReturn = "<a href='javascript:stopOrStart("+full.id+",1);' class='btn-enable'>启用</a>";
		                	  }else{
		                		  sReturn = "<a href='javascript:stopOrStart("+full.id+",0);' class='btn-disable'>停用</a>";
		                	  }
		                  	
		                		  return sReturn;
		                  	}
		                }, 
		        ],
		        aoColumnDefs : [
		        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		        				{
		        					orderable : false,
		        					/* aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ] */
		        				} // 制定列不参与排序
		        				],
		        rowCallback:function(row,data,index){//添加单击事件，改变行的样式      
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});
}
/**
 * 显示角色权限信息
 * @param id 角色id
 */
function showMess(id){
	var html ="";
	//debugger;
	$.ajax({
		url : appPath+"/getLimitById.do",
		data:{
			roleId:id
		},
		type : "post",
		dataType:"json",
	error : function() {
		alert('操作失败！');
		return;
	},
	success : function(data) {
		if(data!=null && data!=""){
			var moduleList = data.modulelist;
		    var operationList =data.operationList;
		    if(moduleList.length>0){
		    	for(var i=0,len=moduleList.length;i<len;i++){
		    		html +="<div class='role_limit' style='margin:8px'><span style='font-size:14px'>"+moduleList[i].moduleNamel+"</span>"+
		    		'<ul style="font-size: 14px;background-color: #f4f4f4">';
		    		for(var j=0;j<operationList.length;j++){
		    			if(moduleList[i].moduleId == operationList[j].moduleID ){
		    				html +='<li  style="list-style:none;font-size:12px ;padding-left:10px;float:left">'+operationList[j].optName+'</li>';
		    			}
		    			if( j%6==5){
		    				html +="</br>";
		    			}
		    		}
		    		html +="</ul></div>";
		    	}
		    }
		}
		layer.open({
		    type: 1,
		    area: ['560px', '480px'], //高宽
		    title: "角色权限",
		    content: html,//DOM或内容
		});
	}
});
}
/**
 * 
 * @param id   角色id
 * @param statu 角色状态
 */
function stopOrStart(id,statu){
	var ms ="";
	if(statu==0){
		ms="确定停用？";
	}else{
		ms="确定启用？";
	}
	layer.confirm(ms, {
		  btn: ['确定', '取消']
	}, function(index, layero){
		  //按钮【按钮一】的回调
		$.ajax({
			url : appPath+"/ofRole.do",
				data:{
					roleId:id,
					statu:statu
				},
				type : "post",
				dataType:"text",
			error : function() {
				alert('操作失败！');
				return;
			},
			success : function(data) {
				//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
				if(data == 0){
					//执行完关闭
					if(statu==0){
						alert("停用成功。");
					}else{
						alert("启用成功。");
					}
				  	layer.close(index);
				  	setTimeout('location.reload()',2000);
				}else if(data == -1){
					if(statu==0){
						alert("停用失败！");
					}else{
						alert("启用失败！");
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
 * 判断对象是否为空
 * @param obj
 * @returns {Boolean}
 */
function isEmptyObject(obj){ 
	for (var key in obj) { 
		return false; 
		}  
	return true;
} 
