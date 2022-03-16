package com.saydept.api.spf.saleNews.eventHallSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class EventHallSaleInqModel extends SayEnvModel{

	private String Nm;   		 		//이름
	private int	Try;					//목표
	private int	sumTry;					//누계목표
	private int sale;					//매출
	private int sumSale;				//누계매출
	private int discount;				//할인
	private int sumDiscount;			//누계할인
	private int custmernum;				//고객수
	private int sumCustmernum;			//누계고객수
	private int custmercst;				//고객단가
	private int sumCustmercst;			//누계고객단가
	private double Achivmentrate;		//달성율
	private double sumAchivmentrate;	//누계달성율
	

}