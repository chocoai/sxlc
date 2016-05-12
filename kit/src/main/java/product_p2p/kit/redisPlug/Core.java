package product_p2p.kit.redisPlug;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Core {
	private static final int JEDIS_EXPIRE = 60 * 60;
	private static Jedis jedis;
	private static JedisPool pool = null;  
	
	static{
		jedis = new Jedis("localhost");
		if (pool == null) {
			// 建立连接池配置参数
            JedisPoolConfig config = new JedisPoolConfig();
            // 设置最大连接数
            config.setMaxIdle(500);
            // 设置最大阻塞时间，记住是毫秒数milliseconds
            config.setMaxWaitMillis(1000 * 100);
            // 设置空间连接
            config.setMaxIdle(5);  
            
            config.setTestOnBorrow(true);
            // 创建连接池
            pool = new JedisPool(config, "192.168.2.8", 6379);  
        }  
	}
	
	 /** 
     * 返还到连接池 
     *  
     * @param pool  
     * @param redis 
     */  
    public static void returnResource(Jedis redis) {  
        if (redis != null) {  
            pool.returnResource(redis);
        }  
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
	public static Long expire(String key,int s){
		return jedis.expire(key, s);
	}
	
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
			byte[] bInfo = apply_id.getBytes();
			byte[] bSInfo = SerializeUtil.serialize(plugn);
			jedis.set(bInfo, bSInfo);
			jedis.expire(apply_id.getBytes(),JEDIS_EXPIRE);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
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

	
	/***
	* 缓存注册发送的短信验证码
	* 
	* @author 李杰
	* @Title: putRegisterPhoneCode
	* @param phone
	* @param code
	* @return 1缓存成功
	* @Description: TODO
	* @date 2016-4-15 上午9:48:39
	 */
	public static int putRegisterPhoneCode(String phone,String code){
		putString(phone+"register", code);
		jedis.expire(phone+"register", 180);
		return 1;
	}
	
	/***
	* 获取缓存中的注册短信验证码
	* @author 李杰
	* @Title: getRegisterPhoneCode
	* @param phone
	* @return
	* @Description: TODO
	* @date 2016-4-15 上午11:05:27
	 */
	public static String getRegisterPhoneCode(String phone){
		return getString(phone+"register");
	}
	
	/**
	 * 缓存忘记密码中发送的短信验证码
	 * putForgetPWDPhoneCode
	 * @author 邱陈东  
	 * * @Title: putForgetPWDPhoneCode 
	 * @param @param phone
	 * @param @param code
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-5-6 下午4:11:40
	 * @throws
	 */
	public static int putWithdrawPhoneCode(String phone,String code){
		putString(phone+"Withdraw", code);
		jedis.expire(phone+"Withdraw", 180);
		return 1;
	}
	
	public static String getWithdrawPhoneCode(String phone){
		return getString(phone+"Withdraw");
	}
	
	public static int putForgetPWDPhoneCode(String phone,String code){
		putString(phone+"ForgetPWD", code);
		jedis.expire(phone+"ForgetPWD", 180);
		return 1;
	}
	/**
	 * 获取忘记密码中发送的短信验证码
	* getForgetPWDPhoneCode
	* @author 邱陈东  
	* * @Title: getForgetPWDPhoneCode 
	* @param @param phone
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午4:16:43
	* @throws
	 */
	public static String getForgetPWDPhoneCode(String phone){
		return getString(phone+"ForgetPWD");
	}
	
	public static int putForgetPWDStatu(String phone,String statu){
		putString(phone+"ForgetPWDStatu", statu);
		jedis.expire(phone+"ForgetPWDStatu", 1800);
		return 1;
	}
	/**
	 * 获取忘记密码中发送的短信验证码
	* getForgetPWDPhoneCode
	* @author 邱陈东  
	* * @Title: getForgetPWDPhoneCode 
	* @param @param phone
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午4:16:43
	* @throws
	 */
	public static String getForgetPWDStatu(String phone){
		return getString(phone+"ForgetPWDStatu");
	}
	
	/***
	* 缓存修改手机绑定验证码
	* 
	* @author 李杰
	* @param phone
	* @param code
	* @return
	* @date 2016-4-26 下午8:54:57
	 */
	public static int putEditBindPhoneCode(String phone,String code){
		putString(phone+"editBindPhone", code);
		jedis.expire(phone+"editBindPhone", 180);
		return 1;
	}
	
	/***
	* 获取修改手机绑定验证码
	* @author 李杰
	* @param newPhone
	* @return
	* @date 2016-4-26 下午8:07:14
	 */
	public static String getEditBindPhoneCode(String newPhone) {
		return getString(newPhone+"editBindPhone");
	}

	/***
	* 获取绑定邮箱验证码
	* 
	* @author 李杰
	* @param email
	* @return
	* @date 2016-4-27 上午11:24:32
	 */
	public static int putBindEmailCode(String email,String code) {
		putString(email+"bindEmail", code);
		jedis.expire(email+"bindEmail", 180);
		return 1;
	}
	
	/***
	* 获取绑定邮箱验证码
	* 
	* @author 李杰
	* @param email
	* @return
	* @date 2016-4-27 上午11:24:32
	 */
	public static String getBindEmailCode(String email) {
		return getString(email+"bindEmail");
	}
	
	
	
	
}