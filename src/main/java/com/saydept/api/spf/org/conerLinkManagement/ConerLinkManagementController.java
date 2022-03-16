package com.saydept.api.spf.org.conerLinkManagement;

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

@CrossOrigin(origins = "*")
@RestController
public class ConerLinkManagementController {

	@Autowired
	private ConerLinkManagementService conerLinkManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/conerLinkManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 연계코너 체크
	 */
	@RequestMapping(value = "api/conerLinkManagement/selectConerLinkManagement", method = RequestMethod.POST)
	public ConerLinkManagementModel selectConerLinkManagement(@RequestBody ConerLinkManagementModel request)throws Exception {

		ConerLinkManagementModel result = conerLinkManagementService.selectConerLinkManagement(request);
		return result;
	}

	/**
	 연계코너 그리드조회
	 */
	@RequestMapping(value = "api/conerLinkManagement/selectConerLinkManagementList", method = RequestMethod.POST)
	public List<ConerLinkManagementModel> selectConerLinkManagementList(@RequestBody ConerLinkManagementModel request)throws Exception {

		List<ConerLinkManagementModel> result = conerLinkManagementService.selectConerLinkManagementList(request);
		return result;
	}



	/**
	연계코너 추가
	 */
	@RequestMapping(value = "api/conerLinkManagement/insertConerLinkManagement", method = RequestMethod.POST)
	public int insertConerLinkManagement(@RequestBody ConerLinkManagementModel request)throws Exception {

		int result = conerLinkManagementService.insertConerLinkManagement(request);
		return result;
	}



	/**
	연계코너 삭제
	 */
	@RequestMapping(value = "api/conerLinkManagement/deleteConerLinkManagement", method = RequestMethod.POST)
	public int deleteConerLinkManagement(@RequestBody ConerLinkManagementModel request)throws Exception {

		int result = conerLinkManagementService.deleteConerLinkManagement(request);
		return result;
	}

}