package com.saydept.api.spf.saleNews.lastYearCntstWeekSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class LastYearCntstWeekSaleNewsModel extends SayEnvModel{

	private String no1;                 //구분자
	private String division;            //시간대
	private double daygoald_6;			//기준일 d-7일
	private double daygoald_5;			//기준일 d-5일
	private double daygoald_4;			//기준일 d-4일
	private double daygoald_3;			//기준일 d-3일
	private double daygoald_2;			//기준일 d-2일
	private double daygoald_1;			//기준일 d-1일
	private double daygoald;			    //기준일 

}