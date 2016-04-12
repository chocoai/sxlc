/*专家*/
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
		            "url": "../backage-web/ExpertsController/selectExpertTeamListpage.do",
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
		          { title:"专家id","data": "id"},
		          { title:"添加时间","data": "createTime"},  
		          { title:"专家姓名","data": "mngName" },  
		          { title:"职称","data": "mngPost" },  
		          { title:"头像","data": "portraitUrl" },
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
		          { title:"简介","data": "profile" },  
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
						 	{
								"aTargets":[1],
								"bVisible":false
							} 
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
 * 增加/修改操作
 * @param type 1：增加 2：修改
 * @returns
 */
function expAdd(){
	//清除数据
	document.getElementById("dataForm").reset();
	$("#portrait").attr("src","");
	//操作
	var title ="添加";
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	     title: title,
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
	//上传插件初始化
	uploadPic();
}
function expMod(){
	//清除数据
	document.getElementById("dataFor").reset();
	$("#portrai").attr("src","");
	//操作
	var  title="修改专家团队";
		var data = $('#teamTb').DataTable().rows('.selected').data(); 
		if(data.length<1){
			layer.alert("请选择要修改的管理团队！",{icon:0});
			return;
		}
		$("#mngNam").val(data[0].mngName);	
		$("#mngPos").val(data[0].mngPost);	
		$("#profil").val(data[0].profile);	
		$("#portra").attr("src",$("#hostPath").val()+data[0].portraitUrl);
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
	//上传插件初始化
	uploadPics();
	
}

function updateExpertTeamByID(){
	var data = $('#teamTb').DataTable().rows('.selected').data(); 
	var	id=data[0].id;
	var mngName = document.getElementById("mngNam").value;
	var mngPost = document.getElementById("mngPos").value;
	var portraitUrl = document.getElementById("portraitUr").value;
	var profile = document.getElementById("profil").value;
	$.ajax( {  
		url:"../backage-web/ExpertsController/updateExpertTeamByID.do",
		data:{
			id:id,
			mngName:mngName,
			mngPost:mngPost,
			portraitUrl:portraitUrl,
			profile:profile
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

function addMngTeam(){
	var mngName = document.getElementById("mngName").value;
	var mngPost = document.getElementById("mngPost").value;
	var portraitUrl = document.getElementById("portraitUrl").value;
	var profile = document.getElementById("profile").value;
	$.ajax( {  
		 url:"../backage-web/ExpertsController/insertExpertTeam.do",
		data:{
			mngName:mngName,
			mngPost:mngPost,
			portraitUrl:portraitUrl,
			profile:profile
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
				layer.alert("该名称的专家顾问已存在",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
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
		url:"../backage-web/ExpertsController/updateExpertTeamStatuByID.do",
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

/**
 * 查看图片
 * @returns
 */
function viewPic(){
	 var rdata = $('#teamTb').DataTable().rows('.selected').data(); 
    console.log(rdata[0].portraitUrl);
	$("#picView").attr("src",$("#hostPath").val()+rdata.portraitUrl);
	layer.open({
	    type: 1,
	    area: ['500px', '400px'], //高宽
	    title: "查看头像",
	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  },cancel: function(index){//或者使用btn2（concel）
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
	    server: appPath+'/backage-web/UpdateBsnLicense',	//文件接收服务端。
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
		var titl = result.split(",")[0];
		var portraitUrl=result.split(",")[1];
		$("#portraitUrl").val(portraitUrl);
		
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


/**
 * 上传图片
 * @returns
 */
function uploadPics(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: appPath+'/backage-web/UpdateBsnLicense',	//文件接收服务端。
	    // 选择文件的按钮。可选。
	    pick: '#filePickers',											//内部根据当前运行是创建，可能是input元素，也可能是flash.
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
		var portraitUrl=result.split(",")[1];
		$("#portraitUrl").val(portraitUrl);
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