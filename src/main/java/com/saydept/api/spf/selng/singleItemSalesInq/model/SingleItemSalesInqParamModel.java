package com.saydept.api.spf.selng.singleItemSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SingleItemSalesInqParamModel extends SayEnvModel{

   private String startDt; 	       /*시작일*/
   private String endDt;           /*종료일*/
   
   private String jum;			   /*점*/
   private String bu;              /*부*/
   private String tim;             /*팀*/
   private String pc;              /*세분류*/
   
   private String cornerCd;        /*코너*/
   private String cornerName;      /*코너명*/
   private String classKeyCd;      /*키*/
   private String classKeyCdName;  	/*키명*/
   
   private String partner;         /*거래선CD*/
   private String partnerName;     /*거래선명*/
   
   private String singleItemCd;    /*단품CD*/
   private String singleItemName;  /*단품명*/
   
   private String lcatCd;          /*대분류CD*/
   private String mcatCd;          /*중분류CD*/
   private String scatCd;          /*소분류CD*/
   
   private String lcatName;        /*대분류명*/
   private String mcatName;        /*중분류명*/
   private String scatName;        /*소분류명*/
   
   private String coopCd;          /*협력업체CD*/ 
   private String coopName;        /*협력업체명*/ 

}