package com.saydept.api.spf.saleNews.dayBestSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DayBestSaleInqModel extends SayEnvModel{

	private String jum;					//점
	private String jumNm;				//점명
	private String bu;                  //부
	private String buNm;                //부명
	private String tim;                 //팀
	private String timNm;               //팀명
	private double rank;				//순위
	private String saleDate;            //매출일
	private double saleTry;             //매출목표
	private double netSale;             //순매출
	private double achivmentrate;       //달성률
	private	String remark;              //비고
	private double todayNetSale;        //금일실적
	private double todayRank;           //금일순위 
}