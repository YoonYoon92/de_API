package com.saydept.api.spf.rtngud.rtnReqManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.puchas.buyReqManagement.model.BuyReqManagementModel;
import com.saydept.api.spf.rtngud.rtnReqManagement.model.RtnReqManagementModel;


@CrossOrigin(origins = "*")
@RestController
public class RtnReqManagementController {

	@Autowired
	private RtnReqManagementService rtnReqManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/rtnReqManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectrtnReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/rtnReqManagement/selectrtnReqManagement", method = RequestMethod.POST)
	public RtnReqManagementModel selectrtnReqManagement(@RequestBody RtnReqManagementModel request)throws Exception {

		RtnReqManagementModel result = rtnReqManagementService.selectRtnReqManagement(request);
		return result;
	}
	
	@RequestMapping(value = "api/rtnReqManagement/itemDetail", method = RequestMethod.POST)
	public RtnReqManagementModel itemDetail(@RequestBody RtnReqManagementModel request)throws Exception {

		RtnReqManagementModel result = rtnReqManagementService.itemDetail(request);
		return result;
	}


	@RequestMapping(value = "api/rtnReqManagement/selectrtnReqManagementList", method = RequestMethod.POST)
	public List<RtnReqManagementModel> selectrtnReqManagementList(@RequestBody RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementService.selectRtnReqManagementList(request);
		return result;
	}

	//전표년도
	@RequestMapping(value = "api/rtnReqManagement/chitYearList", method = RequestMethod.POST)
	public List<RtnReqManagementModel> chitYearList(@RequestBody RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementService.chitYearList(request);
		return result;
	}
	
	
	@RequestMapping(value = "api/rtnReqManagement/chitSearchResult", method = RequestMethod.POST)
	public RtnReqManagementModel chitSearchResult(@RequestBody RtnReqManagementModel request)throws Exception {

		RtnReqManagementModel result = rtnReqManagementService.chitSearchResult(request);
		return result;
	}
	@RequestMapping(value = "api/rtnReqManagement/chitSearchResultDetail", method = RequestMethod.POST)
	public List<RtnReqManagementModel> chitSearchResultDetail(@RequestBody RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementService.chitSearchResultDetail(request);
		return result;
	}
	
	
	
	//거래선체크
	@RequestMapping(value = "api/rtnReqManagement/checkPartner", method = RequestMethod.POST)
	public RtnReqManagementModel checkPartner(@RequestBody RtnReqManagementModel request)throws Exception {

		RtnReqManagementModel result = rtnReqManagementService.checkPartner(request);
		return result;
	}
	
	//단품리스트
	@RequestMapping(value = "api/rtnReqManagement/itemList", method = RequestMethod.POST)
	public List<RtnReqManagementModel> itemList(@RequestBody RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementService.itemList(request);
		return result;
	}
	
	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updatertnReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/rtnReqManagement/updateRtnReqManagement", method = RequestMethod.POST)
	public int updateRtnReqManagement(@RequestBody List<RtnReqManagementModel> request)throws Exception {

		int result = rtnReqManagementService.updateRtnReqManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertrtnReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/rtnReqManagement/itemsCdCheck", method = RequestMethod.POST)
	public RtnReqManagementModel itemsCdCheck(@RequestBody RtnReqManagementModel request)throws Exception {
		
		RtnReqManagementModel result = rtnReqManagementService.itemsCdCheck(request);
		return result;
	}
	
	@RequestMapping(value = "api/rtnReqManagement/insertRtnReqManagement2", method = RequestMethod.POST)
	public int insertrtnReqManagement2(@RequestBody List<RtnReqManagementModel> request)throws Exception {
		System.out.println(request);
		int result = rtnReqManagementService.insertRtnReqManagement2(request);
		return result;
	}
	
	

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)savertnReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/rtnReqManagement/savertnReqManagement", method = RequestMethod.POST)
	public int savertnReqManagement(@RequestBody RtnReqManagementModel request)throws Exception {

		int result = rtnReqManagementService.saveRtnReqManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deletertnReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/rtnReqManagement/deleteRtnReqManagement", method = RequestMethod.POST)
	public int deleteRtnReqManagement(@RequestBody RtnReqManagementModel request)throws Exception {

		int result = rtnReqManagementService.deleteRtnReqManagement(request);
		return result;
	}

}