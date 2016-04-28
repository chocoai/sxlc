

/** 
* @Title: CreditorTransferCheckEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-25 上午11:28:02 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description:债权转让审核实体
 * @since 
 * @date 2016-4-25 上午11:28:02  */

public class CreditorTransferCheckEntity {
	 private String ctaId;//债权转让申请ID
	 private String billNo;//债权转让申请编号  	         
     private String applyTime  ;//  申请时间  	    
	 private String projectTitle ;//  项目名称   
	 private String projectNo ;//  	债权转让项目编号        
	 private String tranLogname;// 转让会员用户名	     
	
	 private String loanLogname ;//	借款会员  用户名  
	 private String loanMemberName;// 	借款会员  名称
	 private String tranMemberName;//转让会员名称	    
	 private long   transPrincipal;//    转让金额、、 
	 private int    transDiscount;//	转让折扣 
	 private long   transferPrice;//转让价格、
	 private String transPrincipals;// 转让金额、、      
	 private String transDiscounts;//转让折扣 	 
	 private String transferPrices;//转让价格、
	 private String ctaInvestRate;//	融资进度	 
	 private String transMaxTime	;//	  投标结束时间
	 private String tatu;//	    转让状态
     private int    surplusTime;//剩余期限
	 private int    surplusTimeType;//剩余期限类型
	 public long getTransPrincipal() {
		return transPrincipal;
	}
	public void setTransPrincipal(long transPrincipal) {
		this.transPrincipal = transPrincipal;
		this.transPrincipals= IntegerAndString.LongToString(transPrincipal);
	}
	public int getTransDiscount() {
		return transDiscount;
	}
	public void setTransDiscount(int transDiscount) {
		this.transDiscount = transDiscount;
		this.transDiscounts= IntegerAndString.LongToString(transDiscount);
	}
	public long getTransferPrice() {
		return transferPrice;
	}
	public void setTransferPrice(long transferPrice) {
		this.transferPrice = transferPrice;
		this.transferPrices= IntegerAndString.LongToString(transferPrice);
	}
	public String getTransPrincipals() {
		return transPrincipals;
	}
	public void setTransPrincipals(String transPrincipals) {
		this.transPrincipals = transPrincipals;
	}
	public String getTransDiscounts() {
		return transDiscounts;
	}
	public void setTransDiscounts(String transDiscounts) {
		this.transDiscounts = transDiscounts;
	}
	public String getTransferPrices() {
		return transferPrices;
	}
	public void setTransferPrices(String transferPrices) {
		this.transferPrices = transferPrices;
	}
	
	public String getCtaId() {
		return ctaId;
	}
	public void setCtaId(String ctaId) {
		this.ctaId = ctaId;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	 
	public String getLoanLogname() {
		return loanLogname;
	}
	public void setLoanLogname(String loanLogname) {
		this.loanLogname = loanLogname;
	}
	public String getLoanMemberName() {
		return loanMemberName;
	}
	public void setLoanMemberName(String loanMemberName) {
		this.loanMemberName = loanMemberName;
	}
	public String getTranMemberName() {
		return tranMemberName;
	}
	public void setTranMemberName(String tranMemberName) {
		this.tranMemberName = tranMemberName;
	}
  
	public String getCtaInvestRate() {
		return ctaInvestRate;
	}
	public void setCtaInvestRate(String ctaInvestRate) {
		this.ctaInvestRate = ctaInvestRate;
	}
 
	public String getTatu() {
		return tatu;
	}
	public void setTatu(String tatu) {
		this.tatu = tatu;
	}
	public int getSurplusTime() {
		return surplusTime;
	}
	public void setSurplusTime(int surplusTime) {
		this.surplusTime = surplusTime;
	}
	public int getSurplusTimeType() {
		return surplusTimeType;
	}
	public void setSurplusTimeType(int surplusTimeType) {
		this.surplusTimeType = surplusTimeType;
	}
	public String getTransMaxTime() {
		return transMaxTime;
	}
	public void setTransMaxTime(String transMaxTime) {
		this.transMaxTime = transMaxTime;
	}
    public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getTranLogname() {
		return tranLogname;
	}
	public void setTranLogname(String tranLogname) {
		this.tranLogname = tranLogname;
	}
}

