package com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model.LastYearCntstWeekSaleNewsModel;
import com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model.LastYearCntstWeekSaleNewsParamModel;

@CrossOrigin(origins = "*")
@RestController
public class LastYearCntstWeekSaleNewsController {

	@Autowired
	private LastYearCntstWeekSaleNewsService lastYearCntstWeekSaleNewsService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/lastYearCntstWeekSaleNews", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 조회 대상 날짜 
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex)selectLastYearCntstWeekSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/lastYearCntstWeekSaleNews/selectLastYearCntstWeekSaleNews", method = RequestMethod.POST)
	public LastYearCntstWeekSaleNewsParamModel selectLastYearCntstWeekSaleNews(@RequestBody LastYearCntstWeekSaleNewsParamModel request)throws Exception {

		return lastYearCntstWeekSaleNewsService.selectLastYearCntstWeekSaleNews(request);
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectLastYearCntstWeekSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/lastYearCntstWeekSaleNews/selectLastYearCntstWeekSaleNewsList", method = RequestMethod.POST)
	public List<LastYearCntstWeekSaleNewsModel> selectLastYearCntstWeekSaleNewsList(@RequestBody LastYearCntstWeekSaleNewsParamModel request)throws Exception {

		return lastYearCntstWeekSaleNewsService.selectLastYearCntstWeekSaleNewsList(request);
	}


	/**
	 * 조회 대상 날짜 (test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectLastYearCntstWeekSaleNewsTest
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/lastYearCntstWeekSaleNews/selectLastYearCntstWeekSaleNewsTest")
	public LastYearCntstWeekSaleNewsParamModel selectLastYearCntstWeekSaleNews()throws Exception {
		LastYearCntstWeekSaleNewsParamModel param = new LastYearCntstWeekSaleNewsParamModel();
		param.setJum("01");
		param.setStartDate("20200507");		
		return lastYearCntstWeekSaleNewsService.selectLastYearCntstWeekSaleNews(param);
	}
	
	/**
	 * 복수 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectLastYearCntstWeekSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/lastYearCntstWeekSaleNews/selectLastYearCntstWeekSaleNewsListTest")
	public List<LastYearCntstWeekSaleNewsModel> selectLastYearCntstWeekSaleNewsList()throws Exception {

		LastYearCntstWeekSaleNewsParamModel param = new LastYearCntstWeekSaleNewsParamModel();
		param.setJum("01");
		param.setStartDate("20200507");		
		return lastYearCntstWeekSaleNewsService.selectLastYearCntstWeekSaleNewsList(param);
	}

}