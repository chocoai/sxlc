
$(document).ready(function() {
    /*** *************项目详情״̬********* ***/
    $('#deal_list_pro_detail').click(function(){
    	layer.open({
            type: 2,
            title: '项目详情',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/deal_list_pro_detail.jsp'
        });
    });
    
    
    /******************还款详情**********************/
    $('#deal_list_pay_detail').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '还款详情',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/deal_list_pay_detail.jsp'
    	});
    });
    
    /** *************贷后监管************** **/
    $('#deal_list_supervice_list').on('click', function(){
    	layer.open({
    		type: 2,
    		title: '贷后监管',
    		maxmin: true,
    		shadeClose: true, //点击遮罩关闭层
    		area : ['800px' , '520px'],
    		content: 'web/project/deal_list_supervice_list.jsp'
    	});
    });
});