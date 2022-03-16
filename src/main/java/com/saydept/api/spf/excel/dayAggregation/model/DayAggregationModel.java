package com.saydept.api.spf.excel.dayAggregation.model;

import lombok.Data;

@Data
public class DayAggregationModel {
	
	
	//-----------------------pc별 매출---------------------------
	private String pc;
	private String pcNm;
	private String team;
	private String teamNm;
	private String zoning;
	private String zoningNm;
	private String coner;
	private String conerNm;
	//목표
	private int pcDayTry;	//일
	private int pcMonthTry;	//월
	private int pcYearTry;	//년
	private int pcMonthTotalTry;	//월전체
	//전년목표
	private int pcMonthLastyearTry;	//월
	//올해매출
	private int pcDaySplan;		//일
	private int pcMonthSplan;	//월
	private int pcYearSplan;	//년
	//전년매출
	private int pcDayLastyearSplan;		//일
	private int pcMonthLastyearSplan;	//월
	private int pcYearLastyearSplan;	//년
	//달성율
	private double pcDayAchivmentrate;		//일
	private double pcMonthAchivmentrate;	//월
	private double pcYearAchivmentrate;		//년
	//신장율
	private double pcDayIncrsrate;		//일
	private double pcMonthIncrsrate;	//월
	private double pcYearIncrsrate;		//년
	//차액
	private int pcDayDiff;		//일
	private int pcMonthDiff;	//월
	private int pcYearDiff;		//년
	//진도율
	private double pcDayProgressRate;		//일
	private double pcMonthProgressRate;	//월
	private double pcYearProgressRate;		//년
	
	
	
	private String dt; //일자
	private String week; //요일
	

}