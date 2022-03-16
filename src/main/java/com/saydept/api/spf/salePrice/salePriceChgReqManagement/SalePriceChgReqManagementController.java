package com.saydept.api.spf.salePrice.salePriceChgReqManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.rtngud.rtnReqManagement.model.RtnReqManagementModel;
import com.saydept.api.spf.salePrice.salePriceChgReqManagement.model.SalePriceChgReqManagementModel;

@CrossOrigin(origins = "*")
@RestController
public class SalePriceChgReqManagementController {

	@Autowired
	private SalePriceChgReqManagementService salePriceChgReqManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectSalePriceChgReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement/selectSalePriceChgReqManagement", method = RequestMethod.POST)
	public SalePriceChgReqManagementModel selectSalePriceChgReqManagement(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

		SalePriceChgReqManagementModel result = salePriceChgReqManagementService.selectSalePriceChgReqManagement(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalePriceChgReqManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement/selectSalePriceChgReqManagementList", method = RequestMethod.POST)
	public List<SalePriceChgReqManagementModel> selectSalePriceChgReqManagementList(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

		List<SalePriceChgReqManagementModel> result = salePriceChgReqManagementService.selectSalePriceChgReqManagementList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateSalePriceChgReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement/updateSalePriceChgReqManagement", method = RequestMethod.POST)
	public int updateSalePriceChgReqManagement(@RequestBody List<SalePriceChgReqManagementModel> request)throws Exception {

		int result = salePriceChgReqManagementService.updateSalePriceChgReqManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertSalePriceChgReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement/insertSalePriceChgReqManagement", method = RequestMethod.POST)
	public int insertSalePriceChgReqManagement(@RequestBody List<SalePriceChgReqManagementModel> request)throws Exception {

		int result = salePriceChgReqManagementService.insertSalePriceChgReqManagement(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveSalePriceChgReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement/saveSalePriceChgReqManagement", method = RequestMethod.POST)
	public int saveSalePriceChgReqManagement(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

		int result = salePriceChgReqManagementService.saveSalePriceChgReqManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteSalePriceChgReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/salePriceChgReqManagement/deleteSalePriceChgReqManagement", method = RequestMethod.POST)
	public int deleteSalePriceChgReqManagement(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

		int result = salePriceChgReqManagementService.deleteSalePriceChgReqManagement(request);
		return result;
	}
	
	//거래선체크
		@RequestMapping(value = "api/salePriceChgReqManagement/checkPartner", method = RequestMethod.POST)
		public SalePriceChgReqManagementModel checkPartner(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

			SalePriceChgReqManagementModel result = salePriceChgReqManagementService.checkPartner(request);
			return result;
		}
		
	//단품리스트
		@RequestMapping(value = "api/salePriceChgReqManagement/itemList", method = RequestMethod.POST)
		public List<SalePriceChgReqManagementModel> itemList(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

			List<SalePriceChgReqManagementModel> result = salePriceChgReqManagementService.itemList(request);
			return result;
		}
		
		@RequestMapping(value = "api/salePriceChgReqManagement/itemDetail", method = RequestMethod.POST)
		public SalePriceChgReqManagementModel itemDetail(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

			SalePriceChgReqManagementModel result = salePriceChgReqManagementService.itemDetail(request);
			return result;
		}
		
		@RequestMapping(value = "api/salePriceChgReqManagement/itemsCdCheck", method = RequestMethod.POST)
		public SalePriceChgReqManagementModel itemsCdCheck(@RequestBody SalePriceChgReqManagementModel request)throws Exception {
			
			SalePriceChgReqManagementModel result = salePriceChgReqManagementService.itemsCdCheck(request);
			return result;
		}
		
		@RequestMapping(value = "api/salePriceChgReqManagement/chitSearchResult", method = RequestMethod.POST)
		public SalePriceChgReqManagementModel chitSearchResult(@RequestBody SalePriceChgReqManagementModel request)throws Exception {
			
			SalePriceChgReqManagementModel result = salePriceChgReqManagementService.chitSearchResult(request);
			return result;
		}
		
		@RequestMapping(value = "api/salePriceChgReqManagement/chitSearchResultDetail", method = RequestMethod.POST)
		public List<SalePriceChgReqManagementModel> chitSearchResultDetail(@RequestBody SalePriceChgReqManagementModel request)throws Exception {

			List<SalePriceChgReqManagementModel> result = salePriceChgReqManagementService.chitSearchResultDetail(request);
			return result;
		}

}