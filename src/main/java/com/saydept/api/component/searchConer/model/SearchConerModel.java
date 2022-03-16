package com.saydept.api.component.searchConer.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SearchConerModel extends SayEnvModel{
	
	private String jum;					//점
	private String bu;					//부
	private String team;				//팀
	private String pc;					//pc
	private String jumName;				//점명
	private String buName;				//부명
	private String teamName;			//팀명
	private String pcName;				//pc명
	
	private String conerNo;				//클래스번호
	private String conerName;			//클래스명
	
	private String codeCrtDate;			//코드부여일
	private String codeDispDate;	//코드폐기일
	

}