package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.BorrowingType;
import cn.membermng.model.BorrowingTypeInfo;
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.LegalPersonReanName;
import cn.membermng.model.RealNameAuth;


/***
* 会员借款认证
* 
* @author 李杰
* @since 
* @date 2016-3-23 上午11:35:02 
*
*/
public interface IBorrowingCertificationReadDao {

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	/***
	* 获取个人会员实名认证信息
	* 
	* @author 李杰
	* @Title: showAuthRealName
	* 
	* @param param
	* memberId			会员编号
	* 
	* @returnMap
	* realName			真实姓名<br>
	* personalIDCard	身份证号<br>
	* SexID				会员性别<br>
	* homeTown			籍贯<br>
	* Nation			民族<br>
	* endDate			有效期<br>
	* positive			身份证正面<br>
	* reverse			身份证反面<br>
	* status			认证状态<br>
	* @date 2016-3-24 上午10:13:00
	 */
	public RealNameAuth showAuthRealName(Map<String, Object> param);
	
	
	
	
	
	
	
	/***
	* 查看企业|个人会员通用认证信息
	* 
	* @author 李杰
	* @Title: showCurrencyAuth
	* @param param
	* memberId					会员编号<br>
	* memberType				会员类型<br>
	* typeId					借款认证项编号<br>
	* 
	* @returnMap
	* endDate					有效期<br>
	* attachName				认证附件名称、用逗号隔开<br>
	* attachPath				认证附件路径、用逗号隔开<br>
	* status					认证状态
	* @date 2016-3-24 下午4:33:00
	*/
	public CurrencyAuth showCurrencyAuth(Map<String,Object> param);

	

	
	
	
	/***
	* 获取个人住址认证信息
	* 
	* @author 李杰
	* @Title: showAuthAddress
	* @param param
	* memberId						会员编号
	* @return
	* attachName					附件名称<br>
	* endDate						认证有效期<br>
	* attachPath					附件路径<br>
	* Address						详细住址<br>
	* status						认证状态<br>
	* @Description: TODO
	* @date 2016-3-24 下午6:01:59
	 */
	public CurrencyAuth showAuthAddress(Map<String, Object> param);
	
	
	
	
	
	
	/***
	* 根据会员编号获取会员房产认证详细信息
	* 
	* @author 李杰
	* @Title: showAuthHousing
	* @param param
	* memberId						会员编号
	* @return
	* certificationId				认证记录编号<br>
	* endDate						有效期||登记日期<br>
	* attachName					附件名称<br>
	* attachPath					附件路径<br>
	* Address						位置信息<br>
	* status						认证状态<br>
	* @Description: TODO
	* @date 2016-3-25 上午9:16:08
	 */
	public List<CurrencyAuth> showAuthHousing(Map<String, Object> param);

	
	
	/**
	 * 根据认证编号获取会员房产认证详细信息
	 * TODO
	 * 创建日期：2016-5-5上午10:22:34
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	public CurrencyAuth showAuthHousingOne(Map<String, Object> param);
	
	
	

	
	
	/***
	* 查看个人会员车产认证信息
	* 
	* @author 李杰
	* @Title: showAuthProduction
	* @param memberId				会员编号
	* @return
	* certificationId				认证记录编号<br>
	* endDate						有效期<br>
	* attachName					附件名称<br>
	* attachPath					附件路径<br>
	* Brand							品牌<br>
	* Model							型号<br>F
	* licensePlate					车牌号<br>
	* Value							价值<br>
	* status						认证状态<br>
	* @date 2016-3-24 上午11:35:48
	*/
	public List<CurrencyAuth> showAuthProduction(long memberId);


	/**
	 * 查看个人会员车产认证信息
	 * TODO
	 * 创建日期：2016-5-5上午10:09:52
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	public CurrencyAuth showAuthProductionOne(Map<String, Object> param);

	
	
	
	
	/***
	* 查看个人婚姻认证信息
	* 
	* @author 李杰
	* @Title: showAuthMarriage
	* @param memberId				会员编号
	* @return
	* endDate						有效期<br>
	* attachName					附件名称<br>
	* attachPath					附件路径<br>
	* isMarried						婚姻状况<br>
	* status						认证状态<br>
	* @date 2016-3-24 下午1:55:52
	 */
	public CurrencyAuth showAuthMarriage(Long memberId);

	
	
	
	
	
	

	/***
	* 查看个人会员学历认证信息
	* 
	* @author 李杰
	* @Title: showAuthEducation		
	* @param memberId								会员编号
	* @return
	* attachName									附件名称
	* attachPath									附件路径
	* @Description: TODO
	* @date 2016-3-24 下午2:57:13
	 */
	public CurrencyAuth showAuthEducation(Map<String, Object> param);

	

	
	

/******************************************************************************************************************************************************************************************************************
* 
* 						a ha ha 我是华丽丽的分界线、下面的都是企业会员的了
* 
* 
*******************************************************************************************************************************************************************************************************************/

	

	/***
	* 根据企业会员序号获取营业执照信息
	* 
	* @author 李杰
	* @Title: showBusinessLicense
	* @param memberId							会员编号
	* @return
	* @date 2016-3-24 下午4:25:41
	 */
	public Map<String, Object> showBusinessLicense(long memberId);


	
	
	

	/***
	* 查看企业营业执照认证信息
	* 
	* @author 李杰
	* @Title: showCommercialLicense
	* @param param						
	* @return	
	* @Description: TODO
	* @date 2016-3-28 下午1:35:20
	*/
	public Map<String,Object> showCommercialLicense(Map<String,Object> param);
	
	

	
	
	
	
	/***
	* 显示组织机构认证信息
	* 
	* @author 李杰
	* @Title: showOrganizational
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2016-3-28 下午3:27:53
	 */
	public Map<String, Object> showOrganizational(Map<String,Object> param);

	
	
	


	/**
	* 查看开户许可认证
	* 
	* @author 李杰
	* @Title: showACcountOpening
	* @param param
	* @return
	* @date 2016-3-28 下午5:10:59
	 */
	public Map<String, Object> showACcountOpening(Map<String, Object> param);

	


	
	
	

	/***
	* 查看税务登记认证
	* 
	* @author 李杰
	* @Title: showTaxRegistration
	* @param param
	* @return
	* @date 2016-3-28 下午7:26:22
	 */
	public Map<String, Object> showTaxRegistration(Map<String, Object> param);

	

	
	
	
	


	/***
	* 查看批文认证
	* 
	* @author 李杰
	* @Title: showAuthApproval
	* @param memberId
	* @return
	* @date 2016-3-28 下午8:03:21
	 */
	public Map<String, Object> showAuthApproval(long memberId);


	/***
	* 根据会员获取会员认证信息列表
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-4-26 下午1:55:13
	 */
	public List<BorrowingType> getAllByMember(Map<String, Object> param);






	/***
	* 根据条件查询会员的借款项的认证信息
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-5-3 上午11:04:46
	 */
	public List<BorrowingTypeInfo> getAllByMemberAndLoanType(Map<String, Object> param);







	


	


	
}

