package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data

public class NonSalesCornerByPeriodMgtParamModel extends SayEnvModel{

	private String jum;                     //점코드
	private String fromSaleDate;            //판매 시작일
	private String toSaleDate;              //판매 종료일	
	
}
