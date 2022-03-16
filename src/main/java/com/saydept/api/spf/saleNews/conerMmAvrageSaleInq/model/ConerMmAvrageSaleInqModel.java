package com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ConerMmAvrageSaleInqModel extends SayEnvModel{


	private String corno;               	//코너번호
	private String cornm;               	//코너명
	private double netSale;             	//당년순매출
	private double avg;						//당년평균
	private double netSaleLastY;            //전년순매출
	private double avgLastY;				//전년평균
	private double incrsrate;				//신장율
	private	String inDate;					//입점일
	private String outDate;                 //퇴점일


}