
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * 债权转让放款查询列表
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-30 下午5:19:29  */
public class TransferableCreditsFangKuanEntity {
	private long tranId;//债权转让申请id
	private String projectName;//项目名称
	private String loanMemberName;//借款会员登录名
	private String transferMemberName;//转让会员登录名
	private long mount;//转让价格
	private String mounts;//转让价格
	private long transferMount;//转让金额
	private String transferMounts;//转让金额
	private int  transferzk;//转让折扣
	private String  transferzks;//转让折扣
	private long investSe;//投资进度
	private String investSes;//投资进度
	private String invEndtime;//投资结束时间
	private int status;//项目状态
	private String statusName;//项目状态
	private String fangkuanTime;//放款时间 /流标时间
//	private String failTime;//流标时间
	public long getTranId() {
		return tranId;
	}
	public void setTranId(long tranId) {
		this.tranId = tranId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getLoanMemberName() {
		return loanMemberName;
	}
	public void setLoanMemberName(String loanMemberName) {
		this.loanMemberName = loanMemberName;
	}
	public String getTransferMemberName() {
		return transferMemberName;
	}
	public void setTransferMemberName(String transferMemberName) {
		this.transferMemberName = transferMemberName;
	}
	public long getMount() {
		return mount;
	}
	public void setMount(long mount) {
		this.mount = mount;
		this.mounts = IntegerAndString.LongToString(mount/1000000);
	}
	public long getTransferMount() {
		return transferMount;
	}
	public void setTransferMount(long transferMount) {
		this.transferMount = transferMount;
		this.transferMounts = IntegerAndString.LongToString(transferMount);
	}
	public int getTransferzk() {
		return transferzk;
	}
	public void setTransferzk(int transferzk) {
		this.transferzk = transferzk;
		this.transferzks = IntegerAndString.IntToString(transferzk);
	}
	public long getInvestSe() {
		return investSe;
	}
	public void setInvestSe(long investSe) {
		this.investSe = investSe;
		this.setInvestSes(IntegerAndString.LongToString(investSe));
	}
	public String getInvEndtime() {
		return invEndtime;
	}
	public void setInvEndtime(String invEndtime) {
		this.invEndtime = invEndtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFangkuanTime() {
		return fangkuanTime;
	}
	public void setFangkuanTime(String fangkuanTime) {
		this.fangkuanTime = fangkuanTime;
	}
//	public String getFailTime() {
//		return failTime;
//	}
//	public void setFailTime(String failTime) {
//		this.failTime = failTime;
//	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getMounts() {
		return mounts;
	}
	public void setMounts(String mounts) {
		this.mounts = mounts;
	}
	public String getTransferMounts() {
		return transferMounts;
	}
	public void setTransferMounts(String transferMounts) {
		this.transferMounts = transferMounts;
	}
	public String getTransferzks() {
		return transferzks;
	}
	public void setTransferzks(String transferzks) {
		this.transferzks = transferzks;
	}
	public String getInvestSes() {
		return investSes;
	}
	public void setInvestSes(String investSes) {
		this.investSes = investSes;
	}
	
}

