$(function(){
	//借款项目详情
	$('.obtn-loan-prodetail').click(function(){
		alert("点击跳转前台相应的借款项目详情，加链接");
	});
//	账单详情
	$('.obtn-bill-detail').click(function(){
    	layer.open({
            type: 2,
            title: '账单详情',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/bill_detail.jsp'
        });
	});
});