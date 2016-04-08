package cn.springmvc.httpRequest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import product_p2p.kit.RSA.RSAPlugn;
import product_p2p.kit.constant.Constant;




/****
 * 处理请求参数解密
 * <br>原理装饰HttpServletRequest的getParameter方法,对获取的参数解密后在返回
 * @author LiJie
 *
 */
public class DecryptHttpServletRequest extends HttpServletRequestWrapper{
	
	private String privateKey;
	
	public DecryptHttpServletRequest(HttpServletRequest request) {
		super(request);
		privateKey = (String) request.getSession().getAttribute(Constant.publicKey);
	}

	@Override
	public String getParameter(String name) {
		String ciphertext = super.getParameter(name);
		if (privateKey == null) {
			return ciphertext;
		}else{
			return RSAPlugn.decryptByPrivateKey(ciphertext, privateKey);
		} 
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] names =  super.getParameterValues(name);
		if (privateKey == null) {
			
			return names;
		}else{
			String[] param = new String[name.length()];
			for (int i = 0; i < names.length; i++) {
				param[i] = (RSAPlugn.decryptByPrivateKey(names[i],privateKey));
			}
			return param;
		}
	}
	
}

