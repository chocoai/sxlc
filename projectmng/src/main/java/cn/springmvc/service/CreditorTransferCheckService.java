

/** 
* @Title: CreditorTransferCheckService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-25 下午12:43:05 
* @version V5.0 */
 
package cn.springmvc.service; 
 

import java.util.Map;

import cn.springmvc.model.CreditorTransferCheckEntity;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 债权转让管理
 * @since 
 * @date 2016-4-25 下午12:43:05  */

public interface CreditorTransferCheckService {
	/**
     * 后台债权转让管理 -分页查询债权转让申请 
     * @author 刘利   
     * @Description: TODO 
     * @param pageEntity
     * {sKey,projectNo 项目编号；billNo债权转让编号；Tranname 转让会员名称；TransPrincipal转让金额，
     * order(1转让申请时间降序,-1转让申请时间升序-,2转让金额降序,-2转让金额升序,3转让价格降序,-3转让价格升序)}
     * @param @return 设定文件 
     * @return void 返回类型 
     * @date 2016-4-25 上午11:20:59
     */
	public void selectCreditorTransferManager(PageEntity pageEntity);
	/**
	 * 审核时查看债权转让详情 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param ctaId 债权申请ID
	 * @param @return 设定文件 
	 * @return CreditorTransferCheckEntity 返回类型 
	 * @date 2016-4-25 下午1:54:15
	 */
	public CreditorTransferCheckEntity selectCreditorTransferDetailCheck(long ctaId);
	/**
	 * 债权转让申请审核
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{ctaId债权转让申请ID,checkstatu审核状态,adminID,checkRemark审核意见,transMaxTime最迟转让时间}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功，-1该债权已审核
	 * @date 2016-4-25 下午2:03:44
	 */
	public int creditorTransAppCheck(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 修改最迟转让时间
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{transMaxTime最晚转让日期；ctaId债权转让申请日期}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-25 下午2:57:51
	 */
	public int updateTransMaxTime(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 查询债权转让投标结束时间
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param ctaId
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-25 下午4:39:59
	 */
	public String selectTransMaxTime(long ctaId);
}

