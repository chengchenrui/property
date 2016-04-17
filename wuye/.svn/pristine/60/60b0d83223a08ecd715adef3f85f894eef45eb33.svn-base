package com.wuye.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public class HttpUtil {
	private static final Logger logger  = Logger.getLogger(HttpUtil.class);
	private static final String ENCODING_UTF_8 = "utf-8";
	public static String encodeUrl(String url) {
		try {
			return URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	public static String get(String url) {
		URL getUrl;
		String ret = "";
		try {
			getUrl = new URL(url);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			return ret;
		}
		
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) getUrl
					.openConnection();
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			String lines;
			while ((lines = reader.readLine()) != null) {
				ret += lines;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (connection != null)
			connection.disconnect();
		
		return ret;
	}
	
	public static String post(String urlStr,String params){ 
		String backInfo = null;
		HttpURLConnection httpConn = null;
		try { 
			//String pathUrl = "http://172.20.0.206:8082/TestServelt/login.do"; 
			String pathUrl = urlStr;	
			// 建立连接 
			URL url = new URL(pathUrl); 
			httpConn = (HttpURLConnection) url.openConnection(); 
			// //设置连接属性 
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出 
			httpConn.setDoInput(true);// 使用 URL 连接进行输入 
			httpConn.setUseCaches(false);// 忽略缓存 
			httpConn.setRequestMethod("POST");// 设置URL请求方法 
			//String requestString = "客服端要以以流方式发送到服务端的数据...";
			String requestString = params;
			// 设置请求属性 
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致 
			byte[] requestStringBytes = requestString.getBytes(ENCODING_UTF_8); 
			httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length); 
			httpConn.setRequestProperty("Content-Type", "application/octet-stream"); 
			httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接 
			httpConn.setRequestProperty("Charset", "UTF-8"); 
			// 建立输出流，并写入数据 
			OutputStream outputStream = httpConn.getOutputStream(); 
			outputStream.write(requestStringBytes); 
			outputStream.close(); 
			// 获得响应状态 
			int responseCode = httpConn.getResponseCode(); 
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功 
				// 当正确响应时处理数据 
				StringBuffer sb = new StringBuffer(); 
				String readLine; 
				BufferedReader responseReader; 
				// 处理响应流，必须与服务器响应流输出的编码一致 
				responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), ENCODING_UTF_8)); 
				while ((readLine = responseReader.readLine()) != null) { 
					sb.append(readLine).append("\n"); 
				} 
				responseReader.close(); 
				backInfo = sb.toString(); 
			} 
		} catch (Exception ex) { 
			logger.error("HTTP POST请求返回错误：",ex); 
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}
		
		return backInfo;
	} 

	
	// http://www.xxx.com/a/b/c/1.htm
	// level 0: http://www.xxx.com/a/b/c/
	// level 1: http://www.xxx.com/a/b/
	// level 2: http://www.xxx.com/a/
	// level 3: http://www.xxx.com/
	// level 4: empty string
	public static String getBaseUrl(String url, int level){
		String ret = url;
		int pos = 0;
		List p = new ArrayList<Integer>();
		while ((pos = ret.indexOf("/", pos + 1)) >= 0) {
			p.add(pos);
		}
		
		if (p.size() <= level + 2) return "";
		
		pos = (Integer)p.get(p.size() - level -1);
		
		return ret.substring(0, pos + 1);
	}
	
	/**
	 * 获取关注对象微信永久二维码
	 * @param access_token
	 * @param params
	 * @return
	 */
	public static String getQRCode(String access_token,String params){
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+access_token;
		String backStr = HttpUtil.post(url,params);
		return backStr;
	}
	
	
	public static void main(String args[]){
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=YSx7EuIaiqVlARVzfqU8SESxa1gMo9bC0x9bYv4-qR4WBlgFdCIpQ4UlqM4TMw30pzdIFlK6x38PyEn_gxrx1WeV-Ebh3gejb165WkqtVkA";
		String params = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":\"123\"}}}";
		String backStr = post(url,params);
		System.out.printf("post返回参数："+backStr);
		
	}
}
