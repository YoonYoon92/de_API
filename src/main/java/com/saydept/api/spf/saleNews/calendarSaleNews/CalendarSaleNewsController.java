package com.saydept.api.spf.saleNews.calendarSaleNews;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.calendarSaleNews.model.CalendarSaleNewsModel;
import com.saydept.api.spf.saleNews.calendarSaleNews.model.CalendarSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class CalendarSaleNewsController {

	@Autowired
	private CalendarSaleNewsService CalendarSaleNewsService;
	private String endDate;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/CalendarSaleNews", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCalendarSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/calendarSaleNews/selectCalendarSaleNewsList", method = RequestMethod.POST)
	public List<CalendarSaleNewsModel> selectCalendarSaleNewsList(@RequestBody CalendarSaleNewsParamModel request)throws Exception {

		ArrayList<CalendarSaleNewsModel> retModel = new ArrayList<CalendarSaleNewsModel>();
		
		// 공백 일자 
		CalendarSaleNewsModel spaceDate;
		
		//주간 누계 
		CalendarSaleNewsModel totalOfWeek;
		
		//월의 말일
		endDate = null;
		
		//주간 실적/목표 누계 값
		double sumWeekSaleAmount = 0.0;
		double sumWeekGoal = 0.0;
		
		double[] totalDayofWeekSaleAmount = new double[8];
		double[] totalDayofWeekDayGoal = new double[8];
		@SuppressWarnings("unused")
		double[] totalDayofWeekAchievementRate = new double[8];
				
		//시작 제목 출력
		spaceDate = new CalendarSaleNewsModel();
		spaceDate.setSaleDate("Title");
   		retModel.add(spaceDate);
		
		//시작요일전 공백 삽입
		for(int spaceDay=1 ; spaceDay < SayUtils.getDayOfWeek(request.getInqYM()+"01") ; spaceDay++) {
			spaceDate = new CalendarSaleNewsModel();
			spaceDate.setSaleDate(null);
	   		retModel.add(spaceDate);
		}
		
		
		
		// DB data read start 
		List<CalendarSaleNewsModel> calendarSaleNewsModel = CalendarSaleNewsService.selectCalendarSaleNewsList(request);
		for(CalendarSaleNewsModel daySaleNews: calendarSaleNewsModel) {
			  
			daySaleNews.setDay(Integer.parseInt(daySaleNews.getSaleDate().substring(6, 8)));
		   	daySaleNews.setDayNum(SayUtils.getDayOfWeek(daySaleNews.getSaleDate()));
		   	
		   	
		   	//일요일인경우 제목 추가
		   	if(daySaleNews.getDayNum()==1) {
		   		spaceDate = new CalendarSaleNewsModel();
		   		spaceDate.setSaleDate("Title");
		   		retModel.add(spaceDate);
		   	}
		   	endDate = daySaleNews.getSaleDate();
		   	retModel.add(daySaleNews);
		   	
		   	sumWeekSaleAmount += daySaleNews.getSaleAmount();  
		   	sumWeekGoal += daySaleNews.getDayGoal();
		   	
		    
		   	//토요일인경우 주간 합계 추가
		   	if(daySaleNews.getDayNum()==7) {
		   		System.out.println(sumWeekSaleAmount);
			   	System.out.println(sumWeekGoal);
		   		totalOfWeek = new CalendarSaleNewsModel();
				totalOfWeek.setSaleDate("Total");
				totalOfWeek.setDayNum(8);
		   		totalOfWeek.setSaleAmount(sumWeekSaleAmount);
			   	totalOfWeek.setDayGoal(sumWeekGoal);
		   		totalOfWeek.setAchievementRate(sumWeekSaleAmount / sumWeekGoal *100);		   		
		   		retModel.add(totalOfWeek);
		   		sumWeekSaleAmount = 0.0;
		   		sumWeekGoal = 0.0;	   		
		   	}
		   	
		   	//요일별 합계
		   	totalDayofWeekSaleAmount[daySaleNews.getDayNum()-1] += daySaleNews.getSaleAmount();
		   	totalDayofWeekDayGoal[daySaleNews.getDayNum()-1] += daySaleNews.getDayGoal();
		   	//월합계
		   	totalDayofWeekSaleAmount[7] += daySaleNews.getSaleAmount();
		   	totalDayofWeekDayGoal[7] += daySaleNews.getDayGoal();	
		   			   
		}
		
		
		//마지막일자 add 후 공백 삽입 및 마지막주 주간합계 추가
		for(int spaceDay = SayUtils.getDayOfWeek(endDate)  ; spaceDay < 7 ; spaceDay++) {
			spaceDate = new CalendarSaleNewsModel();
			spaceDate.setSaleDate(null);
	   		retModel.add(spaceDate);
	   	    //토요일인경우 주간 합계 추가
		   	if(spaceDay == 6) {	
		   		System.out.println(sumWeekSaleAmount);
			   	System.out.println(sumWeekGoal);
		   		totalOfWeek = new CalendarSaleNewsModel();
		   		totalOfWeek.setSaleDate("Total");
				totalOfWeek.setDayNum(8);
		   		totalOfWeek.setSaleAmount(sumWeekSaleAmount);  
		   		totalOfWeek.setDayGoal(sumWeekGoal);
			   	totalOfWeek.setAchievementRate(sumWeekSaleAmount / sumWeekGoal *100); 
		   		retModel.add(totalOfWeek);
		   	}
		}
		
		//요일별 합계 및 월합계 
		spaceDate = new CalendarSaleNewsModel();
		spaceDate.setSaleDate("WeekTitle");
		retModel.add(spaceDate);
		for(int i = 0  ; i < 8 ; i++) {
			totalOfWeek = new CalendarSaleNewsModel();			
			totalOfWeek.setSaleDate("WeekTotal");
			totalOfWeek.setSaleAmount(totalDayofWeekSaleAmount[i]);
			totalOfWeek.setDayGoal(totalDayofWeekDayGoal[i]);
			totalOfWeek.setAchievementRate(totalDayofWeekSaleAmount[i]/totalDayofWeekDayGoal[i]*100);	
			totalOfWeek.setDayNum(i+1);
			retModel.add(totalOfWeek);
		}	
		
		return retModel;		
		
	}
	
	/**
	 * 복수 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCalendarSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/calendarSaleNews/selectCalendarSaleNewsListTest")
	public List<CalendarSaleNewsModel> selectCalendarSaleNewsList()throws Exception {
		CalendarSaleNewsParamModel param = new CalendarSaleNewsParamModel();
		ArrayList<CalendarSaleNewsModel> retModel = new ArrayList<CalendarSaleNewsModel>();
		
		// 공백 일자 
		CalendarSaleNewsModel spaceDate;
		
		//주간 누계 
		CalendarSaleNewsModel totalOfWeek;
		
		//월의 말일
		endDate = null;
		
		//주간 실적/목표 누계 값
		double sumWeekSaleAmount = 0.0;
		double sumWeekGoal = 0.0;
		
		double[] totalDayofWeekSaleAmount = new double[8];
		double[] totalDayofWeekDayGoal = new double[8];
		@SuppressWarnings("unused")
		double[] totalDayofWeekAchievementRate = new double[8];
		
		param.setInqYM("202104");
		param.setJum("01");
		
		//시작 제목 출력
		spaceDate = new CalendarSaleNewsModel();
		spaceDate.setSaleDate("Title");
   		retModel.add(spaceDate);
		
		//시작요일전 공백 삽입
		for(int spaceDay=1 ; spaceDay < SayUtils.getDayOfWeek(param.getInqYM()+"01") ; spaceDay++) {
			spaceDate = new CalendarSaleNewsModel();
			spaceDate.setSaleDate(null);
	   		retModel.add(spaceDate);
		}
		
		
		
		// DB data read start 
		List<CalendarSaleNewsModel> calendarSaleNewsModel = CalendarSaleNewsService.selectCalendarSaleNewsList(param);
		for(CalendarSaleNewsModel daySaleNews: calendarSaleNewsModel) {
			  
			daySaleNews.setDay(Integer.parseInt(daySaleNews.getSaleDate().substring(6, 8)));
		   	daySaleNews.setDayNum(SayUtils.getDayOfWeek(daySaleNews.getSaleDate()));
		   	
		   	
		   	//일요일인경우 제목 추가
		   	if(daySaleNews.getDayNum()==1) {
		   		spaceDate = new CalendarSaleNewsModel();
		   		totalOfWeek = new CalendarSaleNewsModel();
		   		spaceDate.setSaleDate("Title");
		   		retModel.add(spaceDate);
		   	}
		   	endDate = daySaleNews.getSaleDate();
		   	retModel.add(daySaleNews);
		   	
		   	sumWeekSaleAmount += daySaleNews.getSaleAmount();  
		   	sumWeekGoal += daySaleNews.getDayGoal();	
		    
		   	//토요일인경우 주간 합계 추가
		   	if(daySaleNews.getDayNum()==7) {		   		
		   		System.out.println(sumWeekSaleAmount);
			   	System.out.println(sumWeekGoal);
		   		totalOfWeek = new CalendarSaleNewsModel();
				totalOfWeek.setSaleDate("Total");
				totalOfWeek.setDayNum(8);
		   		totalOfWeek.setSaleAmount(sumWeekSaleAmount);  
			   	totalOfWeek.setDayGoal(sumWeekGoal);
		   		totalOfWeek.setAchievementRate(sumWeekSaleAmount / sumWeekGoal *100);		   		
		   		retModel.add(totalOfWeek);
		   		sumWeekSaleAmount = 0.0;
		   		sumWeekGoal = 0.0;	   		
		   	}
		   	
		   	//요일별 합계
		   	totalDayofWeekSaleAmount[daySaleNews.getDayNum()-1] += daySaleNews.getSaleAmount();
		   	totalDayofWeekDayGoal[daySaleNews.getDayNum()-1] += daySaleNews.getDayGoal();
		   	//월합계
		   	totalDayofWeekSaleAmount[7] += daySaleNews.getSaleAmount();
		   	totalDayofWeekDayGoal[7] += daySaleNews.getDayGoal();	
		   			   
		}
		
		
		//마지막일자 add 후 공백 삽입 및 마지막주 주간합계 추가
		for(int spaceDay = SayUtils.getDayOfWeek(endDate)  ; spaceDay < 7 ; spaceDay++) {
			spaceDate = new CalendarSaleNewsModel();
			spaceDate.setSaleDate(null);
	   		retModel.add(spaceDate);
	   	    //토요일인경우 주간 합계 추가
		   	if(spaceDay == 6) {		   		
		   		System.out.println(sumWeekSaleAmount);
			   	System.out.println(sumWeekGoal);
		   		totalOfWeek = new CalendarSaleNewsModel();
				totalOfWeek.setSaleDate("Total");
				totalOfWeek.setDayNum(8);
		   		totalOfWeek.setSaleAmount(sumWeekSaleAmount);  
		   		totalOfWeek.setDayGoal(sumWeekGoal);
			   	totalOfWeek.setAchievementRate(sumWeekSaleAmount / sumWeekGoal *100); 
		   		retModel.add(totalOfWeek);
		   	}
		}
		
		//요일별 합계 및 월합계 
		spaceDate = new CalendarSaleNewsModel();
		spaceDate.setSaleDate("WeekTitle");
		retModel.add(spaceDate);
		for(int i = 0  ; i < 8 ; i++) {
			totalOfWeek = new CalendarSaleNewsModel();			
			totalOfWeek.setSaleDate("WeeKTotal");
			totalOfWeek.setSaleAmount(totalDayofWeekSaleAmount[i]);
			totalOfWeek.setDayGoal(totalDayofWeekDayGoal[i]);
			totalOfWeek.setAchievementRate(totalDayofWeekSaleAmount[i]/totalDayofWeekDayGoal[i]*100);	
			totalOfWeek.setDayNum(i+1);
			retModel.add(totalOfWeek);
		}	
		
		return retModel;
	}
	
}