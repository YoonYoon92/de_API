package com.saydept.api.dashboard.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class EventSaleUnitModel extends SayEnvModel{

	private String 	saleDate; // 영업일
	private String 	eventNm; // 행사명
	private Long 	netSale; // 순매출

}
