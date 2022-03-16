package com.saydept.api.dashboard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.dashboard.model.AchivModel;
import com.saydept.api.dashboard.model.ComplainModel;
import com.saydept.api.dashboard.model.EventSaleUnitModel;
import com.saydept.api.dashboard.model.NoticeModel;
import com.saydept.api.dashboard.model.DashboardModel;
import com.saydept.api.dashboard.model.TimeZoneModel;
import com.saydept.api.dashboard.model.TimeZoneUnitModel;

@Mapper
public interface DashboardMapper {

	/**
	 * 당일 당월 당년 온라인
	 * @param request
	 * @return
	 */
	AchivModel selectAchiv(DashboardModel request);
	
	/**
	 * 시간대별 매출(당일 전주 전년)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<TimeZoneUnitModel> selectTimeZoneList(TimeZoneModel timeZoneModel);
	
	/**
	 * 행사장 매출
	 * @param request
	 * @return
	 */
	List<EventSaleUnitModel> selectEventSaleList(DashboardModel request);

	/**
	 * 공지사항
	 * @param request
	 * @return
	 */
	List<NoticeModel> selectNoticeList(DashboardModel request);
	
	/**
	 * 컴플레인
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<ComplainModel> selectComplainList(DashboardModel request);

	/**
	 * 공지 읽음 처리
	 * @param request
	 * @return
	 */
	int noticeRead(NoticeModel request);

	/**
	 * 고객의 소리 읽음 처리
	 * @param request
	 * @return
	 */
	int compainRead(NoticeModel request);

}
