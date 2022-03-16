package com.saydept.api.spf.org.zoneManagement;

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
import com.saydept.api.spf.org.zoneManagement.model.ZoneManagementModel;
import com.saydept.api.spf.org.zoneManagement.model.ZoneManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.org.pcManagement.model.PcManagementSaveModel;


@CrossOrigin(origins = "*")
@RestController
public class ZoneManagementController {

	@Autowired
	private ZoneManagementService zoneManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/zoneManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 *  대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectZoneManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */

	
	//목록조회 1건
	@RequestMapping(value = "api/zoneManagement/selectZoneManagement", method = RequestMethod.POST)
	public ZoneManagementSaveModel selectZoneManagement(@RequestBody ZoneManagementSaveModel request)throws Exception {
//		ZoneManagementSaveModel result = zoneManagementService.selectZoneManagement(request);
		return zoneManagementService.selectZoneManagement(request);
	}
	
	
	@RequestMapping(value = "api/zoneManagement/saveZoneManagement", method = RequestMethod.POST)
	public int saveZoneManagement(@RequestBody ZoneManagementSaveModel request)throws Exception {
		request.setMs21Mod("U");
		request.setMs21Sabun("SAY");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = zoneManagementService.saveZoneManagement(request);
		return result;
	}
	
	//목록저장 1건 신규
	@RequestMapping(value = "api/zoneManagement/insertZoneManagement", method = RequestMethod.POST)
	public int insertZoneManagement(@RequestBody ZoneManagementSaveModel request)throws Exception {
		request.setMs21Mod("A");
		request.setMs21Sabun("SAY");
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		int result = zoneManagementService.saveZoneManagement(request);
		return result;
	}


	//부 리스트 조회
	@RequestMapping(value = "api/zoneManagement/selectBuList", method = RequestMethod.POST)
	public List<ZoneManagementModel> selectBuList(@RequestBody ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementService.selectBuList(request);
		return result;
	}
	
	//팀 리스트 조회
	@RequestMapping(value = "api/zoneManagement/selectTimList", method = RequestMethod.POST)
	public List<ZoneManagementModel> selectTimList(@RequestBody ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementService.selectTimList(request);
		return result;
	}
	
	//PC 리스트 조회
	@RequestMapping(value = "api/zoneManagement/selectPcList", method = RequestMethod.POST)
	public List<ZoneManagementModel> selectPcList(@RequestBody ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementService.selectPcList(request);
		return result;
	}
	
	//존 리스트 조회
	@RequestMapping(value = "api/zoneManagement/selectZoneList", method = RequestMethod.POST)
	public List<ZoneManagementModel> selectZoneList(@RequestBody ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementService.selectZoneList(request);
		return result;
	}
	
	
}