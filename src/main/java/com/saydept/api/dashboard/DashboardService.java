package com.saydept.api.dashboard;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.dashboard.model.AchivModel;
import com.saydept.api.dashboard.model.ComplainModel;
import com.saydept.api.dashboard.model.EventSaleModel;
import com.saydept.api.dashboard.model.EventSaleUnitModel;
import com.saydept.api.dashboard.model.NoticeModel;
import com.saydept.api.dashboard.model.DashboardModel;
import com.saydept.api.dashboard.model.TimeZoneModel;
import com.saydept.api.dashboard.model.TimeZoneUnitModel;
import com.saydept.utils.SayUtils;

@Service
public class DashboardService {

	@Autowired
	private DashboardMapper dashboardMapper;
	
	@Autowired
	private SayUtils sayUtils;

	/**
	 * 당일 당월 당년 온라인
	 * @param request
	 * @return
	 */
	public AchivModel achiv(DashboardModel request) {
		// TODO Auto-generated method stub
		return dashboardMapper.selectAchiv(request);
	}
	
	/**
	 * 시간대별 매출(당일 전주 전년)
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws Exception
	 */
	public TimeZoneModel timeZone(DashboardModel request) throws ParseException {
		
		TimeZoneModel timeZoneModel = new TimeZoneModel();
		
		timeZoneModel.setSaleDate(request.getSaleDate());
		timeZoneModel.setOldWeekSaleDate(sayUtils.getCusomDay(request.getSaleDate(),-7));
		timeZoneModel.setOldYearSaleDate(sayUtils.getSameDayAsLastYear(request.getSaleDate()));
		System.out.println("hi");
		
		List<TimeZoneUnitModel> resultList = dashboardMapper.selectTimeZoneList(timeZoneModel);
		
		TimeZoneModel result = new TimeZoneModel();
	      
	    //변환작업
	    result.setSaleDate(request.getSaleDate());
	    
		List<String> dayTimeLables = new ArrayList<String>();
		List<Long> daySales = new ArrayList<Long>();			
		List<Long> lastWeekSales = new ArrayList<Long>();	
		List<Long> lastYearSales = new ArrayList<Long>();	
	      
	    for( TimeZoneUnitModel data :  resultList) {
	    	
	    	dayTimeLables.add(data.getTimeZone());
	    	daySales.add(data.getSaleAmount());
	    	lastWeekSales.add(data.getOldWeekSaleAmount());
	    	lastYearSales.add(data.getOldYearSaleAmount());
	    	
	    }
	    
	    result.setDayTimeLable(dayTimeLables);
	    result.setDaySale(daySales);
	    result.setLastWeekSale(lastWeekSales);
	    result.setLastYearSale(lastYearSales);
	    
		return result;
	}
	
	/**
	 * 행사장 매출
	 * @param request
	 * @return
	 */
	public EventSaleModel selectEventSaleList(DashboardModel request) {
		
		List<EventSaleUnitModel> resultList = dashboardMapper.selectEventSaleList(request);
		EventSaleModel result = new EventSaleModel();
		
		//변환작업
		result.setSaleDate(request.getSaleDate());
		
		List<String> eventNms = new ArrayList<String>();
		List<Long> netSales = new ArrayList<Long>();
		
		for( EventSaleUnitModel data :  resultList) {
			
			eventNms.add(data.getEventNm());
			netSales.add(data.getNetSale());
		}		
		
		result.setEventNm(eventNms);
		result.setNetSale(netSales);
						
		return result;
	}
	
	/**
	 * 공지사항
	 * @param request
	 * @return
	 */
	public List<NoticeModel> selectNoticeList(DashboardModel request) {
		return dashboardMapper.selectNoticeList(request);
	}
	
	/**
	 * 컴플레인
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ComplainModel> selectComplainList(DashboardModel request) {
		
		return dashboardMapper.selectComplainList(request);
	}

	/**
	 * 공지 읽음 처리
	 * @param request
	 * @return
	 */
	public int noticeRead(NoticeModel request) {
		// TODO Auto-generated method stub
		return dashboardMapper.noticeRead(request);
	}

	/**
	 * 고객의 소리 읽음 처리
	 * @param request
	 * @return
	 */
	public int compainRead(NoticeModel request) {
		// TODO Auto-generated method stub
		return dashboardMapper.compainRead(request);
	}

}
