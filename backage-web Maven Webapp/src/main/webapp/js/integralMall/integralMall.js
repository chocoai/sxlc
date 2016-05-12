function bankManagementAdd(title,type){

	//判断实物还是电子券
	if (goodType == "0"){
		$("#addtypeName").html("实物")
	}else if(goodType == "1"){
		$("#addtypeName").html("电子礼券")
	}
	
	
	if (title == "添加"){
		$("#proName").val("");
		$("#fileList").html("");
		$("#productDescribe").val("");
		$("#portraitUrl").val("")
		layer.open({
		    type: 1,
		    area: ['500px', '460px'], 
		    title: title,
		    maxmin: true,
		    content: $(".pic-add"),
		    btn:['确认', '取消']
			  ,yes: function(index, layero){ 
				  console.log($(".add-content #productDescribe").val())
				  if ($(".add-content #portraitUrl").val()==undefined||$(".add-content #portraitUrl").val()==""||$("#fileList").html()==""){
					  layer.alert("请上传图片",function(index){
						  layer.close(index);
					  });
					  return
				  }
				  if ($(".add-content #proName").val()==undefined||$(".add-content #proName").val()==""){
					  layer.alert("请填写商品类型名称",function(index){
						  layer.close(index);
					  });
					  return
				  }
				  
				  if ($(".add-content #productDescribe").val()==""||$(".add-content #productDescribe").val()==undefined){
					  layer.alert("请填写商品类型描述",function(index){
						  layer.close(index);
					  });
					  return
				  }
				  console.log($(".add-content #proName").val());
				  var data = {};
				  data.upId = encrypt.encrypt(goodType+"");
				  data.typeName =  encrypt.encrypt($(".add-content #proName").val()+"");
				  data.describe = encrypt.encrypt($(".add-content #productDescribe").val()+"");
				  data.iocPath = encrypt.encrypt($(".add-content #portraitUrl").val()+"");
				  var url = "commodityTypeManager/release.do";
				  
				  $.ajax({
					  type:"POST",
					  url:url,
					  data:data,
					  dataType:"json",
					  success:function(r){
						  if (r.status == 1){
							  layer.alert("添加成功",function(){
								  layer.closeAll();
								  $('#table_id').DataTable().ajax.reload();
							  })
						  }else{
							  layer.alert("添加失败,请重试",function(index){
								  layer.close(index)
							  })
						  }
					  }
				  })
			  },cancel: function(index){
				  layer.close(index);
			  }
		});
	}else if (title == "修改"){
		var data = $("#table_id").DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的商品类型！",{icon:0});
			return;
		}
		
		$("#fileList").html("<div id='WU_FILE_0' class='file-item thumbnail upload-state-done imgDisplay'> <img style='height:100px' src='"+$("#imgHost").val()+data[0].commodityClassifyPic
				+"'><div class='info'>"+"</div><div class='file-panel'><span class='cancel deleteBtn'>"
				+"</span></div></div>");
		$("#portraitUrl").val(data[0].commodityClassifyPic);
		$("#proName").val(data[0].commodityClassify);
		$("#productDescribe").val(data[0].commodityClassifyDes);
		$("#updateUid").val(data[0].commodityTypeID)
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
		 
		 
		layer.open({
		    type: 1,
		    area: ['500px', '460px'], 
		    title: title,
		    maxmin: true,
		    content: $(".pic-add"),
		    btn:['确认', '取消']
			  ,yes: function(index, layero){ 
				  if ($(".add-content #portraitUrl").val()==undefined||$(".add-content #portraitUrl").val()==""){
					  layer.alert("请上传图片",function(index){
						  layer.close(index);
					  });
					  return
				  }
				  if ($(".add-content #proName").val()==undefined||$(".add-content #proName").val()==""){
					  layer.alert("请填写商品类型名称",function(index){
						  layer.close(index);
					  });
					  return
				  }
				  
				  if ($(".add-content #productDescribe").val()==""||$(".add-content #productDescribe").val()==undefined){
					  layer.alert("请填写商品类型描述",function(index){
						  layer.close(index);
					  });
					  return
				  }
				  var data = {};
				  data.upId = encrypt.encrypt(goodType+"");
				  data.tId = encrypt.encrypt($("#updateUid").val()+"");
				  data.typeName =  encrypt.encrypt($(".add-content #proName").val()+"");
				  data.describe = encrypt.encrypt($(".add-content #productDescribe").val()+"");
				  data.iocPath = encrypt.encrypt($(".add-content #portraitUrl").val()+"");
				  var url = "commodityTypeManager/edit.do";
				  NetUtil.ajax(
					 url,
					 data,
					 function(r){
						 if (r.status == "1"){
							  layer.alert("修改成功",function(){
								  layer.closeAll();
								  $('#table_id').DataTable().ajax.reload();
							  })
						  }else if(r.status == "-1"){
							  layer.alert("名称已存在",function(index){
								  layer.close(index)
							  })
						  }else{
							  layer.alert("修改失败，请重试",function(index){
								  layer.close(index)
							  })
						  }
					 }
				  )
				  
			  },cancel: function(index){
				  layer.close(index);
			  }
		});
	}

}



//查询按钮
/**
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
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

function changeDefine(value){
	if (value == undefined){
		return ""
	}else{
		return value
	}
}

function enableOrDisable(statu,tid){
	if (statu == "1"){
		var str = "确定启用该商品？"
	}else{
		var str = "确定停用该商品？"
	}
	layer.confirm(str, {
		  btn: ['确定', '取消'],
		  yes:function(){
				var url = "commodityTypeManager/off.do";
				var data= {};
				data.status = encrypt.encrypt(statu+"");
				data.tId = encrypt.encrypt(tid+"");
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = r;
							if (data.status=="1"){
								layer.alert("操作成功",function(index){
									layer.close(index);
									$('#table_id').DataTable().ajax.reload();
								})
							}else if(data.status=="0"){
								layer.alert("操作失败",function(index){
									layer.close(index);
								})
							}
						})
		  },
		  cancel:function(index){
			  layer.close(index)
		  }
		})
}




$(function() {
	var appPath = getRootPath();//项目根路径
	
	$('#table_id').DataTable(
		{
			autoWidth : false,
			scrollY : 500,
			pagingType: "simple_numbers",//设置分页控件的模式  
			lengthMenu:[[10,25,50,-1],[10,25,50,"全部"]],
			colReorder : false,
			scrollX : true,
			sScrollX : "100%",
			sScrollXInner : "100%",
			bScrollCollapse : true,  
			processing: true, //打开数据加载时的等待效果  
	        serverSide: true,//打开后台分页
	        ajax: {  
	            "url": "commodityTypeManager/loadList.do",   
	            "dataSrc": "results",
	            "type":"get",
	            "data": function ( d ) {  
	                var good = goodType;
	                var mngName = changeDefine($("#mngName").val());
	                var statu = $("#getStatu").val();
	                d.goodType = encrypt.encrypt(good+"");
	                d.mngName = encrypt.encrypt(mngName+"");
	                d.statu = encrypt.encrypt(statu+"");
	            } 
	        },
	        initComplete:function(settings, data){
	        	console.log(data);
	        	$("#imgHost").val(data.map.picBasePath);
	        },
	        columns: [  
	                  {title:'',
	                	  "mRender": function (data, type, full) {
	                		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
			        		  return sReturn;
	                	  }
	                  },
	                  { title:"添加时间","data": "addTime" },
	                  { title:"商品类型名称","data": "commodityClassify" },  
	                  { title:"商品类型描述","data": "commodityClassifyDes" },  
	                  { title:"操作","data": "status",
	                	  "mRender": function (data, type, full) {
	                		  if(full.status==0){
			        			  return "<a onclick=\"enableOrDisable(1,'"+full.commodityTypeID+"');\" href=\"javascript:void(0);\">启用</a>" ;
			        		  }else if(full.status==1){
			        			  return "<a onclick=\"enableOrDisable(0,'"+full.commodityTypeID+"');\" href=\"javascript:void(0);\">停用</a>";
			        		  }
			        	  }
	                  },  
	                  { title:"状态","data": "status",
	                	  "mRender": function (data, type, full) {
			        		  if(data==0){
			        			  return "<font color='red'>无效</font>";
			        		  }else if(data==1){
			        			  return "有效";
			        		  }
			        	  }
	                  },
	                  { title:"最近一次操作员","data": "adminName" },
	        ],
	        aoColumnDefs : [
	        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
	        				{
	        					sDefaultContent: '',
	        					orderable : false,
	        					aTargets: [ 0,2,3,4,5,6 ]
	        				},
	        				{  
	                            "aTargets":[],  
	                            "visible":false  
	                        }
	        				],
		});
	
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

	 
	 $("#addProPage").click(function(){
		 if (goodType == "0"){
			 bankManagementAdd("添加");
		 }else if(goodType == "1"){
			 bankManagementAdd("添加");
		 }
	 });
	 
	$("#updateProPage").click(function(){
		 if (goodType == "0"){
			 bankManagementAdd("修改");
		 }else if(goodType == "1"){
			 bankManagementAdd("修改");
		 }
	});
	
	//上传插件初始化
	expUpload("#portraitUrl");
	
	
})