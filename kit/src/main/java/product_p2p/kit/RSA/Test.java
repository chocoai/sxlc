package product_p2p.kit.RSA;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;



/***
 * TEst
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		String source = "骆甲 阿斯顿骆驼暗黑世界将哈哈";
		
		KeyPair plugn = RSAPlugn.GetKeyPair();
		
		String publicKey 	= RSAPlugn.PublicKeyToString((RSAPublicKey)plugn.getPublic());
		String privateKey 	= RSAPlugn.PrivateKeyToString((RSAPrivateKey)plugn.getPrivate());
		/*String shiyaojiami = plugn.encryptionByPrivateKey(source);
		System.out.println("私钥加密："+shiyaojiami);
		String gongyaojiemi = plugn.decryptByPublicKey(shiyaojiami);
		System.out.println("公钥解密："+gongyaojiemi);
		
		System.out.println("公钥加密："+gongyaojiami);
		plugn.decryptByPrivateKey(source,publicKey);
		System.out.println("私钥解密："+shiyaojiemi);*/
		System.out.println(publicKey);
		System.out.println(privateKey);
		String shiyaojiami = RSAPlugn.encryptionByPublicKey(source,publicKey);
		String shiyaojiemi = RSAPlugn.decryptByPrivateKey(shiyaojiami,privateKey);
		System.out.println(shiyaojiami);
		System.out.println(shiyaojiemi);
		
	}
}
