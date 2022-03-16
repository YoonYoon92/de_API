package com.saydept.api.scd.custmer.dmEventHisInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DmEventHisInqParamModel extends SayEnvModel{

   private String startDt; 	       /*시작일*/
   private String endDt;           /*종료일*/
   private String jum;			   /*점*/
   private String bu;              /*부*/
   private String tim;             /*팀*/
   private String pc;              /*세분류*/
   
   private String eventStartDt;    /*행사시작일*/
   private String eventEndDt;      /*행사종료일*/
   private String eventNo;         /*행사번호*/
   private String evnetNm;         /*행사명*/
   private String evnetManageCd;   /*행사관리코드*/
   
   private String commerDistCd;     /*상권구분*/

   
      
}