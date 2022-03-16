package com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model.ProfitAnalysisOfMarginRateChgModel;
import com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model.ProfitAnalysisOfMarginRateChgParamModel;

	@Service
	public class ProfitAnalysisOfMarginRateChgService {

	@Autowired
	private ProfitAnalysisOfMarginRateChgMapper ProfitAnalysisOfMarginRateChgMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ProfitAnalysisOfMarginRateChgModel> selectProfitAnalysisOfMarginRateChgList(ProfitAnalysisOfMarginRateChgParamModel request)throws Exception {

		List<ProfitAnalysisOfMarginRateChgModel> result = ProfitAnalysisOfMarginRateChgMapper.selectProfitAnalysisOfMarginRateChgList(request);
		return result;

	}


}