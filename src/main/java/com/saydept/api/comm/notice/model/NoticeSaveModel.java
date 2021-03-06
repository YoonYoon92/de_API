package com.saydept.api.comm.notice.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class NoticeSaveModel extends SayEnvModel{

	   //공지내용
	   private String ms81myy;           //공지년도 4
	   private String ms81mid;         	 //공지순번 7	   
	   private String ms81fr;            //공지시작 8
	   private String ms81to;            //공지종료 8
	   private String ms81gubun;         //구분, '' = 정상
	   private String ms81title;         //제목
	   private String ms81msg;           //내용
	   private String ms81wsabun;        //작성자 6
	   private String ms81wdate;         //작성일 14
	   private String ms81fill1;         //예비1
	   private String ms81fill2;         //예비2
	  
	   //공지대상자
	   private List<String> ms82rsabuns;        //공지대상자사번   6
	   private String ms82rsabun;
	   private String ms82rchk;          //확인여부 1
	   private String ms82rdate;         //확인일자14
	   private String ms82fill1;         //예비1
	   private String ms82fill2;         //예비2
}



 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 