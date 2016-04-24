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


	
}
