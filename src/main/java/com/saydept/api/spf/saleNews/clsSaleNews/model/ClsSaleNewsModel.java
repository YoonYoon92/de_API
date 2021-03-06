package com.saydept.api.spf.saleNews.clsSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ClsSaleNewsModel extends SayEnvModel{

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
	private String date;                //날짜

	/*실적*/
	private double ddTotsale;			//총매출
	private double ddDsicount;			//에누리
	private double ddNetsale;			//순매출
	private double mmNetsale;			//월실적
	private double yyNetsale;			//연실적
	private double daySplan;            //실적
	private double dayTotsale;          //총매출
	private double dayDsicount;         //할인액
	private double dayNetsale;          //순매출

}
