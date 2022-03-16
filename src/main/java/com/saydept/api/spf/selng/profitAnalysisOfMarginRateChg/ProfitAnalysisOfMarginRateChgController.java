package com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model.ProfitAnalysisOfMarginRateChgModel;
import com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model.ProfitAnalysisOfMarginRateChgParamModel;

@CrossOrigin(origins = "*")
@RestController
public class ProfitAnalysisOfMarginRateChgController {

	@Autowired
	private ProfitAnalysisOfMarginRateChgService ProfitAnalysisOfMarginRateChgService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/spf/selng/selectProfitAnalysisOfMarginRateChgInq", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/spf/selng/selectProfitAnalysisOfMarginRateChgList", method = RequestMethod.POST)
	public List<ProfitAnalysisOfMarginRateChgModel> selectProfitAnalysisOfMarginRateChgList(@RequestBody ProfitAnalysisOfMarginRateChgParamModel request)throws Exception {
		System.out.println(request.getJum());
		System.out.println(request.getStartYM());
		System.out.println(request.getEndYM());
		System.out.println(request.getClassCd());
		System.out.println(request.getPrevMarginRate());
		System.out.println(request.getAfterMarginRate());
		List<ProfitAnalysisOfMarginRateChgModel> result = ProfitAnalysisOfMarginRateChgService.selectProfitAnalysisOfMarginRateChgList(request);
	
		return result;
	}

}