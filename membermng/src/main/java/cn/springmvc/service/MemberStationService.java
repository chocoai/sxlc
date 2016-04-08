

/** 
* @Title: MemberStationService.java 
* @Package cn.memberstation.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午4:50:24 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.MemberStationLetterEntity;

import product_p2p.kit.pageselect.PageEntity;
 

/** 
 * @author 刘利 
 * @Description:会员站内信 
 * @since 
 * @date 2016-3-29 下午4:50:24  */

public interface MemberStationService {
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
	 * @param @param memberStationLetterEntity
	 * @param @return 设定文件 
	 * @return int 返回类型  0失败，1成功,-1数据为空
	 * @date 2016-3-29 下午4:37:46
	 */
	public int addStationLetter(MemberStationLetterEntity memberStationLetterEntity);
	/**
	 * 根据会员ID查询会员发件箱信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map{memberID 会员ID ,keys}
	 * @param @return 设定文件 
	 * @return List<MemberStationLetterEntity> 返回类型 
	 * @date 2016-3-29 下午4:11:47
	 */
   public List<MemberStationLetterEntity> selectSendLetter(PageEntity pageEntity);
   /**
    * 根据会员ID查询会员收件箱信息，筛选已读未读
    * @author 刘利   
    * @Description: TODO 
    * @param  map{memberID 会员ID ,keys,isRead(是否阅读 0：否 1：是 -1:全部)}
    * @param @return 设定文件 
    * @return List<MemberStationLetterEntity> 返回类型 
    * @date 2016-3-29 下午4:13:41
    */
   public List<MemberStationLetterEntity> selectRecLetter(PageEntity pageEntity);
   /**
    * 根据站内信ID查看发件箱站内信详情
    * @author 刘利   
    * @Description: TODO 
    * @param   letterID  站内信ID
    * @param @return 设定文件 
    * @return MemberStationLetterEntity 返回类型 
    * @date 2016-3-29 下午4:16:16
    */
   public MemberStationLetterEntity  selectSendLetterDetail(Map<String,Object> map);
   /**
    * 根据站内信ID查看收件箱站内信详情
    * @author 刘利   
    * @Description: TODO 
    * @param  letterID 站内信ID
    * @param @return 设定文件 
    * @return MemberStationLetterEntity 返回类型 
    * @date 2016-3-29 下午4:17:57
    */
   public MemberStationLetterEntity  selectRecLetterDetail(Map<String,Object> map);
   /**
    * 根据用户名查询会员ID
    * @author 刘利   
    * @Description: TODO 
    * @param logname
    * @param @return 设定文件 
    * @return long 返回类型 
    * @date 2016-3-29 下午4:22:09
    */
   public long selectMemberID(String logname);
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

