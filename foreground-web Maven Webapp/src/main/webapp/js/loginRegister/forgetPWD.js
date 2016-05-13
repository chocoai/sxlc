/*伍成然2016-3-27*/

$(function(){
	/*跳转流程*/
	/*$(".next-btn").on("click",function(){
		$(".input-group1").removeClass("on");
		$(".input-group2").addClass("on");
		layer.closeAll('tips'); //关闭所有的tips层
	});
	$(".submit-btn").on("click",function(){
		$(".input-group2").removeClass("on");
		$(".info").addClass("on");
						
	});*/
});







/* 验证     */
$(function(){
	$("#forgetPWDbox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".next-btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:{//使用ajax提交时
			url:"login.html",
			type:"post",
			datatype:"json",
			data:{},
			beforeSubmit:function(curform){//提交借款申请时添加家庭成员和家庭成员信息拼接
		        //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。  
		        //这里明确return false的话表单将不会提交;
				
		    },
			success:function(data,obj){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
				$(".next-btn").on("click",function(){
					$(".input-group1").removeClass("on");
					$(".input-group2").addClass("on");
					layer.closeAll('tips'); //关闭所有的tips层
				});
	        },
	        error:function(data,obj){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
	            //console.log(data.status);
	        }
		}
	});
});




$(function(){
	$("#input-info").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".submit-btn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:{//使用ajax提交时
			url:"login.html",
			type:"post",
			datatype:"json",
			data:{},
			beforeSubmit:function(curform){//提交借款申请时添加家庭成员和家庭成员信息拼接
		        //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。  
		        //这里明确return false的话表单将不会提交;
				
		    },
			success:function(data,obj){
	            //data是返回的json数据;
	            //obj是当前表单的jquery对象;
				$(".submit-btn").on("click",function(){
					$(".input-group2").removeClass("on");
					$(".info").addClass("on");
									
				});
	        },
	        error:function(data,obj){
	            //data是{ status:**, statusText:**, readyState:**, responseText:** };
	            //obj是当前表单的jquery对象;
	            //console.log(data.status);
	        }
		}
	});
});