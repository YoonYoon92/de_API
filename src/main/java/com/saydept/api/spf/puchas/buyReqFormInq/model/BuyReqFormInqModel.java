package com.saydept.api.spf.puchas.buyReqFormInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class BuyReqFormInqModel extends SayEnvModel{

	private String startDt;
	private String endDt;
	private String jum;
	private String bu;
	private String tim;
	private String juDt;		//전표작성일
	private String chit;		//전표
	private String chitNum;		//전표번호
	private String partner;		//클래스
	private String partnerNm;	//클래스명
	private String cls;			//클래스
	private String clsNm;		//클래스명명
	private int cost;			//원가
	private int price;			//매가
	private int sumCost;		//원가
	private int sumPrice;		//매가
	private int diffPrice;		//차액	
	private int diffRate;		//차익율
	private int itemNum;		//수량
	private String conf;		//확정

}