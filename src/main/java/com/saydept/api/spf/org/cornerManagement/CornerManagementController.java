package com.saydept.api.spf.org.cornerManagement;

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
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.cornerManagement.model.CornerManagementModel;
import com.saydept.api.spf.org.cornerManagement.model.CornerManagementSaveModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;


@CrossOrigin(origins = "*")
@RestController
public class CornerManagementController {

	@Autowired
	private CornerManagementService cornerManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/cornerManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 *  대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCornerManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */

	
	//목록조회 1건
	@RequestMapping(value = "api/cornerManagement/selectCornerManagement", method = RequestMethod.POST)
	public CornerManagementSaveModel selectCornerManagement(@RequestBody CornerManagementSaveModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		return cornerManagementService.selectCornerManagement(request);
	}

	
	@RequestMapping(value = "api/cornerManagement/saveCornerManagement", method = RequestMethod.POST)
	public int saveCornerManagement(@RequestBody CornerManagementSaveModel request)throws Exception {
		request.setMs05Mod("U");
		request.setMs05Sabun("SAY");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = cornerManagementService.saveCornerManagement(request);
		return result;
	}
	
	//목록저장 1건 신규
	@RequestMapping(value = "api/cornerManagement/insertCornerManagement", method = RequestMethod.POST)
	public int insertCornerManagement(@RequestBody CornerManagementSaveModel request)throws Exception {
		request.setMs05Mod("A");
		request.setMs05Sabun("SAY");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = cornerManagementService.saveCornerManagement(request);
		return result;
	}
	

	//코너 리스트 조회
	@RequestMapping(value = "api/cornerManagement/selectCornerList", method = RequestMethod.POST)
	public List<CornerManagementModel> selectCornerList(@RequestBody CornerManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<CornerManagementModel> result = cornerManagementService.selectCornerList(request);
		return result;
	}
	
	
}