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
		privateKey = (String) request.getSession().getAttribute(Constant.privateKey);
	}

	@Override
	public String getParameter(String name) {
		String ciphertext = super.getParameter(name);
		if("start".equals(name)){
			return ciphertext;
		}
		if("length".equals(name)){
			return ciphertext;
		}
		if("draw".equals(name)){//datatable 视图 可不传
			return ciphertext;
		}
		if("_index_m1".equals(name)){//视图 可不传
			return ciphertext;
		}
		if("_index_m2".equals(name)){// 视图 可不传
			return ciphertext;
		}
		if("_index_m3".equals(name)){// 视图 可不传
			return ciphertext;
		}
		if("auth".equals(name)){//角色权限
			return ciphertext;
		}
		if("content".equals(name)){//百度编辑器文本内容
			return ciphertext;
		}
		if (privateKey == null) {
			return ciphertext;
		}else if (ciphertext == null) {
			return null;
		}else {
				return RSAPlugn.decryptByPrivateKey(ciphertext, privateKey);
		}
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] names =  super.getParameterValues(name);
		if (privateKey == null || names == null) {
			
			return names;
		}else{
			String[] param = new String[names.length];
			for (int i = 0; i < names.length; i++) {
				param[i] = (RSAPlugn.decryptByPrivateKey(names[i],privateKey));
			}
			return param;
		}
	}
	
}

