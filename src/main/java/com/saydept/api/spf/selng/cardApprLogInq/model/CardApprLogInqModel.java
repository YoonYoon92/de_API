package com.saydept.api.spf.selng.cardApprLogInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CardApprLogInqModel extends SayEnvModel{
	
	private String apprDate;             //승인일자
	private String van;                 //승인van사
	private String wcc;                 //승인구분 	 
	private String regi;                //레지번호
	private String receipt;             //영수증번호
	private String replyCd;             //응답코드
	private String msg;                 //응답메시지
	private String repNo;               //대표번호
	private String cardCoNm;            //대표카드사명	
	private String apprCardCo;          //카드사(카드사코드+카드사명)
	private String apprCardCoCd;        //카드사Code(2byte)
	private String apprCardCoNm;        //카드사명
	private String apprMaeipCo;         //매입사(매입사코드+매입사명)
	private String apprMaeipCoCd;       //매입사Code(2byte)
	private String apprMaeipCoNm;       //매입사명
	private String reqc;                //전문구분(0200:승인, 0420:취소)
	private String cardNoNonMask;       //카드번호-nonMask
	private String cardNoMask;          //카드번호-mask
	private String appNo;               //승인번호(8byte)
	private double amt;                 //승인금액
	private String sdateTime;           //승인요청일시(yyyymmddHHMMSS)
	private String rdateTime;           //승인응답일시(yyyymmddHHMMSS)
	private double rSec;                //응답시간(초)
	private String confCardNo;          //확정카드번호(S02)
	private String confirm;             //확정유무

}