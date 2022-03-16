package com.saydept.api.scd.custmer.tradingAreaMemberInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TradingAreaMemberInqModel extends SayEnvModel{

	private String searchDt;
	private String searchCd;
	private String tradingAreaCd;
	private String tradingAreaNm;	
	private String areaCd;
	private String areaNm;	
	private int cdMember;
	private int plusMember;
	private int useMember;
	private int memberAmt;
	private double cdRate;
	private double plusRate;
	private double useRate;
	private double memberAmtRate;
	private int memberPrice;
	
	

}