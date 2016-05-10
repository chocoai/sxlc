package cn.springmvc.dao; 

import java.util.Map;




/** 
 * 认证信息审核操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午8:23:22  */
public interface HandleCertificationAuditDao {
	
	/** 
	* handleEnterpriseCerAudit 操作企业营业执照认证 审核
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleEnterpriseCerAudit 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-24 下午8:24:50
	* @throws 
	*/
	public Map<String, Object> handleEnterpriseCerAudit(Map<String, Object> map);
	
	/** 
	* handleEnterpriseBLAttest 操作企业会员工商执照认证信息审核
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleEnterpriseBLAttest 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-24 下午8:25:15
	* @throws 
	*/
	public Map<String, Object> handleEnterpriseBLAttest(Map<String, Object> map);
	
	
	/** 
	* handleAttest 会员其他相关认证操作
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleAttest 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-24 下午8:25:39
	* @throws 
	*/
	public Map<String, Object> handleAttest(Map<String, Object> map);
	
	
	/** 
	* handlequalification 个人会员最高学历认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handlequalification 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午9:08:34
	* @throws 
	*/
	public Map<String, Object> handlequalification(Map<String, Object> map);
	
	/** 
	* handlenameAuthentication 个人会员实名认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handlenameAuthentication 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午10:00:00
	* @throws 
	*/
	public Map<String, Object> handlenameAuthentication(Map<String, Object> map);
	
	/** 
	* handlemarriage 个人会员婚姻认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handlemarriage 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午10:04:42
	* @throws 
	*/
	public Map<String, Object> handlemarriage(Map<String, Object> map);
	
	
	/** 
	* handleAddress 个人会员住址认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleAddress 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午10:16:41
	* @throws 
	*/
	public Map<String, Object> handleAddress(Map<String, Object> map);
	
	
	/** 
	* delAutomaticBidSetting 删除自动投标设置 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: delAutomaticBidSetting 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-4 下午2:21:37
	* @throws 
	*/
	public int delAutomaticBidSetting(Map<String, Object> map);
	
	/** 
	* AutomaticBidSetting 添加自动投标设置  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: AutomaticBidSetting 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-5-4 下午2:22:05
	* @throws 
	*/
	public Map<String, Object> AutomaticBidSetting(Map<String, Object> map);
	
	
	/** 
	* DistributionFinancialAdvisor 给会员分配理财顾问
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: DistributionFinancialAdvisor 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-5-5 下午2:34:24
	* @throws 
	*/
	public Map<String, Object> DistributionFinancialAdvisor(Map<String, Object> map);
}

