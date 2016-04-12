package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.springmvc.dao.IFinancialAdvisorDao;
import cn.springmvc.model.FinancialAdvisor;

@Repository
public class FinancialAdvisorImpl implements IFinancialAdvisorDao {

	@Override
	public List<FinancialAdvisor> getListByParam(Map<String, Object> param) {
		return null;
	}

	@Override
	public int saveFinancialAdvisor(FinancialAdvisor advisor) {
		return 0;
	}

	@Override
	public int removeFinancialAdvisor(FinancialAdvisor advisor) {
		return 0;
	}

}
