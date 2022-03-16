package com.saydept.api.spf.org.pcManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PcManagementModel extends SayEnvModel {

	private String jum;
	private String bu;
	private String buNm;
	private String tim;
	private String timNm;
	private String pc;
	private String pcNm;
	private String pcCom;

}