package com.saydept.api.spf.salePrice.salePriceChgReqFormInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SalePriceChgReqFormInqModel extends SayEnvModel{
	
	
	private String startDt;
	private String endDt;
	private String jum;
	private String bu;
	private String tim;
	private String juDt;    //전표작성일
	private String chit;	//전표
	private String chitNum;	//전표번호
	private String cls;		//클래스
	private String clsNm;	//클래스명
	private String item;	//품목
	private String itemNm;	//품목명
	private int newSale;	//신매가
	private int oldSale;	//구매가
	private int sumNewSale;	//신매가
	private int sumOldSale;	//구매가
	private int diffSale;	//차액	
	private int itemNum;	//수량
	private String conf;	//확정
		
}