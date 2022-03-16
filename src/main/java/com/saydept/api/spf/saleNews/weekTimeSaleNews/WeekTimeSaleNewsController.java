package com.saydept.api.spf.saleNews.weekTimeSaleNews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsOrgModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;

@CrossOrigin(origins = "*")
@RestController
public class WeekTimeSaleNewsController {

	@Autowired
	private WeekTimeSaleNewsService weekTimeSaleNewsService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/weekTimeSaleNews", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 조회 대상 날짜 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectWeekTimeSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/weekTimeSaleNews/selectWeekTimeSaleNewsDate", method = RequestMethod.POST)
	public WeekTimeSaleNewsParamModel selectWeekTimeSaleNews(@RequestBody WeekTimeSaleNewsParamModel request)throws Exception {

		WeekTimeSaleNewsParamModel result = weekTimeSaleNewsService.selectWeekTimeSaleNewsDate(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectWeekTimeSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/weekTimeSaleNews/selectWeekTimeSaleNewsList", method = RequestMethod.POST)
	public List<WeekTimeSaleNewsModel> selectWeekTimeSaleNewsList(@RequestBody WeekTimeSaleNewsParamModel request)throws Exception {

		//List<WeekTimeSaleNewsModel> result = weekTimeSaleNewsService.selectWeekTimeSaleNewsList(request);
		return weekTimeSaleNewsService.selectWeekTimeSaleNewsList(request);
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectWeekTimeSaleNewsOrgList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/weekTimeSaleNews/selectWeekTimeSaleNewsOrgList", method = RequestMethod.POST)
	public List<WeekTimeSaleNewsOrgModel> selectWeekTimeSaleNewsOrgList(@RequestBody WeekTimeSaleNewsParamModel request)throws Exception {

		//List<WeekTimeSaleNewsOrgModel> result = weekTimeSaleNewsService.selectWeekTimeSaleNewsOrgList(request);
		return weekTimeSaleNewsService.selectWeekTimeSaleNewsOrgList(request);
	}	
	
	/**
	 * 복수 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectWeekTimeSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/weekTimeSaleNews/selectWeekTimeSaleNewsListTest")
	public List<WeekTimeSaleNewsModel> selectWeekTimeSaleNewsList()throws Exception {

		WeekTimeSaleNewsParamModel param = new WeekTimeSaleNewsParamModel();
		param.setJum("01");
		param.setStartDate("20200507");
		param.setSelectVal("2");
		return weekTimeSaleNewsService.selectWeekTimeSaleNewsList(param);
	}

	

}