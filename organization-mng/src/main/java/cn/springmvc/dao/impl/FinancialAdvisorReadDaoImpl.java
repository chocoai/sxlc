package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.springmvc.dao.IFinancialAdvisorReadDao;
import cn.springmvc.dao.IFinancialAdvisorWriteDao;
import cn.springmvc.model.FinancialAdvisor;

@Repository
public class FinancialAdvisorReadDaoImpl implements IFinancialAdvisorReadDao {

	
	
	@Override
	public List<FinancialAdvisor> getListByParam(Map<String, Object> param) {
		
		return null;
	}



}
