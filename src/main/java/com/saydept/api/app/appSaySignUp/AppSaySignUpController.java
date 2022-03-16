package com.saydept.api.app.appSaySignUp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.saydept.api.app.appSaySignUp.model.AppSaySignUpModel;
import com.saydept.api.app.appSaySignUp.model.AppSaySignUpParamModel;

@CrossOrigin(origins = "*")
@RestController
public class AppSaySignUpController {

	@Autowired
	private AppSaySignUpService appSaySignUpService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/appSaySignUp", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
//	
//	@RequestMapping(value = "api/appSaySignUp/insertAppSaySignUp")
//	public int insertAppSaySignUp(@RequestBody AppSaySignUpParamModel request)throws Exception {
//		AppSaySignUpParamModel param=new AppSaySignUpParamModel();
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
//		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
//		Date time = new Date();
//		String time1 = format1.format(time);
//		String time2 = format2.format(time);
//		request.setJoinDate(time1);
//		request.setJoinTime(time2);
//		System.out.println(request);
//		int result = appSaySignUpService.insertAppSaySignUp(request);
//		return result;
//	}

	@RequestMapping(value = "api/appSaySignUp/insertAppSaySignUp")
	public AppSaySignUpModel insertAppSaySignUp(@RequestBody AppSaySignUpParamModel request)throws Exception {
		AppSaySignUpParamModel param=new AppSaySignUpParamModel();
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		request.setJoinDate(time1);
		request.setJoinTime(time2);
		request.setAddr8("");
		request.setCreditAgree("1");
		request.setSmsAgree("1");
		request.setDmAgree("1");
		request.setFill("");
		System.out.println(request);
		AppSaySignUpModel result = appSaySignUpService.insertAppSaySignUp(request);
		return result;
	}
	
	
	
	
	
}