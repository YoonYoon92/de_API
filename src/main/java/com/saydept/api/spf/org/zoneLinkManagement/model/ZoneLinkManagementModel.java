package com.saydept.api.spf.org.zoneLinkManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ZoneLinkManagementModel extends SayEnvModel{
	private String startDt;
	private String jum;
	private String bu;		//부
	private String tim;		//팀
	private String pc;		//세분류
	private String coner;
	private String conerNm;
	private String linkConerNm;
	private String linkConer;
	private String regiDt;
	private String delDt;	
	private String zoneCd;	//존코드	
	private String zoneNm;	//존명
	private String zone;	//존
}