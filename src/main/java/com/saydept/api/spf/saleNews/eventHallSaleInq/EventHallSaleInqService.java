package com.saydept.api.spf.saleNews.eventHallSaleInq;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqSearchModel;


	@Service
	public class EventHallSaleInqService {

	@Autowired
	private EventHallSaleInqMapper eventHallSaleInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	PcList
	 * 
	 */
	
	public List<EventHallSaleInqSearchModel> PcList(EventHallSaleInqSearchModel request)throws ParseException {

	      System.out.println(request);
		
		List<EventHallSaleInqSearchModel> result = eventHallSaleInqMapper.PcList(request);
		 System.out.println(request);
		
		 
		return result;

	}
	
	public List<EventHallSaleInqSearchModel> Searcheventlist(EventHallSaleInqSearchModel request)throws ParseException {

	      System.out.println(request);
		
		List<EventHallSaleInqSearchModel> result = eventHallSaleInqMapper.SearchEventlist(request);
		 System.out.println(request);
		
		 
		return result;

	}

	public List<EventHallSaleInqModel> EventHallSaleInqList(EventHallSaleInqSearchModel request)throws ParseException {
		List<EventHallSaleInqModel> resultList = new ArrayList<EventHallSaleInqModel>();
		
		if (request.getPc() == null)
		{
			request.setPc("");
		}
		if (request.getBu() == null)
		{
			request.setBu("");
		}
		
		
		if(  request.getPc() != "" ) 
		{      
			System.out.println(request.getPc().length());
			System.out.println(request);  
			List<EventHallSaleInqModel> result = eventHallSaleInqMapper.EventHallSaleInqListPc(request);
			    
		 	resultList.addAll(result);
		}
		else if (request.getBu() != "")
		{
			System.out.println(request); 
			List<EventHallSaleInqModel> result = eventHallSaleInqMapper.EventHallSaleInqListBu(request);
		 	resultList.addAll(result);
		}
		else if(request.getJum() != "" )
		{
			System.out.println(request);      
			List<EventHallSaleInqModel> result = eventHallSaleInqMapper.EventHallSaleInqListJum(request);
			resultList.addAll(result);
		}
		 return resultList;	
		
 
	}
}