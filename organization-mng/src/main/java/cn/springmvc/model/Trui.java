package cn.springmvc.model;

public class Trui {
	private String accessPath;						//访问路径
	private String checked;							//true
	private String delFlag;						
	private String parentID;						//父节点id
	private String resourceCode;					
	private String resourceDesc;
	private String resourceGrade;
	private String resourceID;						//本级节点id
	private String resourceName;					//节点名
	private String resourceOrder;
	private String resourceType;
	
	public String getAccessPath() {
		return accessPath;
	}

	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public String getResourceGrade() {
		return resourceGrade;
	}

	public void setResourceGrade(String resourceGrade) {
		this.resourceGrade = resourceGrade;
	}

	public String getResourceID() {
		return resourceID;
	}

	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(String resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@Override
	public String toString() {
		return "trui [accessPath=" + accessPath + ", checked=" + checked
				+ ", delFlag=" + delFlag + ", parentID=" + parentID
				+ ", resourceCode=" + resourceCode + ", resourceDesc="
				+ resourceDesc + ", resourceGrade=" + resourceGrade
				+ ", resourceID=" + resourceID + ", resourceName="
				+ resourceName + ", resourceOrder=" + resourceOrder
				+ ", resourceType=" + resourceType + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
