package com.saydept.api.spf.saleNews.weekTimeSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class WeekTimeSaleNewsParamModel extends SayEnvModel{
	
	private String jum;			       //점
	private String bu;                 //부
	private String tim;                //팀
	                               
	private String startDate;          //시작일자
	private String d6Day;              //시작일자 d-6
	private String d5Day;              //시작일자 d-5
	private String d4Day;              //시작일자 d-4
	private String d3Day;              //시작일자 d-3
	private String d2Day;              //시작일자 d-2
	private String d1Day;              //시작일자 d-1
	
	private String oldStartDate;       //시작일자 전년동일
	private String oldD6Day;           //시작일자 d-6 전년동일
	private String oldD5Day;           //시작일자 d-5 전년동일
	private String oldD4Day;           //시작일자 d-4 전년동일
	private String oldD3Day;           //시작일자 d-3 전년동일
	private String oldD2Day;           //시작일자 d-2 전년동일
	private String oldD1Day;           //시작일자 d-1 전년동일
	
	private String selectVal;          //selectfield 값

	
}