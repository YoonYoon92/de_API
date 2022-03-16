package com.saydept.api.app.appSaySignUp.model;

import lombok.Data;

@Data
public class AppSaySignUpParamModel {

	private String joinDate;			//가입날짜 길이 8
	private String joinTime;			//가입날짜 길이 8
	private String name;				//이름      길이 5글자
	private String birthday;			//생년월일 길이 8
	private String gender;				//성별      길이 1
	private String postAddr;			//우편번호 길이 5
	private String allAddr;				//전체주소 
	private String addr1;				//시도      길이 19
	private String addr2;				//시군구    길이 19
	private String addr3;				//읍면      길이 19
	private String addr4;				//도로명    길이 29
	private String addr5;				//건물본번호 길이 25
	private String addr6;				//건물부번호
	private String addr7;				//상세주소
	private String addr8;				//지하,산
	private String addrCode;			//도로명주소코드
	private String buildCode;			//건물주소코드
	private String hptel;				//휴대폰
	private String id;					//아이디           //20220206 추가
	private String selCard;				//카드선택
	private String ip;					//ip
	private String creditAgree;			//신용동의
	private String smsAgree;			//sms동의
	private String DmAgree;				//dm동의
	private String fill;				//여유필드
	private String extCarnum;			//기존카드번호
	
	
	//가공후
//	private String juminserial;			//주민생성번호저장
//	private String jumin1;				//이름      길이 5글자
//	private String jumin2;				//이름      길이 5글자
}