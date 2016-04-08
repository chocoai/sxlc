

/** 
* @Title: GenerateRepayListService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:57:04 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.Map;

/**
 * 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-5 上午11:12:03
 */

public interface InviteMasterApplyService {
	/**
	 * 推荐达人申请  
	 * @author 刘利    
	 * @param map map内传 会员ID memberID，推荐达人ID:imApplyID
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功，0失败 ，-1该会员意识推荐达人，或改会员存在未审核的申请记录
	 * @date 2016-4-5 上午11:07:37
	 */
	public int insertInviteMasterApply(Map<String,Object> map);
}

