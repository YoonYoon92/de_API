package com.saydept.api.spf.org.orgnztInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class OrgnztInqParamModel extends SayEnvModel{

	private String jum;		//점
	private String bu;		//부
	private String tim;		//팀
	private String pc;		//세분류
	private String zone;	//존
	private String storeLvNm; //이름
	private String zoneCd;	//존코드	
	private String zoneNm;	//존명
	

	

}