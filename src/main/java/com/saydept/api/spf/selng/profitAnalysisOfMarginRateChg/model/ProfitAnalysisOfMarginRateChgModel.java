package com.saydept.api.spf.selng.profitAnalysisOfMarginRateChg.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ProfitAnalysisOfMarginRateChgModel extends SayEnvModel{
	
	private String yyyymm;              //년월
	private double netAmount;           //순매출액(실적)
	private double profitAmount;        //이익액(실적)
	private double profitRate;          //이익율(실적)
	private double prevProfit;          //전마진이익액
	private double afterProfit;         //후마진이익액
	private double profitDiff;          //이익액 차액

}