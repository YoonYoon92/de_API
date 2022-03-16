package com.saydept.api.dashboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.dashboard.model.AchivModel;
import com.saydept.api.dashboard.model.ComplainModel;
import com.saydept.api.dashboard.model.EventSaleModel;
import com.saydept.api.dashboard.model.NoticeModel;
import com.saydept.api.dashboard.model.DashboardModel;
import com.saydept.api.dashboard.model.TimeZoneModel;

@CrossOrigin(origins = "*")
@RestController
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	/**
	 * 주석 작성법: 생성한 함수 위에서 /** 입력후 엔터키 입력 
	 */

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/dashboard", method = RequestMethod.GET)
	public String condition() {
    	return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 당일 달월 당년 온라인
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/achiv", method = RequestMethod.POST)
	public AchivModel achiv(@RequestBody DashboardModel request)throws Exception {
		
		System.out.println(request);
		
		AchivModel result = dashboardService.achiv(request);
		
    	return result;
	}
	
	/**
	 * 시간대별 매출(당일 전주 전년)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/timeZone", method = RequestMethod.POST)
	public TimeZoneModel timeZone(@RequestBody DashboardModel request)throws Exception {
		
		TimeZoneModel result = dashboardService.timeZone(request);
		
    	return result;
	}
	
	/**
	 * 행사장 매출
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/eventSale", method = RequestMethod.POST)
	public EventSaleModel eventSale(@RequestBody DashboardModel request)throws Exception {
		
		EventSaleModel result = dashboardService.selectEventSaleList(request);
		
		return result;
	}
	
	/**
	 * 공지사항
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/notice", method = RequestMethod.POST)
	public List<NoticeModel> notice(@RequestBody DashboardModel request)throws Exception {
		
		return dashboardService.selectNoticeList(request);
	}
	
	/**
	 * 공지사항 읽음 처리
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/noticeRead", method = RequestMethod.POST)
	public int noticeRead(@RequestBody NoticeModel request)throws Exception {
		
		/**
		 * return 1 지우고 아래 주석 해제한후 DeahboardSql.xml 파일에서 insert id="noticeRead" 쿼리 작성
		 * 서버로 넘어온 파라메터는
		 * noticeDate 	- 공지년도
		 * seq			- 공지번호
		 * userId		- 접속자아아디
		 */
		//return dashboardService.noticeRead(request);
		
		return 1;
	}
	
	/**
	 * 컴플레인
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/complain", method = RequestMethod.POST)
	public List<ComplainModel> complain(@RequestBody DashboardModel request)throws Exception {
		
		return  dashboardService.selectComplainList(request);
	}
	
	/**
	 * 고객의 소리 읽음 처리
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/dashboard/compainRead", method = RequestMethod.POST)
	public int compainRead(@RequestBody NoticeModel request)throws Exception {
		
		/**
		 * return 1 지우고 아래 주석 해제한후 DeahboardSql.xml 파일에서 insert id="compainRead" 쿼리 작성
		 * 서버로 넘어온 파라메터는
		 * rcpDate 		- 접수일자
		 * rcpSeq		- 접수번호
		 * userId		- 접속자아아디
		 */
		//return dashboardService.compainRead(request);
		
		return 0;
	}
	
}
