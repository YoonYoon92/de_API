package com.saydept.api.spf.saleNews.pcEnuriInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PcEnuriInqModel extends SayEnvModel{

	private String jum;					//점
	private String jumNm;				//점명
	private String bu;                  //부
	private String buNm;                //부명
	private String tim;                 //팀
	private String timNm;               //팀명
	private String pc;                  //세분류
	private String pcNm;                //세분류명
	private String coner;               //코너
	private String conerNm;             //코너명
	private String cls;                 //클래스
	private String clsNm;               //클래스명
	private String date;                //조회일
	private String maeDate;                //매출일
	private String regiNo;                //레지
	private String regiNm;                //레지
	private String rcptNo;                //영수
	private String appNo;                //승인
	private String tcdNo;                //카드
	private String pointNo;                //포인트
	private String enuriCd;                //사유
	private String clsNo;                //코너
	private String cpNm;                //쿠폰

	/*실적*/
//	private String clsNm;               //클래스명
	private double saleAmt;			//매출금
	private double enuriAmt;		//에누리
	private double enuriRate;			//할인율

}
