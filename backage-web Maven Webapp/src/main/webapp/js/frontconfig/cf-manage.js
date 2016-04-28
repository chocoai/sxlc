/**
 * 版块：前台界面配置-管理团队
 * 内容介绍：
 */

//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function() {
	validform5(".layui-layer-btn0","dataForm",false,3);
	$('#teamTb').DataTable(
			{	
				ajax: {  
					"url": appPath+"/front/getTeamData.do",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {  
						var name = encrypt.encrypt($("#name").val());
						var addDate = encrypt.encrypt($("#addDate").val());
						d.mngName = name;  
						d.startTime = addDate;  
					}  
				},
				columns: [  
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
	                          {"bVisible": false, "aTargets": [ 0,1]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,1,3,4,5,6,7,8,9]
	                          } // 制定列不参与排序
	                          ],
              pagingType: "simple_numbers",//设置分页控件的模式  
              processing: true, //打开数据加载时的等待效果  
              serverSide: true,//打开后台分页  
//              info:false,
              rowCallback:function(row,data){//添加单击事件，改变行的样式      
              }
	 
	});//表格初始化完毕
	 
	//表格单选效果
	 $('#teamTb tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
	        if ( $this.hasClass('selected') ) {
	        	$this.removeClass('selected');
	        }
	        else {
	        	$('#teamTb tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
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
		$("#nameOld").val(data[0].mngName);	//修改之前的name
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
	expUpload("#portraitUrl");
}



/**
 * 增加或修改
 * @param type 1:增加  2：修改
 */
function addOrModify(type){
		//加密参数
		var data={};
		var mngName = encrypt.encrypt($("#mngName").val());
		data.mngName=mngName;
		var mngPost = encrypt.encrypt($("#mngPost").val());
		data.mngPost=mngPost;
		var portraitUrl = encrypt.encrypt($("#portraitUrl").val());
		data.portraitUrl=portraitUrl;
		var profile = encrypt.encrypt($("#profile").val());
		data.profile=profile;
		var teamId = encrypt.encrypt($("#teamId").val());
		data.teamId=teamId;
		data.type=encrypt.encrypt(""+type);
		
		$.ajax( {  
			url:appPath+"/front/addOrUpdateTeam.do",
			data:data,
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
	var title="";
	if(type==1){
		title ='确定启用？';
	}else if(type==0){
		title ='确定停用？';
	}
	layer.confirm(title, {
		btn: ['确定', '取消']
	}, function(index, layero){
	
	
//	 NetUtil.ajax(
//			  appPath+"/front/enableMngTeam.do",
//			  {"statu":encrypt.encrypt(""+type),"id":encrypt.encrypt(id)},
//			  function(data) { 
//					if(data==1){
//						layer.alert("操作成功",{icon:1});
//						var table = $('#teamTb').DataTable();
//						table.ajax.reload();
//					}else if(data==0){
//						layer.alert("操作失败",{icon:2});  
//					}
//				}
//	 );
	
	$.ajax( {  
		url:appPath+"/front/enableMngTeam.do",
		data:{"statu":encrypt.encrypt(""+type),"id":encrypt.encrypt(id)},
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
	
	}, function(index){
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

