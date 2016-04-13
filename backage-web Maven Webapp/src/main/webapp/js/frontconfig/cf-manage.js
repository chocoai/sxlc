/**
 * 版块：前台界面配置-管理团队
 * 内容介绍：
 */

$(function() {
	validform5(".layui-layer-btn0","dataForm",false,3);
//	$("#addBtn").on("click",function(){
//		parent.layer.close();
//	});
	$('#teamTb').DataTable(
			{	
				ajax: {  
					"url": appPath+"/front/getTeamData.do",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {  
						var name = $("#name").val();
						var addDate = $("#addDate").val();
						d.name = name;  
						d.addDate = addDate;  
					}  
				},
				columns: [  
				          {title:'<input type="checkbox"  value="1" />',
				        	  "mRender": function (data, type, full) {
				        		  return  '<input type="checkbox" value="1" />';
				        	  }
//				          "sClass": "table-checkbox"
				          },
				          { title:"teamId","data": "id"},  
				          { title:"头像","data": "portraitUrl"},  
				          { title:"添加时间","data": "createTime"},  
				          { title:"姓名","data": "mngName"},  
				          { title:"职务","data": "mngPost"},  
				          { title:"头像","data": "头像", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this)">查看头像</a>';
				        	  }
				          },  
				          { title:"简介","data": "profile" },  
				          { title:"最后一次操作管理员","data": "adminName"},  
				          { title:"状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  if(data==0){
				        			  return "<font color='red'>无效</font>";
				        		  }else if(data==1){
				        			  return "有效";
				        		  }
				        	  }
				          },  
				          { title:"操作","data": "baseInfo.nationId", 
				        	  "mRender": function (data, type, full) {
				        		  if(full.statu==0){
				        			  return "<a onclick=\"enableOrDisable(1,'"+full.id+"');\" href=\"javascript:void(0);\">启用</a>" ;
				        		  }else if(full.statu==1){
				        			  return "<a onclick=\"enableOrDisable(0,'"+full.id+"');\" href=\"javascript:void(0);\">停用</a>";
				        		  }
				        	  }
				          }

				          ],
	          aoColumnDefs : [
	                          {"bVisible": false, "aTargets": [ 1,2 ]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,2,4,5,6,7,8,9,10]
	                          } // 制定列不参与排序
	                          ],
              pagingType: "simple_numbers",//设置分页控件的模式  
              processing: true, //打开数据加载时的等待效果  
              serverSide: true,//打开后台分页  
              info:false,
              rowCallback:function(row,data){//添加单击事件，改变行的样式      
              }
//				,
//              Language: {
//            	  "LengthMenu": "每页显示 _MENU_ 条记录",
//            	  "ZeroRecords": "抱歉， 没有找到",
//            	  "Info": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
//            	  "InfoEmpty": "没有数据",
//            	  "InfoFiltered": "(从 _MAX_ 条数据中检索)",
//            	  "Paginate": {
//            	  "First": "首页",
//            	  "Previous": "前一页",
//            	  "Next": "后一页",
//            	  "Last": "尾页"
//            	  }
//              }
	 
	});
	 
	//选中
	 $('#teamTb tbody').on( 'click', 'tr', function () {
	        $(this).toggleClass('selected');
	  });
	
	
}); 

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#teamTb').DataTable().ajax.reload();
});



/**
 * 增加/修改操作
 * @param type 1：增加 2：修改
 * @returns
 */
function addOrUpdate(type){
	//清除数据
	document.getElementById("dataForm").reset();
	$("#portrait").attr("src","");
	$("#fileList").html("");
	$("#filePicker").html("选择图片");//清除样式
	//操作
	var title="";
	if(type==1){
		title="添加管理团队";
		$("#dataForm").attr("action","javascript:addOrModify(1)");
	}else if(type==2){
		title="修改管理团队"
		$("#dataForm").attr("action","javascript:addOrModify(2)");
		var data = $('#teamTb').DataTable().rows('.selected').data(); 
		if(data.length<1){
			layer.alert("请选择要修改的管理团队！",{icon:0});
			return;
		}
		$("#teamId").val(data[0].id);	
		$("#mngName").val(data[0].mngName);	
		$("#mngPost").val(data[0].mngPost);	
		$("#profile").val(data[0].profile);	
		$("#portrait").attr("src",$("#hostPath").val()+data[0].portraitUrl);
			
	}
	
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	    title: title,
	    maxmin: true,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
//			  $("#portraitUrl").val(uploadUrl);
			  $("#dataForm").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
	//上传插件初始化
	expUpload("portraitUrl");
}



/**
 * 增加或修改
 * @param type 1:增加  2：修改
 */
function addOrModify(type){
		var url=""; 
		if(type==1){
			url="/front/addMngTeam.do";
		}else if(type==2){
			url="/front/editMngTeam.do";
		}
		$.ajax( {  
			url:appPath+url,
			data:$("#dataForm").serialize(),
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data==1){
					layer.alert("操作成功",{icon:1});
					$(".layui-layer-btn1").click();
					 var table = $('#teamTb').DataTable();
					 table.ajax.reload();
				}else if(data==0){
					layer.alert("操作失败",{icon:2});  
				}else if(data==-1){
					layer.alert("管理团队已存在",{icon:2});  
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}

/**
 * 启用/停用功能
 * @param type 1：启用 0：停用
 * @param id 管理团队id
 * @returns
 */
function enableOrDisable(type,id){
	$.ajax( {  
		url:appPath+"/front/enableMngTeam.do",
		data:{"statu":type,"id":id},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				var table = $('#teamTb').DataTable();
				table.ajax.reload();
			}else if(data==0){
				layer.alert("操作失败",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}

/**
 * 查看图片
 * @returns
 */
function viewPic(btn){
    var data = $('#teamTb').DataTable().row($(btn).parents('tr')).data();
    if(data.portraitUrl !=""){
    	$("#picView").attr("src",$("#hostPath").val()+data.portraitUrl);
    	$(".hideHtml").hide();
    }else{
    	$(".hideHtml").show();
    	$("#picView").attr("src","");
    }
	layer.open({
	    type: 1,
	    area: ['500px', '400px'], //高宽
	    title: "查看头像",
//	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}

