package com.saydept.api.spf.saleNews.pcEnuriInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PcEnuriInqParamModel extends SayEnvModel{

	
	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
//	private String pc;              //세분류
//	private String coner;           //코너
	private String cls;             //클래스
	private String serchLevel;      //검색등급
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
	private String frDateLy;		//전년일자
	private String toDateLy;		//전년일자
	
	private String regiNo;		//전년일자
	private String enuriCd;		//전년일자
	
	
}
