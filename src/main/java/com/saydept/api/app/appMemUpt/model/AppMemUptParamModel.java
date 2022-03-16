package com.saydept.api.app.appMemUpt.model;

import lombok.Data;

@Data
public class AppMemUptParamModel {
	private String uptDate;			//가입날짜 길이 8
	private String uptTime;			//가입날짜 길이 8
	private String citizenNo1;		//주민1
	private String citizenNo2;		//주민2
	private String postAddr;		//우편번호 길이 5
	private String allAddr;			//전체주소 
	private String addr1;			//시도      길이 19
	private String addr2;			//시군구    길이 19
	private String addr3;			//읍면      길이 19
	private String addr4;			//도로명    길이 29
	private String addr5;			//건물본번호 길이 25
	private String addr6;			//건물부번호
	private String addr7;			//상세주소
	private String addr8;			//지하,산
	private String addrCode;		//도로명주소코드
	private String buildCode;		//건물주소코드
	private String hptel;			//기존휴대폰
	private String uptHptel;		//변경휴대폰
	private String id;				//변경휴대폰
	private String fill;			//여유필드
	private String extCarnum;		//기존카드번호
	
	//가공후
//	private String juminserial;			//주민생성번호저장
//	private String jumin1;				//이름      길이 5글자
//	private String jumin2;				//이름      길이 5글자
}