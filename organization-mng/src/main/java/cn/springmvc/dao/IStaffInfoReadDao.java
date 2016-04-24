package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.StaffInfo;

public interface IStaffInfoReadDao {
	
	
	

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
	* 根据员工编号获取员工信息
	* 
	* @author 李杰
	* @Title: findById
	* @param param
	* @return
	* @date 2016-4-20 上午11:13:18
	 */
	public StaffInfo findById(Map<String, Object> param);
	
	
	
	
	
	
	
	

}

