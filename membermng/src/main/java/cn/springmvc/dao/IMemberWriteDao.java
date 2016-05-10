package cn.springmvc.dao;

import java.util.Map;


/**
 * 会员数据访问层
 * @author LiJie
 *
 */
public interface IMemberWriteDao {

	
	
	/****
	 * 会员注册
	 * @param param						会员信息
	 * @return
	 */
	public int individualMember(Map<String,Object> param);

	
	/***
	 * 会员登录
	 * @param param						登录信息
	 * @return
	 */
	public int login(Map<String, Object> param);




	/***
	* 修改个人会员信息
	* 
	* @author 李杰
	* @Title: editMemberPersonalInfo
	* @param param
	* @return
	* @date 2016-3-29 下午2:22:39
	 */
	public int editMemberPersonalInfo(Map<String,Object> param);

	/***
	* 修改企业会员信息
	* 
	* @author 李杰
	* @Title: editMemberPersonalInfo
	* @param param
	* @return
	* @date 2016-3-29 下午2:22:39
	 */
	public int editMemberComplanyInfo(Map<String,Object> param);


	/***
	* 添加好友
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-5-6 下午1:52:29
	 */
	public int applyAddFriends(Map<String, Object> param);
	
	/**
	 * 同意好友申请
	* agreeAapplyForFriend
	* @author 邱陈东  
	* * @Title: agreeAapplyForFriend 
	* @param @param param
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午6:10:58
	* @throws
	 */
	public int agreeAapplyForFriend(Map<String, Object> param);


	/***
	* 确认收货
	* 
	* @author 李杰
	* @param param
	* @return
	* @date 2016-5-9 上午10:08:41
	 */
	public int confirmReceipt(Map<String, Object> param);
	
}
