package cn.springmvc.pageBean;

import java.util.HashMap;
import java.util.Map;


/***
 * PageBean
 * @author LiJie
 *
 */
public class PageBean {

	private Map<String,Object> param = new HashMap<String, Object>();
	
	
	
	
	
	
	
	
	public void put(String key,Object object){
		this.param.put(key, object);
	}
	
	
	public Map<String,Object> getParam(){
		return this.param;
	}
	
	
	
}
