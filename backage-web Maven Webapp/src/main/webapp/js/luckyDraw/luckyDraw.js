var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
var uploadUrl = "";//服务器图片保存路径,全局变量
/*  添加抽奖设置      */
function addLuckyDraw(){
	$.ajax({
		type : 'post',
		url : appPath + "/lottery/selectGrade.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<option value=\""+item.grade+"\">"+item.grade+"</option>";
			});
			$("#grade").html(str);
		}
	});
	
	$.ajax({
		type : 'post',
		url : appPath + "/lottery/selectPrizeTypes.do",
		success : function (msg) {
			var str = "";
			$.each(msg, function(i, item) {
				str += "<option value=\""+item.prizeType+"\">"+item.prizeType+"</option>";
			});
			$("#prizeType").html(str);
		}
	});
	layer.open({
		type: 1,
		area: ['550px', '420px'], //高宽
		title: "修改附件",
		maxmin: true,
		content: $("#addluckyDraw")//DOM或内容
	});
}

$("#add").bind('click', function () {
	$("#addluckyInfo").submit();
});
function addDraw() {
	
}
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
	uploader.on( 'uploadSuccess', function( file,imgUrl ) {
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
$(function(){
	validform5(".addBtn","addluckyInfo",false,3);
	$(".cancelBtn").bind("click",function(){
		layer.closeAll();
	});
});

/**
 * 删除奖品
 */

$(function () {
	var appPath = getRootPath();//项目根路径
	//删除部门
	$(".obtn-dept-del").on("click touchstart",function(){
		//获得选取的对象
		
		layer.confirm('确定删除该奖品？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //确定的回调
		  var rowdata = $('#applicationAudit').DataTable().rows('.selected').data();
		  //加密操作
		  var result = encrypt.encrypt(rowdata[0].prizeID + "");
		  $.ajax({
		  	type : 'post',
		  	url : appPath + "/role/delete.do",
		  	data : {deptId : result},
		  	success : function (msg) {
		  		if (msg == 1) {
		  			layer.alert("删除成功!",{icon:1});
		  			setTimeout('location.reload()',2000);
		  		}
		  	},
		  	error : function() {  
		           layer.alert("操作失败!",{icon:2});  
		    } 
		  });
			
			layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
	});
});

//表格初始化
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#applicationAudit').DataTable(
	{
		autoWidth : false,
		scrollY : 500,
		pagingType: "simple_numbers",//设置分页控件的模式  
		lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
        ajax: {  
            "url": appPath + "/lottery/luckyDrawList.do",   
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
                  { title:"奖品ID","data": "prizeID" },
                  { title:"奖品等级","data": "grade" }, 
                  { title:"奖品类型","data": "prizeType" },
                  { title:"奖品名称","data": "prizeName" },
                  { title:"奖品价值(元)","data": "prizeWorths" },
                  { title:"奖品剩余数量","data": "prizeQuantity" },
                  { title:"中奖概率基数","data": "winningOdds" },
                  { title:"奖品图片","data": "prizeUrl" }
                  
        ],
        aoColumnDefs : [
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				}
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
        }
});
 var table = $('#applicationAudit').DataTable();
//设置选中change颜色
 $('#applicationAudit tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
  });
});