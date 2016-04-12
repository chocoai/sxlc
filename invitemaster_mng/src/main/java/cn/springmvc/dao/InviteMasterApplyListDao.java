

/** 
* @Title: GenerateRepayListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:46:58 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;
/**
 * 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-5 上午11:33:04
 */

public interface InviteMasterApplyListDao {
	/**
	 * 查询该会员是否已成为推荐达人，或者存在审核中的推荐达人申请
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberID 会员ID
	 * @param @return 设定文件 
	 * @return int 返回类型  0不存在，大于0存在
	 * @date 2016-4-5 上午11:38:32
	 */
	public int selectInviteMasterApplyIsExist(long memberID);
	
}

