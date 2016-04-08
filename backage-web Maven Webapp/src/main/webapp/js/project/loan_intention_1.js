
$(function(){
	//分配理财顾问
	$('#pro_allocation').on('click', function(){});
	
	
	//补充资料弹出层
	$('#add_information').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '补充资料',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['980px' , '620px'],
	        content: 'web/project/add_information.jsp'
	    });
	});
	//添加到借款申请
	$('#add_loan_apply').on('click', function(){});
	
	
	
	//借款会员拉黑
	$("#loan_member_black").on("click",function(){
		prompt("请输入拉黑原因？");
	});
	
	//查看审批记录
	$('#loan_exam_record').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '查看审批记录',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        content: 'web/project/loan_exam_record.jsp'
	    });
	});
	
	
	
	//查看借款项目详情
	$('#loan_detail').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '借款项目详情',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '520px'],
	        content: 'web/project/loan_pro_detail.jsp'
	    });
	});
	
	//拒绝借款
	$('#refuse_payment').on('click', function(){
		layer.confirm('确定拒绝借款？', {
			  btn: ['确定','取消'] //按钮
			}, function(){
			  layer.msg('已拒绝', {icon: 1});
			});
	});
});
