$(function(){
	$(".TD").addClass("down");
	$(".TD3").addClass("down2");
	/*弹出层伍成然2016-4-6*/
	$('.allowBidBtn').on('click', function(){
		layer.open({
			title :'自动投标设置',//标题
			skin: 'layer-ext-myskin',//皮肤
	        type: 1,
	        area: ['583px', '768px'],//大小宽*高
	        shadeClose: true, //点击遮罩关闭
	        content: $('.autoBidSet')//内容，里边是包含内容的div的class
	    });
	});
	
	$('.numberReg').focus(function(){
		$(this).parent().siblings().children('.numberReg').attr('disabled',true);
		$('.numberReg').blur(function(){
			var dangQ=$(this).val();
			if(dangQ == ''){
				$(this).parent().siblings().children('.numberReg').attr('disabled',false);
				$('.numberReg').focus(function(){
					$(this).parent().layoutWarning("请输入项目期限");
				});
			}
			else{
				$(this).parent().layoutClean();
			}
		});
	});	
	$(".proType").on("click",function(){
		if ($(this).prop("checked")){
			$(this).parent().addClass("active");
			if ($(this).val()=="-1"){
				$(".proType").prop("checked",true);
				$(".proType").parent().addClass("active");
			}
		}else{
			$(this).parent().removeClass("active");
			if ($(this).val()!="-1"){
				$(".proType").eq(0).prop("checked",true);
				$(".proType").eq(0).parent().removeClass("active");
			}
		}
	});
	
	$(".loanType").on("click",function(){
		if ($(this).prop("checked")){
			$(this).parent().addClass("active");
			if ($(this).val()=="-1"){
				$(".loanType").prop("checked",true);
				$(".loanType").parent().addClass("active");
			}
		}else{
			$(this).parent().removeClass("active");
			if ($(this).val()!="-1"){
				$(".loanType").eq(0).prop("checked",true);
				$(".loanType").eq(0).parent().removeClass("active");
			}
		}
	});
	
	//自动投标
	$("#touBao").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".autoBtn", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		datatype:extdatatype,//扩展验证类型
		ajaxPost:true,
		beforeSubmit:function(){
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			var data = {};
			var arr1 = [];
			if ($(".loanType:checked").eq(0).val()=="-1"){
				$(".loanType").each(function(n){
					if (n>0){
						arr1.push($(this).val())
					}
				});
			}else{
				$(".loanType:checked").each(function(){
					arr1.push($(this).val())
				})
			}
			data.loanType = encrypt.encrypt(arr1.join(",")+"");
			
			var arr2 = [];
			if ($(".proType:checked").eq(0).val()=="-1"){
				
				$(".proType").each(function(n){
					if (n>0){
						arr2.push($(this).val())
					}
				});
			}else{
				$(".proType:checked").each(function(){
					arr2.push($(this).val())
				})
			}
			data.proType = encrypt.encrypt(arr2.join(",")+"");
			data.everyMoney = encrypt.encrypt($("#everyMoney").val()+"");		
			if ($("#rateMin").val()!=undefined){
				data.rateMin = encrypt.encrypt($("#rateMin").val()+"");		
			}else{
				data.rateMin = encrypt.encrypt("");		
			}
			if ($("#rateMax").val()!=undefined){
				data.rateMax = encrypt.encrypt($("#rateMax").val()+"");		
			}else{
				data.rateMax = encrypt.encrypt("");		
			}
			
			if ($("#yearMin").val()!=undefined){
				data.yearMin = encrypt.encrypt($("#yearMin").val()+"");		
			}else{
				data.yearMin = encrypt.encrypt("");		
			}
			if ($("#yearMax").val()!=undefined){
				data.yearMax = encrypt.encrypt($("#yearMax").val()+"");		
			}else{
				data.yearMax = encrypt.encrypt("");	
			}
			
			if ($("#monthMin").val()!=undefined){
				data.monthMin = encrypt.encrypt($("#monthMin").val()+"");		
			}else{
				data.monthMin = encrypt.encrypt("");		
			}
			
			if ($("#monthMax").val()!=undefined){
				data.monthMax = encrypt.encrypt($("#monthMax").val()+"");			
			}else{
				data.monthMax = encrypt.encrypt("");			
			}
			
			if ($("#dayMin").val()!=undefined){
				data.dayMin = encrypt.encrypt($("#dayMin").val()+"");		
			}else{
				data.dayMin = encrypt.encrypt("");	
			}
			if ($("#dayMax").val()!=undefined){
				data.dayMax = encrypt.encrypt($("#dayMax").val()+"");
			}else{
				data.dayMax = encrypt.encrypt("");
			}
			
			data.reservedMoney = encrypt.encrypt($("#reservedMoney").val()+"");	
			var url = "investmentManagement/autoBidConfig.html";
			NetUtil.ajax(
					url,
					data,
					function(r){
						r = JSON.parse(r);
						if (r.status == "0"){
							layer.alert(r.message,function(){
								location.reload()
							})
						}else{
							layer.alert(r.message);
						}
					}
			)
			
			
			return false;
		}
	});

	// 取消自动投标
	$("#deleAutoBid").on("click",function(){
		$.ajax({
			type:"GET",
			url:"investmentManagement/removeAutoBidConf.html",
			datatype:"json",
			success:function(r){
				if (r.status=="1") {
					layer.alert("操作成功",function(){
						window.location.reload()
					})
				}else{
					layer.alert(r.message,function(index){
						layer.close(index);
					})
				}
			}
		})
	})
});





