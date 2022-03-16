package com.saydept.api.spf.selng.generalCreditSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class GeneralCreditSalesInqParamModel extends SayEnvModel{

   private String startDt; 	       /*시작일*/
   private String endDt;           /*종료일*/
   private String jum;			   /*점*/
   private String bu;              /*부*/
   private String tim;             /*팀*/
   private String pc;              /*세분류*/
   
   private String saleCls;         /*시제구분*/
   private String combinePay;      /*복합시제유무*/
   
   private String classCd;         /*클래스cd*/
   private String classNm;         /*클래스명*/
   private String orgCd;           /*조직코드(점,부,팀,pc)*/
   
   private String buCd;            /*부cd 포스번호 앞2자리 */
   private String singleItemCd;    /*단품cd*/
   private String singleItemNm;    /*담품명*/
   
}