package com.saydept.api.app.appSayCash;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.app.appSayCash.model.AppSayCashModel;

	@Service
	public class AppSayCashService {

	@Autowired
	private AppSayCashMapper appSayCashMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public AppSayCashModel selectAppSayCash(AppSayCashModel request)throws Exception {
		
	AppSayCashModel result = appSayCashMapper.selectAppSayCash(request);
	Date time = new Date();
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
	SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
	String time1 = format1.format(time);
	String time2 = format2.format(time);
	result.setNow(time1+time2);
	return result;

	}
	
	
	public List<AppSayCashModel> AppSayCashDetail(AppSayCashModel request)throws Exception {
		
		List<AppSayCashModel> result = appSayCashMapper.AppSayCashDetail(request);
		System.out.println(result);
		return result;

		}
	//ecash지급 상세내역
	public List<AppSayCashModel> eventReceipt(AppSayCashModel request)throws Exception {
		
		List<AppSayCashModel> result = appSayCashMapper.eventReceipt(request);
		System.out.println(result);
		return result;

		}

}