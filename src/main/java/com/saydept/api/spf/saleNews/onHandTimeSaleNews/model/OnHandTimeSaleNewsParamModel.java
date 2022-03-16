package com.saydept.api.spf.saleNews.onHandTimeSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class OnHandTimeSaleNewsParamModel extends SayEnvModel{
	
	private String jum;			       //점
	private String bu;                 //부
	private String tim;                //팀
	                               
	private String startDate;          //시작일자
	
}