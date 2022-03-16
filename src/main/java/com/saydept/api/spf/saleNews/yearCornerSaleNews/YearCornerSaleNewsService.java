package com.saydept.api.spf.saleNews.yearCornerSaleNews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.yearCornerSaleNews.model.YearCornerSaleNewsParamModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;
import com.saydept.api.spf.saleNews.yearCornerSaleNews.model.YearCornerSaleNewsModel;
import com.saydept.utils.SayUtils;

	@Service
	public class YearCornerSaleNewsService {

	@Autowired
	private YearCornerSaleNewsMapper yearCornerSaleNewsMapper;

	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public YearCornerSaleNewsModel selectYearCornerSaleNews(YearCornerSaleNewsParamModel request)throws Exception {

	YearCornerSaleNewsModel result = yearCornerSaleNewsMapper.selectYearCornerSaleNews(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YearCornerSaleNewsModel> selectYearCornerSaleNewsList(YearCornerSaleNewsParamModel request)throws Exception {
		
		System.out.println(request);
		
		/* 전달받은 기준을 searchDay 를 가지고 12개월의 검색일자를 각각 구해서 당월까지 13번 월별로 검색한다 */
		//선택한 일자의 전년 동월 1일자 구하기  => frDate 매출 검색 시작일
		String beforeYear;
		beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1);
    	request.setFrDate(beforeYear.substring(0, 6) + "01");
    	//request.setToDate(beforeYear.substring(0, 6) + "31");
    	//선택한 일자 => toDate 매출 검색 종료일    	
    	request.setToDate(request.getSearchDay());
    	
		//오늘날짜 구하기
//	    Date today = new Date();	        
//	    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
//	    String toDay = date.format(today);
   
	    System.out.println(request);
	    
		/* 
		 * 1. 기간(12개월) 동안의 월별 매출기간 설정 ( SQL 에서의 CASE 문에서 기간 변수 설정을 위해 )
		 */	    
		request.setM12FrDate(request.getFrDate()); 
		request.setM12ToDate(request.getM12FrDate().substring(0, 6) + "31");	    
		request.setM11FrDate(sayUtils.getCusomMonth(request.getM12FrDate(), +1)); 
		request.setM11ToDate(request.getM11FrDate().substring(0, 6) + "31");
		request.setM10FrDate(sayUtils.getCusomMonth(request.getM11FrDate(), +1)); 
		request.setM10ToDate(request.getM10FrDate().substring(0, 6) + "31");
		request.setM09FrDate(sayUtils.getCusomMonth(request.getM10FrDate(), +1)); 
		request.setM09ToDate(request.getM09FrDate().substring(0, 6) + "31");
		request.setM08FrDate(sayUtils.getCusomMonth(request.getM09FrDate(), +1)); 
		request.setM08ToDate(request.getM08FrDate().substring(0, 6) + "31");
		request.setM07FrDate(sayUtils.getCusomMonth(request.getM08FrDate(), +1)); 
		request.setM07ToDate(request.getM07FrDate().substring(0, 6) + "31");
		request.setM06FrDate(sayUtils.getCusomMonth(request.getM07FrDate(), +1)); 
		request.setM06ToDate(request.getM06FrDate().substring(0, 6) + "31");
		request.setM05FrDate(sayUtils.getCusomMonth(request.getM06FrDate(), +1)); 
		request.setM05ToDate(request.getM05FrDate().substring(0, 6) + "31");
		request.setM04FrDate(sayUtils.getCusomMonth(request.getM05FrDate(), +1)); 
		request.setM04ToDate(request.getM04FrDate().substring(0, 6) + "31");
		request.setM03FrDate(sayUtils.getCusomMonth(request.getM04FrDate(), +1)); 
		request.setM03ToDate(request.getM03FrDate().substring(0, 6) + "31");
		request.setM02FrDate(sayUtils.getCusomMonth(request.getM03FrDate(), +1)); 
		request.setM02ToDate(request.getM02FrDate().substring(0, 6) + "31");
		request.setM01FrDate(sayUtils.getCusomMonth(request.getM02FrDate(), +1)); 
		request.setM01ToDate(request.getM01FrDate().substring(0, 6) + "31");
		request.setM00FrDate(sayUtils.getCusomMonth(request.getM01FrDate(), +1)); 
		request.setM00ToDate(request.getM00FrDate().substring(0, 6) + "31");

		System.out.println(request);
		
		List<YearCornerSaleNewsModel> result = yearCornerSaleNewsMapper.selectYearCornerSaleNewsList(request);
		
		System.out.println(result);
	    
//	    List<YearCornerSaleNewsModel> result = yearCornerSaleNewsMapper.selectYearCornerSaleNewsListCorner(request);
//	        
//	    	    
//	    for( YearCornerSaleNewsModel data: result ) {
//	    	/*12개월치 매출데이터 가져오기*/
//	    	request.setConer(data.getConer());
//	    	List<YearCornerSaleNewsModel> resultC = yearCornerSaleNewsMapper.selectYearCornerSaleNewsList(request);
//	    	
//	    	System.out.println("코너별 12개월 매출 가져오기 반복 출력");
//	    	System.out.println(resultC);
//	    	
//	    	for( YearCornerSaleNewsModel data2: resultC)
//	    	{
//	    		
//	    	}   	
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateYearCornerSaleNews(YearCornerSaleNewsParamModel request)throws Exception {

		int result = yearCornerSaleNewsMapper.updateYearCornerSaleNews(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertYearCornerSaleNews(YearCornerSaleNewsParamModel request) {

		int result = yearCornerSaleNewsMapper.insertYearCornerSaleNews(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveYearCornerSaleNews(YearCornerSaleNewsParamModel request) {

		int result = yearCornerSaleNewsMapper.saveYearCornerSaleNews(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteYearCornerSaleNews(YearCornerSaleNewsParamModel request) {

		int result = yearCornerSaleNewsMapper.deleteYearCornerSaleNews(request);
		return result;

	}

}