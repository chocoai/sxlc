
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import product_p2p.kit.constant.Constant;
import product_p2p.kit.redisPlug.Core;

import cn.dictionaries.model.CityInfoEntity;
import cn.dictionaries.model.CountyInfoEntity;
import cn.dictionaries.model.EducationInfoEntity;
import cn.dictionaries.model.MaritalInfoEntity;
import cn.dictionaries.model.NationInfoEntity;
import cn.dictionaries.model.ProvinceInfoEntity;
import cn.dictionaries.model.ReligionInfoEntity;
import cn.dictionaries.model.TownInfoEntity;

/**
 * 字典查询入口
* @author 张友 
* @Description: 字典查询入口 
* @since 
* @date 2016-3-31 上午11:44:06
 */
@Controller("dictionariesCore")
public class DictionariesCore extends Constant {
	private static DictionariesCore dictionariesCore;
	@Resource(name="dictionariesDaoImpl")
	private DictionariesDaoImpl dictionariesDaoImpl;
	
	public DictionariesCore(){
		if(dictionariesCore==null){
			dictionariesCore = this;
		}
	}
	public static DictionariesCore GetDictionariesInstead(){
		if(dictionariesCore == null){
			dictionariesCore = new DictionariesCore();
		}
		return dictionariesCore;
	}
	/**
	 * 获取有效的学历信息
	* GetEducationList 获取有效的学历信息
	* @author 张友  
	* * @Title: GetEducationList 
	* @Description: 获取有效的学历信息 
	* @param @return 设定文件 
	* @return List<EducationInfoEntity> 学历信息列表
	* @date 2016-3-31 下午1:31:50
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<EducationInfoEntity> GetEducationList(){
		List<EducationInfoEntity> list = null;
		
		list = (List<EducationInfoEntity>)Core.getObject("education_list");
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.GetEducationList();
			Core.putRsa("education_list", (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取有效的民族信息
	* GetNationInfoList	获取有效的民族信息
	* @author 张友  
	* * @Title: GetNationInfoList 
	* @Description: 获取有效的民族信息 
	* @param @return 设定文件 
	* @return List<NationInfoEntity> 民族列表
	* @date 2016-3-31 下午1:42:54
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<NationInfoEntity> GetNationInfoList(){
		List<NationInfoEntity> list = null;
		
		list = (List<NationInfoEntity>)Core.getObject(NATIONLIST);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.GetNationList();
			Core.putRsa(NATIONLIST, (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取省份列表
	* GetProvinceList	获取省份列表 
	* @author 杨翰林  
	* * @Title: GetProvinceList 
	* @Description: 获取省份列表 
	* @param @return 设定文件 
	* @return List<ProvinceInfoEntity> 省份信息表
	* @date 2016-4-1 下午4:14:19
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ProvinceInfoEntity> GetProvinceList(){
		List<ProvinceInfoEntity> list = null;
		
		list = (List<ProvinceInfoEntity>)Core.getObject(PROVINCELIST);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.getProvinceList();
			Core.putRsa(PROVINCELIST, (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取城市列表 
	* GetCityList	获取城市列表 
	* @author 杨翰林  
	* * @Title: GetCityList 获取城市列表  
	* @Description: 	获取城市列表  
	* @param @param pId
	* @param @return 设定文件 
	* @return List<CityInfoEntity> 城市信息表
	* @date 2016-4-1 下午4:21:06
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<CityInfoEntity> GetCityList(int pId){
		List<CityInfoEntity> list = null;
		
		list = (List<CityInfoEntity>)Core.getObject(pId + CITYLIST);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.getCityList(pId);
			Core.putRsa(pId + CITYLIST, (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取县区列表
	* GetCountyList	获取县区列表 
	* @author 杨翰林  
	* * @Title: GetCountyList 获取县区列表
	* @Description: 获取县区列表
	* @param @param cId
	* @param @return 设定文件 
	* @return List<CountyInfoEntity> 县区信息表 
	* @date 2016-4-1 下午4:22:12
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<CountyInfoEntity> GetCountyList(int cId){
		List<CountyInfoEntity> list = null;
		
		list = (List<CountyInfoEntity>)Core.getObject(cId + COUNTYLIST);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.getCountyList(cId);
			Core.putRsa(cId + COUNTYLIST, (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取乡镇列表
	* GetTownList	获取乡镇列表 
	* @author 杨翰林  
	* * @Title: GetTownList	获取乡镇列表 
	* @Description: 获取乡镇列表 
	* @param @param xId
	* @param @return 设定文件 
	* @return List<TownInfoEntity> 乡镇信息表
	* @date 2016-4-1 下午4:23:42
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TownInfoEntity> GetTownList(int xId){
		List<TownInfoEntity> list = null;
		
		list = (List<TownInfoEntity>)Core.getObject(xId + TOWNLIST);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.getTownList(xId);
			Core.putRsa(xId + TOWNLIST, (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取婚姻状况
	* GetMaritalList	获取婚姻状况 
	* @author 杨翰林  
	* * @Title: GetMaritalList	获取婚姻状况 
	* @Description: 获取婚姻状况 
	* @param @return 设定文件 
	* @return List<MaritalInfoEntity> 婚姻信息表
	* @date 2016-4-1 下午4:24:20
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<MaritalInfoEntity> GetMaritalList(){
		List<MaritalInfoEntity> list = null;
		
		list = (List<MaritalInfoEntity>)Core.getObject(MARITALINFO);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.getMaritalStatusList();
			Core.putRsa(MARITALINFO, (Object)list);
		}
		
		return list;
	}
	
	/**
	 * 获取宗教列表
	* GetReligionList	获取宗教列表 
	* @author 杨翰林  
	* * @Title: GetReligionList 获取宗教列表
	* @Description: 获取宗教列表 
	* @param @return 设定文件 
	* @return List<ReligionInfoEntity> 宗教信息表 
	* @date 2016-4-1 下午4:25:10
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ReligionInfoEntity> GetReligionList(){
		List<ReligionInfoEntity> list = null;
		
		list = (List<ReligionInfoEntity>)Core.getObject(RELIGIONLIST);
		if(list == null || list.size()==0){
			list = dictionariesDaoImpl.getReligionList();
			Core.putRsa(RELIGIONLIST, (Object)list);
		}
		
		return list;
	}
}

