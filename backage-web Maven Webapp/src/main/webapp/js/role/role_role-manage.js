/*角色管理*/
/**pengran
 * 版块：角色管理
 * 内容介绍：角色管理
 */
$(function(){
	validform5(".layui-layer-btn0","dataForm",false,3);
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
				t.prev("div").find("[name='moduleCls']").prop("checked",false);//prev("div").
			}
		}
	});
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
	
	$(".obtn-role-add").on("click touchstart",function(){
		 $("#roleName1").val(""); //角色名称
		 $("#rolediscribe1").val("");	//角色描述
		 $("#addOrUpdate").val(0);
		clearCheck();
		layer.open({
		    type: 1,
		    area: ['980px', '600px'], //高宽
		    title: "添加角色",
		    content: $(".role-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				  $("#dataForm").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
				  $("#dataForm").Validform().resetStatus();
			  }
		});
	});
	
	/**
	 * 修改角色前显示角色信息
	 */
	$(".obtn-role-mod").on("click touchstart",function(){
		//获得选取的对象
		clearCheck();
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var roleId =0;
		if(!isEmptyObject(rowdata[0])){ //判断是否选择
			roleId=rowdata[0].id;
		}else{
			layer.alert("请选择要处理的事务！",{icon:0});  
			return;
		}
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		$("#roleId").val(roleId);
		roleId = encrypt.encrypt(roleId+"");
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
				    $("#roleName1").val(roleInfo[0].roleName);
				    $("#rolediscribe1").val(roleInfo[0].roleRemark);
				    $("#addOrUpdate").val(1);
				    
				    //模块操作权限
				    var str = data.roleAuth;
				    
				    var moduleCls = $("input[name='moduleCls']");
					moduleCls.each(function(index){
						var moduVal = $(this).val();
						$.each(str, function(k, list) {
							if(moduVal == list.moduleId){
								$("#moduleCls"+moduVal+"").prop("checked",true);
							//	console.log("模块："+moduVal);
								return true;
							}
						});
							
					});
					
					var checkAutoCls = $("input[name='checkAutoCls']");
					checkAutoCls.each(function(index){
						var moduVal = $(this).val();
						$.each(str, function(k, list) {
							if(moduVal == list.optId){
								$("#checkAutoCls"+moduVal+"").prop("checked",true);
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
		    content: $(".role-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				  $("#dataForm").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
				  $("#dataForm").Validform().resetStatus();
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
			layer.alert("请选择要处理的事务！",{icon:0});  
			return;
		}
		//result 为加密后参数
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		roleId = encrypt.encrypt(roleId+"");
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
						layer.alert("删除成功！",{icon:1});
					  	layer.close(index);
						setTimeout('location.reload()',500);
					}else if(data == -1){
						layer.alert("删除失败！改角色已被管理员使用！",{icon:1});
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
 * 清空选择中的数据
 * @param moduleCls 	//模块
 * @param checkAutoCls  //操作
 */
function clearCheck(){
	  var moduleCls = $("input[name='moduleCls']");
		moduleCls.each(function(){
			if($(this).prop("checked")==true){
				$(this).prop("checked",false);
			}
		});
		var checkAutoCls = $("input[name='checkAutoCls']");
		checkAutoCls.each(function(index,list){
			if($(this).prop("checked")==true){
				$(this).prop("checked",false);
			}
		});
}

/**
 * 显示角色列表
 */
function showRoleList(){
	$('#table_id').DataTable(
			{	autoWidth : false,
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
		            "url": appPath+"/getRoleList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var roleNo = $("#roleNo").val();//角色编码
		            	var roleName =  $("#roleName").val();//角色
		            	var startTime =  $("#start").val();//角色
		            	var endTime =  $("#end").val();//角色
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	//result 为加密后参数
		            	roleNo = encrypt.encrypt(roleNo);
		            	roleName = encrypt.encrypt(roleName);
		            	startTime = encrypt.encrypt(startTime);
		            	endTime = encrypt.encrypt(endTime);
		            	
		            	
		            	//?roleNo="+roleNo+"&roleName="+roleName+"&startTime="+startTime+"&endTime="+endTime
		            	d.roleNo=roleNo;
		            	d.roleName=roleName;
		            	d.startTime=startTime;
		            	d.endTime=endTime;
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
		                  { title:"状态","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.roleStatu==0){
		                		  sReturn = "<font >有效</font>";
		                	  }else{
		                		  sReturn = "<font color='red'>无效</font>";
		                		 
		                	  }
		                  		return sReturn;
		                  	}
		                  }, 
		                  { title:"操作","mRender": function(data, type, full){
		                	  var sReturn ="";
		                	  if(on_off==true){
		                		  if(full.roleStatu==0){
			                		  sReturn = "<a href=\"javascript:stopOrStart("+full.id+",1);\" class='btn-enable'>停用</a>";
			                	  }else{
			                		  sReturn = "<a href=\"javascript:stopOrStart("+full.id+",0);\" class='btn-disable'>启用</a>";
			                	  }
		                	  }else{
		                		  sReturn = "<a href=\"javascript:void(0);\" class='btn-disable'></a>";
		                	  }
		                	  
		                  		return sReturn;
		                  	}
		                }, 
		        ],
		        aoColumnDefs : [
		        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		        				{
		        						"orderable" : false,
		        						"aTargets" : [0,1,2,3]
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
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});
/**
 * 显示角色权限信息
 * @param id 角色id
 */
function showMess(id){
	var html ="";
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var id = encrypt.encrypt(id+"");
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
	if(statu==1){
		ms="确定停用？";
	}else{
		ms="确定启用？";
	}
	var status = statu;
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var id = encrypt.encrypt(id+"");
	var statu = encrypt.encrypt(statu+"");
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
					if(status==1){
						layer.alert("停用成功。",{icon:1});  
					}else{
						layer.alert("启用成功。",{icon:1});
					}
				  	layer.close(index);
				  	setTimeout('location.reload()',500);
				}else if(data == -1){
					if(status==1){
						layer.alert("停用失败!",{icon:0});  
					}else{
						layer.alert("启用失败!",{icon:0});
					}
				}
			}
			});
			//执行完关闭
		}, function(index){
		  //按钮【按钮二】的回调
		});
}

/**
 * 添加或者修改角色
 */
function AddOrUpdateRole(){
	//确定的回调
	  var addOrUpdate = $("#addOrUpdate").val();
	  var roleName = $("#roleName1").val(); //角色名称
	  var rolediscribe =  $("#rolediscribe1").val();	//角色描述
	  var auth = "";
	  auth = checkboxStr("moduleCls","checkAutoCls");
		if(auth=="" ||auth==null){
			layer.alert("请选择角色权限。",{icon:2});  
			return;
		}
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		roleName = encrypt.encrypt(roleName);
		rolediscribe = encrypt.encrypt(rolediscribe);
		if(addOrUpdate==0){//添加
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
						layer.alert("添加成功。",{icon:1});  
						$(".layui-layer-btn1").click();
					  	setTimeout('location.reload()',500);
					}else if(data == -1){
						layer.alert("角色名称已存在！",{icon:0});  
					}
				}
 			});
		}else{//修改
			var roleId = $("#roleId").val();
			roleId = encrypt.encrypt(roleId+"");
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
					if(data == 1 ){
						//执行完关闭
						layer.alert("修改成功。",{icon:1});  
						$(".layui-layer-btn1").click();
					  	setTimeout('location.reload()',500);
					}else if(data == -1){
						layer.alert("角色名称已存在！",{icon:0});  
					}
				}
			});
		}
		
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
