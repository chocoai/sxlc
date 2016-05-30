$(function(){
	$(".addAuthen").on("click",function(){
		addCar("添加车产认证");
	});

	$("#car").Validform({
		tiptype:5,//提示信息类型
		btnSubmit:".saveSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(){
			$(".saveSubmit").attr("disabled","true");
			var editType=$(".car").find(".editType").val();//0-新增  1-修改 
			var brand=$(".car").find(".brand").val();//车辆品牌
			var model=$(".car").find(".model").val();//车辆型号
			var licensePlate=$(".car").find(".licensePlate").val();//车牌号
			var value=$(".car").find(".value").val();//价值
			value = value.replace(/,/g,"");
			var endTime=$(".car").find(".dateSelect").val();//有效期
			var cid=$(".car").find(".cid").val();
			if(endTime=="请选择登记时间"){
				endTime="";
			}
			var authPrev=$(".car").find(".previewHide").attr("id");
			var url=[];//附件路径数组
			if(authPrev==0){
				layer.alert("请上传认证附件");
				return;
			}
			//循环图片地址
			var path;
			$(".car").find(".previewHide").each(function(){
				path=$(this).val();
				url.push(path);
			});
			//附件","分开
			var annex=url.join(",");
			
			var data={};
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			
			data.editType=encrypt.encrypt(editType+"");
			data.brand=encrypt.encrypt(brand+"");
			data.model=encrypt.encrypt(model+"");
			data.licensePlate=encrypt.encrypt(licensePlate+"");
			data.value=encrypt.encrypt(value+"");
			data.endTime=encrypt.encrypt(endTime+"");
			if(editType!=0){
				data.cid=encrypt.encrypt(cid+"");
			}else{
				data.cid=encrypt.encrypt(0+"");
			}
			data.annex=annex;//附件路径不加密
			
			var str_url="personalCenter/authProduction.html";
			NetUtil.ajax(
				str_url,
				data,
				function(r){
					$(".saveSubmit").attr("disabled","false");
					var r = JSON.parse(r);
					if (r.status == 0){
						layer.alert("操作成功",function(){
							loadAuthHousing();
							layer.closeAll();
						});
					}else{
						layer.alert(r.message);
					}
				}
			);
			return false;
		}
	});
	
	loadAuthHousing();
});
/**加载已保存车产认证列表***/
function loadAuthHousing(){
	var str_url = "personalCenter/loadAuthProduction.html"; //车产认证--个人
	$.ajax({
		type:"GET",
		url:str_url,
		async:true,
		success:function(r){
			var object=JSON.parse(r);
			if(object.status == 0){
				var data = object.data;
				//layer.alert(data);
				//layer.alert(data.length);
				if(data.length>0){
					var html = template("car_list",object);
					$("#car_body").html("");
					$("#car_body").append(html);
				}
				$(".attachPrefix").val(object.attachPrefix);
			}
		}
	});
}

function addCar(title){
	$(".editType").val(0);
	$(".cid").val(0);
	cleanTheWindow();
	layer.open({
		 type: 1,
		 area: ['880px', '600px'], 
		 title: title,
		 maxmin: true,
		 content: $(".cloneDiv")
	});
	expMoreUpload(".file");
}
/**
 * 清理窗口  旧数据
 */
function cleanTheWindow(){
	$(".file").html("<img class=\"previewImg previewPicture\"  src=\"resource/img/account/common/opacity.png\">");
	$(".authPreviDiv_u").html("");
	$(".brand").val($(".brand").attr("lang"));
	$(".model").val($(".model").attr("lang"));
	$(".licensePlate").val($(".licensePlate").attr("lang"));
	$(".value").val($(".value").attr("lang"));
	$(".dateSelect").val($(".dateSelect").attr("lang"));
	$(".tag").removeClass("Validform_right");
	$(".tag").removeClass("Validform_wrong");
}
/**
 * 查看车产信息及附件
 */
function showCar(cid){
	cleanTheWindow();
	//读取详细车辆信息写入data
	$tr = $(".tr_"+cid);
	var data={};
	data.cid= cid;
	data.brand = $tr.find(".td_brand").html();
	data.model= $tr.find(".td_model").html();
	data.licensePlate= $tr.find(".td_licensePlate").html();
	data.value= $tr.find(".td_value").html();
	data.endDate= $tr.find(".td_endDate").html();
	data.attachPath=$tr.find(".td_attachPath").attr("value");//附件路径
	data.attachPrefix=$(".attachPrefix").val();//附件路径的前缀
	dealCarData(data,"cloneDiv_show");
	layer.open({
		 type: 1,
		 area: ['800px', '600px'], 
		 title: "查看车产认证",
		 maxmin: false,
		 content: $(".cloneDiv_show")
	});
}
/**
 * 修改车产认证
 * @param cid
 */
function modifyCar(cid){
	cleanTheWindow();
	$(".editType").val(1);
	$tr = $(".tr_"+cid);
	var data={};
	data.cid= cid;
	data.brand = $tr.find(".td_brand").html();
	data.model= $tr.find(".td_model").html();
	data.licensePlate= $tr.find(".td_licensePlate").html();
	data.value= $tr.find(".td_value").html();
	data.endDate= $tr.find(".td_endDate").html();
	data.attachPath=$tr.find(".td_attachPath").attr("value");//附件路径
	data.attachPrefix=$(".attachPrefix").val();//附件路径的前缀
	dealCarData(data,"cloneDiv");
	layer.open({
		 type: 1,
		 area: ['800px', '600px'], 
		 title: "修改车产认证",
		 maxmin: false,
		 content: $(".cloneDiv")
	});
	expMoreUpload(".file");
}

function dealCarData(data,className){
	$("."+className).find(".cid").val(data.cid);
	$("."+className).find(".brand").val(data.brand);
	$("."+className).find(".model").val(data.model);
	$("."+className).find(".licensePlate").val(data.licensePlate);
	$("."+className).find(".value").val(data.value);
	$("."+className).find(".dateSelect").val(data.endDate);
	var arr = data.attachPath.split(",");
	var str = "";
	for (var a = 0;a<arr.length;a++){
		str += "<div class='authPreviDiv'>"+
			"<img class='previewImg'  src='"+data.attachPrefix+arr[a]+"'>"+
			"<input type='hidden' class='previewHide' value='"+arr[a]+"' />"+
			"</div>";
	};
	$("."+className).find(".authPreviDiv_u").html(str);
}