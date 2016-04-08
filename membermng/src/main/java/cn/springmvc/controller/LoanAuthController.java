package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.Map;

import product_p2p.kit.StringUtil.StringUtils;
import cn.springmvc.service.IBorrowingCertificationServer;



/***
* 个人中心-借款认证控制器
* 
* @author 李杰
* @Description:
* @since 
* @date 2016-3-23 上午10:38:09 
*
*/
public class LoanAuthController {

	private IBorrowingCertificationServer borrowingCertificationServer;
	
	
	/***
	* 个人中心-借款认证列表
	* 显示会员的认证列表信息
	* @author 李杰
	* @Title  borrowingCertifications
	* @return
	* @date 2016-3-23 上午10:42:26
	*/
	public String borrowingCertifications(){
		
		
		
		return null;
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/***
	* 个人会员实名认证 
	* @author 李杰
	* @Title authRealName
	* @param realName					真实姓名
	* @param sex						性别
	* @param national					民族
	* @param idCard						身份证号
	* @param birthplace					籍贯
	* @param positive					身份证正面
	* @param reverse					身份证反面
	* @return
	* @date 2016-3-23 上午11:01:18
	 */
	public String authRealName(String realName,Integer sex,Integer national,String idCard,String birthplace,String positive,String reverse){
		Map<String,Object> message = new HashMap<String, Object>();
		if(realName == null || !StringUtils.checkUserName(realName)){
			message.put("realName", "请输入有效用户名");
		}
		if(sex == null){
			message.put("sex", "请选择性别");
		}
		if(national == null){
			message.put("national", "请选择名族");
		}
		if(idCard == null || StringUtils.checkIdCard(idCard)){
			message.put("idCard", "请输入有效身份证");
		}
		if(birthplace == null || birthplace.trim().length() < 2){
			message.put("birthplace", "请输入正确籍贯");
		}
		if(positive == null){
			message.put("positive", "请选择身份证正面");
		}
		if(reverse == null){
			message.put("reverse", "请选择身份证反面");
		}
		
		int result = borrowingCertificationServer.authRealName(0L,realName,sex,national,idCard,birthplace,positive,reverse);
		if(result == 0){
			
		}
		
		return null;
		
	}
	
	/***
	* 查看个人会员实名认证
	* 
	* @author 李杰
	* @Title: showRealName
	* @return
	* @date 2016-3-24 上午9:16:09
	 */
	public String showAuthRealName(){
		Long memberId = 1L;
		Map<String,Object> authInfo = borrowingCertificationServer.showAuthRealName(memberId);
		
		return null;
	}
	
	/***
	* 个人会员实名认证修改
	* 
	* @author 李杰
	* @Title: editAuthRealName
	* @param realName						真实姓名
	* @param sex							性别
	* @param national						名族
	* @param idCard							身份证号
	* @param birthplace						籍贯
	* @param positive						身份证正面
	* @param reverse						身份证反面
	* @return
	* @date 2016-3-24 上午9:18:32
	 */
	public String editAuthRealName(String realName,Integer sex,Integer national,String idCard,String birthplace,String positive,String reverse){
		int result = borrowingCertificationServer.editAuthRealName(1L,realName, sex, national, idCard, birthplace, positive, reverse);
		return null;
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/***
	* 企业|个人通用认证 
	* 
	* @author 李杰
	* @Title: currencyAuth
	* @param enclosure						附件多个用逗号隔开
	* @param endTime						附件有效期|登记日期
	* @param typeId							认证类型编号
	* @return
	* @date 2016-3-24 上午9:24:11
	*/
	public String currencyAuth(String enclosure,String endTime,Integer typeId){
		
		return null;
	}
	
	/***
	* 查看企业|个人通用认证
	* 
	* @author 李杰
	* @Title: showCurrencyAuth
	* @param typeId					认证类型编号
	* @return
	* @date 2016-3-24 上午9:29:46
	 */
	public String showCurrencyAuth(Integer typeId){
		
		return null;
	}
	
	/***
	* 企业|个人通用认证修改
	* 
	* @author 李杰
	* @Title: editCurrencyAuth
	* @param enclosure
	* @param endTime
	* @param typeId
	* @return
	* @date 2016-3-24 上午9:31:13
	 */
	public String editCurrencyAuth(String enclosure,String endTime,Integer typeId){
	
		return null;
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	/***
	* 个人会员住址认证
	* 
	* @author 李杰
	* @Title: authAddress
	* @param address						详细地址
	* @param endTime						认证时间
	* @param enclosure						附件信息
	* @return
	* @date 2016-3-24 上午9:34:05
	 */
	public String authAddress(String address,String endTime,String enclosure){
	
		return null;
	}
	
	/***
	* 查看个人会员住址认证信息
	* 
	* @author 李杰
	* @Title: showAuthAddress
	* @return
	* @date 2016-3-24 上午9:35:12
	 */
	public String showAuthAddress(){
		
		return null;
	}
	
	/***
	* 修改个人会员住址认证洗洗脑
	* 
	* @author 李杰
	* @Title: editAuthAddress
	* @param address							详细住址信息
	* @param endTime							登记时间
	* @param enclosure							附件信息,多个用逗号隔开
	* @return
	* @date 2016-3-24 上午9:36:19
	 */
	public String editAuthAddress(String address,String endTime,String enclosure){
		
		return null;
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/***
	* 个人会员房产认证
	* 
	* @author 李杰
	* @Title: authHousing
	* @param iaddress							房产详细地址
	* @param iArea								面积
	* @param ivalue								价值
	* @param endTime							登记日期
	* @param enclosure							附件、多个用逗号隔开
	* @return
	* @date 2016-3-24 上午9:38:52
	 */
	public String authHousing(String iaddress,String iArea,String ivalue,String endTime,String enclosure){
		
		return null;
	}
	
	/***
	* 查看个人会员房产认证 
	*
	* @author 李杰
	* @Title: showAuthHousing
	* @return
	* @date 2016-3-24 上午9:47:36
	 */
	public String showAuthHousing(){
		
		return null;
	}
	
	/***
	* 修改个人房产认证信息
	* 
	* editAuthHousing(这里用一句话描述这个方法的作用)
	* @author 李杰
	* @Title: editAuthHousing
	* @param iaddress					房产详细地址信息
	* @param iArea						面积
	* @param ivalue						价值
	* @param endTime					登记时间
	* @param enclosure					附件、多个用逗号隔开
	* @return
	* @date 2016-3-24 上午9:50:13
	 */
	public String editAuthHousing(String iaddress,String iArea,String ivalue,String endTime,String enclosure){
		
		return null;
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	/***
	* 个人会员车产认证
	* 
	* @author 李杰
	* @Title: authProduction
	* @param iBrand
	* @param iModel
	* @param iLicensePlate
	* @param ivalue
	* @param endTime
	* @param enclosure
	* @return
	* @date 2016-3-24 上午9:54:49
	*/
	public String authProduction(String iBrand,String iModel,String iLicensePlate,String ivalue,String endTime,String enclosure){
		
		return null;
	}
	
	/***
	* 查看个人会员车产认证
	*
	* @author 李杰
	* @Title: showAuthProduction
	* @return
	* @date 2016-3-24 上午9:55:48
	 */
	public String showAuthProduction(){
		
		return null;
	}
	
	/***
	* 修改个人会员认证信息
	* 
	* @author 李杰
	* @Title: editAuthProduction
	* @param iBrand
	* @param iModel
	* @param iLicensePlate
	* @param ivalue
	* @param endTime
	* @param enclosure
	* @return
	* @date 2016-3-24 上午9:56:49
	 */
	public String editAuthProduction(String iBrand,String iModel,String iLicensePlate,String ivalue,String endTime,String enclosure){
		
		return null;
	}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/***
	* 个人会员婚姻认证
	* 
	* @author 李杰
	* @Title: authMarriage
	* @param integer					婚姻状态
	* @param endTime					认证时间
	* @param enclosure					附件、多个用逗号隔开
	* @return
	* @date 2016-3-24 上午9:58:22
	 */
	public String authMarriage(Integer integer,String endTime,String enclosure){
		
		return null;
	}
	
	/***
	* 查看个人会员婚姻认证
	* 
	* @author 李杰
	* @Title: showAuthMarriage
	* @return
	* @date 2016-3-24 上午9:58:22
	 */
	public String showAuthMarriage(){
		
		return null;
	}

	/***
	* 修改个人会员婚姻认证
	* 
	* @author 李杰
	* @Title: editAuthMarriage
	* @param integer					婚姻状态
	* @param endTime					认证时间
	* @param enclosure					附件、多个用逗号隔开
	* @return
	* @date 2016-3-24 上午9:58:22
	 */
	public String editAuthMarriage(Integer integer,String endTime,String enclosure){
		
		return null;
	}

//====================================================================================================================================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

