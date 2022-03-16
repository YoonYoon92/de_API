package com.saydept.api.spf.saleNews.eventHistoryInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.eventHistoryInq.model.EventHistoryInqModel;


	@Service
	public class EventHistoryInqService {

	@Autowired
	private EventHistoryInqMapper eventHistoryInqMapper;


	public List<EventHistoryInqModel> selectEventHistoryInqList(EventHistoryInqModel request)throws Exception {

		List<EventHistoryInqModel> result = eventHistoryInqMapper.selectEventHistoryInqList(request);
		return result;

	}



}