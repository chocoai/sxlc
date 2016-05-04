$(function(){
	$(".TD").addClass("down");
	$(".TD1").addClass("down2");
	/*切换背景图部分开始 王延君 2016-04-01*/
	$(".myInvestmentMTitle div em").on("click",function(){
		if($(this).hasClass("iconDown")){
			$(this).removeClass("iconDown").addClass("iconUp");
		}else{
			$(this).removeClass("iconUp").addClass("iconDown");
		}
	});
	/*切换背景图部分结束 王延君 2016-04-01*/
	/*切换显示部分开始*/
	$(".recycle").css("color","#45a7e6");
	$(".recycle").css("border-bottom","2px solid #45a7e6");
	$(".myInvestmentH div").click(function(){
		var index=$(this).index();
		$(this).css("color","#45a7e6").siblings().css("color","#000");
		$(this).css("border-bottom","2px solid #45a7e6").siblings().css("border-bottom","none");
		$(".myInvestmentM ul").eq(index).show().siblings("ul").hide();
	});
	
	/*切换显示部分结束*/
	
//	2016-5-4 付晨早
	//只要日期，不要时间
	template.helper("$timeFixed",function(content){
		var index = content.indexOf(" ");
		return content.substring(0,index)
	})
	//金额取小数点后2位
	template.helper("$toFixed",function(content){
		return parseInt(content).toFixed(2);
	})
	//去掉时间后的.0
	template.helper("$toDelete",function(content){
		var index = content.indexOf(".");
		return content.substring(0,index)
	})

	var myInvestment = {
			//回收中
			recycling:function(order,cpage,pageSize){
//				(1根据剩余期数升序,-1根据剩余期数降序，2 根据下期回款时间升序，-2 根据下期回款时间降序)}
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);

				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				};
				if (cpage!=undefined){
//					console.log(cpage)
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/recycling.html";

				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.tol>0){
								var html = template("recy_list",data);
								$("#recycleUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									data.cpage = encrypt.encrypt(n+"");
										NetUtil.ajax(
												url,
												data,
												function(r){
													var data = JSON.parse(r);
													var html = template("recy_list",data);
													$("#recycleUl").append(html);
												}
											)
									}
								});
							}
						}
					)
			},
			//已结清
			settled:function(order,cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				}
				if (cpage!=undefined){
					
					data.cpage = encrypt.encrypt(cpage+"");
				}
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				}
				var url = "investmentManagement/settled.html";

				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.tol>0){
								var html = template("settled_list",data);
								$("#settledUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager1.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									data.cpage = encrypt.encrypt(n+"");
										NetUtil.ajax(
												url,
												data,
												function(r){
													var data = JSON.parse(r);
													var html = template("settled_list",data);
													$("#settledUl").append(html);
												}
											)
									}
								});
							}
						}
					)
			},
			bidding:function(order,cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				data.statu = encrypt.encrypt("0"+"");
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				};
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/bidding.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
//							console.log(data);
							if (data.tol>0){
								var html = template("biding_list",data);
								$("#bidingUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager2.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									data.cpage = encrypt.encrypt(n+"");
										NetUtil.ajax(
												url,
												data,
												function(r){
													var data = JSON.parse(r);
													var html = template("biding_list",data);
													$("#bidingUl").append(html);
												}
											)
									}
								});
							}
						}
					)
			},
			bidders:function(order,cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				data.statu = encrypt.encrypt("1"+"");
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				};
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/bidding.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
//							console.log(data);
							if (data.tol>0){
								var html = template("bidMissed_list",data);
								$("#bidMissedUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager3.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									data.cpage = encrypt.encrypt(n+"");
										NetUtil.ajax(
												url,
												data,
												function(r){
													var data = JSON.parse(r);
													var html = template("bidMissed_list",data);
													$("#bidMissedUl").append(html);
												}
											)
									}
								});
							}
						}
					)
			},
			bid_success:function(order,cpage,pageSize){
				var data = {};
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				data.statu = encrypt.encrypt("2"+"");
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
				};
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var url = "investmentManagement/bidding.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
//							console.log(data);
							if (data.tol>0){
								var html = template("bidEnd_list",data);
								$("#bidEndUl").append(html);
								var totalPage = Math.ceil(data.tol/data.pageSize);
								var totalRecords = data.tol;
								var pageNo = data.cpage;
								pager4.generPageHtml({
								pno : pageNo,
								//总页码
								total : totalPage,
								//总数据条数
								totalRecords : totalRecords,
								mode : 'click',//默认值是link，可选link或者click
								click : function(n) {
									data.cpage = encrypt.encrypt(n+"");
										NetUtil.ajax(
												url,
												data,
												function(r){
													var data = JSON.parse(r);
													var html = template("bidEnd_list",data);
													$("#bidEndUl").append(html);
												}
											)
									}
								});
							}
						}
					)
			}
	}
	//初始化
	myInvestment.recycling();
	myInvestment.settled();
	myInvestment.bidding();
	myInvestment.bidders();
	myInvestment.bid_success();
	
	//回收中 升序 降序。。。。(1根据剩余期数升序,-1根据剩余期数降序，2 根据下期回款时间升序，-2 根据下期回款时间降序)}
	$("#remainingNum em").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.recycling(1);
		}else{
			myInvestment.recycling(-1);
		}
	});
	$("#nextPaymentT em").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.recycling(2);
		}else{
			myInvestment.recycling(-2);
		}
	});
	
	//已结清。。。1根据投资金额升序,-1根据投资金额降序，2 根据收益总额升序，
	//-2 根据收益总额降序 3根据放款时间升序,-3根据放款时间降序，4 根据结清时间时间升序，-4根据结清时间降序
	$("#settled_investNum").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.settled(1);
		}else{
			myInvestment.settled(-1);
		}
	});
	$("#settled_totalRevenue").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.settled(2);
		}else{
			myInvestment.settled(-2);
		}
	});
	$("#settled_lendingTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.settled(3);
		}else{
			myInvestment.settled(-3);
		}
	});
	$("#settled_closingTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.settled(4);
		}else{
			myInvestment.settled(-4);
		}
	});
	//1根据投资金额升序,-1 根据投资金额降序，
	//2根据投资进度升序，-2 根据投资进度降序 
	//3根据投标时间升序,-3根据投标时间降序，
	//4 根据结束时间升序，-4根据结束时间降序 ，5 根据流标时间升序，-5 根据流标时间降序 
	
	//投标中
	$("#biding_investNum").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bidding(1);
		}else{
			myInvestment.bidding(-1);
		}
	});
	$("#biding_investmentProgress").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bidding(2);
		}else{
			myInvestment.bidding(-2);
		}
	});
	$("#biding_biddingTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bidding(3);
		}else{
			myInvestment.bidding(-3);
		}
	});
	
	//已流标
	$("#bidMissed_investNum").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bidders(1);
		}else{
			myInvestment.bidders(-1);
		}
	});
	$("#bidMissed_biddingTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bidders(1);
		}else{
			myInvestment.bidders(-1);
		}
	});
	$("#bidMissed_bidMissedTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bidders(5);
		}else{
			myInvestment.bidders(-5);
		}
	});
	
	//投标结束
	$("#bidEnd_investNum").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bid_success(1);
		}else{
			myInvestment.bid_success(-1);
		}
	});
	$("#bidEnd_biddingTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bid_success(1);
		}else{
			myInvestment.bid_success(-1);
		}
	});
	$("#bidEnd_biddingEndTime").on("click",function(){
		if ($(this).attr("class")=="iconUp"){
			myInvestment.bid_success(4);
		}else{
			myInvestment.bid_success(-4);
		}
	});
});
