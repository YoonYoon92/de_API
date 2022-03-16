package com.saydept.api.spf.org.conerHistoryInq.model;

import lombok.Data;

@Data
public class ConerHistoryInqParamModel {
	
	private String dbType;
	
	private String startDt;         //시작검색일자
	private String endDt;          	//종료검색일자

	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀

	private String storeLvCd;       //조직코드
	private String storeLvNm;       //조직명
	private String paramLvCd;		//조직검색코드

	
}