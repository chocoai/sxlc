package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.Admin;


/***
 * 添加管理员业务逻辑层
 * @author LiJie
 *
 */
public interface IAdminService {
	
	
	
	/***
	 * 添加一个管理员信息<br>
	 * staffType			员工类型0：员工 1：推荐达人 2：超级管理员 3：客服 4：担保公司管理员<br>
	 * staffId				员工ID/推荐达人ID/担保公司ID 0：表示超级管理员 <br>
	 * adminName			管理员名称<br>
	 * adminPwd				管理员密码<br>
	 * adminRemark			说明<br>
	 * adminCure		 	是否固化，固化后只能修改密码，不能进行删除等操作，默认0；0：不固化，非0：固化<br>
	 * adminStatu			是否失效，默认0；0：有效，非0：失效<br>
	 * @param admin			管理员实体<br>
	 * @param roles			权限
	 * @return -1该员工已是管理员、-2管理员名称已被使用、0成功
	 */
	public int saveAdmin(Admin admin,long roles,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/**
	* 查询一个管理员详细信息
	* @author 李杰
	* @return
	* @date 2016-4-19 下午5:54:37
	 */
	public Admin findAdminById(long adminId);
	
	
	/***
	 * 根据条件查询管理员信息<br>
	 * 
	 * 
	 * @param admin				条件信息		
	 * @return
	 */
	public void adminsByParam(PageEntity entity);
	
	
	/***
	 * 修改管理员信息<br>
	 * aid						管理员编号<br>
	 * roles					角色权限<br>
	 * @param admin				管理员信息
	 * @return		0修改成功过  -1修改失败
	 */
	public int editAdmin(Admin admin,long roles,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/***
	* 修改管理员密码
	* @author 李杰
	* @Title: editAdminPassword
	* @param adminId						管理员编号
	* @param password						管理员密码
	* @return	1修改成功、-1修改失败
	* @date 2016-4-6 上午10:11:45
	 */
	public int editAdminPassword(long adminId,String password,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/***
	 * 停用启用
	 * id						管理员编号
	 * statu					状态
	 * 
	 * @param admin				管理员信息
	 * @return -1失败 、 0成功
	 */
	public int ofAdmin(long id,int statu,InsertAdminLogEntity entity,String[] sIpInfo);
	
	

}
