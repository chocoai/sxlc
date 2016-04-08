package product_p2p.kit.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import com.github.pagehelper.Page;

public class PageUtil{
	/**
	 * map集合key关键字前缀
	 */
	private static final String  MAP_PREFIX="gdlmap";
	/**
	 * 参数集合
	 */
	private static Map<String, Object> map=null;
	/**
	 * 将返回值集合和page对象封装到PageEntity
	 * 2016-1-7
	 * @author lsf
	 * @description void
	 */
	public static <T> void ObjectToPage(PageEntity pageEntity,List<T> list){
		pageEntity.setResults(list);
		Page<?> page=(Page<?>)pageEntity.getResults();
		pageEntity.setTatalNum(page.getTotal());
	}
	/**
	 * 
	 * 2016-1-7
	 * @author lsf
	 * @description 封装pageEntity 对象
	 * @param <T> 实体对象
	 * @param map 查询条件
	 * @param PageNum 当前页
	 * @param PageSize 当前页面大小
	 * @param OrderBy 排序方式
	 * @return {@link PageEntity}
	 */
	public static <T> PageEntity SetPage(T t,Map<String, Object> map,int PageNum,int PageSize,int OrderBy){
		PageEntity pageEntity=new PageEntity();
		pageEntity.setPageNum(PageNum);
		pageEntity.setPageSize(PageSize);
		pageEntity.setMap(map);
		pageEntity.setEnumOrder(OrderBy);
		return pageEntity;
	}
	/**
	 * 
	 * 2016-1-7
	 * @author lsf
	 * @description 将数组转出成map key=gdlmap+i(0开始) value=数组值 。如果数组为null 返回一个空{}的map集合不是null
	 * @param objects 不定参数
	 * @return Map<String,Object> 返回map
	 */
	public static Map<String, Object> getMap(Object ...objects){
		map=new HashMap<String, Object>();
		if(objects==null)
			return map;
		for (int i = 0; i < objects.length; i++) {
			map.put(MAP_PREFIX+i, objects[i]);
		}
		    return map;
	}
	/**
	 * 
	 * 2016-1-22
	 * @author lsf
	 * @description
	 * @param sql sql语句
	 * @param orderBy 排序 可以设置为null
	 * @param pageNum 当前页
	 * @param pageSize 当前大小
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> getMap(String sql,String orderBy,int pageNum,int pageSize){
		    map=new HashMap<String, Object>();
			map.put("sql", sql);
			map.put("orderBy", orderBy);
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("tatalNum", 0);//总条数默认为0
		    return map;
	}
	/**
	 * 调用存储过程返回的总条数
	 * 2016-1-22
	 * @author lsf
	 * @description
	 * @return long
	 */
	public static long mapGetCount(){
		return Long.valueOf((String) map.get("tatalNum"));
	}


}
