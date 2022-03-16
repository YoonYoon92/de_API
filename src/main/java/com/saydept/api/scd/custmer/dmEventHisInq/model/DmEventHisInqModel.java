package com.saydept.api.scd.custmer.dmEventHisInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DmEventHisInqModel extends SayEnvModel{

	private String eventStartDt;        //행사시작일자
	private String eventEndDt;          //행사종료일자
	private String orgCd;               //조직코드
	private String corNo;               //코너번호
	private String corNm;               //코너명
	private String eventNo;             //행사번호
	private String eventNm;             //행사명
	private String dmSortation;         //DM구분
	private String sendDt;              //발송일
	private double sendCnt;             //발송건수
	private String eventSts;            //이벤트상태
	private String regiDt;              //등록일
	private String updDt;               //수정일
	
   private String commerDistCd;         /*상권구분*/
   private String commerDistNm;         /*상권명*/
   private String commerDistArNm;       /*지역명*/

}