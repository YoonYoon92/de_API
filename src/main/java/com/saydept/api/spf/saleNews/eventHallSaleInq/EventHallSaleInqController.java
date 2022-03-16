package com.saydept.api.spf.saleNews.eventHallSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqSearchModel;

@CrossOrigin(origins = "*")
@RestController
public class EventHallSaleInqController {

	@Autowired
	private EventHallSaleInqService eventHallSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/eventHallSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	@RequestMapping(value = "/api/eventHallSaleInq/PcList", method = RequestMethod.POST)
	public List<EventHallSaleInqSearchModel> PcList(@RequestBody EventHallSaleInqSearchModel request)throws Exception {

		List<EventHallSaleInqSearchModel> result = eventHallSaleInqService.PcList(request);
		return result;
	}

	@RequestMapping(value = "api/eventHallSaleInqSearch/PcListTEST")
	public List<EventHallSaleInqSearchModel> TEST3()throws Exception {
		EventHallSaleInqSearchModel result = new EventHallSaleInqSearchModel();
		result.setStartDt("20200601");
		result.setJum("01");
		result.setBu("72");

		return eventHallSaleInqService.PcList(result);
	}
	@RequestMapping(value = "/api/eventHallSaleInq/selectEventHallSaleInqSearchList", method = RequestMethod.POST)
	public List<EventHallSaleInqSearchModel> Searcheventlist(@RequestBody EventHallSaleInqSearchModel request)throws Exception {

		List<EventHallSaleInqSearchModel> result = eventHallSaleInqService.Searcheventlist(request);
		return result;
	}

	@RequestMapping(value = "api/eventHallSaleInqSearch/TEST")
	public List<EventHallSaleInqSearchModel> TEST()throws Exception {
		EventHallSaleInqSearchModel result = new EventHallSaleInqSearchModel();
		result.setStartDt("20200408");
		

		return eventHallSaleInqService.Searcheventlist(result);
	}

	@RequestMapping(value = "/api/eventHallSaleInq/selectEventHallSaleInqList", method = RequestMethod.POST)
	public List<EventHallSaleInqModel> EventHallSaleInqList(@RequestBody EventHallSaleInqSearchModel request)throws Exception {

		List<EventHallSaleInqModel> result = eventHallSaleInqService.EventHallSaleInqList(request);
		return result;
	}

	@RequestMapping(value = "api/eventHallSaleInq/TEST")
	public List<EventHallSaleInqModel> TEST1()throws Exception {
		EventHallSaleInqSearchModel result = new EventHallSaleInqSearchModel();
		result.setStartDt("20200601");
		result.setEventcd1("EV");
		result.setEventcd2("06");
		result.setJum("01");
		result.setEventstartDt("20200529");
		result.setEventendDt("20200604");
		

		return eventHallSaleInqService.EventHallSaleInqList(result);
	}

}