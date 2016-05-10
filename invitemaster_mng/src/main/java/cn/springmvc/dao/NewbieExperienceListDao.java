

/** 
* @Title: NewbieExperienceListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午2:12:16 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import cn.invitemastermng.model.NewbieExperienceRecordsEntity;
import cn.invitemastermng.model.NewbieExperienceSetEntity;

import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 新手体验标
 * @since 
 * @date 2016-4-15 下午2:12:16  */

public interface NewbieExperienceListDao {
	/**
	 * 会员体验收益获取记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<NewbieExperienceRecordsEntity> 返回类型 
	 * @date 2016-4-15 下午2:14:04
	 */
	public List<NewbieExperienceRecordsEntity> getExperienceIncome(PageEntity page);
	/**
	 * 查询新手体验标设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return NewbieExperienceSetEntity 返回类型 
	 * @date 2016-4-19 下午3:34:30
	 */
	public NewbieExperienceSetEntity  getNewbieExperienceSet();
	
	/**
	 * 首页查询查询新手体验标设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return NewbieExperienceSetEntity 返回类型 
	 * @date 2016-4-19 下午3:34:30
	 */
	public NewbieExperienceSetEntity  getNewbieExperienceSetIndex();
} 

