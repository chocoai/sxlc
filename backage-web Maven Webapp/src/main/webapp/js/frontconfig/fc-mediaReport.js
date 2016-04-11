/**
 * 版块：前台界面配置-媒体报道
 * 内容介绍：
 */
 
$(function() {
	$('#mediaTb').DataTable({
		ajax: {  
			"url": appPath+"/front/getMediaData.do",   
			"dataSrc": "results", 
			"type": "POST",
			"data": function ( d ) {  
			}  
		},
		columns: [  
		          {title:'<input type="checkbox"  value="1" />',
		        	  "mRender": function (data, type, full) {
		        		  return  '<input type="checkbox" value="1" />';
		        	  }
	//	          "sClass": "table-checkbox"
		          },
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
	                  {"bVisible": false, "aTargets": [1,2 ]}, //控制列的隐藏显示
	                  {
	                	  "orderable" : false,
	                	  "aTargets" : [0,1,3,4,5,6,7,8,9]
	                  } // 制定列不参与排序
	                  ],
	  pagingType: "simple_numbers",//设置分页控件的模式  
	  processing: true, //打开数据加载时的等待效果  
	  serverSide: true,//打开后台分页  
	  info:false,
	  rowCallback:function(row,data){//添加单击事件，改变行的样式      
	  }
	
	});
	
	//选中
	 $('#mediaTb tbody').on( 'click', 'tr', function () {
	        $(this).toggleClass('selected');
	  });
	
});







/**
 * 增加/修改操作
 * @param type 1：增加 2：修改
 * @returns
 */
function addOrUpdate(type){
	//初始化
	var ue = UE.getEditor('editor');
	//清空数据
	document.getElementById("dataForm").reset();
	$("#showImg").attr("src","");
	$("#fileList").html("");
	//操作
	var title="";
	var url=""; 
	if(type==1){
		title="添加最新动态";
		url="/front/addMediaReport.do";
		ue.addListener("ready", function () {
        	ue.setContent("");
	    });
	}else if(type==2){
		title="修改最新动态";
		url="/front/editMediaReport.do";
		var data = $('#mediaTb').DataTable().rows('.selected').data(); 
		if(data.length<1){
			layer.alert("请选择要修改的数据！",{icon:0});
			return;
		}
		$("#reportId").val(data[0].id);	
		$("#title").val(data[0].title);	
		$("#source").val(data[0].source);
		$("#pictureUrl").val(data[0].logo);
		ue.addListener("ready", function () {
        	ue.setContent(data[0].content);
	    });
		$("#showImg").attr("src",$("#hostPath").val()+data[0].logo);
			
	}
	layer.open({
	    type: 1,
	    area: ['1100px', '600px'], //高宽
	    title: title,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
			    var content = ue.getContent();
				$("#content").val(content);
				ue.destroy();
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
			  ue.destroy();
		  }
	});
	//上传插件初始化
	uploadPic();
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
		data:{"statu":type,"id":id},
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
	    area: ['800px', '600px'], //高宽
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
	    area: ['500px', '400px'], //高宽
	    title: "查看图标",
//	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}


/**
 * 上传图片
 * @returns
 */
function uploadPic(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
	    // 选择文件的按钮。可选。
	    pick: '#filePicker',											//内部根据当前运行是创建，可能是input元素，也可能是flash.
	    fileNumLimit: 1,												//个数限制
		//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。
		fileSingleSizeLimit: 1024*512,
	    accept: {														//只允许选择图片文件
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    },
	    resize: false													//不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	});
	
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + file.name + '</div>' +
	            '</div>'
	            ),
	    	$del = $del = $('<div class="file-panel"><span class="cancel"></span></div>'),
	        $img = $li.find('img');
	
	
	    // $list为容器jQuery实例
	    $list = $("#fileList");
	    $list.append( $li );
	    $del.appendTo( $li );
	    
	    //预览时操作面板显隐
	    $("#fileList .file-item").each(function(){
			$(this).mouseenter(function(){
				$(this).parent().find(".file-panel").animate({height:30},"fast");
			}).mouseleave(function(){
				$(this).parent().find(".file-panel").animate({height:0},"fast");
			});
	    });
		
	    //销毁
		$del.on('click', 'span', function() {
			removeFile(file);
		});
		
		// 负责view的销毁
		function removeFile(file) {
			var $li = $('#' + file.id);
			uploader.removeFile(file, true);
			$li.off().find('.file-panel').off().end().remove();
		}
		
	
	    // 创建缩略图
	    // 如果为非图片文件，可以不用调用此方法。
	    // thumbnailWidth x thumbnailHeight 为 100 x 100
	    // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,
	    
	    uploader.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            $img.replaceWith('<span>不能预览</span>');
	            return;
	        }
	
	        $img.attr( 'src', src );
	    }, thumbnailWidth, thumbnailHeight );
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress span');
	
	    // 避免重复创建
	    if ( !$percent.length ) {
	        $percent = $('<p class="progress"><span></span></p>')
	                .appendTo( $li )
	                .find('span');
	    }
	
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {
		var result = json._raw;
		var pictureUrl=result.split(",")[1];
		$("#pictureUrl").val(pictureUrl);
	    $( '#'+file.id ).addClass('upload-state-done');
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');
	
	    // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }
	
	    $error.text('上传失败');
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').remove();
	});
}





