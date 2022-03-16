package com.saydept.api.admin.userProgListManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.saydept.api.comm.model.AccountInput;
import com.saydept.api.comm.model.AccountModel;
import com.saydept.api.comm.model.DbConfig;
import com.saydept.api.comm.model.ResModel;
import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
import com.saydept.api.spf.org.buManagement.model.BuManagementModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.admin.userProgListManagement.model.UserProgListManagementModel;
import com.saydept.api.admin.userProgListManagement.model.UserProgListManagementSaveModel;


@CrossOrigin(origins = "*")
@RestController
public class UserProgListManagementController {

	@Autowired
	private UserProgListManagementService userProgListManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/userProgListManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 *  대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectUserProgListManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "api/userProgListManagement/insertUserProgListManagement", method = RequestMethod.POST)
//	public int insertUserProgListManagement(@RequestBody UserProgListManagementSaveModel request)throws Exception {
	public UserProgListManagementSaveModel insertUserProgListManagement(@RequestBody UserProgListManagementSaveModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                                        ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");	
//		request.setMs01Adddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
//		request.setZd02Mod("A");
		int result = 0;
		result = userProgListManagementService.insertUserProgListManagement(request);
		request.setZd02Result("권한:"+Integer.toString(result));
		result = userProgListManagementService.insertUserProgListManagement1(request);
		request.setZd02Result(request.getZd02Result()+", "+"메뉴:"+Integer.toString(result));
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                                        ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");	
		return request;
	}
	
	
	//PGM 리스트 조회
//	@RequestMapping(value = "api/userProgListManagement/selectPgmList", method = RequestMethod.POST)
//	public List<UserProgListManagementModel> selectPgmList(@RequestBody UserProgListManagementModel request)throws Exception {
////		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                                        ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date()));
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		List<UserProgListManagementModel> result = userProgListManagementService.selectPgmList(request);
//		return result;
//	}
	
	//MenuGroupId 리스트 조회
	@RequestMapping(value = "api/userProgListManagement/selectMenuGroupIdList", method = RequestMethod.POST)
	public List<UserProgListManagementModel> selectMenuGroupIdList(@RequestBody UserProgListManagementModel request)throws Exception {
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                                        ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date()));
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<UserProgListManagementModel> result = userProgListManagementService.selectMenuGroupIdList(request);
		return result;
	}
	
	
	//MenuId 리스트 조회
	@RequestMapping(value = "api/userProgListManagement/selectMenuIdList", method = RequestMethod.POST)
	public List<UserProgListManagementModel> selectMenuIdList(@RequestBody UserProgListManagementModel request)throws Exception {
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                                        ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date()));
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<UserProgListManagementModel> result = userProgListManagementService.selectMenuIdList(request);
		return result;
	}
	
		
}