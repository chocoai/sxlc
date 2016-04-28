/* 黄鑫2016-4-2 */
$(function(){
	$(".TB").addClass("down");
	$(".TB1").addClass("down2");
	/* 伍成然2016-4-2 */
	/* 内容显示切换 */
	/* 修改 */
	$(".modify").click(function(){
		$(".content1").removeClass("active");
		$(".content2").addClass("active");
	});
	/* 取消保存 */
	$(".cancel").click(function(){
		$(".content2").removeClass("active");
		$(".content1").addClass("active");
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});



function bindPro(){
	
}











/* 验证     */
$(function(){
	
	var app = $("#testbox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".preserve", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true
	});
	
	var sendDate = {};
	
	
	app.config({
		//showAllError:true,
	    url:"personalCenter/editPsersonInfo.html",
	    ajaxpost:{
	        //可以传入$.ajax()能使用的，除dataType外的所有参数;
	        type: "post",
			//async: true,
			data: sendDate,
			dataType: "json",
			timeout: 1000,
			success:function(data){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
				console.log(data);
			},
	        error:function(data){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
	            console.log(data.status);
	        }
	    }
	});

	
});




