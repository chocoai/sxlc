
$(function(){
	//默认禁用搜索和排序
	/* $.extend( $.fn.dataTable.defaults, {
	    searching: true,
	    ordering:  false
	} ); */
	$('#pro_table').DataTable({
		"autoWidth" : false,
		//scrollY : 500,
		//paging : false,//分页
		//"searching" : false,
		"info" : false,//左下角信息
		//"ordering": false,//排序
		"aaSorting" : [ [ 5, "desc" ],[ 12, "desc" ],[ 14, "desc" ] ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [ 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13 ]
		} // 制定列不参与排序
		],
		colReorder : false,
		"sScrollX" : "100%",
		"sScrollXInner" : "100%",
		"bScrollCollapse" : true
	});
	
	
	/*验证*/
	validform5("layui-layer-btn0","saveNotice",true,"3");
	//分配理财顾问
	$('#pro_allocation').on('click', function(){
		layer.open({
			  type: 1,
			  title:'理财顾问分配',
			  btn: ['确定','取消'],
			  //skin: 'layui-layer-rim', //加上边框
			  area: ['320px', '200px'], //宽高
			  content: $(".allocation"),
			});
	});	
	//查看审批记录
	$('#loan_exam_record').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '查看审批记录',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '520px'],
	        content: 'web/project/pro-add/loan_exam_record.jsp'
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
	//借款会员拉黑
	$("#loan_member_black").on("click",function(){
        layer.prompt({title: '填写拉黑原因', formType: 2}, function(text){
          layer.msg('拉黑原因：'+text);
        });	      
	});
	//查看借款项目详情
	$('#loan_detail').on('click', function(){
	    layer.open({
	        type: 2,
	        title: '借款项目详情',
	        maxmin: true,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['620px' , '500px'],
	        content: 'web/project/pro-add/loan_pro_detail.jsp'
	    });
	});
});
/******补充资料*******/
function addInfo(){
	$(".right_col").load("web/project/pro-add/add_information.jsp");
}


