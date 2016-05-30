 
/**
 * ****************左侧菜单****************
 * 包含浏览器放大缩小时的显示
 * 收缩展开效果
 * 二级，三级效果
 */
$(function () {
	//左侧自适应菜单收缩
    $('#menu_toggle').click(function () {
        if ($('body').hasClass('nav-md')) {
            $('body').addClass('nav-sm').removeClass('nav-md');
            $('.left_col').removeClass('scroll-view').removeAttr('style');
            $('.sidebar-footer').hide();
        }else{
            $('body').addClass('nav-md').removeClass('nav-sm');
            $('.sidebar-footer').show();
        }
        
        //切换重新计算
        mathHeight();
    });
    
	//左侧子菜单
	$('#sidebar-menu .side-menu>li>a').on('click', function() {
		$(this).parent("li").addClass("active").siblings("li").removeClass("active").children("ul").slideUp(400);
        $(this).parent("li").children("ul").slideToggle(400);
    });
	$(".child_menu li").click(function(){
        $(this).addClass("current-page").siblings("li").removeClass("current-page");
        $(this).parent().parent().siblings().find(".current-page").removeClass("current-page");
	});
	
	//自动执行
	//menuSlide();
	
	
	
	
	//条件搜索栏
	$("a.state").click(function(){
		$(".search>.panel>.panel-body").slideToggle();
	});
	
	//
	
});


//左侧菜单默认进入时显示项判断
function menuSlide(){
	$('#sidebar-menu .side-menu>li.active ul').show();
}

//滚动条优化
$(document).ready(function (){
	/*$(".demo-box").niceScroll({
    	cursorcolor: "#ccc",//#CC0071 光标颜色 
	    cursoropacitymax: 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0 
	    touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备 
	    cursorwidth: "5px", //像素光标的宽度 
	    cursorborder: "0", //     游标边框css定义 
	    cursorborderradius: "5px",//以像素为光标边界半径 
	    autohidemode: true //是否隐藏滚动条
    });*/
    $("#sidebar-menu").niceScroll({
        //touchbehavior: true,
        cursorcolor: "rgba(200, 200, 200, 1)",
        //cursorcolor: "rgba(42, 63, 84, 0.35)",
        cursorwidth: "8px"
        
    });
    $(".top_menu,.zTree-box").niceScroll();
    $(".w-content").niceScroll();
});