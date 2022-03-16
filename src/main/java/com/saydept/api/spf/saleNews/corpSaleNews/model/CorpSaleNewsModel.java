package com.saydept.api.spf.saleNews.corpSaleNews.model;

import lombok.Data;

@Data
public class CorpSaleNewsModel {

	private String dbType;
	private String jum;					//점
	private String jumNm;				//점명
	private String buCode;              //그리드 출력용 부
	private String buName;              //그리드 출력용 부명	
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
	private String space;

	/*일*/	
	private double dayCompRate;         //구성비
	private double dayTry;              //목표
	private double daySplan;            //실적
	private double dayAchivmentrate;    //달성율
	private double dayLastyearSplan;    //전년실적
	private double dayIncrsrate;        //신장율
	private double dayDnfnt;            //차액
	private double dayDnfnt2;           //전년대비차액
	private double dayProgresrate;      //진도율
	private double dayDiscount;         //할인액
	private double dayNetsale;          //순매출
	private double daySale;		        //총매출	
	private double dayProfit;           //이익액
	private double dayRprofit;          //이익율
	

	/*월*/
	private double mmCompRate;			//구성비
	private double mmTry;               //목표
	private double mmTryMax;            //목표 말일까지 (진도율 목표)
	private double mmSplan;             //실적
	private double mmAchivmentrate;     //달성율
	private double mmLastyearSplan;     //전년실적
	private double mmIncrsrate;         //신장율
	private double mmDnfnt;             //차액
	private double mmDnfnt2;            //전년대비차액
	private double mmDnfntMax;          //진도율목표대비차액
	private double mmProgresrate;       //진도율
	private double mmDiscount;          //할인액
	private double mmNetsale;           //순매출
	private double mmSale;		        //총매출	
	private double mmProfit;            //이익액
	private double mmRprofit;           //이익율

	/*년*/
	private double yyCompRate;     		//구성비
	private double yyTry;               //목표
	private double yyTryMax;            //목표 말일까지 (진도율 목표)
	private double yySplan;             //실적
	private double yyAchivmentrate;     //달성율
	private double yyLastyearSplan;     //전년실적
	private double yyIncrsrate;         //신장율
	private double yyDnfnt;             //차액
	private double yyDnfnt2;            //전년대비차액
	private double yyDnfntMax;          //진도율목표대비차액
	private double yyProgresrate;       //진도율
	private double yyDiscount;          //할인액
	private double yyNetsale;           //순매출
	private double yySale;		        //총매출	
	private double yyProfit;            //이익액
	private double yyRprofit;           //이익율

}
