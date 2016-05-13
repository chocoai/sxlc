/**
 * 角色管理
 * 职务管理
 */

/**===================================================================*/
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
	$('#post_id tbody').on( 'click', 'tr', function () {
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

});

//添加职务
function postAdd(){
	validform5("layer-btn0","dataForm",true,"3");
	//操作
	layer.open({
	    type: 1,
	    area: ['400px', '270px'], //高宽
	    title: "添加职务",
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



function expMod(){
	//清除数据
	//document.getElementById("dataFor").reset();
	//操作
	var  title="修改职务";
	var rowdata = $('#post_id').DataTable().rows('.selected').data();
	validform5("layer-btn0","dataFor",true,"3");
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	$("#postName_two").val(rowdata[0].postName);	
	$("#postRemark1").val(rowdata[0].postRemark);
	var value=rowdata[0].deptId;
	$("#deptId1").attr("value",value);
	$("#deptId1").val(value);
	$("#deptId1").get(0).value = value;
	layer.open({
	    type: 1,
	    area: ['400px', '270px'], //高宽
	    title: title,
	    maxmin: true,
	    content: $(".pic-mod"),//DOM或内容
	    btn:['确定', '取消']
		  ,yes: function(index, layero){ //或者使用btn1
		    //确定的回调
		  	//判断执行不同方法
			  $("#dataFor").submit();
		  },cancel: function(index){//或者使用btn2（concel）
		  	//取消的回调
		  }
	});

}

/**
 * 保存职务
 */
function savePost(){
	var postName = $("#postName_one").val();
	var postRemark 	=$("#postRemark").val();
	var deptId = $("#deptId").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	postName = encrypt.encrypt(postName);
	postRemark = encrypt.encrypt(postRemark);
	deptId = encrypt.encrypt(deptId+"");
	$.ajax({  
		url:appPath+"/PostController/savePost.do",
		data:{
			postName:postName,
			postRemark:postRemark,
			depeId:deptId
		},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			 if(data==0){
					layer.alert("添加成功",{icon:1});
					$(".layui-layer-btn1").click();
					document.getElementById("dataForm").reset();
					setTimeout('location.reload()',500);
					 
				}else {
					layer.alert("添加失败",{icon:2});  
					document.getElementById("dataForm").reset();
				}
			 document.getElementById("dataForm").reset();
		},  
		error : function() {  
			layer.alert("操作失败!",{icon:0});  
		}  
	});
}


/**
 * 修改 职务
 */
function test(){
	var rowdata = $('#post_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
    var	id=rowdata[0].id;
  
    var postName = $("#postName_two").val();
	var postRemark 	=$("#postRemark1").val();
	var deptId = $("#deptId1").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	postName = encrypt.encrypt(postName);
	postRemark = encrypt.encrypt(postRemark);
	deptId = encrypt.encrypt(deptId+"");
	
	id = encrypt.encrypt(id+"");
	$.ajax( {  
		url:appPath+"/PostController/editPost.do",
		data:{
			lId:id,
			postName:postName,
			postRemark:postRemark,
			depeId:deptId
			},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			 if(data==0){
					layer.alert("修改成功",{icon:1});
					$(".layui-layer-btn1").click();
					document.getElementById("dataFor").reset();
					setTimeout('location.reload()',500);
					 
				}else {
					layer.alert("修改失败",{icon:2}); 
					document.getElementById("dataFor").reset();
				}
			 document.getElementById("dataForm").reset();
		},  
		error : function() {  
			layer.alert("操作失败!",{icon:2});  
		}  
	});
}
/**
 * 删除职务
 */
$(".obtn-post-del").on("click touchstart",function(){
	//获得选取的对象
	var rowdata = $('#post_id').DataTable().rows('.selected').data();
	if(rowdata.length<1){
		layer.alert("请选择要处理的事务！",{icon:0});
		return;
	}
	var id=  rowdata[0].id;
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	id = encrypt.encrypt(id+"");
	//删除某个职务，当有员工拥有改职务时，不能进行删除
	layer.confirm('确定删除该职务？', {
	  btn: ['确定', '取消']
	}, function(index, layero){
	  //按钮【按钮一】的回调
			$.ajax( {  
			      url:appPath+"/PostController/delPost.do",
			      data:{  
			           lId:id
			      	},  
			      	type:'post',  
			    success:function(data) { 
			    	  if(data==0){  
					       layer.alert("删除成功!",{icon:1});  
					       $(".layui-layer-btn1").click();
					       $('#post_id').DataTable().ajax.reload();
				      }else if(data==1){  
					       layer.alert("该职务下有任职的的员工!",{icon:2});  
				      }else{
				    	  layer.alert("删除失败!",{icon:2});  
				      }
			      },  
			      error : function() {  
			           layer.alert("操作失败!",{icon:2});  
			      } 
			 });
		//执行完关闭
	  	layer.close(index);
	}, function(index){
	  //按钮【按钮二】的回调
	});
});

/**
 * 停用启用职务
 * @param id   职务id
 * @param statu 职务状态
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
			url : appPath+"/PostController/ofPost.do",
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
				if(data == 0){
					//执行完关闭
					if(status==0){
						layer.alert("停用成功。",{icon:1});  
					}else{
						layer.alert("启用成功。",{icon:1});
					}
				  	layer.close(index);
				  	$('#post_id').DataTable().ajax.reload();
				}else if(data == -1){
					if(status==0){
						alert("停用失败！");
					}else{
						alert("启用失败！");
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
 * 显示职务列表或者刷新
 */
var flag = true;
function showListOfDataTable(dePtId){
	$("#deptIds").val(dePtId);
	$("#deptId").attr("value",dePtId);
	$("#deptId").val(dePtId);
	$("#deptId").get(0).value = dePtId;
	$("#deptId").prop("disabled",true);
	if(flag){
		showPost();
	}else{
		$('#post_id').DataTable().ajax.reload();
	}
	flag = false;
}


/**
 * 显示职务列表
 * @returns
 */

function showPost(){
    $("#post_id").dataTable({ 
    	autoWidth : false,
		scrollY : 500,
		serverSide:true,
		pagingType: "simple_numbers",//设置分页控件的模式  
		paging : true,//分页
		searching : true,
/*			processing:true,
		displayStart:0,*/
		info : true,// 左下角信息
//		ordering: false,//排序
		lengthMenu:[10,25,50,100],
//		aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
	        ajax: { 
	        	"url": appPath+"/PostController/getPostList.do",
	            "dataSrc": "results",   
	            "data": function ( d ) {  
	            	var deptId = $("#deptIds").val();//所属部门id
	            	var deptName = $("#deptName").val();//所属部门
	            	var postName =  $("#postName").val();//职务名称
	            	var startTime =  $("#start").val();//开始时间
	            	var endTime =  $("#end").val();//结束时间
	            	var encrypt = new JSEncrypt();
	            	encrypt.setPublicKey(publicKey_common);
	            	//result 为加密后参数
	            	deptName = encrypt.encrypt(deptName);
	            	postName = encrypt.encrypt(postName);
	            	startTime = encrypt.encrypt(startTime);
	            	endTime = encrypt.encrypt(endTime);
	            	deptId = encrypt.encrypt(deptId+"");
	            	d.deptName=deptName;
	            	d.postName=postName;
	            	d.startTime=startTime;
	            	d.endTime=endTime;
	            	d.deptId = deptId;
	            }  
	        },
	   columns: [  
	          {title:'<input type="checkbox" class="table-checkbox"  value="1" />',
	        	  "mRender": function (data, type, full) {
	        		  sReturn = '<input type="checkbox" value="1" />';
	        		  return sReturn;
	        	  }
	          },
	          { title:"职务id","data": "id"},
	          { title:"职务名称","data": "postName"},  
	          { title:"所属部门","data": "deptName"},  
	          { title:"职务描述","data": "postRemark" },  
	          { title:"添加时间","data": "addDate" } ,
	          { title:"状态","mRender":function(data, type, full){
            	  var sReturn ="";
            	  if(full.postStatu==1){
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
            		  if(full.postStatu==1){
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
					// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
					{
						orderable : false,
						aTargets : [ 0, 1, 2, 3, 4]
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

