package product_p2p.kit.RSA;


import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;



public class RSAPlugn implements Serializable{

	private static final long serialVersionUID = 380164102533066773L;

	public static Logger logger = Logger.getLogger(RSAPlugn.class);
	
//	private RSAPublicKey rsaPublicKey = null;
//	private RSAPrivateKey rsaPrivateKey = null;
	
	/***
	 * 最大解密密文大小
	 */
	public static final int MAX_DECRYPT_BLOCK = 128;
	
	/***
	 * 最大加密大小
	 */
	public static final int MAX_ENCRYPT_BLOCK = 117;
	
	/*public RSAPlugn() {
		//初始化密钥
		KeyPairGenerator generator = null;
		try {
			generator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			logger.error("初始化秘钥失败!");
			e.printStackTrace();
		}
		generator.initialize(1024);
		KeyPair keyPair = generator.generateKeyPair();
		rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
		logger.debug("public Key \t:"+new String(Base64.encodeBase64((rsaPublicKey.getEncoded()))));
		logger.debug("private Key\t:"+new String(Base64.encodeBase64((rsaPrivateKey.getEncoded()))));
		
	}*/
	
	public static KeyPair GetKeyPair(){
		//初始化密钥
		KeyPairGenerator generator = null;
		try {
			generator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			logger.error("初始化秘钥失败!");
			e.printStackTrace();
		}
		generator.initialize(1024);
		KeyPair keyPair = generator.generateKeyPair();
		logger.debug("public Key \t:"+new String(Base64.encodeBase64((keyPair.getPublic().getEncoded()))));
		logger.debug("private Key\t:"+new String(Base64.encodeBase64((keyPair.getPrivate().getEncoded()))));
		return keyPair;
	}
	
	/**
	 * 公钥  转  字符串
	* PublicKeyToString	公钥  转  字符串
	* TODO(描述)
	* @author 张友  
	* * @Title: PublicKeyToString 
	* @Description: TODO 
	* @param key					公钥
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-3-31 下午1:47:35
	* @throws
	 */
	public static String PublicKeyToString(RSAPublicKey key){
		String sResult = "";
		if(key != null){
			sResult = new String(Base64.encodeBase64((key.getEncoded())));
		}
		
		return sResult;
	}
	
	/**
	 * 私钥  转  字符串
	* PrivateKeyToString	私钥  转  字符串
	* TODO	私钥  转  字符串
	* @author 张友  
	* * @Title: PrivateKeyToString 
	* @Description: TODO 
	* @param  key	私钥
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-3-31 下午1:49:36
	* @throws
	 */
	public static String PrivateKeyToString(RSAPrivateKey key){
		String sResult = "";
		if(key != null){
			sResult = new String(Base64.encodeBase64((key.getEncoded())));
		}
		
		return sResult;
	}
	
	/***
	 * 公钥加密-私钥解密-加密
	 * @param source				欲加密的字符串
	 * @return
	 */
	public static String encryptionByPublicKey(String source,String sKey){
		byte[] result = null;
		try {
			/*RSAPublicKey publicKey = StringToPublicKey(sKey);
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
			KeyFactory factory = KeyFactory.getInstance("RSA");*/
			PublicKey publicKey = StringToPublicKey(sKey);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] sources = source.getBytes();
			int offSet = 0;
			byte[] chche;
			int i = 0;
			while (sources.length - offSet > 0) {
				if(sources.length - offSet > MAX_ENCRYPT_BLOCK){
					chche = cipher.doFinal(sources, offSet, MAX_ENCRYPT_BLOCK);
				}else{
					chche = cipher.doFinal(sources, offSet,sources.length - offSet);
				}
				out.write(chche);
				i++;
				offSet = i * MAX_ENCRYPT_BLOCK;
			}
			result = out.toByteArray();
			out.close();
			return new String(Base64.encodeBase64(result));
		} catch (Exception e) {
			logger.warn("公钥加密-加密异常");
		}
		return null;
	}
	
	
	/***
	 * 公钥解密-私钥加密-解密
	 * @param source				解密源
	 * @return
	 */
	public static String decryptByPublicKey(String source,String sKey){
		byte[] result = null;
		try {
			/*X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			KeyFactory factory = KeyFactory.getInstance("RSA");*/
			PublicKey publicKey = StringToPublicKey(sKey); //factory.generatePublic(x509EncodedKeySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] sources = Base64.decodeBase64(source);
			int offSet = 0;
			byte[] chche;
			int i = 0;
			while (sources.length - offSet > 0) {
				if(sources.length - offSet > MAX_DECRYPT_BLOCK){
					chche = cipher.doFinal(sources, offSet, MAX_DECRYPT_BLOCK);
				}else{
					chche = cipher.doFinal(sources, offSet,sources.length - offSet);
				}
				out.write(chche);
				i++;
				offSet = i * MAX_DECRYPT_BLOCK;
			}
			result = out.toByteArray();
			out.close();
			logger.debug("公钥解密-私钥加密-解密\t:"+new String(result));
			return new String(result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("公钥解密-解密异常");
		}
		return null;
	}
	
	
	
	/***
	 * 私钥加密-公钥解密-加密
	 * @param source				欲加密的字符串
	 * @return
	 */
	public static String encryptionByPrivateKey(String source,String sKey){
		byte[] result = null;
		try {
			/*PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory factory = KeyFactory.getInstance("RSA");*/
			PrivateKey privateKey =	StringToPrivateKey(sKey); // factory.generatePrivate(encodedKeySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] sources = source.getBytes();
			int offSet = 0;
			byte[] chche;
			int i = 0;
			while (sources.length - offSet > 0) {
				if(sources.length - offSet > MAX_ENCRYPT_BLOCK){
					chche = cipher.doFinal(sources, offSet, MAX_ENCRYPT_BLOCK);
				}else{
					chche = cipher.doFinal(sources, offSet,sources.length - offSet);
				}
				out.write(chche);
				i++;
				offSet = i * MAX_ENCRYPT_BLOCK;
			}
			result = out.toByteArray();
			out.close();
			return new String(Base64.encodeBase64(result));
		} catch (Exception e) {
			logger.warn("公钥解密-解密异常");
		}
		return null;
	}
	
	
	
	/***
	 * 私钥解密-公钥加密-解密
	 * @param source				解密源
	 * @return
	 */
	public static String decryptByPrivateKey(String source,String sKey){
		byte[] result = null;
		try {
			/*PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory factory = KeyFactory.getInstance("RSA");*/
			PrivateKey privateKey = StringToPrivateKey(sKey);		//factory.generatePrivate(encodedKeySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] sources = Base64.decodeBase64(source);
			int offSet = 0;
			byte[] chche;
			int i = 0;
			while (sources.length - offSet > 0) {
				if(sources.length - offSet > MAX_DECRYPT_BLOCK){
					chche = cipher.doFinal(sources, offSet, MAX_DECRYPT_BLOCK);
				}else{
					chche = cipher.doFinal(sources, offSet,sources.length - offSet);
				}
				out.write(chche);
				i++;
				offSet = i * MAX_DECRYPT_BLOCK;
			}
			result = out.toByteArray();
			out.close();
			logger.debug("私钥加密、公钥解密-解密\t:"+new String(result));
			return new String(result);
		} catch (Exception e) {
			logger.warn("私钥解密-解密异常");
		}
		return null;
	}
	
	/**
	 * 字符串转化为私钥
	* StringToPrivateKey	字符串转化为私钥 
	* TODO(描述)
	* @author 张友  
	* * @Title: StringToPrivateKey 
	* @Description: TODO 
	* @param sPrivateKey		私钥字符串
	* @param @return 设定文件 
	* @return PrivateKey 返回类型 
	* @date 2016-3-30 上午11:55:24
	* @throws
	 */
	private static PrivateKey StringToPrivateKey(String sPrivateKey){
		PKCS8EncodedKeySpec priPKCS8;
		PrivateKey privateKey = null;
        try {
        	priPKCS8 = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(sPrivateKey));
        	KeyFactory keyf = KeyFactory.getInstance("RSA");
        	privateKey = keyf.generatePrivate(priPKCS8);
        } catch (Exception e) {
        	logger.warn("私钥转换异常" + e.getLocalizedMessage());
        }
        return privateKey;
	}
	
	/**
	 * 字符串转化为公钥
	* StringToPublicKey 字符串转化为公钥
	* TODO(描述)
	* @author 张友  
	* * @Title: StringToPublicKey 
	* @Description: TODO 
	* @param @param sKey
	* @param @return 设定文件 
	* @return PublicKey 返回类型 
	* @date 2016-3-30 上午11:47:13
	* @throws
	 */
	private static PublicKey StringToPublicKey(String sKey){
		PublicKey publickey = null;
		try {
			KeyFactory keyFactory=KeyFactory.getInstance("RSA"); 
	        X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(sKey));
	        // 取公钥匙对象
	        publickey = keyFactory.generatePublic(bobPubKeySpec);
		} catch (Exception e) {
			// TODO: handle exception
			logger.warn("公钥转换异常" + e.getLocalizedMessage());
		}
		return publickey;
	}
	
	/**
	 * 获取私钥
	* privateKey	获取私钥 
	* TODO(描述)
	* @author 张友  
	* * @Title: privateKey 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-3-30 上午10:28:27
	* @throws
	 */
	/*public String privateKey(){
		return new String(Base64.encodeBase64(rsaPrivateKey.getEncoded()));
	}*/
	
	/***
	 * 获取publicKey
	 * @return
	 */
	/*public String publicKey(){
		return new String(Base64.encodeBase64(rsaPublicKey.getEncoded()));
	}*/
	
}