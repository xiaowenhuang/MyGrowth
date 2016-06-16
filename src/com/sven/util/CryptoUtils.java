package com.sven.util;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类
 * @author sven 2016年6月16日
 *
 */
public class CryptoUtils {
	/**
	 * 加密
	 * @param plaintext 明文（密码）
	 * @param salt 加密盐(用户名的大写)
	 * @return 十六进制密文
	 */
	public static String encrypt(String plaintext,String salt){
		final ConfigurableHashService hashService = new DefaultHashService();
	
	    hashService.setPrivateSalt(ByteSource.Util.bytes("PXD-PASSWORD"));
	    hashService.setHashAlgorithmName("SHA-512");
	
	
	    hashService.setHashIterations(2);
	    
	
	    final String dynaSalt = salt;
	    final HashRequest request = new HashRequest.Builder()
	                                .setSalt(dynaSalt)
	                                .setSource(plaintext)
	                                .build();
	    String ciphertext = hashService.computeHash(request).toHex();
	    return ciphertext;
	}
	/**测试加密入口
	 * @author sven 2016年6月16日
	 * @param args
	 */
	public static  void main(String[] args){
		String pass = "testadmin";
		
		String salt = "testadmin".toUpperCase();
		//CryptoUtils cu = new CryptoUtils();
		String newpd = CryptoUtils.encrypt(pass, salt);
		System.out.println(newpd);
/*		Userinfo ui = getSSOUserInfo("1");
		ui.setPASSWORD(newpd);//设置新密码
		//ui.setDISPLAYNAME(display_name);//设置新昵称
		Map<String,Object> columnValueMap = BeanUtils.tarnsBeanPropertiesToMap(ui);
		ssojdbc.modify("userinfo", columnValueMap);//更新SSO数据库中userinfo表中的数据
*/	}
}
