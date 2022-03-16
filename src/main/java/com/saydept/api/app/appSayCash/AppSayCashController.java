package com.saydept.api.app.appSayCash;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.app.appSayCash.model.AppSayCashModel;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class AppSayCashController {

	@Autowired
	private AppSayCashService appSayCashService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/appSayCash")
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	//ECASH금액내역 
	@RequestMapping(value = "api/appSayCash/selectAppSayCash", method = RequestMethod.POST)
	public AppSayCashModel selectAppSayCash(@RequestBody AppSayCashModel request)throws Exception {

		AppSayCashModel result = appSayCashService.selectAppSayCash(request);
		return result;
	}
	
	//ECASH 지급내역 및 매출내역
	@RequestMapping(value = "api/appSayCash/AppSayCashDetail", method = RequestMethod.POST)
	public List<AppSayCashModel> AppSayCashDetail(@RequestBody AppSayCashModel request)throws Exception {

		List<AppSayCashModel> result = appSayCashService.AppSayCashDetail(request);
		return result;
	}
	//ECASH 지급내역 상세정보(지급내역이 어떤식으로 이루어졌는지 확인)
	@RequestMapping(value = "api/appSayCash/eventReceipt", method = RequestMethod.POST)
	public List<AppSayCashModel> eventReceipt(@RequestBody AppSayCashModel request)throws Exception {

		List<AppSayCashModel> result = appSayCashService.eventReceipt(request);
		return result;
	}
	
	@RequestMapping(value = "api/appSayCash/test")
	public AppSayCashModel test( AppSayCashModel request)throws Exception {
		AppSayCashModel param =new AppSayCashModel();
		param.setWheno("9200279920113092");

		System.out.println(request);
		AppSayCashModel result = appSayCashService.selectAppSayCash(param);
		return result;
	}
	
	@RequestMapping(value = "api/appSayCash/test2")
	public List<AppSayCashModel> AppSayCashDetail2(AppSayCashModel request)throws Exception {
		AppSayCashModel param =new AppSayCashModel();
		param.setWheno("9200279920113092");
		param.setFrDate("20210501");
		List<AppSayCashModel> result = appSayCashService.AppSayCashDetail(param);
		return result;
	}
	

}