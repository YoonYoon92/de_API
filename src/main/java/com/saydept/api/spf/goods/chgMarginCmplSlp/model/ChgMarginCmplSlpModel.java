package com.saydept.api.spf.goods.chgMarginCmplSlp.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ChgMarginCmplSlpModel extends SayEnvModel{

//	private String jum;					//점
//	private String jumNm;				//점명
//	private String bu;                  //부
//	private String buNm;                //부명
//	private String tim;                 //팀
//	private String timNm;               //팀명
//	private String pc;                  //세분류
//	private String pcNm;                //세분류명
//	private String coner;               //코너
//	private String conerNm;             //코너명
	private String clsNo;                 //클래스
	private String clsNm;               //클래스명
	private String chgDate;                //변경일자
	private String eventCode;                //행사코드
	private String eventEndDate;                //행사종료일자
	private String bizCustomNo;                //거래선번호
	private String bizCustomNm;                //거래선명
	
	

	/*실적*/
	private double frMargin;		//변경전마진
	private double toMargin;		//변경후마진

}
