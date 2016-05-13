$(function(){
	$(".TC").addClass("down");
	$(".TC4").addClass("down2");
});
/*李丽梅*/
/*资金管理-我的红包*/
/*2016-3-31*/
/*我的红包、我的电子劵方法*/
$(function(){
	/*李丽梅*/
	/*我的红包、电子劵*/
	$(".awardHead li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".tabContent .awardContent").removeClass("contentActive");
			$(".awardHead li").removeClass("awardIng");
			$(".tabContent .awardContent").eq(index).addClass("contentActive");
			liNode.addClass("awardIng");
		});
	});
	
	/*李丽梅*/
	/*代金劵获取、记录修改*/
	$(".awardBtn li").each(function(index){
		var liNode =$(this);
		$(this).click(function(){
			$(".awardtabContent .awardContenta").removeClass("contentActivea");
			$(".awardBtn li").removeClass("awardBtnIng");
			$(".awardtabContent .awardContenta").eq(index).addClass("contentActivea");
			liNode.addClass("awardBtnIng");
		});
	});
	loadMyRedpackage();
	
	/**
	 * 红包
	 */
	var award = {
			loadRedPackageList:function(order,cpage,pageSize){
				//order
				//cpage 当前页数
				//pageSize 每页条数
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				var url = "rewards/loadRedPackageList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("redList",data);
								$("#redList_top").siblings().remove();
								$("#redList_ul").append(html);
								
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
										award.loadRedPackageList(needOrder,n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				)
			},
			//查询代金劵总额
			loadMyVouchers:function(){
				var data={};
				var url = "rewards/loadMyVouchers.html";
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r).data;
							
						}
				)
			},
			//已经获取的代金劵列表
			loadVouchersList:function(order,cpage,pageSize){
				//order
				//cpage 当前页数
				//pageSize 每页条数
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				var url = "rewards/loadVouchersList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("vouchersList",data);
								$("#useVouchersList_top").siblings().remove();
								$("#useVouchersList_ul").append(html);
								
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
										award.loadVouchersList(needOrder,n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				)
			},
			//已经使用的代金劵列表
			loadUseVouchersList:function(order,cpage,pageSize){
				//order
				//cpage 当前页数
				//pageSize 每页条数
				var data = {};
				data.start=cpage;
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(publickey);
				
				var url = "rewards/loadUseVouchersList.html";
				
				NetUtil.ajax(
						url,
						data,
						function(r){
							var data = JSON.parse(r);
							if (data.totalPage>0){
								var html = template("useVouchersList",data);
								$("#useVouchersList_top").siblings().remove();
								$("#useVouchersList_ul").append(html);
								
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
										award.loadUseVouchersList(needOrder,n);
										this.selectPage(n);
										return false;
									}
								});
							}
						}
				)
			}
	}
	award.loadRedPackageList();
	award.loadMyVouchers();
	$(".awardHeadLi1").on("click",function(){
		award.loadRedPackageList();
	});
	$(".awardHeadLi2").on("click",function(){
		if($(".awardBtnIng").hasClass("useVoucher")){
			award.loadUseVouchersList();
		}else{
			award.loadVouchersList();
		}
	});
	$(".getVoucher").on("click",function(){
		award.loadVouchersList();
	});
	$(".useVoucher").on("click",function(){
		award.loadUseVouchersList();
	});
});
function loadMyRedpackage(){
	var data={};
	var url = "rewards/loadMyRedpackage.html";
	NetUtil.ajax(
		url,
		data,
		function(message){
			var r = JSON.parse(message).data;
			$("#sRedPackageSum").html(r.sRedPackageSum);
			$("#sExpiredSum").html(r.sExpiredSum);
			$("#sUseRedPackageSum").html(r.sUseRedPackageSum);
			$("#sCanUseRedPackageSum").html(r.sCanUseRedPackageSum);
			$(".moneyFormat2").each(function(){
				var s = $(this).text();
				var str = parseFloat(s);
				var n = $(this).format(str);
				$(this).text(n);
			});
		}
	)
}