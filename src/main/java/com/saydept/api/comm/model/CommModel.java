package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class CommModel extends SayEnvModel{
	
	/**
	 * 공통코드
	 */
	
	private String groupCd;		//그룹코드
	private String codeId;		//공통코드
	private String groupNm;		//그룹명
	private String codeNm;		//코드명
	
	/**
	 * 점포목록
	 */
	private String storeCd;
	private String storeNm;
	
	/**
	 * POS목록
	 */
	private String posNo;
	
	/**
	 * 조직
	 */
	private String jum;
	private String storeLvCd;	//조직코드
	private String storeLvNm;	//조직명
	private String paramLvCd;	//조직 검색 코드
	
//	private String storeLv2Cd;	//조직코드(부) 
//	private String storeLv2Nm;  //조직명(부)  
//	
//	private String storeLv3Cd;	//조직코드(팀) 
//	private String storeLv3Nm;  //조직명(팀)  
//	
//	private String storeLv4Cd;	//조직코드(PC) 
//	private String storeLv4Nm;  //조직명(PC)  
//	
//	private String storeLv5Cd;	//조직코드(코너) 
//	private String storeLv5Nm;  //조직명(코너)  
//	
//	private String storeLv6Cd;	//조직코드(class) 
//	private String storeLv6Nm;  //조직명(class)  
	

}