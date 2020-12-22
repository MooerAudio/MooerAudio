package com.mooer.manager.gtrs.plugin.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
 
/**
 * HttpClient工具类
 */
public class HttpUtil {
    
    /**
     * get请求
     * @return
     */
    public static String doGet(String url) {
        try {
            @SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                
                return strResult;
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**get请求(用于key-value格式的参数,且带有header请求头)
     * @param url            
     * @param map            请求的参数map<key,value>键值对
     * @param headerKey        headers Key
     * @param headerValue    headers Value
     * @return
     */
    public static byte[] doGet(String url,Map<String, String> map,Map<String, String> header) {
        // 获取连接客户端工具
        CloseableHttpClient httpClient = HttpClients.createDefault();
     
        byte[] entityStr = null;
        CloseableHttpResponse response = null;
     
        try {
            /*
             * 由于GET请求的参数都是拼装在URL地址后方，所以我们要构建一个URL，带参数
             */
            URIBuilder uriBuilder = new URIBuilder(url);
            /** 第一种添加参数的形式 */
            /*uriBuilder.addParameter("name", "root");
            uriBuilder.addParameter("password", "123456");*/

            for (Map.Entry<String, String> entry : map.entrySet()) { 
                  uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            
            
            /** 第二种添加参数的形式 */
            /* List<NameValuePair> list = new LinkedList<>();
            BasicNameValuePair param1 = new BasicNameValuePair("startTime", "2019-1-1 00:00:00");
            BasicNameValuePair param2 = new BasicNameValuePair("endTime", "2019-1-9 00:00:00");
            list.add(param1);
            list.add(param2);
            uriBuilder.setParameters(list);*/
     
            // 根据带参数的URI对象构建GET请求对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());
     
            /* 
             * 添加请求头信息
             */
            // 浏览器表示
//            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            // 传输的类型
//            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            //header的<key,value>
            for (Map.Entry<String, String> entry : header.entrySet()) { 
//                uriBuilder.addParameter(entry.getKey(), entry.getValue());
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
            
            // 执行请求
            response = httpClient.execute(httpGet);
            // 获得响应的实体对象
            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toByteArray(entity);
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.err.println("URI解析异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        } finally {
            // 释放连接
            if (null != response) {
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    System.err.println("释放连接出错");
                    e.printStackTrace();
                }
            }
        }
        return entityStr;
    }
    
    
    
    
    /**
     * post请求(用于key-value格式的参数)
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map params){
        
        BufferedReader in = null;  
        try {  
            // 定义HttpClient  
            HttpClient client = new DefaultHttpClient();  
            // 实例化HTTP方法  
            HttpPost request = new HttpPost();  
            request.setURI(new URI(url));
            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));
                
                //System.out.println(name +"-"+value);
            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
            
            HttpResponse response = client.execute(request);  
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){    //请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()  
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");  
                String line = "";  
                String NL = System.getProperty("line.separator");  
                while ((line = in.readLine()) != null) {  
                    sb.append(line + NL);  
                }
                
                in.close();  
                
                return sb.toString();
            }
            else{    //
                System.out.println("状态码：" + code);
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
            return null;
        }
    }
    
    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params) throws Exception {
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost   
        httpPost.setHeader("Accept", "application/json"); 
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);        
        CloseableHttpResponse response = null;
        
        try {
            
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{

            }
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
}