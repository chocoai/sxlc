/*项目管理----成交项目列表----贷后监管*/
$(function(){
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					url: appPath+"/project/getProAfterLoanListData",   
					dataSrc: "results", 
					type: "POST",
					data: function ( d ) {
						//加密
						var startTime = $("#startDate").val();
						var endTime = $("#endDate").val();
						var projectID =$("#projectID").val(); 
						
						d.startTime = encrypt.encrypt(startTime);
						d.endTime = encrypt.encrypt(endTime);
						d.projectID = encrypt.encrypt(projectID);
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"添加时间","data": "recordDate"},  
				          { title:"摘要","data": "abstracts", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data==null){
				        		  		return "";
				        	  		}else if(data.length>8){//当内容长度大于8时隐藏详细信息
				        	    		return ' <a href="javascript:;" onclick="showText(this)" title="摘要">'+data.substring(0,7)+'...</a>';
				        	    	}else {
				        	    		return data;
				        	    	} 
				        	  }
				          },  
				          { title:"详细描述","data": "detail", 
				        	  "mRender": function (data, type, full) {
				        			if(data==null){
				        		  		return "";
				        	  		}else if(data.length>8){//当内容长度大于8时隐藏详细信息
				        	    		return ' <a href="javascript:;" onclick="showText1(this)" title="详细描述">'+data.substring(0,7)+'...</a>';
				        	    	}else {
				        	    		return data;
				        	    	} 
				        	  }
				          },  
				          { title:"操作","data": "", 
				        	  "mRender": function (data, type, full) {
					        		return '<a href="javascript:void(0);" onclick="deleteData('+full.id+')" class="invest-fee-del">删除</a>';
					        	  }
				          }
				          ],
 			  aaSorting :[[ 1, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 2, 3, 4]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页
	          searching: false,
	          scrollCollapse: true,
	          scrollX : "100%",
	          scrollXInner : "100%",scrollY:500,
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          },
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#table_id tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#table_id tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	
	 /**
	  * 查询按钮
	  */
	 $(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
		
	 });
	
	validform5(".layui-layer-btn0","dataForm",false,"5");
	 
	/*添加贷后信息*/
	$(".obtn-addmsg").on("click touchstart",function(){
		 //清除数据
		 $("#abstractMain").val("");
		 $("#details").val("");
		 $("#recordDate").val("");
		 $("#fileName").val("");
		 $("#fileList1").html("");
		
		layer.open({
		    type: 1,
		    area: ['600px', '500px'], //高宽
		    title: "添加贷后信息",
		    content: $(".addmsg"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				$("#dataForm").submit();
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
	});
	
	/*贷后信息查询*/
	$(".obtn-searchmsg").on("click touchstart",function(){
		 var data = $('#table_id').DataTable().rows('.selected').data();
		 if(data.length<1){
				layer.alert("请选择要查询的贷后信息！",{icon:0});
				return;
		 }
		 //清除数据
		 $(".abstractMain").val("");
		 $(".details").val("");
		 $(".recordDate").val("");
		 $(".showFileList").html("");
		 var infoId =data[0].id;
		 $.ajax( {  
			url:appPath+"/project/getProjectAfterLoandetail",
			data:{"infoId":encrypt.encrypt(infoId+"")},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) {
				$(".abstracts").html(data.abstracts);
				$(".detail").html(data.detail);
				$(".recordDate").html(data.recordDate);
				var list=data.attaches;
				for(var i in data.attaches){
					var attachTitle = list[i].attachTitle;
					var attachUrl = $("#hostPath").val()+""+list[i].attachUrl;
					var attachIndex = list[i].attachIndex;
					$(".showFileList").append("<div> <span>"+attachTitle+"</span>: " +
							"<img height='100' width='100' src='"+attachUrl+"'></div>");
				}
//				//绑定事件
//				 $(".imgDisplay").mouseover(function(){
//					 $(this).children(".file-panel").css("height","30px");
//				 });
//				 $(".imgDisplay").mouseout(function(){
//					 $(this).children(".file-panel").css("height","0");
//				 });
//				 //点击删除图标
//				 $(".deleteBtn").click(function(){
//					 $this.parent().parent(".imgDisplay").remove();
//				 });
				 layer.open({
					    type: 1,
					    area: ['500px', '300px'], //高宽
					    title: "贷后信息查询",
					    content: $(".searchmsg"),//DOM或内容
					    btn:['关闭']
						 ,cancel: function(index){
						  	//取消的回调
						  }
					});
				 
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
		
	});
	/*删除*/
    $(".btn-del").on('click',function(){
    	layer.confirm('确定要删除该条记录吗？', {
			btn: ['确定', '取消']
		}, function(index, layero){    //点确定回调
			
		}, function(index){    //点取消回调
			
		});
    });
});

var uploadUrl = "";//服务器图片保存路径,全局变量
//初始化
$(function(){
	$(".filePicker").each(function(i,obj){
		 var filePicker ="filePicker"+(i+1);
		 var fileListObj = $(this).parent().parent().parent().parent().find(".fileList");
		 var inputObj = $(this).prev("input");
		 UploadImg(filePicker,fileListObj,3,inputObj,220,110);
	});
});


/**
* 图片上传公共方法
* 选择图片对应id    filePicker 
* 图片存放div对象  
* 图片上传个数限制   1或者其他 
* 图片宽度		  imgWidth;			
* 图片高度    	  imgHeight 	
* 服务器返回路径保存的隐藏input元素的对象 inputObj 
*/
function UploadImg(filePicker,fileListObj,imgNum,inputObj,imgWidth,imgHeight) {
		//上传初始化
		var piker = '#'+filePicker+'';
		//上传初始化
		var uploader = WebUploader.create({
			auto: true,														//选完文件后，是否自动上传。
		    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
		    server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
		    // 选择文件的按钮。可选。
		    pick: piker,											//内部根据当前运行是创建，可能是input元素，也可能是flash.
		    fileNumLimit: imgNum,												//个数限制
			//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。
		    fileSingleSizeLimit: 5*1024*1024, //1M  
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
		                '<div class="info">' + $("#fileName").val() + '</div>' +
		            '</div>'
		            ),
		    	$del = $del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
		        $img = $li.find('img');
		
		
		    // $list为容器jQuery实例
		    $list = fileListObj;
		   // $list.empty();
		    $list.append( $li );
		    $del.appendTo( $li );
		    
		    //预览时操作面板显隐
		    $list.children(".file-item").each(function(){
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
	        thumbnailWidth = imgWidth * ratio,
	        thumbnailHeight = imgHeight * ratio,
		    
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
		
		 uploader.on( 'beforeFileQueued', function( file ) {
			 var fileName = $("#fileName").val();
			 if(fileName !=null && fileName != ""){
				 return true;
			 }else{
				 layer.alert("附件名不能为空",{icon:0});  
				 return false;
			 }
	     });
		
		// 文件上传成功，给item添加成功class, 用样式标记上传成功。
		uploader.on( 'uploadSuccess', function( file,json ) {
			var result = json._raw;
			uploadUrl=result.split(",")[1];
			var fileName= $("#fileName").val();
			var newValue = fileName+","+uploadUrl;
			var oldValue = $("#affix").val();
			if(oldValue !=null && oldValue != ""){
				$("#affix").val(oldValue+";"+newValue);
			}else{
				$("#affix").val(newValue);
			}
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
		
};


/**
 * 简介弹出框显示
 */
function showText(btn){
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	layer.open({
	    type: 1,
	    area: ['400px', '300px'], //高宽
	    title: "摘要",
	    content: data.abstracts,//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});
};
function showText1(btn){
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	layer.open({
		type: 1,
		area: ['400px', '300px'], //高宽
		title: "详细描述",
		content: data.detail,//DOM或内容
		btn:['关闭']
	,cancel: function(index){
		//取消的回调
	}
	});
};



/**
 * 删除
 */
function deleteData(param){
	layer.confirm('确定删除该条信息？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
			$.ajax( {  
				url:appPath+"/project/delProAfterLoanInfo",
				data:{"infoId":encrypt.encrypt(param+"")},
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					if(data>0){
						layer.alert("操作成功",{icon:1});
						var table = $('#table_id').DataTable();
						table.ajax.reload();
					}else if(data==0){
						layer.alert("操作失败",{icon:2});  
					}
				},  
				error : function() {  
					layer.alert("服务器异常",{icon:2});  
				}  
			});					
		  	layer.close(index);
		}, function(index){
		});
}

function addMsg(){
	  //确定的回调
	  var updateData = {};
	  var applyID = $("#projectID").val();
	  var abstractMain = $("#abstractMain").val();
	  var details = $("#details").val();
	  var affix = $("#affix").val();
	  if(affix ==""){
		  layer.alert("请上传附件",{icon:0});
		  return;
	  }
	  updateData.applyID=encrypt.encrypt(applyID);
	  updateData.abstractMain=encrypt.encrypt(abstractMain);
	  updateData.details=encrypt.encrypt(details);
	  updateData.affix=encrypt.encrypt(affix);

	  $.ajax( {  
		  url:appPath+"/project/insertProjectAfterLoanInfo",
		  data:updateData,
		  type:'post',  
		  cache:false,  
		  dataType:'json',  
		  success:function(data) {
			  if(data==1){
				  layer.alert("操作成功",{icon:1});
				  var table = $('#table_id').DataTable();
				  table.ajax.reload();
				  $(".layui-layer-btn1").click();
			  }else if(data==0){
				  layer.alert("操作失败",{icon:2});  
			  }
		  },  
		  error : function() {  
			  layer.alert("服务器异常",{icon:2});  
		  }  
	  });
}