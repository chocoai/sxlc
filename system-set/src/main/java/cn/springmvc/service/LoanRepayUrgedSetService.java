package cn.springmvc.service; 

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.LoanRepayUrgedSetEntity;

public interface LoanRepayUrgedSetService {
	/**
	 * 新增催收账单配置
	 * @param entity 催收账单配置实体 billDays传入-1不设置
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除催收账单配置
	 * @param id 催收账单配置id
	 * @return 0：失败；1成功
	 */
	public int deleteLoanRepayUrgedSet();  
	/**
	 * 查询催收账单配置 
	 * @return LoanRepayUrgedSetEntity 催收账单配置实体
	 */
	public  LoanRepayUrgedSetEntity selectLoanRepayUrgedSetList();
}
