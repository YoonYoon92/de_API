package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data

public class NonSalesCornerByPeriodMgtClassClosedModel extends SayEnvModel{

	private String jumNo;                     //점코드
	private String class1;                    //클래스 1 (5byte)
	private String class2;                    //클래스 2 (2byte)
	private String className;                 //클래스명  (24byte)
	private String buNo;                      //부번호
	private String teamNo;                    //팀번호
	private String pcNo;                      //부번호
	private String classClosedDate;           //폐기 일자	
	
}
