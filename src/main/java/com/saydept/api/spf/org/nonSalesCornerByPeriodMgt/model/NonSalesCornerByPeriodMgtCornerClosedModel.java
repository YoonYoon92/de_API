package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data

public class NonSalesCornerByPeriodMgtCornerClosedModel extends SayEnvModel{

	private String jum;                     //점코드
	private String cornerNo;                //폐기 코너번호
	private String cornerClosedDate;        //폐기 일자	
	private String updateDate;              //수정 일자
	
}
