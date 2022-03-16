package com.saydept.api.spf.selng.cardApprLogInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CardApprLogInqParamModel extends SayEnvModel{

	private String jum;                 //점
	
	private String startDate;           //시작일자re
	private String endDate;             //종료종료
	
	private String searchCardNo;        //검색 카드번호
	private String searchRegi;          //검색 Regi번호
	private String searchWCC;           //검색 WCC (A: swipe, I: IC, F: fallback, Z: ic수기입력, @: magnetic수기입력) 
	private String searchCardCoNm;      //검색 카드사명
	private String searchCardCoNmUpper;      //검색 카드사명
	private String searchCardCoNmLower;      //검색 카드사명
	private String searchCardCoNmFullChar;      //검색 카드사명
	private String searchCardCoNmFullCharUpper;      //검색 카드사명
	private String searchCardCoNmFullCharLower;      //검색 카드사명
	
	private String repNo;               //프리픽스마스터 대표번호
	private String cardCoNm;            //프리픽스마스터 카드사명
	

}