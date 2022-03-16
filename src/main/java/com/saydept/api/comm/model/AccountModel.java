package com.saydept.api.comm.model;

import java.util.List;

import lombok.Data;

@Data
public class AccountModel extends SayEnvModel{	
	
	
	private String userId;
	private String userPw;
	private String userIp;
    private String userName;		//사용자명
    private String lateDate;		//최근접속일
    private String latePgm;			//최근접속프로그램
    //private List<ProgModel> latePgms;	//최근접속프로그램
    
    private String jum;
    private String jumName;
    private String bu;
    private String buName;
    private String team;
    private String teamName;
   	
    private String userCode;		//사용자코드
    private String userAuth;		//사용자권한
    

    
    //조직정보 추가(점,부,팀...) 코드, 명칭 [공지사항 조회 등급으로도 사용]
    //직책정보 추가
    //
	
	private String pd1802;
	private String pd1806;
}
