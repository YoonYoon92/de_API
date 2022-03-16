package com.saydept.api.app.appMemUpt;

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
import com.saydept.api.app.appMemUpt.model.AppMemUptModel;
import com.saydept.api.app.appMemUpt.model.AppMemUptParamModel;

@CrossOrigin(origins = "*")
@RestController
public class AppMemUptController {

	@Autowired
	private AppMemUptService appMemUptService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/appMemUpt", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
//	
//	@RequestMapping(value = "api/appMemUpt/insertAppMemUpt")
//	public int insertAppMemUpt(@RequestBody AppMemUptParamModel request)throws Exception {
//		AppMemUptParamModel param=new AppMemUptParamModel();
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
//		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
//		Date time = new Date();
//		String time1 = format1.format(time);
//		String time2 = format2.format(time);
//		request.setJoinDate(time1);
//		request.setJoinTime(time2);
//		System.out.println(request);
//		int result = appMemUptService.insertAppMemUpt(request);
//		return result;
//	}

	@RequestMapping(value = "api/appMemUpt/memUpt")
	public AppMemUptModel insertAppMemUpt(@RequestBody AppMemUptParamModel request)throws Exception {
		AppMemUptParamModel param=new AppMemUptParamModel();
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		request.setUptDate(time1);
		request.setUptTime(time2);
		request.setAddr8("");
		
		request.setFill("");
		System.out.println(request);
		AppMemUptModel result = appMemUptService.insertAppMemUpt(request);
		return result;
	}
	//결과값확인
//	@RequestMapping(value = "api/appMemUpt/insertAppMemUpt")
//	public AppMemUptParamModel insertAppMemUpt(@RequestBody AppMemUptParamModel request)throws Exception {
//		AppMemUptParamModel param=new AppMemUptParamModel();
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
//		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
//		Date time = new Date();
//		String time1 = format1.format(time);
//		String time2 = format2.format(time);
//		request.setJoinDate(time1);
//		request.setJoinTime(time2);
//		System.out.println(request);
//		//int result = appMemUptService.insertAppMemUpt(request);
//		return request;
//	}

//	@RequestMapping(value = "api/appMemUpt/Test")
//	public int insertAppMemUptTest(AppMemUptParamModel request)throws Exception {
//		AppMemUptParamModel param=new AppMemUptParamModel();
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
//		System.out.println(param);
//		int result = appMemUptService.insertAppMemUpt(param);
//		return result;
//		
//	}
	
	
	@RequestMapping(value = "api/appMemUpt/Test")
	//public static void callRPGProgram( String firstName, String lastName, String age, String message ){
	public  AppMemUptModel insertAppMemUptTest1(AppMemUptParamModel request)throws Exception {

		
		AppMemUptParamModel param=new AppMemUptParamModel();
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		
		
		//param.setJoinTime();
		param.setUptDate(time1);
		param.setUptTime(time2);
		param.setCitizenNo1("920716");
		param.setCitizenNo2("1403026");
		param.setId("waz134");
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
		param.setAddrCode("3011042920010100001400000");
		param.setBuildCode("3011011800102790001019422");
		param.setHptel("01077365280");
		param.setUptHptel("01052807736");
		param.setFill("");
		
		
	
		AppMemUptModel result = appMemUptService.insertAppMemUpt(param);
		System.out.println(result);
		return result;
		
	}
	
	
}