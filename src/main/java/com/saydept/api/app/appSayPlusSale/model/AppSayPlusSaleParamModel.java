package com.saydept.api.app.appSayPlusSale.model;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
//public class AppSayPlusSaleParamModel extends SayEnvModel{
public class AppSayPlusSaleParamModel {

	private String jum;				//점
//	private String bu;              //부
//	private String tim;             //팀
//	private String pc;              //세분류
//	private String coner;           //코너
//	private String cls;             //클래스
//	private String serchLevel;      //검색등급
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
//	private String frDateLy;		//전년일자
//	private String toDateLy;		//전년일자
	private String onlineChk;       //입력값
}
