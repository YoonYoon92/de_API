package com.saydept.api.spf.selng.cornerMarginChgSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CornerMarginChgSalesInqModel extends SayEnvModel{
	
	private String cls2;                //클래스키 2byte
	private String minDay;              //시작일
	private String maxDay;              //종료일
	private double netAmount;           //순매출액(실적)
	private double saleAmount;          //할인액(실적)
	private double totalAmount;         //총매출액(실적)
	private double feeAmount;           //수수료(실적)
	private double marginRate;          //적용 마진율
	private String marginFrDate;        //마진적용 시작일
	private String marginToDate;        //마진적용 종료일

}