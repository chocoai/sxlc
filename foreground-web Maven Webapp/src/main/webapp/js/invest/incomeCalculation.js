$(function(){
	$("#getInvestA .selectOption").on("click",function(){
		setDayPro();
	});
	setDayPro();
	$("#form1").Validform({
		tiptype:5,//提示信息类型
		btnSubmit:".calBtn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(){
			$(".calBtn").addClass("disabled");
			var data = {};
			data.amount = $(".amount").val();
			data.yearRate = $(".yearRate").val();
			data.moreRate= $(".moreRate").val();
			data.dateNum = $(".dateNum").val();
			data.dateType = $("#getInvestA .selectValue").attr("value");
			data.repaymentMethod = $("#investX .selectValue").attr("value");
			$.ajax({
				url:"loadGainCalculator.html",
				data:data,
				type:"post",
				dataType:"json",
				async:false,
				success:function(msg){
					if(msg!=null){
						$(".expectedReturn").html(msg.expectedReturn);
						$(".moreReturn").html(msg.moreReturn);
						
						var html = template("all_list",msg);
						$("#list").children().remove();
						$("#list").append(html);
						$(".moneyFormat").each(function(){
							var s = $(this).text();
							var str = parseFloat(s);
							var n = $(this).format(str);
							$(this).text(n);
						});
					}
				},
				error:function(){
					layer.alert("网络出错了，请稍后重试");
				},
				complete:function(){
					$(".calBtn").removeClass("disabled");
				}
			});
			return false;
		}
	});
});
/**
 * 日标只能选择 到期还本息的借款方式
 */
function setDayPro(){
	if($("#getInvestA .selectValue").attr("value")=="0"){
		$("#investX .selectValue").attr("value","2");
		$("#investX .selectInput").val("到期还本息");
		$("#investX .selectInput").addClass("disabled");
	}else{
		$("#investX .selectInput").removeClass("disabled");
	}
}