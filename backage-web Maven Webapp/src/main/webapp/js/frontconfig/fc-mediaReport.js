/**
 * 版块：前台界面配置-媒体报道
 * 内容介绍：
 */

//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function() {
	//表格初始化
	$('#mediaTb').DataTable({
		ajax: {  
			"url": appPath+"/front/getMediaData.do",   
			"dataSrc": "results", 
			"type": "POST",
			"data": function ( d ) {
			}  
		},
		columns: [  
		          { title:"媒体报道ID","data": "id"},  
		          { title:"logoUrl","data": "logo"},  
		          { title:"添加时间","data": "createTime"},  
		          { title:"图标","data": "图标", 
		        	  "mRender": function (data, type, full) {
		        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this)">查看图标</a>';
		        	  }
		          },  
		          { title:"标题","data": "title"},  
		          { title:"来源","data": "source"},  
		          { title:"内容","data": "content", 
		        	  "mRender": function (data, type, full) {
		        		  return '<a href="javascript:void(0);" class="btn-det" onclick="reportDet(this)">查看详情</a>';
		        	  }
		          }, 
		          { title:"最后一次操作管理员","data": "adminName"}, 
		          { title:"状态","data": "statu", 
		        	  "mRender": function (data, type, full) {
		        		  if(data==0){
		        			  return "<font color='red'>失效</font>";
		        		  }else if(data==1){
		        			  return "有效";
		        		  }
		        	  }
		          },  
		          { title:"操作","data": "", 
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
	                  {"bVisible": false, "aTargets": [0,1]}, //控制列的隐藏显示
	                  {
	                	  "orderable" : false,
	                	  "aTargets" : [0,1,3,4,5,6,7,8,9]
	                  } // 制定列不参与排序
	                  ],
	  pagingType: "simple_numbers",//设置分页控件的模式  
	  processing: true, //打开数据加载时的等待效果  
	  serverSide: true,//打开后台分页  
//	  info:false,
	  rowCallback:function(row,data){//添加单击事件，改变行的样式      
	  }
	
	});
	
	//表格单选效果
	 $('#mediaTb tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
	        if ( $this.hasClass('selected') ) {
	        	$this.removeClass('selected');
	        }
	        else {
	        	$('#mediaTb tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	 
	
});


/**
 * 增加/修改操作
 * @param type 1：增加 2：修改
 * @returns
 */
var ue = UE.getEditor('editor');
var num=0;//用于判断是否是第一次进入editor插件
function addOrUpdate(type){
	//初始化
	//清空数据
	document.getElementById("dataForm").reset();
//	ue.reset();
	$("#showImg").attr("src","");
	$("#fileList").html("");
	$("#filePicker").html("选择图片");//清除样式
	//操作
	var title="";
	if(type==1){
		title="添加最新动态";
		if(num==0){
			ue.addListener("ready", function () {
	        	ue.setContent("");
		    });
			num += 1;
		}else{
			ue.setContent("");
		}
	}else if(type==2){
		title="修改最新动态";
		var data = $('#mediaTb').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的数据！",{icon:0});
			return;
		}
		$("#reportId").val(data[0].id);	
		$("#title").val(data[0].title);	
		$("#source").val(data[0].source);
		$("#pictureUrl").val(data[0].logo);
		if(num==0){
			ue.addListener("ready", function () {
	        	ue.setContent(data[0].content);
		    });
			num += 1;
		}else{
			ue.setContent(data[0].content);
		}
		$("#fileList").html('<img height="100" width="100" src="'+$("#hostPath").val()+data[0].logo+'">');
			
	}
	layer.open({
	    type: 1,
	    area: ['1100px', '600px'], //高宽
	    title: title,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
//				$("#content").val(content);
//				ue.destroy();
				
				//加密参数
				var data={};
				var title = encrypt.encrypt($("#title").val());
				data.title=title;
				var source = encrypt.encrypt($("#source").val());
				data.source=source;
				var logo = encrypt.encrypt($("#pictureUrl").val());
				data.logo=logo;
				var reportId = encrypt.encrypt($("#reportId").val());
				data.reportId=reportId;
				var content = ue.getContent();
				data.content=encrypt.encrypt(content);
				data.type=encrypt.encrypt(""+type);
				
				$.ajax( {  
					url:appPath+"/front/addOrUpdateReport.do",
					data:data,
					type:'post',  
					cache:false,  
					dataType:'json',  
					success:function(data) { 
						if(data==1){
							layer.alert("操作成功",{icon:1});
							$(".layui-layer-btn1").click();
							 var table = $('#mediaTb').DataTable();
							 table.ajax.reload();
						}else if(data==0){
							layer.alert("操作失败",{icon:2});  
						}else if(data==-1){
							layer.alert("该报道标题已存在！",{icon:2});  
						}
					},  
					error : function() {  
						layer.alert("服务器异常",{icon:2});  
					}  
				});
			  
		  },cancel: function(index){//或者使用btn2（concel）
//			  ue.destroy();
		  }
	});
	//上传插件初始化
	expUpload("#pictureUrl");
}

 
/**
 * 启用/停用功能
 * @param type 1：启用 0：停用
 * @param id 媒体报道id
 * @returns
 */
function enableOrDisable(type,id){
	$.ajax( {  
		url:appPath+"/front/enableMediRepo.do",
		data:{"statu":encrypt.encrypt(""+type),"id":encrypt.encrypt(id)},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				var table = $('#mediaTb').DataTable();
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
 * 查看详情
 */
function reportDet(btn){
	$(".report-det").html("");//清空数据
	var data = $('#mediaTb').DataTable().row($(btn).parents('tr')).data();
	$(".report-det").html(data.content);
	
	layer.open({
	    type: 1,
	    area: ['500px', '300px'], //高宽
	    title: "查看详情",
	    maxmin: true,
	    content: $(".report-det"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){//或者使用btn2（concel）
		  }
	});
}



/**
 * 查看图片
 * @returns
 */
function viewPic(btn){
    var data = $('#mediaTb').DataTable().row($(btn).parents('tr')).data();
    if(data.logo !=""){
    	$("#picView").attr("src",$("#hostPath").val()+data.logo);
    	$(".hideHtml").hide();
    }else{
    	$(".hideHtml").show();
    	$("#picView").attr("src","");
    }
	layer.open({
	    type: 1,
	    area: ['300px', '300px'], //高宽
	    title: "查看图标",
//	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}

