package cn.membermng.model;

/**
 * @author pengran 交易类型实体
 * @date:2016-5-2 下午12:13:36
 **/

public class TradingTypeEntity {
	private long id; // id
	private long fid; // 所属一级交易类型id
	private String fTypeName; // 所属一级交易类型名称
	private String tradeType; // 交易类型
	private String tradeNo; // 交易编号
	private int statu; // 是否有效

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getfTypeName() {
		return fTypeName;
	}

	public void setfTypeName(String fTypeName) {
		this.fTypeName = fTypeName;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}
}
