package com.saydept.api.spf.selng.salesByTypeInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SalesByTypeInqModel extends SayEnvModel{

	private String orgCd;               //조직코드
	private String orgName;             //조직명
	
    /*   입금형태별 매출현황                       */
	private double cash;                //현금매출
	private double card;                //카드매출
	private double norCrdt;             //일반외상
	private double gift;                //상품권매출
	private double cod;                 //COD
	private double etc;                 //기타매출
	
	/*   판매형태별 매출현황                        */
	private double normal;             //정상매출
	private double event;              //행사매출
	private double uniform;            //균일매출

	/*   합           계                         */
	private double netAmount;           //순매출액
	private double saleAmount;          //할인액
	private double totalAmount;         //총매출액
	/*   고     객     수                        */
	private double customCnt;           //고객수

}