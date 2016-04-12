

/** 
* @Title: MemberMsgRecordService.java 
* @Package cn.membermsgrecord.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午5:21:52 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.MemberMsgRecordEntity;

import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 会员站内信
 * @since 
 * @date 2016-3-29 下午5:21:52  */

public interface MemberMsgRecordService {
	/**
	 * 分页查询会员的站内消息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity map{memberID,readStatu(-1全部，1已读，0未读)}
	 * @param @return 设定文件 
	 * @return List<MemberMsgRecordEntity> 返回类型 
	 * @date 2016-3-29 下午6:17:53
	 */
     public List<MemberMsgRecordEntity> selectMemberMsgList(PageEntity pageEntity);
     /**
 	 * 标记会员站内消息为已读 
 	 * @author 刘利   
 	 * @Description: TODO 
 	 * @param @param map (memberID,recordDate(生成时间),msgType(消息类型 2：站内信))
 	 * @param @return 设定文件 
 	 * @return int 返回类型 
 	 * @date 2016-3-29 下午6:20:12
 	 */
 	public int  updateMemberMsgIsRead(Map<String,Object> map);
}

