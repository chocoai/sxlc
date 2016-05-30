//积分商城-商品列表
$(function(){
	$(".filterLi li").click(function(){
		$(this).children("span").addClass("selected");
		$(this).siblings().children("span").removeClass("selected");
	});

	shortpoint();//快捷积分
	dealPoint();//积分处理
	getGoodsList();//获取列表
});


//function
//选择快捷积分
function shortpoint(){
	$(".filterLi li").click(function(){
		var $curr = $(this).children("span");
		$curr.addClass("selected");
		$(this).siblings().children("span").removeClass("selected");
		
		//处理积分
		var min = $curr.attr("data-min");
		var max = $curr.attr("data-max");
		$("#minpoint,.minpoint").val(min);
		$("#maxpoint,.maxpoint").val(max);
	});
}


//悬浮变换
function overEffect(){
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
//积分范围处理
function dealPoint(){
	console.log("范围处理");
	var _minpoint= $(".minpoint").val();	//最小值
	var _maxpint=  $(".minpoint").val();	//最大值
	console.log([_minpoint,_minpoint]);
}


//获取商品列表
//上下限（快捷和输入不并存）
function getGoodsList(start,length){
	var encrypt = new JSEncrypt();//加密
	encrypt.setPublicKey(publickey);
	var data = {};//minPoint,maxPoint,commodityTypeId,order
	var url= 'integralMall/goods.html';
	//输入了积分范围，快捷范围就无效
	
	debugger;
	var minpoint = $("#minpoint").val();	//最小值
	var maxpoint = $("#maxpoint").val();	//最大值
	var order = $("#order").val();			//排序
	var type = $("#commodityType").val();	//商品分类

	if(minpoint != undefined && minpoint != ""){
		data.minPoint= encrypt.encrypt(minpoint+"");
	}
	if(maxpoint != undefined && maxpoint != ""){
		data.maxPoint= encrypt.encrypt(maxpoint+"");
	}
	if(type != undefined && type != ""){
		data.commodityTypeId= encrypt.encrypt(type+"");
	}
	if(order != undefined && order != ""){
		data.order= encrypt.encrypt(order+"");
	}
	data.start = start || 1;
	data.length = length || 12;
	
	NetUtil.ajax(
		url,
		data,
		function(data){ 
			var data = JSON.parse(data);
			console.log(data);
			$("#productList").html("");
			if (data.results.length > 0) {
				var html = template("goodslist", data);
				$("#productList").append(html);
				pager.generPageHtml({
					pno: data.pageNum,					//当前页
					total: data.totalPage,				//总页码
					totalRecords: data.recordsTotal,	//总数据条数
					mode: 'click', //默认值是link，可选link或者click
					click: function(n) {
						getGoodsList(n, length);
						this.selectPage(n);
						return false;
					}
				},true);
				overEffect();
			} else {
				var noData = '<li class="data-item noData"><div>暂无数据！</div></li>';
				$("#productList").append(noData);
			}
		}
	);
	
	
}