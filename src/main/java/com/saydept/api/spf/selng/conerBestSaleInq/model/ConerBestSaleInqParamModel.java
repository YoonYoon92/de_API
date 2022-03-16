package com.saydept.api.spf.selng.conerBestSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ConerBestSaleInqParamModel extends SayEnvModel{
	
	private String startDt;			//시작일
	private String endDt;			//종료일
	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	
	private String selectDay;		//매출시작일
	private String toDay;			//매출종료일

	private String saleLimit;        //매출하한선
	private String gubun;            //총매출,순매출구분
	
	private String corNo;			//코너번호
	private String corNm;			//코너명
	private String inDate;          //입점일
	private String bestYYMM;		//기네스년월
	private double bestSale;		//기네스매출
	private double standardSale;		//기준월매출
	
}