

/** 
* @Title: ExtensionModuleDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:05:47 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.CpsInviteSetEntity; 
import cn.invitemastermng.model.MemberInfoEntity; 
import cn.invitemastermng.model.SeoSetEntity;
import cn.invitemastermng.model.SeoSetTypeEntity;

/** 
 * @author 刘利 
 * @Description: 推广模块
 * @since 
 * @date 2016-4-15 下午8:05:47  */

public interface ExtensionModuleListDao {
	/**
	 * 推荐达人申请记录查询
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page 
	 * #{skey}         #{Member_No}     #{Logname}       #{Reg_Date_Min}
	 * #{Reg_Date_Max} #{Personal_Name} #{House_Address} #{Check_Statu}
	 * @param @return 设定文件 
	 * @return List<MemberInfoEntity> 返回类型 
	 * @date 2016-4-16 下午3:01:44
	 */
	public List<MemberInfoEntity> getIMapply(PageEntity page);
	/**
	 * 推荐达人邀请记录查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * #{skey} 
	 * #{Im_No}
	 * @param @return 设定文件 
	 * @return List<MemberInfoEntity> 返回类型 
	 * @date 2016-4-16 下午3:08:26
	 */
	public List<MemberInfoEntity> getIMInvite(PageEntity page);
	/**
	 * SEO设置信息展示 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<SeoSetEntity> 返回类型 
	 * @date 2016-4-16 下午3:24:41
	 */
	public List<SeoSetEntity> getSEODisplay(PageEntity page); 
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
	 *  根据ID查询SEO信息配置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  seoSetID
	 * @param @return 设定文件 
	 * @return SeoSetEntity 返回类型 
	 * @date 2016-4-18 下午5:33:49
	 */
	public SeoSetEntity getSEOSetByID(long seoSetID); 
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
	 * 查询推荐达人配置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 下午6:00:41
	 */
	public int getInviteMasterSet();
  
}

