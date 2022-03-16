package com.saydept.api.spf.giftEvent.giftEventInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class GiftEventInqModel extends SayEnvModel{

	private String  jum;
	private	String 	searchDay;
	private String eventYY;          
	private String eventNo;                    
	private String frEventDay; 
	private String toEventDay; 
	private String eventName;                 
	private int saleLevel;                 
	private int eventGift;                 
	private int eventGoods;                
	private int eventEtc;                

}