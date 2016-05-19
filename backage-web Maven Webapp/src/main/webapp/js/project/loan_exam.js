$(function(){
	//标签页初始化
	$(".showUlLi").on("click",function(){
		var $this = $(this);
		var sIndexs = $this.attr("sIndexs");
		var pushIndex = $("#pushIndex").val();
		var initPg = $("#sIndexs").val();
		if(sIndexs == pushIndex){//表明是审核发布节点
			window.location.href=appPath+"/project/toPostListPg";
		}else{//不是审核发布节点
			window.location.href=appPath+"/project/toLoanChkList?content="+sIndexs;
		}
	});
	
	//表格初始化
	$('#table_id').DataTable(
			{	
				ajax: {  
					"url": appPath+"/project/getProAuitData",   
					"dataSrc": "results", 
					"type": "POST",
					"data": function ( d ) {
						//加密
						var ProjectTitle = $(".ProjectTitle").val();
						var Logname = $(".Logname").val();
//						var memberNo = $(".memberNo").val();
						var name = $(".name").val();
//						var checkStatu = $(".checkStatu").val();
//						var projectNO = $(".projectNO").val();
						var startTime = $("#startDate").val();
						var endTime = $("#endDate").val();
						var statu = $("#statu").val();
						var sIndexs = $("#sIndexs").val();
						d.ProjectTitle = encrypt.encrypt(ProjectTitle);
						d.Logname = encrypt.encrypt(Logname);
//						d.memberNo = encrypt.encrypt(memberNo);
						d.name = encrypt.encrypt(name);
//						d.checkStatu = encrypt.encrypt(checkStatu);
//						d.projectNO = encrypt.encrypt(projectNO);
						d.startTime = encrypt.encrypt(startTime);
						d.endTime = encrypt.encrypt(endTime);
						d.sIndexs = encrypt.encrypt(sIndexs);
						d.statu = encrypt.encrypt(statu);
//						d.order = encrypt.encrypt("2");//  1:Amount desc   -1:Amount asc   2:Release_Date desc   -2:Release_Date asc
					}  
				},
				columns: [  
				          {title:'',sWidth:"3%", 
				        	  "mRender": function (data, type, full) {
				        		  sReturn = '<input type="checkbox" class="tr-checkbox" value="1" />';
				        		  return sReturn;
				        	  }
				          },
				          { title:"借款人申请日期","data": "recordDate"},  
				          { title:"借款申请项目编号","data": "projectNo"},  
				          { title:"借款人用户名","data": "logname"},  
				          { title:"借款人姓名","data": "memberName"},  
				          { title:"借款项目名称","data": "projectBaseInfoentity.projectTitle"},  
				          { title:"借款产品类型","data": "projectName"},  
				          { title:"借款期限","data": "projectBaseInfoentity.deadline"},  
				          { title:"借款金额(元)","data": "projectBaseInfoentity.amounts"},  
				          { title:"年化利率(%)","data": "projectBaseInfoentity.yearRates"},  
				          { title:"还款方式","data": "projectBaseInfoentity.repayWay", 
				        	  "mRender": function (data, type, full) {
				        		  if(data == 0){
				        	    		return "等额本息";
				        	    	}else if(data == 1){
				        	    		return '每月还息，到期还本';
				        	    	}else if(data == 2){
				        	    		return "到期还息本";
				        	    	}else if(data == 3){
				        	    		return "等额本金";
				        	    	}else{
				        	    		return "";
				        	    	}  
				        	  }
				          },  
				          { title:"状态","data": "checkStatuNow", 
				        	  "mRender": function (data, type, full) {
				        		  	if(data == 1){
				        	    		return "已审核";
				        	    	}else{
				        	    		return "未审核";
				        	    	}  
				        	  }
				          }  
				          ],
//			  aaSorting : [ [ 2, "desc" ],[ 10, "desc" ],[ 12, "desc" ] ],//默认第几个排序
	          aoColumnDefs : [
	                          {
	                        	  "orderable" : false,
	                        	  "aTargets" : [0,1,2,3,4,5,6,7,8,9,10,11]
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



$(document).ready(function() { 
    /** *************查看历史审批记录************** **/
    $('#history_exam_record').on('click', function(){
    	
    	var data = $('#table_id').DataTable().rows('.selected').data();
		if(data.length<1){
				layer.alert("请选择要查看的项目！",{icon:0});
				return;
		}
		var applyId = data[0].applyId;
	    layer.open({
	        type: 2,
	        title: '历史审批记录',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        content: appPath+'/project/toCheckRecordPg?content='+applyId
	    });
    });
});
function del(){
	layer.confirm('删除?', {title:'提示'}, function(index){
		  //do something
	  layer.close(index);
	});
}
function down(){
	layer.confirm('下载?', {title:'提示'}, function(index){
		  //do something
	  layer.close(index);
	});
}

/*******项目审核*******/
function proAudit(){
	var data = $('#table_id').DataTable().rows('.selected').data(); 
	if(data.length<1){
			layer.alert("请选择项目！",{icon:0});
			return;
	}
	if(data[0].checkStatuNow == 1){
			layer.alert("该项目已审核！",{icon:0});
			return;
	}
	var applyId = data[0].applyId;//Project_App_Record 表Apply_Id
	window.location.href=appPath+"/project/toLoanProPostPg?content="+applyId+"&start="+$("#sIndexs").val()+"&length=1";
//	$(".right_col").load("web/project/pro-add/loan_pro_exam.jsp");
}
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