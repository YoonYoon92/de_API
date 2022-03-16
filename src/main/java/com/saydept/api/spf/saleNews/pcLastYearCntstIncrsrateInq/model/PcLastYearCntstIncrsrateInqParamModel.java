package com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PcLastYearCntstIncrsrateInqParamModel extends SayEnvModel{

	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	private String coner;           //코너
	private String Subordconer;     //종속코너
	private String conerNm;         //코너명
	private String cls;             //클래스
	private String zoneCd;             //존
	private String zoneNm;             //존명
	private String serchLevel;      //검색등급
	private String startDt;         //시작검색일자
	private String endDt;           //종료검색일자
	private String searchDay;		//조회일자
	private String LastyearstartDt;          //시작검색일자
	private String LastyearendDt;          //종료검색일자
	private String onlinechk;				//온라인체크
	private String achivmentrateCheck;			//달성율체크
}