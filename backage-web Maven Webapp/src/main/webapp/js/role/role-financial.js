/**
 * 角色管理-理财顾顾问管理
 * 添加修改部分代码直接写在页面上的，加快渲染速度
 * 每次执行操作前请清空目标盒子的数值
 */

var STAFF_NUM = 0; //控制员工列表显示一次
$(function() {
	plannerList();
	//单选
	$('#table_id,#staffListTb tbody').on( 'click', 'tr', function () {
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
	
	//==============理财顾问
	$(".obtn-adviser-add").on("click touchstart",function(){
		if(STAFF_NUM ==0){
			staffList();
			STAFF_NUM++;
		}
		layer.open({
		    type: 1,
		    area: ['950px', '600px'], //高宽
		    title: "添加理财顾问",
		    content: $(".adviser-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				//获得选取的对象
					var rowdata = $('#staffListTb').DataTable().rows('.selected').data();
					var staffId =0;
					if(!isEmptyObject(rowdata[0])){ //判断是否选择
						staffId=rowdata[0].id;
					}else{
						layer.alert("请选择要处理的事务！",{icon:0});  
						return;
					}
					var encrypt = new JSEncrypt();
			    	encrypt.setPublicKey(publicKey_common);
			    	//result 为加密后参数
			    	staffId = encrypt.encrypt(staffId);
				  $.ajax({
						url : appPath+"/savaPlannerAdvise.do",
							data:{
								staffId:staffId,
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
								layer.alert("添加成功",{icon:1});  
							  	layer.close(index);
							  	setTimeout('location.reload()',500);
							}else if(data == -1){
								layer.alert("添加失败， 该员工未注册前台会员！",{icon:0});  
							}
						 }
					});  
				  
			    //确定的回调
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
	$(".obtn-adviser-del").on("click touchstart",function(){
		//获得选取的对象
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var staffId =0;
		if(!isEmptyObject(rowdata[0])){ //判断是否选择
			staffId=rowdata[0].id;
		}else{
			layer.alert("请选择要处理的事务！",{icon:0});  
			return;
		}
		var encrypt = new JSEncrypt();
    	encrypt.setPublicKey(publicKey_common);
    	//result 为加密后参数
    	staffId = encrypt.encrypt(staffId);
		layer.confirm('确定移除该理财顾问？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/removePlannerAdvise.do",
					data:{
						planneId:staffId,
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
					  	layer.close(index);
					  	setTimeout('location.reload()',500);
					}else if(data == -1){
						
					}
				 }
			});
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
});


/**
 * 理财顾顾问列表
 */
function plannerList(){
	$('#table_id').DataTable(
			{	autoWidth : false,
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
		            "url": appPath+"/getPlannerAdvise.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		            	var staffName = $("#staffName").val();//管理员编码
		            	var memberNo =  $("#memberNo").val();//用户
		            	var logName =  $("#logName").val();//开始时间
		            	var realName =  $("#realName").val();//结束时间
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	//result 为加密后参数
		            	staffName = encrypt.encrypt(staffName);
		            	memberNo = encrypt.encrypt(memberNo);
		            	logName = encrypt.encrypt(logName);
		            	realName = encrypt.encrypt(realName);
		            	d.staffName=staffName;
		            	d.memberNo=memberNo;
		            	d.logName=logName;
		            	d.realName=realName; 
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"理财顾问ID","data": "id"},   
		                  { title:"员工名称","data": "staffName"},   
		                  { title:"成为理财顾问时间","data": "sRecordDate"},   
		                  { title:"前台会员编号","data": "memberNo" },  
		                  { title:"前台会员用户名","data": "logName" },  
		                  { title:"前台会员类型","mRender":function(data, type, full){
		                  		sReturn = "";
		                  		if(full.memberType==0){
		                  			sReturn ="个人会员";
		                  		}else if(full.memberType==1){
		                  			sReturn ="企业会员";
		                  		}
		                		  return sReturn;
		                	  }
		                  }, 
		                  { title:"前台会员名称","data": "realName" },  
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
		            "url": appPath+"/role/getAllStaff.do?sType=2",   
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
