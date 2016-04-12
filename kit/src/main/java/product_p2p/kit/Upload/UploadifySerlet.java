package product_p2p.kit.Upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//import com.PublicBenefitBack.common.FtpClientUtil;

public class UploadifySerlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//上传文件的保存路径
	protected String configPath = "images/product/uploads/";
	//公共图片文件，前后台可以共享
	//protected String configPath = "../publicImages/images/";

	protected String dirTemp = "images/product/uploads/temp/";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String sFileSeparator = "/";
		if(FtpClientUtil.sFtpServer == 1){
			sFileSeparator = "\\";
			configPath.replace("/", "\\");
			dirTemp.replace("/", "\\");
		}
		
		//文件保存目录路径
//		String savePath = this.getServletContext().getRealPath("/") + configPath;
		
		// 临时文件目录 
		String tempPath = this.getServletContext().getRealPath("/") + dirTemp;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ymd = sdf.format(new Date());
//		savePath += ymd + File.separator;
		//创建文件夹
//		File dirFile = new File(savePath);
//		if (!dirFile.exists()) {
//			dirFile.mkdirs();
//		}
		
		/*tempPath += File.separator + ymd + File.separator;
		//创建临时文件夹
		File dirTempFile = new File(tempPath);
		if (!dirTempFile.exists()) {
			dirTempFile.mkdirs();
		}*/
		
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		factory.setSizeThreshold(20 * 1024 * 1024); //设定使用内存超过5M时，将产生临时文件并存储于临时目录中。   
		factory.setRepository(new File(tempPath)); //设定存储临时文件的目录。   

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		String sResultInfo = "";
		 
		try {
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			
			String name = "";
			String qq = "";
			
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				String fileName = item.getName();
				if (!item.isFormField()) {
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
					try{
	                    InputStream is = item.getInputStream();
	                    //上传至FTP
	                    String path_ftp = sFileSeparator+configPath+ymd+ sFileSeparator;
	                    FtpClientUtil.FtpUploadFileUtilEnd(is, newFileName, path_ftp);
	                    sResultInfo = FtpClientUtil.getFtpFilePath();
	                    if(sResultInfo!=null){
	                    	sResultInfo = sResultInfo.substring(0, sResultInfo.length()-1);
	                    }
	                    out.print(sResultInfo+","+path_ftp+newFileName);
					}catch(Exception e){
						e.printStackTrace();
					}
				}else {
					String filedName = item.getFieldName();
					if (filedName.equals("userName")) {
						name = item.getString();
					}else {
						qq = item.getString();
					}
				}			
			} 
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
	
}
