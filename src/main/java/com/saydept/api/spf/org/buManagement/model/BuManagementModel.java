package com.saydept.api.spf.org.buManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class BuManagementModel  extends SayEnvModel{

	private String sendDt;
	private String jum;
	private String bu;
	private String buCom;
	private String buNm;
	private String tim;
	private String timNm;
	private String pc;
	private String pcNm;
	private String cls1;
	private String cls2;
	private String cls;	
	private String clsNm;
	private String eventStartDt;
	private String eventEndDt;
	private String proc;
	private String disol;

}