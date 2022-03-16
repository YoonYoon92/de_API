package com.saydept.api.app.appSayPlusSale.model;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
//public class AppSayPlusSaleModel extends SayEnvModel{
public class AppSayPlusSaleModel {

	private String jum;					//점
//	private String jumNm;				//점명
//	private String bu;                  //부
//	private String buNm;                //부명
//	private String tim;                 //팀
//	private String timNm;               //팀명
//	private String pc;                  //세분류
//	private String pcNm;                //세분류명
//	private String coner;               //코너
//	private String conerNm;             //코너명
//	private String cls;                 //클래스
//	private String clsNm;               //클래스명
//	private String mDate;                //조회일
	private String cdNo;				//회원번호
	private String saleDate;			//매출일자
	private String slpNo;				//영수증번호
//	private String clsNo;				//클래스번호
	private String clsNm;				//클래스명
	private String uptCd;				//반품체크
	private double totAmt; 				//총매출
	private double halAmt;				//할인
	private double saleAmt;				//순매출
	private double salePoint;			//포인트적립
	private String saleTime;			//매출시간
	
	/*실적*/
//	private String clsNm;               //클래스명
//	private double thisYySplan;			//당년계획
//	private double thisYyNetsale;		//당년매출
//	private double thisYyAchivmentrate;	//당년달성율
//	private double lastYySplan;			//전년계획
//	private double lastYyNetsale;		//전년매출
//	private double lastYyAchivmentrate;	//전년달성율

}
