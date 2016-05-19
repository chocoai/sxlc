package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.MemberResetPwdEntity;




/***
 * 会员管理数据访问层
 * @author LiJie
 *
 */
public interface IMemberManagerWriteDao {

	
	
	
	
	

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
	
	/**
	 * 取消黑名单
	 * TODO
	 * 创建日期：2016-5-5下午9:23:24
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return Map<String,Object>
	 */
	public  Map<String, Object> removeBlack(Map<String, Object> param);	  

	
	/**
	 * 会员密码重置
	 * TODO
	 * 创建日期：2016-5-5下午7:08:31
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return Map<String,Object>
	 */
	public Map<String, Object> memberResetPwd(Map<String, Object> param);	

	/**
	 * 添加黑名单限制
	 * TODO
	 * 创建日期：2016-5-10上午10:41:33
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int addLimitList (int[] str);

	/**
	 * 删除黑名单限制
	 * TODO
	 * 创建日期：2016-5-10上午10:42:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int deleteLimitList();
	/**
	 * 修改管理员密码
	 * TODO
	 * 创建日期：2016-5-12下午2:57:48
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int updateAdminPwd(Map<String, Object> param);
	
	/**
	 * 修改我的邀请人
	 * TODO
	 * 创建日期：2016-5-18下午4:31:28
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	public int updateMyInvete(Map<String,Object> map);

}
