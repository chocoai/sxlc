

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

import cn.invitemastermng.model.FirstInvestRedpacketsSetEntity; 
import cn.invitemastermng.model.MemberRedpacketsEntity;
import cn.invitemastermng.model.MemberRedpacketsSetEntity;
import cn.invitemastermng.model.RedpacketsAffairEntity; 
import cn.invitemastermng.model.RedpacketsDetailRecordEntity;

/** 
 * @author 刘利 
 * @Description: 推广模块-赠送管理
 * @since 
 * @date 2016-4-15 下午8:05:47  */

public interface ExtensionModuleGiftListDao { 
	/**
	 * 红包活动记录查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<RedpacketsAffairEntity> 返回类型 
	 * @date 2016-4-16 下午3:27:46
	 */
	public List<RedpacketsAffairEntity> getRedpacketsAffair(PageEntity page);
	/**
	 * 根据ID查询红包活动详情 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param affairID 红包活动ID
	 * @param @return 设定文件 
	 * @return RedpacketsAffairEntity 返回类型 
	 * @date 2016-4-16 下午3:27:46
	 */
	public  RedpacketsAffairEntity  selectRedpacketsAffairbyID(long affairID);
	/**
	 * 根据红包活动ID查询活动红包明细纪录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param affairID 红包活动ID
	 * @param @return 设定文件 
	 * @return List<RedpacketsDetailRecordEntity> 返回类型 
	 * @date 2016-4-20 下午5:06:15
	 */
	public  List<RedpacketsDetailRecordEntity> selectRedpacketsDetailbyaffairID(long affairID);
	/**
	 * 红包领取明细查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<MemberRedpacketsEntity> 返回类型 
	 * @date 2016-4-16 下午3:31:33
	 */
	public List<MemberRedpacketsEntity> getRedpacketsreceive(PageEntity page);
	/**
	 * 查询会员红包赠送配置表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return MemberRedpacketsSetEntity 返回类型 
	 * @date 2016-4-18 下午2:58:58
	 */
	public MemberRedpacketsSetEntity selectMemberRedpacketsSet(); 
	/**
	 * 根据ID查询会员首次投资红包赠送配置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param firpID
	 * @param @return 设定文件 
	 * @return FirstInvestRedpacketsSetEntity 返回类型 
	 * @date 2016-4-18 下午3:36:38
	 */
	public FirstInvestRedpacketsSetEntity selectFIInvestRedSetByID(long firpID);
	/**
	 * 分页查询首次投资红包赠送配置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return List<FirstInvestRedpacketsSetEntity> 返回类型 
	 * @date 2016-4-18 下午4:03:02
	 */
	public List<FirstInvestRedpacketsSetEntity> selectFIInvestRedSetList(PageEntity page);
}

