

/** 
* @Title: ExtensionModuleService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:10:45 
* @version V5.0 */
 
package cn.springmvc.service; 
 
import java.util.List;
import java.util.Map;

import cn.invitemastermng.model.CpsInviteSetEntity; 
import cn.invitemastermng.model.SeoSetEntity;
import cn.invitemastermng.model.SeoSetTypeEntity;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 推广模块
 * @since 
 * @date 2016-4-15 下午8:10:45  */

public interface ExtensionModuleService {
	/**
	 * SEO信息配置表设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * {title :内容	description :描述	keyword :关键词	
	 * seotype:SEO类型	adminID	:管理员ID	     lId:新生成ID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0 失败1成功
	 * @date 2016-4-16 下午12:01:48
	 */
	public int seoSet(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
     * SEO信息配置表删除
     * @author 刘利   
     * @Description: TODO 
     * @param  lId
     * @param @return 设定文件 
     * @return int 返回类型 
     * @date 2016-4-16 下午12:26:23
     */
	public int seoDelete(int lId,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * SEO设置信息展示 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-16 下午3:24:41
	 */
	public void getSEODisplay(PageEntity page);
	/**
	 * 查询SEO类型- 下拉选择 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<SeoSetTypeEntity> 返回类型 
	 * @date 2016-4-18 下午5:45:32
	 */
	public List<SeoSetTypeEntity> getSeoSetType();
	/**
	 *  根据ID查询SEO信息配置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param seoSetID
	 * @param @return 设定文件 
	 * @return SeoSetEntity 返回类型 
	 * @date 2016-4-18 下午5:33:49
	 */
	public SeoSetEntity getSEOSetByID(long seoSetID); 
	/**
	 * CPS推荐配置表修改，如果传入参数值为-1，不修改该参数 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * {first_Invest:首次投资金额	
	 * invite :第三方账户成功返现金额	
	 * first_Borrow :首次借款成功返现金额	
	 * first_Recharge:首次充值成功返现金额
	 * }
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-16 下午12:35:22
	 */
	public int CPSPromote(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 查询cps推荐配置表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return CpsInviteSetEntity 返回类型 
	 * @date 2016-4-18 下午4:59:21
	 */
	public CpsInviteSetEntity selectCpsInviteSet();
	/**
	 *  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param validityPeriod 推荐达人推广有效年限
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-16 下午12:42:29
	 */
	public int inviteMasterSet(int validityPeriod,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 推荐达人申请审核 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * apply_ID:推荐达人申请ID	
	 * aimID	:推荐达人活动点ID	
	 * checkStatu:审核记录状态	1：通过 -1：打回 
	 * adminID	:审核管理员ID	
	 * remark：审核意见	
	 * attach_Name：附件名称(若是多个，用英文逗号(,)拼接)	
	 * attach_Url：附件路径(若是多个，用英文逗号(,)拼接)	
	 * lId:新生成ID
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败1成功
	 * @date 2016-4-16 下午1:40:19
	 */
	public int inviteMasterApplyCheck(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 推荐达人申请记录查询
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page 
	 * #{skey}         #{Member_No}     #{Logname}       #{Reg_Date_Min}
	 * #{Reg_Date_Max} #{Personal_Name} #{House_Address} #{Check_Statu}
	 * #{orderDsec 1升序，0降序}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-16 下午3:01:44
	 */
	public void getIMapply(PageEntity page);
	/**
	 * 推荐达人邀请记录查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * #{skey} 
	 * #{Im_No}
	 * #{orderDsec 1升序，0降序}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-16 下午3:08:26
	 */
	public void getIMInvite(PageEntity page);
	/**
	 * 查询推荐达人配置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 下午6:00:41
	 */
	public int getInviteMasterSet();
	
	
}	

