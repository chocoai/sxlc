

/** 
* @Title: GenerateRepayListService.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:59:16 
* @version V5.0 */
 
package cn.springmvc.service.impl; 
 
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
 
import cn.springmvc.dao.InviteMasterApplyDao;  
import cn.springmvc.dao.InviteMasterApplyListDao;
import cn.springmvc.service.InviteMasterApplyService;

/** 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-1 下午1:59:16  */
@Service("inviteMasterApplyServiceImpl")
public class InviteMasterApplyServiceImpl implements InviteMasterApplyService {
	@Resource(name="inviteMasterApplyDaoImpl")
	private  InviteMasterApplyDao inviteMasterApplyDao;
	@Resource(name="inviteMasterApplyListDaoImpl")
	private  InviteMasterApplyListDao inviteMasterApplyListDaoImpl;

	@Override
	public int insertInviteMasterApply(Map<String, Object> map) {
		
		int result = 0;
		long memberID = IntegerAndString.StringToLong(map.get("memberID").toString(),0);
		result = inviteMasterApplyListDaoImpl.selectInviteMasterApplyIsExist(memberID);
		//判断该会员是否是推荐达人，或者存在未审核的申请
		if(result >0 ) {
			return -1;
		}
		return inviteMasterApplyDao.insertInviteMasterApply(map);
		
	}  
	 

}

