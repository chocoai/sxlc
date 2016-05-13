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
});


$(document).ready(function() { 
    /** *************查看历史审批记录************** **/
    $('#history_exam_record').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '历史审批记录',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/pro-add/loan_exam_record.jsp'
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
	$(".right_col").load("web/project/pro-add/loan_pro_exam.jsp");
}
/******查看借款项目详情*******/
function view_detail(){
	$(".right_col").load("web/project/pro-add/loan_pro_detail.jsp");
}