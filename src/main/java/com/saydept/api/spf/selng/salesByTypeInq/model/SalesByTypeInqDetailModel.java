package com.saydept.api.spf.selng.salesByTypeInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SalesByTypeInqDetailModel extends SayEnvModel{

	/*   입금형태별 매출현황 - 정상(01)   */
	private double cash01;                //현금매출
	private double card01;                //카드매출
	private double norCrdt01;             //일반외상
	private double gift01;                //상품권매출
	private double cod01;                 //cod	
	private double etc01;                 //기타매출
	private double netAmount01;           //순매출액
	private double saleAmount01;          //할인액
	private double totalAmount01;         //총매출액
	private double customCnt01;           //고객수
	/*   입금형태별 매출현황 - 행사(02)   */
	private double cash02;                //현금매출
	private double card02;                //카드매출
	private double norCrdt02;             //일반외상
	private double gift02;                //상품권매출
	private double cod02;                 //cod	
	private double etc02;                 //기타매출
	private double netAmount02;           //순매출액
	private double saleAmount02;          //할인액
	private double totalAmount02;         //총매출액
	private double customCnt02;           //고객수
	/*   입금형태별 매출현황 - 행사(03)   */
	private double cash03;                //현금매출
	private double card03;                //카드매출
	private double norCrdt03;             //일반외상
	private double gift03;                //상품권매출
	private double cod03;                 //cod	
	private double etc03;                 //기타매출
	private double netAmount03;           //순매출액
	private double saleAmount03;          //할인액
	private double totalAmount03;         //총매출액
	private double customCnt03;           //고객수
	/*   입금형태별 매출현황 - 합계       */
	private double cash;                //현금매출
	private double card;                //카드매출
	private double norCrdt;             //일반외상
	private double gift;                //상품권매출
	private double cod;                 //cod	
	private double etc;                 //기타매출
	private double netAmount;           //순매출액
	private double saleAmount;          //할인액
	private double totalAmount;         //총매출액
	private double customCnt;           //고객수


}