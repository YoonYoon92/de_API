package com.saydept.api.spf.org.buManagement.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class BuManagementSaveModel  extends SayEnvModel{

	private String ms02Mod  	; 	//수정삭제	구분자
	private String ms02Sabun  	; 	//수정삭제 사용자

	private String ms02Jum      ;   //점코드            
	private String ms02JumNm    ;   //점명
	private String ms02Bu      ;   //부코드            
	private String ms02BuNm    ;   //부명
	private String ms0205;   //1          COLHDG(' 부서구분 ')   
	private Double ms0206;   //5P         COLHDG(' 직영인원 ')  
	private Double ms0207;   //5P         COLHDG(' 총　평수 ')   
	private Double ms0208;   //5P         COLHDG(' 판촉인원 ')               
	private Double ms0209;   //5P         COLHDG(' 전용면적 ')  
	private Double ms0210;   //5P         COLHDG(' 공유면적 ')   
	private String ms0211;   //16J         COLHDG(' 부서장명 ')  
	private String ms0212;   //8          COLHDG(' 등록 USER-ID')
	private String ms0213;   //8          COLHDG(' 변경 USER-ID')
                       
	private String ms0214;   //8          COLHDG(' 코드폐기일 ') 
	private String ms0215;   //8          COLHDG(' 코드부여일 ') 
	private String ms0216;   //8          COLHDG(' 코드수정일 ') 
}