package cn.springmvc.model;

public class Trui {
	private String accessPath;						//访问路径
	private boolean checked;							//true
	private long delFlag;						
	private long   parentID;						//父节点id
	private String resourceCode;					
	private String resourceDesc;
	private long resourceGrade;
	private long resourceID;						//本级节点id
	private String resourceName;					//节点名
	private long  resourceOrder;
	private String resourceType;
	
	public String getAccessPath() {
		return accessPath;
	}

	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}

	public long getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(long delFlag) {
		this.delFlag = delFlag;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
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
	public long getResourceGrade() {
		return resourceGrade;
	}

	public void setResourceGrade(long resourceGrade) {
		this.resourceGrade = resourceGrade;
	}

	public long getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(long resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	
	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public long getResourceID() {
		return resourceID;
	}

	public void setResourceID(long resourceID) {
		this.resourceID = resourceID;
	}

}
