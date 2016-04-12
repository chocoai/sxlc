package cn.springmvc.model;

/**
 * @author pengran
 * 操作模块
 * @date:2016-3-31 下午3:32:13
 **/
public class Operation {
	private  long   optID;			//操作id
	private  long   moduleID;		//模块id
	private  String optName;		//操作名称
	private  String optPic;			//操作对应图片名称	
	private  String optFunction;	//操作对应资源路径
	private  int    optindex;		//序号(同一模块不能重复)	
	private  int    auto;			//是否自动展示
	private  int    moduleType;		//模块类型0：总部，地市共有（继承模块类型） 1：总部 2：地市 3：理财师 4：客服 5：客服，理财师共有 6：所有人共有
	public long getOptID() {
		return optID;
	}
	public void setOptID(long optID) {
		this.optID = optID;
	}
	public long getModuleID() {
		return moduleID;
	}
	public void setModuleID(long moduleID) {
		this.moduleID = moduleID;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public String getOptPic() {
		return optPic;
	}
	public void setOptPic(String optPic) {
		this.optPic = optPic;
	}
	public String getOptFunction() {
		return optFunction;
	}
	public void setOptFunction(String optFunction) {
		this.optFunction = optFunction;
	}
	public int getOptindex() {
		return optindex;
	}
	public void setOptindex(int optindex) {
		this.optindex = optindex;
	}
	public int getAuto() {
		return auto;
	}
	public void setAuto(int auto) {
		this.auto = auto;
	}
	public int getModuleType() {
		return moduleType;
	}
	public void setModuleType(int moduleType) {
		this.moduleType = moduleType;
	}

}
