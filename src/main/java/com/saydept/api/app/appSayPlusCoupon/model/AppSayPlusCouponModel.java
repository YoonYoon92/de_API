package com.saydept.api.app.appSayPlusCoupon.model;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
//public class AppSayPlusCouponModel extends SayEnvModel{
public class AppSayPlusCouponModel {

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
//	private String date;                //조회일

	private String cdNo;				//회원번호
	private String cpNo;				//쿠폰번호
	private String cpFdate;				//쿠폰시작일
	private String cpTdate;				//쿠폰종료일
	private String cpGubun;				//쿠폰구분자
	private String cpName;				//쿠폰명
	private String cpType;				//쿠폰할인구분
	private String cpDcPer;				//쿠폰할인율
	private String cpDcWon;				//쿠폰할인액
	private String cpTno;				//쿠폰전체수량
	private String cpUno;				//쿠폰사용수량
	private String cpJno;				//쿠폰잔여수량
	private String cpResult;			//쿠폰결과
		
	/*실적*/
//	private String clsNm;               //클래스명
//	private double thisYySplan;			//당년계획
//	private double thisYyNetsale;		//당년매출
//	private double thisYyAchivmentrate;	//당년달성율
//	private double lastYySplan;			//전년계획
//	private double lastYyNetsale;		//전년매출
//	private double lastYyAchivmentrate;	//전년달성율

}
