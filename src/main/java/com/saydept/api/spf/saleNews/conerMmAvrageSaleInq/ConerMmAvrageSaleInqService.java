package com.saydept.api.spf.saleNews.conerMmAvrageSaleInq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model.ConerMmAvrageSaleInqModel;
import com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model.ConerMmAvrageSaleInqParamModel;

	@Service
	public class ConerMmAvrageSaleInqService {

	@Autowired
	private ConerMmAvrageSaleInqMapper conerMmAvrageSaleInqMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ConerMmAvrageSaleInqModel> selectConerMmAvrageSaleInqList(ConerMmAvrageSaleInqParamModel request)throws Exception {

		//List<ConerMmAvrageSaleInqModel> result = conerMmAvrageSaleInqMapper.selectConerMmAvrageSaleInqList(request);
		List<ConerMmAvrageSaleInqModel> resultList = new ArrayList<ConerMmAvrageSaleInqModel>();
		

		//등급이 팀일때		
		if( request.getSerchLevel().equals("tim") ) {		
			
			//월카운트 구하기
			int mcount1;
			int mcount2;
			
			mcount1 =  Integer.parseInt(request.getFrDate().substring(0,4));
			mcount2 =  Integer.parseInt(request.getToDate().substring(0,4));			
			
			if(mcount1 != mcount2)
				mcount2 = Integer.parseInt(request.getToDate().substring(4,6)) + 13;
			else
				mcount2 = Integer.parseInt(request.getToDate().substring(4,6)) + 1;			
			mcount1 =  Integer.parseInt(request.getFrDate().substring(4,6));
			
			request.setMmCount(mcount2-mcount1);
			//월카운트 구하기 끝
			
			//당년검색시작월, 종료월 셋팅
//			request.setFrYYMM(request.getFrDate().substring(0,6));
//			request.setToYYMM(request.getToDate().substring(0,6));		
			
						
			//전년 검색시작월, 종료월 셋팅 
//			mcount1 =  Integer.parseInt(request.getFrDate().substring(0,4)) - 1;
//			mcount2 =  Integer.parseInt(request.getToDate().substring(0,4)) - 1;	
//			request.setFrYYMMLastY(String.valueOf(mcount1)+request.getFrDate().substring(4,6));
//			request.setToYYMMLastY(String.valueOf(mcount2)+request.getToDate().substring(4,6));	
			//전년 검색시작일, 종료일 셋팅
			mcount1 =  Integer.parseInt(request.getFrDate().substring(0,4)) - 1;
			mcount2 =  Integer.parseInt(request.getToDate().substring(0,4)) - 1;	
			request.setFrDateLastY(String.valueOf(mcount1)+request.getFrDate().substring(4,8));
			request.setToDateLastY(String.valueOf(mcount2)+request.getToDate().substring(4,8));	
			
		
			System.out.println(request);
			
			
			List<ConerMmAvrageSaleInqModel> result = conerMmAvrageSaleInqMapper.selectConerMmAvrageSaleInqList(request);		
			resultList.addAll(result);		
		}			

		
		
		

		
		return resultList;

	}

	

}