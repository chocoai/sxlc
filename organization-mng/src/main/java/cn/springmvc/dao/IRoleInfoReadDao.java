package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleAuth;
import cn.springmvc.model.RoleInfo;

import product_p2p.kit.pageselect.PageEntity;

/***
* 角色 
* @author 李杰
* @since 
* @date 2016-4-20 下午1:59:23 
*
 */
public interface IRoleInfoReadDao {
	

	/**
	 * TODO  获取模块列表
	 * 创建日期：2016-3-31下午3:45:55
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<PostInfo>
	 */
	public List<Module> getModuleList();	
	
	/**
	 * TODO   获取操作列表
	 * 创建日期：2016-3-31下午4:15:17
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<Operation>
	 */
	public List<Operation> getOperationList();
	
	/***
	 * 根据条件查询角色列表
	 * 
	 * @param param
	 * roleNo						角色编号
	 * roleName						角色名称
	 * startTime					创建日期
	 * endTime						结束日期
	 * @return
	 */
	public List<RoleInfo> getListByParam(Map<String,Object> param,PageEntity entity);
	

	/**
	 * TODO  获取模块列表  通过角色id
	 * 创建日期：2016-4-5下午4:13:54
	 * 修改日期：
	 * 作者：pengran
	 * @param  roleId
	 * return List<Module>
	 */
	public List<Module> getModuleListById(long roleId);	
	
	/**
	 *  
	 * TODO 获取操作列表 通过角色id
	 * 创建日期：2016-4-5下午4:12:50
	 * 修改日期： roleId
	 * 作者：pengran
	 * @param
	 * return List<Operation>
	 */
	public List<Operation> getOperationListById(long roleId);
	
	/**
	 * 根据职务编号查询职务信息
	 * 创建日期：2016-4-5下午5:05:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<RoleInfo>
	 */
	
	
	public List<RoleInfo> getRoleInfoById(long roleId);
	/**
	 * 根据职务编号查询角色权限表
	 * TODO
	 * 创建日期：2016-4-5下午5:05:17
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<RoleAuth>
	 */
	public List<RoleAuth> getRoleAuthById(long roleId);

	/**
	 * TODO
	 * 创建日期：2016-4-8下午2:38:14
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<RoleInfo>
	 */
	public List<RoleInfo> getRoleList();

	
	
	public List<Module> getModuleListThree();

}

