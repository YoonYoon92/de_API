package com.saydept.api.spf.puchas.buyReqManagement;

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
import com.saydept.api.spf.puchas.buyReqManagement.model.BuyReqManagementParamModel;

@CrossOrigin(origins = "*")
@RestController
public class BuyReqManagementController {

	@Autowired
	private BuyReqManagementService buyReqManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/buyReqManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectBuyReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqManagement/selectBuyReqManagement", method = RequestMethod.POST)
	public BuyReqManagementModel selectBuyReqManagement(@RequestBody BuyReqManagementModel request)throws Exception {

		BuyReqManagementModel result = buyReqManagementService.selectBuyReqManagement(request);
		return result;
	}
	
	@RequestMapping(value = "api/buyReqManagement/itemDetail", method = RequestMethod.POST)
	public BuyReqManagementModel itemDetail(@RequestBody BuyReqManagementModel request)throws Exception {

		BuyReqManagementModel result = buyReqManagementService.itemDetail(request);
		return result;
	}
	
	//전표찾기
	@RequestMapping(value = "api/buyReqManagement/chitSearchResult", method = RequestMethod.POST)
	public BuyReqManagementModel chitSearchResult(@RequestBody BuyReqManagementModel request)throws Exception {

		BuyReqManagementModel result = buyReqManagementService.chitSearchResult(request);
		return result;
	}
	@RequestMapping(value = "api/buyReqManagement/chitSearchResultDetail", method = RequestMethod.POST)
	public List<BuyReqManagementModel> chitSearchResultDetail(@RequestBody BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementService.chitSearchResultDetail(request);
		return result;
	}
	
	@RequestMapping(value = "api/buyReqManagement/selectBuyReqManagementList", method = RequestMethod.POST)
	public List<BuyReqManagementModel> selectBuyReqManagementList(@RequestBody BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementService.selectBuyReqManagementList(request);
		return result;
	}

	//전표년도
	@RequestMapping(value = "api/buyReqManagement/chitYearList", method = RequestMethod.POST)
	public List<BuyReqManagementModel> chitYearList(@RequestBody BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementService.chitYearList(request);
		return result;
	}
	//거래선체크
	@RequestMapping(value = "api/buyReqManagement/checkPartner", method = RequestMethod.POST)
	public BuyReqManagementModel checkPartner(@RequestBody BuyReqManagementModel request)throws Exception {

		BuyReqManagementModel result = buyReqManagementService.checkPartner(request);
		return result;
	}
	
	//단품리스트
	@RequestMapping(value = "api/buyReqManagement/itemList", method = RequestMethod.POST)
	public List<BuyReqManagementModel> itemList(@RequestBody BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementService.itemList(request);
		return result;
	}
	
	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateBuyReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqManagement/updateBuyReqManagement", method = RequestMethod.POST)
	public int updateBuyReqManagement(@RequestBody List<BuyReqManagementModel> request)throws Exception {

		int result = buyReqManagementService.updateBuyReqManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertBuyReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqManagement/itemsCdCheck", method = RequestMethod.POST)
	public BuyReqManagementModel itemsCdCheck(@RequestBody BuyReqManagementModel request)throws Exception {
		
		BuyReqManagementModel result = buyReqManagementService.itemsCdCheck(request);
		return result;
	}
	
	@RequestMapping(value = "api/buyReqManagement/insertBuyReqManagement2", method = RequestMethod.POST)
	public int insertBuyReqManagement2(@RequestBody List<BuyReqManagementModel> request)throws Exception {
		int result = buyReqManagementService.insertBuyReqManagement2(request);
		return result;
	}
	
	

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveBuyReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqManagement/saveBuyReqManagement", method = RequestMethod.POST)
	public int saveBuyReqManagement(@RequestBody BuyReqManagementModel request)throws Exception {

		int result = buyReqManagementService.saveBuyReqManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteBuyReqManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/buyReqManagement/deleteBuyReqManagement", method = RequestMethod.POST)
	public int deleteBuyReqManagement(@RequestBody BuyReqManagementModel request)throws Exception {

		int result = buyReqManagementService.deleteBuyReqManagement(request);
		return result;
	}

}