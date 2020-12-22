package com.mooer.manager.gtrs.plugin.tool;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 根据IP地址获取详细的地域信息工具类
 * 
 * 已测试
 * 
 * @project:personGocheck
 * 
 * @class:AddressUtils.java
 *
 * 
 * 
 */

public class IpUtil {
	
	
	public static String getRealIP(HttpServletRequest request) {
	    String ip = null;

	    //X-Forwarded-For：Squid 服务代理
	    String ipAddresses = request.getHeader("X-Forwarded-For");

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //Proxy-Client-IP：apache 服务代理
	        ipAddresses = request.getHeader("Proxy-Client-IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //WL-Proxy-Client-IP：weblogic 服务代理
	        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //HTTP_CLIENT_IP：有些代理服务器
	        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //X-Real-IP：nginx服务代理
	        ipAddresses = request.getHeader("X-Real-IP");
	    }

	    //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
	    if (ipAddresses != null && ipAddresses.length() != 0) {
	        ip = ipAddresses.split(",")[0];
	    }

	    //还是不能获取到，最后再通过request.getRemoteAddr();获取
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;
	}

	/**
	 *
	 * 
	 * 
	 * @param content
	 * 
	 *                请求的参数 格式为：name=xxx&pwd=xxx
	 * 
	 * @return
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */

	public static String getAddresses(String content, String encodingString)

			throws UnsupportedEncodingException {

// 这里调用pconline的接口

		String urlStr = "http://ip.taobao.com/outGetIpInfo";

		// 从http://whois.pconline.com.cn取得IP所在的省市区信息

		String returnStr = IpUtil.getResult(urlStr,content, encodingString);

		if (returnStr != null) {

			// 处理返回的省市区信息
			return returnStr;

		}

		return null;

	}

	/**
	 * 
	 * @param urlStr
	 * 
	 *                 请求的地址
	 * 
	 * @param content
	 * 
	 *                 请求的参数 格式为：name=xxx&pwd=xxx
	 * 
	 * @param encoding
	 * 
	 *                 服务器端请求编码。如GBK,UTF-8等
	 * 
	 * @return
	 * 
	 */

	public static String getResult(String urlStr,String content, String encoding) {

		URL url = null;

		HttpURLConnection connection = null;

		try {

			url = new URL(urlStr);

			connection = (HttpURLConnection) url.openConnection();// 新建连接实例

			connection.setConnectTimeout(10000);// 设置连接超时时间，单位毫秒

			connection.setReadTimeout(10000);// 设置读取数据超时时间，单位毫秒

			connection.setDoOutput(true);// 是否打开输出流true|false

			connection.setDoInput(true);// 是否打开输入流true|false

			connection.setRequestMethod("POST");// 提交方法POST|GET

			connection.setUseCaches(false);// 是否缓存true|false

			connection.connect();// 打开连接端口

			DataOutputStream out = new DataOutputStream(connection

					.getOutputStream());// 打开输出流往对端服务器写数据

			out.writeBytes(content);// 写数据,也就是提交你的表单name=xxx&pwd=xxx

			out.flush();// 刷新

			out.close();// 关闭输出流

			BufferedReader reader = new BufferedReader(new InputStreamReader(

					connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据

			// ,以BufferedReader流来读取

			StringBuffer buffer = new StringBuffer();

			String line = "";

			while ((line = reader.readLine()) != null) {

				buffer.append(line);

			}

			reader.close();

			return buffer.toString();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (connection != null) {

				connection.disconnect();// 关闭连接

			}

		}

		return null;

	}

	/**
	 * 
	 * unicode 转换成 中文
	 *
	 * 
	 * 
	 * @author fanhui 2007-3-15
	 * 
	 * @param theString
	 * 
	 * @return
	 * 
	 */

// 测试
	
	public static String getIpArea(String ip) {
		
		String result = "";
		
		try {
			result = IpUtil.getAddresses("ip=" + ip+"&accessKey=alibaba-inc", "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Map<String, String> getArea(String areaJson) {
		Map<String, String> result = null;
		if(areaJson!=null&&areaJson!="") {
			try {
				JSONObject obj = JSON.parseObject(areaJson);
				JSONObject data = obj.getJSONObject("data");
				String country = data.getString("country");
				String region = data.getString("region");
				result = new HashMap<>();
				result.put("country", country);
				result.put("region", region);
			} catch (Exception e) {
				
			}
		}
		return result;
	}

//	public static void main(String[] args) {
//
////		String ip = "99.171.132.213";
//		String ip = "42.236.10.125";
//
//		String area = IpUtil.getIpArea(ip);
//		
//		JSONObject obj = JSON.parseObject(area);
//		JSONObject data = obj.getJSONObject("data");
//		String country = data.getString("country");
//		String region = data.getString("region");
//	}

}
