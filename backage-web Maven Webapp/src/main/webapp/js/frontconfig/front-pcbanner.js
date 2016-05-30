/**
 * 版块：前台界面配置-pc宣传图片管理
 * 内容介绍：
 */
$(function() {
	UploadImg("#imgPath","#filePickers");
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
	 /**
	  * 查询按钮
	  */
	 $(".glyphicon-search").on("click",function(){
	 	$('#table_id').DataTable().ajax.reload();
	 });
}); 


/**
 * 停用启用轮播图
 * @param statu
 * @param id
 */
function stopOrStart(statu,id){
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
			url : appPath+"/homeBanner/ofHomeBanner.do",
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
				//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
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
 * 上移或者下移
 * id  1上  0 下
 * statu 状态
 */
function upOrDown(id,statu){
		var stutus =statu;
		var ms ="";
		if(statu==-1){
			ms="确定下移？";
		}else{
			ms="确定上移？";
		}
		//result 为加密后参数
		var statu = encrypt.encrypt(statu+"");
		var id = encrypt.encrypt(id+"");
		layer.confirm(ms, {
			  btn: ['确定', '取消']
		}, function(index, layero){
			  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/homeBanner/moveHomeBanner.do",
					data:{
						flag:statu,
						id:id
					},
					type : "post",
					dataType:"text",
				error : function() {
					alert('操作失败！');
					return;
				},
				success : function(data) {
					if(data >0){
						//执行完关闭
						if(stutus>0){
							layer.alert("上移成功。",{icon:1});  
						}else{
							layer.alert("下移成功。",{icon:1});  
						  
						}
						layer.close(index);
						var table = $('#table_id').DataTable();
						table.ajax.reload();
					}else {
						if(stutus>0){
							layer.alert("上移失败!",{icon:2});
						}else{
							layer.alert("下移失败!",{icon:2});
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
 * 删除
 * id  1上  0 下
 * statu 状态
 */
function deleteBanner(){
		var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要删除的事务！",{icon:0});
			return;
		}
		
		var id =data[0].id;
		var ms ="";
		ms="确定删除？";
		//result 为加密后参数
		var id = encrypt.encrypt(id+"");
		layer.confirm(ms, {
			  btn: ['确定', '取消']
		}, function(index, layero){
			  //按钮【按钮一】的回调
			$.ajax({
				url : appPath+"/homeBanner/deleteHomeBanner.do",
					data:{
						id:id
					},
					type : "post",
					dataType:"text",
				error : function() {
					alert('操作失败！');
					return;
				},
				success : function(data) {
					if(data >0){
						//执行完关闭
						layer.alert("删除成功。",{icon:1});  
					  	layer.close(index);
					  	var table = $('#table_id').DataTable();
						table.ajax.reload();
					}else {
						layer.alert("删除失败!",{icon:2});
					}
				}
				});
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
	$("#imgPath").attr("src","");
	$("#fileList").html("");
	$("#filePicker").html("选择图片");//清除样式
	//操作
	var title="";
	if(type==1){
		title="添加首页宣传图";
		$("#dataForm").attr("action","javascript:addOrModify(1)");
	}else if(type==2){
		title="修改首页宣传图";
		$("#dataForm").attr("action","javascript:addOrModify(2)");
		var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的首页宣传图！",{icon:0});
			return;
		}
		$("#bannerId").val(data[0].id);	
		$("#bannerTitlea").val(data[0].bannerTitle);	
		$("#links").val(data[0].links);	
		$("#imgPath").val(data[0].url);
		appendImg(data[0].url,$("#fileList"));
	}
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
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
		var bannerTitle = encrypt.encrypt($("#bannerTitlea").val());
		data.bannerTitle=bannerTitle;
		var links = encrypt.encrypt($("#links").val());
		data.links=links;
		var imgPath = encrypt.encrypt($("#imgPath").val());
		data.url=imgPath;
		var bannerId = encrypt.encrypt($("#bannerId").val()+"");
		data.id=bannerId;
		var Posturl = appPath+"/homeBanner/";
		if(type ==1){//添加
			Posturl +="saveHomeBanner";
		}else{
			Posturl +="updateHomeBanner";
		}
		$(".layui-layer-btn0").addClass("disabled");
		$.ajax( {  
			url:Posturl,
			data:data,
			type:'post',  
			cache:false,  
			dataType:'text',  
			success:function(data) { 
				if(type ==1 ){
					if(data==1){
						layer.alert("添加成功",{icon:1});
						$(".layui-layer-btn1").click();
						 var table = $('#table_id').DataTable();
						 table.ajax.reload();
					}else if(data==0){
						layer.alert("添加失败",{icon:2});  
					}else if(data==-1){
						layer.alert("图片标题已存在",{icon:2});  
					}
				}else{
					if(data==1){
						layer.alert("修改成功",{icon:1});
						$(".layui-layer-btn1").click();
						 var table = $('#table_id').DataTable();
						 table.ajax.reload();
					}else if(data==0){
						layer.alert("修改失败",{icon:2});  
					}else if(data==-1){
						layer.alert("图片标题已存在",{icon:2});  
					}
				}
				 $(".layui-layer-btn0").removeClass("disabled");
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
    $("#picView").attr("src","");
    if(data.url !=""){
    	var picURL = $("#hostPath").val()+data.url;
    	//changePic(picURL);
    	$("#picView").attr("src",picURL);
    	//alert($("#picView")[0].height);
    	$(".hideHtml").hide();
    }else{
    	$(".hideHtml").show();
    	$("#picView").attr("src","");
    }
	layer.open({
	    type: 1,
	    area: ['500px', '400px'], //高宽
	    title: "查看图片",
//	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}

/**
 * 等比例缩放
 */
function changePic(picURL){
	var in2 = document.getElementById("hostPath");
	var im = document.createElement("img");
	im.src=picURL;
	var realHeight = im.height;
	var realWidth  =  im.width;
	var h = realHeight/280;
	var w = realWidth/500;
	var proportion=1;
	if(h>w){
		proportion = h;
	}else{
		proportion = w;
	}
	var P_HEIGHT = parseInt(realHeight/proportion)+"px";
	var P_WIDTH =  parseInt(realWidth/proportion)+"px";
	$("#picView").css({"height":P_HEIGHT,"width":P_WIDTH});
	$("#picView").attr("src",picURL);
	
}
/**
 * 显示列表
 */
function showList(){
	$('#table_id').DataTable(
			{	autoWidth : false,
				scrollY : 500,
				serverSide:true,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
				searching : true,
	/*			processing:true,
				displayStart:0,*/
				info : true,// 左下角信息
//				ordering: false,//排序
				lengthMenu:[10,25,50,100],
//				aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: {  
		        	"url": appPath+"/homeBanner/showHomeBannerList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {
		            	var bannerTitle =$("#bannerTitle").val();
						var startDate = $("#startDate").val();
						var endDate = $("#endDate").val();
						var statu = $("statu").val();
						bannerTitle = encrypt.encrypt(bannerTitle);
						startDate = encrypt.encrypt(startDate);
						endDate = encrypt.encrypt(endDate);
						statu = encrypt.encrypt(statu+"");
						d.statu = statu;
						d.endDate = endDate;
						d.startDate = startDate;
						d.bannerTitle = bannerTitle;
		            } 
		        },
		        columns: [  
		                  {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
		                	  "mRender": function (data, type, full) {
		                		  sReturn = '<input type="checkbox" value="1" />';
		                		  return sReturn;
		                	  }
		                  },
		                  { title:"添加时间","data": "sCreateTime"},  
				          { title:"图片标题","data": "bannerTitle"},  
				          { title:"图片展示",
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this)">查看图片</a>';
				        	  }
				          },  
				          { title:"图片点击跳转路径","data": "links"},  
				          { title:"最后一次操作管理员","data": "adminName"},  
				          { title:"状态","data": "statu", 
				        	  "mRender": function (data, type, full) {
				        		  if(full.statu==0){
				        			  return "<font color='red'>无效</font>";
				        		  }else {
				        			  return "有效";
				        		  }
				        	  }
				          },  
				          { title:"操作",
				        	  "mRender": function (data, type, full) {
				        		  var sReturn ="";
				        		  if(full.statu==0){
				        			  sReturn = "<a onclick=\"stopOrStart(1,'"+full.id+"');\" href=\"javascript:void(0);\">启用</a>" ;
				        		  }else if(full.statu==1){
				        			  sReturn =  "<a onclick=\"stopOrStart(0,'"+full.id+"');\" href=\"javascript:void(0);\">停用</a>";
				        		  }
		                		  sReturn+=  "&nbsp;&nbsp;&nbsp;<a href='javascript:upOrDown("+full.id+",1);' class='btn-disable'>上移</a>";
		                		  sReturn+=  "&nbsp;&nbsp;&nbsp;<a href='javascript:upOrDown("+full.id+",-1);' class='btn-disable'>下移</a>";
		                		  return sReturn;
				        	  }
				          }

				  ],
		        aoColumnDefs : [
		        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		        				{
		        						"orderable" : false,
		        						"aTargets" : [0,1,2,3]
		        					/* aTargets : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		        							13, 14, 15 ] */
		        				} // 制定列不参与排序
		        				],
		        
		        rowCallback:function(row,data,index){//添加单击事件，改变行的样式      
		        },
		        oTableTools:{"sRowSelect":"multi"}
	});
}














