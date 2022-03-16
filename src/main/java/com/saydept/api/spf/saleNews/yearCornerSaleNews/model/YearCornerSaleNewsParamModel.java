package com.saydept.api.spf.saleNews.yearCornerSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class YearCornerSaleNewsParamModel extends SayEnvModel{

	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	private String pc;              //세분류
	private String coner;           //코너
	private String cls;             //클래스
	private String serchLevel;      //검색등급
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
	private String searchDay;		//조회일자
	private String onlineChk;		//조회일자
	
	private String mmFrDate;			//총매출 시작일
	private String mmToDate;			//총매출 종료일	
	private String m12FrDate;			//매출 시작일
	private String m12ToDate;			//매출 종료일
	private String m11FrDate;			//매출 시작일
	private String m11ToDate;			//매출 종료일
	private String m10FrDate;			//매출 시작일
	private String m10ToDate;			//매출 종료일
	private String m09FrDate;			//매출 시작일
	private String m09ToDate;			//매출 종료일
	private String m08FrDate;			//매출 시작일
	private String m08ToDate;			//매출 종료일
	private String m07FrDate;			//매출 시작일
	private String m07ToDate;			//매출 종료일
	private String m06FrDate;			//매출 시작일
	private String m06ToDate;			//매출 종료일
	private String m05FrDate;			//매출 시작일
	private String m05ToDate;			//매출 종료일
	private String m04FrDate;			//매출 시작일
	private String m04ToDate;			//매출 종료일
	private String m03FrDate;			//매출 시작일
	private String m03ToDate;			//매출 종료일
	private String m02FrDate;			//매출 시작일
	private String m02ToDate;			//매출 종료일
	private String m01FrDate;			//매출 시작일
	private String m01ToDate;			//매출 종료일
	private String m00FrDate;			//매출 시작일
	private String m00ToDate;			//매출 종료일
}