package com.saydept.api.scd.custmer.tradingAreaPostInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TradingAreaPostInqModel extends SayEnvModel{

	private String tradingAreaCd;	//상권구분코드
	private String tradingAreaNm;	//상권구분명
	private String address;			//상권구분코드
	private String addressNm;		//상권구분명
	private String repAddress;		//상권구분코드
	private String houseNum;		//상권구분명
	private String apartDiv;		//상권구분코드
	

	

}