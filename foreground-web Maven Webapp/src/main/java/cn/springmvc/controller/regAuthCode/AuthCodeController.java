package cn.springmvc.controller.regAuthCode; 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import product_p2p.kit.datatrans.IntegerAndString;

/** 
* @author 唐国峰
* @Description: 验证码控制器
* @date 2016-3-30 下午3:09:44  
*/
@Controller
public class AuthCodeController {
	//设置画布大小 
    private static final int IMG_WIDTH=146; 
    private static final int IMG_HEIGHT=30; 
    //设置干扰线条数
    private static final int DISTURB_LINE_SIZE = 1;  
    //设置字体及字号
    private final Font font = new Font("宋体", Font.BOLD, 18);  
    private Random random = new Random(); 
    private int xyresult;  //运算结果 
    private String randomString;//验证码字符串
    private static final String CVCNUMBERS = "\u96F6\u4E00\u4E8C\u4E09\u56DB\u4E94\u516D\u4E03\u516B\u4E5D\u5341\u4E58\u9664\u52A0\u51CF";//大写的数字
    private static final Map<String, Integer> OPMap = new HashMap<String, Integer>();  
    static{  
        OPMap.put("*", 11);  
        OPMap.put("/", 12);  
        OPMap.put("+", 13);  
        OPMap.put("-", 14);  
    }
	
	/** 
	* authImage(生成验证码) 
	* @author 唐国峰  
	* @Description: 随机生成10以内的加减乘除算法，并以中文显示
	* @return void 
	* @date 2016-3-30 下午3:20:39
	* @throws 
	*/
	@RequestMapping("/authImage")
	public void authImage(HttpServletRequest request,
			HttpServletResponse response) {
		Integer type = IntegerAndString.StringToInt(request.getParameter("type"),0);//0 登录等地方  1忘记密码    
		try {
	        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);  
	        //画笔
	        Graphics g = image.getGraphics();  
	        //设置验证码图片背景为白色
	        g.setColor(Color.WHITE);  
	        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);  
	        //生成图片边框
	        g.setColor(getRandomColor(200,250));  
	        g.drawRect(0, 0, IMG_WIDTH-2, IMG_HEIGHT-2);  
	        //生成干扰线
	        g.setColor(getRandomColor(110, 133));  
	        for(int i =0;i < DISTURB_LINE_SIZE; i++){  
	            drawDisturbLine1(g);  
	            drawDisturbLine2(g);  
	        }  
	        //生成算式
	        getRandomMathString(); 
	        StringBuffer logsu = new StringBuffer();  
	        for(int j=0,k = randomString.length(); j < k; j++){  
		          int chid = 0;  
		          if(j==1){
		              chid = OPMap.get(String.valueOf(randomString.charAt(j)));  
		          }else{
		              chid = Integer.parseInt(String.valueOf(randomString.charAt(j)));  
		          }
		          String ch = String.valueOf(CVCNUMBERS.charAt(chid));  
		          logsu.append(ch);  
		          drawRandomString((Graphics2D)g,ch, j);  
	        }  
	        //生成后缀： “等于？”  
	        drawRandomString((Graphics2D)g,"\u7B49\u4E8E\uFF1F", 3);  
	        logsu.append("\u7B49\u4E8E \uFF1F");  
	        randomString = logsu.toString();  
	        System.out.println("验证码:" + randomString + " 值：" + xyresult);
	        
	        HttpSession session = request.getSession(true);
	        if(type==0){
	        	session.removeAttribute("AUTH_IMG_CODE_IN_SESSION");
	        	session.setAttribute("AUTH_IMG_CODE_IN_SESSION", xyresult);
	        }else if(type==1){//忘记密码
	        	session.removeAttribute("AUTH_IMG_CODE_IN_SESSION_FORGETPWD");
	        	session.setAttribute("AUTH_IMG_CODE_IN_SESSION_FORGETPWD", xyresult);
	        }else{
	        	session.removeAttribute("AUTH_IMG_CODE_IN_SESSION");
	        	session.setAttribute("AUTH_IMG_CODE_IN_SESSION", xyresult);
	        }
			//设置http响应头
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
	        
	        OutputStream os = response.getOutputStream();
			ImageIO.write(image, "JPEG", os);
			g.dispose();  
			os.flush();  
			os.close();  
			os = null;  
			response.flushBuffer();  
		} catch (IOException e) {
			//log.error("生成验证码异常!",e);
		} 
    }  
    
	 
	/** 
	* getRandomColor(生成随机颜色) 
	* @author 唐国峰  
	* @Description: 随机生成RGB颜色
	* @return Color
	* @date 2016-3-30 下午4:05:26
	* @throws 
	*/
	public Color getRandomColor(int fc,int bc){  
	        if(fc > 255){  
	            fc = 255;  
	        }  
	        if(bc > 255){  
	            bc = 255;  
	        }  
	        int r = fc+random.nextInt(bc -fc - 16);  
	        int g = fc+random.nextInt(bc - fc - 14);  
	        int b = fc+random.nextInt(bc - fc - 18);  
	        return new Color(r, g, b);  
	    }  
	
	/** 
	* drawDisturbLine1(干扰线1) 
	* @author 唐国峰  
	* @Description: 
	* @param g 
	* @return void 
	* @date 2016-3-30 下午3:33:55
	* @throws 
	*/
	public void drawDisturbLine1(Graphics g){  
	     int x1 = random.nextInt(IMG_WIDTH);  
	     int y1 = random.nextInt(IMG_HEIGHT);  
	     int x2 = random.nextInt(13);  
	     int y2 = random.nextInt(15);  
	     g.drawLine(x1, y1, x1 + x2, y1 + y2);  
	}  
   
	
	/** 
	* drawDisturbLine2(干扰线2) 
	* @author 唐国峰  
	* @Description: 
	* @param g 
	* @return void 
	* @date 2016-3-30 下午3:35:57
	* @throws 
	*/
	public void drawDisturbLine2(Graphics g){  
	     int x1 = random.nextInt(IMG_WIDTH);  
	     int y1 = random.nextInt(IMG_HEIGHT);  
	     int x2 = random.nextInt(13);  
	     int y2 = random.nextInt(15);  
	     g.drawLine(x1, y1, x1 - x2, y1 - y2);  
	}  
	 
	 
	/** 
	* drawRandomString(画随机字符) 
	* @author 唐国峰  
	* @Description: 
	* @return void
	* @date 2016-3-30 下午3:51:29
	* @throws 
	*/
	public void drawRandomString(Graphics2D g,String randomvcch,int i){  
			//字体
			g.setFont(font);  
	        //颜色
	        int rc = random.nextInt(255);  
	        int gc = random.nextInt(255);  
	        int bc = random.nextInt(255);  
	        g.setColor(new Color(rc, gc, bc));  
	        //设置画笔的起点
	        int x = random.nextInt(3);  
	        int y = random.nextInt(2);  
	        g.translate(x, y);  
	        //设置字体旋转角度  
	        int degree = new Random().nextInt() % 15;  
	        //Positive point of view  
	        g.rotate(degree * Math.PI / 180, 5+i*25, 20);  
	        //在指定坐标画上字符串  
	        g.drawString(randomvcch, 5+i*25, 20);  
	        //Reverse Angle  
	        g.rotate(-degree * Math.PI / 180, 5+i*25, 20);  
	    }  
	
	/** 
	* getRandomMathString(生成随机算式) 
	* @author 唐国峰  
	* @Description: 10以内的随机数以及随机生成运算符号
	* @date 2016-3-30 下午3:42:10
	* @throws 
	*/
	private void getRandomMathString(){  
	     int xx = random.nextInt(10);  
	     int yy = random.nextInt(10);  
	     StringBuilder suChinese =  new StringBuilder();  
	         //生成随机运算码（0：乘，1：除，2：减，其它：加）
	         int Randomoperands = (int) Math.round(Math.random()*2);  
	         if(Randomoperands ==0){  
	             this.xyresult = yy * xx;  
	             suChinese.append(yy);  
	             suChinese.append("*");  
	             suChinese.append(xx);  
	         }else if(Randomoperands ==1){  
	             if(!(xx==0) && yy%xx ==0){  
	                 this.xyresult = yy/xx;  
	                 suChinese.append(yy);  
	                 suChinese.append("/");  
	                 suChinese.append(xx);  
	             }else{  
	                 this.xyresult = yy + xx;  
	                 suChinese.append(yy);  
	                 suChinese.append("+");  
	                 suChinese.append(xx);  
	             }  
	         }else if(Randomoperands ==2){  
	                 this.xyresult = yy - xx;  
	                 suChinese.append(yy);  
	                 suChinese.append("-");  
	                 suChinese.append(xx);  
	         }else{  
	                 this.xyresult = yy + xx;  
	                 suChinese.append(yy);  
	                 suChinese.append("+");  
	                 suChinese.append(xx);  
	         }
	   this.randomString = suChinese.toString();  
	}  
    
	/** 
	 * checkAuthCode(验证码前端ajax验证的实现方法)  
	 * @author 唐国峰  
	 * @Description: 把前端页面中的输入的验证码跟session中的系统验证码对比。 相等，输出1;如果不相等，输出0。 
	 * @date 2016-3-30 下午4:38:00
	 */
	@RequestMapping("/checkAuthCode")
	public void checkAuthCode(HttpServletRequest req,HttpServletResponse res){
		//前端页面中的输入的验证码
		String authCode = req.getParameter("pAuthCode");
		//session中的系统验证码
        int sysAuth = Integer.parseInt((String) req.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION"));
        String sysAuthCode =String.valueOf(sysAuth);
        PrintWriter out = null;     
		try {
			out = res.getWriter();
	        if(authCode==null || "".equals(authCode) || sysAuthCode==null || "".equals(sysAuthCode)){
	        	out.print("0");
	        }else{
	 			if(authCode.equalsIgnoreCase(sysAuthCode)){//如果是字母，忽略大小写
	 				out.println("1"); 
	            }else{
	            	out.print("0");
	            } 
	        } 
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
            out.close();
        }
	}
}

