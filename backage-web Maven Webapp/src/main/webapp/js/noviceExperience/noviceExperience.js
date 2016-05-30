var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
var uploadUrl = "";//服务器图片保存路径,全局变量
var ftp = "";
$(function(){
	$(".openNew").change(function(){
		if($(this).val().match("是")){
			validform5(".addBt","formInput",false,5);
		}
	});
});

$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/noviceExperience/getFtp.do",
		success : function(msg) {
			ftp = msg;
		}
	});
});
/**
 * 修改新手体验标
 */
$(function () {
	$("#mod").bind('click', function () {
		$("#formInput").submit();
	});
	
	$.ajax({
		type : 'post',
		url : appPath + "/noviceExperience/query.do",
		success : function (msg) {
			if (msg != null) {
				$("#statu").find("option[value='"+msg.statu+"']").attr("selected",true);
				$("#productType").find("option[value='"+msg.projectID+"']").attr("selected",true);
				$("#repayWay").find("option[value='"+msg.repayWay+"']").attr("selected",true);
				$("#deadlineType").find("option[value='"+msg.deadlineType+"']").attr("selected",true);
				$("#experienceDescribe").val(msg.experienceDescribe);
				$("#experienceName").val(msg.experienceName);
				$("#yearRates").val(msg.yearRates);
				$("#deadline").val(msg.deadline);
				$("#vouchersAmounts").val(msg.vouchersAmounts);
				var str = "<div id=\"WU_FILE_5\" class=\"file-item thumbnail upload-state-done\">"+
								"<img src=\""+ ftp + msg.experienceUrl+"\">"+
								"<div class=\"file-panel\"><span class=\"cancel\">删除</span></div>"+
							"</div>";
				$(".con1").html(str);
			}
		}
	});
});

function modNew() {
	
	var statu = $("#statu").val();
	var experienceDescribe = $("#experienceDescribe").val();
	var experienceName = $("#experienceName").val();
	var productType = $("#productType").val();
	var repayWay = $("#repayWay").val();
	var yearRates = $("#yearRates").val();
	var deadline = $("#deadline").val();
	var deadlineType = $("#deadlineType").val();
	var vouchersAmounts = $("#vouchersAmounts").val();
	var experienceUrl = uploadUrl;
	
	//加密
	statu = encrypt.encrypt((statu + ""));
	experienceDescribe = encrypt.encrypt((experienceDescribe + ""));
	experienceName = encrypt.encrypt((experienceName + ""));
	productType = encrypt.encrypt((productType + ""));
	repayWay = encrypt.encrypt((repayWay + ""));
	yearRates = encrypt.encrypt((yearRates + ""));
	deadline = encrypt.encrypt((deadline + ""));
	deadlineType = encrypt.encrypt((deadlineType + ""));
	vouchersAmounts = encrypt.encrypt((vouchersAmounts + ""));
	experienceUrl = encrypt.encrypt((experienceUrl + ""));
	
	$.ajax({
		type : 'post',
		url : appPath + "/noviceExperience/modNew.do",
		data : {
			statu : statu,
			experienceDescribe : experienceDescribe,
			experienceName : experienceName,
			productType : productType,
			repayWay : repayWay,
			yearRates : yearRates,
			deadline : deadline,
			deadlineType : deadlineType,
			vouchersAmounts : vouchersAmounts,
			experienceUrl : experienceUrl
		},
		success : function (msg) {
			if (msg == 1) {
				layer.alert("添加成功",{icon:1});  
				document.getElementById("formInput").reset();
				setTimeout('location.reload()',2000);
			}else {
				layer.alert("服务器异常",{icon:2});
				document.getElementById("formInput").reset();
			}
		}
	});
}

$(function () {
	$.ajax({
		type : 'post',
		url : appPath + "/noviceExperience/queryType.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function (i, item) {
				str += "<option value=\""+item.id+"\">"+item.projectName+"</option>";
			})
			$("#productType").html(str);
		}
	});
});
$(function(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
	    // 选择文件的按钮。可选。
	    pick: '#filePicker',											//个数限制
	    fileNumLimit: 1,												//个数限制
		//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。
		fileSingleSizeLimit: 1024*512,
	    accept: {														//只允许选择图片文件
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    },                                                              //超出则不允许加入队列。
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
        thumbnailWidth = 250 * ratio,
        thumbnailHeight = 150 * ratio,
	    
	    uploader.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            $img.replaceWith('<span style="width:250px;height:150px;display:inline-block;">不能预览</span>');
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
	uploader.on( 'uploadSuccess', function( file, imgUrl ) {
	    $( '#'+file.id ).addClass('upload-state-done');
	    var result = imgUrl._raw;
		uploadUrl=result.split(",")[1];
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