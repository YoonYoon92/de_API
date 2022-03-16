package com.saydept.api.spf.org.pcManagement;

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
import com.saydept.api.spf.org.pcManagement.model.PcManagementModel;
import com.saydept.api.spf.org.pcManagement.model.PcManagementSaveModel;
import com.saydept.api.spf.org.timManagement.model.TimManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;


@CrossOrigin(origins = "*")
@RestController
public class PcManagementController {

	@Autowired
	private PcManagementService pcManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/pcManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 *  대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectPcManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */

	
	//목록조회 1건
	@RequestMapping(value = "api/pcManagement/selectPcManagement", method = RequestMethod.POST)
	public PcManagementSaveModel selectPcManagement(@RequestBody PcManagementSaveModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		
//		PcManagementSaveModel result = pcManagementService.selectPcManagement(request);
		return pcManagementService.selectPcManagement(request);
	}
	
	@RequestMapping(value = "api/pcManagement/savePcManagement", method = RequestMethod.POST)
	public int savePcManagement(@RequestBody PcManagementSaveModel request)throws Exception {
		request.setMs04Mod("U");
		request.setMs04Sabun("SAY");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = pcManagementService.savePcManagement(request);
		return result;
	}
	
	//목록저장 1건 신규
	@RequestMapping(value = "api/buManagement/insertPcManagement", method = RequestMethod.POST)
	public int insertPcManagement(@RequestBody PcManagementSaveModel request)throws Exception {
		request.setMs04Mod("A");
		request.setMs04Sabun("SAY");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = pcManagementService.savePcManagement(request);
		return result;
	}


	//부 리스트 조회
	@RequestMapping(value = "api/pcManagement/selectBuList", method = RequestMethod.POST)
	public List<PcManagementModel> selectBuList(@RequestBody PcManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<PcManagementModel> result = pcManagementService.selectBuList(request);
		return result;
	}
	
	//팀 리스트 조회
	@RequestMapping(value = "api/pcManagement/selectTimList", method = RequestMethod.POST)
	public List<PcManagementModel> selectTimList(@RequestBody PcManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");

		List<PcManagementModel> result = pcManagementService.selectTimList(request);
		return result;
	}
	
	//PC 리스트 조회
	@RequestMapping(value = "api/pcManagement/selectPcList", method = RequestMethod.POST)
	public List<PcManagementModel> selectPcList(@RequestBody PcManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<PcManagementModel> result = pcManagementService.selectPcList(request);
		return result;
	}
	
	
}