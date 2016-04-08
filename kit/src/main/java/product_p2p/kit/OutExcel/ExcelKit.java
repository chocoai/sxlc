package product_p2p.kit.OutExcel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


/***
* 导出数据到Excel
* @author 李杰
* @since 
* @date 2016-3-21 下午2:15:41
 */
public class ExcelKit<T> {

	private WritableWorkbook 	workbook 	= null;
	private WritableSheet 		sheet 		= null;
	private List<T> 			data;
	private String		 		name;
	private OutExcel 			oe;
	private	Label 				label 		= null;
	private List<List<T>> 		ioc 		= new ArrayList<List<T>>();
	private int 				row 		= 1;
	private int 				sheetNumber = 1;
	private int 				cindex 		= 0;
	
	/***
	* 如果需要导出成文件
	* @author 李杰 
	* @param os							文件输出流
	* @param objs						数据集合
	* @param fileName					导出的文件标题
	* @param excel 设定文件 				元数据解析器				
	* @return void 返回类型 
	* @date 2016-3-21 下午8:30:47
	* @throws
	 */
	public void init(OutputStream os,List<T> objs,String fileName,OutExcel excel){
		try {
			workbook = Workbook.createWorkbook(os);
			name = fileName;
			ioc.add(objs);
			oe = excel;
			loading();
		} catch (IOException e) {
			System.out.println("创建工作表异常,请检查输出流");
		}
	}
	
	
	public WritableSheet createSheet(String name,Integer number){
		String[] head = oe.setHead();
		sheet = workbook.createSheet(name, number);
		for (int i = 0; i < head.length; i++) {
			label = new Label(i, 0, head[i]);
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				System.out.println("工作表行数超出限制了");
			} catch (WriteException e) {
				System.out.println("写入数据异常");
			}
		}
		return sheet;
	}
	
	
	public void loading(){
		data = getList();
		if(data == null){
			return;
		}
		for (int i = 0; i < data.size(); i++) {
			if(row >= 65535 || sheetNumber == 1){
				sheetNumber++;
				sheet = createSheet(name+sheetNumber,sheetNumber);
				row = 1;
			}else{
				row++;
			}
			
			String[] attribute = oe.readAttribute(data.get(i));
			for (int j = 0; j < attribute.length; j++) {
				label = new Label(j, row, attribute[j]);
				try {
					sheet.addCell(label);
				} catch (RowsExceededException e) {
					System.out.println("工作表行数超出限制了");
				} catch (WriteException e) {
					System.out.println("写入数据异常");
				}
			}
		}
		if(ioc.size() > cindex+1){
			loading();
		}
	}
	
	
	public void addList(List<T> objs){
		if(ioc.size() == cindex){
			ioc.add(objs);
			loading();
		}else{
			ioc.add(objs);
		}
	}
	
	
	public List<T> getList(){
		List<T> data = null;
		if(ioc.size() > cindex){
			data = ioc.get(cindex);
			ioc.set(cindex, null);
			cindex++;
		}
		return data;
	}
	
	
	public void close(){
		try {
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			System.out.println("写入数据异常");
		} catch (IOException e) {
			System.out.println("关闭文件流出现异常");
		}
	}
	
	/***
	* 下载导出
	* @author 李杰 
	* @Title: out 
	* @param response					HttpServletResponse响应对象	
	* @param objs						数据集
	* @param fileName					导出文件标题
	* @param excel 设定文件 				元数据解析器
	* @return void 返回类型 
	* @date 2016-3-21 下午8:30:51
	* @throws
	 */
	public void out(HttpServletResponse response,List<T> objs,String fileName,OutExcel excel){
		//创建工作流   
		ServletOutputStream os = null; 
		try {
			//设置弹出对话框   
			response.setContentType("application/DOWLOAD");
			try {
				name = new String(name.getBytes(), "iso8859-1");//解决中文 文件名问题  
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置工作表的标题
			response.setHeader("Content-Disposition","attachment;filename="+name+".xls");
			os = response.getOutputStream();
			init(os, objs, fileName, excel);
		}catch (Exception e) {
			
		}
	}
	
}

