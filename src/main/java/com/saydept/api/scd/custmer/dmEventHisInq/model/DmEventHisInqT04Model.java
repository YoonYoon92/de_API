package com.saydept.api.scd.custmer.dmEventHisInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DmEventHisInqT04Model extends SayEnvModel{

	private double ranking;              //선정순위
	private String jumin;                //주민번호
	private String memberNo;             //회원번호
	private String memberNm;             //회원명
	private double selCnt;               //선정매출건수
	private double selAmt;               //선정매출금액
		
}