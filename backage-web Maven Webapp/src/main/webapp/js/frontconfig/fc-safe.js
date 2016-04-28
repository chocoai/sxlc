/**
 *前台界面配置-首页4大安全保障管理
 * 添加修改部分代码直接写在页面上的，加快渲染速度
 * 每次执行操作前请清空目标盒子的数值
 */

//
///**
// * 查询按钮
// */
//$(".glyphicon-search").on("click",function(){
//	$('#tb-manage-in').DataTable().ajax.reload();
//	
//});
var ue ;
$(function() {
	//上传插件初始化
	expUpload("#imgPath");
	ue =  UE.getEditor('applyguide');
	FirstFourList();	//
	//单选
	$('#partnerTb tbody').on( 'click', 'tr', function () {
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
		
	} );

	$(".obtn-safety-mod").on("click touchstart",function(){
		//获取选取对象
		var rowdata = $('#partnerTb').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要处理的事务！",{icon:0});
			return;
		}
		validform5(".layui-layer-btn0","dataForm",true,3);
		$("#title").val(rowdata[0].asTitle);
		$("#imgPath").val(rowdata[0].sgPic);
		$("#imgUrl").val(rowdata[0].sgUrl);
		$("#lId").val(rowdata[0].sgID);
		ue.addListener("ready", function () {
        	ue.setContent(rowdata[0].sgContent);//('insertHtml', rowdata[0].sgContent);
	    });
		$("#fileList").empty();
		appendImg(rowdata[0].sgPic,$("#fileList"));
		layer.open({
		    type: 1,
		    area: ['750px', '550px'], //高宽
		    title: "修改首页安全保障",
		    //maxmin: true,
		    content: $(".modify"),//DOM或内容
		    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
			  $("#dataForm").submit();
		  },cancel: function(index, layero){ //或者使用btn1
				layer.close();				
			  }
		});
	});
});


/**
 * 
 * @param id   管理员id
 * @param statu 管理员状态
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
			url : appPath+"/firstSecurity/ofFirstSecurity.do",
				data:{
					lId:id,
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
				  	setTimeout('location.reload()',500);
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
 * 列表
 */
function FirstFourList(){
	$('#partnerTb').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : false,//分页
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
		            "url": appPath+"/firstSecurity/FirstSecurityList.do",   
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
//		                	  "sClass": "table-checkbox"
		                  },
		                  { title:"保障标题","data": "asTitle" },  
		                  { title:"保障内容","data": "sgContent", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="showDetail(this)">查看详情</a>';
				        	  }
				          },  
		                  { title:"保障展示图片","data": "sgPic", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this)">查看图片</a>';
				        	  }
				          },  
		                  { title:"保障链接地址","data": "sgUrl" },  
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
			                		  sReturn = "<a href='javascript:stopOrStart("+full.sgID+",0);' class='btn-enable'>停用</a>";
			                	  }else{
			                		  sReturn = "<a href='javascript:stopOrStart("+full.sgID+",1);' class='btn-disable'>启用</a>";
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


/**
 * 追加图片
 * @param imgURL  		图片路劲
 * @param fileListObj	存放图片div 
 */
function appendImg(imgURL,fileListObj){
	var imgRealURL ="http://cdsxlc.com:21000/";
	if(imgURL==null || imgURL==""){
		return ;
	}else{
		imgRealURL+=imgURL;
	}
	var html = '<div  class="file-item thumbnail">' +
                '<img src="'+imgRealURL+'" style="width:100px;height:100px"/>' +
                '<div class="file-panel"><span class="cancel"></span></div>'+
            '</div>';
	fileListObj.append(html );
}


/**
 * 查看图片
 * @returns
 */
function viewPic(btn){
	var _w = parseInt($(window).width());//获取浏览器的宽度 
	var imgRealURL ="http://cdsxlc.com:21000/";
    var data = $('#partnerTb').DataTable().row($(btn).parents('tr')).data();
    var url = data.sgPic;
    var $img = $("#picView"); 
    var realWidth;//真实的宽度 
    var realHeight;//真实的高度 
    if(data!=""){
    	$img.attr("src",imgRealURL+url);
    	/*$("<img/>").attr("src", $(img).attr("src")).load(function() { 
	     如果要获取图片的真实的宽度和高度有三点必须注意 1、需要创建一个image对象：如这里的$("<img/>") 2、指定图片的src路径 3、一定要在图片加载完成后执行如.load()函数里执行 
	   	realWidth =  this.width; 
	   	realHeight = this.height; 
	   	//如果真实的宽度大于浏览器的宽度就按照100%显示 
	   	if(realWidth>=_w){ 
	   		$(img).css("width","100%").css("height","auto"); 
	    }else{//如果小于浏览器的宽度按照原尺寸显示 
	   		$(img).css("width",realWidth+'px').css("height",realHeight+'px');
	   	} 
	   	}); */
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
	    content: $(".picture"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){
		  	//取消的回调
		  }
	});

}

/**
 * 查看详情
 */
function showDetail(btn){
	$(".report-det").html("");//清空数据
	var data = $('#partnerTb').DataTable().row($(btn).parents('tr')).data();
	$(".report-det").html(data.sgContent);
	
	layer.open({
	    type: 1,
	    area: ['800px', '600px'], //高宽
	    title: "查看详情",
	    maxmin: true,
	    content: $(".report-det"),//DOM或内容
	    btn:['关闭']
		  ,cancel: function(index){//或者使用btn2（concel）
		  }
	});
}



/**
 * 根据管理员id修改安全保障
 * @param {} title
 * @param {} type
 */
function modifySafe(){
	var id = $("#lId").val();
	var title = $("#title").val();
	var imgPath  = $("#imgPath").val();
	var imgUrl = $("#imgUrl").val();
	var content = UE.getEditor('applyguide').getContent();
	
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	id = encrypt.encrypt(id+"");
	title = encrypt.encrypt(title);
	imgPath = encrypt.encrypt(imgPath);
    imgUrl =encrypt.encrypt(imgUrl);
	$.ajax({
		url : appPath+"/firstSecurity/UpdateFirstSecurity.do",
			data:{
				lId:id,
				title:title,
				imgPath:imgPath,
				imgUrl:imgUrl,
				content:content
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
				layer.alert("修改成功。",{icon:1});
				$(".layui-layer-btn1").click();
			  	setTimeout('location.reload()',500);
			}else {
				ayer.alert("修改失败！",{icon:2});
			}
		}
	});
}