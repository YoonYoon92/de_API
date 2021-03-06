package com.saydept.api.spf.saleNews.dayBestSaleInq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.dayBestSaleInq.model.DayBestSaleInqModel;
import com.saydept.api.spf.saleNews.dayBestSaleInq.model.DayBestSaleInqParamModel;

	@Service
	public class DayBestSaleInqService {

	@Autowired
	private DayBestSaleInqMapper dayBestSaleInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DayBestSaleInqModel> selectDayBestSaleInqList(DayBestSaleInqParamModel request)throws Exception {

		
		List<DayBestSaleInqModel> resultList = new ArrayList<DayBestSaleInqModel>();
		
		
		//등급이 점일때		
		if( request.getSerchLevel().equals("jum") ) {			
		List<DayBestSaleInqModel> result = dayBestSaleInqMapper.selectDayBestSaleInqListLv1(request);		
		resultList.addAll(result);
		
		List<DayBestSaleInqModel> result1 = dayBestSaleInqMapper.selectDayBestSaleInqListLv1Today(request);
		resultList.addAll(0, result1);
		}			
			
		//등급이 부일때		
		if( request.getSerchLevel().equals("bu") ) {			
		List<DayBestSaleInqModel> result = dayBestSaleInqMapper.selectDayBestSaleInqListLv2(request);		
		resultList.addAll(result);
		
		List<DayBestSaleInqModel> result1 = dayBestSaleInqMapper.selectDayBestSaleInqListLv2Today(request);
		resultList.addAll(0, result1);
		}		
				
		//등급이 팀일때		
		if( request.getSerchLevel().equals("tim") ) {			
		List<DayBestSaleInqModel> result = dayBestSaleInqMapper.selectDayBestSaleInqListLv3(request);		
		resultList.addAll(result);
		
		List<DayBestSaleInqModel> result1 = dayBestSaleInqMapper.selectDayBestSaleInqListLv3Today(request);
		resultList.addAll(0, result1);
		}		
		
		return resultList;
	}
	
	

}