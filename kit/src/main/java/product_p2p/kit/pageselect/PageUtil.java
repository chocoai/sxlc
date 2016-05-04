package product_p2p.kit.pageselect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*import com.gdl.Entity.PageEntity;
import com.gdl.Entity.PageEntity.EnumOrder;*/
import com.github.pagehelper.Page;

public class PageUtil{
	/**
	 * map集合key关键字前缀
	 */
	private static final String  MAP_PREFIX="gdlmap";
	/**
	 * 参数集合
	 */
	private static Map map=null;
	/**
	 * 将返回值集合和page对象封装到PageEntity
	 * 2016-1-7
	 * @author lsf
	 * @description void
	 */
	public static  void ObjectToPage(PageEntity pageEntity,List list){
		pageEntity.setResults(list);
		Page page=(Page)pageEntity.getResults();
		pageEntity.setRecordsTotal(page.getTotal());
		pageEntity.setRecordsFiltered(page.getTotal());
		long pageSize = pageEntity.getPageSize();
		long totalPage =page.getTotal()/pageSize;
		if(page.getTotal()%pageSize!=0){
			totalPage+=1;
		}
		pageEntity.setTotalPage(totalPage);
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
	 * @param OrderBy 排序方式	0:降序 1：升序
	 * @return {@link PageEntity}
	 */
	public static  PageEntity SetPage(Map map,int PageNum,int PageSize,int OrderBy){
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
	 * @description 封装pageEntity 对象
	 * @param <T> 实体对象
	 * @param map 查询条件
	 * @param PageNum 当前页
	 * @param PageSize 当前页面大小
	 * @param OrderBy 排序方式
	 * @param orderKey 排序关键字
	 * @return {@link PageEntity}
	 */
	public static  PageEntity SetPage(Map map,int PageNum,int PageSize,String orderKey,String OrderBy){
		PageEntity pageEntity=new PageEntity();
		pageEntity.setPageNum(PageNum);
		pageEntity.setPageSize(PageSize);
		pageEntity.setMap(map);
		pageEntity.setOrderKey(orderKey);
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
	public static Map getMap(Object[] objects){
		map = new HashMap();
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
	public static Map getMap(String sql,String orderBy,int pageNum,int pageSize){
		    map=new HashMap();
			map.put("sql", sql);
			map.put("orderBy", orderBy);
			map.put("pageNum", Integer.toString(pageNum) );
			map.put("pageSize", Integer.toString(pageSize));
			map.put("tatalNum", "0");//总条数默认为0
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
//		long lResult = 
		return Long.valueOf((String) map.get("tatalNum")).longValue();
	}


}
