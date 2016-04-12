package cn.springmvc.service;

import java.util.Date;
import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.StaffInfo;
import cn.springmvc.model.StaffPost;




/***
 * 用户操作业务逻辑层
 * @author LiJie
 *
 */
public interface IStaffInfoService {

	

	/***
	 * 保存员工信息
	 * @param info				员工信息
	 * @param post				员工职务信息
	 * @return
	 */
	public int saveStaff(StaffInfo info,String deptId,String postId,Date joinDate);
	
	
	
	
	
	
	/***
	 * 获取员工信息列表
	 * @param name				员工姓名
	 * @param contactPhone		联系电话
	 * @param idCard			身份证号码
	 * @param postId			职务
	 * @param sType				非员工中的管理yuan
	 * @return
	 */

	public void StaffInfosByParam(PageEntity pageEntity);

	
	
	
	
	
	/***
	 * 修改员工信息
	 * @param info					员工实体
	 * @param staffPost				
	 * @return
	 */
	public int editStaff(StaffInfo info,String deptId,String posId,Date joinDate);
	
	
	
	
	
	/***
	 * 离职
	 * @param info					员工实体
	 * @return
	 */
	public int quit(StaffInfo info);
	
	
	
	
	
	
	
}
