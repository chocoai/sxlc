
package cn.membermng.model; 
/**
 * 余额处理使用
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-5-5 下午7:46:35
 */
public class MemberTradingIdEntity {
	private long lId;			//交易记录ID
	private short sType;		//会员类型 	0：会员 1：担保机构
	public long getlId() {
		return lId;
	}
	public void setlId(long lId) {
		this.lId = lId;
	}
	public short getsType() {
		return sType;
	}
	public void setsType(short sType) {
		this.sType = sType;
	}
}

