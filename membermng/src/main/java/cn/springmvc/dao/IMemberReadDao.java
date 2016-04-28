package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.RadPackage;
import cn.membermng.model.SecurityInfo;


/**
 * 会员数据访问层
 * @author LiJie
 *
 */
public interface IMemberReadDao {

	
	
	/***
	 * 统计当前电话号码的个数
	 * @param param
	 * @return
	 */
	public int countPhone(Map<String,Object> param);
	
	
	
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
	* 根据编号获取个人会员信息
	*
	* @author 李杰
	* @Title: memberPersonalInfo
	* @return
	* @date 2016-3-29 上午10:54:24
	 */
	public MemberInfo memberPersonalInfo(Map<String,Object> param);
	
	/***
	* 根据编号获取企业会员信息
	*
	* @author 李杰
	* @Title: memberPersonalInfo
	* @return
	* @date 2016-3-29 上午10:54:24
	 */
	public MemberInfo memberComplanyInfo(Map<String,Object> param);


	
	/***
	* 分页获取好友邀请信息 
	* 
	* @author 李杰
	* @Title: friendInvitation
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午2:28:02
	 */
	public List<MemberInfo> friendInvitation(PageEntity entity);
	
	/***
	* 会员积分信息
	* 
	* @author 李杰
	* @Title: points
	* @param memberId
	* @param memberType
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午4:01:01
	 */
	public Map<String,Object> points(Map<String,Object> param);
	
	/***
	* 会员获取积分记录
	* 
	* @author 李杰
	* @Title: addPoints
	* @param memberId					会员编号
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午4:04:51
	 */
	public List addPoints(PageEntity entity);
	
	/***
	* 会员消费积分记录
	* 
	* @author 李杰
	* @Title: addPoints
	* @param memberId					会员编号
	* @param memberType					会员类型
	* @return
	* @Description: TODO
	* @date 2016-3-29 下午4:04:51
	 */
	public List rePoints(Map<String,Object> param);

	
	
	
	/***
	* 获取我的红包信息
	* 
	* @author 李杰
	* @Title: myRedPackage
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午3:42:30
	 */
	public MyRedPackage myRedPackage(Map<String, Object> param);


	/***
	* 获取我的红包记录
	* 
	* @author 李杰
	* @Title: redPackages
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午3:43:03
	 */
	public List<RadPackage> redPackages(PageEntity entity);


	/***
	* 获取我的代金券
	* 
	* @author 李杰
	* @Title: myVouchers
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午7:31:25
	 */
	public MemberVouchers myVouchers(Map<String, Object> param);


	/***
	* 获取我的代金券列表
	* myVouchers(这里用一句话描述这个方法的作用)
	* TODO(描述)
	* @author 李杰
	* @Title: myVouchers
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-30 下午7:32:33
	 */
	public List<MemberVouchers> vouchers(PageEntity entity);


	/**
	* 查询会员信息
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-4-26 上午10:36:37
	 */
	public MemberInfo findMemberInfoByParam(Map<String, Object> param);


	
	/***
	* 获取安全中心信息
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-4-26 下午6:52:20
	 */
	public SecurityInfo securityInfo(Map<String, Object> param);



	
}
