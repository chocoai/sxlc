/*
 * 公共方法 依赖jq
 */
/**
 * 全局 1-4级菜单下标
 * @type	int 
 * 影响功能$("body").bread();
 */
$(function() {
	// 路径导航
	/*$('#sidebar-menu .side-menu>li').on('click touchstart', function() {
		$(this).addClass("active").siblings().removeClass("active");
	});*/

	// （根据实际需要选择页面切换）tab切换，内容切换
    $(".nav-tabs li").on("click touchstart",function(i){
		$(this).addClass("active").siblings().removeClass("active");
		var _i = $(this).index();//当前位置索引
		//alert($(".nav-tabs-con").length);
		$(".nav-tabs-con").hide().eq(_i).show();
    });
    
    //输入框操作限制
    limitOperate();
	
	
});

//=======================function

//修改地址导航
function modAddr(){
	/*var $_c = $(".breadcrumb li:last");
	var _c_name = $_c.find("a").text();
	$_c.addClass("active").text(_c_name);*/
	var _c_name = "";//路径项名称
	var _cs = $(".breadcrumb li");
	for(var i=1;i<_cs.length;i++){
		_c_name = _cs.eq(i).find("a").text();
		_c_url = _cs.eq(i).find("a").attr("href");
		if(_c_url == "undefined"){//为空链接处理
			_cs.eq(i).addClass("active").text(_c_name);
		}
		if(i == (_cs.length-1)){//最后一项链接处理
			_cs.eq(i).addClass("active").text(_c_name);
		}
	};
}

//动态计算尺寸
$(window).resize(function(){
	mathHeight();
});
function mathHeight() {
	var _disH = $.trim($(".top_navigation").outerHeight(true));// 头部
	var _bdH = window.innerHeight;// 窗口
	var _rcH = _bdH - _disH;// 35 右侧主要内容
	//console.log(_disH + "," + _bdH + "," + _rcH);
	$(".right_col,.left_col").css("height", _rcH + "px");
	//左侧菜单（-57还有点问题）
	var _tH = $(".nav_title").height();
	$(".main_menu_side").css("height", _rcH - _tH - 2 + "px");
	$(".tree-table").css("height",_rcH - 40 + "px");
}


//复制、剪切、粘贴
function limitOperate() {
    $("input:password,input[limitoperate='1']").bind("copy cut paste",function(e){
        return false;
     });
}

/**
 * 获取项目根目录全路径
 * @returns
 */
var appPath=getRootPath();
function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPath=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
//		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
//		}else{
//			return(localhostPath);
//		}
}

;(function($){
	var menu = {
		getMenu:function(){
			//menu.selectSection();
			var m1 = menu.getMenu1();
			var m2 = menu.getMenu2();
			var m3 = menu.getMenu3();
			menu.setAddr(m1+m2+m3);
		},
		getMenu1:function(){//读一级菜单
			var a = menu.exchangeData();
			$(".top_menu li[data-m1='"+a.m1 +"']").addClass("tab_active").siblings()
				.removeClass("tab_active");
			var name = $(".top_menu li[data-m1='"+a.m1+"']").find("p").eq(1).text();
//			if(name){//左侧菜单主标题赋值
//				$(".left_col.scroll-view .nav_title span").text(name);
//			}else{
//				$(".left_col.scroll-view .nav_title span").text("后台管理");
//			}
			var url = $(".top_menu li[data-m1='"+a.m1+"']").find("a").attr("href");
			return menu.splitHtml(name,url) || "";
		},
		getMenu2:function(){//读二级菜单
			var a = menu.exchangeData();
			//console.log(JSON.stringify(a));
			$this = $(".side-menu>li[data-id='"+a.m2+"']").addClass("active");
			if($this.children("ul.child_menu")){//当前项若存在子菜单则展开
	        	$this.children("ul.child_menu").show();
			}
			var name = $(".side-menu>li.active>a:first").text();
			var url = $(".side-menu>li.active>a:first").attr("href");
			return menu.splitHtml(name,url) || "";
		},
		getMenu3:function(){//读三级菜单
			var a = menu.exchangeData();
			//console.log("menu3");
			//debugger;
			$(".side-menu>li.active li[data-id='"+a.m3+"']").addClass("current-page");
			var name = $(".side-menu>li.active li.current-page").text();
			var url = $(".side-menu>li.active li.current-page>a:first").attr("href");
			if(url == "" || name == ""){
				return "";
			}
			return menu.splitHtml(name,url) || "";
		},
		getFun:function(){//读功能菜单
			//console.log("getFun");
			
		},
		setAddr:function(urlAll){//设置导航
			//console.log(urlAll);
			var urlBase = '<li>'+
							'<div class="nav toggle">'+
								'<a id="menu_toggle"><i class="fa fa-bars"></i> </a>'+
							'</div>当前位置：'+
						'</li>';
			
			urlAll = urlAll || "";	
			urlAll = urlBase+urlAll;
			$(".breadcrumb").html(urlAll);//填充地址
			modAddr();//修改链接
		},
		splitHtml:function(name,url){//拼接路径
			var temp = '<li><a href="' + url + '">'
					+ name + '</a></li>';
			/*if(name == undefined || url == undefined){
				temp = "";
			}*/	//为空判断放在了最后的处理中
			return temp;
		},
		exchangeData:function(){//交换数据，用于iframe取值判断
			var a = {};
			if("undefined" != typeof _index){
				a = _index;
			}else{
				a = window.parent.window._index;
			}
			//console.log(JSON.stringify(a));
			return a;
		},
		selectSection:function(){//选择菜单域
			var a = menu.exchangeData();
			//console.log(JSON.stringify(a));
		}
	};
	
	
	//定义插件
	$.fn.bread = function(options){
		return menu;
	};
	
	//定义私有函数
	//定义暴露函数
	//默认参数
	$.fn.bread.defaults = {};
	//版本号
	$.fn.bread.version = 1.0;
})(jQuery);

$(function(){
	//面包屑导航
	var guide = $(document).bread();//实例一个对象，后面点击会用
	if("undefined" != typeof(_index) && _index != null){
		guide.getMenu();//
	}
});

/*
 * 金额千分位控制
 * 胥福星  
 * 20160426
 */
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



/* 
 * 限制特殊字符的输入    
 * 胥福星
 * 20160426
 */

$(".notspecial").bind('keypress', function (event) {
	 var regex = new RegExp(/^([;&,\-\.\+\*\~':"\!\^#$%@\[\]\(\)=>\|])*$/);
	 var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
	 if (regex.test(key)) {
	  event.preventDefault();
	  return false;
	 }
});


/* 控制输入为数字   */
$(function(){
	$(".numberReg").each(function(){
		$(this).focus(function(){
			$(this).keyup(function(){
				if(this.value.length > 0){
					this.value = this.value.replace(/[^0-9]/g,'');
				}
			});
		});
		$(this).change(function(){
			this.value = this.value.replace(/[^0-9.]/g,'');
		});
	});
});




//function
