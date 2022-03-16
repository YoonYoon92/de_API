package com.saydept.api.spf.saleNews.onHandTimeSaleNews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsModel;
import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsParamModel;
import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsTotalModel;

@CrossOrigin(origins = "*")
@RestController
public class OnHandTimeSaleNewsController {

	@Autowired
	private OnHandTimeSaleNewsService onHandTimeSaleNewsService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/onHandTimeSaleNews", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectOnHandTimeSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/onHandTimeSaleNews/selectOnHandTimeSaleNews", method = RequestMethod.POST)
	public OnHandTimeSaleNewsTotalModel selectOnHandTimeSaleNews(@RequestBody OnHandTimeSaleNewsParamModel request)throws Exception {

		OnHandTimeSaleNewsTotalModel result = onHandTimeSaleNewsService.selectOnHandTimeSaleNews(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectOnHandTimeSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/onHandTimeSaleNews/selectOnHandTimeSaleNewsList", method = RequestMethod.POST)
	public List<OnHandTimeSaleNewsModel> selectOnHandTimeSaleNewsList(@RequestBody OnHandTimeSaleNewsParamModel request)throws Exception {

		List<OnHandTimeSaleNewsModel> result = onHandTimeSaleNewsService.selectOnHandTimeSaleNewsList(request);
		return result;
	}
	
	/**
	 * 복수 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectOnHandTimeSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/onHandTimeSaleNews/selectOnHandTimeSaleNewsListTest")
	public List<OnHandTimeSaleNewsModel> selectOnHandTimeSaleNewsList()throws Exception {
		OnHandTimeSaleNewsParamModel param = new OnHandTimeSaleNewsParamModel();
		param.setJum("01");
		param.setStartDate("20200507");
		
		List<OnHandTimeSaleNewsModel> result = onHandTimeSaleNewsService.selectOnHandTimeSaleNewsList(param);
		return result;
	}
	
	/**
	 * 단일 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectOnHandTimeSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/onHandTimeSaleNews/selectOnHandTimeSaleNewsTest")
	public OnHandTimeSaleNewsTotalModel selectOnHandTimeSaleNews()throws Exception {
		OnHandTimeSaleNewsParamModel param = new OnHandTimeSaleNewsParamModel();
		param.setJum("01");
		param.setStartDate("20200507");
		
		return onHandTimeSaleNewsService.selectOnHandTimeSaleNews(param);
		
	}
	
}