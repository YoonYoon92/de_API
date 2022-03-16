package com.saydept.api.spf.goods.regiMasterSendInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class RegiMasterSendInqModel extends SayEnvModel{

	private String regiNo;				//레지
	private String regiNm;				//레지
	private String code0;				//점
	private String date0;				//
	private String code1;				//부
	private String date1;				//
	private String code2;				//담당자
	private String date2;				//
	private String code3;				//클래스
	private String date3;				//
	private String code4;				//프리셋
	private String date4;				//
	private String code5;				//예약
	private String date5;				//
	private String code6;				//즉시
	private String date6;				//
	private String code7;				//품목
	private String date7;				//
	private String code8;				//명판
	private String date8;				//
	private String code9;				//카드
	private String date9;				//
	
	/*실적*/
//	private String clsNm;               //클래스명
//	private double achivmentrate;		//당년달성율
//	private double incrsrate;			//당년신장율

}
