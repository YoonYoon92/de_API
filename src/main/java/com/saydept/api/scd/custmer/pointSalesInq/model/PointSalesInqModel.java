package com.saydept.api.scd.custmer.pointSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PointSalesInqModel extends SayEnvModel{

	private String searchDt;
	private String yearP1;
	private String monthP1;
	private String searchPoint;        
	private String searchPoint1;
	private String searchPoint2;
	private String searchPoint3;
	
	private String stsDiv;
	private String pointNm;
	private int pointScore;
	private int lostPoint;
	private String saleDt;           
	private String saleDiv;        
	private String posNum;         
	private String receipt;        
	private String clsNm;          
	private String pointDiv;       
	private int cardSale;       
	private int cardPoint;      
	private int cashSale;       
	private int cashPoint;      
	private int salePoint;      
	private int totPoint;      
	private int netSale;        
	private String saleReturn;     
	private String saleUpate;      

}