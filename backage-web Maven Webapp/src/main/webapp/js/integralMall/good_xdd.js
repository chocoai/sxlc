$(function(){
	$("#good_xdd").Validform({
		tiptype:3,
		btnSubmit:".queding", 
		datatype:{"enterAddress":enterAddress,"acountM":acountM,"time":time},
		ajaxPost:{
			
		    },
			success:function(data,obj){
	            
	        },
	        error:function(data,obj){
	            
	        }
		});
});

$(function(){
	//上传初始化
	var uploader1 = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: '',	//文件接收服务端。
	    // 选择文件的按钮。可选。
	    pick: '#filePicker1',											//内部根据当前运行是创建，可能是input元素，也可能是flash.
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
	uploader1.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + file.name + '</div>' +
	            '</div>'
	            ),
	        	$del = $del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
		        $img = $li.find('img');
	
	
	    // $list为容器jQuery实例
	    $list = $("#fileList1");
	    $list.append( $li );
	    $del.appendTo( $li );
	    
	    //预览时操作面板显隐
	    $("#fileList1 .file-item").each(function(){
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
			uploader1.removeFile(file, true);
			$li.off().find('.file-panel').off().end().remove();
		}
		
	
	    // 创建缩略图
	    // 如果为非图片文件，可以不用调用此方法。
	    // thumbnailWidth x thumbnailHeight 为 100 x 100
	    // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,
        thumbnailWidth = 200 * ratio,
        thumbnailHeight = 184 * ratio,
	    
	    uploader1.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            $img.replaceWith('<div>不能预览</div>');
	            return;
	        }
	
	        $img.attr( 'src', src );
	    }, thumbnailWidth, thumbnailHeight );
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader1.on( 'uploadProgress', function( file, percentage ) {
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
	uploader1.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).addClass('upload-state-done');
	});
	
	// 文件上传失败，显示上传出错。
	uploader1.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');
	
	    // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }
	
	    $error.text('上传失败');
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader1.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').remove();
	});
});
