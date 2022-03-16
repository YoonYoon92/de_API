package com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ClsPlnNetSaleSltModel extends SayEnvModel{

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
//	private String clsNm;               //클래스명
	private double thisYySplan;			//당년계획
	private double thisYyNetsale;		//당년매출
	private double thisYyAchivmentrate;	//당년달성율
	private double lastYySplan;			//전년계획
	private double lastYyNetsale;		//전년매출
	private double lastYyAchivmentrate;	//전년달성율

}
