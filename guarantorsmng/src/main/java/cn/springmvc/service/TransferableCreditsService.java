
package cn.springmvc.service; 

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
import cn.springmvc.model.TransferableCreditsEntity;
import cn.springmvc.model.TransferableCreditsFangKuanEntity;



/** 
 * 债权转让申请相关操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:11:22  */
public interface TransferableCreditsService {
	/** 
	* selectTransferableCredits 查询可转让债权
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectTransferableCredits 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<TransferableCreditsEntity> 返回类型 
	* @date 2016-3-31 上午11:05:38
	*/
	public List<TransferableCreditsEntity> selectTransferableCredits(PageEntity page);
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
	*/
	public int creditorTransApp(Map<String, Object> map);
	
	
	/** 
	* transferableCreditsFangKuan(这里用一句话描述这个方法的作用) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: transferableCreditsFangKuan 
	* @Description: TODO 
	* @param @param paEntity
	* @param @return 设定文件 
	* @return List<TransferableCreditsFangKuanEntity> 返回类型 
	* @date 2016-5-18 上午10:15:19
	* @throws 
	*/
	public List<TransferableCreditsFangKuanEntity> transferableCreditsFangKuan(PageEntity paEntity);
}


