$(function(){
	//标签页初始化
	$(".showUlLi").on("click",function(){
		var $this = $(this);
		var sIndexs = $this.attr("sIndexs");
		var pushIndex = $("#pushIndex").val();
		if(sIndexs != pushIndex){//除审核发布节点的其他审核节点
			window.location.href=appPath+"/project/toLoanChkList?content="+sIndexs;
		}else{
			window.location.href=appPath+"/project/toPostListPg";
		}
	});
	
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getProPublishData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var ProjectTitle = $(".ProjectTitle").val();
						var Logname = $(".Logname").val();
						var memberNo = $(".memberNo").val();
						var name = $(".name").val();
						var checkStatu = $(".checkStatu").val();
						var projectNO = $(".projectNO").val();
						var pushstartTime = $("#startDate").val();
						var pushendTime = $("#endDate").val();
						var sIndexs = $("#pushIndex").val();
						d.ProjectTitle = encrypt.encrypt(ProjectTitle);
						d.Logname = encrypt.encrypt(Logname);
						d.memberNo = encrypt.encrypt(memberNo);
						d.name = encrypt.encrypt(name);
						d.checkStatu = encrypt.encrypt(checkStatu);
						d.projectNO = encrypt.encrypt(projectNO);
						d.pushstartTime = encrypt.encrypt(pushstartTime);
						d.pushendTime = encrypt.encrypt(pushendTime);
						d.sIndexs = encrypt.encrypt(sIndexs);
						d.order = encrypt.encrypt("2");//  1:Amount desc   -1:Amount asc   2:Release_Date desc   -2:Release_Date asc
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"项目名称","data": "projectBaseInfoentity.projectTitle"},  
				          { title:"项目审批通过日期","data": "releaseDate"},  
				          { title:"项目编号","data": "projectNo"},  
				          { title:"借款人编号","data": "memberNo"},  
				          { title:"借款人用户名","data": "logname"},  
				          { title:"借款人名称","data": "memberName"},  
				          { title:"产品类型","data": "projectName"},  
				          { title:"借款期限","data": "projectBaseInfoentity.deadline"},  
				          { title:"借款金额(元)","data": "projectBaseInfoentity.amounts"},  
				          { title:"年化利率(%)","data": "projectBaseInfoentity.yearRates"},  
				          { title:"状态","data": "checkStatu", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data == 0){
				        	    		return "未发布";
				        	    	}else if(data == 1){
				        	    		return "已发布";
				        	    	}else if(data == -1){
				        	    		return "已拒绝";
				        	    	}else{
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"项目发布时间","data": "releaseDate"}  
				          ],
			  aaSorting : [ [ 2, "desc" ],[ 10, "desc" ],[ 12, "desc" ] ],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [ 0, 1, 3, 4, 5, 6, 7, 8, 9, 11 ]
	                          } // 制定列不参与排序
	                          ],
	          pagingType: "simple_numbers",//设置分页控件的模式  
	          processing: true, //打开数据加载时的等待效果  
	          serverSide: true,//打开后台分页  
	          scrollCollapse: true,
	          scrollX : "100%",
			  scrollXInner : "100%",
	          rowCallback:function(row,data){//添加单击事件，改变行的样式      
	          },
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
	
	 /**
	  * 查询按钮
	  */
	 $(".glyphicon-search").on("click",function(){
		$('#table_id').DataTable().ajax.reload();
		
	 });
});


$(function(){
//	拒绝
	$('#refuse').click(function(){
		var rdata = $('#table_id').DataTable().rows('.selected').data();
		if(rdata.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
		}
		layer.confirm('你确定要拒绝吗？', {
			  btn: ['确定','取消'] //按钮
			},function(){
				var data={};
				var applyId = rdata[0].applyId;//申请ID
				data.applyId =  encrypt.encrypt(applyId+"");
				
				$.ajax( {  
					url:appPath+"/project/refuseProBorrow",
					data: data,  
					type:'post',  
					cache:false,  
					dataType:'json',  
					success:function(data) { 
						if(data > 0){
							layer.alert("操作成功!",{icon:1});  
							var table = $('#table_id').DataTable();
							table.ajax.reload();
						}else if(data == 0){
							layer.alert("未找到项目!",{icon:2});  
						}
					},  
					error : function() {  
						layer.alert("服务器异常!",{icon:2});  
					}  
				});
				
			});
	});
//	项目借款结束日期延长
	$('#end_time_along').click(function(){
		var rdata = $('#table_id').DataTable().rows('.selected').data();
		if(rdata.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
		}
		layer.open({
		    type: 1,
		    area: ['500px', '240px'], //宽高
		    title: "项目借款结束日期延长",
		    content: $(".extendTime"),//DOM或内容
		    btn:['确认延长', '取消']
			  ,yes: function(index, layero){ //或者使用btn1
			    //确定的回调
				  var data={};
				  var applyId = rdata[0].applyId;//申请ID
				  var endDate = $("#modify_endTime").val();
				  if(endDate=="" || endDate == null){
					  layer.alert("请选择日期！",{icon:0});  
					  return;
				  }
				  data.endDate = encrypt.encrypt(endDate);
				  data.applyId =  encrypt.encrypt(applyId+"");
				  $.ajax( {  
					  url:appPath+"/project/updateEndtime",
					  data: data,  
					  type:'post',  
					  cache:false,  
					  dataType:'json',  
					  success:function(data) { 
						  if(data > 0){
							  layer.alert("操作成功!",{icon:1});  
							  var table = $('#table_id').DataTable();
							  table.ajax.reload();
						  }else if(data == 0){
							  layer.alert("未找到项目!",{icon:2});  
						  }
					  },  
					  error : function() {  
						  layer.alert("服务器异常!",{icon:2});  
					  }  
				  });
			  },cancel: function(index){//或者使用btn2（concel）
			  	//取消的回调
			  }
		});
		
	});
});
/******查看借款项目详情*******/
function view_detail(){
	var data = $('#table_id').DataTable().rows('.selected').data(); 
	if(data.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
	}
	var applyId = data[0].applyId;//Project_App_Record 表Apply_Id
	window.location.href=appPath+"/project/toProjectdetailPg?content="+applyId;
}
/******发布*******/
function proPost(){
	var data = $('#table_id').DataTable().rows('.selected').data(); 
	if(data.length<1){
		layer.alert("请选择项目！",{icon:0});
		return;
	}
	if(data[0].checkStatu == 1){
		layer.alert("该项目已发布！",{icon:0});
		return;
	}
	var applyId = data[0].applyId;//Project_App_Record 表Apply_Id
	window.location.href=appPath+"/project/toLoanProPostPg?content="+applyId+"&start="+$("#pushIndex").val()+"&length=2";
}

