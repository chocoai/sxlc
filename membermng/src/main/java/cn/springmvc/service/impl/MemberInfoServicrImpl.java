

/** 
* @Title: MemberInfoServicrImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午9:32:26 
* @version V5.0 */
 
package cn.springmvc.service.impl; 
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;  
import cn.membermng.model.MemberAll;
import cn.membermng.model.MemberInfoEntity; 
import cn.springmvc.dao.impl.MemberInfoListDaoimpl;
import cn.springmvc.service.MemberInfoService;

/** 
 * @author 刘利 
 * @Description: 会员信息
 * @since 
 * @date 2016-3-21 上午9:32:26  */
@Service("memberInfoServicrImpl")
public class MemberInfoServicrImpl implements MemberInfoService {
	@Resource(name="memberInfoListDaoimpl")
	private MemberInfoListDaoimpl memberInfoListDaoimpl;  
    
	public List<MemberInfoEntity> selectMemberInfoList(PageEntity pageEntity) {
           
    	 List<MemberInfoEntity> memberInfoList = null;
  		 memberInfoList=memberInfoListDaoimpl.selectMemberInfoAllpage(pageEntity);  
         return memberInfoList;
	}

	@Override
	public List<MemberAll> getMemberList(PageEntity pageEntity) {
		pageEntity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return memberInfoListDaoimpl.getMemberList(pageEntity);  
		
	}

}

