/* 账户中心充值部分开始 */
/*function accRecharge(){
	$(".right_col").load("web/recommend/re-add/acc-recharge.jsp");
}*/
function accRecharge(title,page,type){
	layer.open({
		type: 2,
		area: ['500px', '350px'], //高宽
		title:title,
		/*maxmin: true,*/
		content:page,//DOM或内容
	});
}
/* 账户中心充值部分结束 */
/* 账户中心提现部分开始 */
function accWithdraw(){
	$(".right_col").load("web/recommend/re-add/acc-withdraw.jsp");
}
/* 账户中心提现部分结束 */

/* 查看担保费收取记录部分开始 */
function accCheckRecords(){
	$(".right_col").load("web/recommend/re-add/acc-checkrecords.jsp");
}
/* 查看担保费收取记录部分结束 */
/* 担保借款金额范围开始 */
function loanAmount(){
	layer.open({
		type: 1,
		area: ['455px', '230px'], //高宽
		title: "担保借款金额范围",
		maxmin: true,
		content: $("#loanamount"),//DOM或内容
	});
}
/* 担保借款金额范围结束 */
/* 担保产品类型开始 */
function productType(){
	layer.open({
		type: 1,
		area: ['455px', '230px'], //高宽
		title: "担保产品类型",
		maxmin: true,
		content: $("#producttype"),//DOM或内容
	});
}
/* 担保产品类型结束 */
/**
 * 开启/关闭自动代偿
 */
function accOnOff(){
	layer.confirm('is not?', {title:'提示'}, function(index){
		  //do something
	  layer.close(index);
	});
}