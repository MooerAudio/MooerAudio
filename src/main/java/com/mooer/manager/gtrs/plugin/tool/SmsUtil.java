package com.mooer.manager.gtrs.plugin.tool;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class SmsUtil {

	private static final String WSSE_HEADER_FORMAT = "UsernameToken Username=\"%s\",PasswordDigest=\"%s\",Nonce=\"%s\",Created=\"%s\"";

	private static final String AUTH_HEADER_VALUE = "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"";

	private static final String APP_KEY = "C4s8P680K8rtI8PMmkY1XR4RlJt7";

	private static final String APP_SECRET = "JT3IsT8g55kk6C5OX85hjov004pD";

	private static final String API_ADDRESS = "https://rtcsms.cn-north-1.myhuaweicloud.com:10743/sms/batchSendSms/v1";

	private static final String STATUS_CALLBACK = "";

	private static final String LIVE_CHANNEL_NUMBER = "882001148654";

	private static final String FORGOT_TEMPLATE_ID = "0f3d04fff6284588b1c12bca354498c3";

//	  public static void main(String[] args) throws Exception {
//	  System.out.println(sendForgotValiCode("18320436743", "7894")); }
	
	public static String sendForgotValiCode(String receiver, String valiCode) throws Exception {
		String templateId = FORGOT_TEMPLATE_ID;
		String templateParas = "[\"" + valiCode + "\"]";
		return sendAllMsg(LIVE_CHANNEL_NUMBER, receiver, templateId, templateParas);
	}

	public static String sendAllMsg(String sender, String receiver, String templateId, String templateParas)
			throws Exception {

		// 请求Body
		String body = buildRequestBody(sender, receiver, templateId, templateParas, STATUS_CALLBACK);

		// 请求Headers中的X-WSSE参数值
		String wsseHeader = buildWsseHeader(APP_KEY, APP_SECRET);

		// 如果JDK版本是1.8，可使用如下代码
		CloseableHttpClient client;
		HttpResponse response = null;
		client = HttpClients.custom()//
				.setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, (x509CertChain, authType) -> true).build())//
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();//

		response = client.execute(RequestBuilder.create("POST").setUri(API_ADDRESS)//
				.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")//
				.addHeader(HttpHeaders.AUTHORIZATION, AUTH_HEADER_VALUE).addHeader("X-WSSE", wsseHeader)//
				.setEntity(new StringEntity(body)).build());//

		String responseEntity = EntityUtils.toString(response.getEntity());

		String code = JSON.parseObject(responseEntity).getString("code");
		String description = JSON.parseObject(responseEntity).getString("description");

		if (code.equals("000000") && description.equals("Success")) {
			return "success";
		}
		return "error";
	}

	private static String buildRequestBody(String sender, String receiver, String templateId, String templateParas,
			String statusCallbackUrl) {

		List<NameValuePair> keyValues = new ArrayList<NameValuePair>();

		keyValues.add(new BasicNameValuePair("from", sender));
		keyValues.add(new BasicNameValuePair("to", receiver));
		keyValues.add(new BasicNameValuePair("templateId", templateId));
		keyValues.add(new BasicNameValuePair("templateParas", templateParas));
		keyValues.add(new BasicNameValuePair("statusCallback", statusCallbackUrl));

		return URLEncodedUtils.format(keyValues, StandardCharsets.UTF_8);
	}

	private static String buildWsseHeader(String appKey, String appSecret) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String time = sdf.format(new Date());
		String nonce = UUID.randomUUID().toString().replace("-", "");

		byte[] passwordDigest = DigestUtils.sha256(nonce + time + appSecret);
		String hexDigest = Hex.encodeHexString(passwordDigest);
		String passwordDigestBase64Str = Base64.encodeBase64String(hexDigest.getBytes(Charset.forName("utf-8")));
		return String.format(WSSE_HEADER_FORMAT, appKey, passwordDigestBase64Str, nonce, time);
	}

}
