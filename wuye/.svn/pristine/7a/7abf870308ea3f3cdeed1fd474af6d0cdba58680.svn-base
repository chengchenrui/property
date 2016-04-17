package com.wuye.util;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.wuye.util.json.JSONException;
import com.wuye.util.json.JSONObject;

public class Tools {
	public static final String GET_TODAY_TIME() {
		Date date = new Date();
		SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd-HH-mm-ss");
		String today = format.format(date);
		return today;
	}

	/**
	 * 将字符编码从iso-8859-1转成utf-8
	 * 
	 * @param s
	 * @return
	 */
	public static final String CONVERT_ISO_UTF(String s) {
		String result = null;
		if (s == null) {
			return null;
		}
		byte[] temp;
		try {
			temp = s.getBytes("iso-8859-1");
			result = new String(temp, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 检查是否为空字符串,空：true,不空:false
	 * @param value
	 * @return
	 */
	public static boolean isEmptyString(String value) {
		return value == null || "".equals(value.trim());
	}

	/**
	 * 根据IP查找该IP所属的地区，省份，城市
	 * @param ip
	 * @return{地区，省份，城市}
	 */
	public static String queryIp(String ip) throws Exception{
		String IPQUERY = "http://ip.taobao.com/service/getIpInfo.php?ip=";
		String resip = ip+" "+ip+" "+ip;
		//
		String url = IPQUERY+ip;
		String res = HttpUtil.get(url);
		try {
			JSONObject obj = new JSONObject(res.trim());
			JSONObject data = obj.getJSONObject("data");
			if(data != null){
				String area = data.getString("area");
				String region = data.getString("region");
				String city = data.getString("city");
				
				
				return area+" "+region+" "+city;
			}
		} catch (JSONException e) {
			throw new Exception(e);
		}
		
		return resip;
		}
	
	 /**
     * 获取当前日期是星期几
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }
    
    /**
     * 日期转字符串 格式:yyyy-MM-dd
     * @param date
     * @return
     */
	public static String DATE_TO_STRING(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dFormat.format(date);
	}
	
    /**
     * 日期时间转字符串 格式:yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
	public static String DATETIME_TO_STRING(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dFormat.format(date);
	}
    /**
     * 日期时间转字符串 格式(没有空格):yyyy-MM-ddHH:mm:ss
     * @param date
     * @return
     */
	public static String DATETIME_TO_STRING_WITHOUTSPACE(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		return dFormat.format(date);
	}
	 /**
     * 日期时间转字符串 格式(没有符号):yyyyMMddHHmmss
     * @param date
     * @return
     */
	public static String DATETIME_TO_STRING_WITHOUTMARK(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dFormat.format(date);
	}
	/**
	 * 字符串转日期 格式:yyyy-MM-dd HH:mm:ss
	 * @param sdate
	 * @return
	 * @throws ParseException
	 */
	public static Date STRING_TO_DATE(String sdate) throws ParseException {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dFormat.parse(sdate);
		return date;
	}
	
	/**
	 * 字符串转日期 格式:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param sdate
	 * @return
	 * @throws ParseException
	 */
	public static Date STRING_TO_DATETIME(String sdate) throws ParseException {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dFormat.parse(sdate);
		return date;
	}
	/**
	 * 字符串转日期 格式(没有空格):yyyy-MM-ddHH:mm:ss
	 * 
	 * @param sdate
	 * @return
	 * @throws ParseException
	 */
	public static Date STRING_TO_DATETIME_WITHOUTSPACE(String sdate) throws ParseException {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		Date date = dFormat.parse(sdate);
		return date;
	}
	
	/**
	 * 字符串转日期 格式格式(没有符号):yyyyMMddHHmmss
	 * 
	 * @param sdate
	 * @return
	 * @throws ParseException
	 */
	public static Date STRING_TO_DATETIME_WITHOUTMARK(String sdate) throws ParseException {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = dFormat.parse(sdate);
		return date;
	}
	/**
	 * 获取指定日期的后一天
	 * @param today
	 * @return
	 */
	public static Date GET_TOMORROW(Date today) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date tomorro = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// String dateString = formatter.format(tomorro);
		// System.out.println(dateString);
		return tomorro;
	}
	/**
	 * 获取指定日期的前一天
	 * @param today
	 * @return
	 */
	public static Date GET_YESTODAY(Date today) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date yestoday = calendar.getTime(); // 这个时间就是日期往前推一天的结果
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// String dateString = formatter.format(yestoday);
		// System.out.println(dateString);
		return yestoday;
	}
	
	/**
	 * java时间相减：http://j2eeyes.javaeye.com/blog/136170
	 * now-before 的时间差，单位秒
	 * 
	 * @throws ParseException
	 */
	public static Long DATE_SUBTRACTION(Date before, Date now)
			throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
		String nowTime = d.format(now);// 按以上格式 将now时间转换成字符串
		String beforeTime = d.format(before);// 按以上格式 将before时间转换成字符串
		long result = (d.parse(nowTime).getTime() - d.parse(beforeTime)
				.getTime()) / 1000;// 当前时间减去测试时间
		// 这个的除以1000得到秒，相应的60000得到分，3600000得到小时
		System.out.println("当前时间减去测试时间=" + result + "秒");
		return result;
	}

	/**
	 * 创建文件：先验证文件是否存在，
	 * 如果存在，返回true
	 * 如果不存在，则创建新文件，范围false
	 * false表示是新建的文件
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static boolean FILE_ISEXIST_AND_CREATE(String fileName)
			throws IOException {
		boolean flag = true;
		File file = new File(fileName);
		if (file.exists() == false) {
			file.createNewFile();
			flag = false;
		}
		return flag;
	}

	public static String subStringDateFormat(String sdate) {
		// 取出<!-- 2009-03-12 13:25:01 -->格式中的日期字符串
		return sdate.substring(5, 24);
	}

	public static String HTML_DATE_TO_STRING(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "<!-- " + dFormat.format(date) + " -->";
		return s;
	}


	// 工具方法 把从页面获取的数据格式化，方便在显示的时候按原来的格式显示
	public static String transform(String content) {
		String contentNew = content;
		String enter = "<br>\n";
		contentNew = contentNew.replaceAll("&", "&amp");
		contentNew = contentNew.replaceAll("<", "&lt;");
		contentNew = contentNew.replaceAll(" ", "nbsp;");
		contentNew = contentNew.replaceAll(">", "&gt;");
		contentNew = contentNew.replaceAll("\r\n", enter);
		return contentNew;
	}

	/**
	 * 功能：去掉所有的<*>标记,去除html标签
	 * 
	 * @param content
	 * @return
	 */
	public static String removeTagFromText(String content) {
		Pattern p = null;
		Matcher m = null;
		String value = null;

		// 去掉<>标签
		p = Pattern.compile("(<[^>]*>)");
		m = p.matcher(content);
		String temp = content;
		while (m.find()) {
			value = m.group(0);
			temp = temp.replace(value, "");
		}

		// 去掉换行或回车符号
		p = Pattern.compile("(\r+|\n+)");
		m = p.matcher(temp);
		while (m.find()) {
			value = m.group(0);
			temp = temp.replace(value, " ");
			// System.out.println("....." + value);
		}
		return temp;
	}
	/**
	 * 删除内容字符串中的html格式
	 * 
	 * @param input
	 * @param length
	 * @return
	 */
	public static String splitAndFilterString(String input, int length) {
		if (input == null || input.trim().equals("")) {
			return "";
		}
		// 去掉所有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
				"<[^>]*>", "");
		str = str.replaceAll("[(/>)<]", "");
		int len = str.length();
		if (len <= length) {
			return str;
		} else {
			str = str.substring(0, length);
			str += "......";
		}
		return str;
	}
	/**
	 * 获取请求真实IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	}
	/**
	 * 获取随机长度字符串 包含数字和字母
	 * @param length  字符串长度
	 * @return
	 */
	public static final String getRandomString(int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			randGen = new Random();
			numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
			"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		}
		char [] randBuffer = new char[length];
		for (int i=0; i<randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}
	
	
	/**
	 * 获取随机长度字符串 纯字母
	 * @param length  字符串长度
	 * @return
	 */
	public static final String getRandomStringWithOutNumber(int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			randGen = new Random();
			numbersAndLetters = ("abcdefghijklmnopqrstuvwxyz" +
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		}
		char [] randBuffer = new char[length];
		for (int i=0; i<randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(51)];
		}
		return new String(randBuffer);
	}
	
	/**
	 * 获取随机长度字符串 纯数字
	 * @param length  字符串长度
	 * @return
	 */
	public static final String getRandomStringWithNumber(int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			randGen = new Random();
			numbersAndLetters = ("0123456789").toCharArray();
		}
		char [] randBuffer = new char[length];
		for (int i=0; i<randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(9)];
		}
		return new String(randBuffer);
	}
}

