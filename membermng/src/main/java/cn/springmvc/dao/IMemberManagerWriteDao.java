package cn.springmvc.dao;

import java.util.Map;




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



	
}
