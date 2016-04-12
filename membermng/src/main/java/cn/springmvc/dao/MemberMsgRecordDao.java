

/** 
* @Title: MemberMsgRecordDao.java 
* @Package cn.membermsgrecord.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午6:14:26 
* @version V5.0 */
 
package cn.springmvc.dao; 
 
import java.util.Map;
  

/** 
 * @author 刘利 
 * @Description: 站内消息
 * @since 
 * @date 2016-3-29 下午6:14:26  */

public interface MemberMsgRecordDao {
	/**
	 * 标记会员站内消息为已读 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-29 下午6:20:12
	 */
	public int  updateMemberMsgIsRead(Map<String,Object> map);
}

