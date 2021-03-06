package com.saydept.api.dashboard.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TimeZoneUnitModel extends SayEnvModel{

	private String timeZone;  		 	//시간대
	private long   saleAmount;			//당일 순매출액
	private long   oldWeekSaleAmount;   //전주 동요일 순매축액
	private long   oldYearSaleAmount;   //전년 동요일 순매출액

}
