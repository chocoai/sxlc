/*伍成然2016-4-1*/
$(function(){ 
    if ( window.clipboardData ) {  
        $('#cu').click(function() {  
            window.clipboardData.setData("Text", $(this).prev('input').attr("value"));  
            layer.tips('复制成功', '#cu'); 
        });  
    } else {  
        $('#cu').zclip({  
            path:'http://img3.job1001.com/js/ZeroClipboard/ZeroClipboard.swf',  
            copy:function(){return $(this).prev('input').attr("value");},  
            afterCopy:function(){layer.tips('复制成功', '#cu');}  
        });  
    }  
});
    
$(function(){
	$(".TB").addClass("down");
	$(".TB6").addClass("down2");
	$(".tab-head li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tab-content .c-content").removeClass("content-active");
			$(".tab-head li").removeClass("tab-ing");
			$(".tab-content .c-content").eq(index).addClass("content-active");
			liNode.addClass("tab-ing");
			
			//查询站内好友
			if(index==1){
				quryFriendList();//friendManagement_data.js 里面
			}
		});
	});
	/*弹出层伍成然2016-4-6*/
	$(".unprocessed").click(function(){
		layer.open({
			title :'好友申请列表',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['642px', '520px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.undeal')//内容，里边是包含内容的div的class
	    });
		
		//获取待确认好友列表
		quryConfirmFriend();  //friendManagement_data.js 里面
		
	});
	$(".add-friends").click(function(){
		layer.open({
			title :'加好友申请列表',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['652px', '676px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.addFriends')//内容，里边是包含内容的div的class
	    });
	});
	
	$(".search").click(function(){
		serachMemberByParam();//查找陌生人
		
	});
	
});
$(function(){
	/* 弹出层翻页 */
	$(".pageAfter1").click(function(){
		$(".pageAfter1").addClass("pageAfter");
		$(".pageAfter").removeClass("pageAfter1");
		$(".pageBefore").addClass("pageBefore1");
		$(".pageBefore1").removeClass("pageBefore");
	});
});
$(function(){
	/* 弹出层翻页 */
	$(".pageBefore1").click(function(){
		$(".pageBefore1").addClass("pageBefore");
		$(".pageBefore").removeClass("pageBefore1");
		$(".pageAfter").addClass("pageAfter1");
		$(".pageAfter1").removeClass("pageAfter");
	});
});

/***********验证***********/
$(function(){
	$("#notLoginBox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".login-now", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype: {"acountM":acountM,},//扩展验证类型
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
