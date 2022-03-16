package com.saydept.api.spf.saleNews.largeShopSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class LargeShopSaleInqModel extends SayEnvModel{
	
	private String startDt;				//조회일
	private String mmDt;				//월1일
	private String yyDt;				//당년1월1일
	private String timNm;   			//팀명
	private String coner;   			//코너
	private String conerNm; 			//코너명
	private int ddSplan;           	    //일매출
	private int mmSplan;         	    //월매출
	private int yySplan;  	 			//년매출	
	private int ddTry;           	    //일목표
	private int mmTry;         	    	//월목표
	private int yyTry;  	 			//년목표
	private double ddAchivmentrate; 	//일달성율
	private double mmAchivmentrate;    	//월달성율
	private double yyAchivmentrate;     //년달성율


}