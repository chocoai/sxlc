//积分商城-商品详情
$(function(){
	$(".subBtn").click(function(){
		var value = $(this).siblings("input").val();
		if(value ==1 ){
			return false;
		}else{
			value--;
			$(this).siblings("input").val(value);
		}
	});
	$(".addBtn").click(function(){
		var value = $(this).siblings("input").val();
		value++;
		$(this).siblings("input").val(value);
	});
});

//function
function getGoodsInfo(){

}