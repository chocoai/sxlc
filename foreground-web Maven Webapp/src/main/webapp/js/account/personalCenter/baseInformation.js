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
	bindPro();
	
	
});


function bindPro(){
	$.ajax({
		url:"personalCenter/provinceList.html",
		dataType:"json",
		type:"post",
		success:function(json){
			$(".province li").remove();
			for (var int = 0; int < json.length; int++) {
				$(".province").append("<li class=\"selectOption\" value=\""+json[int].pId+"\">"+json[int].pName+"</li>");
			}
			$(".province .selectOption").on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
				$(".county li").remove();
				bindCity($(this).attr("value"));
			})
		}
	});
}


function bindCity(pid){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	var spid = encrypt.encrypt(pid);
	$.ajax({
		url:"personalCenter/citys.html",
		dataType:"json",
		type:"post",
		data:{proId:spid},
		success:function(json){
			console.log(json);
			$(".city li").remove();
			for (var int = 0; int < json.length; int++) {
				$(".city").append("<li class=\"selectOption\" value=\""+json[int].cId+"\">"+json[int].cName+"</li>");
			}
			$(".city .selectOption").on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
				$(".county li").remove();
				bindCounty($(this).attr("value"));
			})
		}
	});
}


function bindCounty(cid){
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	var scid = encrypt.encrypt(cid);
	$.ajax({
		url:"personalCenter/countys.html",
		dataType:"json",
		type:"post",
		data:{cid:scid},
		success:function(json){
			console.log(json);
			$(".county li").remove();
			for (var int = 0; int < json.length; int++) {
				$(".county").append("<li class=\"selectOption\" value=\""+json[int].xId+"\">"+json[int].xName+"</li>");
			}
			$(".county .selectOption").on("click",function(){
				$(this).parent().parent().find(".selectInput").val($(this).html());
				$(this).parent().parent().find(".selectValue").attr("value",$(this).attr("value"));
				$(this).parent().slideUp(200);
				$(this).parent().parent().find(".selectInput").css('color','#2f2f2f');
			})
		}
	});
}


function submitEditPersonal(){
	var smemberQQ = $(".input-QQ").val();
	var homeTown = $(".input-homeTown").val();
	var loction	 = $(".input-location").val();
	var sprovinceId	= $(".province").parent().find(".selectValue").attr("value");
	var scityId		= $(".city").parent().find(".selectValue").attr("value");
	var scountyId	= $(".county").parent().find(".selectValue").attr("value");
	
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	smemberQQ = encrypt.encrypt(smemberQQ);
	homeTown = encrypt.encrypt(homeTown);
	loction	 = encrypt.encrypt(loction);
	sprovinceId	= encrypt.encrypt(sprovinceId);
	scityId		= encrypt.encrypt(scityId);
	scountyId	= encrypt.encrypt(scountyId);
	
	$.ajax({
		url:"personalCenter/editPsersonInfo.html",
		type:"post",
		dataType:"json",
		data:{memberQQ:smemberQQ,address:loction,hjdz:homeTown,provinceId:sprovinceId,cityId:scityId,countyId:scountyId},
		success:function(json){
			console.log(json);
		}
	});
}


function submitEditCompanlyInfo(){
	var contactName = $("input[name='contactName']").val();
	var contactPhone= $("input[name='contactPhone']").val();
	var contactQq   = $("input[name='contactQq']").val();
	var contactEmail= $("input[name='contactEmail']").val();
	var companyIndo = $("#contactus").text();
	var sprovinceId	= $(".province").parent().find(".selectValue").attr("value");
	var scityId		= $(".city").parent().find(".selectValue").attr("value");
	var scountyId	= $(".county").parent().find(".selectValue").attr("value");
	
	
	var encrypt = new JSEncrypt();
	encrypt.setPublicKey(publicKey);
	
	contactName = encrypt.encrypt(contactName);
	contactPhone= encrypt.encrypt(contactPhone);
	contactQq	= encrypt.encrypt(contactQq);
	contactEmail= encrypt.encrypt(contactEmail);
	companyIndo	= encrypt.encrypt(companyIndo);
	sprovinceId	= encrypt.encrypt(sprovinceId);
	scityId		= encrypt.encrypt(scityId);
	scountyId	= encrypt.encrypt(scountyId);
	
	var data = {};
	data.provinceId			= sprovinceId;
	data.cityId				= scityId;
	data.countyId			= scountyId;
	data.contactName		= contactName;
	data.contactPhone		= contactPhone;
	data.contactQQ			= contactQq;
	data.contactEmail		= contactEmail;
	data.companyProfile		= companyIndo;
	NetUtil.ajax("personalCenter/editComplanyInfo.html", data, success, null);
	function success(json){
		json = JSON.parse(json);
		if(json.status == 0){
			alert(json.message);
			window.location.href="personalCenter/baseInformationForPerson.html";
		}else if(json.status == -2){
			alert("参数出错");
		}else{
			alert(json.message);
		}
	}
}



/* 验证     */
$(function(){
	var app = $("#testbox").Validform({
		tiptype:3,//提示信息类型
		btnSubmit:".preserve", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(){
			if(memberType == 0){
				submitEditPersonal();
			}else{
				submitEditCompanlyInfo();
			}
			return false;
		}
	});
});




