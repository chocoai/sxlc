function serachByType(value){
	var url = "commodityTypeManager/serachByType.do";
	var upId = encrypt.encrypt($("#getType").val()+"");
	var data = {upId:upId}
	NetUtil.ajax(
			url,
			data,
			function(r){
				var str = "";
				for (var a = 0;a<r.length;a++){
					str += "<option value='"+r[a].commodityTypeID+"'>"+r[a].commodityClassify+"</option>";
				}
				$("#getLei").html(str);
				if (value!=undefined){
					$("#getLei").val(value);
				}
			}
	)
}

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

$(function(){

	UploadImg("filePicker",$("#fileList"),1,$("#urlBigImg"),361,333);
	UploadImg("filePicker1",$("#fileList1"),1,$("#urlSmaillImg"),361,333);
	
	$("#getType").on("change",function(){
		serachByType();
	});
	
	var id = GetQueryString("id");
	var url = "commodityManager/commodInfo/"+id+".do";
	$.ajax({
		type:"get",
		url:url,
		dataType:"json",
		success:function(r){
			var commodityType = r.commodityType;
		
			$("#getType").val(r.commodityType);
			serachByType(r.commodityTypeID)
			
			if (r.commoditylargeIcon!=null){
				$("#fileList").html("<div id='WU_FILE_0' class='file-item thumbnail upload-state-done imgDisplay'> <img style='height:100px' src='"
						+r.picBasePath+r.commoditylargeIcon
						+"'><div class='info'>"+"</div><div class='file-panel'><span class='cancel deleteBtn'>"
						+"</span></div></div>");
				
				$("#urlBigImg").val(r.commoditylargeIcon);
			}
			
			if (r.commoditySmallIcon!=null){
				$("#fileList1").html("<div id='WU_FILE_0' class='file-item thumbnail upload-state-done imgDisplay'> <img style='height:100px' src='"
						+r.picBasePath+r.commoditySmallIcon
						+"'><div class='info'>"+"</div><div class='file-panel'><span class='cancel deleteBtn'>"
						+"</span></div></div>");
				
				$("#urlSmallImg").val(r.commoditySmallIcon);
			}
			
			
			
			//绑定事件
			 $(".imgDisplay").mouseover(function(){
				 $(this).children(".file-panel").css("height","30px");
			 });
			 $(".imgDisplay").mouseout(function(){
				 $(this).children(".file-panel").css("height","0");
			 });
			 //点击删除图标
			 $(".deleteBtn").click(function(){
				 var $this = $(this); 
				 var old = $("#deleteaffix").val();
				 var temp = $this.attr("attachIndex");
				 if(old !=null && old != ""){
					 $("#deleteaffix").val(old+";"+temp);
				 }else{
					 $("#deleteaffix").val(temp);
				 }
				 $this.parent().parent(".imgDisplay").remove();
			 });
			 
			 
			$("#goodName").val(r.commodityName);
			$("#point").val(r.needPoint);
			$("#endTime").val(r.endDate.substr(0,r.endDate.indexOf(" ")));
			$("#manufactor").val(r.manufacturer);
			$("#marketValue").val(r.marketPrice);
			$("#specifications").val(r.specificationsmodels);
			$("#stock").val(r.quantity);
			$("#denominationVouchers").val(r.vouchersAmount);
			$("#urlBigImg").val(r.commoditylargeIcon);
			$("#urlSmallImg").val(r.commoditySmallIcon);
			if (r.commodityDescribe!=null){
				ue.setContent(r.commodityDescribe);
			};
		}
	})
	
	
	$("#good_add").Validform({
		tiptype:3,
		btnSubmit:".queding", 
		datatype:{"enterAddress":enterAddress,"acountM":acountM,"img":img,"time":time},
		ajaxPost:true,
		beforeSubmit:function(){
				if ($("#fileList").html()==""){
					layer.alert("请上传前台展示大图标");
					return
				}
				if ($("#fileList1").html()==""){
					layer.alert("请上传前台展示小图标");
					return
				}
				var data = {};
				data.typeId = encrypt.encrypt($("#getLei").val()+"");
				data.goodName = encrypt.encrypt($("#goodName").val()+"");
				data.point = encrypt.encrypt($("#point").val()+"");
				data.endTime = encrypt.encrypt($("#endTime").val()+"");
				data.manufactor = encrypt.encrypt($("#manufactor").val()+"");
				data.specifications = encrypt.encrypt($("#specifications").val()+"");
				data.stock = encrypt.encrypt($("#stock").val()+"");
				data.isVip = encrypt.encrypt($("#isVip").val()+"");
				data.isActivity = encrypt.encrypt($("#isActivity").val()+"");
				data.denominationVouchers = encrypt.encrypt($("#denominationVouchers").val()+"");
				data.marketValue = encrypt.encrypt($("#marketValue").val()+"");
				data.maxPicPath = encrypt.encrypt($("#urlBigImg").val()+"");
				data.minPicPath = encrypt.encrypt($("#urlSmallImg").val()+"");
				data.commodDetail = encrypt.encrypt(ue.getContent()+"");
				data.goodId = encrypt.encrypt(GetQueryString("id")+"");
				var url = "commodityManager/edit.do";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = r;
							console.log(r)
							if (data.status=="1"){
								layer.alert("修改成功",function(){
									window.history.go(-1);
								});
							}else{
								layer.alert("修改失败",function(index){
									layer.close(index);
								});
							}
							
						}
				)
				
				return false
			}
		});
	
});
