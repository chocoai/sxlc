package cn.springmvc.dao;


import cn.springmvc.model.DeptInfo;
import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

/***
 * 部门信息接口
 * <br>规定对部门信息的一些基本操作
 * @author LiJie
 * @Date   2016-03-14
 *
 */
public interface IDeptInfoDao {
	
	
	
	
	
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
	 * 持久化一个部门信息
	 * @param deptInfo					部门信息实体
	 * @return							-1部门已存在、1添加成功
	 */	
	public int saveDept(Map<String,Object> param);
	
	
	
	
	/***
	 * 修改一个部门信息
	 * @param deptInfo					部门信息实体
	 * @return							0修改成功、1修改失败
	 */
	public int editDept(Map<String,Object> param);
	
	
	
	
	/***
	 * 删除一个部门信息
	 * @param deptInfo					部门信息实体
	 * @return							0删除成功、1删除失败
	 */
	public int delDept(Map<String,Object> param);

	
	/***
	 * 停用启用一个部门
	 * @param deptInfo				部门信息
	 * @return
	 */
	public int ofDept(Map<String,Object> param);


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
	
	
}
