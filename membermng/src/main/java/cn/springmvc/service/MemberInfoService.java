

/** 
* @Title: MemberInfoService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午9:31:10 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.MemberInfoEntity;

/** 
 * @author 刘利 
 * @Description: 会员信息 
 * @since 
 * @date 2016-3-21 上午9:31:10  */

public interface MemberInfoService {
	/**
	 * 分页查询会员信息
	 * @param pageEntity 分页实体类 map{memberNo}
	 * @return 会员信息
	 */
	public List<MemberInfoEntity> selectMemberInfoList(
			PageEntity pageEntity);
	
}

