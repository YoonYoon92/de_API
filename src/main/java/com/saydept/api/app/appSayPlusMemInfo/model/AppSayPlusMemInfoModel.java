package com.saydept.api.app.appSayPlusMemInfo.model;

import lombok.Data;

@Data
public class AppSayPlusMemInfoModel {

//	private String jum;					//점
	private String citizenNo1;			//주민1
	private String citizenNo2;			//주민2
	private String wheno;				//포인트카드
	private String name;				//성명
	private String hptel;				//휴대폰
	private String joinDate; 			//발급일
	
	private String terminateDate; 		//해지일
	private String cardst;				//카드상태
	private double tpoint;				//포인트누계
	private double lostPoint;			//소멸예정포인트
	private String now;					//현재시간
}
