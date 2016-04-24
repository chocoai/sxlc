/* 账户中心充值部分开始 */
function accRecharge(){
	$(".right_col").load("web/recommend/re-add/acc-recharge.jsp");
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
/**
 * 开启/关闭自动代偿
 */
function accOnOff(){
	layer.confirm('is not?', {title:'提示'}, function(index){
		  //do something
	  layer.close(index);
	});
}