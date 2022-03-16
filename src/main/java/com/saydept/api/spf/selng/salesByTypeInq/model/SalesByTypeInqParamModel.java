package com.saydept.api.spf.selng.salesByTypeInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SalesByTypeInqParamModel extends SayEnvModel{

   
   private String startDt; 	       /*시작일*/
   private String endDt;           /*종료일*/
   private String jum;			   /*점*/
   private String bu;              /*부*/
   private String tim;             /*팀*/
   private String pc;              /*세분류*/
   
   private String corner;          /*코너*/
   private String key;             /*키*/
   
   private String detailInqOrgCd;  /*세부조회조직코드*/

}