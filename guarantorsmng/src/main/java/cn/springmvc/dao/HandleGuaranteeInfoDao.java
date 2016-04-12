
package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import net.sf.jsqlparser.statement.update.Update;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;





/** 
 * 保荐机构操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午11:31:59  */
public interface HandleGuaranteeInfoDao {
	
	/** 
	* handleGuaranteeInfo 添加或修改担保机构信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleGuaranteeInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-21 上午11:33:39
	* @throws 
	*/
	public Map<String, Object> handleGuaranteeInfo(Map<String, Object> map);
	
	
	/** 
	* deleteOrStopGuaranteeInfo 删除或启用停用 担保机构
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteOrStopGuaranteeInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:34:20
	* @throws 
	*/
	public int deleteOrStopGuaranteeInfo(Map<String, Object> map);
	
	
	/** 
	* insertGuaranteeCertificate 添加担保机构证件 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeCertificate 
	* @Description: TODO 
	* @param @param list
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:35:48
	* @throws 
	*/
	public int insertGuaranteeCertificate(List<ManagementCertificateEntity> list);
	
	
	/** 
	* deleteGuaranteeCertificate 根据担保机构id删除所有证件信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteGuaranteeCertificate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:36:38
	* @throws 
	*/
	public int deleteGuaranteeCertificate(Map<String, Object> map);
	
	
	/** 
	* deleteOrStopManagementInfo 根据资产管理方id 删除或启用停用资产管理方
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteOrStopManagementInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:38:24
	* @throws 
	*/
	public int deleteOrStopManagementInfo(Map<String, Object> map);
	
	
	/** 
	* handleManagementInfo 添加或修改资产管理方信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleManagementInfo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-21 上午11:39:17
	* @throws 
	*/
	public Map<String, Object> handleManagementInfo(Map<String, Object> map);
	
	
	/** 
	* insertManagementCertificate 添加资产管理方证件 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertManagementCertificate 
	* @Description: TODO 
	* @param @param entities
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:42:01
	* @throws 
	*/
	public int insertManagementCertificate(List<ManagementCertificateEntity> entities);
	
	
	/** 
	* deleteManagementCertificate 根据资产管理方id删除所有证件信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteManagementCertificate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 上午11:43:21
	* @throws 
	*/
	public int deleteManagementCertificate(Map<String, Object> map);
	
	
	/** 
	* insertGuaranteeBorrowing(添加担保机构担保借款范围 ) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeBorrowing 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:11:37
	* @throws 
	*/
	public int insertGuaranteeBorrowing(Map<String, Object> map);
	
	/** 
	* updateGuaranteeBorrowingByID(根据保荐机构id修改担保机构担保借款范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateGuaranteeBorrowingByID 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:12:10
	* @throws 
	*/
	public int updateGuaranteeBorrowingByID(Map<String, Object> map);
	
	/** 
	* insertGuaranteePeriod(添加担保机构期限范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteePeriod 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:13:26
	* @throws 
	*/
	public int insertGuaranteePeriod(Map<String, Object> map);
	
	/** 
	* updateGuaranteePeriodByID(根据保荐机构id,期限类型修改担保机构担保借款范围) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateGuaranteePeriodByID 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:14:00
	* @throws 
	*/
	public int  updateGuaranteePeriodByID(Map<String, Object> map);
	
	
	/** 
	* insertGuaranteeRelational(添加担保机构担保类型) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertGuaranteeRelational 
	* @Description: TODO 
	* @param @param list
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:15:46
	* @throws 
	*/
	public int insertGuaranteeRelational(List<GuaranteeRelationalEntity> list);
	
	
	/** 
	* deleteGuaranteeRelationalByID 根据担保机构id删除担保机构担保类型 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteGuaranteeRelationalByID 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-21 下午5:18:29
	* @throws 
	*/
	public int deleteGuaranteeRelationalByID(Map<String, Object> map);
}

