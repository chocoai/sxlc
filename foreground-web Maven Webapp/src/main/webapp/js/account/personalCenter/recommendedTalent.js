$(function(){
	$(".TB").addClass("down");
	$(".TB11").addClass("down2");
	/*日期选择部分开始 王延君 2016-04-05*/
	$(".chooseTime>span").click(function(){
		$(this).addClass("active").css("color","#72c0f3").siblings("span").css("color","#444444").removeClass("active");
	});
	/*日期选择部分结束 王延君 2016-04-05*/
	/*选项卡切换部分开始*/
	$(".recommendedTalentMain1 .ContHeader .awardStatistics").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain2 .ContHeader .historyCashBack").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain3 .ContHeader .inviteRecord").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain4 .ContHeader .LoanDetails").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain5 .ContHeader .investDetails").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain6 .ContHeader .historyPrincipalBack").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".recommendedTalentMain7 .ContHeader .purchaseDetails").css("border-top","1px solid #72c0f3").css("border-bottom","2px solid #fff");
	$(".ContHeader div").each(function(){
		$(this).click(function(){
			var index=$(this).index();
			$(".recommendedTalentMain").eq(index).show().siblings(".recommendedTalentMain").hide();
		});
	});
	/*选项卡切换部分结束*/
	/*em背景切换开始*/
	$(".ContListTitle div em").on("click",function(){
		if($(this).hasClass("iconDown")){
			$(this).removeClass("iconDown").addClass("iconUp");
		}else{
			$(this).removeClass("iconUp").addClass("iconDown");
		}
	});
	/*em背景切换结束*/
	//
	$(".apply").click(function(){ 
		 $.ajax({     		
		    	url:"recommendedTalentc/applyInviteMaster.html",
		    	type:"post",
				async:false,
				dataType:'json',
				beforeSend :function(xmlHttp){  // beforeSend 是请求前清除缓存  ，如果没有缓存也不使用beforeSend 
				xmlHttp.setRequestHeader("If-Modified-Since","0"); 
				xmlHttp.setRequestHeader("Cache-Control","no-cache"); 
					}, 
				error: function(){  
					$.messager.alert('Warning','操作失败！','error',function(){
						return;
					});
				},  
				success : function(data) {  
				     if(data.result == 1){
				    	 layer.open({
				 			title :' ',//标题
				 			skin: 'layer-ext-myskin',//皮肤
				 	        type: 1,
				 	        area: ['540px', '373px'],//大小宽*高
				 	        shadeClose: true, //点击遮罩关闭
				 	        content: $('.applyTalent')//内容，里边是包含内容的div的class
				 	    });
				 		$('.layui-layer-title').css("border-bottom","none");
				     }else if(data.result == 0){
				    	 layer.alert("申请失败");
				     }else if(data.result == -1){
				    	 layer.alert("您已申请成为推荐达人");
				     }
				}
			});

		
	}); 
	
	//只要日期，不要时间
	template.helper("$timeFixed",function(content){
		if(content!=null && content!=" "){
			var index = content.indexOf(" ");
			return content.substring(0,index);
		} 
	})
	//金额取小数点后2位
	template.helper("$toFixed",function(content){
		if(content!=null && content!=""){
		 return parseInt(content).toFixed(2);
		}
	});
	//去掉时间后的.0
	template.helper("$toDelete",function(content){
		if(content!=null && content!=""){
			var index = content.indexOf(".");
			return content.substring(0,index);
		}
	});
	
	//推荐达人提奖
	var recommendedTalent = { 
			inviteAwardRecord :function(startDate,endDate,dateStart,start,length){
				
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey); 
				if (startDate!=undefined){
					data.startTime = encrypt.encrypt(startDate+"");
				};
				if (endDate!=undefined){
					data.endTime = encrypt.encrypt(endDate+"");
				};
				if (dateStart!=undefined){
					data.dateStart = encrypt.encrypt(dateStart+"");
				}; 
				if (start!=undefined){
					data.start = start;
				};
				if (length!=undefined){
					data.length = length;
				}; 
				var url = "recommendedTalentc/inviteAwardRecord.html"; 
				NetUtil.ajax(
						url,
						data,
						function(r){ 
						    var data = JSON.parse(r);
						 	$("#inviteAwardTop").siblings().remove();
							if(data.recordsTotal > 0) {
								var html = template("inviteAwardList",data); 
								$("#awardStatisticsUl").append(html);
								var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo       = data.pageNum;
								pager.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										recommendedTalent.inviteAwardRecord(startDate,endDate,dateStart,n);
										this.selectPage(n);
										return false;
										}
									});
							}
						 }
				);
			},
	 //	历史返现	
		inviteHistoryBack :function(startDate,endDate,month,start,length){ 
			var data = {};
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publickey); 
			if (startDate!=undefined){
				data.startTime = encrypt.encrypt(startDate+"");
			};
			if (endDate!=undefined){
				data.endTime = encrypt.encrypt(endDate+"");
			};
			if (month!=undefined){
				data.month = encrypt.encrypt(month+"");
			}; 
			if (start!=undefined){
				data.start = start;
			};
			if (length!=undefined){
				data.length = length;
			}; 
			var url = "recommendedTalentc/inviteHistoryBack.html";  
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					     var data = JSON.parse(r);  
					     $("#historyCashTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("inviteHistoryAward",data); 
							$("#historyCashBackUl").append(html);
							var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
							var totalRecords = data.recordsTotal;
							var pageNo       = data.pageNum;
							pager1.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									recommendedTalent.inviteHistoryBack(startDate,endDate,month,n);
									this.selectPage(n);
									return false;
									}
								});
						}
					 }
			);
		},
		//邀请记录
		inviteInvitation :function(startDate,endDate,name,isopenThird,order,start,length){  
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey); 
				if (startDate!=undefined){
					data.startTime = encrypt.encrypt(startDate+"");
				};
				if (endDate!=undefined){
					data.endTime = encrypt.encrypt(endDate+"");
				};
				if (name!=undefined){
					data.name = encrypt.encrypt(name+"");
				}; 
				if (isopenThird!=undefined){
					data.isopenThird = encrypt.encrypt(isopenThird+"");
				}; 
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				}; 
				if (start!=undefined){
					data.start = start;
				};
				if (length!=undefined){
					data.length = length;
				}; 
				var url = "recommendedTalentc/inviteInvitation.html";  
				NetUtil.ajax(
						url,
						data,
						function(r){ 
						    var data = JSON.parse(r);  
						    $("#inviteInvitationTop").siblings().remove();
							if(data.recordsTotal > 0) {
								var html = template("inviteInvitationAward",data); 
								$("#inviteRecordUl").append(html);
								var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo       = data.pageNum;
								pager2.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										recommendedTalent.inviteInvitation(startDate,endDate,name,isopenThird,order,n);
										this.selectPage(n);
										return false;
										}
									});
							}
					 }
				);
			},
			//借款明细
			inviteBorrowing :function(startDate,endDate,name,projectTitle,order,start,length){  
				var data = {}; 
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey); 
				if (startDate!=undefined){
					data.startTime = encrypt.encrypt(startDate+"");
				};
				if (endDate!=undefined){
					data.endTime = encrypt.encrypt(endDate+"");
				};
				if (name!=undefined){
					data.name = encrypt.encrypt(name+"");
				};  
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				}; 
				if (projectTitle!=undefined){
					data.projectTitle = encrypt.encrypt(projectTitle+"");
				}; 
				if (start!=undefined){
					data.start = start;
				};
				if (length!=undefined){
					data.length = length;
				}; 
				var url = "recommendedTalentc/inviteBorrowing.html";   
				NetUtil.ajax(
						url,
						data,
						function(r){ 
						    var data = JSON.parse(r);  
						    $("#inviteBorrowTop").siblings().remove();
							if(data.recordsTotal > 0) {
								var html = template("inviteBorrowAward",data); 
								$("#LoanDetailsUl").append(html);
								var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo       = data.pageNum;
								pager3.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										recommendedTalent.inviteBorrowing(startDate,endDate,name,projectTitle,order,n);
										this.selectPage(n);
										return false;
										}
									});
							}
					 }
				);
			},
			//投资明细
			inviteInvest :function(startDate,endDate,name,projectTitle,order,start,length){ 
				var data = {}; 
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey); 
				if (startDate!=undefined){
					data.startTime = encrypt.encrypt(startDate+"");
				};
				if (endDate!=undefined){
					data.endTime = encrypt.encrypt(endDate+"");
				};
				if (name!=undefined){
					data.name = encrypt.encrypt(name+"");
				};  
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				}; 
				if (projectTitle!=undefined){
					data.projectTitle = encrypt.encrypt(projectTitle+"");
				}; 
				if (start!=undefined){
					data.start = start;
				};
				if (length!=undefined){
					data.length = length;
				}; 
				var url = "recommendedTalentc/inviteInvest.html";   
				NetUtil.ajax(
						url,
						data,
						function(r){ 
						    var data = JSON.parse(r);  
						    $("#inviteInvestTop").siblings().remove();
							if(data.recordsTotal > 0) {
								var html = template("inviteInvestAward",data); 
								$("#investDetailsUl").append(html);
								var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo       = data.pageNum;
								pager4.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										recommendedTalent.inviteInvest(startDate,endDate,name,projectTitle,order,n);
										this.selectPage(n);
										return false;
										}
									});
							}
					 }
				);
			},
			//还本明细
			repaymentInvite :function(startDate,endDate,name,projectTitle,over,order,start,length){ 
				var data = {}; 
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey); 
				if (startDate!=undefined){
					data.startTime = encrypt.encrypt(startDate+"");
				};
				if (endDate!=undefined){
					data.endTime = encrypt.encrypt(endDate+"");
				};
				if (name!=undefined){
					data.name = encrypt.encrypt(name+"");
				};  
				if (over!=undefined){
					data.over = encrypt.encrypt(over+"");
				};  
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				}; 
				if (projectTitle!=undefined){
					data.projectTitle = encrypt.encrypt(projectTitle+"");
				}; 
				if (start!=undefined){
					data.start = start;
				};
				if (length!=undefined){
					data.length = length;
				}; 
				var url = "recommendedTalentc/repaymentInvite.html";    
				NetUtil.ajax(
						url,
						data,
						function(r){ 
						    var data = JSON.parse(r);  
						    $("#repaymentInviteTop").siblings().remove();
							if(data.recordsTotal > 0) {
								var html = template("repaymentInviteAward",data); 
								$("#historyPrincipalBackUl").append(html);
								var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo       = data.pageNum;
								pager5.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										recommendedTalent.repaymentInvite(startDate,endDate,name,projectTitle,over,order,n);
										this.selectPage(n);
										return false;
										}
									});
							}
					 }
				);
			},
			//vip购买明细
			inviteVipPay :function(startDate,endDate,name,order,start,length){ 
				var data = {}; 
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey); 
				if (startDate!=undefined){
					data.startTime = encrypt.encrypt(startDate+"");
				};
				if (endDate!=undefined){
					data.endTime = encrypt.encrypt(endDate+"");
				};
				if (name!=undefined){
					data.name = encrypt.encrypt(name+"");
				};  
				 
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				}; 
				 
				if (start!=undefined){
					data.start = start;
				};
				if (length!=undefined){
					data.length = length;
				}; 
				var url = "recommendedTalentc/inviteVipPay.html";    
				NetUtil.ajax(
						url,
						data,
						function(r){ 
						    var data = JSON.parse(r);  
						    $("#inviteVipPayTop").siblings().remove();
						    
							if(data.recordsTotal > 0) {
								var html = template("inviteVipPayAward",data); 
								$("#purchaseDetailsUl").append(html);
								var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo       = data.pageNum;
								pager6.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										recommendedTalent.inviteVipPay(startDate,endDate,name,order,n);
										this.selectPage(n);
										return false;
										}
									});
							}
					 }
				);
			}
	};
	//初始化
	recommendedTalent.inviteAwardRecord(); 
	recommendedTalent.inviteHistoryBack(); 
	recommendedTalent.inviteInvitation();
	recommendedTalent.inviteBorrowing();
	recommendedTalent.inviteInvest();
	recommendedTalent.repaymentInvite();
	recommendedTalent.inviteVipPay();
	
	//提奖统计点击搜索
	$("#searchAward").on("click",function(){
	 var startTime = $("#startDate").val() == "请选择" ? "" : $("#startDate").val(); 
     var endTime   = $("#endDate").val() == "请选择" ? "" : $("#endDate").val();  
	 var dateStart = $(".chooseTime span.active").attr("data-time"); 
	 recommendedTalent.inviteAwardRecord(startTime,endTime,dateStart);
	});
	//历史返现
	$("#searchAwardhis").on("click",function(){
     var month    =  $("#monthAward").val();   
	 var startTime = $("#startTimehis").val() == "请选择" ? "" : $("#startTimehis").val(); 
     var endTime   = $("#endTimehis").val() == "请选择" ? "" : $("#endTimehis").val();  
	 recommendedTalent.inviteHistoryBack(startTime,endTime,month);
	});
	//邀请记录
	$("#searchInvit").on("click",function(){
     var isopenThird   = $("#isopenThird").val();   
	 var name          = $("#memberName").val() == "请输入会员/用户名" ? "" : $("#memberName").val(); 
	 var startTime     = $("#startTimeInvit").val() == "请选择" ? "" : $("#startTimeInvit").val(); 
     var endTime       = $("#endDateInvit").val() == "请选择" ? "" : $("#endDateInvit").val();  
	 recommendedTalent.inviteInvitation(startTime,endTime,name,isopenThird);
	});
	//借款明细
	$("#SearchBorrow").on("click",function(){  
	 var startTime     = $("#startTimeBorrow").val() == "请选择" ? "" : $("#startTimeBorrow").val(); 
     var endTime       = $("#endTimeBorrow").val() == "请选择" ? "" : $("#endTimeBorrow").val();  
     var name          = $("#memberNameBrow").val() == "请输入会员/用户名" ? "" : $("#memberNameBrow").val(); 
     var projectTitle  = $("#projectTitleBrow").val() == "输入借款名称" ? "" : $("#projectTitleBrow").val(); 
	 recommendedTalent.inviteBorrowing(startTime,endTime,name,projectTitle);
	});
	//投资明细
	$("#SearchInvest").on("click",function(){  
	 var startTime     = $("#startTimeInvest").val() == "请选择" ? "" : $("#startTimeInvest").val(); 
     var endTime       = $("#endTimeInvest").val() == "请选择" ? "" : $("#endTimeInvest").val();  
     var name          = $("#memberNameInvest").val() == "请输入会员/用户名" ? "" : $("#memberNameInvest").val(); 
     var projectTitle  = $("#projectTitleInvest").val() == "输入借款名称" ? "" : $("#projectTitleInvest").val(); 

	 recommendedTalent.inviteInvest(startTime,endTime,name,projectTitle);
	});
	//还本明细
	$("#SearchReplay").on("click",function(){  
	 var over          = $("#isover").val();   
	 var startTime     = $("#startTimeReplay").val() == "请选择" ? "" : $("#startTimeReplay").val(); 
     var endTime       = $("#endTimeReplay").val() == "请选择" ? "" : $("#endTimeReplay").val();  
     var name          = $("#memberNameReplay").val() == "请输入会员/用户名" ? "" : $("#memberNameReplay").val(); 
     var projectTitle  = $("#projectTitleReplay").val() == "输入借款名称" ? "" : $("#projectTitleReplay").val(); 

	 recommendedTalent.repaymentInvite(startTime,endTime,name,projectTitle,over);
	});
	//Vip购买明细
	$("#SearchVIPpay").on("click",function(){  
	 var startTime     = $("#startTimeVIP").val() == "请选择" ? "" : $("#startTimeVIP").val(); 
     var endTime       = $("#endTimeVIP").val() == "请选择" ? "" : $("#endTimeVIP").val();  
     var name          = $("#memberNameVIP").val() == "请输入会员/用户名" ? "" : $("#memberNameVIP").val(); 
     recommendedTalent.inviteVipPay(startTime,endTime,name);
	});
	//提奖统计导出excel
	$("#inviteAwardexcel").on("click",function(){ 
	 var startTime = $("#startDate").val() == "请选择" ? "" : $("#startDate").val(); 
     var endTime   = $("#endDate").val() == "请选择" ? "" : $("#endDate").val(); 
	 var dateStarts = $(".chooseTime span.active").attr("data-time");
	 var encrypt = new JSEncrypt();
	 encrypt.setPublicKey(publickey);  
	 var startTime2 = encrypt.encrypt(startTime+"");
	 var endTime2   = encrypt.encrypt(endTime+"");
	 var dateStart2 = encrypt.encrypt(dateStarts+""); 
	 $("#startTimeatz").val(startTime2);
	 $("#endTimeatz").val(endTime2);
	 $("#dateStartatz").val(dateStart2);  
	 document.inviteAwardexcel.submit(); 
	// window.location.href="inviteAwardRecordexcel/inviteAwardRecordexcel.html?startTime="+startTime+"&endTime="+endTime+"&dateStart="+dateStart;
	}); 
	//历史返现导出excel
	$("#inviteAwardHisExcel").on("click",function(){ 
     var month    =  $("#monthAward").val();   
	 var startTime = $("#startTimehis").val() == "请选择" ? "" : $("#startTimehis").val(); 
     var endTime   = $("#endTimehis").val() == "请选择" ? "" : $("#endTimehis").val();  
	 var encrypt = new JSEncrypt();
	 encrypt.setPublicKey(publickey); 
	 var startTime2 = encrypt.encrypt(startTime+"");
	 var endTime2   = encrypt.encrypt(endTime+"");
	 var month2 = encrypt.encrypt(month+"");
	 $("#startTimeatzh").val(startTime2);
	 $("#endTimeatzh").val(endTime2);
	 $("#monthtzh").val(month2); 
	 document.inviteHistory.submit(); 
	// window.location.href="inviteHistoryBackExcel/inviteHistoryBackexcel.html?startTime="+startTime+"&endTime="+endTime+"&month="+month;
	}); 
	//邀请记录-注册时间-升序-降序
	$("#registerRecord em").on("click",function(){
		 var isopenThird   = $("#isopenThird").val();   
		 var name          = $("#memberName").val() == "请输入会员/用户名" ? "" : $("#memberName").val(); 
		 var startTime     = $("#startTimeInvit").val() == "请选择" ? "" : $("#startTimeInvit").val(); 
	     var endTime       = $("#endDateInvit").val() == "请选择" ? "" : $("#endDateInvit").val();  
		if ($(this).attr("class")=="iconUp"){
			 recommendedTalent.inviteInvitation(startTime,endTime,name,isopenThird,1);
		}else{
			 recommendedTalent.inviteInvitation(startTime,endTime,name,isopenThird,2);
		}
	});
	//借款明细-放款时间升序-降序
	$("#lendingTime em").on("click",function(){ 
		 var startTime     = $("#startTimeBorrow").val() == "请选择" ? "" : $("#startTimeBorrow").val(); 
	     var endTime       = $("#endTimeBorrow").val() == "请选择" ? "" : $("#endTimeBorrow").val();  
	     var name          = $("#memberNameBrow").val() == "请输入会员/用户名" ? "" : $("#memberName").val(); 
	     var projectTitle  = $("#projectTitleBrow").val() == "输入借款名称" ? "" : $("#projectTitleBrow").val();  
		if ($(this).attr("class")=="iconUp"){ 
			 recommendedTalent.inviteBorrowing(startTime,endTime,name,projectTitle,1);  
		}else{

			 recommendedTalent.inviteBorrowing(startTime,endTime,name,projectTitle,2); 
			
		}
	});
	//投资明细-预期收益时间升序-降序
	$("#expectProfitTime em").on("click",function(){ 
		 var startTime     = $("#startTimeInvest").val() == "请选择" ? "" : $("#startTimeInvest").val(); 
	     var endTime       = $("#endTimeInvest").val() == "请选择" ? "" : $("#endTimeInvest").val();  
	     var name          = $("#memberNameInvest").val() == "请输入会员/用户名" ? "" : $("#memberNameInvest").val(); 
	     var projectTitle  = $("#projectTitleInvest").val() == "输入借款名称" ? "" : $("#projectTitleInvest").val(); 

		if ($(this).attr("class")=="iconUp"){ 
			 recommendedTalent.inviteInvest(startTime,endTime,name,projectTitle,1);
		}else{ 
			 recommendedTalent.inviteInvest(startTime,endTime,name,projectTitle,2); 
		}
	});
	//还本明细-还款时间升序降序
	$("#repaymentTime em").on("click",function(){ 
		 var over          = $("#isover").val();   
		 var startTime     = $("#startTimeReplay").val() == "请选择" ? "" : $("#startTimeReplay").val(); 
	     var endTime       = $("#endTimeReplay").val() == "请选择" ? "" : $("#endTimeReplay").val();  
	     var name          = $("#memberNameReplay").val() == "请输入会员/用户名" ? "" : $("#memberNameReplay").val(); 
	     var projectTitle  = $("#projectTitleReplay").val() == "输入借款名称" ? "" : $("#projectTitleReplay").val(); 

		if ($(this).attr("class")=="iconUp"){ 
			 recommendedTalent.repaymentInvite(startTime,endTime,name,projectTitle,over,1);
		}else{ 
			 recommendedTalent.repaymentInvite(startTime,endTime,name,projectTitle,over,2);
		}
	});
});