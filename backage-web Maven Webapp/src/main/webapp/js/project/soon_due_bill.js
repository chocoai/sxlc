$(function(){
//借款项目详情
	$('.obtn-loan-prodetail').click(function(){
		$(".right_col").load('web/project/pro-add/loan_pro_detail.jsp');
	});
//	账单详情
	$('.obtn-bill-detail').click(function(){
    	layer.open({
            type: 2,
            title: '账单详情',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '500px'],
            content: 'web/project/bill_detail.jsp'
        });
	});
});