package com.saydept.api.spf.saleNews.buRtnSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class BuRtnSaleNewsModel extends SayEnvModel{

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

	/*실적*/
	private double ddCnt;				//건수
	private double ddCash;				//현금
	private double ddCard;				//카드
	private double ddOther;				//기타
	private double ddNetsale;			//순매출

}
