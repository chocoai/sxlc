/* 金额千分位控制 */
jQuery.fn.format=function(num){
	return (num.toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
};
$(function(){
	$(".moneyFormat").each(function(){
		var s = $(this).text();
		var str = parseFloat(s);
		var n = $(this).format(str);
		$(this).text(n);
	});
});
/* 编辑框 */
var pi = UE.getEditor('payguide');
/* 验证 */
$(function(){
	validform5(".layui-layer-btn0","loan-money",false,"3");
});
$(function(){
	/* 年化利率*/
	$(".startTY").blur(function(){
		var ty = $(".startTY").val();
		if(ty > 0 && ty < 0.24){
			alert(1111);
		}
	});
});
/* 下一步跳转 */
$(function(){
	$(".nextBtn").click(function(){
		$(".modInfo").hide();
		$(".nextField").show();
	});
	$(".beforeBtn").click(function(){
		$(".nextField").hide();
		$(".modInfo").show();
	});
});
/* 添加红包惊喜标 */
$(function(){
	$(".addRed").click(function(){
		var rs = $(".red_add").html();
		$(".red_list:last-child").append("<li class='red_add'>" +rs + "</li>");
	});
	$(".reduceRed").click(function(){
		if($(".red_list li").length>1){
			$(".red_add:last-child").remove();
		}
	});
});
/*担保机构弹出层及回调
伍成然
2016-04-28*/
$(function(){
	$(".add_mechanism").click(function(){
		layer.open({
			  type: 1,
			  title:'选择担保机构',
			  btn: ['确定','取消'],
			  //skin: 'layui-layer-rim', //加上边框
			  area: ['420px', '300px'], //宽高
			  content: $(".select_mechanism"),
			  btn1:function(){
				  var val=$('input:radio[name="mechanism"]:checked').val();
				  $(".mechanism").html("机构"+val);
			  },
		});
	});
});
/*资产管理方弹出层及回调
伍成然
2016-04-28*/
$(function(){
	$(".add_assetManagement").click(function(){
		layer.open({
			  type: 1,
			  title:'选择资产管理方',
			  btn: ['确定','取消'],
			  //skin: 'layui-layer-rim', //加上边框
			  area: ['420px', '300px'], //宽高
			  content: $(".select_assetManagement"),
			  btn1:function(){
				  var val=$('input:radio[name="assetManagement"]:checked').val();
				  $(".assetManagement").html("资产管理方"+val);
			  },
		});
	});
});

