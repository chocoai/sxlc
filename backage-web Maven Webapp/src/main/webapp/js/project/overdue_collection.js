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
//生成账单	
	$('.obtn-generate-bill').click(function(){
    	layer.open({
            type: 1,
            title: '生成账单',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['500px' , '300px'],
            content: $(".generate_bill"),//DOM或内容
		    btn:['发送', '取消']
        });
	});
});