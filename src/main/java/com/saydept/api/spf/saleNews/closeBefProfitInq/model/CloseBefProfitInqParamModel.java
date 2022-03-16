package com.saydept.api.spf.saleNews.closeBefProfitInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CloseBefProfitInqParamModel extends SayEnvModel{

	/* UI에서 넘어온 파라메터 */
	private String fromDate;
	private String toDate;
	private String jum;
	private String bu;
	private String tim;
	private String pc;
//	private String class1;
//	private String class2;
	private	String saleForm;
	private String onlineForm;
	private String storeLvCd;	/*조직코드*/
	private String storeLvNm;	/*조직명*/
	private String paramLvCd;	/*조직 검색 코드*/

	/* 프로그램내부에서 생성된 파라메터 */	
	private String fromDateL;		/*전년 시작일*/
	private String toDateL;			/*전년 종료일*/
	private String today;			/*오늘 날짜*/
	private String fromYYMMDD;		/*조회 시작일*/
	private String fromYYMMDDL;		/*조회 시작일-전년*/
	private String fromYYMM;		/*조회 시작 년월*/
	private String toYYMM;			/*조회 종료 년월*/
	private String fromYYMML;		/*조회 시작 년월-전년*/
	private String toYYMML;			/*조회 종료 년월-전년*/
}