//积分商城-商品详情
$(function(){
	getGoodsInfo();
});

//修改数量
function changeNum(){
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
}

//function
//根据id获取商品详情
function getGoodsInfo(){
	var temp = window.location.href;
	goodsId = temp.split("goodsId=")[1];
	//console.log(goodsId);
	if(goodsId == null || isNaN(goodsId)){
		return;
	}
	
	$.ajax({
		url:"integralMall/commodityInfo_"+goodsId+".html",
		data:{},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			////console.log(data);
			if(data){
				var html = template("goodsDet", data);
				$("#productListArea").append(html);		//填充数据
				changeNum();
			}else{
				
			}
			
		}/*,
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}*/
	});
}