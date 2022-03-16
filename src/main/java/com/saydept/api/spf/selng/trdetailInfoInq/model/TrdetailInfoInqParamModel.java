package com.saydept.api.spf.selng.trdetailInfoInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TrdetailInfoInqParamModel extends SayEnvModel{

	private String startDt;
	private String posNum;
	private int receipt;
	private String saleDiv;
	
	private String data1;
	private String data2;
	private String data3;
	private String data4;
	private String data5;
	private String data6;
	private String data7;
	private String data8;
	private String data9;
	
	private String cardNum;	//카드번호
	private String appNum;	//승인번호
	private String chitNum; //전표
	private String van; //전표
	
}