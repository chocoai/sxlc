package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.DeptInfo;


public interface IDeptInfoServer {

	/**
	 *获取全部部门 
	 */
	public  List<DeptInfo> findall();
	
	
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
	public void  getListByParam(PageEntity entity);
	
	
	/***
	 * 持久化一个部门信息
	 * @param deptInfo					部门信息实体
	 * @return							-1部门已存在、1添加成功
	 */	
	public int saveDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/***
	 * 修改一个部门信息
	 * @param deptInfo					部门信息实体
	 * @return							0修改成功、1修改失败
	 */
	public int editDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/***
	 * 删除一个部门信息
	 * @param deptInfo					部门信息实体
	 * @return							0删除成功、1删除失败，存在职务、2删除失败，存在下级部门
	 */
	public int delDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo);

	
	/***
	 * 停用启用一个部门
	 * @param deptInfo				部门信息
	 * @return
	 */
	public int ofDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo);

	
	/**
	* 根据部门编号获取部门详细信息 
	* @author 李杰
	* @Title: deprinfoById
	* @param deptId
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午3:25:44
	 */
	public DeptInfo deprinfoById(long deptId);
	
	
	/***
	* 根据部门编号查询下级部门 
	* 
	* @author 李杰
	* @Title: findDeptInfoByParentId
	* @param parentId
	* @return
	* @date 2016-4-20 下午1:48:16
	 */
	public List<DeptInfo> findDeptInfoByParentId(long parentId);
	
	/***
	 * 
	 * TODO
	 * 创建日期：2016-4-22下午6:53:02
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<DeptInfo>
	 */
	public List<DeptInfo> getDeptList() ;
}

