$(function(){
	$(".addAuthen").on("click",function(){
		cleanTheWindow();//清理添加窗口中可能存在的旧数据
		//显示添加窗口
		addHouse("添加房产认证");
	});
	
	$("#house").Validform({
		tiptype:5,//提示信息类型
		btnSubmit:".saveSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		//btnReset:"#btnreset1",
		datatype:extdatatype,//扩展验证类型
		//showAllError:true,//提交前验证显示所有错误
		ajaxPost:true,
		beforeSubmit:function(){
			$(".saveSubmit").attr("disabled","true");
			var editType=$(".house").find(".editType").val();//0-新增  1-修改 
			var address=$(".house").find(".address").val();//房产地址
			var area=$(".house").find(".area ").val();//面积
			var value=$(".house").find(".value").val();//价值
			value = value.replace(/,/g,"");
			var endTime=$(".house").find(".dateSelect").val();//有效期
			var cid=$(".house").find(".cid").val();
			if(endTime=="请选择登记时间"){
				endTime="";
			}
			var authPrev=$(".house").find(".previewHide").attr("id");
			var url=[];//附件路径数组
			if(authPrev==0){
				layer.alert("请上传认证附件");
				return;
			}
			//循环图片地址
			var path;
			$(".house").find(".previewHide").each(function(){
				path=$(this).val();
				url.push(path);
			});
			//附件","分开
			var annex=url.join(",");
			
			var data={};
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey);
			data.editType=encrypt.encrypt(editType+"");
			data.endTime=encrypt.encrypt(endTime+"");
			data.address=encrypt.encrypt(address+"");
			data.area=encrypt.encrypt(area+"");
			data.value=encrypt.encrypt(value+"");
			if(editType!=0){
				data.cid=encrypt.encrypt(cid+"");
			}else{
				data.cid=encrypt.encrypt(0+"");
			}
			data.annex=annex;//附件路径不加密
			
			var str_url="personalCenter/authHousing.html";
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
/**加载已保存房产认证列表***/
function loadAuthHousing(){
	var str_url = "personalCenter/loadAuthHousing.html"; //房产认证--个人
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
					var html = template("house_list",object);
					$("#house_body").html("");
					$("#house_body").append(html);
				}
				$(".attachPrefix").val(object.attachPrefix);
			}
		}
	});
}

function addHouse(title){
	$(".editType").val(0);
	$(".cid").val(0);
	cleanTheWindow();
	layer.open({
		 type: 1,
		 area: ['800px', '600px'], 
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
	$(".address").val($(".address").attr("lang"));
	$(".area").val($(".area").attr("lang"));
	$(".value").val($(".value").attr("lang"));
	$(".dateSelect").val($(".dateSelect").attr("lang"));
	$(".tag").removeClass("Validform_right");
	$(".tag").removeClass("Validform_wrong");
}
/**
 * 查看房产信息及附件
 */
function showHouse(cid){
	cleanTheWindow();
	
	$tr = $(".tr_"+cid);
	var data={};
	data.cid= cid;
	data.homeAddress = $tr.find(".td_homeAddress").html();
	data.area= $tr.find(".td_area").html();
	data.value= $tr.find(".td_value").html();
	data.endDate= $tr.find(".td_endDate").html();
	data.attachPath=$tr.find(".td_attachPath").attr("value");//附件路径
	data.attachPrefix=$(".attachPrefix").val();//附件路径的前缀
	dealHouseData(data,"cloneDiv_show");
	layer.open({
		 type: 1,
		 area: ['800px', '600px'], 
		 title: "查看房产认证",
		 maxmin: false,
		 content: $(".cloneDiv_show")
	});
}
/**
 * 修改房产认证
 * @param cid
 */
function modifyHouse(cid){
	cleanTheWindow();
	$(".editType").val(1);
	$tr = $(".tr_"+cid);
	var data={};
	data.cid= cid;
	data.homeAddress = $tr.find(".td_homeAddress").html();
	data.area= $tr.find(".td_area").html();
	data.value= $tr.find(".td_value").html();
	data.endDate= $tr.find(".td_endDate").html();
	data.attachPath=$tr.find(".td_attachPath").attr("value");//附件路径
	data.attachPrefix=$(".attachPrefix").val();//附件路径的前缀
	dealHouseData(data,"cloneDiv");
	layer.open({
		 type: 1,
		 area: ['800px', '600px'], 
		 title: "修改房产认证",
		 maxmin: false,
		 content: $(".cloneDiv")
	});
	expMoreUpload(".file");
}

function dealHouseData(data,className){
	$("."+className).find(".cid").val(data.cid);
	$("."+className).find(".address").val(data.homeAddress);
	$("."+className).find(".area").val(data.area);
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