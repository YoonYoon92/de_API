package com.saydept.api.dashboard.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class AchivModel extends SayEnvModel{

	private String saleDate;      		//영업일
	private String jum;              	//점코드
	private double dayAchivRate;   		//당일 달성율
	private double monthAchivRate;   	//당월 달성율
	private double yearAchivRate;   	//당년 달성율

	private long   dayNetSale;			//당일 매출액
	private long   monthNetSale;		//당월 매출액
	private long   yearNetSale;			//당년 매출액
	private long   dayOnlineNetSale; 	//온라인 매출액 당일
	private long   monthOnlineNetSale; 	//온라인 매출액 당월
	private long   yearOnlineNetSale; 	//온라인 매출액 당년

	private long   dayNetTry;			//당일 목표
	private long   monthNetTry;			//당월 목표
	private long   yearNetTry;			//당년 목표
}
