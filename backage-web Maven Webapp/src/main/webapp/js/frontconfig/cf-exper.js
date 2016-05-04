/*专家*/
/**
 * 获取项目根目录全路径
 * @returns
 */
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}

$(function() {
	//单选
	$('#teamTb tbody').on( 'click', 'tr', function () {
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
	showExpert();
	//上传插件初始化
	expUpload("#portraitUrl");
   
});



/**
 * 增加/修改专家顾问操作
 * @param type 0：增加 1：修改
 * @returns
 */
function addOrModify(type){
	//清除数据
	validform5(".layui-layer-btn0","dataForm",true,3);
	//清除数据
	document.getElementById("dataForm").reset();
	$("#portrait").attr("src","");
	$("#fileList").html("");
	//操作
	var title="";
	if(type==0){
		title="添加专家顾问";
		$("#dataForm").attr("action","javascript:addOrUpdate(0)");
	}else if(type==1){
		title="修改专家顾问";
		$("#dataForm").attr("action","javascript:addOrUpdate(1)");
		var rowdata = $('#teamTb').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要修改的专家顾问！",{icon:0});
			return;
		}
		$("#mngName").val(rowdata[0].mngName);	
		$("#mngPost").val(rowdata[0].mngPost);	
		$("#profile").val(rowdata[0].profile);
		$("#portraitUrl").val(rowdata[0].portraitUrl);
		appendImg(rowdata[0].portraitUrl,$("#fileList"));
		
	}
	var title =title;
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	     title: title,
	    maxmin: true,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
			  $("#dataForm").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});
}


/**
 * 修改之前查询数据
 * @returns
 */
function expMod(){
	//清除数据
	validform5(".layui-layer-btn0","dataForm",true,3);
	document.getElementById("dataForm").reset();
	
	$("#portrai").attr("src","");
	//操作
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	    title: title,
	    maxmin: true,
	    content: $(".pic-add"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
			  $("#dataForm").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
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

//提交添加或者修改
function addOrUpdate(type){
	if(type==0){
		addMngTeam();//添加
	}else{
		updateExpertTeamByID(); //修改
	}
	
}

/**
 * 修改专家顾问
 * @returns
 */
function updateExpertTeamByID(){
	var rowdata = $('#teamTb').DataTable().rows('.selected').data();
	var	id=rowdata[0].id;
	var mngName = $("#mngName").val();
	var mngPost =  $("#mngPost").val();
	var portraitUrl = $("#portraitUrl").val();
	var profile =$("#profile").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	mngName = encrypt.encrypt(mngName);
	mngPost = encrypt.encrypt(mngPost);
	portraitUrl = encrypt.encrypt(portraitUrl);
	profile =encrypt.encrypt(profile);
	id =encrypt.encrypt(id+"");
	$.ajax( {  
		url: appPath+"/ExpertsController/updateExpertTeamByID.do",
		data:{
			id:id,
			mngName:mngName,
			mngPost:mngPost,
			portraitUrl:portraitUrl,
			profile:profile
			},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			 if(data==1){
					layer.alert("修改成功",{icon:1});
					$(".layui-layer-btn1").click();
					 var table = $('#staffListTb').DataTable();
					 window.location.reload(); 
					 
				}else if(data==0){
					layer.alert("失败",{icon:2});  
				}
		},  
		error : function() {  
			layer.alert("操作失败!",{icon:2});  
		}  
	});
}


/**
 * 添加管理团队
 */
function addMngTeam(){
	var mngName = $("#mngName").val();
	var mngPost =  $("#mngPost").val();
	var portraitUrl = $("#portraitUrl").val();
	var profile =$("#profile").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	mngName = encrypt.encrypt(mngName);
	mngPost = encrypt.encrypt(mngPost);
	portraitUrl = encrypt.encrypt(portraitUrl);
	profile =encrypt.encrypt(profile);
	
	
	$.ajax( {  
		 url:appPath+"/ExpertsController/insertExpertTeam.do",
		data:{
			mngName:mngName,
			mngPost:mngPost,
			portraitUrl:portraitUrl,
			profile:profile
		},
		type:'post',  
		cache:false,  
		dataType:'json',   
		success:function(data) { 
			 if(data==1){
				layer.alert("添加成功",{icon:1});
				  $(".layui-layer-btn1").click();
				 setTimeout('location.reload()',500);
			 }else if(data==-1){
				layer.alert("该名称的专家顾问已存在",{icon:2});  
			 }
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}


/**
 * 启用/停用管理团队
 * @param type 1：启用 0：停用
 * @param id 管理团队id
 * @returns
 */
function stopOrStart(id,type){
	
	var ms ="";
	if(type==0){
		ms="确定停用？";
	}else{
		ms="确定启用？";
	}
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	id = encrypt.encrypt(id+"");
	type = encrypt.encrypt(type+"");
	layer.confirm(ms, {
		  btn: ['确定', '取消']
	}, function(index, layero){
		  //按钮【按钮一】的回调
	$.ajax( {  
		url:appPath+"/ExpertsController/updateExpertTeamStatuByID.do",
		data:{
			id:id,
			statu:type
			},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("修改成功。",{icon:1});
				 $(".layui-layer-btn1").click();
				setTimeout('location.reload()',500);
			}else if(data==-1){
				layer.alert("该名称的专家顾问已存在！",{icon:2});  
			 }else {
				layer.alert("修改失败！",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
	//执行完关闭
  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
}

/**
 * 查看图片
 * @returns
 */
function viewPic(){
	var rowdata = $('#post_id').DataTable().rows('.selected').data();
    console.log(rowdata[0].portraitUrl);
	$("#picView").attr("src",$("#hostPath").val()+rowdata.portraitUrl);
	layer.open({
	    type: 1,
	    area: ['500px', '400px'], //高宽
	    title: "查看头像",
	    maxmin: true,
	    content: $(".pic-view"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});

}

/**
 * 显示专家顾问
 * @returns
 */
function  showExpert(){
	
	 $("#teamTb").dataTable({ 
		 autoWidth : false,
		scrollY : 500,
		serverSide:true,
		pagingType: "simple_numbers",//设置分页控件的模式  
		paging : true,//分页
		searching : true,
/*			processing:true,
		displayStart:0,*/
		info : true,// 左下角信息
//			ordering: false,//排序
		lengthMenu:[10,25,50,100],
//			aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
	        ajax: { 
	            "url":  appPath+"/ExpertsController/selectExpertTeamListpage.do",
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
	          { title:"专家id","data": "id"},
	          { title:"添加时间","data": "sCreateTime"},  
	          { title:"专家姓名","data": "mngName" },  
	          { title:"职称","data": "mngPost" },  
              { title:"头像","data": "portraitUrl", 
	        	  "mRender": function (data, type, full) {
	        		  return '<a href="javascript:void(0);" class="btn-det" onclick="viewPic(this)">查看图片</a>';
	        	  }
	          },  
	          { title:"简介","data": "profile", 
	        	  "mRender": function (data, type, full) {
	        		  return '<a href="javascript:void(0);" class="btn-det" onclick="showDetail(this)">查看详情</a>';
	        	  }
	          },  
	          { title:"最后一次操作管理员","data": "adminName" },  
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
            } 
		     ],
	    aoColumnDefs : [
					{	
						sDefaultContent: '',
						orderable : false,
						aTargets: [ '_all' ]
						}, // 制定列不参与排序
					 	{
							"aTargets":[1],
							"bVisible":false
						} 
					],
	    rowCallback:function(row,data){//添加单击事件，改变行的样式      
	    },
	    oTableTools:{"sRowSelect":"multi"}
	});  
}


/**
 * 查看图片
 * @returns
 */
function viewPic(btn){
	var imgRealURL ="http://cdsxlc.com:21000/";
    var data = $('#teamTb').DataTable().row($(btn).parents('tr')).data();
    var url = data.portraitUrl;
    if(data!=""){
    	console.log(imgRealURL+url);
    	$("#picView").attr("src",imgRealURL+url);
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
	var data = $('#teamTb').DataTable().row($(btn).parents('tr')).data();
	$(".report-det").html(data.profile);
	
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

