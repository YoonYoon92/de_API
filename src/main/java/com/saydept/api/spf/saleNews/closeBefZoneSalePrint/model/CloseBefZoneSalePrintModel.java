package com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CloseBefZoneSalePrintModel extends SayEnvModel{

	private String fromSaleDate;        
	private String toSaleDate;    
	
	private String jum; 				
	private String bu;					
	private String tim;					
	private String pc;					
	private String class1;				
	private String class2;						
	private String zoneNo;  
	
	private String jumNm; 				
	private String buNm;					
	private String timNm;					
	private String pcNm;					
	private String class1Nm;					
	private String class2Nm;						
	private String zoneNm;  
	
	private double area;
	                                   
	private double yearNetsale; 		
	private double yearDiscount;		
	private double yearTotalsale;       
	private double yearTry; 			
	private double yearProfitTry;      
	private double yearProfit;		
	private double yearCnt;
	private String sep01;
	                
	private double lastYearNetsale; 	
	private double lastYearDiscount;    
	private double lastYearTotalsale;   
	private double lastYearTry; 		
	private double lastYearProfitTry;   
	private double lastYearProfit;		
	private double lastYearCnt;

}