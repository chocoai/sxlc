/**
 * 版块：配置中心-----会员等级配置
 * 内容介绍：
 */

	$(function(){
		//表格初始化
		$('#table_id').DataTable({
			ajax: {  
				"url": appPath+"/config/getMemberLevel.do",   
				"dataSrc": "results", 
				"type": "POST",
				"data": function ( d ) {  
				}  
			},
			columns: [  
			          {title:'<input type="checkbox"  value="1" />',
			        	  "mRender": function (data, type, full) {
			        		  return  '<input type="checkbox" value="1" />';
			        	  },
			          sClass: "table-checkbox"
			          },
			          { title:"id","data": "id"},  
			          { title:"会员等级","data": "levelMark"},  
			          { title:"对应开始积分","data": "scoreMin"},  
			          { title:"对应结束积分","data": "scoreMax"},  
			          { title:"等级描述","data": "levelDetail"},  
			          { title:"操作","data": "", 
			        	  "mRender": function (data, type, full) {
			        		return '<a href="javascript:void(0);" onclick="deleteData('+full.id+')" class="invest-fee-del">删除</a>';
			        	  }
			          }
			          ],
		  aoColumnDefs : [
		                  {"bVisible": false, "aTargets": [1]}, //控制列的隐藏显示
		                  {
		                	  "orderable" : false,
		                	  "aTargets" : [ 0, 1,2, 3, 4, 5 ]
		                  } // 制定列不参与排序
		                  ],
		  pagingType: "simple_numbers",//设置分页控件的模式  
		  processing: true, //打开数据加载时的等待效果  
		  serverSide: true,//打开后台分页  
//			  info:false,
		  rowCallback:function(row,data){//添加单击事件，改变行的样式      
		  }
		});
		
		//选中
		 $('#table_id tbody').on( 'click', 'tr', function () {
		        $(this).toggleClass('selected');
		 });
		 
		 /**
		 * 增加按钮
		 */
		$(".obtn-memgrade-add").on("click",function(){
			//清空数据
			$("#levelMark").val("");
			$("#scoreMin").val("");
			$("#scoreMax").val("");
			$("#levelDetail").val("");
			layer.open({
			    type: 1,
			    area: ['400px', '300px'], //高宽
			    title: "添加会员等级配置",
			    content: $(".memgrade-add"),//DOM或内容
			    btn:['确定', '取消']
				  ,yes: function(index, layero){ //或者使用btn1
					  var levelMark = $("#levelMark").val();
					  var scoreMin = $("#scoreMin").val();
					  var scoreMax = $("#scoreMax").val();
					  var levelDetail = $("#levelDetail").val();
					  
					  var reg = new RegExp("^[1-9][0-9]{0,4}$");  
					  if(!reg.test(scoreMin) || !reg.test(scoreMax)){  
						 layer.alert("积分输入错误,请输入5位内的整数",{icon:0});
						 return;
					  }		
					  if(Number(scoreMin)>Number(scoreMax)){
						  layer.alert("输入错误,开始积分应小于结束积分",{icon:0});
						  return;
					  }
					  
					  $.ajax( {  
							url:appPath+"/config/addMemberLevel.do",
							data:{"levelMark":levelMark,"scoreMin":scoreMin,"scoreMax":scoreMax,"levelDetail":levelDetail},
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
				url:appPath+"/config/delMemberLevel.do",
				data:{"id":param},
				type:'post',  
				cache:false,  
				dataType:'json',  
				success:function(data) { 
					if(data>0){
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
			layer.close(index);
		}, function(index){
			
		});
	}
