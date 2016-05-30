/**
 *前台界面配置
 *协议配置
 * 添加修改部分代码直接写在页面上的，加快渲染速度
 * 每次执行操作前请清空目标盒子的数值
 */

$(function() {
	validform5("layui-layer-btn0","addagreementName",false,"5");
	/* 自行编辑协议配置 */
	ue = UE.getEditor('agreementadd');
	AgreementList();	//
	//单选
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
		
	} );
	/* 下拉框内字体颜色 */
	$(".linkedoperation").css("color","#aaa");
	$(".linkedoperation").change(function(){
		if($(this).val()!="请选择"){
			$(this).css("color","#000");
		}else{
			$(this).css("color","#aaa");
		}
	});
});

/**
 * 增加/修改专家顾问操作
 * @param type 0：增加 1：修改
 * @returns
 */
function addOrModify(type){
	//清除数据
	validform5(".layui-layer-btn0","dataForm",false,3);
	//清除数据
	document.getElementById("dataForm").reset();
	$("#select_type").prop("disabled",false);
	//操作
	var title="";
	if(type==0){
		title="添加协议";
		ue.addListener("ready", function () {
	    	ue.setContent("");//('insertHtml', rowdata[0].sgContent);
	    });
		$("#dataForm").attr("action","javascript:addOrUpdate(0)");
	}else if(type==1){
		title="修改协议";
		$("#dataForm").attr("action","javascript:addOrUpdate(1)");
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要修改的协议！",{icon:0});
			return;
		}
		var type =rowdata[0].agreementType;
		$("#select_type").val(type);
		ue.addListener("ready", function () {
        	ue.setContent(rowdata[0].agreementDetail);//('insertHtml', rowdata[0].sgContent);
	    });
	}
	layer.open({
	    type: 1,
	    area: ['750px', '550px'], //高宽
	     title: title,
	    maxmin: true,
	    content: $(".agreement-add"),//DOM或内容
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
function addAgreement(){
	var agreeType = $("#select_type").val();
	//获取ueditor内容
	var content = ue.getContent();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	agreeType = encrypt.encrypt(agreeType+"");
	$(".layui-layer-btn0").addClass("disabled");
	$.ajax( {  
		 url:appPath+"/agreement/saveAgreeConfig.do",
		data:{
			agreeType:agreeType,
			content:content
		},
		type:'post',  
		cache:false,  
		dataType:'json',   
		success:function(data) { 
			 if(data==1){
				layer.alert("添加成功",{icon:1});
				$(".layui-layer-btn1").click();
				$('#table_id').DataTable().ajax.reload();
			}else if(data==-1){
				layer.alert("该协议已存在！",{icon:2});  
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
		 addAgreement();
	 }else{
		 updateAgreement();
	 }
	 
 } 
/**
 * 修改协议
 * @returns
 */
  function updateAgreement(){
	    var rowdata = $('#table_id').DataTable().rows('.selected').data();
	    var	id=rowdata[0].id;
	    var content = ue.getContent();
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		id = encrypt.encrypt(id+"");   
		$(".layui-layer-btn0").addClass("disabled");
		$.ajax( {  
			url:appPath+"/agreement/updateConfig.do",
			data:{
				id:id,
				content:content
			},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data==1){
					layer.alert("修改成功",{icon:1});
					$(".layui-layer-btn1").click();
					$('#table_id').DataTable().ajax.reload();
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
 * 
 * @param id   协议id
 * @param statu 协议状态
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
			url : appPath+"/agreement/changeAgreeStatu.do",
				data:{
					agreeType:id,
					agreeStatu:statu
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
				  	$(".layui-layer-btn1").click();
					$('#table_id').DataTable().ajax.reload();
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
function AgreementList(){
	$('#table_id').DataTable(
			{
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
		            "url": appPath+"/agreement/getAgreeList.do",   
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
		                  { title:"协议名称","mRender": function(data,type,full){
		                	  var sReturn ="";
		                	  if(full.agreementType==0){
		                		  	sReturn= "注册协议";
			            		}else if(full.agreementType==1){
			            			sReturn= "投资协议";
			            		}else if(full.agreementType==2){
			            			sReturn = "借款协议";
			            		}else if(full.agreementType==3){
			            			sReturn = "债权转让协议";
			            		}else if(full.agreementType==4){
			            			sReturn = "债权转让投资协议";
			            		}
		                	  return sReturn;
			                  }
		                  },  
		                  { title:"协议内容","data": "agreementDetail", 
				        	  "mRender": function (data, type, full) {
				        		  return '<a href="javascript:void(0);" class="btn-det" onclick="showDetail(this)">查看详情</a>';
				        	  }
				          },  
		                  { title:"状态","mRender":function(data, type, full){
		                	  var sReturn ="";
		                	  if(full.agreementStatu==1){
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
		                		  if(full.agreementStatu==1){
			                		  sReturn = "<a href='javascript:stopOrStart("+full.agreementType+",0);' class='btn-enable'>停用</a>";
			                	  }else{
			                		  sReturn = "<a href='javascript:stopOrStart("+full.agreementType+",1);' class='btn-disable'>启用</a>";
			                	  }
		                	  }else{
		                		  sReturn = "<a href='javascript:void(0);' class='btn-disable'></a>";
		                	  }
		                		  return sReturn;
		                  	}
		                }
		                  
		        ],
		        aoColumnDefs : [
		        				{"bVisible": false, "aTargets": []}, //控制列的隐藏显示
		        				{
		        					orderable : false
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
 * 查看详情
 */
function showDetail(btn){
	$(".report-det").html("");//清空数据
	var data = $('#table_id').DataTable().row($(btn).parents('tr')).data();
	$(".report-det").html(data.agreementDetail);
	
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
