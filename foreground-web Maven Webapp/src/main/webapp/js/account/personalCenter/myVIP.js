$(function(){
	$(".TB").addClass("down");
	$(".TB4").addClass("down2");
	
	$(".buy-VIP").click(function(){
		$("#startYear").val("");
		$("#sellYear").val("");
		$("#needMoney").val("");
		$(".endT").html("");
		$(".beginT").html("");
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




$(function(){
	$("#sellYear").on("keyup",function(){
		var num = parseFloat($(this).val())*parseFloat(vipYearMoney);
		$("#needMoney").html(num);
	});
	//分页
	
	var pageSize = $("#pageSize").val();
	var totalRecords = $("#tol").val();
	var totalPage = Math.ceil(totalRecords/pageSize);
	var pageNo = $("#cpage").val();
	if (!pageNo) {
		pageNo = 1;
	};
	
	pager.generPageHtml({
	pno : pageNo,
	//总页码
	total : totalPage,
	//总数据条数
	totalRecords : totalRecords,
	//链接前部
	hrefFormer : basePath + "personalCenter/myVIP/",
	//链接尾部
	hrefLatter : '.html',
	mode : 'link',//默认值是link，可选link或者click
	getLink : function(n) {
		return this.hrefFormer+ n + this.hrefLatter ;//自定义格式
	}
});
	
	
	$("#buyBox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".buy-now", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype: extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(){
			console.log(1)
			if ($("#startYear").val()=="请选择开始时间"){
				layer.alert("请选择开始时间");
				return false
			}
			if ($("#sellYear").val()=="请输入购买年份"){
				layer.alert("请输入购买年份");
				return false
			}
			
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var data = {};
			data.startTime = encrypt.encrypt($("#startYear").val()+"");
			data.years = encrypt.encrypt($("#sellYear").val()+"");
			
			var obj = eval(data);
			var sign = NetUtil.createSign(obj);
			
			$("#get1").val(data.startTime);
			$("#get2").val(data.years);
			$("#get3").val(sign);
			
//			var url = "personalCenter/vipApply.html";
			
			$("#form1").submit();
//			NetUtil.ajax(
//					url,
//					data,
//					function(r){
//						var data = JSON.parse(r);
//						if (data.status == "-2"){
//							layer.alert(data.startTime);
//						}else{
//							layer.alert("成功",function(){
//								window.location.reload();
//							})
//						}
//					}
//			)
			return false;
		}
	});
});
