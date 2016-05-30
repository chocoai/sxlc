var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey_common);
$(document).ready(function() {
//启用停用
	$(".btn-enable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定启用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});

	$(".btn-disable").on("click touchstart",function(){
		//获取选取对象
		
		layer.confirm('确定停用？', {
			btn: ['确定', '取消']
		}, function(index, layero){
			//按钮【按钮一】的回调
			
			//执行完关闭
			layer.close(index);
		}, function(index){
			//按钮【按钮二】的回调
		});
	});
});
/* 代偿开始  */
function compenFunction(){
	var rowdata = $('#table_id').DataTable().rows('.selected').data();
	if (rowdata.length <= 0) {
		layer.alert("请选择要操作的记录！",{icon:0});
		return;
	}else {
		$.ajax({
			type : 'post',
			url : appPath + "/compensatory/query4compensatory.do",
			data : {
				repayID : encrypt.encrypt((rowdata[0].applyId + ""))
			},
			success : function (msg) {
				if (msg != null) {
					$("#projectNo").val(msg.projectNo);
					$("#projectTitle").val(msg.projectTitle);
					$("#personalName").val(msg.personalName);
					$("#logname").val(msg.logname);
					$("#index").val(msg.index);
					$("#sDRepayPrincipal").val(msg.sDRepayPrincipal);
					$("#sDRepayInterest").val(msg.sDRepayInterest);
					$("#repayOverdueInterest").val(msg.repayOverdueInterest);
					$("#repayOverdue").val(msg.repayOverdue);
				}
			}
		});
		layer.open({
			type: 1,
			area: ['500px', '300px'], //高宽
			title: "代偿",
			maxmin: true,
			content: $("#compenfunction"),//DOM或内容
			btn:['确定','返回'],
			yes: function(index, layero){ //或者使用btn1
			//确定的回调
			//判断执行不同方法
				
			
		},cancel: function(index){//或者使用btn2（concel）
			//取消的回调
		}
		});
		sub();
		
	}
	
}

function sub() {
	$(".layui-layer-btn0").on('click', function () {
		var rowdata = $('#table_id').DataTable().rows('.selected').data();
		var appplyId = encrypt.encrypt((rowdata[0].applyId + ""));
		var repalyId = encrypt.encrypt((rowdata[0].repayID + ""));
		var memberType = encrypt.encrypt((1 + ""));
		$("#appplyId").val(appplyId);
		$("#repalyId").val(repalyId);
		$("#memberType").val(memberType);
		$("#tocom").submit();
	});
}
/* 代偿结束  */
/**
 * 表格初始化
 */
$(function() {
	var appPath = getRootPath();//项目根路径
	$('#table_id').DataTable(
	{
		autoWidth : false,
		scrollY : 500,
		pagingType: "simple_numbers",//设置分页控件的模式  
		lengthMenu:[[5,10,25,50,-1],[5,10,25,50,"全部"]],
		colReorder : false,
		scrollX : true,
		sScrollX : "100%",
		sScrollXInner : "100%",
		bScrollCollapse : true,  
		processing: true, //打开数据加载时的等待效果  
        serverSide: true,//打开后台分页  
        ajax: {  
            "url": appPath + "/compensatory/guCompensatoryList.do",   
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
//                	  "sClass": "table-checkbox"
                  },
                  { title:"项目申请记录id","data": "applyId" },
                  { title:"还款计划id","data": "repayID" },
                  { title:"项目编号","data": "projectNo" },
                  { title:"产品类型","data": "projectName" },  
                  { title:"项目名称","data": "projectTitle" },  
                  { title:"期数","data": "indexs" },  
                  { title:"借款人姓名","data": "personalName" },  
                  { title:"借款人用户名","data": "logname" },
                  { title:"借款人手机号","data": "personalPhone" },
                  { title:"担保机构名称","data": "guaranteeName" },
                  { title:"实际借款金额","data": "realAmount" },
                  { title:"当期合约还款时间","data": "repayMaxTime" },
                  { title:"应代偿金额","data": "addDate" },
                  { title:"状态","data": "isCompensatory" },
                  { title:"操作","data": "isCompensatory" }
                  
        ],
        aoColumnDefs : [
        				// {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
        				{
        					sDefaultContent: '',
        					orderable : false,
        					aTargets: [ '_all' ]
        				},
        				{  
                            "aTargets":[1],  
                            "visible":true  
                        }
        				],
        rowCallback:function(row,data){//添加单击事件，改变行的样式      
//        	if($.inArray(data.DT_RowId,selected)!==-1){
//        		$(row).addClass('selected'); 
//        	}
        }
});
 var table = $('#table_id').DataTable();
//设置选中change颜色
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