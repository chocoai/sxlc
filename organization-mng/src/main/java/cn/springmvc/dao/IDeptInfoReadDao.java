package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.DeptInfo;


public interface IDeptInfoReadDao {

	

	/***
	 * 根据条件获取部门列表信息
	 * 
	 * @param deptNo					部门编号
	 * @param deptName					部门名称
	 * @param principalName				部门负责人名称
	 * @param principalPhone			部门负责人电话号码
	 * @param statu						部门状态   0停用、1启用
	 * @return
	 */
	public List<DeptInfo> getListByParam(PageEntity entity);
	
	
	/**
	* 获取所有部门信息
	* @author 李杰
	* @Title: findall
	* @return
	* @Description: TODO
	* @date 2016-4-6 下午2:12:00
	 */
	public List<DeptInfo> findall();
	
	

	/***
	* 获取某个部门详细信息
	* 
	* @author 李杰
	* @Title: deptInfo
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午3:23:49
	 */
	public DeptInfo deptInfo(Map<String,Object> param);
	
	/***
	* 根据上级部门编号查询下级部门信息
	* 
	* @author 李杰
	* @Title: findDeptInfoByParentId
	* @param param
	* @return
	* @date 2016-4-20 下午1:46:06
	 */
	public List<DeptInfo> findDeptInfoByParentId(Map<String,Object> param);
	
	/**
	 * 无条件不分页获取部门列表信息
	 * TODO
	 * 创建日期：2016-4-22下午6:50:19
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<DeptInfo>
	 */
	public List<DeptInfo> getDeptList();
}

