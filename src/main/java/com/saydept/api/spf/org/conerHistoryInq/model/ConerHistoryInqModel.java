package com.saydept.api.spf.org.conerHistoryInq.model;

import lombok.Data;

@Data
public class ConerHistoryInqModel {

	private String dbType;
	private String jum;				//점
	private String bu;              //부
	private String tim;             //팀
	private String pc;              //세분류
	private String gubun;           //조회구분
	private String coner;           //코너
	private String cls;             //클래스
	private String serchLevel;      //검색등급
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
	
	/*조회 결과 그리드 출력 내용*/
	private String newBuNo;			//사용코너 부서번호
	private String newBuNm;			//사용코너 부서명
	private String newTimNm;		//사용코너 팀명
	private String newPcNm;			//사용코너 세분류명
	private String newCorNo;		//사용코너 코너번호
	private String newCorNm;		//사용코너 코너명
	private String newFrDate;		//사용코너 코드부여일
	private String space;           //'|'
	
	private String oldBuNo;         //구 코너 부서번호 
	private String oldBuNm;         //구 코너 부서명  
	private String oldTimNm;        //구 코너 팀명   
	private String oldPcNm;         //구 코너 세분류명 
	private String oldCorNo;        //구 코너 코너번호 
	private String oldCorNm;        //구 코너 코너명  
	private String oldFrDate;       //구 코너 코드부여일
	private String oldToDate;		//구 코너 코드종료일
	private String oldDelDate;		//구 코너 폐기일


}