package com.saydept.api.spf.selng.singleItemSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SingleItemSalesInqModel extends SayEnvModel{
	
	
	private String jum;                 //점
	private String org;                 //부
	private String buName;              //부명
	private String singleItemCd;        //단품번호
	private String SingleItemName;      //단품명
	
	private double cnt;                 //수량
	private String unit;                //단위
	private double netAmount;           //순매출액
	private double saleAmount;          //할인액
	private double totalAmount;         //총매출액
	
	private String itemCd;              //품목코드
	private String itemName;            //품목명
	private String partnerCd;           //협력업체번호
	private String partnerName;         //협력업체명
	private String classCd;             //클래스코드
	private String className;           //클래스명
	

	
}