$(function() {
	validform5(".layui-layer-btn0","dataForm",false,"3");
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/config/getRectalSetData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {  
					}  
				},
				columns: [  
				          {title:'',sWidth:"5%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"等级名称","data": "gradeName"},  
				          { title:"等级投资总金额","data": "totalInvest"},  
				          { title:"等级描述","data": "gradeRemark"},  
				          { title:"推荐VIP提奖金额","data": "vIPReward"},  
				          { title:"推荐借款提奖百分比","data": "borrowReward"},  
				          { title:"推荐借款还本提奖百分比","data": "repayReward" },  
				          { title:"推荐投资收益提奖百分比","data": "investReward"},  
				          { title:"推荐投资提奖百分比","data": "investReward", 
				        	  "mRender": function (data, type, full) {
				        		  return "该属性后台还没加";
				        	  }
				          },  //该属性后台还没加
				          { title:"操作","data": "", 
				        	  "mRender": function (data, type, full) {
				        		  if(full.statu==0){
				        			  return "<a onclick=\"enableOrDisable(1,'"+full.id+"');\" href=\"javascript:void(0);\">启用</a>" ;
				        		  }else if(full.statu==1){
				        			  return "<a onclick=\"enableOrDisable(0,'"+full.id+"');\" href=\"javascript:void(0);\">停用</a>";
				        		  }
				        	  }
				          }
	
				          ],
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,1,2,3,4,5,6,7,8,9]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          scrollCollapse: true,
	          scrollX : "100%",
			  scrollXInner : "100%",
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          }
	});//表格初始化完毕
	 
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
});


/**
 * 增加/修改按钮
 * @param type 1：增加 2：修改
 * @returns
 */
function handleBtn(type){
	$("#dataForm").attr("action","javascript:addOrUpdate("+type+");");
	//清空数据
	document.getElementById("dataForm").reset();
	$(".gradeName").val("");
	$(".totalInvest").val("");
	$(".recaltextarea").val("");
	$(".vIPReward").val("");
	$(".borrowReward").val("");
	$(".repayReward").val("");
	$(".investReward").val("");
	//操作
	var title="";
	if(type==1){
		title="添加";
	}else if(type==2){
		title="修改";
		var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
			layer.alert("请选择要修改的数据！",{icon:0});
			return;
		}
		$("#rewardId").val(data[0].id);
		$(".gradeName").val(data[0].gradeName);
		$(".totalInvest").val(data[0].totalInvest);
		$(".recaltextarea").val(data[0].gradeRemark);
		$(".vIPReward").val(data[0].vIPReward);
		$(".borrowReward").val(data[0].borrowReward);
		$(".repayReward").val(data[0].repayReward);
		$(".investReward").val(data[0].investReward);
	}
	//打开弹出窗口
	layer.open({
		type: 1,
		area: ['550px', '500px'], //高宽
		title: title,
		maxmin: true,
		content: $("#addrectal"),//DOM或内容
		btn:['确定', '取消']
	,yes: function(index, layero){ //或者使用btn1
		$("#dataForm").submit();
	},cancel: function(index){//或者使用btn2（concel）
		//取消的回调
	}
	});
}
/**
 * 增加/修改操作
 * @param type 1：增加 2：修改
 * @returns
 */
function addOrUpdate(type){
	//加密参数
	var data={};
	var gradeName = encrypt.encrypt($(".gradeName").val());
	data.gradeName=gradeName;
	var totalInvest = encrypt.encrypt($(".totalInvest").val());
	data.totalInvest=totalInvest;
	var gradeRemark = encrypt.encrypt($(".recaltextarea").val());
	data.gradeRemark=gradeRemark;
	var vIPReward = encrypt.encrypt($(".vIPReward").val());
	data.vIPReward=vIPReward;
	var borrowReward = encrypt.encrypt($(".borrowReward").val());
	data.borrowReward=borrowReward;
	var repayReward = encrypt.encrypt($(".repayReward").val());
	data.repayReward=repayReward;
	var investReward = encrypt.encrypt($(".investReward").val());
	data.investReward=investReward;
	var rewardId = encrypt.encrypt($("#rewardId").val());
	data.rewardId=rewardId;
	//还有一个参数(推荐投资提奖百分比)，后台待传,实体没有，说是后面要加
	data.type=encrypt.encrypt(""+type);
	
	$.ajax( {  
		url:appPath+"/config/addOrUpdateReward",
		data:data,
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				$(".layui-layer-btn1").click();
				 var table = $('#table_id').DataTable();
				 table.ajax.reload();
			}else if(data==0){
				layer.alert("操作失败",{icon:2});  
			}else if(data==-1){
				layer.alert("已存在！",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	});
			  
}


/**
 * 启用/停用功能
 * @param type 1：启用 0：停用
 * @param id 
 * @returns
 */
function enableOrDisable(type,id){
	$.ajax( {  
		url: appPath+"/config/enableRewardSet.do",
		data: {"statu":encrypt.encrypt(""+type),"id":encrypt.encrypt(id+"")},
		type:'post',  
		cache:false,  
		dataType:'json',  
		success:function(data) { 
			if(data==1){
				layer.alert("操作成功",{icon:1});
				var table = $('#table_id').DataTable();
				table.ajax.reload();
			}else if(data==0){
				layer.alert("操作失败",{icon:2});  
			}
		},  
		error : function() {  
			layer.alert("服务器异常",{icon:2});  
		}  
	}); 
}
