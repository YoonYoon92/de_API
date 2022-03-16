package com.saydept.api.spf.org.jumManagement.model;

import java.util.List;

import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ProgramParameter;
import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class JumManagementSaveModel  extends SayEnvModel{

	private String ms01Mod  	; 	//수정삭제	구분자
	private String ms01Sabun  	; 	//수정삭제 사용자

	private String ms01Jum      ;   //점코드            
	private String ms01JumNm    ;   //점명
	private String ms01Sano     ;   //사업자번호
	private String ms01Dname    ;   //대표자명
	private String ms01Juno1    ;   //주민1
//	private String ms01Juno2    ;   //주민2                
	private String ms01Post1    ;   //우편1
//	private String ms01Post2    ;   //우편2
	private String ms01Phone1   ;   //전화1
//	private String ms01Phone2   ;   //전화2
//	private String ms01Phone3   ;   //전화3

	private String ms01Address  ;   //주소
	private String ms01Crdate   ;   //창립일
	private String ms01Camonth  ;   //결산월
	private String ms01Deldate  ;   //코드폐기일
	private String ms01Adddate  ;   //코드부여일
	private String ms01Uptdate  ;   //코드수정일
	private String ms01Adduser  ;   //입력user
	private String ms01Uptuser  ;   //변경user	
		 
}