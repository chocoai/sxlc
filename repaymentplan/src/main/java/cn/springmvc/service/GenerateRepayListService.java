

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

/** 
 * @author 刘利 
 * @Description: 发布后生成还款计划
 * @since 
 * @date 2016-4-1 下午1:57:04  */

public interface GenerateRepayListService {
	/**
	 * 项目发布时根据项目ID生成该项目的还款计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param applyID
	 * @param @return 设定文件 
	 * @return int 返回类型  -1项目信息不存在，1成功
	 * @date 2016-4-1 下午1:58:20
	 */
	public int GenerateRepayList(int applyID);
}

