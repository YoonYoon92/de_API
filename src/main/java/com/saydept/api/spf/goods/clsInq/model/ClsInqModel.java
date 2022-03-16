package com.saydept.api.spf.goods.clsInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ClsInqModel extends SayEnvModel{

	private String jum;
	private String bu;
	private String tim;
	private String pc;
	private String jumNm;
	private String buNm;
	private String timNm;
	private String pcNm;
	private String orgCode;		//조직코드
	private String coner;		//코너
	private String conerNm;		//코너명
	private String cls;			//클래스
	private String cls1;		//클래스1
	private String cls2;		//클래스2
	private String clsNm;		//클래스명
	private String partner;		//협력업체
	private String partnerNm;	//협력업체명
	private int fee;			//수수료
	private String giveDt;		//부여일
	private String duseDt;		//폐기일
	private String status;		//상태
	
	
	private String code;		//특정코드 
	private String trade;		//거래선
	private String busiNum;		//사업자번호
	private String busiNm;		//사업자명
	private String lossRate;	//재고로스율
	private String marginRate;	//마진율
	private String eventDiv;	//행사구분
	private String tagDiv;		//태그구분
	private String regiDt;		//재고로스율
	private String changeDt;	//마진율
	private String stopDt;		//행사구분
	private String delDt;		//태그구분
	
	//마진변경내역
	private int afterMagin;			//후마진
	private int beforeMargin;		//전마진
	private String endDt;			//종료일
	private String marginChangeDt;	//변경일
	private String eventCode;		//행사코드
	
	//협력업체
	private String owner;			//대표자명
	private String jumin;			//주민
	private String tel;				//전화
	private String address;			//주소
	private String addressNm;		//주소명
	private String service;			//업태
	private String serviceSect;		//업종
	private String imprest;			//전도금
	private String payment;			//지불방법
	private String paymentCode;		//지불코드
	private String billDt;			//어음일자
	private String paymentLateCode;	//지불코드
	private String bankDiv;			//예금종류
	private String bankCode;		//은행코드
	private String bankNum;			//계좌번호
	private String bankNm;			//예금주명
	private String paymentCondition;//지급조건
	private String calcdiv;			//끝전처리
	private String openDt;			//창사기념일
	private String endCode;			//끝전처리코드
	private String areaDiv;			//지역구분
	private String manageBu;		//관리부서t
	private String tradeStop;		//거래중지
	private String ParterdelDt;		//삭제일자
	private String fax;				//fax
	
	
	
	
}