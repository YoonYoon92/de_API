package com.saydept.api.spf.salePrice.salePriceChgReqManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SalePriceChgReqManagementModel extends SayEnvModel{

	private String 	id;
	private String 	name;
	private String	chitYear;
	private int chitNum;
	private String   saleChangeDt;
	private String   deleteDt;
	private String   saleChangeCd;
	private String   saleChangeNm;
	private String   payDt;
	private String   jum;			 
	private String   bu;            
	private String   tim;           
	private String   pc;           
	private String   cls;           
	private String   clsNm;         
	private String   partner;       
	private String   partnerNm;        
	private String   partnerStatus;     //거래선상태
	private String 	 featureCd;			//특정코드
	private String 	 taxDiv;			//특정코드
	private String 	 userId;			//특정코드
	

	
	
	private String	itemCd;   		//단품코드
	private String	itemNm;   		//단품코드
	private String  itemsCd;    	//품목코드
	private String  itemsNm;    	//품목코드
	private double 	cost;    		//원가
	private double	price;    		//매가
	private int 	totCost;   		//원가
	private int		totPrice;  		//매가
	private int   	diffPrice;    	//차액
	private int   	diffRate;    	//차익율
	private int   	num;    		//수량
	private int   	unit;    		//단위
	private int   	conf;    		//확정
	private int		emptyCost;		//공병
	private double 	purchaseMargin; //매입마진
	private String  writeTime;    	//입력날
	private String  writeTime2;    	//입력시간
	
	//SPFO02PF
	private int chitCount;

}