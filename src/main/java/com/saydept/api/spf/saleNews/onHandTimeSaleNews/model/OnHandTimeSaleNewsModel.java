package com.saydept.api.spf.saleNews.onHandTimeSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class OnHandTimeSaleNewsModel extends SayEnvModel{

	private String division;              // 구분
	private double cashAmount;            // 현금 시재
	private double cardAmount;            // 카드 시재
	private double giftAmount;            // 상품권 시재
	private double etcAmount;             // 기타 시재
	private double netSaleAmount;         // 순매출액
	private double discountAmount;        // 할인액
	private double totalSaleAmount;       // 총매출액
	private double customCount;	          // 고객수

}