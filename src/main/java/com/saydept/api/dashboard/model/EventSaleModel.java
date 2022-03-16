package com.saydept.api.dashboard.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class EventSaleModel extends SayEnvModel{

	private String saleDate;		//영업일
	private List<String> eventNm;	//행사명
	private List<Long> netSale;		//순매출
	
}
