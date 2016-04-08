package product_p2p.kit.shareCache;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

import org.apache.log4j.Logger;

import product_p2p.kit.Lock.SyncLock;

/**
 * 共享内存
 * @author wj
 *
 */
public class shareCache {
	private static Logger logger = Logger.getLogger(shareCache.class); 
	private String sShareFileName;
	private File fShare;
	private FileChannel readWriteChannel;
	private ByteBuffer readWriteBuf;
	private SyncLock SCLock = new SyncLock();
	private int iFileSize = 0;
	
	private boolean bStart = false;
	private final int min_size = (2*10*1024);
	private final int max_size = (5*1024*1024);
	
	public shareCache(String sFileName,int iSize){
		if(iSize <= 0){
			iSize = min_size;
		}
		if(iSize>max_size){
			iSize = max_size;
		}
		if(sFileName == null){
			sFileName = "";
		}
		sShareFileName = sFileName.trim();
		if(sShareFileName.equals("")){
			UUID uuid = UUID.randomUUID();
			sShareFileName = uuid.toString();
		}
		iFileSize = iSize;
	}
	public boolean startShare(){
		if (!bStart) {
			if(sShareFileName!=null && !sShareFileName.equals("")){
				try {
					fShare = new File(sShareFileName);
					readWriteChannel = new RandomAccessFile(fShare, "rw").getChannel();
//					readWriteBuf = readWriteChannel.map(FileChannel.MapMode.READ_WRITE, 0, (int)readWriteChannel.size());
					readWriteBuf = readWriteChannel.map(FileChannel.MapMode.READ_WRITE, 0, iFileSize);
					
					bStart = true;
				} catch (Exception e) {
					logger.error("shareCache-->startShare:" + e.getLocalizedMessage());
				}
			}
		}
		
		return bStart;
	}
	private void Lock(){
		SCLock.EnterLock();
	}
	private void UnLock(){
		SCLock.LeaveLock();
	}
	public boolean Read(byte[]dst,int iPos,int iLen){
		if (!bStart) {
			return false;
		}
		boolean bRet = false;
		Lock();
		try {
			readWriteBuf.position(iPos);
			readWriteBuf.get(dst, 0, iLen);
			bRet = true;
		} catch (Exception e) {
			logger.error("shareCache-->Read:" + e.getLocalizedMessage());
		}finally{
			UnLock();
		}
		
		return bRet;
	}
	
	public boolean Write(byte[]src,int iPos,int iLen){
		if (!bStart) {
			return false;
		}
		boolean bRet = false;
		Lock();
		try {
			readWriteBuf.position(iPos);
			readWriteBuf.put(src, 0, iLen);
			bRet = true;
		} catch (Exception e) {
			System.out.println("shareCache-->Write:" + e.getLocalizedMessage());
			logger.error("shareCache-->Write:" + e.getLocalizedMessage());
		}finally{
			UnLock();
		}
		
		return bRet;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File file = new File("myfile.dat");
	
	        // create a random access file stream (for read only)
	        FileChannel readOnlyChannel = new RandomAccessFile(file, "r").getChannel();
	        // map a region of this channel's file directly into memory
	        ByteBuffer readOnlyBuf =
	                  readOnlyChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) readOnlyChannel.size());
	
	        // create a random access file stream (read-write)
	        FileChannel readWriteChannel = new RandomAccessFile(file, "rw").getChannel();
	        // map a region of this channel's file directly into memory
	        ByteBuffer readWriteBuf =
	                readWriteChannel.map(FileChannel.MapMode.READ_WRITE, 0, (int) readWriteChannel.size());
	
	        // create a random access file stream (private/copy-on-write))
	        FileChannel privateChannel = new RandomAccessFile(file, "rw").getChannel();
	        // map a region of this channel's file directly into memory
	        ByteBuffer privateBuf =
	                  privateChannel.map(FileChannel.MapMode.PRIVATE, 0, (int) privateChannel.size());
	
	    }
	    catch (IOException e) {
	        System.out.println("I/O Error: " + e.getMessage());
	        logger.error("I/O Error:" + e.getMessage());
	    }
	}

}
