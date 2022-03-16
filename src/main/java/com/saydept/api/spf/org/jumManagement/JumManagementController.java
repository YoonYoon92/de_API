package com.saydept.api.spf.org.jumManagement;

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
import com.saydept.api.spf.org.jumManagement.model.JumManagementModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementSaveModel;


@CrossOrigin(origins = "*")
@RestController
public class JumManagementController {

	@Autowired
	private JumManagementService jumManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/jumManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 *  대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectJumManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */

	
	//목록조회 1건
	@RequestMapping(value = "api/jumManagement/selectJumManagement", method = RequestMethod.POST)
	public JumManagementSaveModel selectJumManagement(@RequestBody JumManagementSaveModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		return jumManagementService.selectJumManagement(request);
	}
	
	//목록저장 1건
//	@RequestMapping(value = "api/jumManagement/saveJumManagement", method = RequestMethod.POST)
//	public int updateJumManagement(@RequestBody JumManagementSaveModel request)throws Exception {
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		request.setMs01Uptdate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		int result = jumManagementService.updateJumManagement(request);
//		return result;
//	}
	
	@RequestMapping(value = "api/jumManagement/saveJumManagement", method = RequestMethod.POST)
	//public static void callRPGProgram( String firstName, String lastName, String age, String message ){
//	public  JumManagementModel saveJumManagement(JumManagementSaveModel request)throws Exception {
	public int saveJumManagement(@RequestBody JumManagementSaveModel request)throws Exception {
		request.setMs01Mod("U");
		request.setMs01Sabun("SAY");
//		JumManagementModel result = jumManagementService.saveJumManagement(request);
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = jumManagementService.saveJumManagement(request);
		return result;
	}
	
	//목록저장 1건 신규
	@RequestMapping(value = "api/jumManagement/insertJumManagement", method = RequestMethod.POST)
	//public static void callRPGProgram( String firstName, String lastName, String age, String message ){
//	public  JumManagementModel saveJumManagement(JumManagementSaveModel request)throws Exception {
	public int insertJumManagement(@RequestBody JumManagementSaveModel request)throws Exception {
		request.setMs01Mod("A");
		request.setMs01Sabun("SAY");
//		JumManagementModel result = jumManagementService.saveJumManagement(request);
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = jumManagementService.saveJumManagement(request);
		return result;
	}


//	@RequestMapping(value = "api/jumManagement/insertJumManagement", method = RequestMethod.POST)
//	public int insertJumManagement(@RequestBody JumManagementSaveModel request)throws Exception {
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		request.setMs01Adddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");	
//		int result = jumManagementService.insertJumManagement(request);
////		System.out.println((char)27+"[0;36m     "+result+(char)27+"[0;00m");
//		return result;
//	}
	
	//점 리스트 조회
	@RequestMapping(value = "api/jumManagement/selectJumList", method = RequestMethod.POST)
	public List<JumManagementModel> selectJumList(@RequestBody JumManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<JumManagementModel> result = jumManagementService.selectJumList(request);
		return result;
	}
	
	
}