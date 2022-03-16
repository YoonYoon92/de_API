package com.saydept.api.spf.org.zoneLinkManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.org.conerLinkManagement.model.ConerLinkManagementModel;
import com.saydept.api.spf.org.zoneLinkManagement.model.ZoneLinkManagementModel;

@CrossOrigin(origins = "*")
@RestController
public class ZoneLinkManagementController {

	@Autowired
	private ZoneLinkManagementService ZoneLinkManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/zoneLinkManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectZoneLinkManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/zoneLinkManagement/selectZoneLinkManagement", method = RequestMethod.POST)
	public ZoneLinkManagementModel selectZoneLinkManagement1(@RequestBody ZoneLinkManagementModel request)throws Exception {

		ZoneLinkManagementModel result = ZoneLinkManagementService.selectZoneLinkManagement(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectZoneLinkManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/zoneLinkManagement/selectZoneLinkManagementList", method = RequestMethod.POST)
	public List<ZoneLinkManagementModel> selectZoneLinkManagementList(@RequestBody ZoneLinkManagementModel request)throws Exception {

		List<ZoneLinkManagementModel> result = ZoneLinkManagementService.selectZoneLinkManagementList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateZoneLinkManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/zoneLinkManagement/updateZoneLinkManagement", method = RequestMethod.POST)
	public int updateZoneLinkManagement(@RequestBody ZoneLinkManagementModel request)throws Exception {

		int result = ZoneLinkManagementService.updateZoneLinkManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertZoneLinkManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/zoneLinkManagement/insertZoneLinkManagement", method = RequestMethod.POST)
	public int insertZoneLinkManagement(@RequestBody ZoneLinkManagementModel request)throws Exception {
		System.out.println(request);
		int result = ZoneLinkManagementService.insertZoneLinkManagement(request);
		
		
		System.out.println(result);
		return result;
	}

	
	@RequestMapping(value = "api/zoneLinkManagement/deleteZoneLinkManagement", method = RequestMethod.POST)
	public int deleteZoneLinkManagement(@RequestBody ZoneLinkManagementModel request)throws Exception {
		System.out.println(request);
		int result = ZoneLinkManagementService.deleteZoneLinkManagement(request);
		return result;
	}
	//존목록조회
	@RequestMapping(value = "api/zoneLinkManagement/selectzoneStoreList", method = RequestMethod.POST)
	public List<ZoneLinkManagementModel> selectzoneStoreList(@RequestBody ZoneLinkManagementModel request)throws Exception {

		
		List<ZoneLinkManagementModel> result = ZoneLinkManagementService.selectzoneStoreList(request);
		return result;
	}
	
	/**
	 연계코너 체크
	 */
	@RequestMapping(value = "api/zoneLinkManagement/selectConerchk", method = RequestMethod.POST)
	public ZoneLinkManagementModel selectConerchk(@RequestBody ZoneLinkManagementModel request)throws Exception {

		ZoneLinkManagementModel result = ZoneLinkManagementService.selectConerchk(request);
		return result;
	}


}