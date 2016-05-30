/**
 * 版块：配置中心-----会员等级配置
 * 内容介绍：
 */

//加密设置
var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);

$(function(){
	//表格初始化
	$('#table_id').DataTable({
		ajax: {  
			"url": appPath+"/config/getCreditLevel.do",   
			"dataSrc": "results", 
			"type": "POST",
			"data": function ( d ) {  
			}  
		},
		columns: [ 
		          {title:'',sWidth:"3%", 
		        	  "mRender": function (data, type, full) {
		        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
		        		  return sReturn;
		        	  }
		          },
		          { title:"会员信用等级","data": "levelMark"},  
		          { title:"对应开始分数","data": "creditScoreMin"},  
		          { title:"对应结束分数","data": "creditScoreMax"},  
		          { title:"等级描述","data": "levelDetail"},  
		          { title:"操作","data": "", 
		        	  "mRender": function (data, type, full) {
		        		return '<a href="javascript:void(0);" onclick="deleteData('+full.id+')" class="invest-fee-del">删除</a>';
		        	  }
		          }
		          ],
	  ordering:false,
//	  aoColumnDefs : [
//	                  {
//	                	  "orderable" : false,
//	                	  "aTargets" : [ 0, 1,2, 3, 4, 5 ]
//	                  } // 制定列不参与排序
//	                  ],
	  pagingType: "simple_numbers",//设置分页控件的模式  
	  processing: true, //打开数据加载时的等待效果  
	  serverSide: true,//打开后台分页  
	  searching: false,
	  scrollCollapse: true,
      scrollX : "100%",
      scrollXInner : "100%",scrollY:500,
	  rowCallback:function(row,data){//添加单击事件，改变行的样式      
	  }
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
	 
	 /**
	 * 增加按钮
	 */
	$(".obtn-memcredit-grade-add").on("click",function(){
		//清空数据
		$("#levelMark").val("");
		$("#creditScoreMin").val("");
		$("#creditScoreMax").val("");
		$("#levelDetail").val("");
		//打开弹窗
		layer.open({
		    type: 1,
		    area: ['400px', '300px'], //高宽
		    title: "添加会员信用等级",
		    content: $(".memcredit-grade-add"),//DOM或内容
		    btn:['确定', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
				  var levelMark = $("#levelMark").val();
				  var creditScoreMin = $("#creditScoreMin").val();
				  var creditScoreMax = $("#creditScoreMax").val();
				  var levelDetail = $("#levelDetail").val();
				  var reg = new RegExp("^[0-9]{0,5}$");  
				  if(levelMark==""){
					  layer.alert("请输入会员信用等级",{icon:0});
					  return;
				  }
				  if(creditScoreMin==""){
					  layer.alert("请输入开始分数",{icon:0});
					  return;
				  }
				  if(creditScoreMax==""){
					  layer.alert("请输入结束分数",{icon:0});
					  return;
				  }
				  if(!reg.test(creditScoreMin) || !reg.test(creditScoreMax)){  
					 layer.alert("分数输入错误,请输入5位内的整数",{icon:0});
					 return;
				  }
				  if(Number(creditScoreMin) >= Number(creditScoreMax)){
					  layer.alert("输入错误,开始分数应小于结束分数",{icon:0});
					  return;
				  }
				  
				  $.ajax( {  
						url:appPath+"/config/addCreditLevel.do",
						data:{"levelMark":encrypt.encrypt(levelMark),"creditScoreMin":encrypt.encrypt(creditScoreMin),"creditScoreMax":encrypt.encrypt(creditScoreMax),"levelDetail":encrypt.encrypt(levelDetail)},
						type:'post',  
						cache:false,  
						dataType:'json',  
						success:function(data) { 
							if(data>0){
								layer.alert("操作成功",{icon:1});
								$(".layui-layer-btn1").click();
								var table = $('#table_id').DataTable();
								table.ajax.reload();
							}else if(data==0){
								layer.alert("操作失败",{icon:2});  
							}else if(data ==-1){
								layer.alert("开始分数不能小于已有等级的结束分数",{icon:2});  
							}
						},  
						error : function() {  
							layer.alert("服务器异常",{icon:2});  
						}  
					});
				  
			  },cancel: function(index){//或者使用btn2（concel）
			  }
		});
	});
	 
});


/**
 * 删除
 */
function deleteData(param){
	layer.confirm('确定要删除该条记录吗？', {
		btn: ['确定', '取消']
	}, function(index, layero){
		$.ajax( {  
			url:appPath+"/config/delCreditLevel.do",
			data:{"id":encrypt.encrypt(""+param)},
			type:'post',  
			cache:false,  
			dataType:'json',  
			success:function(data) { 
				if(data>0){
					layer.alert("操作成功",{icon:1});
					layer.close(index);
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
	}, function(index){
		
	});
}
