/* 表格 */
$('#table_frontconfig').DataTable({
	"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
	"aoColumnDefs" : [
	//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
	{
		"orderable" : false,
		"aTargets" : [0,2,3,4,5,6,7]
	} // 制定列不参与排序
	],
});


/**
 * 版块：前台界面配置
 * 内容介绍：首页宣传图片管理
 * 伍成然2016-05-11
 */
$(function(){
	$(".obtn-pic-add").on("click",function(){
		layer.open({
		    type: 2,
		    area: ['750px', '550px'], //高宽
		    title: "添加",
		    maxmin: true,
		    content: "web/frontconfig/fc-add/integrateMall-pic-add.jsp",//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	$(".obtn-pic-mod").on("click",function(){
		layer.open({
		    type: 2,
		    area: ['750px', '550px'], //高宽
		    title: "添加",
		    maxmin: true,
		    content: "web/frontconfig/fc-add/integrateMall-pic-mod.jsp",//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	$(".obtn-pic-del").on("click",function(){
		layer.alert("确认删除吗？",{
			icon:0,
			btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		    },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		    }
		});
	});
	//启用停用
	$(".btn-enable").on("click touchstart",function(){
		layer.alert("确认启用吗？",{
			icon:0,
			btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		    },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		    }
		});
	});

	$(".btn-disable").on("click touchstart",function(){
		layer.alert("确认停用吗？",{
			icon:0,
			btn:['确定', '取消']
			,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		    },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		    }
		});
	});
});

/*图片上传
伍成然
2016-05-12*/
$(function(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: '',	//文件接收服务端。
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
	    	$del = $del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
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
        thumbnailWidth = 580 * ratio,
        thumbnailHeight = 280 * ratio,
	    
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
	uploader.on( 'uploadSuccess', function( file ) {
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
	
	
});









