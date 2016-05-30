function serachByType(){
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
			}
	)
}
$(function(){
	
	UploadImg("filePicker",$("#fileList"),1,$("#maxPic"),361,333);
	UploadImg("filePicker1",$("#fileList1"),1,$("#minPic"),361,333);
	
	$("#getType").on("change",function(){
		serachByType();
	});
	
	serachByType();
	
	$("#good_add").Validform({
		tiptype:5,
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
				console.log($("#maxPic").val());
				console.log($("#minPic").val());
				var data = {};
				data.typeId = encrypt.encrypt($("#getLei").val()+"");
				data.goodName = encrypt.encrypt($("#goodName").val()+"");
				data.point = encrypt.encrypt($("#point").val()+"");
				data.endTime = encrypt.encrypt($("#endTime").val()+"");
				data.manufactor = encrypt.encrypt($("#manufactor").val()+"");
				data.specifications = encrypt.encrypt($("#specifications").val()+"");
//				data.stock = encrypt.encrypt($("#stock").val()+"");
				data.isVip = encrypt.encrypt($("#isVip").val()+"");
				data.isActivity = encrypt.encrypt($("#isActivity").val()+"");
				data.denominationVouchers = encrypt.encrypt($("#denominationVouchers").val()+"");
				data.marketValue = encrypt.encrypt($("#marketValue").val()+"");
				
//				大小图
				data.maxPicPath = encrypt.encrypt($("#maxPic").val()+"");
				data.minPicPath = encrypt.encrypt($("#minPic").val()+"");
				

				data.commodDetail = encrypt.encrypt(ue.getContent()+"");
				
				var url = "commodityManager/release.do";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = r;
							if (data.status=="1"){
								layer.alert("添加成功",function(){
									window.history.go(-1);
								});
							}else{
								layer.alert("添加失败",function(index){
									layer.close(index);
								});
							}
							
						}
				)
				
				return false
			}
		});
	
});
