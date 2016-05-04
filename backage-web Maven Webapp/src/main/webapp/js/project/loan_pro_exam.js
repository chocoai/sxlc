$(function(){

	$('#table_history_enclosure').DataTable({
		scrollX:true,
		autoWidth : false,
		"aaSorting" : [ ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4,5,6]
		} // 制定列不参与排序
		],
	});
	$('#table_history_del').DataTable({
		scrollX:true,
		autoWidth : false,
		"aaSorting" : [ ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4,5]
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