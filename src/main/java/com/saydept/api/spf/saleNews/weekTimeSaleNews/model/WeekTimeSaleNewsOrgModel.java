package com.saydept.api.spf.saleNews.weekTimeSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class WeekTimeSaleNewsOrgModel extends SayEnvModel{
	
	private String orgcd;                    //시간대
	private String jumnm;            		//기준일 d-7일
	private String bunm;             		//기준일 d-5일
	private String teamnm;            		//기준일 d-4일
	private double timezone11pre;     		//기준일 d-3일
	private double timezone13pre;    		//기준일 d-2일
	private double timezone14pre;     		//기준일 d-1일
	private double timezone15pre;     	    //기준일 
	private double timezone16pre;            //기준일 고객수
	private double timezone17pre;     
	private double timezone18pre;     
	private double timezone19pre;     
	private double timezone20pre;     
	private double timezone21pre;     
	private double timezone24pre;     
	private double daysaleamount;     
	private double daygoal;           
	private double daydifference;     
	private double dayachievementrate;
	private double customercnt;       
    private double olddaysaleamount;  
    private double strechrat;   
}  