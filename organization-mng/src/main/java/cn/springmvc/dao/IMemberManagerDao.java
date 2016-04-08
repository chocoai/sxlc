package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.MemberAttestInfo;
import cn.springmvc.model.MemberBankCard;
import cn.springmvc.model.MemberInfo;
import cn.springmvc.model.MemberThirdInfo;




/***
 * 会员管理数据访问层
 * @author LiJie
 *
 */
public interface IMemberManagerDao {

	
	
	/***
	 * 根据条件查询
	 * @param entity
	 * @return
	 */
	public List<MemberInfo> getMembersByParam(PageEntity entity);

	
	
	/***
	 * 更具会员编号获取会员详细信息
	 * @param memberId
	 * @return
	 */
	public MemberInfo memberInfoById(Long memberId);
	
	
	
	/****
	 * 获取会员第三方账户开通情况
	 * @param param
	 * @return
	 */
	public MemberThirdInfo memberThirdInfo(Map<String,Object> param);
	
	
	/***
	 * 会员资料认证信息
	 * @param param
	 * @return
	 */
	public MemberAttestInfo memberAttestInfo(Map<String,Object> param);
	
	
	
	/***
	 * 会员借款信用统计
	 * @param param
	 * @return
	 */
	public Map<String,Object> borrowers(Map<String,Object> param);
	
	
	/***
	 * 会员投资信息统计
	 * @param param
	 * @return
	 */
	public Map<String,Object> investment(Map<String,Object> param);
	
	
	/***
	* 查看会员的交易记录 
	* @author 李杰 
	* @Title: blotter 
	* @Description:管理员查看会员信息的时候查看会员的交易记录
	* @return List<T> 返回类型 
	* @date 2016-3-18 下午7:08:46
	* @throws
	 */
	//public List<T> blotter(Map<String,Object> param);
	
	
	
	/***
	 * 查看会员的银行卡列表
	* @author 李杰 
	* @Title: bankCards 
	* @Description: 管理员查看该会员的银行卡列表
	* @param @param param			查询条件
	* @param @return 设定文件 
	* @return List<T> 返回类型 
	* @date 2016-3-18 下午7:10:48
	* @throws
	 */
	public List<MemberBankCard> bankCards(Map<String,Object> param);
	
	
	
	
	
	
	/***
	* 重置一个会员的登陆密码
	* @author 李杰 
	* @Title: resetPassword 
	* @Description: 如果某个会员的密码忘记了，那么管理员即可通过此功能重新设置用户密码、
	* @param param	参数
	* @return int 返回类型 
	* @date 2016-3-18 下午7:12:29
	* @throws
	 */
	public int resetPassword(Map<String,Object> param);
	
	
	
	/**
	* 查看会员邀请的会员
	* @author 李杰 
	* @Title: invitationsByParam 
	* @Description:更具条件查看该会员邀请的注册的会员
	* @param @param param
	* @param @return 设定文件 
	* @return List<MemberInfo> 返回类型 
	* @date 2016-3-18 下午7:17:02
	* @throws
	 */
	public List<MemberInfo> invitationsByParam(Map<String,Object> param);



	/**
	* 拉黑会员
	* @author 李杰 
	* @Title  pullBlack 
	* @param  id					管理员编号(操作人编号)
	* @param  memberId				会员编号(操作对象序号)
	* @param  referer 				请求来源
	* @param  ipaddress 			请求IP地址
	* @param  mac 					客户端MAC地址
	* @return int 返回类型 
	* @date   2016-3-21 上午10:51:13
	* @throws
	 */
	public int pullBlack(Map<String,Object> param);



	
	/***
	* 根据条件查询VIP会员
	* @author 李杰 
	* @Title: vipMembersByParam 
	* @Description: TODO 
	* @param @param param
	* @param @return 设定文件 
	* @return List<MemberInfo> 返回类型 
	* @date 2016-3-21 下午5:28:09
	*/
	public List<MemberInfo> vipMembersByParam(Map<String, Object> param);



	/***
	* 更具条件查询注册会员列表
	* @author 李杰
	* @param param					查询条件
	* @return
	* @date 2016-3-22 上午11:22:11
	 */
	public List<MemberInfo> registers(Map<String, Object> param);



	
	/***
	* 更具条件查询认证会员 
	* authenticationMember(管理员查询会员注册后认证至少一项后，没有借过款、没有投过资的)
	* @author 李杰
	* @Title: authenticationMember
	* @param param					查询条件
	* @return
	* @Description: TODO
	* @date 2016-3-22 下午2:09:52
	 */
	public List<MemberInfo> authenticationMember(Map<String, Object> param);



	/***
	* 更具条件查询至少借款过一次的会员
	* 
	* @author 李杰
	* @Title loanMember
	* @param param					查询条件
	* @return
	* @date 2016-3-22 下午2:52:53
	 */
	public List<MemberInfo> loanMember(Map<String, Object> param);



	/***
	* 查询至少投过一次资的会员
	* 
	* @author 李杰
	* @Title investmentMember
	* @param param					查询条件
	* @return
	* @date 2016-3-22 下午4:30:02
	*/
	public List<MemberInfo> investmentMember(Map<String, Object> param);



	
	/***
	* 会员黑名单
	* 
	* @author 李杰
	* @Title blackList
	* @param param					查询条件
	* @return
	* @date 2016-3-22 下午5:49:18
	*/
	public List<MemberInfo> blackList(Map<String, Object> param);
	
}
