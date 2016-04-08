/*
 * 公共方法 依赖jq
 */
!(function($) {
	$.fn.menu = function(options) {
		var defaults = {
			_index : 0, // 下标，默认为0
			_referrer : document.referrer, // 来源地址
			_loc1 : "", // 一级菜单地址
			_loc1_name : "", // 一级菜单名字
			_loc2 : "", // 一级菜单地址
			_loc2_name : "" // 一级菜单名字
		};
		// 继承
		options = $.extend(defaults, options);
		$(".top_menu li").eq(options._index).addClass("tab_active").siblings()
				.removeClass("tab_active");

		options._loc1 = $(".top_menu li").eq(options._index).find("a")
				.attr("href");
		options._loc1_name = $(".top_menu li").eq(options._index).find("p")
				.eq(1).text();

		// 打印
		/*console.log(options._index + "\n" + options._referrer + "\n"
				+ options._loc1 + "\n" + options._loc1_name + "\n"
				// +options.+"\n"
				);*/

		// 地址栏赋值，存在bug
		var _loc_html = "";
		if (options._loc1_name) {
			_loc_html += '<li><a href="' + options._loc1 + '">'
					+ options._loc1_name + '</a></li>';
			// $(".breadcrumb
			// a:first").text(options._loc1_name).attr("href",options._loc1);
			var $o2 = $(".side-menu li.active").find("a:first");
			options._loc2 = $o2.attr("href");
			options._loc2_name = $o2.text();
			if (options._loc2_name) {
				_loc_html += '<li><a href="' + options._loc2 + '">'
						+ options._loc2_name + '</a></li>';
			}
			$(".left_col.scroll-view .nav_title span").text(options._loc1_name);
			$(".breadcrumb").append(_loc_html);
			//修改地址导航
			modAddr();
		}

		/*
		 * $(this).on({ click : function(){
		 * console.log(options._index+",二级菜单查询"); } });
		 */
	};
})(jQuery);


$(function() {
	/*陈小花----左侧菜单下拉，有问题*/
	// 左侧菜单
	$('#sidebar-menu .side-menu>li>a').on('click', function() {
        var link = $(this).attr('href');
        //console.log(link);
       if(link) { 
            window.location.href = link;
        } 
       else {
            if ($(this).parent("li").is('.active')) {
                $(this).parent("li").removeClass('active');
                $('ul', $(this).parent("li")).slideUp();
            }
            else {
                $('#sidebar-menu li').removeClass('active');
                $('#sidebar-menu li ul').slideUp();
                
                $(this).parent("li").addClass('active');
                $('ul', $(this).parent("li")).slideDown();
            }
       }
        
    });
    /**  ************左侧二级菜单***************** **/
    	$(".child_menu li").click(function(){
    		if ($(this).is('.current-page')) {
                $(this).removeClass('current-page');
            } else {
                $('.child_menu li').removeClass('current-page');
                $(this).addClass('current-page');
            }
    	});
    	
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
	var $_c = $(".breadcrumb li:last");
	var _c_name = $_c.find("a").text();
	$_c.addClass("active").text(_c_name);
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
	$(".main_menu_side").css("height", _rcH - 55 + "px");
	$(".tree-table").css("height",_rcH - 40 + "px");
}


//清除空格
String.prototype.trim=function(){
     return this.replace(/(^\s*)|(\s*$)/g,'');
};
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
		if(/127.0.0.1|localhost/.test(localhostPath)){
			return(localhostPath+projectName);
		}else{
			return(localhostPath);
		}
}

//菜单（状态）切换
//当前位置
//即时通讯
//在线管理
//系统设置
//cookie管理
//随机码生成
//根据所需，浏览器判断，进行相应操作