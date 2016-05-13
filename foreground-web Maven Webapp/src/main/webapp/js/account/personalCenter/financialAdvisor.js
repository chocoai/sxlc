$(function(){
	$(".TB").addClass("down");
	$(".TB12").addClass("down2");
	/*日期选择部分开始 王延君 2016-04-05*/
	$(".chooseTime>span").click(function(){
		$(this).addClass("active").css("color","#72c0f3").siblings("span").removeClass("active").css("color","#444444");
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
	
	
	//只要日期，不要时间
	template.helper("$timeFixed",function(content){ 
		if(content != null && content != '' && index != -1){
			var index = content.indexOf(" ");  
			return content.substring(0,index);
		}
	});
	//金额取小数点后2位
	template.helper("$toFixed",function(content){
		return parseInt(content).toFixed(2);
	});
	//去掉时间后的.0
	template.helper("$toDelete",function(content){
		var index = content.indexOf(".");
		return content.substring(0,index);
	});
	
	
	//chenzhen 0509
	//理财顾问
	var data = {};//数据
	var encrypt = new JSEncrypt();//加密
	encrypt.setPublicKey(publickey);
	var noData = '<li class="data-item noData">暂无数据</li>';
	
	var financialAdvisor = {
		//理财顾问提奖记录(开始时间，结束时间，快捷时间范围，数据开始，单页条数)
		financialAwardRecord:function(startDate,endDate,dateStart,start,length){
			data = {};//切换置空
			//判断参数，加密处理
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
			
			//访问链接：提奖统计
			var url = "financialAdvisortc/financialAwardRecord.html";
			
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					    var data = JSON.parse(r);
					    ////console.log("测试返回：")
					    ////console.log(data);
					    //*+Top
					 	$("#financialAwardTop").siblings().remove();//除标题外的内容移除
						if(data.recordsTotal > 0) {
							var html = template("financialAwardList",data);//模板生成 
							$("#awardStatisticsUl").append(html);//页面赋值
							var totalPage    = Math.ceil(data.recordsTotal/data.pageSize);
							var totalRecords = data.recordsTotal;
							var pageNo       = data.pageNum;
							pager.generPageHtml({//调用分页
								pno : pageNo,				//当前页
								total : totalPage,			//总页码
								totalRecords : totalRecords,//总数据条数
								mode : 'click',				//默认值是link，可选link或者click
								click : function(n) {
									financialAdvisor.financialAwardRecord(startDate,endDate,dateStart,n);
									this.selectPage(n);//点击重复调用
									return false;
								}
							});
						}else{
							$("#awardStatisticsUl").append(noData);//页面赋值
						}
					}
			);
		},
		
		//历史返现
		financialHistoryBack:function(startDate,endDate,month,start,length){
			data = {};//切换置空
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
			//访问链接：历史返现
			var url = "financialAdvisortc/financialHistoryBack.html";  
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					     var data = JSON.parse(r);
					     $("#historyCashTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("historyCashList",data); 
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
									financialAdvisor.financialHistoryBack(startDate,endDate,month,n);
									this.selectPage(n);
									return false;
									}
								});
						}else{
							$("#historyCashBackUl").append(noData);//页面赋值
						}
					 }
			);
		},
		
		//邀请记录
		financialInvitation:function(startDate,endDate,name,isopenThird,order,start,length){
			var data = {};
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
			var url = "financialAdvisortc/financialInvitation.html"; 
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					    var data = JSON.parse(r);
					    //console.log(data);
					    $("#financialInvitationTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("financialInvitationList",data); 
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
									financialAdvisor.financialInvitation(startDate,endDate,name,isopenThird,order,n);
									this.selectPage(n);
									return false;
									}
								});
						}else{
							$("#inviteRecordUl").append(noData);
						}
				 }
			);
		},
		
		//借款明细
		financialBorrowing :function(startDate,endDate,name,projectTitle,order,start,length){ 
			var data = {}; 
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
			var url = "financialAdvisortc/financialBorrowing.html";   
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					    var data = JSON.parse(r);
					    $("#financialBorrowingTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("financialBorrowingList",data); 
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
									financialAdvisor.financialBorrowing(startDate,endDate,name,projectTitle,order,n);
									this.selectPage(n);
									return false;
									}
								});
						}else{
							$("#LoanDetailsUl").append(noData);
						}
				 }
			);
		},
		
		//投资明细
		financialInvest :function(startDate,endDate,name,projectTitle,order,start,length){ 
			var data = {}; 
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
			var url = "financialAdvisortc/financialInvest.html";
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					    var data = JSON.parse(r);
					    $("#financialInvestTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("financialInvestList",data); 
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
									financialAdvisor.financialInvest(startDate,endDate,name,projectTitle,order,n);
									this.selectPage(n);
									return false;
									}
								});
						}else{
							$("#investDetailsUl").append(noData);
						}
				 }
			);
		},
		
		//还本明细
		repaymentfinancial :function(startDate,endDate,name,projectTitle,over,order,start,length){ 
			var data = {}; 
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
			var url = "financialAdvisortc/repaymentfinancial.html";
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					    var data = JSON.parse(r);  
					    $("#repaymentfinancialTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("repaymentfinancialList",data); 
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
									financialAdvisor.repaymentfinancial(startDate,endDate,name,projectTitle,over,order,n);
									this.selectPage(n);
									return false;
									}
								});
						}else{
							$("#historyPrincipalBackUl").append(noData);
						}
				 }
			);
		},
		
		//VIP购买明细
		financialVipPay :function(startDate,endDate,name,order,start,length){ 
			var data = {}; 
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
			var url = "financialAdvisortc/financialVipPay.html";    
			NetUtil.ajax(
					url,
					data,
					function(r){ 
					    var data = JSON.parse(r);  
					    $("#financialVipPayTop").siblings().remove();
						if(data.recordsTotal > 0) {
							var html = template("financialVipPayList",data); 
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
									financialAdvisor.financialVipPay(startDate,endDate,name,order,n);
									this.selectPage(n);
									return false;
									}
								});
						}else{
							$("#purchaseDetailsUl").append(noData);
						}
				 }
			);
		}
	};
	
	
	//首次加载-初始化
	financialAdvisor.financialAwardRecord();
	
	//点击切换查询
	$(".awardStatistics").click(function(){
		financialAdvisor.financialAwardRecord();
	});
	$(".historyCashBack").click(function(){
		financialAdvisor.financialHistoryBack();
	});
	$(".inviteRecord").click(function(){
		financialAdvisor.financialInvitation();
	});
	$(".LoanDetails").click(function(){
		financialAdvisor.financialBorrowing();
	});
	$(".investDetails").click(function(){
		financialAdvisor.financialInvest();
	});
	$(".historyPrincipalBack").click(function(){
		financialAdvisor.repaymentfinancial();
	});
	$(".purchaseDetails").click(function(){
		financialAdvisor.financialVipPay();
	});
	
	
	//=========条件查询s========
	//提奖统计
	$("#searchAward").on("click",function(){
		var startTime = $("#startDate").val() == "请选择" ? "" : $("#startDate").val();
		var endTime   = $("#endDate").val() == "请选择" ? "" : $("#endDate").val(); 
		var dateStart = $(".chooseTime span.active").attr("data-time") || "";
		financialAdvisor.financialAwardRecord(startTime,endTime,dateStart);
	});
	
	//历史返现
	$("#searchAwardhis").on("click",function(){
		var month     =  $("#monthAward").val(); 
		var startTime = $("#startTimehis").val() == "请选择" ? "" : $("#startTimehis").val();
		var endTime   = $("#endTimehis").val() == "请选择" ? "" : $("#endTimehis").val();
		financialAdvisor.financialHistoryBack(startTime,endTime,month);
	});
	
	//邀请记录
	$("#searchInvit").on("click",function(){
		var isopenThird   = $("#isopenThird").val(); 
		var startTime     = $("#startTimeInvit").val() == "请选择" ? "" : $("#startTimeInvit").val();
		var endTime       = $("#endDateInvit").val() == "请选择" ? "" : $("#endDateInvit").val();
		var name          = $("#memberName").val();
		financialAdvisor.financialInvitation(startDate,endDate,name,isopenThird);
	});
	
	//借款明细
	$("#SearchBorrow").on("click",function(){ 
	 var startTime     = $("#startTimeBorrow").val() == "请选择" ? "" : $("#startTimeBorrow").val();
	 var endTime       = $("#endTimeBorrow").val() == "请选择" ? "" : $("#endTimeBorrow").val();  
	 var name          = $("#memberNameBrow").val(); 
	 var projectTitle  = $("#projectTitleBrow").val(); 
	 financialAdvisor.financialBorrowing(startTime,endTime,name,projectTitle);
	});
	
	//投资明细
	$("#SearchInvest").on("click",function(){ 
	 var startTime     = $("#startTimeInvest").val() == "请选择" ? "" : $("#startTimeInvest").val();
	 var endTime       = $("#endTimeInvest").val() == "请选择" ? "" : $("#endTimeInvest").val();  
	 var name          = $("#memberNameInvest").val(); 
	 var projectTitle  = $("#projectTitleInvest").val(); 
	 financialAdvisor.financialInvest(startTime,endTime,name,projectTitle);
	});
	
	//还本明细
	$("#SearchReplay").on("click",function(){ 
	 var startTime     = $("#startTimeReplay").val() == "请选择" ? "" : $("#startTimeReplay").val();
	 var endTime       = $("#endTimeReplay").val() == "请选择" ? "" : $("#endTimeReplay").val();  
	 var name          = $("#memberNameReplay").val(); 
	 var over          = $("#isover").val(); 
	 var projectTitle  = $("#projectTitleReplay").val(); 
	 financialAdvisor.repaymentfinancial(startTime,endTime,name,projectTitle,over);
	});
	
	//VIP购买明细
	$("#SearchVIPpay").on("click",function(){ 
	 var startTime     = $("#startTimeVIP").val() == "请选择" ? "" : $("#startTimeVIP").val();
	 var endTime       = $("#endTimeVIP").val() == "请选择" ? "" : $("#endTimeVIP").val();  
	 var name          = $("#memberNameVIP").val();  
	 financialAdvisor.financialVipPay(startTime,endTime,name);
	});
	
	//=========条件查询e========
	
	
	
	//=======数据导出s=======
	//提奖统计
	$("#financialAwardexcel").on("click",function(){
		var startTime = $("#startDate").val() == "请选择" ? "" : $("#startDate").val();
		var endTime   = $("#endDate").val() == "请选择" ? "" : $("#endDate").val(); 
		var dateStarts = $(".chooseTime span.active").attr("data-time");
		var startTime2 = encrypt.encrypt(startTime+"");
		var endTime2   = encrypt.encrypt(endTime+"");
		var dateStart2 = encrypt.encrypt(dateStarts+""); 
		 $("#startTimeatz").val(startTime2);
	     $("#endTimeatz").val(endTime2);
	     $("#dateStartatz").val(dateStart2);  
	     document.financialAwardexcel.submit(); 
	 	});
	
	$("#financialAwardHisExcel").on("click",function(){ 
		var month    =  $("#monthAward").val();   
		var startTime = $("#startTimehis").val() == "请选择" ? "" : $("#startTimehis").val(); 
		var endTime   = $("#endTimehis").val() == "请选择" ? "" : $("#endTimehis").val();  
		var startTime2 = encrypt.encrypt(startTime+"");
		var endTime2   = encrypt.encrypt(startTime+"");
		var month2 = encrypt.encrypt(month+""); 
		$("#startTimeatzh").val(startTime2);
	    $("#endTimeatzh").val(endTime2);
	    $("#monthtzh").val(month2); 
	     document.financialHistory.submit(); 
	});
	//=======数据导出e=======
	
});

