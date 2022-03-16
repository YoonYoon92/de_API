package com.saydept.api.spf.org.jumManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class JumManagementModel  extends SayEnvModel{

	private String sendDt;
	private String jum;
	private String jumNm;
	private String jumCom;
	private String bu;
	private String tim;
	private String pc;
	private String cls1;
	private String cls2;
	private String cls;	
	private String clsNm;
	private String eventStartDt;
	private String eventEndDt;
	private String proc;
	private String disol;

}