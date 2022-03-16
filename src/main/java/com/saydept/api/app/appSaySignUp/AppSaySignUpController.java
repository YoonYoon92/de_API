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
	//결과값확인
//	@RequestMapping(value = "api/appSaySignUp/insertAppSaySignUp")
//	public AppSaySignUpParamModel insertAppSaySignUp(@RequestBody AppSaySignUpParamModel request)throws Exception {
//		AppSaySignUpParamModel param=new AppSaySignUpParamModel();
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
//		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
//		Date time = new Date();
//		String time1 = format1.format(time);
//		String time2 = format2.format(time);
//		request.setJoinDate(time1);
//		request.setJoinTime(time2);
//		System.out.println(request);
//		//int result = appSaySignUpService.insertAppSaySignUp(request);
//		return request;
//	}

//	@RequestMapping(value = "api/appSaySignUp/Test")
//	public int insertAppSaySignUpTest(AppSaySignUpParamModel request)throws Exception {
//		AppSaySignUpParamModel param=new AppSaySignUpParamModel();
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
//		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
//		Date time = new Date();
//		String time1 = format1.format(time);
//		String time2 = format2.format(time);
//		param.setJoinDate(time1);
//		param.setJoinTime(time2);
//		param.setName("윤경윤");
//		param.setBirthday("920716");
//		//param.setSDiv("1");
//		param.setPostAddr("34624");
//		param.setAllAddr("대전광역시 동구 대전천동로 618(삼성동,빌라맨션) B동 805호");
//		param.setAddr1("대전광역시");
//		param.setAddr2("동구");
//		param.setAddr3("삼성동");
//		param.setAddr4("대전천동로");
//		param.setAddr5("618");
//		param.setAddr6("");
//		param.setAddr7("B동805호(삼성동,빌라맨션)");
//		param.setAddr8("");
//		param.setHptel("01077365280");
//		param.setAddrCode("3011042920010100001400000");
//		param.setBuildCode("3011011800102790001019422");
//		param.setSelCard("91");
//		param.setIp("128.131.13.23");
//		param.setId("waz134");
//		System.out.println(param);
//		int result = appSaySignUpService.insertAppSaySignUp(param);
//		return result;
//		
//	}
	
	
	@RequestMapping(value = "api/appSaySignUp/Test")
	//public static void callRPGProgram( String firstName, String lastName, String age, String message ){
	public  AppSaySignUpModel insertAppSaySignUpTest1(AppSaySignUpParamModel request)throws Exception {

		
		AppSaySignUpParamModel param=new AppSaySignUpParamModel();
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		param.setJoinDate(time1);
		param.setJoinTime(time2);
		
		//param.setJoinTime();
		param.setName("윤경윤");
		param.setBirthday("981212");
		param.setGender("1");
		param.setPostAddr("34624");
		param.setAllAddr("대전광역시 동구 대전천동로 618(삼성동,빌라맨션) B동 805호");
		param.setAddr1("대전광역시");
		param.setAddr2("동구");
		param.setAddr3("삼성동");
		param.setAddr4("대전천동로");
		param.setAddr5("618");
		param.setAddr6("");
		param.setAddr7("B동805호(삼성동,빌라맨션)");
		param.setAddr8("");
		param.setHptel("01077755280");
		param.setAddrCode("3011042920010100001400000");
		param.setBuildCode("3011011800102790001019422");
		param.setSelCard("91");
		param.setIp("128.131.13.23");
		param.setCreditAgree("1");
		param.setSmsAgree("1");
		param.setDmAgree("1");
		param.setFill("");
		param.setId("waz134");
		AppSaySignUpModel result = appSaySignUpService.insertAppSaySignUp(param);
		System.out.println(result);
		return result;
		
	}
	
	
}