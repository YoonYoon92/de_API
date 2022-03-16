package com.saydept.api.spf.saleNews.eventHistoryInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.eventHistoryInq.model.EventHistoryInqModel;


@CrossOrigin(origins = "*")
@RestController
public class EventHistoryInqController {

	@Autowired
	private EventHistoryInqService eventHistoryInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/eventHistoryInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
	
	@RequestMapping(value = "api/eventHistoryInq/selectEventHistoryInqList", method = RequestMethod.POST)
	public List<EventHistoryInqModel> selectEventHistoryInqList(@RequestBody EventHistoryInqModel request)throws Exception {

		List<EventHistoryInqModel> result = eventHistoryInqService.selectEventHistoryInqList(request);
		return result;
	}

	@RequestMapping(value = "api/eventHistoryInq/TEST")
	public List<EventHistoryInqModel> TEST1()throws Exception {
		EventHistoryInqModel result = new EventHistoryInqModel();
		result.setStartDt("20200601");
	
	
		return eventHistoryInqService.selectEventHistoryInqList(result);
	}

}