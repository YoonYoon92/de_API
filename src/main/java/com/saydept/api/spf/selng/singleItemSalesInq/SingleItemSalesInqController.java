package com.saydept.api.spf.selng.singleItemSalesInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.selng.singleItemSalesInq.model.SingleItemSalesInqModel;
import com.saydept.api.spf.selng.singleItemSalesInq.model.SingleItemSalesInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class SingleItemSalesInqController {

	@Autowired
	private SingleItemSalesInqService SingleItemSalesInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/spf/selng/selectSingleItemSalesInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalesByTypeInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectSingleItemSalesInqList", method = RequestMethod.POST)
	public List<SingleItemSalesInqModel> selectSingleItemSalesInqList(@RequestBody SingleItemSalesInqParamModel request)throws Exception {
		
		List<SingleItemSalesInqModel> result = SingleItemSalesInqService.selectSingleItemSalesInqList(request);
	
		return result;
	}

	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)SingleItemSalesInqParamModel
	 * 단품 품목코드 대분류 Code 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectStoreComboLargeCatList")
	public List<SingleItemSalesInqParamModel> selectStoreComboLargeCatList()throws Exception {
		
		List<SingleItemSalesInqParamModel> result = SingleItemSalesInqService.selectStoreComboLargeCatList();
	
		return result;
	}
	
	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectStoreComboMidiumCatList
	 * 단품 품목코드 중분류 Code 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectStoreComboMidiumCatList", method = RequestMethod.POST)
	public List<SingleItemSalesInqParamModel> selectStoreComboMidiumCatList(@RequestBody SingleItemSalesInqParamModel request)throws Exception {
		
		List<SingleItemSalesInqParamModel> result = SingleItemSalesInqService.selectStoreComboMidiumCatList(request);
	
		return result;
	}
	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectStoreComboSmallCatList
	 * 단품 품목코드 소분류 Code 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectStoreComboSmallCatList", method = RequestMethod.POST)
	public List<SingleItemSalesInqParamModel> selectStoreComboSmallCatList(@RequestBody SingleItemSalesInqParamModel request)throws Exception {
		
		List<SingleItemSalesInqParamModel> result = SingleItemSalesInqService.selectStoreComboSmallCatList(request);
	
		return result;
	}
}