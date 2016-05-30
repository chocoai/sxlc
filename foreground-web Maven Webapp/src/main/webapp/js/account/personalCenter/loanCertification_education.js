/**
 * 学历认证--->文字+附件  @author LHL
 */
/* 验证     */
$(function(){
	checkCAR();
	quryAddress();
});
	function checkCAR(){
		var type=$(".saveSubmit").attr("id");
		$(".authEducation").each(function(){
			$(this).Validform({
				tiptype:3,//提示信息类型
				btnSubmit:".saveSubmit", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
				//btnReset:"#btnreset1",
				datatype:extdatatype,//扩展验证类型
				//showAllError:true,//提交前验证显示所有错误
				ajaxPost:true,
				beforeSubmit:function(curform){
					$(".saveSubmit").attr("disabled","true");
					educationAddOrUpdate();
					return false;
				}
			});
		});
	}
	
	/**
	 * 添加\修改 学历认证
	 * @returns {Boolean}
	 */
	function educationAddOrUpdate(){
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publickey);
		
		var data ={};
		var editType=$(".editType").val();//0-新增  1-修改 
		data.editType=encrypt.encrypt(editType+"");
		
		var education=$(".selectValue").attr("value");//学历编号ID
		data.education=encrypt.encrypt(education+"");
		
		/*var educationName=$(".selectInput ").val();//学历名称
		data.educationName = encrypt.encrypt(educationName);*/
		
		var endTime=$(".dateSelect").val();//有效期
		if(endTime=="请选择登记时间"){
			endTime="";
		}
		data.endTime = encrypt.encrypt(endTime);
		if(editType==1){
			var cid=$(".cid").val();
			data.cid = encrypt.encrypt(cid);
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
		data.annex = annex;
		
		var str_url="personalCenter/authEducation.html";
		NetUtil.ajax(
			str_url,
			data,
			function(r){
				$(".saveSubmit").attr("disabled","false");
				var r = JSON.parse(r);
				if (r.status == 0){
					layer.alert("操作成功",function(){
						window.location.href="personalCenter/loanCertification.html";
					});
				}else{
					layer.alert(r.message);
				}
			}
		);
	}
	
	
	/**
	 * 查询认证信息信息
	 */
	function quryAddress(){
		var type=$(".saveSubmit").attr("id");
		var str_url ="personalCenter/loadAuthEducation.html";//房产认证--企业
		$.ajax({
			type:"GET",
			url:str_url,
			async:true,
			success:function(r){
				var object=JSON.parse(r);
				if(object.status == 0){
					var data = object.data;
					dealAuthEducation(data);
				}
			}
		});
	}
	
	/**
	 * 学历信息
	 * @param data
	 * @param attachPrefix
	 */
	function dealAuthEducation(data){
		if(data!=null){
			
			var education=data.education;//学历ID
			var educationName = data.educationName;//学历名称
			var attachPath=data.attachPath;//附件
			var sEndDate=data.sEndDate;//有效时间
			var cid=data.rid;//认证ID	
			var statu = data.status;
			if(statu=="0"){
				$(".editType").val("0");//新增
			}else if(statu=="1"){
				$(".editType").val("1");//修改
			}else{
				$(".editType").val("2");//查看
			}
			if(data.educationName!=undefined){
				$(".selectValue").attr("value",education);
				$(".selectInput").val(educationName);
			}
			$(".dateSelect").val(sEndDate);
			$(".cid").val(cid);
//			$(".previewHide").val(data[0].attachPath);
//			$("#previewImg").attr("src",attachPath);
//			$(".previewHide").attr("id","1");
//			console.log(data);
			if(data.attachPath!=undefined){
				var arr = data.attachPath.split(",");
				var str = "";
				for (var a = 0;a<arr.length;a++){
					str += "<div class='authPreviDiv'>"+
					"<img class='previewImg'  src='"+data.attachPrefix+arr[a]+"'>"+
					"<input type='hidden' class='previewHide' value='"+arr[a]+"' />"+
					"</div>";
				};
				$(".authPreviDiv_u").html(str);
			}
		}
	}
