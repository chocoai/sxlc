
package cn.springmvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dictionaries.model.CityInfoEntity;
import cn.dictionaries.model.CountyInfoEntity;
import cn.dictionaries.model.EducationInfoEntity;
import cn.dictionaries.model.MaritalInfoEntity;
import cn.dictionaries.model.NationInfoEntity;
import cn.dictionaries.model.ProvinceInfoEntity;
import cn.dictionaries.model.ReligionInfoEntity;
import cn.dictionaries.model.TownInfoEntity;

/**
 * 获取字典实现类
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:56:01
 */
@Repository("dictionariesDaoImpl")
public class DictionariesDaoImpl extends SqlSessionDaoSupport{
	
	/**
	 * 获取学历列表
	* GetEducationList	获取学历列表
	* TODO		获取学历列表
	* @author 张友  
	* * @Title: GetEducationList 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<EducationInfoEntity> 返回类型 
	* @date 2016-3-31 上午11:57:23
	* @throws
	 */
	public List<EducationInfoEntity> GetEducationList(){
		List<EducationInfoEntity> list = null;
		
		list = getSqlSession().selectList("Dictionaries.GetEducationInfo");
		
		return list;
	}
	
	/**
	 * 获取民族列表
	* GetNationList	获取民族列表
	* TODO	获取民族列表
	* @author 张友  
	* * @Title: GetNationList 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<NationInfoEntity> 返回类型 
	* @date 2016-3-31 下午1:45:08
	* @throws
	 */
	public List<NationInfoEntity> GetNationList(){
		List<NationInfoEntity> list = null;
		
		list = getSqlSession().selectList("Dictionaries.GetNationInfo");
		
		return list;
	}
	
	/**
	 * 获取城市列表
	* getCityList	获取城市列表
	* 
	* @author 杨翰林  
	* * @Title: getCityList
	* @Description:  
	* @param @return 设定文件 
	* @return List<CityInfoEntity> 返回类型 
	* @date 2016-4-1 上午11:57:56
	* @throws
	 */
	public List<CityInfoEntity> getCityList(int pId) {
		List<CityInfoEntity> list = null;
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("pId", pId);
		
		list = getSqlSession().selectList("Dictionaries.GetCityInfo", param);
		
		return list;
	}
	
	/**
	 * 获取省份列表
	* getProvinceList	获取省份列表 
	* TODO	获取省份列表
	* @author 杨翰林  
	* * @Title: getProvinceList 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<ProvinceInforEntity> 返回类型 
	* @date 2016-4-1 下午12:00:00
	* @throws
	 */
	public List<ProvinceInfoEntity> getProvinceList() {
		List<ProvinceInfoEntity> list = null;
		
		list = getSqlSession().selectList("Dictionaries.GetProvinceInfo");
		
		return list;
	}
	
	/**
	 * 获取县区列表
	* getCountyList 	获取县区列表 
	* TODO	获取县区列表
	* @author 杨翰林  
	* * @Title: getCountyList 
	* @Description: TODO 
	* @param @param cId
	* @param @return 设定文件 
	* @return List<CountyInfoEntity> 返回类型 
	* @date 2016-4-1 下午2:35:40
	* @throws
	 */
	public List<CountyInfoEntity> getCountyList(int cId) {
		List<CountyInfoEntity> list = null;
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("cId", cId);
		
		list = getSqlSession().selectList("Dictionaries.GetCountyInfo", param);
		
		return list;
	}
	
	/**
	 * 获取乡镇列表
	* getTownList 	获取乡镇列表 
	* TODO	获取乡镇列表
	* @author 杨翰林  
	* * @Title: getTownList 
	* @Description: TODO 
	* @param @param xId
	* @param @return 设定文件 
	* @return List<TownInfoEntity> 返回类型 
	* @date 2016-4-1 下午2:39:29
	* @throws
	 */
	public List<TownInfoEntity> getTownList(int xId) {
		List<TownInfoEntity> list = null;
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("xId", xId);
		
		list = getSqlSession().selectList("Dictionaries.GetCountyInfo", param);
		
		return list;
	}
	
	/**
	 * 获取婚姻状况
	* getMaritalStatusList	获取婚姻状况 
	* TODO	获取婚姻状况
	* @author 杨翰林  
	* * @Title: getMaritalStatusList 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<MaritalInfoEntity> 返回类型 
	* @date 2016-4-1 下午2:56:53
	* @throws
	 */
	public List<MaritalInfoEntity> getMaritalStatusList() {
		List<MaritalInfoEntity> list = null;
		
		list = getSqlSession().selectList("Dictionaries.GetMaritalInfo");
		
		return list;
	}
	
	/**
	 * 获取宗教信仰
	* getReligionList	获取宗教信仰 
	* TODO	获取宗教信仰
	* @author 杨翰林  
	* * @Title: getReligionList 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<ReligionInfoEntity> 返回类型 
	* @date 2016-4-1 下午3:15:09
	* @throws
	 */
	public List<ReligionInfoEntity> getReligionList() {
		List<ReligionInfoEntity> list = null;
		
		list = getSqlSession().selectList("Dictionaries.GetReligionInfo");
		
		return list;
	}
	
	@Override
	@Resource(name="sqlSessionFactoryR")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

