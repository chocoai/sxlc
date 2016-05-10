$(function() {
	$('#table_history_record').DataTable({
		"autoWidth" : false,
		"scrollX":true,
		// scrollY : 500, //
		//paging : false,//分页
		//"searching" : false,
		"info" : false,//左下角信息
		//"ordering": false,//排序
		"aaSorting" : [ ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [ 0, 1, 2, 3, 4, 5]
		} // 制定列不参与排序
		],
	});
	$('#table_history_enclosure').DataTable({
		"autoWidth" : false,
		// scrollY : 500, //
		//paging : false,//分页
		//"searching" : false,
		"info" : false,//左下角信息
		//"ordering": false,//排序
		"aaSorting" : [ ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [ 0, 1, 2, 3, 4, 5, 6]
		} // 制定列不参与排序
		],
	});
	$('#table_history_del').DataTable({
		"autoWidth" : false,
		// scrollY : 500, //
		//paging : false,//分页
		//"searching" : false,
		"info" : false,//左下角信息
		//"ordering": false,//排序
		"aaSorting" : [ ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [ 0, 1, 2, 3, 4, 5]
		} // 制定列不参与排序
		],
	});
});
/*********修改切换*********/
$(function(){
	$(".btnMod").click(function(){
		$(".infoMod").show();
		$(".infoDisplay").hide();
	});
	$(".btnPreserve").click(function(){
		$(".infoDisplay").show();
		$(".infoMod").hide();
	});
	$(".btnCancel").click(function(){
		$(".infoDisplay").show();
		$(".infoMod").hide();
	});
});