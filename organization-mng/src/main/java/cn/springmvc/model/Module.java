package cn.springmvc.model;


/**
 * 模块
 * @author LiJie
 *
 */
public class Module {
	
	private Long		moduleId;				//模块序号
	private Integer		moduleLevel;			//模块级别
	private String		moduleNamel;			//模块名称
	private Long		prevModuleId;			//上级模块编号
	private String		modulePic1;				//模块对应的图片名称
	private String		modulePic2;				//模块对应的图片名称
	private String		moduleFunction;			//模块对应的资源路径
	private Integer		moduleindex;			//模块序号
	private Integer		moduleType;				//模块对应的类型
	
	private int         dowmModuleNum;			//下级模块数量
	private String      preModuleName;			//下级模块名称 
	
	
	public Module() {
		// TODO Auto-generated constructor stub
	}

	

	public Module(Long moduleId, Integer moduleLevel, String moduleNamel,
			Long prevModuleId, String modulePic1, String modulePic2,
			String moduleFunction, Integer moduleindex, Integer moduleType,
			int dowmModuleNum, String preModuleName) {
		super();
		this.moduleId = moduleId;
		this.moduleLevel = moduleLevel;
		this.moduleNamel = moduleNamel;
		this.prevModuleId = prevModuleId;
		this.modulePic1 = modulePic1;
		this.modulePic2 = modulePic2;
		this.moduleFunction = moduleFunction;
		this.moduleindex = moduleindex;
		this.moduleType = moduleType;
		this.dowmModuleNum = dowmModuleNum;
		this.preModuleName = preModuleName;
	}



	public int getDowmModuleNum() {
		return dowmModuleNum;
	}


	public void setDowmModuleNum(int dowmModuleNum) {
		this.dowmModuleNum = dowmModuleNum;
	}


	public String getPreModuleName() {
		return preModuleName;
	}


	public void setPreModuleName(String preModuleName) {
		this.preModuleName = preModuleName;
	}


	public Long getModuleId() {
		return moduleId;
	}


	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}


	public Integer getModuleLevel() {
		return moduleLevel;
	}


	public void setModuleLevel(Integer moduleLevel) {
		this.moduleLevel = moduleLevel;
	}


	public String getModuleNamel() {
		return moduleNamel;
	}


	public void setModuleNamel(String moduleNamel) {
		this.moduleNamel = moduleNamel;
	}

	public Long getPrevModuleId() {
		return prevModuleId;
	}


	public void setPrevModuleId(Long prevModuleId) {
		this.prevModuleId = prevModuleId;
	}


	public String getModulePic1() {
		return modulePic1;
	}


	public void setModulePic1(String modulePic1) {
		this.modulePic1 = modulePic1;
	}


	public String getModulePic2() {
		return modulePic2;
	}


	public void setModulePic2(String modulePic2) {
		this.modulePic2 = modulePic2;
	}


	public String getModuleFunction() {
		return moduleFunction;
	}


	public void setModuleFunction(String moduleFunction) {
		this.moduleFunction = moduleFunction;
	}


	public Integer getModuleindex() {
		return moduleindex;
	}


	public void setModuleindex(Integer moduleindex) {
		this.moduleindex = moduleindex;
	}


	public Integer getModuleType() {
		return moduleType;
	}


	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}
	
	
}
