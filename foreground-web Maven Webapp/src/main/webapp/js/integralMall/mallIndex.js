//积分商城首页
$(function() {
	//获取轮播图
	getBanner();
	//获取积分长城首页商品展示板块内容
	getMallIndexInfo();
	
	productEffect();
});

//function
//轮播图效果
function bannerEffect(){
	var slidey = $('.banner').unslider({
		speed: 500,			   
		delay: 3000,			
		complete: function() {}, 
		keys: true,			 
		dots: true,			  
		fluid: true
	});
	data = slidey.data('unslider');
	data.move(2, function() {}); 
}

//产品突出显示效果
function productEffect(){
	$(".productDetail").each(function(){
		$(this).mouseover(function(){
			if($(this).find(".sellOutHide").length > 0){
				$(this).find(".detailProduct").hide();
				$(this).find(".flowTop").show();
			}
		}).mouseout(function(){
			$(this).find(".detailProduct").show();
			$(this).find(".flowTop").hide();
		});
	});
}

//获取轮播图
function getBanner(){
	$.ajax({
		url:"integralMall/MallBanner.html",
		data:{},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(data){
			//console.log(data);
			$("#bannerUl").html("");//置空
			if(data.length > 0){
				var html = template("bannerList", data);
				$("#bannerUl").append(html);
				//绑定轮播
				bannerEffect();
			}else{
				
			}
		}/*,
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}*/
	});
}

//获取积分长城首页商品展示板块内容
function getMallIndexInfo(){
	$.ajax({
		url:"integralMall/mallIndexselect.html",
		data:{},
		type:"get",
		dataType:"json",
		timeout:10000,
		success:function(r){
			var data = {};
			data.results = r;
			console.log(data);
			if(data.results.length > 0){
				var html = template("goodsList", data);
				$(".integralApproach").after(html);		//填充数据
				productEffect();						//绑定突出显示
			}
			
		}/*,
		error:function(){
			layer.alert("请求异常，请稍后再试",{icon:2});
		}*/
	});
}
