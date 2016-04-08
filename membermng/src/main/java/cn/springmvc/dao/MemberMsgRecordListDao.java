

/** 
* @Title: MemberMsgRecordListDao.java 
* @Package cn.membermsgrecord.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午6:19:14 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import cn.membermng.model.MemberMsgRecordEntity;

import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-3-29 下午6:19:14  */

public interface MemberMsgRecordListDao {
	/**
	 * 分页查询会员的站内消息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * @param @return 设定文件 
	 * @return List<MemberMsgRecordEntity> 返回类型 
	 * @date 2016-3-29 下午6:17:53
	 */
     public List<MemberMsgRecordEntity> selectMemberMsgList(PageEntity pageEntity);
}

