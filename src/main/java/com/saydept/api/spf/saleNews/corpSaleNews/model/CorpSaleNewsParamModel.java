package com.saydept.api.spf.saleNews.corpSaleNews.model;

import lombok.Data;

@Data
public class CorpSaleNewsParamModel {

	private String dbType;
	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	private String pc;              //세분류
	private String gubun;           //조회구분
	private String coner;           //코너
	private String cls;             //클래스
	private String serchLevel;      //검색등급
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
	private String searchDay;		//조회일자 당일
	private String beforeDay;		//조회일자 전일
	private String beforeYear;		//조회일자 전년당일

}
