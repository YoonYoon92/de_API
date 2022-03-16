package com.saydept.api.spf.selng.trdetailInfoInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TrdetailInfoInqModel extends SayEnvModel{

	private String startDt;
	private String saleDiv;
	private String payDiv1;
	private String payDiv2;
	private String payDiv3;
	private String payDiv4;
	private String payDiv5;
	private int payAmt1;
	private int payAmt2;
	private int payAmt3;
	private int payAmt4;
	private int payAmt5;
	private String data1;
	private String data2;
	private String data3;
	private String data4;
	private String data5;
	private String data6;
	private String data7;
	private String data8;
	private String data9;
	private String data;
	
	private String cardNum1;	//카드번호
	private String appNum1;		//승인번호
	private String chitNum1; 	//전표
	private String van1; 		//van
	
	private String cardNum2;	//카드번호
	private String appNum2;		//승인번호
	private String chitNum2; 	//전표
	private String van2; 		//van
	
	private String cardNum3;	//카드번호
	private String appNum3;		//승인번호
	private String chitNum3; 	//전표
	private String van3; 		//van
	
	private String cardNum4;	//카드번호
	private String appNum4;		//승인번호
	private String chitNum4; 	//전표
	private String van4; 		//van

	private String cardNum5;	//카드번호
	private String appNum5;		//승인번호
	private String chitNum5; 	//전표
	private String van5; 		//van
	
	
	
}