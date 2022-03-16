package com.saydept.api.spf.selng.conerDcntListInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ConerDcntListInqModel extends SayEnvModel{

	private String jum;
	private String bu;
	private String tim;
	private String pc;
	private String coner;		//코너
	private String conerNm;		//코너명
	private String startDt;		//시작일자
	private String regi;		//레지번호
	private String receipt;		//영수증번호
	private int netSale;		//순매출
	private int dsnt;			//할인
	private String cardNo;		//카드번호
	private String cardNm;		//카드명
	private String pointNum;	//포인트카드번호
	private int dsntRate;		//할인률
	private String dsntDiv;		//할인구분
	

}