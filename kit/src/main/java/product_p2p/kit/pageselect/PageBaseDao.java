package product_p2p.kit.pageselect;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

/**
 * 分页查询
 * @author 
 *
 */
public class PageBaseDao { 
	
	public static List<Object> selectPage(String name,PageEntity pageEntity,SqlSession session) {
		List<Object> list = null;
		if(name!=null && !name.equals("") && session != null){
			list = session.selectList(name, pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		}
	    if(list==null){
	    	list = new ArrayList<Object>();
	    }
	    return list;
	}
	
}