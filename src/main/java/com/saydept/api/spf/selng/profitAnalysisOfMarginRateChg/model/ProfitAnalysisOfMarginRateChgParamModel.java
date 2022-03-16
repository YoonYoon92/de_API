package com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ProfitAnalysisOfMarginRateChgParamModel extends SayEnvModel{

	private String jum;                 //점
	private String classCd;             //클래스번호(7byte)
	
	private String startYM;             //시작년월
	private String endYM;               //종료년월
	
	private double prevMarginRate;      //전마진율
	private double afterMarginRate;     //후마진율

}