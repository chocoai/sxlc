/*伍成然2016-3-24*/
$(function(){
	/*标签的切换&顶部链接切换*/	
	$(".tab-head li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .content").removeClass("content-active");
			$(".page-link .current-page").removeClass("on");
			$(".tab-head .tab-li").removeClass("tab-ing");	
			$(".tab-content .content").eq(index).addClass("content-active");
			$(".page-link .current-page").eq(index).addClass("on");
			liNode.addClass("tab-ing");
		});
	});
	/*立即投资弹出层*/	
	/*标签选择*/	
	$(".label-select label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
	/*控制表格变色*/	
	jQuery.changeColor = function (ulid) {
		var liset = $(ulid).find("li");
		for (var i = 2; i < liset.length; i += 2) {
			liset.eq(i).css("background-color", "#f6f8fa");/*i控制从第几个变色*/	
		}
	};
	$.changeColor(".grid-table1");
	$.changeColor(".grid-table2");
	$.changeColor(".proli-table");
	/*登录与未登录状态*/	/*逻辑待改*/	
	$(".login-now").click(function(){
		$(".not-logined").css("display","none");
		$(".logined").css("display","block");
		$(".after-inv-li").css("display","none");
	});
	/*未登录与还款中状态*/	/*逻辑待改*/
	$(".inv-now").click(function(){
		$(".logined").css("display","none");
		$(".repaying").css("display","block");
		$(".after-inv-li").css("display","block");
	});
    /*债后监管展开*/
	$(".info-bottom-content").click(function(){
		$(".info-top").hide();
		$(".info-bottom").show();
		$(this).parent().parent().hide();
		$(this).parent().parent().parent().children(".info-top").show();
	});
	/*进度条*/
	$(".progress").each(function(){
		$(this).find(".barline").css("width",$(this).find(".progress_totle").html());
	});
	/*弹出层*/
	$('.inv-now').on('click', function(){
		layer.open({
			title :'我要投资',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['486px', '440px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.red-packets')//内容，里边是包含内容的div的class
	    });
	});
	/*radio样式切换效果*/	
	$(".select label").click(function(){
		$(this).parent().children().removeClass("active"); 
		$(this).addClass("active");
	});
});
/*伍成然2016-4-8项目历程弹出层*/
$(function(){
	$(".pro-repay").mouseenter(function(){
		$(this).parent().children(".proLi").show();
		$(this).children("div").css("color","#72c0f3");
	});
	$(".pro-repay").mouseleave(function(){
		setTimeout(function(){		
			$(".proLi").hide();
		},1000);
		$(this).children("div").css("color","#605f5f");
	});
	$(".proLi").mouseenter(function(){
		setTimeout(function(){		
			$(".proLi").show();
		},1000);
	});
});

/* 胥福星   2016-04-07   弹出提示层代码     */
jQuery.fn.layoutClick = function(str){
	var s = str;
	var m = '<div class="tipClick"><div class="contentTip">' + s + '<img class="imgTip" src="resource/img/invest/wytz_tip1.png"></div></div>';
	this.parent().css('position','relative');
	this.parent().append(m);
	this.parent().find(".tipClick").css("left",this.offset().left - this.parent().offset().left - this.innerWidth());
	this.parent().find(".tipClick").css("top",this.offset().top - this.parent().offset().top + this.innerHeight() + 15 );
};

/*  胥福星    2016-04-07  弹出提示层   */
$(function(){
	$(".input1").each(function(){
		$(this).mouseover(function(){
			$(this).layoutClick("有效期至：2015-06-10");
		});
		$(this).mouseout(function(){
			$(this).parent().find(".tipClick").remove();
		});
	});
});



/*   胥福星     2016-04-11   input中对输入金额的显示样式的控制     */
$(function(){
	$(".format").each(function(){
		$(this).focus(function(){			
			this.value = (this.value + '').replace(/\,/g, '');
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9.]/g,'');
				}
			});
		});
		$(this).blur(function(){
			if(this.value != ""){
				this.value = parseFloat(this.value).toFixed(2);
				this.value = (this.value + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
			}
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});
