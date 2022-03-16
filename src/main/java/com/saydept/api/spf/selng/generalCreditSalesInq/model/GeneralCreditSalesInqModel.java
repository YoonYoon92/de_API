package com.saydept.api.spf.selng.generalCreditSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class GeneralCreditSalesInqModel extends SayEnvModel{

	private String classfication;       //구분
	private String saledate;            //판매일자
	private String regi;                //regi번호
	private String receipt;             //영수증번호
	private String slpno;               //전표번호
	private String orgCd;               //조직코드
	private String classNo;             //클래스번호
	private String classNm;             //클래스명
	private String singleItemNo;        //단품번호
	private String singleItemNm;        //단품명
	private double unitPrice;           //단가
	private double quantity;            //수량
	private double netAmount;           //순매출액
	private double saleAmount;          //할인액
	private double totalAmount;         //총매출액
	private double creditAmount;        //일반외상매출액
	private double etcAmount;           //기타결제수단매출액

}