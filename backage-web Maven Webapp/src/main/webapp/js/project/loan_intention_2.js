
$(function(){
//	添加意向借款
	$('#add_intention_loan').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '添加意向借款',
	        maxmin: true,
	        shadeClose: true,
	        area : ['800px' , '520px'],
	        content: 'web/project/add_intention_loan.jsp'
	    });
	});
});