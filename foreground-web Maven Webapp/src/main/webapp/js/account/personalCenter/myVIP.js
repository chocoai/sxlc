$(function(){
	$(".TB").addClass("down");
	$(".TB4").addClass("down2");
	$(".buy-VIP").click(function(){
		layer.open({
			title :'购买VIP',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['488px', '441px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.buyVip')//内容，里边是包含内容的div的class
	    });
	});
});
/******弹出层计算日期*******/
$(function(){
	$(".select-time").blur(function(){
		var beginDay=$(".select-time").val();
		$(".beginT").text(beginDay);
	});
	$(".input-time").blur(function(){
		var beginDay=$(".select-time").val();
		var bdy = parseInt(beginDay.substr(0, 4));//年
		var bdmd = beginDay.substr(4, 10)//月，日
		var timeLength=$(".input-time").val();
		var tl = parseInt(timeLength);//时间长		
		$(".endT").text(bdy+tl+bdmd);
	});
});
/***********验证***********/
$(function(){
	$("#buyBox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".buy-now", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype: extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:{//使用ajax提交时
			url:"http://182.150.178.88:8031/GEB_P2P_Foreqround/selectmemberProvince.action",
			datatype:"jsonp",
			success:function(data,obj){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
	        },
	        error:function(data,obj){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
	            console.log(data.status);
	        }
		}
	});
});
