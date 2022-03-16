package com.saydept.api.spf.saleNews.buPlanSaleInq.model;


import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data

public class BuPlanSaleInqParamModel extends SayEnvModel{

	private String jum;						//점
	private String bu;            		  	//부
	private String startDt;       		 	//시작검색일자
	private String endDt;         			//종료검색일자
	private String searchDay;				//조회일자
	private String LastyearstartDt;         //시작검색일자
	private String LastyearendDt;          	//종료검색일자
}
