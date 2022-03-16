package com.saydept.api.spf.saleNews.weekTimeSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class WeekTimeSaleNewsModel extends SayEnvModel{
	
	private String saletime;            //시간대
	private double saleday6;			//기준일 d-7일
	private double saleday5;			//기준일 d-5일
	private double saleday4;			//기준일 d-4일
	private double saleday3;			//기준일 d-3일
	private double saleday2;			//기준일 d-2일
	private double saleday1;			//기준일 d-1일
	private double saleday;			    //기준일 
	private double saledaycustom;       //기준일 고객수
	
}