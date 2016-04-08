package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.PostInfo;
import cn.springmvc.model.StaffInfo;




/****
 * 员工信息管理实体
 * @author LiJie
 *
 */
public interface IStaffInfoDao {
	
	
	
	/***
	 * 根据条件获取员工列表
	 * @param name					员工姓名
	 * @param contactPhone			员工联系电话
	 * @param idCard				身份证号码	
	 * @param postId				职务
	 * @return
	 */
	public List<StaffInfo> getListByParam(PageEntity pageEntity);
	
	
	
	
	/***
	 * 保存一个员工到数据库
	 * @param info					员工信息实体
	 * @param staffPost				
	 * @return
	 */
	public int	saveStaff(StaffInfo info,String deptId,String posId,String joinDate,String sKey);
	
	
	
	
	/***
	 * 修改员工信息
	 * @param info					员工实体
	 * @param staffPost				
	 * @return
	 */
	public int editStaff(StaffInfo info,String deptId,String posId,String joinDate,String sKey);
	
	
	
	
	
	/***
	 * 离职
	 * @param info					员工实体
	 * @return
	 */
	public int quit(StaffInfo info);
	
	
}
