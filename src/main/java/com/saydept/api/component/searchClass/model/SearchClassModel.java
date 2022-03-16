package com.saydept.api.component.searchClass.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SearchClassModel extends SayEnvModel{
	
	private String jum;					//점
	private String bu;					//부
	private String team;				//팀
	private String pc;					//pc
	private String partner;				//거래선번호
	private String jumName;				//점명
	private String buName;				//부명
	private String teamName;			//팀명
	private String pcName;				//pc명
	private String featureCd;			//특정코드
	
	private String classNo;				//클래스번호
	private String className;			//클래스명
	
	private String codeCrtDate;			//코드부여일
	private String codeDispDate;		//코드폐기일
	private double 	purchaseMargin; 	//매입마진
	

}