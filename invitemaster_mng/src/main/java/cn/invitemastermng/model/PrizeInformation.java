package cn.invitemastermng.model; 

/***
* 奖品信息表
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-19 下午7:07:54 
*
*/
public class PrizeInformation {

	
	private long				prizeId						;//奖品编号
	private int					prizeType					;//奖品类型
	private String				prizeTypeName				;//
	private String				prizeName					;//奖品名称
	private long				prizeWorth					;//奖品价值
	private long				prizeQuantity				;//商品剩余数量
	private String				prizeUrl					;//讲评图片路径
	private int					status						;//是否有效
	
	public PrizeInformation() {}

	public PrizeInformation(long prizeId, int prizeType, String prizeName,
			long prizeWorth, long prizeQuantity, String prizeUrl, int status) {
		super();
		this.prizeId = prizeId;
		this.prizeType = prizeType;
		this.prizeName = prizeName;
		this.prizeWorth = prizeWorth;
		this.prizeQuantity = prizeQuantity;
		this.prizeUrl = prizeUrl;
		this.status = status;
	}



	public long getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(long prizeId) {
		this.prizeId = prizeId;
	}

	public int getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(int prizeType) {
		this.prizeType = prizeType;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public long getPrizeWorth() {
		return prizeWorth;
	}

	public void setPrizeWorth(long prizeWorth) {
		this.prizeWorth = prizeWorth;
	}

	public long getPrizeQuantity() {
		return prizeQuantity;
	}

	public void setPrizeQuantity(long prizeQuantity) {
		this.prizeQuantity = prizeQuantity;
	}

	public String getPrizeUrl() {
		return prizeUrl;
	}

	public void setPrizeUrl(String prizeUrl) {
		this.prizeUrl = prizeUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPrizeTypeName() {
		return prizeTypeName;
	}

	public void setPrizeTypeName(String prizeTypeName) {
		this.prizeTypeName = prizeTypeName;
	}
	
	
	
	
	
	
	
	
}

