package com.saydept.api.spf.selng.trdetailInfoInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqModel;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqParamModel;
import com.saydept.api.spf.selng.trdetailInfoInq.model.TrdetailInfoInqModel;
import com.saydept.api.spf.selng.trdetailInfoInq.model.TrdetailInfoInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class TrdetailInfoInqController {

	@Autowired
	private TrdetailInfoInqService trdetailInfoInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/trdetailInfoInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectTrdetailInfoInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/trdetailInfoInq/selectTrdetailInfoInq", method = RequestMethod.POST)
	public TrdetailInfoInqModel selectTrdetailInfoInq(@RequestBody TrdetailInfoInqParamModel request)throws Exception {

		TrdetailInfoInqModel result = trdetailInfoInqService.selectTrdetailInfoInq(request);
		return result;
	}
	
	
	@RequestMapping(value = "api/selectTrdetailInfoInq/TEST")
	public TrdetailInfoInqModel TEST()throws Exception {
		TrdetailInfoInqParamModel result = new TrdetailInfoInqParamModel();
		result.setStartDt("20210118");
		result.setPosNum("7280");
		result.setReceipt(1);
		
		return trdetailInfoInqService.selectTrdetailInfoInq(result);
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTrdetailInfoInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/trdetailInfoInq/selectTrdetailInfoInqList", method = RequestMethod.POST)
	public List<TrdetailInfoInqParamModel> selectTrdetailInfoInqList(@RequestBody TrdetailInfoInqParamModel request)throws Exception {

		List<TrdetailInfoInqParamModel> result = trdetailInfoInqService.dataList(request);
		return result;
	}
	
	

	
	@RequestMapping(value = "api/selectTrdetailInfoInqList/TEST")
	public TrdetailInfoInqModel TEST1()throws Exception {
		TrdetailInfoInqParamModel result = new TrdetailInfoInqParamModel();
		result.setStartDt("20210118");
		result.setPosNum("7280");
		result.setReceipt(1);
		
		return trdetailInfoInqService.selectTrdetailInfoInq(result);
	}
	
	@RequestMapping(value = "api/dataList/Test")
	public List<TrdetailInfoInqParamModel> TEST2()throws Exception {
		TrdetailInfoInqParamModel result = new TrdetailInfoInqParamModel();
		result.setStartDt("20210118");
		result.setPosNum("7280");
		result.setReceipt(1);
	
		return trdetailInfoInqService.dataList(result);
	}

}