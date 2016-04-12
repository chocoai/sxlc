

/** 
* @Title: MemberStationListDao.java 
* @Package cn.memberstation.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午4:09:39 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.MemberStationLetterEntity;

import product_p2p.kit.pageselect.PageEntity;
 

/** 
 * @author 刘利 
 * @Description: 会员站内信读
 * @since 
 * @date 2016-3-29 下午4:09:39  */

public interface MemberStationListDao {
	/**
	 * 根据会员ID查询会员发件箱信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberID 会员ID
	 * @param @return 设定文件 
	 * @return List<MemberStationLetterEntity> 返回类型 
	 * @date 2016-3-29 下午4:11:47
	 */
   public List<MemberStationLetterEntity> selectSendLetter(PageEntity pageEntity);
   /**
    * 根据会员ID查询会员收件箱信息，筛选已读未读
    * @author 刘利   
    * @Description: TODO 
    * @param  map
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
    * @param @param logname
    * @param @return 设定文件 
    * @return long 返回类型 
    * @date 2016-3-29 下午4:22:09
    */
   public long selectMemberID(String logname);
}

