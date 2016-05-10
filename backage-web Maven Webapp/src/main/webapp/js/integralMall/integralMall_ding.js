//发货
$(function () {
	var appPath = getRootPath();
	$(".fahuo").on("click touchstart",function(){
		
		layer.confirm('确定发货吗？', {
		  btn: ['确定', '取消']
		});
	});
});
//撤销订单
$(function () {
	var appPath = getRootPath();
	$(".chexiao").on("click touchstart",function(){
		
		layer.confirm('确定撤销订单吗？', {
		  btn: ['确定', '取消']
		});
	});
});