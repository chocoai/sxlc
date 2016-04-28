

/** 
* @Title: CreditorTransferCheckListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-25 下午12:02:14 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.CreditorTransferCheckEntity; 

/** 
 * @author 刘利 
 * @Description: 债权转让管理
 * @since 
 * @date 2016-4-25 下午12:02:14  */

public interface CreditorTransferCheckListDao {
    /**
     * 后台债权转让管理 -分页查询债权转让申请 
     * @author 刘利   
     * @Description: TODO 
     * @param @param pageEntity
     * @param @return 设定文件 
     * @return List<CreditorTransferListEntity> 返回类型 
     * @date 2016-4-25 上午11:20:59
     */
	public List<CreditorTransferCheckEntity> selectCreditorTransferManager(PageEntity pageEntity);
	/**
	 * 审核时查看债权转让详情 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return CreditorTransferCheckEntity 返回类型 
	 * @date 2016-4-25 下午1:54:15
	 */
	public CreditorTransferCheckEntity selectCreditorTransferDetailCheck(Map<String,Object> map);
	/**
	 * 查询债权转让投标结束时间
	 * @author 刘利   
	 * @Description: TODO 
	 * @param ctaId 债权转让申请ID
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-25 下午4:39:59
	 */
	public String selectTransMaxTime(long ctaId);
}

