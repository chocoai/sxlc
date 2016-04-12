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
	
	
	
	
	
}
