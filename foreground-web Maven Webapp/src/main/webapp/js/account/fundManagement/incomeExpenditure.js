
/* 李丽梅 */
/* 2016-4-1 */
/* 收支明细-交易记录-切换 */
function loadMoreInfo(){
	$(".awardTabRegister").each(function() {
		$(this).click(function() {
			if ($(this).parent().find(".iEDTrecordInfo").is(":hidden")) {
				$(this).parent().find(".iEDTrecordInfo").show();
				$(this).parent().siblings().find(".iEDTrecordInfo").hide();
			} else {
				$(this).parent().find(".iEDTrecordInfo").hide();
			}
			if ($(this).hasClass("awardTabDow")) {
				$(this).removeClass("awardTabDow");
			} else {
				$(this).addClass("awardTabDow");
				$(this).parent().siblings().find(".awardTabRegister").removeClass("awardTabDow");
			}
		});
	});
}
/* 日期选择控件（比如今天,一周时间 ,6个月选项） */
/* 李丽梅 */
/* 2016-4-8 */

$(function() {
	//切换排序
	//交易记录
	$(".awardTableHead div em").on("click",function(){
		if($(this).hasClass("btnDown")){
			$(this).removeClass("btnDown").addClass("btnUp");
		}else{
			$(this).removeClass("btnUp").addClass("btnDown");
		}
	});
	//充值
	$(".awardTableHeada div em").on("click",function(){
		if($(this).hasClass("btnDown")){
			$(this).removeClass("btnDown").addClass("btnUp");
		}else{
			$(this).removeClass("btnUp").addClass("btnDown");
		}
	});
	//充值
	$(".awardTableHeada1 div em").on("click",function(){
		if($(this).hasClass("btnDown")){
			$(this).removeClass("btnDown").addClass("btnUp");
		}else{
			$(this).removeClass("btnUp").addClass("btnDown");
		}
	});
	$(".iEDDiv em").on("click",function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
		} else {
			$(this).addClass("active").siblings(".iEDDiv em")
					.removeClass("active");
		}
	});
	selectAllDealInfoAndFree();
});
/* 点击 充值 跳转到 我要充值 */
/* 李丽梅 */
/* 2016-4-12 */
$(function() {
	$(".iEDContentHeadC").click(function() {
		window.location.href = "recharge.html";
	});
});
$(function(){
	var incomeExpenditure = {
			/**
			 * 查询会员交易记录
			 */
			allTradingRecords : function(order,cpage,pageSize){
				//order
				//(  1交易金额 降序,-1交易金额 升序，2 冻结金额 降序，-2 冻结金额 升序， 3待收本金 降序，-3 待收本金升序
				//   4待收利息 降序,-4待收利息 升序，5 账户可用金额  降序，-5 账户可用金额 升序， 6待还本金 降序，-6 待还本金 升序
				//  7待还利息 降序,-7待还利息 升序，8 待还逾期利息  降序，-8待还逾期利息 升序， 9待还逾期罚息 降序， -9 待还逾期罚息 升序
				//  10总金额 降序,-10 总金额 升序)
				//cpage 当前页数
				//pageSize 每页条数
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
					var needOrder = order;
				}else{
					var needOrder = "";
				}
				
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				
				var tradeTypeId = $(".tradeTypeId").attr("value");
				if(tradeTypeId!=undefined){
					data.tradeTypeId=encrypt.encrypt(tradeTypeId+"");
				}
				var recorddays = $(".active").attr("value");
				if(recorddays!=undefined){
					data.recorddays=encrypt.encrypt(recorddays+"");
				}
				var startTime = $("#startTime1").val();
				if(startTime!=undefined && startTime!="请选择"  && startTime!=""){
					data.startTime=encrypt.encrypt(startTime+"");
				}
				var endTime1 = $("#startTime1").val();
				if(endTime1!=undefined && endTime1!="请选择"  && endTime1!=""){
					data.endTime=encrypt.encrypt(endTime1+"");
				}
				
				var url = "capitalDetail/selectMemberTradingRecords.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("all_list",data);
								$("#all_list_top").siblings().remove();
								$("#all_list_ul").append(html);
								
								loadMoreInfo();
								//格式化金额
								$(".moneyFormat").each(function(){
									var s = $(this).text();
									var str = parseFloat(s);
									var n = $(this).format(str);
									$(this).text(n);
								});
								var totalPage = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo = data.pageNum;
								$("#pager").html("");
								pager.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										incomeExpenditure.allTradingRecords(needOrder,n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				)
			},
			//充值记录
			selectRechargeList:function(order,cpage,pageSize){
				//order
				//cpage 当前页数
				//pageSize 每页条数
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
					var needOrder = order;
				}else{
					var needOrder = "";
				}
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var startTime = $("#startTime2").val();
				if(startTime!=undefined && startTime!="请选择" && startTime!=""){
					data.startTime=encrypt.encrypt(startTime+"");
				}
				var endTime = $("#endTime2").val();
				if(endTime!=undefined && endTime!="请选择" && endTime!=""){
					data.endTime=encrypt.encrypt(endTime+"");
				}
				var thirdMerBillno = $("#thirdMerBillno").val();
				if(thirdMerBillno!=undefined && thirdMerBillno!=""&&thirdMerBillno!="输入交易流水号"){
					data.thirdMerBillno=encrypt.encrypt(thirdMerBillno+"");
				}
				var rechargeStatu = $("#rechargeStatu").attr("value");
				if(rechargeStatu!=undefined){
					data.statu = encrypt.encrypt(rechargeStatu+"");
				}
				var url = "capitalDetail/selectRechargeList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("recharge_list",data);
								$("#recharge_top").siblings().remove();
								$("#recharge_ul").append(html);
								//格式化金额
								$(".moneyFormat").each(function(){
									var s = $(this).text();
									var str = parseFloat(s);
									var n = $(this).format(str);
									$(this).text(n);
								});
								var totalPage = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo = data.pageNum;
								$("#pager1").html("");
								pager1.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										incomeExpenditure.selectRechargeList(needOrder,n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				)
			},
			//提现记录
			selectWithdrawalList:function(order,cpage,pageSize){
				//order
				//cpage 当前页数
				//pageSize 每页条数
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				if (order!=undefined){
					data.order = encrypt.encrypt(order+"");
					var needOrder = order;
				}else{
					var needOrder = "";
				}
				if (cpage!=undefined){
					data.cpage = encrypt.encrypt(cpage+"");
				};
				if (pageSize!=undefined){
					data.pageSize = encrypt.encrypt(pageSize+"");
				};
				var startTime = $("#startTime3").val();
				if(startTime!=undefined && startTime!="请选择" && startTime!=""){
					data.startTime=encrypt.encrypt(startTime+"");
				}
				var endTime = $("#endTime3").val();
				if(endTime!=undefined && endTime!="请选择" && endTime!=""){
					data.endTime=encrypt.encrypt(endTime+"");
				}
				var url = "capitalDetail/selectWithdrawalList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("recharge_list",data);
								$("#withdraw_top").siblings().remove();
								$("#withdraw_ul").append(html);
								//格式化金额
								$(".moneyFormat").each(function(){
									var s = $(this).text();
									var str = parseFloat(s);
									var n = $(this).format(str);
									$(this).text(n);
								});
								var totalPage = Math.ceil(data.recordsTotal/data.pageSize);
								var totalRecords = data.recordsTotal;
								var pageNo = data.pageNum;
								$("#pager2").html("");
								pager2.generPageHtml({
									pno : pageNo,
									//总页码
									total : totalPage,
									//总数据条数
									totalRecords : totalRecords,
									mode : 'click',//默认值是link，可选link或者click
									click : function(n) {
										incomeExpenditure.selectWithdrawalList(needOrder,n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				)
			}
	}
	incomeExpenditure.allTradingRecords();
	/**
	 * 3个标签切换效果
	 */
	$(".allRecord").on("click",function(){
		incomeExpenditure.allTradingRecords();
	});
	$(".rechargeRecord").on("click",function(){
		incomeExpenditure.selectRechargeList();
	});
	$(".withdrawRecord").on("click",function(){
		incomeExpenditure.selectWithdrawalList();
	});
	//搜索按钮
	$("#allSearch").click(function(){
		incomeExpenditure.allTradingRecords();
	});
	$("#rechargeSearch").click(function(){
		incomeExpenditure.selectRechargeList();
	});
	$("#withdrawalSearch").click(function(){
		incomeExpenditure.selectWithdrawalList();
	});
	//排序按钮
	/**************************交易记录********************/
	//交易金额
	$(".awardTableHead3 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(1);
		}else{
			incomeExpenditure.allTradingRecords(-1);
		}
	});
	//总金额
	$(".awardTableHead4 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(10);
		}else{
			incomeExpenditure.allTradingRecords(-10);
		}
	});
	//冻结金额
	$(".awardTableHead5 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(2);
		}else{
			incomeExpenditure.allTradingRecords(-2);
		}
	});
	//待收本金
	$(".awardTableHead6 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(3);
		}else{
			incomeExpenditure.allTradingRecords(-3);
		}
	});
	//待收利息
	$(".awardTableHead7 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(4);
		}else{
			incomeExpenditure.allTradingRecords(-5);
		}
	});
	//可用余额
	$(".awardTableHead8 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(5);
		}else{
			incomeExpenditure.allTradingRecords(-5);
		}
	});
	//待还本金
	$(".awardTableHead9 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(6);
		}else{
			incomeExpenditure.allTradingRecords(-6);
		}
	});
	//待还利息
	$(".awardTableHead10 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(7);
		}else{
			incomeExpenditure.allTradingRecords(-7);
		}
	});
	//待还逾期利息
	$(".awardTableHead11 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.allTradingRecords(8);
		}else{
			incomeExpenditure.allTradingRecords(-8);
		}
	});
	
	/*******************充值记录排序******************************************/
	//充值金额
	$(".awardTableCu1 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.selectRechargeList(1);
		}else{
			incomeExpenditure.selectRechargeList(-1);
		}
	});
	//交易时间
	$(".awardTableCu2 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.selectRechargeList(2);
		}else{
			incomeExpenditure.selectRechargeList(-2);
		}
	});
	//实际到账金额
	$(".awardTableCu5 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.selectRechargeList(3);
		}else{
			incomeExpenditure.selectRechargeList(-3);
		}
	});
	
	/********************提现记录**********************************/
	//提现金额
	$(".awardTabCuA1 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.selectWithdrawalList(1);
		}else{
			incomeExpenditure.selectWithdrawalList(-1);
		}
	});
	//交易时间
	$(".awardTabCuA2 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.selectWithdrawalList(1);
		}else{
			incomeExpenditure.selectWithdrawalList(-1);
		}
	});
	//实际到账金额
	$(".awardTabCuA6 em").on("click",function(){
		if ($(this).attr("class")=="btnUp"){
			//降序
			incomeExpenditure.selectWithdrawalList(3);
		}else{
			incomeExpenditure.selectWithdrawalList(-3);
		}
	});
	
})
$(function() {
	$(".TC").addClass("down");
	$(".TC3").addClass("down2");
});

$(function() {
	/* 李丽梅 */
	/* 2016-4-1 */
	/* 收支明细-充值记录、提现记录、交易记录-tab切换 */
	$(".iEDHead li").each(
			function(index) {
				var liNode = $(this);
				$(this).click(
						function() {
							$(".iEDtabContent .iEDContent").removeClass("iEDcontentActive");
							$(".iEDHead li").removeClass("iEDHeadIng");
							$(".iEDtabContent .iEDContent").eq(index).addClass("iEDcontentActive");
							liNode.addClass("iEDHeadIng");
						});
			});
});
function selectAllDealInfoAndFree(){
	$.ajax({
		url:"capitalDetail/selectAllDealInfoAndFree.html",
		dataType:"json",
		type:"get",
		success : function(data){
			$("#rechargeFee").html(data.rechargeFee);
			$("#rechargeMoney").html(data.rechargeMoney);
			$("#withdrawalFee").html(data.withdrawalFee);
			$("#withdrawalMoney").html(data.withdrawalMoney);
			//格式化金额
			$(".moneyFormat2").each(function(){
				var s = $(this).text();
				var str = parseFloat(s);
				var n = $(this).format(str);
				$(this).text(n);
			});
		},
		error : function(){
			layer.alert("网络错误，请重试");
		}
	});
}

