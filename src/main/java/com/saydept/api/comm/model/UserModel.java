package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class UserModel extends SayEnvModel{
	
	private String userId;
	private String userPw;
    private String userName;		//사용자명
    
    private String storeCode;
    private String storeName;
	
    private String userCode;		//사용자코드
    private String userAuth;		//사용자권한
    

    
    //조직정보 추가(점,부,팀...) 코드, 명칭 [공지사항 조회 등급으로도 사용]
    //직책정보 추가
    //
	
	private String pd1802;
	private String pd1806;
}
