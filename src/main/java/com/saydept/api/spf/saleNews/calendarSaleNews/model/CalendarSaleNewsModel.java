package com.saydept.api.spf.saleNews.calendarSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data

public class CalendarSaleNewsModel extends SayEnvModel{

	private String saleDate;               //판매일자
	private int    day;                    //일자
	private int    dayNum;                 //요일
	private String weather;                //날씨
	private String weatherIcon;            //날씨아이콘	
	private double saleAmount;             //실적
	private double dayGoal;                //목표
	private double achievementRate;	       //달성율
	//-----------------------------------------------------//
	private final String dateAndWeatherTitle = "일자(날씨)";    //날짜/날씨 title
	private final String saleAmountTitle = "실적(천)";        //실적 title
	private final String dayGoalTitle = "목표(천)";           //목표 title
	private final String achievementRateTitle = "달성율(%)";   //달성율 title
	
//	private String dateAndWeatherTitle;    //날짜/날씨 title
//	private String saleAmountTitle;        //실적 title
//	private String dayGoalTitle;           //목표 title
//	private String achievementRateTitle;   //달성율 title

}