
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.AccountDaoSupport;
import cn.springmvc.service.AccountSupportService;
import cn.sxlc.account.manager.model.UnUsedRedpacketsEntity;

@Service
public class AccountSupportServiceImpl implements AccountSupportService{
	@Resource(name="accountDaoSupport")
	private AccountDaoSupport accountDaoSupport;  
	
	@Override
	public long getRemainderVouchers(long lMemberId) {
		
		return accountDaoSupport.getRemainderVouchers(lMemberId);
		
	}

	@Override
	public List<UnUsedRedpacketsEntity> getMemberUnUsedRedPackets(long lMemberId) {
		
		return accountDaoSupport.getMemberUnUsedRedPackets(lMemberId);
		
	}

}

