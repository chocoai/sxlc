package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;


/***
* 会员借款认证
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-23 上午11:35:02 
*
*/
public interface IBorrowingCertificationWriteDao {

	
	
	/***
	* 个人会员实名认证
	* 
	* @author 李杰
	* @Title: autnRealName
	* @param param
	* @return
	* @date 2016-3-23 上午11:42:35
	 */
	public int autnRealName(Map<String, Object> param);
	
	
	/***
	* 修改个人会员实名认证信息
	*
	* @author 李杰
	* @Title: editAuthRealName
	* @param param				
	* @return
	* @date 2016-3-24 下午3:39:41
	 */
	public int editAuthRealName(Map<String, Object> param);
	
	
	
	
	/***
	* 企业|个人会员通用认证
	* 
	* @author 李杰
	* @Title: currencyAuth
	* @param param
	* @return
	* @date 2016-3-23 下午5:13:24
	*/
	public int currencyAuth(Map<String,Object> param);
	
	

	/**
	* 修改企业|个人会员通用认证信息 
	* 
	* @author 李杰
	* @Title: editCurrencyAuth
	* @param param
	* @date 2016-3-24 下午5:31:56
	 */
	public int editCurrencyAuth(Map<String, Object> param);

	
	
	
	/***
	* 个人会员住址认证
	* 
	* @author 李杰
	* @Title: authAddress
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-23 下午5:15:01
	 */
	public int authAddress(Map<String,Object> param);
	
	
	
	/***
	* 修改个人住址认证信息
	*
	* @author 李杰
	* @Title: editAuthAddress
	* @param param
	* @Description: TODO
	* @date 2016-3-24 下午7:04:07
	*/
	public int editAuthAddress(Map<String, Object> param);
	
	
	
	
	/***
	* 个人会员房产认证
	* @author 李杰
	* @Title: authHousing
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-23 下午5:17:44
	 */
	public int authHousing(Map<String,Object> param);
	


	/***
	* 修改个人会员房产认证信息
	* 
	* @author 李杰
	* @Title: editAuthHousing
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-24 上午9:40:29
	 */
	public int editAuthHousing(Map<String, Object> param);

	
	
	
	

	
	/***
	* 个人会员车产认证
	* 
	* @author 李杰
	* @Title: authProduction
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-23 下午5:18:22
	 */
	public int authProduction(Map<String,Object> param);
	
	
	/***
	* 修改个人会员车产认证信息
	* 
	* @author 李杰
	* @Title: editAuthProduction
	* @param param
	* @return
	* @date 2016-3-24 上午11:36:33
	*/
	public int editAuthProduction(Map<String, Object> param);
	
	
	
	
	
	/***
	* 个人会员婚姻认证
	* 
	* @author 李杰
	* @Title: authMarriage
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-23 下午5:19:02
	 */
	public int authMarriage(Map<String,Object> param);

	
	
	
	/***
	* 修改个人婚姻认证信息
	* 
	* @author 李杰
	* @Title: editAuthMarriage
	* @param param
	* @Description: TODO
	* @date 2016-3-24 下午2:30:53
	 */
	public int editAuthMarriage(Map<String, Object> param);

	
	
	
	
	
	/***
	* 个人会员学历认证信息
	* 
	* @author 李杰
	* @Title: authEducation
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午2:55:48
	 */
	public int authEducation(Map<String, Object> param);


	
	/***
	* 修改该个人会员学历认证信息
	* 
	* @author 李杰
	* @Title: editAuthEducation
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午2:57:48
	 */
	public int editAuthEducation(Map<String, Object> param);

	
	

/******************************************************************************************************************************************************************************************************************
* 
* 						a ha ha 我是华丽丽的分界线、下面的都是企业会员的了
* 
* 
*******************************************************************************************************************************************************************************************************************/

	
	/***
	* 添加企业会员营业执照认证
	* 
	* @author 李杰
	* @Title: businessLicense
	* @param param
	* @return
	* @date 2016-3-24 下午4:24:29
	 */
	public int businessLicense(Map<String, Object> param);


	/***
	* 修改企业营业执照信息
	* 
	* @author 李杰
	* @Title: editBusinessLicense
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-24 下午4:26:31
	 */
	public int editBusinessLicense(Map<String, Object> param);

	
	
	
	
	/***
	* 添加企业营业执照认证
	* 
	* @author 李杰
	* @Title: commercialLicense
	* @param param
	* @Description: TODO
	* @date 2016-3-28 下午12:02:58
	 */
	public int commercialLicense(Map<String, Object> param);
	
	
	
	/***
	* 修改企业营业执照信息
	* @author 李杰
	* @Title: editCommercialLicense
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午1:36:41
	 */
	public int editCommercialLicense(Map<String,Object> param);

	
	
	
	/***
	* 添加企业会员组织机构认证
	* 
	* @author 李杰
	* @Title: organizational
	* @param param
	* @date 2016-3-28 下午3:27:30
	 */
	public int organizational(Map<String, Object> param);
	
	

	/***
	* 修改会员组织机构认证信息
	* 
	* @author 李杰
	* @Title: editOrganizational
	* @param param
	* @date 2016-3-28 下午3:28:24
	 */
	public int editOrganizational(Map<String, Object> param);

	
	
	
	/***
	* 
	* @author 李杰
	* @Title: accountOpening
	* @param param
	 * @return 
	* @Description: TODO
	* @date 2016-3-28 下午5:07:51
	 */
	public int accountOpening(Map<String, Object> param);


	
	/***
	* 修改开户许可认证
	* 
	* @author 李杰
	* @Title: editAccountOpening
	* @param param
	* @return
	* @date 2016-3-28 下午5:13:29
	 */
	public int editAccountOpening(Map<String, Object> param);

	
	
	
	/***
	* 添加税务登记认证
	* 
	* @author 李杰
	* @Title: taxRegistration
	* @param param
	* @return
	* @date 2016-3-28 下午7:24:24
	 */
	public int taxRegistration(Map<String, Object> param);

	
	
	/***
	* 修改税务登记认证
	* 
	* 
	* @author 李杰
	* @Title: editTaxRegistration
	* @param param
	* @return
	* @date 2016-3-28 下午7:27:56
	 */
	public int editTaxRegistration(Map<String, Object> param);

	
	
	
	
	/***
	* 添加批文认证
	* 
	* @author 李杰
	* @Title: authApproval
	* @param param
	* @return
	* @date 2016-3-28 下午8:02:38
	 */
	public int authApproval(Map<String, Object> param);

	
	
	/***
	* 修改批文认证
	* 
	* @author 李杰
	* @Title: editAuthApproval
	* @param param
	* @return
	* @date 2016-3-28 下午8:05:59
	 */
	public int editAuthApproval(Map<String, Object> param);

	
	
	
	
	


	


	
}

