package com.saydept.api.spf.saleNews.onHandTimeSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class OnHandTimeSaleNewsTotalModel extends SayEnvModel{

	private double dayGoal;     
	private double daySaleAmount;      
	private double achievementRate;   

}