package com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ConerMmAvrageSaleInqParamModel extends SayEnvModel{
	
	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	private String serchLevel;      //검색등급
	private String frDate;          //당년시작검색일자
	private String toDate;          //당년종료검색일자

	
	private String frDateLastY;     //전년시작검색일자
	private String toDateLastY;     //전년종료검색일자


	private long   mmCount;         //월카운트 (월별 평균을 구하기 위해)
}
