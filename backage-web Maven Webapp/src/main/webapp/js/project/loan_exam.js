
$(document).ready(function() {
	/**��***************项目审核*******************  **/
    /*** *************状态改变功能״̬********* ***/
    $('#loan_pro_exam').click(function(){
    	layer.open({
            type: 2,
            title: '项目审核',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/loan_pro_exam.jsp'
        });
    });
    
    
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