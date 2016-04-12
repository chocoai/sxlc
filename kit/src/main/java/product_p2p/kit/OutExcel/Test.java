package product_p2p.kit.OutExcel; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test implements OutExcel{

	
	
	public static void main(String[] args) throws FileNotFoundException {
		Test test = new Test();
		test.op();
	}
	
	public void op() throws FileNotFoundException{
		Admin admin = null;
		//导出数据
		List<Admin> list = new ArrayList<Admin>();
		for (int i = 0; i < 100000; i++) {
			admin = new Admin();
			admin.setEmail("email"+i);
			admin.setName("name"+i);
			list.add(admin);
		}
		//导出数据
		
		//
		FileOutputStream fos = new FileOutputStream(new File("C:/users/Administrator/Desktop/Test.xls"));
		
		//1
		ExcelKit<Admin> kit = new ExcelKit<Admin>();
		//2
		kit.init(fos, list, "列表", this);
		
		System.out.println("列表生成中");
		boolean islook = true;
		while (islook) {
			System.out.println("是否追加信息？y/n");
			Scanner in = new Scanner(System.in);
			String str = in.nextLine();
			if(str.equals("y")){
				List<Admin> admins = new ArrayList<Admin>();
				for (int i = 0; i < 10000; i++) {
					admin = new Admin();
					admin.setEmail("1277809056@qq.com"+i);
					admin.setName("审"+i);
					admins.add(admin);
				}
				//3
				kit.addList(admins);
				System.out.println("1W条数据添加完成");
			}else{
				//4
				kit.close();
				System.out.println("testApplication exit");
				islook = false;
			}
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			
		}
	}
	
	
	
	@Override
	public String[] readAttribute(Object obj) {
		Admin admin = (Admin) obj;
		return new String[]{admin.getEmail(),admin.getName()};
	}

	@Override
	public String[] setHead() {
		return new String[]{"邮件地址","会员登录名"};
	}
}

