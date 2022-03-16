package com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PcLastYearCntstIncrsrateInqModel extends SayEnvModel{
	
	
	private int    Seq;					//순번
	private String coner;               //코너
	private String conerNm;             //코너명
	private double LastyearTry;   	    //전년목표
	private double Try;           	    //목표
	private double Splan;         	    //실적
	private double LastyearSplan;  	 	//전년실적
	private int    LastyearCo;			//작년건수
	private int    Co;					//건수
	private double Dcnt;         	    //할인
	private double LastyearDcnt;  	 	//전년할인
	private double LastyearAchivmentrate; //전년달성율
	private double Achivmentrate; 	  	//달성율
	private double Incrsrate;       	//신장율
	private String StringIncrsrate;     //신장율

}