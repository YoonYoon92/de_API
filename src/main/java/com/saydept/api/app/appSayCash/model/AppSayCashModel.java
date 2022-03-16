package com.saydept.api.app.appSayCash.model;

import lombok.Data;

@Data
public class AppSayCashModel {

	private String wheno
;
	private String citizenNo1;
	private String citizenNo2;
	private String frDate;		//시작검색일자
	private int eCash;
	private String now;
	private String saleDate;	//매출날짜
	private String slpNo;		//영수증번호
	private String clsNm;		//클래스명
	private String useCash;		//사용/적립포인트
	private String totCash;		//합계포인트
	private String saleTime;	//결제시간
	private String eventNum;	//행사번호

	
	
	

	
}