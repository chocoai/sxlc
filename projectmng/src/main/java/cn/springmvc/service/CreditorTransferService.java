

/** 
* @Title: CreditorTransferService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-6 上午11:38:25 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.InvestEntity;

/** 
 * @author 刘利 
 * @Description: 债权转让
 * @since 
 * @date 2016-4-6 上午11:38:25  */

public interface CreditorTransferService {
	/**
	 * 分页查询债权转让列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity 
	 * <p>map{projectinfo(项目编号或名称),investStatu(项目状态),
	 *       repayWay(还款方式),         projectType(借款类型)
	 *       yearratemin,yearratemax,deadlineType(期限类型 0：天标 1：月标 2：年标)，
	 *       deadlinemin,deadlinemax,skey}
	 * <p>        
	 * @param @return 设定文件 
	 * @return List<CreditorTransferListEntity> 返回类型 
	 * @date 2016-4-6 上午11:27:37
	 */
	public List<CreditorTransferListEntity> selectCreditorTransferList(PageEntity pageEntity);
	/**
	 * 根据债权转让申请ID查询项目详情 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param ctaId  债权转让申请ID
	 * @param @return 设定文件 
	 * @return CreditorTransferListEntity 返回类型 
	 * @date 2016-4-6 下午1:50:17
	 */
	public CreditorTransferListEntity selectCreditorTransferDetail(int ctaId);
	/**
	 * 查询该债权的剩余可投金额 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param ctaId 债权转让申请ID
	 * @param @return 设定文件 
	 * @return CreditorTransferListEntity 返回类型 
	 * @date 2016-4-6 下午2:04:09
	 */
	public CreditorTransferListEntity selectCreditorAvailableaAmount(int ctaId);
	/**
	 * 通过债权转让申请ID查询投资记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param ctaId 债权转让申请ID
	 * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-6 下午2:45:15
	 */
	public List<InvestEntity> selectCreditorInvestRecordByctaId(int ctaId);
}

