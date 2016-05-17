$(function() {
	//历史审核记录表格
	$('#table_history_record').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getProChkRecordData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {  
						var applyId = $("#applyId").val();
						d.applyId = encrypt.encrypt(applyId);  
					}  
				},
				columns: [ 
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"审核管理员名称","data": "adminName"},  
				          { title:"审核点","data": "apName"},  
				          { title:"审核时间","data": "checkDate"},  
				          { title:"审核状态","data": "checkStatu", 
				        	  "mRender": function (data, type, full) {
				        		  if(data == 1){
				        			  return "通过";
				        		  }else if(data == -1){
				        			  return "打回";
				        		  }else if(data == -2){
				        			  return "已通过审核且返回补充材料";
				        		  }else if(data == -3){
				        			  return "需补充材料";
				        		  }else{
				        			  return "";
				        		  }
				        	  }
				          },  
				          { title:"审核意见","data": "checkRemark"}
				          ],
	          aoColumnDefs : [
//	                          {"bVisible": false, "aTargets": [ 1,2]}, //控制列的隐藏显示
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" :  [ 0, 1, 2, 3, 4, 5]
	                          } // 制定列不参与排序
	                          ],
              pagingType: "simple_numbers",//设置分页控件的模式  
              info : false,//左下角信息
              processing: true, //打开数据加载时的等待效果  
              serverSide: true,//打开后台分页  
              scrollCollapse: true,
//	          scrollX : "100%",
//			  scrollXInner : "100%",
              rowCallback:function(row,data){//添加单击事件，改变行的样式      
              }
	});//表格初始化完毕
	 
	//表格单选效果(有复选框)
	 $('#table_history_record tbody').on( 'click', 'tr', function () {
		    var $this = $(this);
		    var $checkBox = $this.find("input:checkbox");
	        if ( $this.hasClass('selected') ) {
	        	 $checkBox.prop("checked",false);
	        	$this.removeClass('selected');
	        } else {
	        	$(".tr-checkbox").prop("checked",false);
	        	$checkBox.prop("checked",true);
	        	$('#table_history_record tr.selected').removeClass('selected');
	        	$this.addClass('selected');
	        }
	  });
	 
	//历史审核附件表格
	 $('#table_history_enclosure').DataTable(
				{	
					ajax: {  
						"url": appPath+"/project/getCheckAttachData",   
						"dataSrc": "results", 
						"type": "POST",
						"data": function ( d ) {  
							var applyId = $("#applyId").val();
							d.applyId = encrypt.encrypt(applyId);  
						}  
					},
					columns: [ 
					          {title:'',sWidth:"3%", 
					        	  "mRender": function (data, type, full) {
					        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
					        		  return sReturn;
					        	  }
					          },
					          { title:"附件名称","data": "attachTitle"},  
					          { title:"上传审核点","data": "addapName"},  
					          { title:"上传审核管理员名称","data": "adminName"},  
					          { title:"上传时间","data": "dealDate"},  
					          { title:"备注","data": "dealRecord"},
					          { title:"操作","data": "", 
					        	  "mRender": function (data, type, full) {
					        		    return '<a href="javascript:void(0);" class="btn-delete" onclick="del('+full.appCheckId+','+full.attachIndex+')">删除</a>&nbsp;&nbsp;'
					                			+'<a href="javascript:;void(0)" class="btn-delete" onclick="down()">下载</a>';
					        	  }
					          }
					          ],
		          aoColumnDefs : [
//		                          {"bVisible": false, "aTargets": [ 1,2]}, //控制列的隐藏显示
		                          {
		                        	  "orderable" : false,
		                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6]
		                          } // 制定列不参与排序
		                          ],
	              pagingType: "simple_numbers",//设置分页控件的模式  
	              info : false,//左下角信息
	              processing: true, //打开数据加载时的等待效果  
	              serverSide: true,//打开后台分页  
	              scrollCollapse: true,
//		          scrollX : "100%",
//				  scrollXInner : "100%",
	              rowCallback:function(row,data){//添加单击事件，改变行的样式      
	              }
		});//表格初始化完毕
		 
		//表格单选效果(有复选框)
		 $('#table_history_enclosure tbody').on( 'click', 'tr', function () {
			    var $this = $(this);
			    var $checkBox = $this.find("input:checkbox");
		        if ( $this.hasClass('selected') ) {
		        	 $checkBox.prop("checked",false);
		        	$this.removeClass('selected');
		        } else {
		        	$(".tr-checkbox").prop("checked",false);
		        	$checkBox.prop("checked",true);
		        	$('#table_history_enclosure tr.selected').removeClass('selected');
		        	$this.addClass('selected');
		        }
		  });
		 
	
		//附件删除记录表格
		 $('#table_history_del').DataTable(
					{	
						ajax: {  
							"url": appPath+"/project/getChkAttachDelData",   
							"dataSrc": "results", 
							"type": "POST",
							"data": function ( d ) {  
								var applyId = $("#applyId").val();
								d.applyId = encrypt.encrypt(applyId);  
							}  
						},
						columns: [ 
						          {title:'',sWidth:"3%", 
						        	  "mRender": function (data, type, full) {
						        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
						        		  return sReturn;
						        	  }
						          },
						          { title:"附件名称","data": "attachTitle"},  
						          { title:"上传审核点","data": "deleteapName"},  
						          { title:"操作删除管理员名称","data": "adminName"},  
						          { title:"删除时间","data": "dealDate"},  
						          { title:"备注","data": "dealRecord"}
						          ],
			          aoColumnDefs : [
//			                          {"bVisible": false, "aTargets": [ 1,2]}, //控制列的隐藏显示
			                          {
			                        	  "orderable" : false,
			                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5]
			                          } // 制定列不参与排序
			                          ],
		              pagingType: "simple_numbers",//设置分页控件的模式  
		              info : false,//左下角信息
		              processing: true, //打开数据加载时的等待效果  
		              serverSide: true,//打开后台分页  
		              scrollCollapse: true,
//			          scrollX : "100%",
//					  scrollXInner : "100%",
		              rowCallback:function(row,data){//添加单击事件，改变行的样式      
		              }
			});//表格初始化完毕
			 
			//表格单选效果(有复选框)
			 $('#table_history_del tbody').on( 'click', 'tr', function () {
				    var $this = $(this);
				    var $checkBox = $this.find("input:checkbox");
			        if ( $this.hasClass('selected') ) {
			        	 $checkBox.prop("checked",false);
			        	$this.removeClass('selected');
			        } else {
			        	$(".tr-checkbox").prop("checked",false);
			        	$checkBox.prop("checked",true);
			        	$('#table_history_del tr.selected').removeClass('selected');
			        	$this.addClass('selected');
			        }
			  });
			 
	 /**
	  * 发布按钮
	  */
	 $(".postBtn").on("click",function(){
		 var data ={};
		 var ApplyId = $("#applyId").val();
		 var Indexsnow = $("#Indexsnow").val();
		 var checkStatu = "1";//审核结果 1：通过 -1：打回
		 var startDate = $("#startDate").val();
		 var endDate = $("#endDate").val();
		 var affix = $("#affix").val();//附件列表
		 var ImageUrl = $("#ImageUrl").val();//企业形象图url 
		 if(startDate =="" || endDate == ""){
			 layer.alert("请选择项目起止时间",{icon:0});
			 return;
		 }
		 data.ApplyId= encrypt.encrypt(ApplyId);
		 data.Indexsnow= encrypt.encrypt(Indexsnow);
		 data.checkStatu= encrypt.encrypt(checkStatu);
		 data.startDate= encrypt.encrypt(startDate);
		 data.endDate= encrypt.encrypt(endDate);
		 data.affix= encrypt.encrypt(affix);
		 data.ImageUrl= encrypt.encrypt(ImageUrl);
		 $.ajax( {  
				url:appPath+"/project/publishProject",
				data:data,
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					if(data>0){
						layer.alert("发布成功！",{icon:1});
					}else if(data==0){
						layer.alert("未找到要发布的项目",{icon:2});  
					}else if(data==-1){
						layer.alert("该项目已发布，请重新选择未发布的项目",{icon:0});  
					}else if(data==-3){
						layer.alert("该项目该审核批次已审核",{icon:0});  
					}
				},  
				error : function() {  
					layer.alert("服务器异常",{icon:2});  
				}  
			});		
	 });
	 
	 /**
	  * 审核提交按钮
	  */
	 $(".chkSubmitBtn").on("click",function(){
		 var data ={};
		 var ApplyId = $("#applyId").val();
		 var Indexsnow = $("#Indexsnow").val();
		 var checkStatu = $(".auditResult").val();
		 var CheckRemark = $("#CheckRemark").val();
		 var affix = $("#affixChk").val();//附件列表
		 
		 data.ApplyId= encrypt.encrypt(ApplyId);
		 data.Indexsnow= encrypt.encrypt(Indexsnow);
		 data.checkStatu= encrypt.encrypt(checkStatu);
		 data.CheckRemark= encrypt.encrypt(CheckRemark);
		 data.affix= encrypt.encrypt(affix);
		 $.ajax( {  
			 url:appPath+"/project/projectAudit",
			 data:data,
			 type:'post',  
			 cache:false,  
			 dataType:'json',  
			 success:function(data) { 
				 if(data==1){
					 layer.alert("审核成功！",{icon:1});
					 window.history.back();
				 }else if(data==0){
					 layer.alert("未找到要审核的项目",{icon:2});  
				 }else if(data==-1){
					 layer.alert("该项目已审核通过",{icon:0});  
				 }else if(data==-3){
					 layer.alert("该项目该审核批次已审核",{icon:0});  
				 }else if(data==-4){
					 layer.alert("上一级审核未通过",{icon:0});  
				 }
			 },  
			 error : function() {  
				 layer.alert("服务器异常",{icon:2});  
			 }  
		 });		
	 });
	 
	 
	/**
	 * 取消按钮
	 */
	$(".cancleAndReturn").on("click",function(){
		window.history.back();
	});
			 
			 
	 
});

/**
 * 删除历史审核附件
 * @param appCheckId 审核记录ID
 * @param attachIndex 附件编号
 */
function del(appCheckId,attachIndex){
	layer.confirm('确定删除该附件？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
			$.ajax( {  
				url:appPath+"/project/delProChkAttach",
				data:{"appCheckId":encrypt.encrypt(appCheckId+""),"attachIndex":encrypt.encrypt(attachIndex+"")},
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					if(data>0){
						layer.alert("操作成功",{icon:1});
						var table = $('#table_history_enclosure').DataTable();
						table.ajax.reload();
					}else if(data==0){
						layer.alert("操作失败,删除0条数据",{icon:2});  
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

/**
 * 下载历史审核附件
 * @param appCheckId 审核记录ID
 * @param attachIndex 附件编号
 */
function down(appCheckId,attachIndex){
	
}

/*********修改切换*********/
$(function(){
	$(".btnMod").click(function(){
		$(".infoMod").show();
		$(".infoDisplay").hide();
	});
	
	//项目基本信息修改保存
	$(".btnPreserve").click(function(){
		var data = {};
		var ApplyId = $("#applyId").val();
		var projectTitle = $("#projectTitle").val();
		var uses = $("#uses").val();
		var repaySource = $("#repaySource").val();
		var amount = $("#amount").val();
		var projectDescript = $("#projectDescript").val();
		var deadline = $("#deadline").val();
		var deadlineType = $("#deadlineType").val();
		var repayWay = $("#repayWay").val();
		var yearRate = $("#yearRate").val();
		var minStart = $("#minStart").val();
		var increaseRange = $("#increaseRange").val();
		var investMax = $("#investMax").val();
		var investCountMax = $("#investCountMax").val();
		var RepayGuarantee = $("#RepayGuarantee").val();
		
		data.ApplyId=encrypt.encrypt(ApplyId);
		data.projectTitle=encrypt.encrypt(projectTitle);
		data.uses=encrypt.encrypt(uses);
		data.repaySource=encrypt.encrypt(repaySource);
		data.amount=encrypt.encrypt(amount);
		data.projectDescript=encrypt.encrypt(projectDescript);
		data.deadline=encrypt.encrypt(deadline);
		data.deadlineType=encrypt.encrypt(deadlineType);
		data.repayWay=encrypt.encrypt(repayWay);
		data.yearRate=encrypt.encrypt(yearRate);
		data.minStart=encrypt.encrypt(minStart);
		data.increaseRange=encrypt.encrypt(increaseRange);
		data.investMax=encrypt.encrypt(investMax);
		data.investCountMax=encrypt.encrypt(investCountMax);
		data.RepayGuarantee=encrypt.encrypt(RepayGuarantee);
		
		$.ajax( {  
			url:appPath+"/project/updateProjectDetail",
			data:data,
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data=1){
					layer.alert("操作成功",{icon:1});
					location.reload(true);//暂时刷新 
//					$(".infoDisplay").show();
//					$(".infoMod").hide();
				}else if(data==0){
					layer.alert("未找到要修改的项目",{icon:2});  
				}else if(data==-2){
					layer.alert("该项目名称已存在",{icon:0});  
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});		
	});
	$(".btnCancel").click(function(){
		$(".infoDisplay").show();
		$(".infoMod").hide();
	});
});


/**
 * 上传项目形象图片
 */
$(function(){
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
	    	$del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
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
		var picUrl=result.split(",")[1];
		$("#ImageUrl").val(picUrl);
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



/**
 * 项目前台显示图片
 */
$(function(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
	    // 选择文件的按钮。可选。
	    pick: '#filePicker1',											//内部根据当前运行是创建，可能是input元素，也可能是flash.
	    fileNumLimit: 10,												//个数限制
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
	                '<div class="info">' + $("#fileName").val() + '</div>' +
	            '</div>'
	            ),
	        	$del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
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
	            $img.replaceWith('<div>不能预览</div>');
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
			 layer.alert("文件名不能为空",{icon:0});  
			 return false;
		 }
     });
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {
		var result = json._raw;
		var uploadUrl=result.split(",")[1];
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
	
	
});

/**
 *	项目审核附件
 */
$(function(){
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
		swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
		server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
		// 选择文件的按钮。可选。
		pick: '#filePicker2',											//内部根据当前运行是创建，可能是input元素，也可能是flash.
		fileNumLimit: 10,												//个数限制
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
				'<div class="info">' + $("#attachName").val() + '</div>' +
				'</div>'
		),
		$del = $('<div class="file-panel"><span class="cancel">删除</span></div>'),
		$img = $li.find('img');
		
		
		// $list为容器jQuery实例
		$list = $("#fileList2");
		$list.append( $li );
		$del.appendTo( $li );
		
		//预览时操作面板显隐
		$("#fileList2 .file-item").each(function(){
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
				$img.replaceWith('<div>不能预览</div>');
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
		var fileName = $("#attachName").val();
		if(fileName !=null && fileName != ""){
			return true;
		}else{
			layer.alert("文件名不能为空",{icon:0});  
			return false;
		}
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {
		var result = json._raw;
		var uploadUrl=result.split(",")[1];
		var fileName= $("#attachName").val();
		var newValue = fileName+","+uploadUrl;
		var oldValue = $("#affixChk").val();
		if(oldValue !=null && oldValue != ""){
			$("#affixChk").val(oldValue+";"+newValue);
		}else{
			$("#affixChk").val(newValue);
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
	
	
});