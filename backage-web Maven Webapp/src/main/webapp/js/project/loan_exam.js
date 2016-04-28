$(document).ready(function() { 
    /******************查看项目详情**********************/
    $('#loan_pro_detail').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '项目详情',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/loan_detail.jsp'
    	});
    });
    
    /** *************查看历史审批记录************** **/
    $('#history_exam_record').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '历史审批记录',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/history_exam_record.jsp'
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
function proAudit(){
	/*******项目审核*******/
	$(".right_col").load("web/project/pro-add/loan_pro_exam.jsp");
}
