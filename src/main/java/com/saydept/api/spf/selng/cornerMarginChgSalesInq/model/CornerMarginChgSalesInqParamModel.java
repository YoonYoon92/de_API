package com.saydept.api.spf.selng.cornerMarginChgSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CornerMarginChgSalesInqParamModel extends SayEnvModel{

	private String jum;                 //점
	private String conerCd;             //코너번호
	
	private String yyyymm;              //조회년월

}