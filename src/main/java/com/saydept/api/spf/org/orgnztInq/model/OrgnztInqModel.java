package com.saydept.api.spf.org.orgnztInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class OrgnztInqModel extends SayEnvModel{

	private String jum;		//점
	private String bu;		//부
	private String tim;		//팀
	private String pc;		//세분류
	private String zone;	//존
	private String orgCode;	//출력코드번호
	private String nm;		//이름
	private String col1;	//컬럼1
	private String col2;	//컬럼2
	private String col3;	//컬럼3
	private String col4;	//컬럼4
	private String col5;	//컬럼5
	private String col6;	//컬럼6
	private String col7;	//컬럼7

	

}