package com.saydept.api.spf.selng.partnerSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PartnerSaleInqModel extends SayEnvModel{
	
	private String startDt;			//시작일
	private String partner;			//협력업체
	private String partnerNm;		//협력업체명
	private String cls;				//클래스
	private String clsNm;			//클래스명
	private String cls1;			//클래스1
	private String cls2;			//클래스2
	
	private String item;			//단품
	private String itemNm;			//단품명
	private String gls;				//품목
	private String glsNm;				//품목
	private String unit;			//단위
	private int qty;				//수량
	private int totSale;			//총매출
	private int netSale;			//순매출
	private int dcnt;				//할인
	private	String org;				//조직코드


}