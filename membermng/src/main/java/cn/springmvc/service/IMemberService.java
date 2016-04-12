package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.CompanyInfo;
import cn.membermng.model.IntegralRecords;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.PersonalBaseInfo;
import cn.membermng.model.RadPackage;




/***
 * 会员相关业务
 * @author LiJie
 *
 */
public interface IMemberService {

	
	
	/***
	 * 个人会员注册
	 * @param member						会员注册信息
	 * @param baseInfo						会员注册基本信息
	 * @return	-1用户名重复、-2电话号码重复、-3邀请码无效、0注册成功
	 */
	public int individualMember(MemberInfo member,PersonalBaseInfo baseInfo);
	
	
	
	/***
	 * 企业会员注册
	 * @param member
	 * @param companyInfo
	 * @return
	 */
	public int corporateMember(MemberInfo member,CompanyInfo companyInfo);



	/***
	 * 会员登录
	 * @param userName						会员登录
	 * @param password						登录密码
	 * @param userType						会员类型
	 * @param ip							登录IP
	 * @param country						国家
	 * @param region						地区
	 * @param province						省份
	 * @param city							市区
	 * @param area							地区
	 * @param ISP							网络运营商
	 * @param sourceUrl 					访问来源
	 * @return	0登录成功  -1登录失败
	 */
	public int login(String userName, String password, int userType,String ip,String[] ipInfo,String sourceUrl);

	
	
	/***
	 * 检查电话号码是否存在
	 * @param phone							会员电话号码
	 * @return
	 */
	public int chechPhone(String phone);
	
	
	/***
	 * 检查用户名的个数
	 * @param userName
	 * @return
	 */
	public int countName(String userName);
	
	
	/***
	 * 检查会员邀请码的个数
	 * @param invitateCode
	 * @return
	 */
	public int countInvitateCode(String invitateCode);
	

	/***
	* 根据会员编号获取会员信息
	* 
	* @author 李杰
	* @Title: memberPersonalInfo
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午5:03:57
	 */
	public MemberInfo memberPersonalInfo(long memberId);

	/***
	* 修改个人会员
	* 
	* 
	* @author 李杰
	* @Title: editMemberPersonalInfo
	* @param memberId							会员编号
	* @param sexid								性别
	* @param qqNumber							QQ号
	* @param homeTown							户籍地址
	* @param currAddress						现居地址
	* @param provinceId							省
	* @param cityId								市
	* @param countyId							县
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午7:39:49
	 */
	public int editMemberPersonalInfo(long memberId,int sexid,String qqNumber,String homeTown,String currAddress,int provinceId,int cityId,int countyId);
	
	
	
	/***
	* 根据编号获取企业会员信息
	* 
	* @author 李杰
	* @Title: memberComplanyInfo
	* @param memberId						会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午7:28:52
	 */
	public MemberInfo memberComplanyInfo(long memberId);
	
	
	/***
	* 修改企业会员
	*  
	*  
	* @author 李杰
	* @Title: editMemberComplanyInfo
	* @param provinceId								省
	* @param cityId									市
	* @param countyId								县
	* @param contactsName							联系人姓名
	* @param contactsPhone							联系人电话
	* @param contactQQ								联系人QQ
	* @param contactEmail							联系人邮箱
	* @param companyProfile							公司简介
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午7:42:10
	 */
	public int editMemberComplanyInfo(long memberId,int provinceId,int cityId,int countyId,String contactsName,String contactsPhone,String contactQQ,String contactEmail,String companyProfile);
	
	
	/***
	* 获取好友邀请列表
	* 
	* @author 李杰
	* @Title: friendInvitation
	* @param entity
	* @return
	* @Description: TODO
	* @date 2015-9-1 上午9:35:21
	 */
	public List<MemberInfo> friendInvitation(PageEntity entity);
	
	
	/***
	* 获取会员积分信息
	* 
	* @author 李杰
	* @Title: points
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2015-9-1 上午9:37:00
	 */
	public Map<String,Object> points(long memberId,int memberType);
	
	
	/***
	* 获取积分记录
	* 
	* @author 李杰
	* @Title: addPoints
	* @param memberId
	* @param memberType
	* @return
	* @Description: TODO
	* @date 2016-3-30 上午10:43:04
	 */
	public List<IntegralRecords> addPoints(PageEntity entity);
	
	
	/***
	* 获取会员的红包信息
	* 
	* @author 李杰
	* @Title: myRedpackage
	* @param memberType						会员类型
	* @param memberId						会员编号
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午1:43:01
	 */
	public MyRedPackage myRedpackage(int memberType,long memberId);
	
	
	
	
	
	/***
	* 获取一个会员的红包列表
	* 
	* @author 李杰
	* @Title: redPackages
	* @param memberType
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午2:05:05
	 */
	public List<RadPackage> redPackages(PageEntity entity);



	
	/***
	* 我的代金券
	* myVouchers(这里用一句话描述这个方法的作用)
	* @author 李杰
	* @Title: myVouchers
	* @param memberId
	* @param memberType
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午5:39:09
	 */
	public MemberVouchers myVouchers(long memberId, int memberType);



	/***
	* 我的代金券列表
	* vouchers(这里用一句话描述这个方法的作用)
	* TODO(描述)
	* @author 李杰
	* @Title: vouchers
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午5:40:18
	 */
	public List<MemberVouchers> vouchers(PageEntity entity);
	
	
	
	
	
	
	
	
}
