/**
 * 角色管理-管理员管理
 * 添加修改部分代码直接写在页面上的，加快渲染速度
 * 每次执行操作前请清空目标盒子的数值
 */


var STAFF_NUM = 0;  //记录点击添加次数



/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#tb-manage-in').DataTable().ajax.reload();
	
});

$(function() {
	adminList();	//管理员列表
	
	//单选
	$('#tb-manage-in,#staffListTb tbody').on( 'click', 'tr', function () {
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
	
	/*$('#tb-manage-in tr').slice(1).each(function(g){
		var p = this;
		$(this).children.silce(1).click(function(){
			$($(p).children()[0]).children().each(function(){
				if(this.type=="checkbox"){
					if(!this.checked){
						this.checked==true;
					}else{
						this.checked==false;
					}
				}
			});
		});
	});*/
});


/**
 * 管理员列表
 */
function adminList(){
	$('#tb-manage-in').DataTable(
			{	autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
//						searching : false,
				info : true,// 左下角信息
//						ordering: false,//排序
				lengthMenu:[10,25,50,100],
//						aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath+"/getAdminList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		            	var adminNo = $("#adminNo").val();//管理员编码
		            	var user1 =  $("#user1").val();//用户
		            	var startTime =  $("#start").val();//开始时间
		            	var endTime =  $("#end").val();//结束时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	adminNo = encrypt.encrypt(adminNo);
		            	user1 = encrypt.encrypt(user1);
		            	startTime = encrypt.encrypt(startTime);
		            	endTime = encrypt.encrypt(endTime);
		            	
		            	
		            	d.adminName=adminNo;
		            	d.userName1=user1;
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
		                  { title:"管理员基本信息","data": "personalBaseInfo"},   
		                  { title:"管理员名称","data": "adminName"},   
		                  { title:"用户名称","mRender": function(data, type, full){
		                	 var str="";
		                	 if(full.personalBaseInfo!=null){
		                		str= full.personalBaseInfo.personalName;
		                	 }
		                	 return str;
		                  }},  
		                  { title:"生成日期","data": "sAddDate" },  
		                  { title:"用户角色","data": "roleName" },  
		                  { title:"用户拥有权限","mRender":function(data, type, full){
		                  		sReturn = "<a href='javascript:showMess("+full.roleId+");' class='btn-enable'>查看</a>";
		                		  return sReturn;
		                	  }
		                  }, 
		                  { title:"状态","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.adminStatu==0){
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
		                		  if(full.adminStatu==0){
			                		  sReturn = "<a href='javascript:stopOrStart("+full.id+",1);' class='btn-enable'>停用</a>";
			                	  }else{
			                		  sReturn = "<a href='javascript:stopOrStart("+full.id+",0);' class='btn-disable'>启用</a>";
			                	  }
		                	  }else{
		                		  sReturn = "<a href='javascript:void(0);' class='btn-disable'></a>";
		                	  }
		                  	
		                		  return sReturn;
		                  	}
		                }, 
		        ],
		        aoColumnDefs : [
		        				 {"bVisible": false, "aTargets": [ 1 ]}, //控制列的隐藏显示
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
 * 管理员详情
 */
function manageDet(title){
	//获取参数
	var rowdata = $('#tb-manage-in').DataTable().rows('.selected').data();
	var adminName ="";
	var obj = null;
	if(!isEmptyObject(rowdata[0])){ //判断是否选择
		adminName=rowdata[0].adminName;
		obj = rowdata[0].personalBaseInfo;
	}else{
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	$('#manage-det input').each(function(){	
			$(this).val("");	
	});	
	if(obj!=null){	//给详情页面赋值
		$("#manage-det input[name=userName]").val(adminName);	//用户名
		$("#manage-det input[name=name]").val(obj.personalName);//姓名
		if(obj.sexId==0){										//性别
			$("#manage-det input[name=sex]").val("男");
		}else{
			$("#manage-det input[name=sex]").val("女");
		}
		var idcard = obj.idcard;
		var birth="";
		$("#manage-det input[name=idcard]").val(idcard);	//身份证
		if(idcard!=null&&idcard!=""){
			birth = getBirthday(idcard);
		}
		$("#manage-det input[name=birth]").val(birth);		//出生日期
		$("#manage-det input[name=poster]").val(obj.sNation);	//民族
		$("#manage-det input[name=poster]").val("");		//职务
		$("#manage-det input[name=phone]").val(obj.personalPhone);		//联系电话
		$("#manage-det input[name=qq]").val(obj.qq);		//qq
		$("#manage-det input[name=email]").val(obj.personalEmail);		//邮箱
		$("#manage-det input[name=home]").val(obj.homeAddress);		//户籍
		$("#manage-det input[name=address]").val(obj.houseAddress);		//现居住地
		$("#manage-det input[name=education]").val(obj.sEducation);		//学历
		$("#manage-det input[name=graduTime]").val(obj.sGraduatedDate);		//毕业时间
		
		$("#manage-det input[name=connect]").val("");		//紧急联系人
		$("#manage-det input[name=connect]").val("");		//紧急联系人
		$("#manage-det input[name=connect]").val("");		//部门
	}
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-det"),//DOM或内容
	    btn:['返回']
		  ,btn0: function(index, layero){ //或者使用btn1
			layer.close();				
		  }
	});
}


/**
 * 添加管理员	内部外部公用	判断类型执行不同函数
 * @param {String} title	标题		
 * @param {String} type		类型		0：内部	1：外部
 */
function manageAdd(title,type){
	console.log(title+","+type);
	//表单置空，清除上次遗留数据
	
	//判断参数
	if(title == "" || type == ""){
		console.log("参数错误，请检查参数");
		return;
	}
	if(STAFF_NUM ==0){
		staffList();
		STAFF_NUM++;
	}
	document.getElementById("form-admin").reset();
	validform5(".layui-layer-btn0","form-admin",true,5);
	layer.open({
	    type: 1,
	    area: ['950px', '550px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-add-staff"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断type执行不同方法
			  layer.close(index);
			 
			  showAddAdmin();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

/**
 * 根据管理员id修改管理员
 * @param {} title
 * @param {} type
 */
function manageMod(title,type){
	//由于添加和修改字段一样，可以考虑克隆，若存在差别，请复制一份到#manage-mod
	//$("#manage-mod").html($("#manage-add-admin form").clone());
	//表单置空，清除上次遗留数据
	//获取参数
	var rowdata = $('#tb-manage-in').DataTable().rows('.selected').data();
	var adminName ="";
	var adminId=0;
	var obj = null;
	var staffId= 0;
	var adminRemark ="";
	if(!isEmptyObject(rowdata[0])){ //判断是否选择
		adminName=rowdata[0].adminName;
		obj = rowdata[0].personalBaseInfo;
		adminId= rowdata[0].id;
		staffId = rowdata[0].staffId;
		adminRemark= rowdata[0].adminRemark;
		
	}else{
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	
	if(rowdata[0].adminStatu==1){
    	layer.alert("该管理员无效，不能修改！",{icon:0});
		return;
    }
	$('#form-admin input').each(function(){	
			$(this).val("");	
	});
	//获取管理员id
	document.getElementById("form-admin").reset();
	validform5(".layui-layer-btn0","form-admin",true,5);
	$("#addOrUpdate").val(1); //修改
	$("#adminId").val(adminId);
	if(obj!=null && obj.personalName!=null){
		$("input[name=userName]").val(obj.personalName);
	}
	$("input[name=userName]").attr("disabled",true);
	$("input[name=adminName]").val(adminName).attr("disabled",true);
	$("#adminName").val(adminName);
	$("input[name=staffId]").val(staffId);
	$("#adminRemark").val(adminRemark);
	$("#adminRole").append("<option selected='selected' value='"+rowdata[0].roleId+"'>"+rowdata[0].roleName+"</option>");
	//赋值
	layer.open({
	    type: 1,
	    area: ['550px', '450px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-addOrUpdate-admin"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断type执行不同方法
			  $("#form-admin").submit();
		  	
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

/**
 * 删除管理员	内部外部公用	
 */
function manageDel(){
	//获得选取的对象
		
	//删除某个职务，当有员工拥有改职务时，不能进行删除
	layer.confirm('确定删除该管理员？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //按钮【按钮一】的回调
		
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}



//加载执行
$(function(){
	$("#manage-det input").attr("disabled",true);
});

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
 * @param id   管理员id
 * @param statu 管理员状态
 */
function stopOrStart(id,statu){
	var ms ="";
	if(statu==1){
		ms="确定停用？";
	}else{
		ms="确定启用？";
	}
	var status=statu;
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
			url : appPath+"/ofAdmin.do",
				data:{
					adminId:id,
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
				  	$('#tb-manage-in').DataTable().ajax.reload();
				}else if(data == -1){
					if(status==1){
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

/**
 * 根据身份证抓取出生日期 
 * @param idCard 
 */
function getBirthday(idCard){
	var birthday = "";  
	if(idCard != null && idCard != ""){  
		if(idCard.length == 15){  
			birthday = "19"+idCard.substr(6,6);  
		} else if(idCard.length == 18){  
			birthday = idCard.substr(6,8);  
		}  
		birthday = birthday.replace(/(.{4})(.{2})/,"$1-$2-");  
	}
	return birthday;
}


/**
 * 员工列表
 */
function staffList(){
	$('#staffListTb').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
//						searching : false,
				info : true,// 左下角信息
//						ordering: false,//排序
				lengthMenu:[10,20,50,100],
//						aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath+"/role/getAllStaff.do?sType=1",   
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		            	d.personalName = "";  
		            	d.personalPhone="";
		            	d.personalIDCard="";
		            	d.postId="";
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
//		                	  "sClass": "table-checkbox"
		                  },
		                  { title:"pid","data": "baseInfo.id"},  
		                  { title:"sid","data": "id"},  
		                  { title:"姓名","data": "baseInfo.personalName"},  
		                  { title:"性别","data": "baseInfo.sexId" , 
		                	  "mRender": function (data, type, full) {
		                		  if(data==0){
		                			  return "男";
		                		  }else if(data ==1){
		                			  return "女";
		                		  }else{
		                			  return data;
		                		  }
		                	  } 
		                  },  
		                  { title:"身份证号","data": "baseInfo.personalIDCard" },  
		                  { title:"职务","data": "postName"},  
		                  { title:"联系电话","data": "baseInfo.personalPhone" },  
		                  { title:"紧急联系人姓名","data": "emerName" },  
		                  { title:"入职时间","data": "startDate" , 
		                	  "mRender": function (data, type, full) {
		                		  var date = new Date(data);
				                  return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		                	  } 
		                  }
		                  
		        ],
		        aoColumnDefs : [
		        				{"bVisible": false, "aTargets": [1,2]}, //控制列的隐藏显示
		        				{
		        					orderable : false,
		        					/*aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ]*/
		        				} // 制定列不参与排序
		        				],
		        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//		        	if($.inArray(data.DT_RowId,selected)!==-1){
//		        		$(row).addClass('selected'); 
//		        	}$("input[name=adminName]").val(adminName).attr("disabled",true);
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});
}
/**
 * 将员工添加为管理员
 */
function showAddAdmin(){
	var title="添加管理员";
	var rowdata = $('#staffListTb').DataTable().rows('.selected').data();
	var staffId = 0;
	var name = "";
	if(!isEmptyObject(rowdata[0])){ //判断是否选择
		staffId=rowdata[0].id;
		if(rowdata[0].baseInfo.personalName!= "undefined" && rowdata[0].baseInfo.personalName!=null){
			name = rowdata[0].baseInfo.personalName;
		}
		name = rowdata[0].baseInfo.personalName;
	}else{
		layer.alert("请选择员工！",{icon:0});
		return;
	}
	$("input[name=userName]").val(name);
	$("input[name=adminName]").removeAttr("disabled");
	$("input[name=staffId]").val(staffId);
	$("#addOrUpdate").val(0);
	layer.open({
	    type: 1,
	    area: ['550px', '450px'], //高宽
	    title: title,
	    //maxmin: true,
	    content: $("#manage-addOrUpdate-admin"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断type执行不同方法
		  	 $("#form-admin").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

/**
 * 提交admin(添加 、修改)
 */
function sumitAdmin(){
	var staffId=$("input[name=staffId]").val();
	var adminName = $("#adminName").val();
	var adminPwd = $("input[name=adminPwd]").val();
	if(adminPwd!=null){
		adminPwd=hex_md5(adminPwd);
	}
	var type = $("#addOrUpdate").val();
	var adminId = $("#adminId").val();
	var adminRole = $("#adminRole").val();
	if(adminRole==-1){
		layer.alert("请选择角色",{icon:1});
		return;
	}
	var adminRemark = $("#adminRemark").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	var types = type;
	staffId = encrypt.encrypt(staffId+"");
	adminName = encrypt.encrypt(adminName);
	adminPwd = encrypt.encrypt(adminPwd);
	type = encrypt.encrypt(type+"");
	adminId = encrypt.encrypt(adminId+"");
	adminRole = encrypt.encrypt(adminRole+"");
	adminRemark = encrypt.encrypt(adminRemark);
	$(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		url:appPath+"/saveOrEditAdmin.do",
		data:{
			staffId:staffId,
			adminName:adminName,
			adminPwd:adminPwd,
			adminRemark:adminRemark,
			adminRole:adminRole,
			adminId:adminId,
			type:type		//添加 0 修改 1
		},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			$(".layui-layer-btn0").removeClass("disabled");
			if(types == 0 ){
				if(data==0){
					layer.alert("添加成功",{icon:1});
					$(".layui-layer-btn1").click();
					 /*var table = $('#staffListTb').DataTable();
					 table.ajax.reload();*/
				  	//setTimeout('location.reload()',500);
				  	$('#tb-manage-in').DataTable().ajax.reload();
				}else if(data==-2){
					layer.alert("此管理员名称已被使用！",{icon:2});  
				}else if(data==-1){
					layer.alert("该成员已经是管理员了！",{icon:2});  
				}
			}else{
				layer.alert("修改成功",{icon:1});
				 $(".layui-layer-btn1").click();
				/* var table = $('#staffListTb').DataTable();
				 table.ajax.reload();*/
				 $('#tb-manage-in').DataTable().ajax.reload();
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
	
}