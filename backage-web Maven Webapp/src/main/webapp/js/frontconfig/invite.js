/*招聘信息*/

/**
 *面板数据 
 *
 */

$(function() {
	//单选
	getInviteList(); //获取列表
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
	
});


/**
 * 增加/修改招贤纳士
 * @param type 0：增加 1：修改
 * @returns
 */
function addOrModify(type){
	//清除数据
	validform5(".layui-layer-btn0","dataForm",false,5);
	//清除数据
	document.getElementById("dataForm").reset();
	if(type==0){
		title="添加招聘信息";
		$("#dataForm").attr("action","javascript:addOrUpdate(0)");
	}else if(type==1){
		title="修改招聘信息";
		$("#dataForm").attr("action","javascript:addOrUpdate(1)");
		var rowdata = $('#teamTb').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要修改的招聘信息！",{icon:0});
			return;
		}
		var ue4 = UE.getEditor('duty');
		var ue5 = UE.getEditor('demand');
		$("#name").val(rowdata[0].name);	
		ue4.addListener("ready", function () {
        	ue4.setContent(rowdata[0].jobResponsibilities);//('insertHtml', rowdata[0].sgContent);
	    });
		ue5.addListener("ready", function () {
        	ue5.setContent(rowdata[0].jobRequirements);//('insertHtml', rowdata[0].sgContent);
	    });
		$("#area").val(rowdata[0].area);
		
	}
	layer.open({
	    type: 1,
	    area: ['750px', '600px'], //高宽
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


//添加方法
function addRecruitments(){
	var name =$("#name").val();
	var area = $("#area").val();
	//获取ueditor内容
	var ue1 = UE.getEditor('duty');
	var jobR = ue1.getContent();
	var ue2 = UE.getEditor('demand');
	var jobRe= ue2.getContent();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	area = encrypt.encrypt(area);
	name = encrypt.encrypt(name);
	jobR = encrypt.encrypt(jobR);
	jobRe = encrypt.encrypt(jobRe);
	 $(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		 url:appPath+"/RecruitmentController/insertRecruitments.do",
		data:{
			name:name,
			area:area,
			jobResponsibilities:jobR,
			jobRequirements:jobRe
		},
		type:'post',  
		cache:false,  
		dataType:'json',   
		success:function(data) { 
			 if(data==1){
				layer.alert("添加成功",{icon:1});
				$(".layui-layer-btn1").click();
				var table = $('#teamTb').DataTable();
				 table.ajax.reload();
			}else if(data==-1){
				layer.alert("该名称的已存在",{icon:2});  
			}
			 $(".layui-layer-btn0").removeClass("disabled");
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
}
/**
 * 添加或者修改
 * @param type 0 添加 1 修改
 */
 function  addOrUpdate(type){
	 if(type==0){
		 addRecruitments();
	 }else{
		 updateRecruitments();
	 }
	 
 } 
/**
 * 修改招聘信息
 * @returns
 */
  function updateRecruitments(){
	    var rowdata = $('#teamTb').DataTable().rows('.selected').data();
	    var	id=rowdata[0].id;
	    var name =$("#name").val();
		var area = $("#area").val();
		//获取ueditor内容
		var ue1 = UE.getEditor('duty');
		var jobR = ue1.getContent();
		var ue2 = UE.getEditor('demand');
		var jobRe= ue2.getContent();
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		id = encrypt.encrypt(id+"");    
		area = encrypt.encrypt(area);
		name = encrypt.encrypt(name);
		jobR = encrypt.encrypt(jobR);
		jobRe = encrypt.encrypt(jobRe);
		 $(".layui-layer-btn0").addClass("disabled");
		$.ajax( {  
			url:appPath+"/RecruitmentController/updateRecruitments.do",
			data:{
				id:id,
				name:name,
				area:area,
				jobResponsibilities:jobR,
				jobRequirements:jobRe
			},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data==1){
					layer.alert("修改成功",{icon:1});
					$(".layui-layer-btn1").click();
					var table = $('#teamTb').DataTable();
					 table.ajax.reload();
				}else{
					layer.alert("修改失败",{icon:2});  
				}
				 $(".layui-layer-btn0").removeClass("disabled");
			},  
			error : function() {  
				layer.alert("操作失败!",{icon:2});  
			}  
		});
	}
 
  
  /**
   * 查看详情 
   */
  function showDetail(btn,type){
  	$(".report-det").html("");//清空数据
  	var data = $('#teamTb').DataTable().row($(btn).parents('tr')).data();
  	var title="";
  	if(type==0){
  		title = "岗位职责";
  		$(".report-det").html(data.jobResponsibilities);
  	}else{
  		title = "任职需求";
  		$(".report-det").html(data.jobRequirements);
  	}
  	
  	layer.open({
  	    type: 1,
  	    area: ['800px', '600px'], //高宽
  	    title: title,
  	    maxmin: true,
  	    content: $(".report-det"),//DOM或内容
  	    btn:['关闭']
  		  ,cancel: function(index){//或者使用btn2（concel）
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
  		url:appPath + "/RecruitmentController/updateRecruitmentStatuByID.do",
  		data:{
  			id:id,
  			statu:type
  			},
  		type:'post',  
  		cache:false,  
  		dataType:'json',  
  		success:function(data) { 
  			if(data==1){
  				layer.alert("操作成功",{icon:1});
  				$(".layui-layer-btn1").click();
				setTimeout('location.reload()',500);
  			}else if(data==0){
  				layer.alert("操作失败",{icon:2});  
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

function getInviteList(){
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
	            "url":appPath+"/RecruitmentController/selectRecruitmentsList.do",
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
	          { title:"招聘id","data": "id"},
	          { title:"添加时间","data": "sCreateTime"},  
	          { title:"招聘职位","data": "name" },  
	          { title:"工作地区","data": "area" },  
	          { title:"岗位职责","data": "jobResponsibilities", 
	        	  "mRender": function (data, type, full) {
	        		  return '<a href="javascript:void(0);" class="btn-det" onclick="showDetail(this,0)">查看职责</a>';
	        	  }
	          }, 
	          { title:"任职要求","data": "jobRequirements", 
	        	  "mRender": function (data, type, full) {
	        		  return '<a href="javascript:void(0);" class="btn-det" onclick="showDetail(this,1)">查看要求</a>';
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
//					 	{
//							"aTargets":[1],
//							"bVisible":false
//						} 
					],
	    rowCallback:function(row,data){//添加单击事件，改变行的样式      
	    },
	    oTableTools:{"sRowSelect":"multi"}
	});  
}

