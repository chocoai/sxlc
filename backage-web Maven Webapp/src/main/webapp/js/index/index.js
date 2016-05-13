/** 首页 **/
$(function () {
	
	/**
	 * 运营项目统计
	 */
	$.ajax({
		type : 'post',
		url : appPath + "/index/statistics.do",
		success : function (msg) {
			$("#notDeal").text(msg.notDeal);
			$("#checking").text(msg.checking);
			$("#investing").text(msg.investing);
			$("#willhold").text(msg.willhold);
			$("#replaying").text(msg.replaying);
			$("#overReplay").text(msg.overReplay);
			$("#Settled").text(msg.Settled);
			
		}
	});
	
	/**
	 * 平台收益统计
	 */
	$.ajax({
		type : 'post',
		url : appPath + "/index/plat.do",
		success : function (msg) {
			$("#rMngFeeAmounts").text(msg.rMngFeeAmounts);
			$("#investMngFeeAmounts").text(msg.investMngFeeAmounts);
			$("#rRiskMarginFees").text(msg.rRiskMarginFees);
			$("#oRiskMarginFees").text(msg.oRiskMarginFees);
			$("#rRiskMarginFees").text(msg.rRiskMarginFees);
			$("#rechargeFees").text(msg.rechargeFees);
			$("#pRechargeFees").text(msg.pRechargeFees);
			$("#withdrawalFees").text(msg.withdrawalFees);
			$("#pwidthdrawFees").text(msg.pwidthdrawFees);
			$("#pgetwidthdrawFees").text(msg.pgetwidthdrawFees);
			$("#rTransFeeAmounts").text(msg.rTransFeeAmounts);
			$("#roverFeeAmounts").text(msg.roverFeeAmounts);
			$("#rcompenAmounts").text(msg.rcompenAmounts);
			$("#rcompenRepayAmounts").text(msg.rcompenRepayAmounts);
			$("#financialAdvisorAwards").text(msg.financialAdvisorAwards);
			$("#inviteMasterAwards").text(msg.inviteMasterAwards);
			
		}
	});
	
	/**
	 * 累计交易统计
	 */
	$.ajax({
		type : 'post',
		url : appPath + "/index/transaction.do",
		success : function (msg) {
			$("#cumulative").text(msg.cumulative);
			$("#successLoan").text(msg.successLoan);
			$("#notRepayPrincipals").text(msg.notRepayPrincipals);
			$("#notRepayTotals").text(msg.notRepayTotals);
			$("#successRepay").text(msg.successRepay);
			$("#sumInvestDs").text(msg.sumInvestDs);
			$("#sumInvestWs").text(msg.sumInvestWs);
			$("#sumInvestMs").text(msg.sumInvestMs);
		}
	});
	
	/**
	 * 平台收支统计
	 */
	$.ajax({
		type : 'post',
		url : appPath + "/index/platMoney.do",
		success : function (msg) {
			$("#stotalRedpackets").text(msg.stotalRedpackets);
			$("#saffairAccount").text(msg.saffairAccount);
			$("#sgetTotalRedpackets").text(msg.sgetTotalRedpackets);
			$("#suseRedpackets").text(msg.suseRedpackets);
			$("#snotuseRedpackets").text(msg.snotuseRedpackets);
			$("#soverRedpackets").text(msg.soverRedpackets);
			$("#stotalVouchers").text(msg.stotalVouchers);
			$("#suseVouchers").text(msg.suseVouchers);
			$("#stotalVouchers").text(msg.stotalVouchers);
			$("#spayWithdrawal").text(msg.spayWithdrawal);
			$("#spayAward").text(msg.spayAward);
			$("#srcompenRepayAmount").text(msg.srcompenRepayAmount);
			$("#sfinancialAdvisorAward").text(msg.sfinancialAdvisorAward);
			
		}
	});
});