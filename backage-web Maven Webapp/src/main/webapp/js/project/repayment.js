$(function(){
	//还款计划
	$('#repayment_plan').click(function(){
		layer.open({
            type: 2,
            title: '还款计划',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/repayment_plan.jsp'
        });
	});
//	查看投资记录
	$('#repayment_invest_record').click(function(){
    	layer.open({
            type: 2,
            title: '投资记录',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/repayment_invest_record.jsp'
        });
	});
});