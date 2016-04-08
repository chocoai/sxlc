package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


import product_p2p.kit.Lock.SyncLock;
import product_p2p.kit.id.IdEntity;
import product_p2p.kit.shareCache.shareCache;

/**
 * id生成器
 * @author zhy
 *
 */
//@Repository @Autowired
//@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
@Controller("IdGeneratorUtil")
public class IdGeneratorUtil {
	@Resource(name="idWriteDaoImpl")
//	@Autowired() @Qualifier("idWriteDaoImpl")
	private IdWriteDaoImpl idWriteDaoImpl;
	@Resource(name="idReadDaoImpl")
//	@Autowired() @Qualifier("idReadDaoImpl")
	private IdReadDaoImpl idReadDaoImpl;
	
	public IdWriteDaoImpl getIdWriteDaoImpl() {
		return idWriteDaoImpl;
	}
	public void setIdWriteDaoImpl(IdWriteDaoImpl idWriteDaoImpl) {
		this.idWriteDaoImpl = idWriteDaoImpl;
	}
	public IdReadDaoImpl getIdReadDaoImpl() {
		return idReadDaoImpl;
	}
	public void setIdReadDaoImpl(IdReadDaoImpl idReadDaoImpl) {
		this.idReadDaoImpl = idReadDaoImpl;
	}
	private SyncLock idLock = new SyncLock();//投标锁
	private int iIntLen = Integer.SIZE/8;
	private int iLongLen = Long.SIZE/8;
	private int iShortLen = Short.SIZE/8;
	private int iHeadLen = iIntLen + iIntLen;
	private int iNodeLen = iLongLen + iShortLen;
	private int iFileSize = 2*1024*1024;
//	private List<IdEntity> idList = new ArrayList<IdEntity>();
	private static IdGeneratorUtil idGeneratorUtil=null;
	public IdGeneratorUtil(){
		String path = getClass().getClassLoader().getResource("/").getPath();
//		String path = "D:\\";
	    path = path.replaceAll("%20", " ");
	    
	    String filePath = path+"IdGenerator.xml";
	    sShareCache = new shareCache(filePath,iFileSize);
	    sShareCache.startShare();
	    if(idGeneratorUtil == null){
			idGeneratorUtil = this;
		}
	}
	public static IdGeneratorUtil GetIdGeneratorInstance(){
		if(idGeneratorUtil == null){
			idGeneratorUtil = new IdGeneratorUtil();
		}
		return idGeneratorUtil;
	}
	private shareCache sShareCache;// = new shareCache("");
	
	/**
	 * 从文件中   获取id
	 * @return
	 */
	public long GetId(){
		long lResult = 0;
		int[] iCount = {0,0};
		idLock.EnterLock();
		try {
			ReadIdCount(iCount);
			int iPos = iHeadLen;
			IdEntity idEntity = null;
			for(int i=0;i<iCount[0];i++){
				idEntity = GetIdInfo(iPos);
				if(idEntity.getsStatu() == (short)0){
					lResult = idEntity.getlId();
					break;
					/*if(idEntity.getlId()==0){
						
					}else{
					}*/
				}
				iPos = iPos + iNodeLen;
			}
			UpdateIdStatu(lResult, iPos, (short)1);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			idLock.LeaveLock();
		}
		return lResult;
		/*int iSize = 0;
		if(idList!=null){
			iSize = idList.size();
		}
		IdEntity idEntity = null;
		idLock.EnterLock();
		try {
			if(iSize>0){
				for(int i=0;i<iSize;i++){
					idEntity = idList.get(i);
					if(idEntity.getsStatu() == 0){
						lResult = idEntity.getlId();
						idEntity.setsStatu((short)1);
						break;
					}
				}
			}else{
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			idLock.LeaveLock();
		}
		return lResult;*/
	}
	
	/**
	 * 设置id使用失败
	 * @param lId	id值
	 */
	public void SetIdUsedFail(long lId){
		idLock.EnterLock();
		try {
			UpdateIdStatu(lId, 0, (short)0);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			idLock.LeaveLock();
		}
	}
	
	/**
	 * 设置id已经被用
	 * @param lId	id值
	 */
	public void SetIdUsed(long lId){
		idLock.EnterLock();
		try {
			UpdateIdStatu(lId, 0, (short)3);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			idLock.LeaveLock();
		}
	}
	
	/**
	 * 更新id状态
	 * @param lId			id值
	 * @param iPos			位置
	 * @param iStatu		状态	1：使用中	3：已使用
	 */
	private void UpdateIdStatu(long lId,int iPos,short iStatu){
		if(sShareCache == null){
			return;
		}
		int[] iCountInfo = {0,0};
		ReadIdCount(iCountInfo);
		IdEntity idEntity = null;
		iPos = iHeadLen;
		for(int i=0;i<iCountInfo[0];i++){
			idEntity = GetIdInfo(iPos);
			if(idEntity.getlId() == lId){
				byte[] bInfo = new byte[iNodeLen];
				LongToBytes(bInfo, 0, lId);
				ShortToBytes(bInfo, iLongLen, iStatu);
				sShareCache.Write(bInfo, iPos, iNodeLen);
				break;
			}
			iPos = iPos + iNodeLen;
		}
	}
	
	/**
	 * 获取id信息
	 * @param iPosition				其实位置
	 * @return
	 */
	private IdEntity GetIdInfo(int iPosition){
		if(iPosition<=0){
			return null;
		}
		if(sShareCache == null){
			return null;
		}
		IdEntity idEntity = new IdEntity();
		int iLen = iLongLen + iShortLen;
		byte[] bInfo = new byte[iLen];
		sShareCache.Read(bInfo, iPosition, iLen);
		long lId = BytesToLong(bInfo, 0);
		short sStatu = BytesToShort(bInfo, iLongLen);
		idEntity.setlId(lId);
		idEntity.setsStatu(sStatu);
		idEntity.setiLen(iLen);
		
		return idEntity;
	}
	
	/**
	 * 更新  id个数和  文件长度
	 * @param iCount			id个数
	 * @param iLen				文件长度
	 */
	private void UpdateIdCount(int iCount,int iLen){
		if(sShareCache==null){
			return;
		}
		byte[] bHeadByte = new byte[iIntLen + iIntLen];
		IntToBytes(bHeadByte, 0, iCount);
		IntToBytes(bHeadByte, iIntLen, iLen);
		sShareCache.Write(bHeadByte, 0, iIntLen + iIntLen);
	}
	
	/**
	 * 获取  id个数
	 * @param iResult			0：id个数	1：文件长度
	 */
	private void ReadIdCount(int[] iResult){
		if(sShareCache==null || iResult==null || iResult.length<2){
			return;
		}
		byte[] bHeadByte = new byte[iIntLen + iIntLen];
		sShareCache.Read(bHeadByte, 0, iIntLen + iIntLen);
		iResult[0] = BytesToInt(bHeadByte, 0);
		iResult[1] = BytesToInt(bHeadByte, iIntLen);
	}
	
	/**
	 * byte数组 转    short
	 * @param data
	 * @param offset
	 * @return
	 */
	private short BytesToShort(byte[] data,int offset){
		short num = 0;
		if(data == null || data.length<(offset + iShortLen)){
			return num;
		}
		for (int i = offset; i < offset + iShortLen; i++) {
			num <<= 8;
			num |= (data[i] & 0xff);
		}
		return num;
	}
	
	/**
	 * byte数组转int
	 * @param data			byte数组
	 * @param offset		
	 * @return
	 */
	private int BytesToInt(byte[] data,int offset){
		int num = 0;
		if(data == null || data.length<(offset + iIntLen)){
			return num;
		}
		for (int i = offset; i < offset + iIntLen; i++) {
			num <<= 8;
			num |= (data[i] & 0xff);
		}
		return num;
	}
	
	/**
	 * byte数组转Long
	 * @param data			byte数组
	 * @param offset		
	 * @return
	 */
	private long BytesToLong(byte[] data,int offset){
		long num = 0;
		if(data == null || data.length<(offset + iLongLen)){
			return num;
		}
		for (int i = offset; i < offset + iLongLen; i++) {
			num <<= 8;
			num |= (data[i] & 0xff);
		}
		return num;
	}
	
	/**
	 * int 转为  byte[] 
	 * @param data			返回值 byte[]
	 * @param offset		偏移量
	 * @param iData			输入参数
	 */
	private void IntToBytes(byte[] data,int offset,int iData){
		int iNum = iData;
		
		for(int i=iIntLen;i>0;i--){
			data[offset+i-1] = (byte)(iNum>>(iIntLen-i)*8);
		}
		/*data[offset+3] = (byte)iNum;
		data[offset + 2] = (byte)(iNum>>8);
		data[offset+1] = (byte)(iNum>>16);
		data[offset] = (byte)(iNum>>24);*/
	}
	
	/**
	 * Long 转为  byte[] 
	 * @param data			返回值 byte[]
	 * @param offset		偏移量
	 * @param iData			输入参数
	 */
	private void LongToBytes(byte[] data,int offset,long iData){
		long iNum = iData;
		
		for(int i=iLongLen;i>0;i--){
			data[offset+i-1] = (byte)(iNum>>(iLongLen-i)*8);
		}
		/*data[offset+3] = (byte)iNum;
		data[offset + 2] = (byte)(iNum>>8);
		data[offset+1] = (byte)(iNum>>16);
		data[offset] = (byte)(iNum>>24);*/
	}
	
	/**
	 * short 转	 byte[]
	 * @param data
	 * @param offset
	 * @param sData
	 */
	private void ShortToBytes(byte[] data,int offset,short sData){
		short iNum = sData;
		
		for(int i=iShortLen;i>0;i--){
			data[offset+i-1] = (byte)(iNum>>(iShortLen-i)*8);
		}
		/*data[offset+1] = (byte)iNum;
		data[offset + 0] = (byte)(iNum>>8);	*/
	}
	
	/**
	 * 整理  id 虚拟文件		已使用的id更新数据库，数量不足时从数据库中获取
	 */
	public void IdFileMng(){
		if(sShareCache == null){
			return;
		}
		
		idLock.EnterLock();
		try {
			int[] iCount = {0,0};
			ReadIdCount(iCount);
			int iTotalCount = iCount[0];
			int iTotalLen = iCount[1];
			int iUnUsedCount = 0;
			iCount[0] = 0;
			iCount[1] = iHeadLen;
			IdEntity idEntity = null;
			int iPos = iHeadLen;
			/*CommonWriteDao commonWriteDao = (CommonWriteDao)SpringUtil.getBean("commonWriteDao");
			CommonDao commonDao = (CommonDao)SpringUtil.getBean("commonDao");*/
			System.out.println("总共id个数：" + iTotalCount);
			for(int i=0;i<iTotalCount;i++){
				idEntity = GetIdInfo(iPos);
				if(idEntity.getsStatu() != 0 || idEntity.getlId() == 0){
					if(idEntity.getlId()!=0){
						idWriteDaoImpl.SetIdUsed(idEntity.getlId());
					}
					DeleteNode(iPos, iNodeLen, iTotalLen);
//					System.out.println("无效id：" + idEntity.getlId());
					/*sShareCache.Read(bTotal, iStartPos, iTotalLen-iStartPos);
					sShareCache.Write(bTotal, iPos, iTotalLen-iStartPos);*/
				}else{
					iCount[0] = iCount[0] + 1;
					iCount[1] = iCount[1] + iNodeLen;
//					System.out.println("有效id：" + idEntity.getlId());
					if(idEntity.getsStatu() == 0){
						iUnUsedCount ++;
					}
					iPos = iPos + iNodeLen;
				}
			}
			UpdateIdCount(iCount[0], iCount[1]);
			System.out.println("有效id个数：" + iUnUsedCount);
			if(iUnUsedCount<6000){
				System.out.println("从数据库获取id：" + (6000-iUnUsedCount + 1000) + " 个");
				GetIdList(6000-iUnUsedCount + 1000);
			}
			iUnUsedCount = idReadDaoImpl.GetUnUsedIdCount();
			if(iUnUsedCount<6000){
				//  生成id
				System.out.println("从服务器获取id：" + (500) + " 个");
				GetIdInfoFromServer(500);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IdFileMng:" + e.getLocalizedMessage());
		}finally{
			idLock.LeaveLock();
		}
	}
	
	/**
	 * 删除  0
	 */
	/*public void RemoveZero(){
		if(sShareCache == null){
			return;
		}
		
		idLock.EnterLock();
		int[] iCount = {0,0};
		ReadIdCount(iCount);
		int iTotal = iCount[0];
		IdEntity idEntity = null;
		int iPos = iHeadLen;
		for(int i=0;i<iTotal;i++){
			idEntity = GetIdInfo(iPos);
			
			if(idEntity.getlId() == 0){
				DeleteNode(iPos, iNodeLen, iTotalLen);
			}
			iPos = iPos + iNodeLen;					
		}
	}*/
	
	/**
	 * 从服务器获取id
	 * @param iCount			id个数
	 */
	private void GetIdInfoFromServer(int iCount){
		/*CommonWriteDao commonWriteDao = (CommonWriteDao)SpringUtil.getBean("commonWriteDao");
		CommonDao commonDao = (CommonDao)SpringUtil.getBean("commonDao");*/
		List<Long> lIdList = null;
		lIdList = new ArrayList<Long>();
		List<Long> lList = idWriteDaoImpl.GetIdList(iCount);
		
		int iListSize = 0;
		if(lList!=null){
			iListSize = lList.size();
		}
		if(iListSize>=2){
			long lStart = lList.get(0);
			long lEnd = lList.get(1);
			for(long i = lStart;i<lEnd;i = i+2){
				lIdList.add(i);
			}
		}
	/*else{
			String sUrl = commonDao.GetHeadquartersServerUrl();
			sUrl = sUrl + "/GetIdInfoFromServer.action";
			String sXml = "size=" + iCount + "";
			CallWs callWs = new CallWs();
			String sInfo = callWs.toCallPost(sXml, sUrl);
			if(sInfo!=null && !sInfo.equals("")){
				String sSubInfo = "\"rows\":[";
				int iPos = sInfo.indexOf(sSubInfo);
				if(iPos!=-1){
					sInfo = sInfo.substring((iPos + sSubInfo.length()), sInfo.length()-2);
					String[] sInfos = sInfo.split(",");
					int iLen = 0;
					if(sInfos!=null){
						iLen = sInfos.length;
					}
					if(lIdList == null){
						lIdList = new ArrayList<Long>();
					}
					for(int i=0;i<iLen;i++){
						lIdList.add(Utility.StringToLong(sInfos[i], 0));
					}
				}
			}
			
		}*/
		idWriteDaoImpl.InsertIdInfo(lIdList);
	}
	
	/**
	 * 调试用
	 */
	public List<IdEntity> ReadAllIdList(){
		List<IdEntity> list = new ArrayList<IdEntity>();
		IdEntity entity = null;
		int[] iCount = {0,0};
		try {
			ReadIdCount(iCount);
			int iPos = iHeadLen;
			for(int i=0;i<iCount[0];i++){
				entity = GetIdInfo(iPos);
				list.add(entity);
				iPos = iPos + iNodeLen;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
		}
		return list;
	}
	
	/**
	 * 删除节点
	 * @param iPos			位置
	 * @param iLen			删除  长度
	 * @param iTotalLen		文件长度
	 */
	private void DeleteNode(int iPos,int iLen,int iTotalLen){
		if(sShareCache==null){
			return;
		}
		byte[] bTotal = new byte[iFileSize];
		sShareCache.Read(bTotal, iPos+iLen, iTotalLen-iPos-iLen);
		sShareCache.Write(bTotal, iPos, iTotalLen-iPos-iLen);
	}
	/**
	 * 从数据库中获取id  并保存到文件中
	 * @param iCount		个数
	 */
	private void GetIdList(int iCount){
//		CommonWriteDao commonWriteDao = (CommonWriteDao)SpringUtil.getBean("commonWriteDao");
		List<IdEntity> list = idWriteDaoImpl.GetUnusedId(iCount);
		System.out.println("数据库实际获取id:" + list.size());
		IdEntity entity = null;
		int iSize = 0;
		if(list!=null){
			iSize = list.size();
		}
		int iPosition = iHeadLen;
		byte[] bNoteByte = new byte[iNodeLen];
		boolean blResult = true;
		if(blResult){
			int[] iCountArray = {0,0};
			ReadIdCount(iCountArray);
			int iTotalCount = iCountArray[0];
			int iTotalLen = iCountArray[1];
			iPosition = iTotalLen;
			for(int i=0;i<iSize;i++){
				entity = list.get(i);
//				System.out.println("获取到的id为：" + entity.getlId());
				LongToBytes(bNoteByte, 0, entity.getlId());
				ShortToBytes(bNoteByte, iLongLen, entity.getsStatu());
				blResult = sShareCache.Write(bNoteByte, iPosition, iNodeLen);
				iPosition = iPosition + iNodeLen;
				iTotalCount ++;
				iTotalLen = iTotalLen + iNodeLen;
				
				UpdateIdCount(iTotalCount, iTotalLen);
				
				/*ReadIdCount(iCountArray);	//记得删掉
				IdEntity idEntity = GetIdInfo(iPosition-iNodeLen);
				System.out.println("新添加id：" + idEntity.getlId());*/
			}
			
//			System.out.println("iTotalCount:" + iTotalCount + ",iTotalLen:" + iTotalLen + "");
			/*IntToBytes(bHeadByte, 0, iTotalCount);
			IntToBytes(bHeadByte, iIntLen, iTotalLen);
			sShareCache.Write(bHeadByte, 0, iIntLen + iIntLen);*/
		}
	}
	/*public void GetIdList(int iCount){
		if(idList == null){
			idList = new ArrayList<IdEntity>();
		}
		int iLen = iCount*(iIntLen+iShortLen); 
		int iPosition = iIntLen + iIntLen;
		byte[] bResult = new byte[iLen];
		boolean blResult = sShareCache.Read(bResult, iPosition, iLen);
		iPosition = 0;
		if(blResult){
			for(int i=0;i<iCount;i++){
				
			}
		}
	}*/
	
	public void test(){
		int iCount = idReadDaoImpl.GetUnUsedIdCount();
		System.out.println("数量："+iCount);
	}
}
