package com.saydept.api.spf.goods.partnerManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PartnerManagementModel extends SayEnvModel{
	//협력업체
		private String startDt;			//시간
		private String userId;			//시간
		private String jum;				//점
		private String busiNum;			//사업자번호
		private String busiNm;			//상호명
		private String partner;			//협력업체
		private String owner;			//대표자명
		private String jumin;			//주민
		//insert
		private String jumin1;			//주민
		private String jumin2;			//주민
		
		private String tel;				//전화
		//insert
		private String tel1;				//전화
		private String tel2;				//전화
		private String tel3;				//전화
		
		private String address;			//주소
		private String address1;			//주소
		private String address2;			//주소
		private String addressNm;		//주소명
		private String service;			//업태
		private String serviceSect;		//업종
		private String imprest;			//전도금
		private String payment;			//지불방법
		private String paymentCd;		//지불코드
		private String billDt;			//어음일자
		private String paymentLateCd;	//지불코드
		private String bankDiv;			//예금종류
		private String bankCd;		//은행코드
		private String bankNum;			//계좌번호
		private String bankNm;			//예금주명
		private String paymentCondition;//지급조건
		private String calcdiv;			//끝전처리
		private String openDt;			//입점일자
		private String contractDt;		//계약일자
		private String endCd;			//끝전처리코드
		private String areaDiv;			//지역구분
		private String manageBu;		//관리부서t
		private String tradeStop;		//거래중지
		private String ParterdelDt;		//삭제일자
		private String fax;				//fax
		//insert
		private String fax1;			//fax1
		private String fax2;			//fax2
		private String email;			//이메일
		private String	paymentCon;		//지급조건
		private String	manager;		//지급조건
}