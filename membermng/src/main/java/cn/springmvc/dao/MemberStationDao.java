

/** 
* @Title: MemberStationDao.java 
* @Package cn.memberstation.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午2:40:20 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List; 

import cn.membermng.model.MemberStationLetterEntity;

/** 
 * @author 刘利 
 * @Description: 会员站内信写
 * @since 
 * @date 2016-3-29 下午2:40:20  */

public interface MemberStationDao {
	/**
	 * 批量删除发送方信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  list 站内信ID 列表
	 * @param @return 设定文件 
	 * @return int 返回类型  0失败，大于0成功,-1数据为空
	 * @date 2016-3-29 下午4:29:28
	 */
	public int deleteSendStationLetter(List<Integer> list);
	/**
	 * 批量删除接收方信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  list 站内信ID 列表
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，大于0成功,-1数据为空
	 * @date 2016-3-29 下午4:30:47
	 */
	public int deleteRecStationLetter(List<Integer> list);
	/**
	 * 批量标记为已读 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  list 站内信ID 列表
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，大于0成功,-1数据为空
	 * @date 2016-3-29 下午4:32:19
	 */
	public int updateRecStationReadlist(List<Integer> list);
	/**
	 * 批量标记为未读
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  list 站内信ID 列表
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，大于0成功,-1数据为空
	 * @date 2016-3-29 下午4:33:14
	 */
	public int updateRecStationNotReadlist(List<Integer> list);
	/**
	 * 发送站内信 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  memberStationLetterEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功,-1数据为空
	 * @date 2016-3-29 下午4:37:46
	 */
	public int addStationLetter(MemberStationLetterEntity memberStationLetterEntity);
	/**
	 * 查看后标记为已读
	 * @author 刘利   
	 * @Description: TODO 
	 * @param letterID
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-29 下午5:47:01
	 */
	public int updateRecStationRead(int letterID);
}

