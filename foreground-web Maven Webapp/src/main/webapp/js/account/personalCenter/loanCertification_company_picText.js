
/**
 * 企业认证----> 文字+附件  @author LHL
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
						case "12":
							businessAddOrUpdate();
						break;					
						case "13":
							commercialAddOrUpdate();
						break;
						case "14":
							crganizationalAddOrUpdate();
						break;
						case "15":
							accountAddOrUpdate();
						break;
						case "18":
							taxAddOrUpdate();
						break;
						case "19":
							approvalAddOrUpdate();
						break;						
					}
					
					return false;
					
				}
			});
		});
	}
	
	/**
	 * 添加\修改 营业执照
	 */
	function businessAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var businessLicenseNumber=$(".businessLicenseNumber").val();//营业执照号
		var regAddress=$(".regAddress").val();//注册地址
		var regPerson=$(".regPerson").val();//注册法人
		var regCapital=$(".regCapital").val();//注册资金
		var businessScope=$(".businessScope").val();//经营范围
		var CompanyType=$(".CompanyType").val();//公司类型
		var regDate=$(".regDate").val();//注册时间
		if(regDate=="请选择注册时间"){
			regDate="";
		}
		var endTime=$(".endTime").val();//有效期
		var cid=$(".cid").val();
		
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
		businessLicenseNumber=encrypt.encrypt(businessLicenseNumber+"");
		regAddress=encrypt.encrypt(regAddress+"");
		regPerson=encrypt.encrypt(regPerson+"");
		regCapital=encrypt.encrypt(regCapital+"");
		businessScope=encrypt.encrypt(businessScope+"");
		CompanyType=encrypt.encrypt(CompanyType+"");
		regDate=encrypt.encrypt(regDate+"");
		endTime=encrypt.encrypt(endTime+"");
		cid=encrypt.encrypt(cid+"");
		var str_url="personalCenter/businessLicense.html";
		
		NetUtil.ajax(
				str_url,
				{editType:editType,businessLicenseNumber:businessLicenseNumber,regAddress:regAddress,regPerson:regPerson,regCapital:regCapital,businessScope:businessScope,CompanyType:CompanyType,regDate:regDate,endTime:endTime,annex:annex,cid:cid},
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
	 * 添加\修改 工商执照
	 * @returns {Boolean}
	 */
	function commercialAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var address=$(".address").val();//住所
		var regPserson=$(".regPserson").val();//注册法人
		var regCapital=$(".regCapital").val();//注册资本
		regCapital = regCapital.replace(/,/g,"");
		var companyType=$(".companyType").val();//公司类型
		var paidCapital=$(".paidCapital").val();//实收资金
		paidCapital = paidCapital.replace(/,/g,"");
		var businessScope=$(".businessScope").val();//经营范围
		var regDate=$(".regDate").val();//有效期
		var cid=$(".cid").val();
		if(regDate=="请选择成立日期"){
			endTime="";
		}
		var endTime=$(".endTime").val();
		if(endTime=="请选择有效期"){
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
		address=encrypt.encrypt(address+"");
		regPserson=encrypt.encrypt(regPserson+"");
		regCapital=encrypt.encrypt(regCapital+"");
		companyType=encrypt.encrypt(companyType+"");
		paidCapital=encrypt.encrypt(paidCapital+"");
		businessScope=encrypt.encrypt(businessScope+"");
		regDate=encrypt.encrypt(regDate+"");
		endTime=encrypt.encrypt(endTime+"");
		cid=encrypt.encrypt(cid+"");
		var str_url="personalCenter/commercialLicense.html";
		NetUtil.ajax(
			str_url,
			{editType:editType,address:address,regPserson:regPserson,regCapital:regCapital,companyType:companyType,paidCapital:paidCapital,businessScope:businessScope,regDate:regDate,endTime:endTime,annex:annex,cid:cid},
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
	 * 保存\修改 组织机构代码
	 */
	function crganizationalAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var organizationalCode=$(".organizationalCode").val();//组织机构代码
		var cid=$(".cid").val();
		var startTime=$(".startTime").val();//颁发时间
		if(startTime=="请选择颁发时间"){
			startTime="";
		}
		var endTime=$(".endTime").val();//有效时间
		if(endTime=="请选择有效期"){
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
		organizationalCode=encrypt.encrypt(organizationalCode+"");
		cid=encrypt.encrypt(cid+"");
		startTime=encrypt.encrypt(startTime+"");
		endTime=encrypt.encrypt(endTime+"");
		
		var str_url="personalCenter/organizational.html";
		
		NetUtil.ajax(
				str_url,
				{editType:editType,organizationalCode:organizationalCode,cid:cid,startTime:startTime,endTime:endTime,annex:annex},
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
	 * 添加\修改 开户许可证
	 */
	function accountAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var accountOpeningCode=$(".accountOpeningCode").val();//开户许可编号
		var opBank=$(".opBank").val();//开户银行
		var bankAccount=$(".bankAccount").val();//开户帐号
		var cid=$(".cid").val();
		var endTime=$(".endTime").val();//有效时间
		if(endTime=="请选择有效期"){
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
		accountOpeningCode=encrypt.encrypt(accountOpeningCode+"");
		opBank=encrypt.encrypt(opBank+"");
		bankAccount=encrypt.encrypt(bankAccount+"");
		cid=encrypt.encrypt(cid+"");
		endTime=encrypt.encrypt(endTime+"");
		var str_url="personalCenter/accountOpening.html";
		
		NetUtil.ajax(
				str_url,
				{editType:editType,accountOpeningCode:accountOpeningCode,opBank:opBank,bankAccount:bankAccount,cid:cid,endTime:endTime,annex:annex},
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
	 * 添加\修改 税务登记认证
	 */
	function taxAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var credentialsNO=$(".credentialsNO").val();//税务编号
		var issueOrgan=$(".issueOrgan").val();//颁发机构
		var endTime=$(".endTime").val();//有效期
		if(endTime=="请选择有效期"){
			endTime="";
		}
		var cid=$(".cid").val();
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
		credentialsNO=encrypt.encrypt(credentialsNO+"");
		issueOrgan=encrypt.encrypt(issueOrgan+"");
		endTime=encrypt.encrypt(endTime+"");
		cid=encrypt.encrypt(cid+"");
		var str_url="personalCenter/taxRegistration.html";
		NetUtil.ajax(
				str_url,
				{editType:editType,credentialsNO:credentialsNO,issueOrgan:issueOrgan,cid:cid,endTime:endTime,annex:annex},
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
	 * 添加\修改 批文认证
	 */
	function approvalAddOrUpdate(){
		
		var editType=$(".editType").val();//0-新增  1-修改 
		var fileSummary=$(".fileSummary").val();//概要
		var issueOrgan=$(".issueOrgan").val();//颁发机构
		var issueDate=$(".issueDate").val();//颁发时间
		if(issueDate=="请输入颁发时间"){
			issueDate="";
		}
		var endTime=$(".endTime").val();//有效时间
		if(endTime=="请选择有效期"){
			endTime="";
		}
		
		var cid=$(".cid").val();
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
		fileSummary=encrypt.encrypt(fileSummary+"");
		issueOrgan=encrypt.encrypt(issueOrgan+"");
		issueDate=encrypt.encrypt(issueDate+"");
		endTime=encrypt.encrypt(endTime+"");
		cid=encrypt.encrypt(cid+"");
		
		var str_url="personalCenter/authApproval.html";
		NetUtil.ajax(
				str_url,
				{editType:editType,fileSummary:fileSummary,issueOrgan:issueOrgan,issueDate:issueDate,cid:cid,endTime:endTime,annex:annex},
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
	 * 查询认证信息
	 */
	function quryAddress(){
		var type=$(".saveSubmit").attr("id");
		var str_url;
		switch(type){
			case "12":
				str_url="personalCenter/loadBusinessLicense.html"; //工商执照
			break;		
			case "13":
				str_url="personalCenter/loadCommercialLicense.html"; //工商执照
			break;	
			case "14":
				str_url="personalCenter/loadOrganizational.html"; //工商执照
			break;	
			case "15":
				str_url="personalCenter/loadAccountOpening.html"; //开户许可
			break;
			case "18":
				str_url="personalCenter/loadTaxRegistration.html"; //税务登记
			break;
			case "19":
				str_url="personalCenter/loadAuthApproval.html"; //税务登记
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
					case "12":
						dealBusiness(data,object.attachPrefix);//工商执照认证数
					break;					
					case "13":
						dealCommercial(data,object.attachPrefix);//工商执照认证数
					break;	
					case "14":
						dealOrganizational(data,object.attachPrefix);//组织机构代码
					break;
					case "15":
						dealAccount(data,object.attachPrefix);//开户许可
					break;
					case "18":
						dealTax(data,object.attachPrefix);//开户许可
					break;
					case "19":
						dealApproval(data,object.attachPrefix);//开户许可
					break;					
				}
				}
			}
		})		
	}
	
	function dealBusiness(data,attachPrefix){
		if(data!=null && data!=""){
			var businessLicenseNumber=data.Firm_BLN;//执照号
			var regAddress=data.Firm_Address;//注册地址
			var regPerson=data.Firm_Legal;//法人
			var regCapital=data.Reg_Capital;//注册资金
			var businessScope=data.Reg_Business;//经营范围
			var CompanyType=data.Firm_Type;//公司范围
			var regDate=data.Reg_Date;//注册时间
			var endTime=data.End_Date;//有效期
			var attachPath=attachPrefix+""+data.Attach_Path;//附件
			
			$(".businessLicenseNumber").val(businessLicenseNumber);
			$(".regAddress").val(regAddress);
			$(".regPerson").val(regPerson);
			$(".regCapital").val(regCapital);
			$(".businessScope").val(businessScope);
			$(".CompanyType").val(CompanyType);
			$(".regDate").val(regDate);
			$(".endTime").val(endTime);
			
			$(".editType").val("1");
			$(".previewHide").val(data.Attach_Path);
			$("#previewImg").attr("src",attachPath);
			$(".previewHide").attr("id","1");				
			
		}
	}
	
	/**
	 * 查询工商执照认证数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealCommercial(data,attachPrefix){
		if(data!=null && data!="" ){
			//console.log(data);
			var address=data.Residence;//住所
			var regPserson=data.Firm_Legal;//注册法人
			var regCapital=data.Reg_Capital;//注册资本
			var companyType=data.Firm_Type;//公司类型
			var paidCapital=data.Real_Capital;//实收资本
			var businessScope=data.Reg_Business;//经营范围
			var regDate=data.SetUp_Date;//成立日期
			var endTime=data.End_Date;//有效期
			var attachPath=attachPrefix+""+data.Attach_Path;//附件
			
			$(".address").val(address);
			$(".regPserson").val(regPserson);
			$(".regCapital").val(regCapital);
			$(".companyType").val(companyType);
			$(".paidCapital").val(paidCapital);
			$(".businessScope").val(businessScope);
			$(".regDate").val(regDate);
			$(".endTime").val(endTime);
			
			$(".editType").val("1");
			$(".previewHide").val(data.Attach_Path);
			$("#previewImg").attr("src",attachPath);
			$(".previewHide").attr("id","1");			
			
		}
	}
	
	/**
	 * 查询组织机构代码数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealOrganizational(data,attachPrefix){
		if(data!=null && data!=""){
			var organizationalCode=data.Firm_OC;// 组织结构代码
			var startTime=data.Reg_Date;//颁发时间
			var endTime=data.End_Date;//有效期
			var attachPath=attachPrefix+""+data.Attach_Path;//附件
			$(".organizationalCode").val(organizationalCode);
			$(".startTime").val(startTime);
			$(".endTime").val(endTime);
			
			$(".editType").val("1");
			$(".previewHide").val(data.Attach_Path);
			$("#previewImg").attr("src",attachPath);
			$(".previewHide").attr("id","1");			
			
		}
	}
	
	/**
	 * 查询开户许可数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealAccount(data,attachPrefix){
		if(data!=null &&　data!=""){
			var accountOpeningCode=data.Permits_Code;//许可证
			var opBank=data.Permits_Bank;//开户银行
			var bankAccount=data.Bank_No;//帐号
			var endTime=data.End_Date;
			var attachPath=attachPrefix+""+data.Attach_Path;//附件
			
			$(".accountOpeningCode").val(accountOpeningCode);
			$(".opBank").val(opBank);
			$(".bankAccount").val(bankAccount);
			$(".endTime").val(endTime);
			$(".editType").val("1");
			$(".previewHide").val(data.Attach_Path);
			$("#previewImg").attr("src",attachPath);
			$(".previewHide").attr("id","1");			
			
		}
	}
	
	/**
	 * 查询税务登记 数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealTax(data,attachPrefix){
		if(data!=null && data!=""){
			//console.log(data);
			var credentialsNO=data.Credentials_NO;//税务编号
			var issueOrgan=data.Issue_Organ;//颁发机构
			var endTime=data.End_Date;
			var attachPath=attachPrefix+""+data.Attach_Path;//附件
			$(".credentialsNO").val(credentialsNO);
			$(".issueOrgan").val(issueOrgan);
			$(".endTime").val(endTime);
			$(".editType").val("1");
			$(".previewHide").val(data.Attach_Path);
			$("#previewImg").attr("src",attachPath);
			$(".previewHide").attr("id","1");				
		}
	}
	
	/**
	 * 查询批文数据处理
	 * @param data
	 * @param attachPrefix
	 */
	function dealApproval(data,attachPrefix){
		if(data!=null && data!=""){
			var fileSummary=data.File_Summary;//文件概要
			var issueOrgan=data.Issue_Organ;//颁发机构
			var issueDate=data.Issue_Date;//颁发时间
			var endTime=data.End_Date;//有效期
			var attachPath=attachPrefix+""+data.Attach_Path;//附件
			$(".fileSummary").val(fileSummary);
			$(".issueOrgan").val(issueOrgan);
			$(".issueDate").val(issueDate);
			$(".endTime").val(endTime);
			$(".endTime").val(endTime);
			$(".editType").val("1");
			$(".previewHide").val(data.Attach_Path);
			$("#previewImg").attr("src",attachPath);
			$(".previewHide").attr("id","1");				
			
		}
	}

	
