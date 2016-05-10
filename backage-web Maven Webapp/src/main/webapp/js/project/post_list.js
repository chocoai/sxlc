$(function(){
	
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
/******发布*******/
function post_pro(){
	$(".right_col").load("web/project/pro-add/loan_pro_exam.jsp");
}

//默认禁用搜索和排序
/* $.extend( $.fn.dataTable.defaults, {
    searching: true,
    ordering:  false
}); */
// 这样初始化，排序将会打开
$(function() {
	$('#table_post_list').DataTable({
		"autoWidth" : false,
		scrollX : true,
		//scrollY : true,
		//paging : false,//分页
		//"searching" : false,
		"info" : false,//左下角信息
		//"ordering": false,//排序
		"aaSorting" : [ [ 2, "desc" ],[ 10, "desc" ],[ 13, "desc" ] ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [ 0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12 ]
		} // 制定列不参与排序
		],
		colReorder : false,
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"bScrollCollapse" : true
	});
});