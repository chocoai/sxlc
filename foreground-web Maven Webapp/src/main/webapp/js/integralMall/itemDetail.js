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
//itemDetail根据id获取商品详情
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
				toExchangeDetail();
			}else{
				
			}
			
		}/*,
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}*/
	});
}

//点击到兑换详情页面，传递数量
function toExchangeDetail(){
	$(".buy").click(function(){
		var count = $("#count").val();//兑换数量
		if(count){
			var newLink = $(this).attr("data-href")+"?count="+count;
			window.location.href = newLink;
		}
	});
}