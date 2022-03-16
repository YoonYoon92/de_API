package com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model.ProfitAnalysisOfMarginRateChgModel;
import com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model.ProfitAnalysisOfMarginRateChgParamModel;

@Mapper
public interface ProfitAnalysisOfMarginRateChgMapper {


	List<ProfitAnalysisOfMarginRateChgModel> selectProfitAnalysisOfMarginRateChgList(ProfitAnalysisOfMarginRateChgParamModel request);

}