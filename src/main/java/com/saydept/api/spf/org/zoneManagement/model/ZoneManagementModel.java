package com.saydept.api.spf.org.zoneManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ZoneManagementModel extends SayEnvModel  {

	private String jum;
	private String bu;
	private String buNm;
	private String tim;
	private String timNm;
	private String pc;
	private String pcNm;
	private String pcCom;
	private String zone;
	private String zoneNm;
	private String zoneCom;

}