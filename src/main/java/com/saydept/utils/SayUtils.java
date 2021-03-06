package com.saydept.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;


@Component
public class SayUtils {

	static final Logger logger = LoggerFactory.getLogger(SayUtils.class);
	
	/**
	 * 2020.06.25 최용권
	 * 클라이언트 요청 파라메터 JSON oo Model 객체로 변환
	 * @param <T>
	 * @param param
	 * @param modelClass
	 * @return
	 * @throws IOException
	 */
	public <T> Object requestJson(String param, Class<T> ClassType) throws IOException {

		return new Gson().fromJson(new JSONObject(param).toString(), ClassType);
	}


	/**
	 * 2020.04.16 최용권
	 * 처리결과 전달(@RestController 미사용 일경우 공통으로 사용)
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public void sendResponse(HttpServletResponse response, Object data) throws IOException {

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(data);
		printWriter.flush();
		printWriter.close();

		return;
	}

	/**
	 * 입력 받은 int 일수 만큼 날짜 계산 
	 * @param val
	 * @param day
	 * @return
	 * @throws ParseException 
	 */
	public String getCusomDay(String val, int day) throws ParseException {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date to = transFormat.parse(val);
		cal.setTime(to);
		cal.add(Calendar.DATE, day);

		return transFormat.format(cal.getTime());
	}

	/**
	 * 입력 받은 int 월수 만큼 날짜 계산 
	 * @param val
	 * @param day
	 * @return
	 * @throws ParseException 
	 */
	public String getCusomMonth(String val, int day) throws ParseException {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date to = transFormat.parse(val);
		cal.setTime(to);
		cal.add(Calendar.MONTH, day);

		return transFormat.format(cal.getTime());
	}

	/**
	 * 입력 받은 int 년수 만큼 날짜 계산 
	 * @param val
	 * @param day
	 * @return
	 * @throws ParseException 
	 */
	public String getCusomYear(String val, int day) throws ParseException {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date to = transFormat.parse(val);
		cal.setTime(to);
		cal.add(Calendar.YEAR, day);

		return transFormat.format(cal.getTime());
	}

	/**
	 * 2020.06.10 Yang SuYoung
	 * 특정 날짜에 대한 요일을 return 
	 * dayNum = 1(일), 2(월), 3(화), 4(수), 5(목), 6(금), 7(토)
	 * @param date
	 * @return dayNum
	 * @throws ParseException 
	 */
	public static int getDayOfWeek(String date) throws ParseException {

	      SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");      
	      Calendar cal = Calendar.getInstance();
	      Date ndate = transFormat.parse(date);
	      cal.setTime(ndate);

	      int dayNum = cal.get(Calendar.DAY_OF_WEEK);

	      return dayNum;
	   }


	/**
	 * 2020.06.10 Yang SuYoung
	 * 입력 받은 일자가 그해의 몇주차인지 계산 
	 * @param date
	 * @return week
	 * @throws ParseException 
	 */
	public int getWeek(String date)  throws ParseException {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");      
		Calendar cal = Calendar.getInstance();
		Date ndate = transFormat.parse(date);
		cal.setTime(ndate);

		int week = cal.get(Calendar.WEEK_OF_YEAR);

		return week;
	}


	/**
	 * 2020.06.10 Yang SuYoung
	 * 입력 받은 일자의 1년뒤 동요일의 날짜를 RETURN 
	 * @param date
	 * @return lastWeekDate
	 * @throws ParseException 
	 */
	public String getSameDayAsLastYear(String date)  throws ParseException {

		//선택된 일자의 요일
		int week = getDayOfWeek(date);

		//전년 동일(lastYearDate)부터 1일씩 증가시키며 입력일자의 요일과 같을경우 해당 일자를 RETURN
		String lastYearDate = getCusomYear(date, -1);
		int lastYearWeek = getDayOfWeek(lastYearDate);

		//1일씩 증가시키며 동요일 find
		while (week != lastYearWeek) {
			lastYearDate = getCusomDay(lastYearDate, 1);
			lastYearWeek = getDayOfWeek(lastYearDate);         
		}

		return lastYearDate;
	}

	/**
	 * 2020.04.16 최용권
	 * 에러 로그 공통 처리
	 * @param e
	 * @param respones
	 * @param errCode	[01: DB관련], [02: Null], [03: IO], [04: JSON], [05: ArrayIndex], [99: 미정의된 오류]
	 * @param message
	 * @throws IOException 
	 */
	public void errorLogger(Exception e, HttpServletResponse response, String errCode, String message) {

		//로그 파일 처리
		logger.error("\n************************************************ERROR START************************************************");
		logger.error("",e);
		logger.error("\n************************************************ERROR E N D************************************************");
		e.printStackTrace();

		//클라이언트에게 전송할 메세지
		JSONObject errorJson = new JSONObject();
		errorJson.put("errCode", errCode);
		errorJson.put("errMsg", e.getMessage());
		errorJson.put("message", message);

		try {
			response.setStatus(500);
			sendResponse(response, errorJson);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	/**
	 * 2020.09.28 양수영
	 * 반각문자 전각 처리
	 * @param e
	 * @param respones
	 * @param message
	 * @throws IOException 
	 */
	public static String toFullChar(String src)
	{
	    if (src == null)    return null;
	    StringBuffer strBuf = new StringBuffer();
	    char c = 0;
	    for (int i = 0; i < src.length(); i++)
	    {
	        c = src.charAt(i);
	        // 영문 알파벳 이거나 특수 문자
	        if (c >= 0x21 && c <= 0x7e)   c += 0xfee0;
	        // 공백
	        else if (c == 0x20)   c = 0x3000;
	        strBuf.append(c);
	    }
	    return strBuf.toString();
	}
	
	
	/**
	 * 2020.09.28 양수영
	 * 전각문자 반각 처리
	 * @param e
	 * @param respones
	 * @param message
	 * @throws IOException 
	 */
	public static String toHalfChar(String src)
	{
	    StringBuffer strBuf = new StringBuffer();
	    char c = 0;
	    for (int i = 0; i < src.length(); i++)
	    {
	        c = src.charAt(i);
	        //영문이거나 특수 문자 일경우.
	        if (c >= '！' && c <= '～')   c -= 0xfee0;
	        // 공백
	        else if (c == '　')   c = 0x20;
	        strBuf.append(c);
	    }
	    return strBuf.toString();
	}


	
}
