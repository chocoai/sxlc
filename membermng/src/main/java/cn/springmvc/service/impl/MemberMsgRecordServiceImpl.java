

/** 
* @Title: MemberMsgRecordServiceImpl.java 
* @Package cn.membermsgrecord.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午6:25:48 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.membermng.model.MemberMsgRecordEntity;
import cn.springmvc.dao.impl.MemberMsgRecordDaoImpl;
import cn.springmvc.dao.impl.MemberMsgRecordListDaoImpl;
import cn.springmvc.service.MemberMsgRecordService;

import product_p2p.kit.pageselect.PageEntity;
  

/** 
 * @author 刘利 
 * @Description: 会员站内消息 
 * @since 
 * @date 2016-3-29 下午6:25:48  */
@Service("memberMsgRecordServiceImpl")
public class MemberMsgRecordServiceImpl implements MemberMsgRecordService{
	@Resource(name="memberMsgRecordDaoImpl")
	private MemberMsgRecordDaoImpl memberMsgRecordDaoImpl;
	@Resource(name="memberMsgRecordListDaoImpl")
	private MemberMsgRecordListDaoImpl memberMsgRecordListDaoImpl;
	@Override
	public List<MemberMsgRecordEntity> selectMemberMsgList(PageEntity pageEntity) {
		
		return memberMsgRecordListDaoImpl.selectMemberMsgList(pageEntity);
		
	}
	@Override
	public int updateMemberMsgIsRead(Map<String, Object> map) {
		
		return memberMsgRecordDaoImpl.updateMemberMsgIsRead(map);
		
	}
}

