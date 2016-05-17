$(function() {	
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getLoanManageData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var Project_No = encrypt.encrypt($(".Project_No").val());
						var Amount_Min = encrypt.encrypt($(".Amount_Min").val());
						var Amount_Max = encrypt.encrypt($(".Amount_Max").val());
						var Personal_Name = encrypt.encrypt($(".Personal_Name").val());
						var Record_Date_Min = encrypt.encrypt($(".Record_Date_Min").val());
						var Record_Date_Max = encrypt.encrypt($(".Record_Date_Max").val());
						var Logname = encrypt.encrypt($(".Logname").val());
						var Deadline = encrypt.encrypt($(".Deadline").val());
						var Deadline_Type = encrypt.encrypt($(".Deadline_Type").val());
						
						d.Project_No = Project_No;
						d.Amount_Min = Amount_Min;
						d.Amount_Max = Amount_Max;
						d.Personal_Name = Personal_Name;
						d.Record_Date_Min = Record_Date_Min;
						d.Record_Date_Max = Record_Date_Max;
						d.Logname = Logname;
						d.Deadline = Deadline;
						d.Deadline_Type = Deadline_Type;
						
						//设置后台排序参数
						d.ordercolumn = encrypt.encrypt("RECORD_DATE");//排序字段 AMOUNT  RECORD_DATE  INVEST_RATE
						d.orderDsec = encrypt.encrypt(0+"");//1:ASC 0:DESC
						//设置查询页面类型
						d.pgType = encrypt.encrypt("4");
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"项目编号","data": "projectNo"},  
				          { title:"借款人用户名","data": "logname"},  
				          { title:"借款人姓名","data": "memberName"},  
				          { title:"项目名称","data": "projectBaseInfoentity.projectTitle"},  
				          { title:"产品类型","data": "projectName"},  
				          { title:"借款期限","data": "projectBaseInfoentity", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data.deadlineTypes == 0){
				        	    		return data.deadline+"天";
				        	    	}else if(data.deadlineTypes == 1){
				        	    		return data.deadline+"月";
				        	    	}else if(data.deadlineTypes == 2){
				        	    		return data.deadline+"年";
				        	    	}else{
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"借款金额","data": "projectBaseInfoentity.amount"},  
				          { title:"年化利率","data": "projectBaseInfoentity.yearRate"},  
				          { title:"项目发布日期","data": "releaseDate"},  
				          { title:"投标开始结束日期","data": "checkDate", 
				        	  "mRender": function (data, type, full) {
				        		  	return full.startDate+"~"+full.endDate; 
				        	  }
				          },
				          { title:"借款进度(%)","data": "investRates"}  
				          ],
 			  aaSorting : [[ 7, "desc"],[ 11, "desc"]],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 8, 9, 10]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          scrollCollapse: true,
	          scrollX : "100%",
			  scrollXInner : "100%",
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
});		

$(function(){
	//修改审核附件信息
	$('#investing_modify').click(function(){
		
	});
//	查看投资记录
	$('.investing_invest_record').click(function(){
		 var data = $('#table_id').DataTable().rows('.selected').data();
		 if(data.length<1){
				layer.alert("请选择项目！",{icon:0});
				return;
		 }
		 $("#applyID").val(data[0].applyId);
    	layer.open({
            type: 2,
            title: '投资记录',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: appPath+'/project/toInvestRecordPg'
        });
	});
});

$(function(){
	validform5(".layui-layer-btn0","formInput",false,"3");
});

/* 弹出层中展示附件删除2016-5-9伍成然 */
$(function(){
	$(".imgDisplay").mouseover(function(){
		$(this).children(".file-panel").css("height","30px");
		$(this).children().children(".cancel").click(function(){
			$(this).parent().parent(".imgDisplay").remove();
		});
	});
	$(".imgDisplay").mouseout(function(){
		$(this).children(".file-panel").css("height","0");
	});
});

/*  修改审核附件      */
function alertAudit(){
	 var data = $('#table_id').DataTable().rows('.selected').data();
	 if(data.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
	 }
	 //清除数据
	 $("#affix").val("");
	 $("#deleteaffix").val("");
	 $("#fileName").val("");
	 $("#fileList").html("");
	 $(".fileList").html("");
	 
	 var projectID =data[0].applyId;
	 $.ajax( {  
		url:appPath+"/project/getChkAttachData",
		data:{"projectID":encrypt.encrypt(projectID+"")},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) {
			for(var i in data){
				var attachTitle = data[i].attachTitle;
				var attachUrl = $("#hostPath").val()+""+data[i].attachUrl;
				var attachIndex = data[i].attachIndex;
				$(".fileList").append("<div class='file-item thumbnail upload-state-done imgDisplay'> <img src='"+attachUrl
						+"'><div class='info'>"+attachTitle+"</div><div class='file-panel'><span class='cancel deleteBtn' attachIndex='"+attachIndex
						+"'>删除</span></div></div>");
			}
			//绑定事件
			 $(".imgDisplay").mouseover(function(){
				 $(this).children(".file-panel").css("height","30px");
			 });
			 $(".imgDisplay").mouseout(function(){
				 $(this).children(".file-panel").css("height","0");
			 });
			 //点击删除图标
			 $(".deleteBtn").click(function(){
				 var $this = $(this); 
				 var old = $("#deleteaffix").val();
				 var temp = $this.attr("attachIndex");
				 if(old !=null && old != ""){
					 $("#deleteaffix").val(old+";"+temp);
				 }else{
					 $("#deleteaffix").val(temp);
				 }
				 $this.parent().parent(".imgDisplay").remove();
			 });
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
	layer.open({
		type: 1,
		area: ['650px', '400px'], //高宽
		title: "修改附件",
		maxmin: true,
		content: $("#alertAudit"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		//确定的回调
		var updateData = {};
		updateData.ProjectAppId=encrypt.encrypt(projectID+"");
		var affix = $("#affix").val();
		updateData.affix=encrypt.encrypt(affix);
		var deleteaffix = $("#deleteaffix").val();
		updateData.deleteaffix=encrypt.encrypt(deleteaffix);
		
		 $.ajax( {  
				url:appPath+"/project/updateAffix",
				data:updateData,
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) {
					if(data==1){
						layer.alert("操作成功",{icon:1});
						$(".layui-layer-btn1").click();
					}else if(data==0){
						layer.alert("操作失败",{icon:2});  
					}
				},  
				error : function() {  
					layer.alert("服务器异常",{icon:2});  
				}  
			});
		
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}


$(function() {	
	//上传初始化
	var uploader = WebUploader.create({
		auto: true,														//选完文件后，是否自动上传。
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf文件路径
	    server: appPath+'/UpdateBsnLicense',	//文件接收服务端。
	    // 选择文件的按钮。可选。
	    pick: '#filePicker',											//个数限制
		//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。
	    resize: false													//不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	});
	
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + $("#fileName").val()+ '</div>' +
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
			 layer.alert("文件名不能为空",{icon:0});  
			 return false;
		 }
     });
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json  ) {
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
	
	
});
