package product_p2p.kit.Upload;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  
import org.apache.commons.net.ftp.FTP;  
import org.apache.commons.net.ftp.FTPClient;  
import org.apache.commons.net.ftp.FTPClientConfig;  
import org.apache.commons.net.ftp.FTPFile;  
import org.apache.commons.net.ftp.FTPReply;  

/**
 * ftp实现文件上传和下载，实现文件共享
 * @author xq
 * @date 2016-03-10
 */
public class FtpClientUtil {
	private final static String sFtpIpAddr = "localhost";
	private final static int iFtpPort = 21;
	private final static int iHttpPort = 8080;
	private final static String sUserName = "xieqiang";
	private final static String sPwd = "xieqiang@qq.com";
	public final static short sFtpServer = 0;		//0：windows 1:linux
	
	public static String getFtpFilePath(){
		String sResult = "http://"+ sFtpIpAddr +":"+iHttpPort+"/";
		
		return sResult;
	}
	
	/** 
     * 获得连接-FTP方式 
     * @param hostName FTP服务器地址 
     * @param port FTP服务器端口 
     * @param userName FTP登录用户名 
     * @param passWord FTP登录密码 
     * @return FTPClient 
     */
    public FTPClient getConnectionFTP(FtpEntity f) {  
        //创建FTPClient对象  
        FTPClient ftp = new FTPClient();  
        try {  
            //连接FTP服务器  
            ftp.connect(f.getIpAddr(), f.getPort());  
            //下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件  
            ftp.setControlEncoding("GBK");  
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);  
            conf.setServerLanguageCode("zh");  
            //登录ftp  
            ftp.login(f.getUserName(), f.getPwd());  
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {  
                ftp.disconnect();  
                System.out.println("连接服务器失败");  
            }  
            System.out.println("登陆服务器成功");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return ftp;  
    }  
      
    /** 
     * 关闭连接-FTP方式 
     * @param ftp FTPClient对象 
     * @return boolean 
     */  
    public boolean closeFTP(FTPClient ftp) {  
        if (ftp.isConnected()) {  
            try {  
                ftp.disconnect();  
                System.out.println("ftp已经关闭");  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
      
    /** 
     * 上传文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param filename 本地文件路径 
     * @param inputStream 输入流 
     * @return boolean 
     */  
    public boolean uploadFile(FTPClient ftp, String path, String fileName, InputStream inputStream) {  
    	boolean success = false;  
        try {  
            ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录  
            
            /*ftpClient.enterLocalPassiveMode(); //开启本地被动模式
            	设置FTPClient为被动传输模式即可解决线程挂起问题。此代码设置在登陆之后或者之前都可以。

                         同样，这只适用于下载的被动传输模式，如果上传的话需要enterRemotePassiveMode()//开启远程被动传输模式
             */           
            ftp.enterLocalPassiveMode();//开启本地被动模式
            
            FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表  
            fileName = FtpClientUtil.changeName(fileName, fs);  
            fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1"); 
            path = new String(path.getBytes("GBK"), "ISO-8859-1");  
            //转到指定上传目录  
            ftp.changeWorkingDirectory(path);  
            //将上传文件存储到指定目录  
            ftp.setFileType(FTP.BINARY_FILE_TYPE);  
            //如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码  
            ftp.storeFile(fileName, inputStream);  
            //关闭输入流  
            inputStream.close();  
            //退出ftp  
            ftp.logout();  
            //表示上传成功  
            success = true;  
            System.out.println("上传成功。。。。。。");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return success;  
    }  
  
    //然后再利用ftpclient的makeDirectory方法创建文件夹
	public void createDir(FTPClient ftp,String dirname){
		try{
			ftp.makeDirectory(dirname);
			System.out.println("在目标服务器上成功建立了文件夹: " + dirname);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
    
    /** 
     * 删除文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param filename FTP服务器上要删除的文件名 
     * @return 
     */  
    public boolean deleteFile(FTPClient ftp, String path, String fileName) {  
        boolean success = false;  
        try {  
            ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录  
            fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");  
            path = new String(path.getBytes("GBK"), "ISO-8859-1");  
            ftp.deleteFile(fileName);  
            ftp.logout();  
            success = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return success;  
    }  
  
    /** 
     * 上传文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param fileName 本地文件路径 
     * @param localPath 本里存储路径 
     * @return boolean 
     */  
    public boolean downFile(FTPClient ftp, String path, String fileName, String localPath) {  
        boolean success = false;  
        try {  
            ftp.changeWorkingDirectory(path);//转移到FTP服务器目录  
            FTPFile[] fs = ftp.listFiles(); //得到目录的相应文件列表  
            for (FTPFile ff : fs) {  
                if (ff.getName().equals(fileName)) {  
                    File localFile = new File(localPath + "\\" + ff.getName());  
                    OutputStream outputStream = new FileOutputStream(localFile);  
                    //将文件保存到输出流outputStream中  
                    ftp.retrieveFile(new String(ff.getName().getBytes("GBK"), "ISO-8859-1"), outputStream);  
                    outputStream.flush();  
                    outputStream.close();  
                    System.out.println("下载成功");  
                }  
            }  
            ftp.logout();  
            success = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return success;  
    }  
      
    /** 
     * 判断是否有重名文件 
     * @param fileName 
     * @param fs 
     * @return 
     */  
    public static boolean isFileExist(String fileName, FTPFile[] fs) {  
        for (int i = 0; i < fs.length; i++) {  
            FTPFile ff = fs[i];  
            if (ff.getName().equals(fileName)) {  
                return true; //如果存在返回 正确信号  
            }  
        }  
        return false; //如果不存在返回错误信号  
    }  
  
    /** 
     * 根据重名判断的结果 生成新的文件的名称 
     * @param fileName 
     * @param fs 
     * @return 
     */  
    public static String changeName(String fileName, FTPFile[] fs) {  
        int n = 0;  
//      fileName = fileName.append(fileName);  
        while (isFileExist(fileName.toString(), fs)) {  
            n++;  
            String a = "[" + n + "]";  
            int b = fileName.lastIndexOf(".");//最后一出现小数点的位置  
            int c = fileName.lastIndexOf("[");//最后一次"["出现的位置  
            if (c < 0) {  
                c = b;  
            }  
            StringBuffer name = new StringBuffer(fileName.substring(0, c));//文件的名字  
            StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));//后缀的名称  
            fileName = name.append(a) + "." + suffix;  
        }  
        return fileName.toString();  
    }  
    
    /**
     * 上传至FTP服务器
     * @author xq
     * @param FileOld 附件数据源， 如：F:/test/1.jpg
     * @param filename 上传后附件名称
     * @param path 上传之后，存放的文件夹，如：/images/uploads/
     * @date 2016-03-11
     * @return 0:成功 1：失败
     */
   
    public static int FtpUploadFileUtil(String FileOld,String filename,String path){
    	int i = 1;
    	boolean success = false; 
    	File f1 = new File(FileOld);
    	FtpClientUtil a = new FtpClientUtil();  
        try {
			InputStream input = new FileInputStream(f1);
			FtpEntity f=new FtpEntity();
			//查询FTP连接参数
			f.setIpAddr(sFtpIpAddr);
			f.setPort(iFtpPort);
			f.setUserName(sUserName);
			f.setPwd(sPwd);
			
			//打开连接
			FTPClient ftp = a.getConnectionFTP(f); 
			//创建文件夹
	        a.createDir(ftp, path.substring(0, path.length()-1));
	        //调用上传
	        success =  a.uploadFile(ftp, path, filename, input);  
	        //关闭连接
	        a.closeFTP(ftp);  
	        
			
		} catch (FileNotFoundException e) {
			System.out.println("FTP上传异常="+e.getLocalizedMessage());
		}  
        if(success==true){
        	i=0;
        }
    	return i;
    }
    
    /**
     * 上传至FTP服务器
     * @author xq
     * @param input 附件流
     * @param filename 上传后附件名称
     * @param path 上传之后，存放的文件夹，如：/images/uploads/
     * @date 2016-03-11
     * @return 0:成功 1：失败
     */
   
    public static int FtpUploadFileUtilEnd(InputStream input,String filename,String path){
    	int i = 1;
    	if(input==null){
    		return i;
    	}
    	boolean success = false; 
    	FtpClientUtil a = new FtpClientUtil();  
        //查询FTP连接参数
		FtpEntity f=new FtpEntity();
		f.setIpAddr(sFtpIpAddr);
		f.setPort(iFtpPort);
	    f.setUserName(sUserName);
	    f.setPwd(sPwd);
		
		//打开连接
		FTPClient ftp = a.getConnectionFTP(f); 
		//创建文件夹
		a.createDir(ftp, path.substring(0, path.length()-1));
		//调用上传
		success =  a.uploadFile(ftp, path, filename, input);  
		//关闭连接
		a.closeFTP(ftp);  
        if(success==true){
        	i=0;
        }
    	return i;
    }
    
    
  
    /** 
     *  
     * @param args 
     *  
     * @throws FileNotFoundException 
     *  
     * 测试程序 
     *  
     */  
    public static void main(String[] args) throws FileNotFoundException {  
  
         
        File f1 = new File("F:/test/1.jpg");  
        String filename = f1.getName();  
        System.out.println(filename);  
        //InputStream input = new FileInputStream(f1);  
        //FtpClientUtil a = new FtpClientUtil();  
        //a.uploadFile("172.25.5.193", 21, "shiyanming", "123", path, filename, input);  
        /* 
         * String path ="D:\\ftpindex\\"; File f2 = new 
         * File("D:\\ftpindex\\old.txt"); String filename2= f2.getName(); 
         * System.out.println(filename2); FtpClientUtil a = new 
         * FtpClientUtil(); a.downFile("172.25.5.193", 21, "shi", "123", path, 
         * filename2, "C:\\"); 
         */  
        FtpClientUtil a = new FtpClientUtil();  
        InputStream input = new FileInputStream(f1);  
//      a.uploadFile("218.108.250.205", 21, "hwyhftp", "!#hwyhftp", path, filename, input);  
        //a.deleteFile("218.108.250.205", 21, "hwyhftp", "!#hwyhftp", path, filename);  
//      a.downFile("218.108.250.205", 21, "hwyhftp", "!#hwyhftp", path, "欢[2].txt");  
        
        FtpEntity f=new FtpEntity();
        f.setIpAddr("192.168.2.36");
        f.setUserName("addAndUpdate");
        f.setPwd("xie8687qiang520");
        f.setPort(2000);
        
        FTPClient ftp = a.getConnectionFTP(f); 
        String path = "/images/uploads/"; 
        //创建文件夹
        a.createDir(ftp, "/images/uploads");
        
//      a.deleteFile(ftp, path, "a[2].txt");  
        a.uploadFile(ftp, path, filename, input);  
        a.closeFTP(ftp);  
    }
}
