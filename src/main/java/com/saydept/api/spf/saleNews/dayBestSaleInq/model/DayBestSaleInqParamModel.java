package com.saydept.api.spf.saleNews.dayBestSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DayBestSaleInqParamModel extends SayEnvModel{

	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	private String serchLevel;      //검색등급
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
	private String searchDay;		//조회일자

}
