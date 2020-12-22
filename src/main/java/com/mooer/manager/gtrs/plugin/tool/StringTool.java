package com.mooer.manager.gtrs.plugin.tool;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * @author main
 *
 */
public class StringTool {

	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(999);
		// 如果不足两位前面补0
		String str = millis + String.format("%03d", end2);
		long id = new Long(str);
		return id;
	}

	public static boolean isDigit(String str) {
		if (null == str || str.length() == 0) {
			return false;
		}

		for (int i = str.length(); --i >= 0;) {
			int c = str.charAt(i);
			if (c < 48 || c > 57) {
				return false;
			}
		}

		return true;
	}
	
	public static String UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
