

/** 
* @Title: CreditorTransferListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-6 上午11:20:54 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.InvestEntity;

import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 债权转让
 * @since 
 * @date 2016-4-6 上午11:20:54  */

public interface CreditorTransferListDao {
	/**
	 * 分页查询债权转让列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity        
	 * @param @return 设定文件 
	 * @return List<CreditorTransferListEntity> 返回类型 
	 * @date 2016-4-6 上午11:27:37
	 */
	public List<CreditorTransferListEntity> selectCreditorTransferList(PageEntity pageEntity);
	/**
	 * 根据债权转让申请ID查询项目详情 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map
	 * @param @return 设定文件 
	 * @return CreditorTransferListEntity 返回类型 
	 * @date 2016-4-6 下午1:50:17
	 */
	public CreditorTransferListEntity selectCreditorTransferDetail(Map<String,Object> map);
	/**
	 * 查询债权转让剩余可投金额-已投资总额-转让本金
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-4-6 下午2:04:09
	 */
	public CreditorTransferListEntity selectCreditorAvailableaAmount(Map<String,Object> map);
	/**
	 * 通过债权转让申请ID查询投资记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-6 下午2:45:15
	 */
	public List<InvestEntity> selectCreditorInvestRecordByctaId(Map<String,Object> map);

}

