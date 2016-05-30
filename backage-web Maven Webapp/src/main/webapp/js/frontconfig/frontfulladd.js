/**
 * 版块：前台界面配置-首页全屏弹出公告
 * 内容介绍：
 */
$(function() {
	validform5(".layui-layer-btn0","dataForm",false,5);
	//表格单选效果(有复选框)
	 $('#table_id tbody').on( 'click', 'tr', function () {
		 var $this = $(this);
			var $checkBox = $this.find("input:checkbox");
			 if ( $(this).hasClass('selected') ) {
				 $checkBox.prop("checked",false);
					$(this).removeClass('selected');
				}
				else {
					$('tr.selected').removeClass('selected');
					$this.siblings().find("input:checkbox").prop("checked",false);
					$checkBox.prop("checked",true);
					$(this).addClass('selected');
				}
			
	  });
	 showList();//显示
}); 

/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
});

/**
 * 停用启用首页全屏弹出公告
 * @param statu
 * @param id
 */
function stopOrStart(id,statu){
	var ms ="";
	if(statu==0){
		ms="确定停用？";
	}else{
		ms="确定启用？";
	}
	var status=statu;
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	var id = encrypt.encrypt(id+"");
	var statu = encrypt.encrypt(statu+"");
	layer.confirm(ms, {
		  btn: ['确定', '取消']
	}, function(index, layero){
		  //按钮【按钮一】的回调
		$.ajax({
			url : appPath+"/FirstPublic/ofSafetySet.do",
				data:{
					id:id,
					statu:statu
				},
				type : "post",
				dataType:"text",
			error : function() {
				alert('操作失败！');
				return;
			},
			success : function(data) {
				if(data == 1){
					//执行完关闭
					if(status==0){
						layer.alert("停用成功。",{icon:1});  
					}else{
						layer.alert("启用成功。",{icon:1});
					}
				  	layer.close(index);
					var table = $('#table_id').DataTable();
					table.ajax.reload();
				}else if(data == 0){
					if(status==1){
						layer.alert("停用失败。",{icon:2});
					}else{
						layer.alert("启用失败。",{icon:2});
					}
				}
			}
			});
			//执行完关闭
		  	layer.close(index);
		}, function(index){
		  //按钮【按钮二】的回调
		});
}


/**
 * 增加/修改操作
 * @param type 1：增加 2：修改
 * @returns
 */
function addOrUpdate(type){
	//清除数据
	document.getElementById("dataForm").reset();
	//上传插件初始化
	expUpload("#imgPath");
	$("#imgPath").attr("src","");
	$("#fileList").html("");
	$("#filePicker").html("选择图片");//清除样式
	//操作
	var title="";
	if(type==1){
		title="添加首页全屏弹出公告";
		$("#dataForm").attr("action","javascript:addOrModify(1)");
	}else if(type==2){
		title="修改首页全屏弹出公告";
		$("#dataForm").attr("action","javascript:addOrModify(2)");
		var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的首页全屏弹出公告！",{icon:0});
			return;
		}
		$("#bannerId").val(data[0].id);	
		$("#url").val(data[0].certificationUrl);	
		$("#imgPath").val(data[0].certificationPicture);
		$("#startDate").val(data[0].certificationStartTimes);
		$("#endDate").val(data[0].certificationEndTimes);
		appendImg(data[0].certificationPicture,$("#fileList"));
	}
	
	layer.open({
	    type: 1,
	    area: ['780px', '600px'], //高宽
	    title: title,
	    maxmin: true,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
//			  $("#portraitUrl").val(uploadUrl);
			  $("#dataForm").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}

/**
 * 增加或修改
 * @param type 1:增加  2：修改
 */
function addOrModify(type){
		//加密参数
		var data={};
		var url = encrypt.encrypt($("#url").val());
		data.url=url;
		var startDate = encrypt.encrypt($("#startDate").val());
		data.startDate=startDate;
		var endDate = encrypt.encrypt($("#endDate").val());
		data.endDate=endDate;
		var imgPath = encrypt.encrypt($("#imgPath").val());
		data.imgPath=imgPath;
		var bannerId = encrypt.encrypt($("#bannerId").val()+"");
		data.id=bannerId;
		var Posturl = appPath+"/FirstPublic/";
		if(type ==1){//添加
			Posturl +="saveSafetySet";
		}else{
			Posturl +="updateSafetySet";
		}
		$.ajax( {  
			url:Posturl,
			data:data,
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(type ==1 ){
					if(data==1){
						layer.alert("添加成功",{icon:1});
						$(".layui-layer-btn1").click();
						 var table = $('#table_id').DataTable();
						 table.ajax.reload();
					}else if(data==0){
						layer.alert("添加失败",{icon:2});  
					}
				}else{
					if(data==1){
						layer.alert("修改成功",{icon:1});
						$(".layui-layer-btn1").click();
						 var table = $('#table_id').DataTable();
						 table.ajax.reload();
					}else if(data==0){
						layer.alert("修改失败",{icon:2});  
					}
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}

/**
 * 追加图片
 * @param imgURL  		图片路劲
 * @param fileListObj	存放图片div 
 */
function appendImg(imgURL,fileListObj){
	var imgRealURL =$("#hostPath").val();
	if(imgURL==null || imgURL==""){
		return ;
	}else{
		imgRealURL+=imgURL;
	}
	var html = '<div  class="file-item thumbnail">' +
                '<img src="'+imgRealURL+'" style="width:580px;height:280px"/>' +
                '<div class="file-panel"><span class="cancel"></span></div>'+
            '</div>';
	fileListObj.append(html );
}


/**
 * 查看图片
 * @returns
 */
function viewPic(btn){
    var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
    if(data.url !=""){
    	$("#picView").attr("src",$("#hostPath").val()+data.certificationPicture);
    	$(".hideHtml").hide();
    }else{
    	$(".hideHtml").show();
    	$("#picView").attr("src","");
    }
	layer.open({
	    type: 1,
	    area: ['500px', '400px'], //高宽
	    title: "查看头像",
//	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}
/**
 * 列表
 */
function showList(){
	$('#table_id').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
//						searching : false,
				info : false,// 左下角信息
//						ordering: false,//排序
				lengthMenu:[10,20,50,100],
//						aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		            "url": appPath+"/FirstPublic/SafetySetList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		            	var title = $("#titles").val();
		            	var statu = $("#statu").val();
		            	title = encrypt.encrypt(title);
		            	statu = encrypt.encrypt(statu+"");
		            	d.statu = statu;
		            	d.title = title;
		            }  
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"添加时间","data": "certificationAddTimes" },
		                  { title:"公告图片","data": "sgPic", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this)">查看图片</a>';
				        	  }
				          }, 
		                  { title:"公告链接","data": "certificationUrl" }, 
		                  { title:"开始日期","data": "certificationStartTimes" },  
		                  { title:"截止日期","data": "certificationEndTimes" }, 
		                  { title:"最近一次操作管理员","data": "adminName" },  
		                  { title:"状态","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.statu==1){
		                		  sReturn = "<font >有效</font>";
		                	  }else{
		                		  sReturn = "<font color='red'>无效</font>";
		                	  }
		                  		return sReturn;
		                  	}
		                  }, 
		                  { title:"操作","mRender": function(data, type, full){
		                	  var sReturn ="";
		                	  if(on_off==true){
		                		  if(full.statu==1){
			                		  sReturn = "<a href='javascript:stopOrStart("+full.id+",0);' class='btn-enable'>停用</a>";
			                	  }else{
			                		  sReturn = "<a href='javascript:stopOrStart("+full.id+",1);' class='btn-disable'>启用</a>";
			                	  }
		                	  }else{
		                		  sReturn = "<a href='javascript:void(0);' class='btn-disable'></a>";
		                	  }
		                		  return sReturn;
		                  	}
		                }, 
		                  
		        ],
		        aoColumnDefs : [
		        				{"bVisible": false, "aTargets": []}, //控制列的隐藏显示
		        				{
		        					orderable : false,
		        					/*aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ]*/
		        				} // 制定列不参与排序
		        				],
		        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//		        	if($.inArray(data.DT_RowId,selected)!==-1){
//		        		$(row).addClass('selected'); 
//		        	}$("input[name=adminName]").val(adminName).attr("disabled",true);
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});
}

