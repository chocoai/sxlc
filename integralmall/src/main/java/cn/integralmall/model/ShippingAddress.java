package cn.integralmall.model; 


/***
* 收货地址记录表
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-11 上午10:58:41 
*
*/
public class ShippingAddress {

	private long				addressId								;//收货地址编号
	private long				memberId								;//会员编号
	private int					province								;//省编号
	private String				provinceName							;//省名称
	private int					city									;//市编号
	private String				cityName								;//市名称
	private int					county									;//区县编号
	private String				countyName								;//区县名称
	private int					villages								;//乡镇
	private String				villagesName							;//乡镇名称
	private String				street									;//街道
	private String				detailedAddress							;//详细地址
	private String				postcode								;//邮编
	private String				contactName								;//联系人姓名
	private String				contactPhone							;//联系人电话
	private String				contactEmail							;//联系人邮箱地址
	private int					deliveryChoice							;//送货选择：0不限、1只限工作日、2只限节假日
	private int					iSDefaultAddress						;//默认送货地址：1是 0否
	private int					deleteFlag								;//删除标记 1有效 0已删除
	
	
	
	public ShippingAddress() {}



	public ShippingAddress(long addressId, long memberId, int province,
			int city, int county, int villages, String street,
			String detailedAddress, String postcode, String contactName,
			String contactPhone, String contactEmail, int deliveryChoice,
			int iSDefaultAddress, int deleteFlag) {
		super();
		this.addressId = addressId;
		this.memberId = memberId;
		this.province = province;
		this.city = city;
		this.county = county;
		this.villages = villages;
		this.street = street;
		this.detailedAddress = detailedAddress;
		this.postcode = postcode;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.deliveryChoice = deliveryChoice;
		this.iSDefaultAddress = iSDefaultAddress;
		this.deleteFlag = deleteFlag;
	}


	
	

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getVillagesName() {
		return villagesName;
	}

	public void setVillagesName(String villagesName) {
		this.villagesName = villagesName;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getCounty() {
		return county;
	}

	public void setCounty(int county) {
		this.county = county;
	}

	public int getVillages() {
		return villages;
	}

	public void setVillages(int villages) {
		this.villages = villages;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int getDeliveryChoice() {
		return deliveryChoice;
	}

	public void setDeliveryChoice(int deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

	public int getiSDefaultAddress() {
		return iSDefaultAddress;
	}

	public void setiSDefaultAddress(int iSDefaultAddress) {
		this.iSDefaultAddress = iSDefaultAddress;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
	
	
	
	
	
	
}

