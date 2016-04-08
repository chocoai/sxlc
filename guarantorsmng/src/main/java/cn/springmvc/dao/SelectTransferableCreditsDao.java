
package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.model.TransferRulesEntity;
import cn.springmvc.model.TransferableCreditsEntity;



/** 
 * 可转让债权相关查询
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:02:17  */
public interface SelectTransferableCreditsDao {
	
	
	/** 
	* selectTransferRules 查询逾期规则 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectTransferRules 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return TransferRulesEntity 返回类型 
	* @date 2016-3-31 上午11:04:44
	* @throws 
	*/
	public TransferRulesEntity selectTransferRules(Map<String, Object> map);
	
	
	/** 
	* selectTransferableCredits 分页 查询可转让债权
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectTransferableCredits 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<TransferableCreditsEntity> 返回类型 
	* @date 2016-3-31 上午11:05:38
	* @throws 
	*/
	public List<TransferableCreditsEntity> selectTransferableCredits(PageEntity paEntity);
}

