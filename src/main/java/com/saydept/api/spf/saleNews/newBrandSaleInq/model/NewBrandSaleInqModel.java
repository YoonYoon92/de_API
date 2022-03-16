package com.saydept.api.spf.saleNews.newBrandSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class NewBrandSaleInqModel extends SayEnvModel{

	private String cornerNo;            //코너번호
	private String cornerName;          //코너명
	private String jumNo;               //점번호
	private String buNo;                //부번호
	private String teamNo;              //팀번호 
	private String pcNo;                //세분류번호          
	private String jumName;             //점명
	private String buName;              //부명
	private String teamName;            //팀명
	private String pcName;              //세분류명
	private String dateOfEntry;         //입점일
	private String salesDays;           //영업일수
	private String cornerType;          //코너형태( 1(대형), 2(전략), 공백(일반) )
	private String dateOfSaleAnalysis;  //매출분석시작일
	private double salesToDayamt;       //당일매출
	private double salesTermAmt;        //기간매출
	private double saleTermAmt;         //기간할인
	private double customCount;         //기간고객수
	private double goalOfCorner;        //기간 목표
	private double dayAverage;          //일평균매출액
	private double achievementRate;	    //달성율

}