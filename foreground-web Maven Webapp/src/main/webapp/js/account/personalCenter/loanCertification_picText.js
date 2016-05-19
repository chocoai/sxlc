/**
 * 个人认证--->文字+附件  @author LHL
 */
/* 验证     */
$(function(){
	checkCAR();
	quryAddress();
});
	function checkCAR(){
		var type=$(".saveSubmit").attr("id");
		$(".person_Renzheng").each(function(){
			$(this).Validform({
				tiptype:3,//提示信息类型
				btnSubmit:".saveSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
				//btnReset:"#btnreset1",
				datatype:extdatatype,//扩展验证类型
				//showAllError:true,//提交前验证显示所有错误
				ajaxPost:true,
				beforeSubmit:function(curform){
					switch(type){
						case "7":
							freeholdAddOrUpdate();
						break;	
						case "8":
							voitureAddOrUpdate();
						break;	
						case "10":
							marriageAddOrUpdate();
						break;
						case "22":
							freeholdAddOrUpdate();
						break;	
						case "23":
							voitureAddOrUpdate();
						break;						
					}
					
					return false;
					
				}
			});
		});
	}
	
	/**
	 * 添加\修改 房产认证
	 * @returns {Boolean}
	 */
	function freeholdAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var address=$(".address").val();//房产地址
		var area=$(".area ").val();//面积
		var value=$(".value").val();//价值
		value = value.replace(/,/g,"");
		var endTime=$(".dateSelect").val();//有效期
		var cid=$(".cid").val();
		if(endTime=="请选择登记时间"){
			endTime="";
		}
		var authPrev=$(".previewHide").attr("id");
		var url=[];//附件路径数组
		if(authPrev==0){
			layer.alert("请上传认证附件");
			return;
		}
		//循环图片地址
		var path;
		$(".previewHide").each(function(){
			path=$(this).val();
			url.push(path);
		});
		//附件","分开
		var annex=url.join(",");
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		editType=encrypt.encrypt(editType+"");
		endTime=encrypt.encrypt(endTime+"");
		address=encrypt.encrypt(address+"");
		area=encrypt.encrypt(area+"");
		value=encrypt.encrypt(value+"");
		cid=encrypt.encrypt(cid+"");
		var str_url="personalCenter/authHousing.html";
		NetUtil.ajax(
			str_url,
			{editType:editType,endTime:endTime,annex:annex,address:address,area:area,value:value,cid:cid},
			function(r){
				var r = JSON.parse(r);
				if (r.status == 0){
					layer.alert("操作成功",function(){
						window.location.href="personalCenter/loanCertification.html";
					})
				}else{
					layer.alert(r.message);
				}
			}
		)		
	}
	
	/**
	 * 添加\修改 车产认证
	 */
	function voitureAddOrUpdate(){
		var editType=$(".editType").val();//0-新增  1-修改 
		var brand=$(".brand").val();//车辆品牌
		var model=$(".model").val();//车辆型号
		var licensePlate=$(".licensePlate").val();//车牌号
		var value=$(".value").val();//价值
		value = value.replace(/,/g,"");
		var endTime=$(".dateSelect").val();//有效期
		var cid=$(".cid").val();
		if(endTime=="请选择首次登记日期"){
			endTime="";
		}		
		var authPrev=$(".previewHide").attr("id");
		var url=[];//附件路径数组
		if(authPrev==0){
			layer.alert("请上传认证附件");
			return;
		}
		//循环图片地址
		var path;
		$(".previewHide").each(function(){
			path=$(this).val();
			url.push(path);
		});
		//附件","分开
		var annex=url.join(",");		
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);		
		editType=encrypt.encrypt(editType+"");
		brand=encrypt.encrypt(brand+"");
		model=encrypt.encrypt(model+"");
		licensePlate=encrypt.encrypt(licensePlate+"");
		value=encrypt.encrypt(value+"");
		endTime=encrypt.encrypt(endTime+"");
		cid=encrypt.encrypt(cid+"");
		var str_url="personalCenter/authProduction.html";
		NetUtil.ajax(
				str_url,
				{editType:editType,brand:brand,model:model,licensePlate:licensePlate,value:value,endTime:endTime,cid:cid,annex:annex},
				function(r){
					var r = JSON.parse(r);
					if (r.status == 0){
						layer.alert("操作成功",function(){
							window.location.href="personalCenter/loanCertification.html";
						})
					}else{
						layer.alert(r.message);
					}
				}
			)		
	}
	
	/**
	 * 添加\修改 婚姻认证
	 */
	function marriageAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var marrigeState = $(".radio[checked=checked]").attr("value");//婚姻状况		
		var endTime=$(".dateSelect").val();//登记日期
		var cid=$(".cid").val();
		if(endTime=="请选择登记日期"){
			endTime="";
		}		
		var authPrev=$(".previewHide").attr("id");
		var url=[];//附件路径数组
		if(authPrev==0){
			layer.alert("请上传认证附件");
			return;
		}
		//循环图片地址
		var path;
		$(".previewHide").each(function(){
			path=$(this).val();
			url.push(path);
		});		
		//附件","分开
		var annex=url.join(",");		
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		
		editType=encrypt.encrypt(editType+"");
		endTime=encrypt.encrypt(endTime+"");
		marriageType=encrypt.encrypt(marrigeState+"");
		cid=encrypt.encrypt(cid+"");
		var str_url="personalCenter/authMarriage.html";
		NetUtil.ajax(
				str_url,
				{editType:editType,endTime:endTime,cid:cid,annex:annex,marriageType:marriageType,cid:cid},
				function(r){
					var r = JSON.parse(r);
					if (r.status == 0){
						layer.alert("操作成功",function(){
							window.location.href="personalCenter/loanCertification.html";
						})
					}else{
						layer.alert(r.message);
					}
				}
			)		
		
	}
	
	/**
	 * 查询认证信息信息
	 */
	function quryAddress(){
		var type=$(".saveSubmit").attr("id");
		var str_url;
		switch(type){
			case "7":
				str_url="personalCenter/loadAuthHousing.html"; //房产认证--个人
			break;
			case "8":
				str_url="personalCenter/loadAuthProduction.html";//车产认证--个人
			break;
			case "10":
				str_url="personalCenter/loadAuthMarriage.html";//婚姻认证
			break;
			case "22":
				str_url="personalCenter/loadAuthHousing.html";//房产认证--企业
			break;			
			case "23":
				str_url="personalCenter/loadAuthProduction.html";//车产认证--企业
			break;			
		}
		$.ajax({
			type:"GET",
			url:str_url,
			async:true,
			success:function(r){
				var object=JSON.parse(r);
				if(object.status == 0){
					var data = object.data;
					switch(type){
					case "7":
						dealFreehold(data,object.attachPrefix);
					break;
					case "8":
						dealVoiture(data,object.attachPrefix);
					break;	
					case "10":
						dealMarriage(data,object.attachPrefix);
					break;	
					case "22":
						dealFreehold(data,object.attachPrefix);
					break;
					case "23":
						dealVoiture(data,object.attachPrefix);
					break;					
				}
				}
			}
		})		
	}
	
	/**
	 * 查询房产认证数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealFreehold(data,attachPrefix){
		if(data!=null && data.length>0){
			var area=data[0].area;//房屋面积
			var attachPath=attachPrefix+""+data[0].attachPath;//附件
			var sEndDate=data[0].sEndDate;//有效时间
			var homeAddress=data[0].homeAddress;//房屋地址
			var value=data[0].value;//价值
			var cid=data[0].rid;//认证ID	
			var statu = data.status;
			if(statu=="0" || statu=="3" || statu=="4"){
				$(".editType").val("0");
			}else{
				$(".editType").val("1");
			}
			$(".area").val(area);
			$(".dateSelect").val(sEndDate);
			$(".address").val(homeAddress);
			$(".value").val(value);
			$(".cid").val(cid);
//			$(".previewHide").val(data[0].attachPath);
//			$("#previewImg").attr("src",attachPath);
//			$(".previewHide").attr("id","1");
//			console.log(data);
			var arr = data[0].attachPath.split(",");
			var str = "";
			for (var a = 0;a<arr.length;a++){
				str += "<div class='authPreviDiv'>"+
   				"<img class='previewImg'  src='"+attachPrefix+arr[a]+"'>"+
   				"<input type='hidden' class='previewHide' value='"+arr[a]+"' />"+
   				"</div>";
			};
			$(".authPreviDiv_u").html(str);
		}		
	}
	
	/**
	 * 查询车产认证数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealVoiture(data,attachPrefix){
		if(data!=null && data.length>0){
			var brand=data[0].brand;//牌子
			var sEndDate=data[0].sEndDate;//登记时间
			var model=data[0].model;//型号
			var licensePlate=data[0].licensePlate;//车牌号
			var value=data[0].value;//价值
			var cid=data[0].rid;
			var attachPath=attachPrefix+""+data[0].attachPath;//附件
			var statu = data.status;
			if(statu=="0" || statu=="3" || statu=="4"){
				$(".editType").val("0");
			}else{
				$(".editType").val("1");
			}
			$(".brand").val(brand);
			$(".dateSelect").val(sEndDate);
			$(".model").val(model);
			$(".licensePlate").val(licensePlate);
			$(".value").val(value);
			$(".cid").val(cid);
//			$(".previewHide").val(data[0].attachPath);
//			$("#previewImg").attr("src",attachPath);
			var arr = data[0].attachPath.split(",");
			var str = "";
			for (var a = 0;a<arr.length;a++){
				str += "<div class='authPreviDiv'>"+
   				"<img class='previewImg'  src='"+attachPrefix+arr[a]+"'>"+
   				"<input type='hidden' class='previewHide' value='"+arr[a]+"' />"+
   				"</div>";
			};
			$(".authPreviDiv_u").html(str);
		}
	}
	
	/**
	 * 查询婚姻认证数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealMarriage(data,attachPrefix){
		//console.log(data);
		if(data!=null){
			var marriageType=data.isMarried;//婚姻状况
			var sEndDate=data.sEndDate;//登记时间
			var cid=data.rid;
			var attachPath=attachPrefix+""+data.attachPath;//附件
			var statu = data.status;
			if(statu=="0" || statu=="3" || statu=="4"){
				$(".editType").val("0");
			}else{
				$(".editType").val("1");
			}
			$(".dateSelect").val(sEndDate);
			$(".previewHide").val(attachPath);
//			$("#previewImg").attr("src",attachPath);
//			$(".previewHide").attr("id","1");	
			var arr = data.attachPath.split(",");
			var str = "";
			for (var a = 0;a<arr.length;a++){
				str += "<div class='authPreviDiv'>"+
   				"<img class='previewImg'  src='"+data.attachPrefix+arr[a]+"'>"+
   				"<input type='hidden' class='previewHide' value='"+arr[a]+"' />"+
   				"</div>";
			};
			$(".authPreviDiv_u").html(str);
			
			$(".radio").each(function(){
				var val=$(this).attr("value");
				if(val==marriageType){
					$(this).siblings("input").next("label").removeClass("checked");
					$(this).attr("checked",true).next("label").addClass("checked");
				}
			});
		}
		
	}
