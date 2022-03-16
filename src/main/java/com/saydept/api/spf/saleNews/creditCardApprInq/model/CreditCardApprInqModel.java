package com.saydept.api.spf.saleNews.creditCardApprInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CreditCardApprInqModel extends SayEnvModel{

	
	private String regiNo; 				//점
	private String regiNm; 				//점명
	private String appTime;             //부
	private String appJp;             //부명
	private String appRcpt;             //팀
	private String appNo;               //팀명
	private String halBu;               //세분류
	private String rcvNo;               //세분류명
	private double appAmt;              //코너
	private String vanCo;               //코너명
	private String guBun;               //클래스
	private String s40Memo;             //클래스명
	private String vanMemo;
	/*실적*/
//	private String clsNm;               //클래스명
//	private String smm;                 //조회일
//	private double thisYySplan;			//당년계획
//	private double thisYyNetsale;		//당년매출
//	private double lastYySplan;			//전년계획
//	private double lastYyNetsale;		//전년매출
//	private double achivmentrate;		//당년달성율
//	private double incrsrate;			//당년신장율

}
