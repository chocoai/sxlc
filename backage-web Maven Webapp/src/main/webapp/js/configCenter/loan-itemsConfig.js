/**
 *前台界面配置
 *借款认证
 * 添加修改部分代码直接写在页面上的，加快渲染速度
 * 每次执行操作前请清空目标盒子的数值
 */

$(function() {
	validform5("layui-layer-btn0","dataForm",false,"3");
	/* 自行编辑协议配置 */
	LoanIntemsList();	//
	 $("input[type='checkbox']").click(function() {
	     if($(this).prop("checked")) {
	         $(this).attr("checked", true);
	         $(this).siblings().prop("checked",false);
	     }
	 });
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
});

/**
 * 增加/修改借款认证
 * @param type 0：增加 1：修改
 * @returns
 */
function addOrModify(type){
	//清除数据
	validform5(".layui-layer-btn0","dataForm",true,3);
	//清除数据
	document.getElementById("dataForm").reset();
	//操作
	var title="";
	if(type==0){
		title="添加认证";
		$("#dataForm").attr("action","javascript:addOrUpdate(0)");
	}else if(type==1){
		title="修改认证";
		$("#dataForm").attr("action","javascript:addOrUpdate(1)");
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		if(rowdata.length<1){
			layer.alert("请选择要修改的认证！",{icon:0});
			return;
		}
		var type =rowdata[0].identyConfigType;
		$("#membertype option[value="+type+"]").attr("selected","selected");
		$(".attach").each(function(){
			if($(this).val() == rowdata[0].attachType){
				$(this).prop("checked","checked");
			}
		});
		$("#attestTypeName").val(rowdata[0].attestTypeName);
		$("#creditScore").val(rowdata[0].creditScore);
	}
	var title =title;
	layer.open({
	    type: 1,
	    area: ['500px', '300px'], //高宽
	     title: title,
	    maxmin: true,
	    content: $(".loanitem-add"),//DOM或内容
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

//添加借款认证
function addidentyConfig(){
    var attachtype =$('input[name="attach"]:checked').val();//附件类型
    var creditScore = $("#creditScore").val();
    var attestTypeName = $("#attestTypeName").val();
    var membertype = $("#membertype").val();
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey_common);
	//result 为加密后参数
	creditScore = encrypt.encrypt(creditScore+""); 
	attestTypeName = encrypt.encrypt(attestTypeName); 
	attachtype = encrypt.encrypt(attachtype); 
	membertype = encrypt.encrypt(membertype); 
	$.ajax( {  
		url:appPath+"/identyConfig/saveIdenty.do",
		data:{
			score:creditScore,
			attachType:attachtype,
			centifyName:attestTypeName,
			memberType:membertype
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
				layer.alert("该名称的已存在",{icon:2});  
			}
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
		 addidentyConfig();
	 }else{
		 updateidentyConfig();
	 }
	 
 } 
/**
 * 修改借款认证
 * @returns
 */
  function updateidentyConfig(){
	    var rowdata = $('#table_id').DataTable().rows('.selected').data();
	    var attachtype =$('input[name="attach"]:checked').val();//附件类型
	    var	attestTypeID=rowdata[0].attestTypeID;
	    var creditScore = $("#creditScore").val();
	    var attestTypeName = $("#attestTypeName").val();
	    var membertype = $("#membertype").val();
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		attestTypeID = encrypt.encrypt(attestTypeID+"");   
		creditScore = encrypt.encrypt(creditScore+""); 
		attestTypeName = encrypt.encrypt(attestTypeName); 
		attachtype = encrypt.encrypt(attachtype); 
		membertype = encrypt.encrypt(membertype); 
		$.ajax( {  
			url:appPath+"/identyConfig/updateMemberIdenty.do",
			data:{
				id:attestTypeID,
				score:creditScore,
				attachType:attachtype,
				centifyName:attestTypeName,
				memberType:membertype
			},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data==1){
					layer.alert("修改成功",{icon:1});
					$(".layui-layer-btn1").click();
					setTimeout('location.reload()',500);
				}else{
					layer.alert("修改失败",{icon:2});  
				}
			},  
			error : function() {  
				layer.alert("操作失败!",{icon:2});  
			}  
		});
	}
 
  

/**
 * 
 * @param id   认证id
 * @param statu 认证状态
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
			url : appPath+"/identyConfig/changeIdentyStatu.do",
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
 * 查询按钮
 */
$(".glyphicon-search").on("click",function(){
	$('#table_id').DataTable().ajax.reload();
	
});

/**
 * 列表
 */
function LoanIntemsList(){
	$('#table_id').DataTable(
			{
				autoWidth : false,
				scrollY : 500,
				pagingType: "simple_numbers",//设置分页控件的模式  
				paging : true,//分页
//						searching : false,
				info : true,// 左下角信息
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
		            "url": appPath+"/identyConfig/getIdentyList.do",   
		            "dataSrc": "results",   
		            "data": function ( d ) {  
		            	var identyName = $("#identyName").val();//认证名
		            	var iStatu =  $("#iStatu").val();//状态
		            	var membertype1 =  $("#membertype1").val();//会员类型
		            	var encrypt = new JSEncrypt();
		            	encrypt.setPublicKey(publicKey_common);
		            	
		            	identyName = encrypt.encrypt(identyName);
		            	iStatu = encrypt.encrypt(iStatu+"");
		            	membertype1 = encrypt.encrypt(membertype1+"");
		            	
		            	d.membertype1=membertype1;
		            	d.identyName=identyName;
		            	d.iStatu=iStatu;
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
		                  { title:"认证项名称","data": "attestTypeName" },  
		                  { title:"附件格式","data": "identyConfigDetail", 
				        	  "mRender": function (data, type, full) {
				        		  if(full.attachType==0){
				        			  sReturn = "<font color='red'>图片</font>";
				        		  }else if(full.attachType==1){
				        			  sReturn = "<font color='red'>offic文件</font>";
				        		  }else if(full.attachType==2){
				        			  sReturn = "<font color='red'>音频</font>";
				        		  }else if(full.attachType==3){
				        			  sReturn = "<font color='red'>视频</font>";
				        		  }
				        		 return sReturn;
				        	  }
				          }, 
				          { title:"默认最高信用分数","data": "creditScore" },  
				          { title:"操作时间","data": "sOptDate" },  
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
			                		  sReturn = "<a href='javascript:stopOrStart("+full.attestTypeID+",0);' class='btn-enable'>停用</a>";
			                	  }else{
			                		  sReturn = "<a href='javascript:stopOrStart("+full.attestTypeID+",1);' class='btn-disable'>启用</a>";
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
