/*招聘信息*/
/**
 * 获取项目根目录全路径
 * @returns
 */
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}


/**
 *面板数据 
 *
 */

$(function() {
	var appPath = getRootPath();//项目根路径
    $("#teamTb").dataTable({ 
		        autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
			 // paging : false,//分页
		//				searching : false,
		//				info : false,// 左下角信息
		//				ordering: false,//排序
				lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		//				aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: { 
		            "url": "../backage-web/RecruitmentController/selectRecruitmentsList.do",
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
		          { title:"招聘id","data": "id"},
		          { title:"添加时间","data": "createTime"},  
		          { title:"招聘职位","data": "name" },  
		          { title:"工作地区","data": "area" },  
		          { title:"岗位职责","data": "jobResponsibilities" },
		          { title:"任职要求","data": "jobRequirements" },
		          { title:"状态","data": "statu",
		        	  "mRender": function (data, type, full) {
                		  if(data==0){
                			  return "<font color ='red'>无效</font>";
                		  }else if(data ==1){
                			  return "有效";
                		  }else{
                			  return data;
                		  }
                	  } 
		          },  
		          { title:"最后一次操作管理员","data": "adminName" },  
		           { title:"操作","data": "statu", 
		        	  "mRender": function (data, type, full) {
                		  return "<a onclick=\"enableMngTeam(1,'"+full.id+"');\" href=\"javascript:void(0);\">启用</a>" 
                		  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick=\"enableMngTeam(0,'"+full.id+"');\" href=\"javascript:void(0);\">停用</a>";
                	  }
              }
			     ],
		    aoColumnDefs : [
						{	
							sDefaultContent: '',
							orderable : false,
							aTargets: [ '_all' ]
							}, // 制定列不参与排序
//						 	{
//								"aTargets":[1],
//								"bVisible":false
//							} 
						],
		    rowCallback:function(row,data){//添加单击事件，改变行的样式      
		    },
		    oTableTools:{"sRowSelect":"multi"}
		});  
	
	 $('#teamTb tbody').on( 'click', 'tr', function () {
	        $(this).toggleClass('selected');
	  });
});


/**
 * 增加
 * @param 
 * @returns
 */
function  inviteAdd(){
	//清除数据
	document.getElementById("dataForm").reset();
//	$("#portrait").attr("src","");
	//操作
	layer.open({
	    type: 1,
	    area: ['750px', '600px'], //高宽
	    title: "添加招聘信息",
	    maxmin: true,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
			  $("#dataForm").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

//添加方法
function addMngTeam(){
	var appPath = getRootPath();//项目根路径
	var name = document.getElementById("name").value;
	var area = document.getElementById("area").value;
	//获取ueditor内容
	var ue1 = UE.getEditor('duty');
	var jobR = ue1.getContent();
	var ue2 = UE.getEditor('demand');
	var jobRe= ue2.getContent();
	$.ajax( {  
		 url:"../backage-web/RecruitmentController/insertRecruitments.do",
		data:{
			name:name,
			area:area,
			jobResponsibilities:jobR,
			jobRequirements:jobRe
		},
		type:'post',  
		cache:false,  
		dataType:'json',   
		success:function(data) { 
			 if(data==1){
				layer.alert("添加成功",{icon:1});
				$(".layui-layer-btn1").click();
				 var table = $('#staffListTb').DataTable();
				 window.location.reload(); 
				 
			}else if(data==0){
				layer.alert("数据为空",{icon:2});  
			}else if(data==-1){
				layer.alert("该名称的已存在",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}

  function inviteMod(){
	  document.getElementById("dataFor").reset();
		//操作
		var  title="修改招聘";
		var ue4 = UE.getEditor('dutys');
		var ue5 = UE.getEditor('demands');
			var data = $('#teamTb').DataTable().rows('.selected').data(); 
			if(data.length<1){
				layer.alert("请选择招聘信息！",{icon:0});
				return;
			}
			$("#nam").val(data[0].name);	
			$("#are").val(data[0].area);
			$.ajax({
				type : 'post',
				url:"../backage-web/RecruitmentController/selectRecruitmentByID.do",
				data:{ id:data[0].id },
				success : function (msg) {
					alert(msg.dutys)
					ue4.addListener("ready", function () {
		        		// editor准备好之后才可以使用
						ue4.setContent(msg.content);
//						ue5.setContent(msg.content);
			        });
				}
			});
			$("#dutys").val(data[0].jobResponsibilities);
			$("#demands").val(data[0].jobRequirements);
		layer.open({
		    type: 1,
		    area: ['750px', '550px'], //高宽
		    title: title,
		    maxmin: true,
		    content: $(".pic-mod"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  	//判断执行不同方法
				  $("#dataFor").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
  }

  function updateRecruitments(){
		var data = $('#teamTb').DataTable().rows('.selected').data(); 
		var	id=data[0].id;
		var name = document.getElementById("nam").value;
		var area = document.getElementById("are").value;
		//获取ueditor内容
		var ue4 = UE.getEditor('dutys');
		var jobRs = ue4.getContent();
		var ue5 = UE.getEditor('demands');
		var jobRes= ue5.getContent();
		$.ajax( {  
			url:"../backage-web/RecruitmentController/updateRecruitments.do",
			data:{
				id:id,
				name:name,
				area:area,
				jobResponsibilities:jobRs,
				jobRequirements:jobRes
				},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				 if(data==1){
						layer.alert("修改成功",{icon:1});
						$(".layui-layer-btn1").click();
						 var table = $('#staffListTb').DataTable();
						 window.location.reload(); 
						 
					}else if(data==0){
						layer.alert("失败",{icon:2});  
					}
			},  
			error : function() {  
				layer.alert("操作失败!",{icon:2});  
			}  
		});
	}
  
  
  /**
   * 启用/停用管理团队
   * @param type 1：启用 0：停用
   * @param id 管理团队id
   * @returns
   */
  function enableMngTeam(type,id){
  	$.ajax( {  
  		url:"../backage-web/RecruitmentController/updateRecruitmentStatuByID.do",
  		data:{
  			id:id,
  			statu:type
  			},
  		type:'post',  
  		cache:false,  
  		dataType:'json',  
  		success:function(data) { 
  			if(data==1){
  				layer.alert("操作成功",{icon:1});
  				var table = $('#teamTb').DataTable();
  				 window.location.reload();
  			}else if(data==0){
  				layer.alert("操作失败",{icon:2});  
  			}
  		},  
  		error : function() {  
  			layer.alert("服务器异常",{icon:2});  
  		}  
  	});
  }



