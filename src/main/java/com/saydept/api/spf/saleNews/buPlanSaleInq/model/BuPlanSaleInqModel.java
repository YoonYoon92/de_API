package com.saydept.api.spf.saleNews.buPlanSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class BuPlanSaleInqModel extends SayEnvModel{
	private String Team;   				//팀번호
	private String Pc;   				//피씨번호
	private String PcNm; 				//피시명
	private double Try;           	    //계획
	private double Splan;         	    //실적
	private double LastyearSplan;  	 	//전년실적	
	private double Achivmentrate; 	  	//달성율
	private double Incrsrate;       	//신장율
	private double CustmerNum;       	//객수
	private double CustmerCst;       	//객단가
	
	

}