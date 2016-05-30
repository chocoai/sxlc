/**
 * 版块：配置中心-----项目审批流程配置----审批流程配置
 * 内容介绍：
 */
$(function(){
	//单选
	$('#table_id,#addproexamexam tbody').on( 'click', 'tr', function () {
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
	showProcess();
	Process();
	//添加审批点
	$(".obtn-proexam-point-add").on("click touchstart",function(){
		layer.open({
		    type: 1,
		    area: ['900px', '650px'], //高宽
		    title: "添加审批点",
		    content: $(".proexam-point-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				  addProgress();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
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
	
	/* 添加部分开始 */
/*	function proexamproceAdd(){
		window.location.href = appPath+"/web/config/config-add/proexam-process-add.jsp";
		//$(".right_col").load("web/config/config-add/proexam-process-add.jsp");
	}*/
	/* 添加部分结束 */

/**
 * 上移或者下移
 * id  1上  0 下
 * statu 状态
 */
function upOrDown(id,statu){
		var stutus =statu;
		var ms ="";
		if(statu==-1){
			ms="确定下移？";
		}else{
			ms="确定上移？";
		}
		//result 为加密后参数
		var statu = encrypt.encrypt(statu+"");
		var id = encrypt.encrypt(id+"");
		layer.confirm(ms, {
			  btn: ['确定', '取消']
		}, function(index, layero){
			  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/activityprocess/upOrDownProgress.do",
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
						if(stutus>0){
							layer.alert("上移成功。",{icon:1});  
						}else{
							layer.alert("下移成功。",{icon:1});  
						  
						}
						layer.close(index);
						var table = $('#table_id').DataTable();
						table.ajax.reload();
					}else {
						if(stutus>0){
							layer.alert("上移失败!",{icon:2});
						}else{
							layer.alert("下移失败!",{icon:2});
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
 * 删除
 * id  1上  0 下
 * statu 状态
 */
function deleteProgress(id){
		var ms ="";
		ms="确定删除？";
		var stutus =id;
		//result 为加密后参数
		var id = encrypt.encrypt(id+"");
		layer.confirm(ms, {
			  btn: ['确定', '取消']
		}, function(index, layero){
			  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/activityprocess/deleteProgress.do",
					data:{
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
						layer.alert("删除成功。",{icon:1});  
					  	layer.close(index);
					  	var table = $('#table_id').DataTable();
						table.ajax.reload();
					}else {
						layer.alert("删除失败!",{icon:2});
					}
				}
				});
			}, function(index){
			  //按钮【按钮二】的回调
			});
	}

	/**
	 * 显示列表
	 */
	function showProcess(){
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
//					ordering: false,//排序
					lengthMenu:[10,25,50,100],
//					aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
					colReorder : false,
					scrollX : true,
					sScrollX : "100%",
					sScrollXInner : "100%",
					bScrollCollapse : true,  
					processing: true, //打开数据加载时的等待效果  
			        serverSide: true,//打开后台分页  
			        ajax: {  
			            "url": appPath+"/activityprocess/getProcessList.do",   
			            "dataSrc": "results",   
			            "data": function ( d ) { 
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
			                	  if(full.apID==0){// 0：1：2：
			                		  sReturn = "<font >平台初审 </font>";
			                	  }else if(full.apID==1){
			                		  sReturn = "<font >担保机构审核 </font>";
			                	  }else{
			                		  sReturn = "<font >平台终审</font>";
			                	  }
			                  		return sReturn;
			                  	}
			                  }, 
			                  { title:"操作","mRender":function(data, type, full){
			                	  var sReturn ="";
		                		  sReturn+=  "<a href='javascript:upOrDown("+full.id+",1);' class='btn-disable'>上移</a>";
		                		  sReturn+=  "&nbsp;&nbsp;&nbsp;<a href='javascript:upOrDown("+full.id+",-1);' class='btn-disable'>下移</a>";
		                		  sReturn+=  "&nbsp;&nbsp;&nbsp;<a href='javascript:deleteProgress("+full.id+");' class='btn-disable'>删除</a>";
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

	/**
	 * 添加审批流程
	 */
	function addProgress(){
		var rowdata = $('#addproexamexam').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要处理的事务！",{icon:0});
			return;
		}
		var id =rowdata[0].id;
		//result 为加密后参数
		id = encrypt.encrypt(id+"");
		layer.confirm("确定添加?", {
			  btn: ['确定', '取消']
		}, function(index, layero){
			  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/activityprocess/saveProgress.do",
					data:{
						apId:id
					},
					type : "post",
					dataType:"text",
				error : function() {
					alert('操作失败！');
					return;
				},
				success : function(data) {
					 if(data ==1){
						//执行完关闭
							layer.alert("添加成功。",{icon:1});  
							$(".layui-layer-btn1").click();
							var table = $('#table_id').DataTable();
							table.ajax.reload();
					  }else if(data==-1){
						  layer.alert("该活动点已添加。",{icon:2});  
					  }else{
						  layer.alert("添加失败",{icon:0});  
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
	function Process(){
		$('#addproexamexam').DataTable(
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
//					ordering: false,//排序
					lengthMenu:[10,25,50,100],
//					aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
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
			            	var auth = $("#auth").val();
			            	d.content = 1;//有效的
			            	d.autu=auth;//活动点名称
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
			                  }
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


	/**
	 * 查询按钮
	 */
	$(".glyphicon-search").on("click",function(){
		//$('#addproexamexam').DataTable().ajax.reload();
		
	});




