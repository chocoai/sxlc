
package cn.springmvc.dao;

import java.util.List;
import java.util.Map;



/** 
 * 可转让债权相关操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:02:17  */
public interface HandleTransferableCreditsDao {
	
	/** 
	* creditorTransApp 提交债权转让申请 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: creditorTransApp 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-31 上午11:32:16
	* @throws 
	*/
	public Map<String, Object> creditorTransApp(Map<String, Object> map);
}

