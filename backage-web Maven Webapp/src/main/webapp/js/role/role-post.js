 //添加职务
function postAdd(){
	document.getElementById("dataForm").reset();
	//操作
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
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
	document.getElementById("dataFor").reset();
	//操作
	var  title="修改专家团队";
		var data = $('#post_id').DataTable().rows('.selected').data(); 
		if(data.length<1){
			layer.alert("请选择要修改的！",{icon:0});
			return;
		}
		$("#postN").val(data[0].postName);	
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
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

$(function() {
	var appPath = getRootPath();//项目根路径
    $("#post_id").dataTable({ 
		        autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
			 // paging : false,//分页
		//				searching : false,
		//				info : false,// 左下角信息
		//				ordering: false,//排序
				lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		//				aaSorting : [ [ 16, "desc" ] ],// 默认第几个排序
				colReorder : false,
				scrollX : true,
				sScrollX : "100%",
				sScrollXInner : "100%",
				bScrollCollapse : true,  
				processing: true, //打开数据加载时的等待效果  
		        serverSide: true,//打开后台分页  
		        ajax: { 
		            "url": "../backage-web/PostController/getPostList.do",
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		                var level1 = $('#level1').val();  
		                //添加额外的参数传给服务器  
		                d.extra_search = level1;  
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
		          { title:"添加时间","data": "addDate" }  
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
	 

	
	 var table = $('#post_id').DataTable();
	
	 $('#post_id tbody').on( 'click', 'tr', function () {
	        $(this).toggleClass('selected');
	  });
	 
//		单击行，选中复选框 
/*		   $("#post_id tr").slice(1).each(function(g){     
			alert("1");     
			var p=this; 
			    $(this).children().slice(1).click(function(){ 
				alert("1");     
				$($(p).children()[0]).children().each(function(){      
				 if(this.type=="checkbox"){  
					if(!this.checked){
						this.checked=true; 
			       }else{         
						this.checked=false;       
				 } 
		      } 
		     }); 
		    }); 
		   });*/ 
	
	
	
	 //添加职务
//	$(".obtn-post-add").on("click touchstart",function(){
//		validform5(".layui-layer-btn0","dataForm",false,"3");
//		layer.open({
//		    type: 1,
//		    area: ['480px', '320px'], //高宽
//		    title: "添加职务",
//		    content: $(".post-add"),//DOM或内容
//		    btn:['确定', '取消']
//			  ,yes: function(index, layero){ //或者使用btn1
//				  savePost();
//			    //确定的回调
//			    $("#dataForm").submit();
//			  },cancel: function(index){//或者使用btn2（concel）
//			  	//取消的回调
//			  }
//		});
//	});
//		

		function savePost(){
			var postName = document.getElementById("postName").value;
			var postRemark 	= document.getElementById("postRemark").value;
			$.ajax({  
				url:"../backage-web/PostController/savePost.do",
				data:{
					postName:postName,
					postRemark:postRemark
				},
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					 if(data==1){
							layer.alert("添加成功",{icon:1});
							$(".layui-layer-btn1").click();
							 var table = $('#staffListTb').DataTable();
							 window.location.reload(); 
							 
						}else if(data==0){
							layer.alert("数据为空",{icon:2});  
						}
				},  
				error : function() {  
					layer.alert("操作失败!",{icon:2});  
				}  
			});
		}
		
		
//	$(".obtn-post-mod").on("click touchstart",function(){
//			//获得选取的对象
//		var rowdata = $('#post_id').DataTable().rows('.selected').data();
//		if(rowdata.length<0){
//			layer.alert("请选择要修改的！",{icon:0});
//			return;
//		}
////			$("#postN").val(rowdata[0].postName);
//			validform5(".layui-layer-btn0","post-mod",true,'3');
//			layer.open({
//			    type: 1,
//			    area: ['480px', '320px'], //高宽
//			    title: "修改职务",
//			    content: $(".post-mod"),//DOM或内容
//			    btn:['确定', '取消']
//				  ,yes: function(index, layero){ //或者使用btn1
//					  
//					  var postName = document.getElementById("postN").value;
//				    //确定的回调
//			       $("#post-mod").submit();
//			       layer.close(index);
//			       window.location.reload(); 
//				  },cancel: function(index){//或者使用btn2（concel）
//				  	//取消的回调
//				  }
//			});
//			
//		});
		
	
	function test(){
		var rowdata = $('#post_id').DataTable().rows('.selected').data();
	    var	id=rowdata[0].id;
	    var postName = document.getElementById("postN").value;
		
		$.ajax( {  
			url:"../backage-web/PostController/editPost.do",
			data:{
				id  :id,
				postName:postName
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
	
	$(".obtn-post-del").on("click touchstart",function(){
		//获得选取的对象
		var rowdata = $('#post_id').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要删除！",{icon:0});
			return;
		}
		//删除某个职务，当有员工拥有改职务时，不能进行删除
		layer.confirm('确定删除该职务？', {
		  btn: ['确定', '取消']
		}, function(index, layero){
		  //按钮【按钮一】的回调
				$.ajax( {  
				      url:"../backage-web/PostController/delPost.do",
				      data:{  
				           "id" : rowdata[0].id
				      	},  
				      	type:'post',  
				    success:function(data) { 
				    	  if(data==0){  
//					        	 layer.alert("删除成功!",{icon:2});  
					             window.location.reload();  
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
	
});

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




/*function updates(){
	var postName = document.getElementById("postN").value;
	alert(postName+"asd")
	  $.ajax( {  
			url:"../backage-web/PostController/editPost.do",
			data:{postName:postName,id : id},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				
			},  
			error : function() {  
				layer.alert("操作失败!",{icon:2});  
			}  
		});
	
}*/


