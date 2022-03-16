package com.saydept.api.spf.selng.receiptInfoInq.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data

public class ReceiptInfoInqModel extends SayEnvModel{

	private String startDt;
	private String jum;
	private String posNum;
	private String receiptNum;
	
	private String pointNum;
	private String totPoint;
	private String afterChk;
	
	private String payMethod;
	private String payCardNum;
	private String payAppNum;
	private String pos;          
	private String receipt;       
	private String serialNum;     
	private String cashier;       
	private String saleDiv;       
	
	private String stsDiv;
	private String chit;
	private String payDiv;
	private String payPrice;
	private String cardNo;
	private String appNo;
	private String van;

	
	private String payDiv1;       
	private String payPrice1;     
	private String payDiv2;       
	private String payPrice2;     
	private String payDiv3;       
	private String payPrice3;     
	private String payDiv4;       
	private String payPrice4;     
	private String payDiv5;       
	private String payPrice5;     
	private String disCount;      
	private String cardNo1;     
	private String cardNo2;     
	private String cardNo3;     
	private String cardNo4;     
	private String cardNo5;     
	private String chit1;     
	private String chit2;     
	private String chit3;     
	private String chit4;
	private String chit5;
	private String appNo1;     
	private String appNo2;     
	private String appNo3;     
	private String appNo4;
	private String appNo5;
	private String item1;     
	private String item2;     
	private String item3;     
	private String item4;
	private String item5;
	private String data;
	private String data1;         
	private String data2;         
	private String data3;         
	private String data4;         
	private String data5;         
	private String data6;         
	private String data7;         
	private String data8;         
	private String data9;
	
	private String cls;
	private String clsNm;
	
	private String couponCd;
	private String couponNm;
	private double couponDiscount;

	private String cashNum;
	private String cashApp;
	
	private String giftNum;
	private String giftNm;
	private String eventCd;
	private String eventNm;
	private int eventGift;
	private String eventGiftNm;
	private int eventAcceptAmount;
	
	private int num;
	private int price;
	private int totPrice;
	private int itemDiscount;
	private int netsales;
	
	         
	

}