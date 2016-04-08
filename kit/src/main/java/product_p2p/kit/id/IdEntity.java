package product_p2p.kit.id;

import java.sql.ResultSet;
/**
 * 
* @author 张友 
* @Description: TODO 
* @since 5.0
* @date 2016-3-18 下午7:37:53
 */
public class IdEntity {
	private long lId;					//id值
	private short sStatu;				//状态			0：未用 1：使用中 2：已使用
	private int iLen;					//共享内存长度
	public void ReadEntity(IdEntity entity,ResultSet rs){
		if(entity == null || rs == null){
			return;
		}
		try {
			entity.setlId(rs.getLong("ID"));
			entity.setsStatu(rs.getShort("Statu"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public long getlId() {
		return lId;
	}
	public void setlId(long lId) {
		this.lId = lId;
	}
	public short getsStatu() {
		return sStatu;
	}
	public void setsStatu(short sStatu) {
		this.sStatu = sStatu;
	}
	public int getiLen() {
		return iLen;
	}
	public void setiLen(int iLen) {
		this.iLen = iLen;
	}
}
