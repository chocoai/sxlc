$(function(){
	//修改审核附件信息
	$('#investing_modify').click(function(){
		
	});
//	查看投资记录
	$('#investing_invest_record').click(function(){
    	layer.open({
            type: 2,
            title: '投资记录',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/investing_invest_record.jsp'
        });
	});
});