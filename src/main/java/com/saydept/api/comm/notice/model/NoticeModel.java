package com.saydept.api.comm.notice.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class NoticeModel extends SayEnvModel{

	
	private String jum;			
	private String bu;       
	private String tim;      

	private String endOrg;		//종료일(실제 종료일)
	private String userId;   
	private List<String> userIds;
	private String userName; 
	private String userPosi;
             
	private String storeLvCd;
	private String storeLvNm;
	private String paramLvCd;

	
	private String noticeDate;	//공지년도
	private String noticeSeq;	//공지순번
	private String title;		//공지제목
	private String desc; 		//공지내용
	private String readYn;  	//읽음여부
}










