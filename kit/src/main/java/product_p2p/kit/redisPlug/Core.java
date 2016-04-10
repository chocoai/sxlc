package product_p2p.kit.redisPlug;

import product_p2p.kit.RSA.RSAPlugn;
import redis.clients.jedis.Jedis;

public class Core {
	private static final int JEDIS_EXPIRE = 60 * 60;
	private static Jedis jedis;
	
	static{
		jedis = new Jedis("localhost");
	}
	/****
	 * 写入一个字符串
	 * @param str
	 * @return 受影响的行数
	 */
	public static Long putString(String key,String value){
		long l = jedis.append(key,value);
		jedis.expire(key, JEDIS_EXPIRE);
		return l;
	}
	
	/***
	 * 获取一个字符串
	 * @param key
	 * @return
	 */
	public static String getString(String key){
		return jedis.get(key);
	}
	
	/***
	 * 删除一个对象
	 * @param key		主键
	 * @return  删除掉的行数
	 */
	public static Long delObject(String key){
		return jedis.del(key);
	}
	
	/***
	 * 检查一个KEY是否存在
	 * @param key
	 * @return
	 */
	public static Boolean exists(String key){
		return jedis.exists(key);
	}
	
	/***
	 * 为一个KEY设置过期时间
	 * <br>设置这个将在s秒后过期
	 * @param key			主键
	 * @param s				秒
	 * @return 受影响的行数
	 */
	/*public static Long expire(String key,int s){
		return jedis.expire(key, s);
	}*/
	
	/***
	 * 为一个KEY指定过期时间,这个Object将在time过期失效
	 * @param key
	 * @param time 				Unix时间戳
	 * @return
	 */
	public static Long expireat(String key,long time){
		return jedis.expireAt(key, time);
	}
	
	/***
	 * 在已有的key中随机获取一个key出来
	 * @return	key
	 */
	public static String randomKey(){
		return jedis.randomKey();
	}
	
	/***
	 * 更改一个主键的名称
	 * @param oldKey			旧(历史)的KEY名称
	 * @param newKey			新的KEY名称
	 * @return 返回OK标示修改成功
	 */
	public static String reNmae(String oldKey,String newKey){
		return jedis.rename(oldKey, oldKey);
	}
	
	/***
	 * 获取值的部分数据信息
	 * @param key				主键 
	 * @param start				开始位置
	 * @param end				结束位置
	 * @return
	 */
	public static String getRange(String key,int start,int end){
		return jedis.getrange(key, start, end);
	}
	
	
	/***
	 * 讲一个对象放入Redis中的
	 * @param key				主键
	 * @param object			值
	 * @return 
	 */
	public static String setObject(String key,Object object){
		return jedis.set(key.getBytes(), SerializeUtil.serialize(object));
	}
	

	/***
	 * 取出Redis中的一个对象
	 * @param key				主键
	 * @return 
	 */
	public static Object getObject(String key){
		byte[] bInfo = jedis.get(key.getBytes());
		if(bInfo == null){
			return null;
		}else{
			return SerializeUtil.unserialize(bInfo);
		}
	}
	
	
	/***
	 * 写入用户RSA到Redis中
	 * @param apply_id				APP应用编号
	 * @param plugn					加密RSA对象
	 * @return 
	 */
	public static int putRsa(String apply_id,Object plugn){
		int result = 0;
		try {
			jedis.set(apply_id.getBytes(), SerializeUtil.serialize(plugn));
			jedis.expire(apply_id.getBytes(),JEDIS_EXPIRE);
			result = 1;
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	
	
	/***
	 * 根据会员登录名称获取登录验证码
	 * @param userName
	 * @return
	 */
	public static Object getVerCodeByUserLognName(String userName) {
		return jedis.get(userName+"dl");
	}
	
	
	
	/***
	* 根据手机号获取短信验证码
	* 登录的时候根据手机号获取短信验证码
	* @author 李杰 
	* @Title: getVerCodeByPhone 
	* @param phone	
	* @return Object 返回类型 String 6位验证码
	* @date 2016-3-21 上午9:26:03
	 */
	public static Object getVerCodeByPhone(String phone){
		return jedis.get(phone+"dl");
	}
	
	
	
	/***
	* 根据手机号作为Key将登录验证码缓存起来
	* @author 李杰 
	* @Title: putVerCodeByPhone 
	* @return 设定文件 
	* @return int 返回类型  1缓存成功
	* @date 2016-3-21 上午9:29:13
	* @throws
	 */
	public static int putVerCodeByPhone(String phone,String code){
		jedis.set(phone+"dl", code);
		jedis.expire(phone+"dl", 180);
		return 1;
	}
	
	
	
	
	
	
	
}