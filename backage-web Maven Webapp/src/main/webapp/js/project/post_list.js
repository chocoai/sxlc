$(function(){
//	项目发布
	$('#post').click(function(){
    	layer.open({
            type: 2,
            title: '发布',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '580px'],
            content: 'web/project/post.jsp'
        });
	});
	
//	拒绝
	$('#refuse').click(function(){
		layer.confirm('你确定要拒绝吗？', {
			  btn: ['确定','取消'] //按钮
			},function(){
				layer.msg('你选择了拒绝');
			});
	});
//	项目借款结束日期延长
	$('#end_time_along').click(function(){
		layer.open({
			type: 1,
			title:'项目借款结束日期延长',
			skin: 'layui-layer-rim', //加上边框
			area: ['500px', '240px'], //宽高
    		content: $('.extendTime')
    	});
	});
});
/******查看借款项目详情*******/
function view_detail(){
	$(".right_col").load("web/project/pro-add/loan_pro_detail.jsp");
}
