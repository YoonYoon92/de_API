package com.saydept.api.spf.goods.clsManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ClsManagementModel extends SayEnvModel{

	private String jum;
	private String coner;
	private String conerNm;
	private String key;
	private String cls1;		//클래스1
	private String cls2;		//클래스2
	private String clsNm;		//클래스명
	private String featureCd;	//특정코드
	private String partner;		//협력업체
	private String stockLoss;	//재고로스율
	private String margin;		//마진
	private String eventCd;		//행사코드
	private String tagCd;		//tag코드
	private String crtDt;		//등록일
	private String uptDt;		//수정일
	private String delDt;		//삭제일
	private String stopDt;		//중지일
	private String Expire;		//만기
	private String payment;		//지불
	private String userId;		//유저
	
}